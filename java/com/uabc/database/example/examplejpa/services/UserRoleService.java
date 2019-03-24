package com.uabc.database.example.examplejpa.services;

import com.uabc.database.example.examplejpa.entity.UserRole;
import com.uabc.database.example.examplejpa.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    public abstract UserRoleModel addUserRole(UserRoleModel userRoleModel);

    public abstract List<UserRoleModel> listAllUserRoles();

    public abstract UserRole findUserRoleByUserRoleId(int id);

    public abstract void removeUserRole(int id);

    public abstract UserRoleModel findUserRoleByIdModel(int id);
}
