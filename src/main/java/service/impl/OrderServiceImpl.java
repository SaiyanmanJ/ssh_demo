package service.impl;

import dao.UserDAO;
import dao.OrderDAO;
import dao.impl.UserDAOImpl;
import pojo.User;
import pojo.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO OrderDAO;

    private UserDAO UserDAO;

    public UserDAO getUserDAO() {
        return UserDAO;
    }

    public void setUserDAO(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    @Override
    public List<Order> list() {
        return OrderDAO.list();
    }

    @Override
    public List<Order> listByUser(User User) {
        return OrderDAO.listByUser(UserDAO.get(User.getId()));
    }

    @Override
    public Order get(int id) {
        return OrderDAO.get(id);
    }

    @Override
    public void add(Order Order) {
        OrderDAO.add(Order);
    }

    @Override
    public void delete(Order Order) {
        OrderDAO.delete(Order);
    }

    @Override
    public void update(Order Order) {
        OrderDAO.update(Order);
    }

    @Override
    public List<Order> searchByKeyword(String keyword) {
        //"%xxx%" 表示匹配包含xxx的所有字符串，该字符串xxx前后都可以由字符，不加%表示只匹配xxx
        return OrderDAO.listByKeyword("%"+keyword+"%");
    }

    public OrderDAO getOrderDAO() {
        return OrderDAO;
    }

    public void setOrderDAO(OrderDAO OrderDAO) {
        this.OrderDAO = OrderDAO;
    }

    public void setUserDAO(UserDAOImpl UserDAO) {
    }
}
