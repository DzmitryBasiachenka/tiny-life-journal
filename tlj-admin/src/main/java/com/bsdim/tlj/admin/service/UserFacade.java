package com.bsdim.tlj.admin.service;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.users.UserRepository;

import java.util.List;

public class UserFacade {
    private UserRepository repository = new UserRepository();

    public void addUser(User user) {
        List<User> users = getUsers();
        users.add(user);
        repository.writeData(users);
    }

    public List<User> getUsers() {
        return repository.readData();
    }

    public void deleteUser(String id) {
        repository.delete(id);
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }

    public User findById(String id) {
        return repository.findById(id);
    }
}