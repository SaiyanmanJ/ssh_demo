package service.impl;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.impl.CategoryDAOImpl;
import org.springframework.util.StringUtils;
import pojo.Category;
import pojo.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    private CategoryDAO categoryDAO;

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Product> list() {
        return productDAO.list();
    }

    @Override
    public List<Product> listByCategory(Category category) {
        return productDAO.listByCategory(categoryDAO.get(category.getId()));
    }

    @Override
    public Product get(int id) {
        return productDAO.get(id);
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public List<Product> searchByKeyword(String keyword) {
        //"%xxx%" 表示匹配包含xxx的所有字符串，该字符串xxx前后都可以由字符，不加%表示只匹配xxx
        return productDAO.listByKeyword("%"+keyword+"%");
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void setCategoryDAO(CategoryDAOImpl categoryDAO) {
    }
}
