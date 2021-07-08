package com.github.sithumonline.controller;

import com.github.sithumonline.db.DBConnection;
import com.github.sithumonline.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SQLViewerController {
    public static int addUser(User users) throws SQLException {
        String sql = "INSERT INTO users (username, password, fullname, email) VALUES ('" + users.getUsername() + "','" + users.getPassword() + "','" + users.getFullname() + "','" + users.getEmail() + "')";
        DBConnection conn = DBConnection.getDBConnection();
        Connection stm = conn.getConnection();
        PreparedStatement runSql = stm.prepareStatement(sql);
        return runSql.executeUpdate();
    }

    public static int deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM users WHERE username='" + username + "'";
        DBConnection conn = DBConnection.getDBConnection();
        Connection stm = conn.getConnection();
        PreparedStatement runSql = stm.prepareStatement(sql);
        return runSql.executeUpdate();
    }

    public static int updateUser(User users) throws SQLException {
        String sql = "UPDATE users SET username='" + users.getUsername() + "', password='" + users.getPassword() + "', fullname='" + users.getFullname() + "', email='" + users.getEmail() + "' WHERE username='" + users.getUsername() + "'";
        DBConnection conn = DBConnection.getDBConnection();
        Connection stm = conn.getConnection();
        PreparedStatement runSql = stm.prepareStatement(sql);
        return runSql.executeUpdate();
    }

    public static ObservableList<User> getUserList() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM users";
        Statement st;
        ResultSet rs;

        try {
            st = DBConnection.getDBConnection().getCreateStatement();
            rs = st.executeQuery(sql);
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("email"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}
