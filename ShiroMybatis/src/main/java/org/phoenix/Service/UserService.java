package org.phoenix.Service;

import org.phoenix.bean.User;
import org.phoenix.bean.User_Role;
import org.phoenix.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getByMap(Map<String, Object> map){
        return userDao.getByMap(map);
    }

    public User getById(Integer id){
        return userDao.getById(id);
    }

    public User create(User user)throws DataAccessException {
        userDao.create(user);
        return user;
    }

    public User update(User user){
        userDao.update(user);
        return user;
    }

    public int delete(Integer id){
        return userDao.delete(id);
    }

    public User getByUserName(String userName){
        return userDao.getByUserName(userName);
    }

    public List<User_Role> getRoles(Integer id){
        return userDao.getRoles(id);
    }
}