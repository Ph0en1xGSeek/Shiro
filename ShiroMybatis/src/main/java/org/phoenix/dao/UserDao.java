package org.phoenix.dao;

import org.phoenix.bean.User;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getByMap(Map<String, Object> map);
    User getById(Integer id);
    Integer create(User user) throws DataAccessException;
    int update(User user);
    int delete(Integer id);
    User getByUserName(String userNmae);
}
