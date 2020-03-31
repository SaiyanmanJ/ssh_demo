package dao.impl;


import dao.OrderItemDAO;
import dao.ProductDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import pojo.Order;
import pojo.OrderItem;
import pojo.User;

import java.util.List;

public class OrderItemDAOImpl extends HibernateTemplate implements OrderItemDAO {

    OrderItem OrderItem;
    @Override
    public List<OrderItem> list() {
        return (List<OrderItem>) findByCriteria(DetachedCriteria.forClass(OrderItem.class));
    }

    @Override
    public List<OrderItem> listByUser(User user) {
        return (List<OrderItem>) findByCriteria(DetachedCriteria.forClass(OrderItem.class).add(Restrictions.eq("user",user)));
    }
    @Override
    public List<OrderItem> listByOrder(Order order) {
        return (List<OrderItem>) findByCriteria(DetachedCriteria.forClass(OrderItem.class).add(Restrictions.eq("order",order)));
    }

    @Override
    public List<OrderItem> listByUserWithNoOrder(User user) {
        return (List<OrderItem>) findByCriteria(DetachedCriteria.forClass(OrderItem.class).add(Restrictions.eq("user",user)).add(Restrictions.isNull("order")));
    }

    @Override
    public OrderItem get(int id) {
        return (OrderItem)get(OrderItem.class,id);
    }

    @Override
    public void add(OrderItem orderItem) {
        save(orderItem);
    }

    @Override
    public void delete(OrderItem orderItem) {
        super.delete(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        super.update(orderItem);
    }

    public pojo.OrderItem getOrderItem() {
        return OrderItem;
    }

    public void setOrderItem(pojo.OrderItem orderItem) {
        OrderItem = orderItem;
    }
}
