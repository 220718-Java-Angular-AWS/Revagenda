package com.revature.daos;

import com.revature.entities.Task;
import com.revature.services.DatasourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaskDAO implements DatasourceCRUD<Task>{
    Connection connection;

    public TaskDAO() {
        connection = DatasourceService.getConnection();
    }

    @Override
    public void create(Task task) {
        try {
            String sql = "INSERT INTO tasks (title, message, user_id, completed) VALUES (?, ?, ?, false)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getMessage());
            pstmt.setInt(3, task.getUser().getUserId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task read(int id) {
        Task task = new Task();
        try {
            String sql = "SELECT * FROM tasks WHERE task_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();


            if(results.next()) {
                task.setTaskId(results.getInt("task_id"));
                task.setTitle(results.getString("title"));
                task.setMessage(results.getString("message"));
                task.getUser().setUserId(results.getInt("user_id"));
                task.setCompleted(results.getBoolean("completed"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return task;
    }

    @Override
    public List<Task> readAll() {
        List<Task> taskList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM tasks";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet results = pstmt.executeQuery();

            while(results.next()) {
                Task task = new Task();
                task.setTaskId(results.getInt("task_id"));
                task.setTitle(results.getString("title"));
                task.setMessage(results.getString("message"));
                task.getUser().setUserId(results.getInt("user_id"));
                task.setCompleted(results.getBoolean("completed"));
                taskList.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    @Override
    public void update(Task task) {
        try {
            String sql = "UPDATE tasks SET title = ?, message = ?, user_id = ?, completed = ? WHERE task_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getMessage());
            pstmt.setInt(3, task.getUser().getUserId());
            pstmt.setBoolean(4, task.getCompleted());
            pstmt.setInt(5, task.getTaskId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM tasks WHERE task_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
