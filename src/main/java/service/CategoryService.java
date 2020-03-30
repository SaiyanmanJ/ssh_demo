package service;

import pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> list();
    public Category get(int id);
    public void add(Category category);
    public void delete(Category category);
    public void update(Category category);
}
