package com.bsdim.tlj.repository.users;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.FileRepository;

import java.util.List;

public class UserRepository extends FileRepository<User> {
    public UserRepository() {
        super("users.dat");
    }

    public void delete(String dataId) {
        List<User> data = readData();
        for (int i = 0; i < data.size(); i++) {
            User userId = data.get(i);
            if (dataId.equals(userId.getId())) {
                data.remove(i);
                break;
            }
        }
        writeData(data);
    }

    public User findByLogin(String login) {
        List<User> data = readData();
        for (User user: data) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User findById(String id) {
        List<User> data = readData();
        for (User user: data) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}