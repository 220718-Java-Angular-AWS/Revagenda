package com.revature.daos;

import com.revature.exceptions.AccessDeniedException;
import com.revature.pojos.User;
import com.revature.services.DatasourceService;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements DatasourceCRUD<User>{

    Connection connection;

    public UserDAO() {
        this.connection = DatasourceService.getConnection();
    }


    @Override
    public void create(User user) {
        try {
            String sql = "INSERT INTO users (user_name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                Integer key = keys.getInt("user_id");
                user.setUserId(key);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(int id) {
        User user = new User();
        try {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();


            if(results.next()) {
                user.setUserId(results.getInt("user_id"));
                user.setUsername(results.getString("user_name"));
                user.setEmail(results.getString("email"));
                user.setPassword(results.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> readAll() {
        List<User> userList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();



            while(results.next()) {
                User user = new User();
                user.setUserId(results.getInt("user_id"));
                user.setUsername(results.getString("user_name"));
                user.setEmail(results.getString("email"));
                user.setPassword(results.getString("password"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void update(User user) {

        try {
            String sql = "UPDATE users SET user_name = ?, email = ?, password = ?, WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getUserId());
            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public User authenticate(String username, String password) {
        User user = new User();

        try {
            String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                user.setUserId(results.getInt("user_id"));
                user.setUsername(results.getString("user_name"));
                user.setEmail(results.getString("email"));
                user.setPassword(results.getString("password"));

            } else {
                throw new AccessDeniedException("Access denied!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }
}
