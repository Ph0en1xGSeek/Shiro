package org.phoenix.dao;

import org.phoenix.bean.Role_Permission;

import java.util.List;

public interface RoleDao {
    List<Role_Permission> getPermissions(Integer id);
}
