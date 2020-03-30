package service;

import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;

import java.util.List;

public interface OrderItemService {

    public void fill(List<Order> orders);
    public void fill(Order order);
    public List<OrderItem> list();
    public List<OrderItem> listByUser(User user);
    public List<OrderItem> listByOrder(Order order);
    public OrderItem get(int id);
    public void add(int pid,int uid,int num);
    public void delete(OrderItem OrderItem);
    public void update(OrderItem OrderItem);
}
