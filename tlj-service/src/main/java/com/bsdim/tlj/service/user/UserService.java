package com.bsdim.tlj.service.user;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.IUserRepository;
import com.bsdim.tlj.repository.sql.UserRepositorySql;

import java.util.List;

public class UserService {
    private IUserRepository repository = new UserRepositorySql();

    public void addUser(User user){
        repository.create(user);
    }

    public User findById(String id) {
        return repository.read(id);
    }

    public void updateUser(User user) {
        repository.update(user);
    }

    public void deleteUser(String id) {
        repository.delete(id);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
