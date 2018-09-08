package org.phoenix.controller;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.phoenix.Service.UserService;
import org.phoenix.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list(HttpServletRequest request){
        return userService.getByMap(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User detail(@PathVariable Integer id){
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user){
        System.out.println("register");
        String username = user.getUsername();
        String password = user.getPassword();
        /*存入数据库前给密码加盐*/
        user.setPassword((new Md5Hash(password, username)).toString());
        try {
            userService.create(user);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";

    }
}
