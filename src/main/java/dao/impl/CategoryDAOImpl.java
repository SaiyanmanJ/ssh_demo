package dao.impl;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import dao.CategoryDAO;
import org.springframework.orm.hibernate5.HibernateTemplate;
import pojo.Category;

import java.util.List;

public class CategoryDAOImpl extends HibernateTemplate implements CategoryDAO {

    Category category;

    @Override
    public List<Category> list() {
        return (List<Category>) find("from Category");
    }

    @Override
    public Category get(int id) {
        return (Category)get(Category.class,id);
    }

    @Override
    public void add(Category category) {
        save(category);
    }

    @Override
    public void delete(Category category) {
        super.delete(category);
    }

    @Override
    public void update(Category category) {
        super.update(category);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
