package org.phoenix.Service;


import org.phoenix.bean.Role_Permission;
import org.phoenix.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleService {

    @Autowired
    private RoleDao roleDao;
    List<Role_Permission> getPermissions(Integer id){
        return roleDao.getPermissions(id);
    }
}
