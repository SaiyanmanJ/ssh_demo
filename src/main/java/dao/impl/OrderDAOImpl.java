package dao.impl;


import dao.OrderDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import pojo.Category;
import pojo.Order;
import pojo.User;
import service.OrderService;

import java.util.List;

public class OrderDAOImpl extends HibernateTemplate implements OrderDAO {

    Order Order;

    @Override
    public List<Order> list() {
        return (List<Order>) findByCriteria(DetachedCriteria.forClass(Order.class));
    }

    @Override
    public List<Order> listByUserWithoutDelete(User user) {
        return (List<Order>) findByCriteria(DetachedCriteria.forClass(Order.class).add(Restrictions.eq("user",user)));
    }

    @Override
    public Order get(int id) {
        return (Order)get(Order.class,id);
    }

    @Override
    public void add(Order order) {
        save(order);
    }

    @Override
    public void delete(Order order) {
        super.delete(order);
    }

    @Override
    public void update(Order order) {
        super.update(order);
    }

    @Override
    public List<Order> listByKeyword(String keyword) {
        return (List<Order>) findByCriteria(DetachedCriteria.forClass(Order.class).add(Restrictions.like("name",keyword)));
    }

    public pojo.Order getOrder() {
        return Order;
    }

    public void setOrder(pojo.Order order) {
        Order = order;
    }
}
