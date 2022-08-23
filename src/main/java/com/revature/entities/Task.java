package com.revature.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column
    private String title;

    @Column
    private String message;

    @Column
    private Boolean completed;

    //foreign key stuff...
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(Integer taskId, String title, String message, Boolean completed, User user) {
        this.taskId = taskId;
        this.title = title;
        this.message = message;
        this.completed = completed;
        this.user = user;
    }

    public Task(String title, String message, Boolean completed, User user) {
        this.title = title;
        this.message = message;
        this.completed = completed;
        this.user = user;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) && Objects.equals(title, task.title) && Objects.equals(message, task.message) && Objects.equals(completed, task.completed) && Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, title, message, completed, user);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
