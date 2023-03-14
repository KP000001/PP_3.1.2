package web.dao;

import web.model.User;
import java.util.List;

public interface UserDAO {
    void update(int id, User user);
    List<User> findAll();
    void saveUser(User user);
    void deleteUser(int id);
    User findById(int id);
}
