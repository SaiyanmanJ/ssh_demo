package dao;

import pojo.Order;
import pojo.User;

import java.util.List;

public interface OrderDAO {
    public List<Order> list();
    public List<Order> listByUserWithoutDelete(User user);
    public Order get(int id);
    public void add(Order order);
    public void delete(Order order);
    public void update(Order order);

    public List<Order> listByKeyword(String keyword);
}
