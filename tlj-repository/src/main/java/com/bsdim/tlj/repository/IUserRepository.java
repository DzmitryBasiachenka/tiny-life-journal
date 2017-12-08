package com.bsdim.tlj.repository;

import java.util.List;

import com.bsdim.tlj.domain.user.User;

/**
 * The user repository.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public interface IUserRepository extends ICrud<String, User> {
    /**
     * Gets users.
     *
     * @return the list of users.
     */
    List<User> getUsers();

    /**
     * Finds user by login.
     *
     * @param login the login.
     * @return the user.
     */
    User findByLogin(String login);
}
