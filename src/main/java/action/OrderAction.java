package action;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.opensymphony.xwork2.ActionContext;
import config.AlipayConfig;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;
import service.OrderItemService;
import service.OrderService;
import service.impl.AlipayServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class OrderAction {
    OrderService orderService;
    Order order;
    List<Order> orders;
    User user;
    Product product;
    int num;
    String msg;
    List<OrderItem> orderItems;
    OrderItemService orderItemService;
    String result;
    AlipayServiceImpl acsi;
    public String alipay() throws AlipayApiException {
        user = (User) ActionContext.getContext().getSession().get("user");
        if(user==null){
            msg="还没登录呢！";
            return "home";
        }else{
            msg="";
        }
        float total = order.getTotal();
        order = orderService.get(order.getId());
        order.setTotal(total);
        result=acsi.postAlipay(order.getOrderCode(),""+order.getTotal(),""+order.getCreateDate(),""+order.getTotalNumber());
        return "alipay";
    }

    public String payed(){
        /*支付宝验签*/
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        /*支付宝回调函数，验签*/
        result = acsi.confirmResult(request,response);
        if(result=="验签失败"){
            msg = "支付失败，请重新支付";
        }else{
            float total = order.getTotal();
            order = orderService.get(order.getId());
            if(order.getStatus().equals(OrderService.waitPay)){
                order.setStatus(OrderService.waitDelivery);
                order.setPayDate(new Date());
                orderService.update(order);
            }
            order.setTotal(total);
            msg="支付成功";
        }

        return "payedPage";
    }

    public String create(){
        List<OrderItem> ois = (List<OrderItem>) ActionContext.getContext().getSession().get("orderItems");
        if(ois==null){
            return "login";
        }
        user = (User)ActionContext.getContext().getSession().get("user");
        order = orderService.createOrder(ois,user);
        return "alipayPage";
    }

    public String list(){
        user = (User) ActionContext.getContext().getSession().get("user");
        if(user == null)
            orders=orderService.list();
        else
            orders = orderService.listByUserWithoutDelete(user);
        orderItemService.fill(orders);
        return "listOrder";
    }
    public String delivery(){
        order = orderService.get(order.getId());
        order.setStatus(OrderService.waitConfirm);
        order.setDeliveryDate(new Date());
        orderService.update(order);
        return "listOrderAction";
    }

    public String confirm(){
        order = orderService.get(order.getId());
        order.setStatus(OrderService.finish);
        order.setConfirmDate(new Date());
        orderService.update(order);
        return "listOrderAction";
    }

    public String delete(){
        order = orderService.get(order.getId());
        order.setStatus(OrderService.delete);
        orderService.update(order);
        return "listOrderAction";
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AlipayServiceImpl getAcsi() {
        return acsi;
    }

    public void setAcsi(AlipayServiceImpl acsi) {
        this.acsi = acsi;
    }
}
