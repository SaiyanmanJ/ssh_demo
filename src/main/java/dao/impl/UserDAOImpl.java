package dao.impl;

import dao.UserDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import pojo.User;

import java.util.List;

public class UserDAOImpl extends HibernateTemplate implements UserDAO {
    @Override
    public List<User> list() {
        return (List<User>) findByCriteria(DetachedCriteria.forClass(User.class));
    }

    @Override
    public User get(int id) {
        return get(User.class,id);
    }

    @Override
    public List<User> getByName(String name) {
        return (List<User>) findByCriteria(DetachedCriteria.forClass(User.class).add(Restrictions.eq("name",name)));
    }

    @Override
    public void add(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public void update(User user) {
        super.update(user);
    }
}
