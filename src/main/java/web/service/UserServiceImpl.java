package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User newUser) {
        userDao.update(newUser);
    }

    @Override
    public User getUserByID(int id) {
        return userDao.getUserBtID(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
