package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void delete(int id);
    void update(User user);
    User getUserBtID(int id);
    List<User> listUsers();
}
