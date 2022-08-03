package com.revature.pojos;

import java.util.Objects;

public class Task {
    private Integer taskId;
    private String title;
    private String message;
    private Integer userId;
    private Boolean completed;

    public Task() {
    }

    public Task(Integer taskId, String title, String message, Integer userId, Boolean completed) {
        this.taskId = taskId;
        this.title = title;
        this.message = message;
        this.userId = userId;
        this.completed = completed;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) && Objects.equals(title, task.title) && Objects.equals(message, task.message) && Objects.equals(userId, task.userId) && Objects.equals(completed, task.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, title, message, userId, completed);
    }
}
