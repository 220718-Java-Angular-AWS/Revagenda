package com.revature.services;

import com.revature.daos.TaskDAO;
import com.revature.pojos.Task;

import java.util.List;

public class TaskService {
    private TaskDAO dao;

    public TaskService() {
        this.dao = new TaskDAO();
    }

    public void saveTask(Task task) {
        dao.create(task);
    }

    public Task getTask(int id) {
        return dao.read(id);
    }

    public List<Task> getAllTasks() {
        return dao.readAll();
    }

    public void updateTask(Task task) {
        dao.update(task);
    }

    public void deleteTask(int id) {
        dao.delete(id);
    }
}
