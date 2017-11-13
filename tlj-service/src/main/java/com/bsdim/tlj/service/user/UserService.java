package com.bsdim.tlj.service.user;

import java.util.List;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.IUserRepository;
import com.bsdim.tlj.repository.sql.UserRepositorySql;

/**
 * The user service.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserService {
    private IUserRepository repository = new UserRepositorySql();

    /**
     * Adds user.
     *
     * @param user the user.
     */
    public void addUser(User user) {
        repository.create(user);
    }

    /**
     * Finds user by id.
     *
     * @param id the id.
     * @return the user.
     */
    public User findById(String id) {
        return repository.read(id);
    }

    /**
     * Updates user.
     *
     * @param user the user.
     */
    public void updateUser(User user) {
        repository.update(user);
    }

    /**
     * Deletes user.
     *
     * @param id the user.
     */
    public void deleteUser(String id) {
        repository.delete(id);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    /**
     * Finds user by login.
     *
     * @param login the login.
     * @return the user.
     */
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
