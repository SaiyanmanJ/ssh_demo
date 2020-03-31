package service.impl;

import dao.OrderItemDAO;
import dao.UserDAO;
import dao.OrderDAO;
import dao.impl.UserDAOImpl;
import pojo.OrderItem;
import pojo.User;
import pojo.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    private UserDAO userDAO;

    private OrderItemDAO orderItemDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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
    public List<Order> searchByKeyword(String keyword) {
        //"%xxx%" 表示匹配包含xxx的所有字符串，该字符串xxx前后都可以由字符，不加%表示只匹配xxx
        return orderDAO.listByKeyword("%"+keyword+"%");
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO OrderDAO) {
        this.orderDAO = OrderDAO;
    }

    public void setUserDAO(UserDAOImpl UserDAO) {
    }

    public OrderItemDAO getOrderItemDAO() {
        return orderItemDAO;
    }

    public void setOrderItemDAO(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }
}
