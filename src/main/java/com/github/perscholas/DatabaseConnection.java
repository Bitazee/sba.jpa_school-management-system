package com.github.perscholas;

import com.github.perscholas.utils.ConnectionBuilder;
import com.github.perscholas.utils.IOConsole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leon on 2/18/2020.
 */
public enum DatabaseConnection implements DatabaseConnectionInterface {
    MANAGEMENT_SYSTEM,
    UAT;

    private static final IOConsole console = new IOConsole(IOConsole.AnsiColor.CYAN);
    private final ConnectionBuilder connectionBuilder;

    DatabaseConnection(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    DatabaseConnection() {
        this(new ConnectionBuilder()
                .setUser("root")
                .setPassword("password")
                .setPort(3306)
                .setDatabaseVendor("mysql")
                .setHost("127.0.0.1")
                .setDatabaseName("schoolSystem"));
    }

    @Override
    public String getDatabaseName() {
        return name().toLowerCase();
    }

    @Override
    public Connection getDatabaseConnection() {
        return connectionBuilder
                .setDatabaseName(getDatabaseName())
                .build();
    }

    @Override
    public Connection getDatabaseEngineConnection() {
        return connectionBuilder.build();
    }

    @Override
    public void create() {
        String createStatement = "Create DATABASE IF NOT EXISITS schoolSystem;";
        String message;
        try {
            getDatabaseEngineConnection()
                    .prepareStatement(createStatement)
                    .execute();
            message = "Successfully executed statement `%s`.";
        } catch (Exception sqlException) {
            message = "Failed to executed statement `%s`.";
        }
        console.println(message, createStatement);
    }


    @Override
    public void drop() {
        String dropStatement = "Drop DATABASE IF NOT EXISITS schoolSystem;";
        String message;
        try {
            getDatabaseEngineConnection()
                    .prepareStatement(dropStatement)
                    .execute();
            message = "Successfully executed statement `%s`.";
        } catch (Exception sqlException) {
            message = "Failed to executed statement `%s`.";
        }
        console.println(message, dropStatement);
    }

    @Override
    public void use() {
        String useStatement = "USE DATABASE IF NOT EXISITS schoolSystem;";
        String message;
        try {
            getDatabaseEngineConnection()
                    .prepareStatement(useStatement)
                    .execute();
            message = "Successfully executed statement `%s`.";
        } catch (Exception sqlException) {
            message = "Failed to executed statement `%s`.";
        }
        console.println(message, useStatement);
    }

    public Statement getScrollableStatement() {
        int resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
        try {
            return getDatabaseConnection().createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    @Override
    public void executeStatement(String sqlStatement) {
        String message;
        try{
            getScrollableStatement().executeQuery(sqlStatement);
            message = "statement done";
            console.print(message, sqlStatement);

        }
        catch(SQLException e){
            message = "statement failed";
            throw new Error(message, e);
        }
    }

    @Override
    public ResultSet executeQuery(String sqlQuery) {
        String message;
        try{
           ResultSet resultSet = getScrollableStatement().executeQuery(sqlQuery);
           message = "Query done";
           console.print(message, sqlQuery);
           return resultSet;
        }
        catch(SQLException e){
            message = "Query failed";
            throw new Error(message, e);
        }
    }
}