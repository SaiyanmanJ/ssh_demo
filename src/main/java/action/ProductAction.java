package action;


import com.opensymphony.xwork2.ActionContext;
import pojo.Category;
import pojo.Product;
import pojo.User;
import service.CategoryService;
import service.ProductService;

import java.util.List;

public class ProductAction {

    ProductService productService;
    List<Product> products;
    Product product;
    String keyword;

    User user;

    public String list() {
        products = productService.list();
        return "listProduct";
    }

    public String add(){
        productService.add(product);
        return "listProductAction";
    }
    public String edit(){
        product = productService.get(product.getId());
        return "editProduct";
    }
    public String delete(){
        productService.delete(product);
        return "listProductAction";
    }
    public String update(){
        productService.update(product);
        return "listProductAction";
    }
    public String search(){
        products = productService.searchByKeyword(keyword);
        return "searchResult";
    }
    public String listByCategory(){
        products = productService.listByCategory(product.getCategory());
        return "listProduct";
    }

    public String info(){
        product = productService.get(product.getId());
        return "infoProduct";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
