package dao;

import pojo.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> list();
    public Category get(int id);
    public void add(Category category);
    public void delete(Category category);
    public void update(Category category);
}
