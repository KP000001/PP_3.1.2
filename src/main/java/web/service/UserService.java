package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void update(int id, User user);

    List<User> findAll();

    void saveUser(User user);

    void deleteUser(int id);

    User findOne(int id);

}
