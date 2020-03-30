package dao.impl;


import dao.ProductDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.util.StringUtils;
import pojo.Category;
import pojo.Product;

import java.util.List;

public class ProductDAOImpl extends HibernateTemplate implements ProductDAO {

    Product product;

    @Override
    public List<Product> list() {
        return (List<Product>) findByCriteria(DetachedCriteria.forClass(Product.class));
    }

    @Override
    public List<Product> listByCategory(Category category) {
        return (List<Product>) findByCriteria(DetachedCriteria.forClass(Product.class).add(Restrictions.eq("category",category)));
    }

    @Override
    public Product get(int id) {
        return (Product)get(Product.class,id);
    }

    @Override
    public void add(Product product) {
        save(product);
    }

    @Override
    public void delete(Product product) {
        super.delete(product);
    }

    @Override
    public void update(Product product) {
        super.update(product);
    }

    @Override
    public List<Product> listByKeyword(String keyword) {
        return (List<Product>) findByCriteria(DetachedCriteria.forClass(Product.class).add(Restrictions.like("name",keyword)));
    }
}
