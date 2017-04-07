package com.bsdim.tlj.repository;

import com.bsdim.tlj.domain.user.User;

import java.util.List;

public interface IUserRepository extends ICrud<String, User> {
    List<User> getUsers();
    User findByLogin(String login);
}
