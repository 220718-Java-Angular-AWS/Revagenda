package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Task;
import com.revature.pojos.User;
import com.revature.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class TaskServlet extends HttpServlet {
    private TaskService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Task servlet initializing...");
        this.service = new TaskService();
        this.mapper = new ObjectMapper();
        System.out.println("Task servlet initialized!");
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.parseInt(req.getParameter("user-id"));

        List<Task> taskList = service.getTasksForUser(userId);

        String json = mapper.writeValueAsString(taskList);

        resp.getWriter().print(json);
        resp.setStatus(200);
        resp.setContentType("Application/Json");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();

        while(buffer.ready()) {
            builder.append(buffer.readLine());
        }

        String json = builder.toString();
        Task task = mapper.readValue(json, Task.class);

        service.saveTask(task);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
