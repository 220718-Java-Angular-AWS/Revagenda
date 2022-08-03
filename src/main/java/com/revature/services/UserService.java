package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.pojos.User;

import java.util.List;

public class UserService {
    private UserDAO dao;

    public UserService() {
        this.dao = new UserDAO();
    }

    public void saveUser(User user) {
        dao.create(user);
    }

    public User getUser(int id) {
        return dao.read(id);
    }

    public List<User> getAllUsers() {
        return dao.readAll();
    }

    public void updateUser(User user) {
        dao.update(user);
    }

    public void deleteUser(int id) {
        dao.delete(id);
    }
}
