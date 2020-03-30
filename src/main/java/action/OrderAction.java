package action;

import dao.impl.OrderItemDAOImpl;
import org.aspectj.weaver.ast.Or;
import pojo.Order;
import pojo.User;
import service.OrderItemService;
import service.OrderService;
import service.UserService;

import java.security.PublicKey;
import java.util.List;

public class OrderAction {
    OrderService orderService;
    Order order;
    List<Order> orders;
    User user;

    OrderItemService orderItemService;

    public String list(){
        orders=orderService.list();
        orderItemService.fill(orders);
        return "listOrder";
    }
    public  String delivery(){
        orderService.get(order.getId()).setStatus(OrderService.waitConfirm);
        return "listOrder";
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
