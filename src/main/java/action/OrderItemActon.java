package action;

import com.opensymphony.xwork2.ActionContext;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;
import service.OrderItemService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class OrderItemActon {

    OrderItem orderItem;
    OrderItemService orderItemService;
    ProductService productService;
    List<OrderItem> orderItems;
    Product product;
    User user;
    int num;
    String msg;
    int[] oiids;
    int oiid;
    float total;
    public String buy(){
        total=0;
        orderItems = new ArrayList<>();
        for (int oiid:oiids){
            orderItem = orderItemService.get(oiid);
            total += orderItem.getNumber()*orderItem.getProduct().getPrice();
            orderItems.add(orderItemService.get(oiid));
        }
        ActionContext.getContext().getSession().put("orderItems",orderItems);
        return "buyPage";
    }

    public String buyOne(){
        user = (User)ActionContext.getContext().getSession().get("user");
        if(user==null){
            msg="您还没登录就想买东西!!!？？？白嫖吗，不存在的";
            return "home";
        }else{
            msg="";
        }
        orderItems = orderItemService.add(product.getId(),user.getId(),num);
        oiid = orderItems.get(0).getId();
        return "redirectBuy";
    }

    public String addCart(){
        user = (User)ActionContext.getContext().getSession().get("user");
        if(user==null){
            msg="您还没登录就想买东西!!!？？？白嫖吗，不存在的";
            return "home";
        }else{
            msg="已加入购物车";
        }
        orderItems.clear();
        orderItems = orderItemService.add(product.getId(),user.getId(),num);
        product = productService.get(product.getId());
        return "infoProduct";
    }
    public String cart(){
        user = (User)ActionContext.getContext().getSession().get("user");
        if(user==null){
            msg="您还没登录想看谁的购物车啊？";
            return "home";
        }else{
            msg="";
        }
        orderItems = orderItemService.listByUserWithNoOrder(user);
        return "cartPage";
    }

    public String update(){
        orderItem = orderItemService.get(orderItem.getId());
        if(orderItem.getProduct().getId()==product.getId()){
            orderItem.setNumber(num);
            orderItemService.update(orderItem);
        }
        return "success";
    }


    public String delete(){
        orderItemService.delete(orderItem);
        return "deleteSuccess";
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public int[] getOiids() {
        return oiids;
    }

    public void setOiids(int[] oiids) {
        this.oiids = oiids;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
    }
}
