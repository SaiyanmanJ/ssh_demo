package service.impl;

import com.opensymphony.xwork2.ActionContext;
import dao.OrderItemDAO;
import dao.UserDAO;
import dao.OrderDAO;
import dao.impl.UserDAOImpl;
import pojo.OrderItem;
import pojo.User;
import pojo.Order;
import service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    private UserDAO userDAO;

    private OrderItemDAO orderItemDAO;

    User user;

    @Override
    public List<Order> list() {
        return orderDAO.list();
    }

    @Override
    public List<Order> listByUser(User user) {
        return orderDAO.listByUser(userDAO.get(user.getId()));
    }

    @Override
    public Order get(int id) {
        return orderDAO.get(id);
    }

    @Override
    public void add(Order order) {
        orderDAO.add(order);
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

    @Override
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Override
    public float createOrder(List<OrderItem> ois,User user) {
        String nowTime = String.valueOf(System.currentTimeMillis());
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + nowTime.substring(nowTime.length()-4);

        Order order = new Order();
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setUser(user);
        order.setStatus(OrderService.waitPay);

        float total = 0;
        orderDAO.add(order);
        for (OrderItem oi:ois) {
            oi.setOrder(order);
            orderItemDAO.update(oi);
            total += oi.getProduct().getPrice()*oi.getNumber();
        }
        return total;
    }

    @Override
    public List<Order> searchByKeyword(String keyword) {
        //"%xxx%" 表示匹配包含xxx的所有字符串，该字符串xxx前后都可以由字符，不加%表示只匹配xxx
        return orderDAO.listByKeyword("%"+keyword+"%");
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public OrderItemDAO getOrderItemDAO() {
        return orderItemDAO;
    }

    public void setOrderItemDAO(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
