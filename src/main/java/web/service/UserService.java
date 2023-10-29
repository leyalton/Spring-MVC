package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void delete(int id);
    void update(User user);
    User getUserByID(int id);
    List<User> listUsers();
}