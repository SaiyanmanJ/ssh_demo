package service;

import pojo.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public User getById(int id);
    public User getByName(String name);
    public boolean isExist(String name);
    public boolean userIsExist(User user);
    public void add(User user);
    public void delete(User user);
    public void update(User user);
}
