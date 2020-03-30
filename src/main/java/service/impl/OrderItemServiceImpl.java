package service.impl;

import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import dao.UserDAO;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;
import service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    OrderItemDAO orderItemDAO;
    ProductDAO productDAO;
    UserDAO userDAO;
    OrderDAO orderDAO;
    List<OrderItem> orderItems;

    @Override
    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    @Override
    public void fill(Order order) {
        orderItems=orderItemDAO.listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for(OrderItem orderItem : orderItems){
            total += orderItem.getNumber()*orderItem.getProduct().getPrice();
            totalNumber += orderItem.getNumber();
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    @Override
    public List<OrderItem> list() {
        return orderItemDAO.list();
    }

    @Override
    public List<OrderItem> listByUser(User user) {
        return orderItemDAO.listByUser(user);
    }

    @Override
    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.listByOrder(orderDAO.get(order.getId()));
    }

    @Override
    public OrderItem get(int id) {
        return orderItemDAO.get(id);
    }

    @Override
    public void add(int pid,int uid,int num) {
        User user = userDAO.get(uid);
        //判断该用户未创建订单的订单项/中的产品/和这次产品是否相同
        boolean haveSeamProduct=false;
        List<OrderItem> orderItems = orderItemDAO.listByUser(user);
        if(!orderItems.isEmpty()){
            for(OrderItem oi:orderItems){
                if(oi.getProduct().getId()==pid){
                    oi.setNumber(oi.getNumber()+num);
                    orderItemDAO.update(oi);
                    haveSeamProduct=true;
                    break;
                }
            }
        }
        if(!haveSeamProduct){
            Product product = productDAO.get(pid);
            OrderItem orderItem = new OrderItem();
            orderItem.setUser(user);
            orderItem.setProduct(product);
            orderItem.setNumber(num);
            orderItemDAO.add(orderItem);
        }

    }
    @Override
    public void delete(OrderItem orderItem) {
        orderItemDAO.delete(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemDAO.update(orderItem);
    }

    public OrderItemDAO getOrderItemDAO() {
        return orderItemDAO;
    }

    public void setOrderItemDAO(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

}
