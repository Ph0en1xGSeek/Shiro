package org.phoenix.Service;

import org.phoenix.bean.Permission;
import org.phoenix.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public Permission getById(Integer id){
        return permissionDao.getById(id);
    }
}
