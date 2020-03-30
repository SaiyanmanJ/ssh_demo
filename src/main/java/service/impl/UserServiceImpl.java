package service.impl;

import dao.UserDAO;
import org.hibernate.cfg.Settings;
import pojo.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    public User getById(int id) {
        return userDAO.get(id);
    }

    @Override
    public User getByName(String name) {
        return userDAO.getByName(name).get(0);
    }

    @Override
    public boolean isExist(String name) {
        return !userDAO.getByName(name).isEmpty();
    }

    @Override
    public boolean userIsExist(User user) {
        if(user.getPassword().equals(userDAO.getByName(user.getName()).get(0).getPassword()))
            return true;
        else
            return false;
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
