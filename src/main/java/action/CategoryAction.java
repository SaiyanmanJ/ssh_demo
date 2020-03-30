package action;

import pojo.Category;
import pojo.Product;
import pojo.User;
import service.CategoryService;

import java.util.List;

public class CategoryAction {

    List<Category> categories;
    Category category;
    CategoryService categoryService;

    public String list(){
        categories = categoryService.list();
        return "listCategory";
    }

    public String edit(){
        category = categoryService.get(category.getId());
        return "editCategory";
    }

    public String add(){
        categoryService.add(category);
        return "listCategoryAction";
    }

    public String delete(){
        categoryService.delete(category);
        return "listCategoryAction";
    }

    public String update(){
        categoryService.update(category);
        return "listCategoryAction";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
