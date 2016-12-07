package com.bsdim.tlj.admin;

import com.bsdim.tlj.domain.user.User;

public class UserRepository extends FileRepository<User> {
    public UserRepository(){
        super("users.dat");
    }
}