package com.bsdim.tlj.service.user;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.users.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = new UserRepository();

    public void addUser(User user){
        repository.create(user);
    }

    public List<User> getUsers() {
        return repository.readData();
    }

    public void deleteUser(String id) {
        repository.delete(id);
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public User findById(String id) {
        return repository.read(id);
    }

}