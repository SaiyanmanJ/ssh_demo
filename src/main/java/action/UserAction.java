package action;

import pojo.User;
import service.UserService;

import java.util.List;

public class UserAction {
    List<User> userList;
    UserService userService;
    User user;

    public String list(){
        userList = userService.list();
        return "listUser";
    }
    public String edit(){
        user=userService.getById(user.getId());
        return "editUser";
    }
    public String add(){
        userService.add(user);
        return "listUserAction";
    }
    public String delete(){
        userService.delete(user);
        return "listUserAction";
    }
    public String update(){
        userService.update(user);
        return "listUserAction";
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
}
