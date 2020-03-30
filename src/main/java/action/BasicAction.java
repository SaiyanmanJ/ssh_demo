package action;

import com.opensymphony.xwork2.ActionContext;
import pojo.User;
import service.UserService;

public class BasicAction {

    UserService userService;
    User user;
    String msg;
    public String registerUser(){
        return "registerUser";
    }
    public String home(){
        return "index";
    }
    public String loginUser(){
        return "loginUser";
    }

    public String register(){
        /*if(user==null){
            msg = "用户名为空！";
            return "registerError";
        }*/
        if(userService.isExist(user.getName())){
            msg = "用户已存在，请更换用户名";
            return "registerError";
        }else{
            userService.add(user);
            return "registerSuccess";
        }
    }

    public String login(){
        if(userService.userIsExist(user)){
            user = userService.getByName(user.getName());
            ActionContext.getContext().getSession().put("user",user);
            return "loginSuccess";
        }else {
            msg = "用户或密码错误";
            return "loginError";
        }

    }
    public String loginOut(){
        ActionContext.getContext().getSession().remove("user");
        return "loginOut";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
}
