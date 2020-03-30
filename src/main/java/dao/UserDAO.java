package dao;

import pojo.User;

import java.util.List;

public interface UserDAO {
    public List<User> list();
    public User get(int id);
    public List<User> getByName(String name);
    public void add(User user);
    public void delete(User user);
    public void update(User user);
}
