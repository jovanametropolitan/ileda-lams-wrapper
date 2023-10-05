package com.metropolitan.iledalamswrapper.lams.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LamsConnection {

    private Connection conn = null;
    private Statement stmt = null;
    private String ip_address;
    private String user;
    private String password;

    public LamsConnection() {
    }

    public LamsConnection(String ip_address, String user, String password) {
        this.ip_address = ip_address;
        this.user = user;
        this.password = password;
        openConnection(ip_address, user, password);
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public boolean openConnection(String ip_address, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + ip_address + "/lams?useUnicode=true&characterEncoding=UTF-8", user, password);

            if (!this.conn.isClosed()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
            return false;
        }
        try {
            this.stmt = this.conn.createStatement();
            if (this.stmt != null || !this.stmt.isClosed()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean closeConnection() {
        try {
            if (this.stmt != null) {
                stmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
