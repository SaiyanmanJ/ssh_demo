package service;

import pojo.Order;
import pojo.User;

import java.util.List;

public interface OrderService {
    public List<Order> list();
    public List<Order> listByUser(User user);
    public Order get(int id);
    public void add(Order Order);
    public void delete(Order Order);
    public void update(Order Order);

    public List<Order> searchByKeyword(String keyword);

    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";
}
