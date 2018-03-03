package com.tzak.neptun.common;

import com.tzak.neptun.NeptunApplication;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {


    public static void createNewDatabase(String dbFilePath, String dbFileName) {

        String url = "jdbc:sqlite:"+ NeptunApplication.APPLICATION_PATH + dbFilePath + dbFileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                //TODO zrobić loggera
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
