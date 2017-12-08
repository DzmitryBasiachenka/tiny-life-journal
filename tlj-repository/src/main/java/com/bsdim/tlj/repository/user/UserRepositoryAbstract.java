package com.bsdim.tlj.repository.user;

import java.util.List;

import com.bsdim.tlj.domain.user.User;
import com.bsdim.tlj.repository.ICrud;
import com.bsdim.tlj.repository.file.AbstractFileRepository;

/**
 * The user repository abstract.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class UserRepositoryAbstract extends AbstractFileRepository<User> implements ICrud<String, User> {
    /**
     * The constructor.
     */
    public UserRepositoryAbstract() {
        super("users.dat");
    }

    @Override
    public void create(User user) {
        List<User> users = readData();
        users.add(user);
        writeData(users);
    }

    @Override
    public User read(String id) {
        List<User> data = readData();
        for (User user: data) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void update(User user) {
        List<User> data = readData();
        for (int i = 0; i < data.size(); i++) {
            User userId = data.get(i);
            if (userId.getId().equals(user.getId())) {
                data.set(i, user);
                break;
            }
        }
        writeData(data);
    }

    @Override
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

    /**
     * Finds user by login.
     *
     * @param login the login.
     * @return the user.
     */
    public User findByLogin(String login) {
        List<User> data = readData();
        for (User user: data) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
