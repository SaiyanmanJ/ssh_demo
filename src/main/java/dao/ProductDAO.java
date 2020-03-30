package dao;

import pojo.Category;
import pojo.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> list();
    public List<Product> listByCategory(Category category);
    public Product get(int id);
    public void add(Product product);
    public void delete(Product product);
    public void update(Product product);

    public List<Product> listByKeyword(String keyword);
}
