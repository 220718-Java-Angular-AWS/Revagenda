package com.revature.services;

import org.hibernate.SessionFactory;

public class ServiceLocator {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }
}
