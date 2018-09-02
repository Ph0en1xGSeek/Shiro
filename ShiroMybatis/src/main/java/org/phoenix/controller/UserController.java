package org.phoenix.controller;

import org.phoenix.Service.UserService;
import org.phoenix.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
