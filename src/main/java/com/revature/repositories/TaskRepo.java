package com.revature.repositories;


import com.revature.services.ServiceLocator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TaskRepo {
    private Session session;
    private static TaskRepo taskRepo;

    public static TaskRepo getTaskRepo() {
        if(taskRepo == null) {
            taskRepo = new TaskRepo();
        }
        return taskRepo;
    }

    private TaskRepo() {
        SessionFactory factory = ServiceLocator.getSessionFactory();
        if(factory.isClosed()) {
            session = factory.openSession();
        } else {
            session = factory.getCurrentSession();
        }
    }
}
