package service.impl;

import dao.CategoryDAO;
import pojo.Category;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO;

    @Override
    public List<Category> list() {
        return categoryDAO.list();
    }

    @Override
    public Category get(int id) {
        return categoryDAO.get(id);
    }

    @Override
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
}
