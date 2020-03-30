package dao;

import pojo.Order;
import pojo.OrderItem;
import pojo.User;

import java.util.List;

public interface OrderItemDAO {
    public List<OrderItem> list();
    public List<OrderItem> listByUser(User user);
    public List<OrderItem> listByOrder(Order order);
    public OrderItem get(int id);
    public void add(OrderItem orderItem);
    public void delete(OrderItem orderItem);
    public void update(OrderItem orderItem);

}
