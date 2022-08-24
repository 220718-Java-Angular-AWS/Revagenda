package com.revature.repositories;

import com.revature.entities.User;
import com.revature.services.ServiceLocator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

public class UserRepo {
    private Session session;
    private static UserRepo userRepo;

    public static UserRepo getUserRepo() {
        if(userRepo == null) {
            userRepo = new UserRepo();
        }
        return userRepo;
    }

    private UserRepo() {
        SessionFactory factory = ServiceLocator.getSessionFactory();
        if(factory.isClosed()) {
            session = factory.openSession();
        } else {
            session = factory.getCurrentSession();
        }
    }


    public List<User> getAllUsers() {
        //Native queries are just like JDBC queries, following the same basic workflow of:
        //wite the SQL, parameterize it (if necessary), execute it, and marshall the results.
        Query query = session.createNativeQuery("SELECT user_id, username, email, password FROM users");
        List<Object[]> resultsList = query.getResultList();
        List<User> userList = new LinkedList<>();
        for(Object[] row : resultsList){
            User user = new User();
            user.setUserId(Integer.parseInt(row[0].toString()));
            user.setUsername(row[1].toString());
            user.setEmail(row[2].toString());
            user.setPassword(row[3].toString());
            userList.add(user);

        }
        return userList;
    }

    public User getUserByUsername(String username) {
        //this will be a native query - using the built-in mapper so we don;t have to marshall results
        TypedQuery<User> query = session.createNativeQuery("SELECT * FROM users WHERE username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();

    }

    public User getUserById(int id) {
        //use the built-in session.get() method
        return session.get(User.class, id);
    }






}
