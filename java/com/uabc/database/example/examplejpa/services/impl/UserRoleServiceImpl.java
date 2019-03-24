package com.uabc.database.example.examplejpa.services.impl;

import com.uabc.database.example.examplejpa.components.UserRoleConverter;
import com.uabc.database.example.examplejpa.entity.UserRole;
import com.uabc.database.example.examplejpa.model.UserRoleModel;
import com.uabc.database.example.examplejpa.respository.UserRoleRepository;
import com.uabc.database.example.examplejpa.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    @Qualifier("userRoleRepository")
    private UserRoleRepository userRoleRepository;

    @Autowired
    @Qualifier("userRoleConverter")
    private UserRoleConverter userRoleConverter;

    @Override
    public UserRoleModel addUserRole(UserRoleModel userRoleModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el userRoleModel a entidad
        UserRole temp=userRoleConverter.convertToUserRoleModel2UserRole(userRoleModel);
        UserRole userRole = userRoleRepository.save(temp);
        return userRoleConverter.convertToUserRole2UserRoleModel(userRole);
    }

    @Override
    public List<UserRoleModel> listAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleModel> userRoleModel = new ArrayList();
        for(UserRole userRole : userRoles){
            userRoleModel.add(userRoleConverter.convertToUserRole2UserRoleModel(userRole));

        }
        return userRoleModel;
    }

    @Override
    public UserRole findUserRoleByUserRoleId(int id) {
        return userRoleRepository.findByUserRoleId(id);
    }

    public UserRoleModel findUserRoleByIdModel(int id){
        return userRoleConverter.convertToUserRole2UserRoleModel(findUserRoleByUserRoleId(id));
    }

    @Override
    public void removeUserRole(int id) {
        UserRole userRole  = findUserRoleByUserRoleId(id);
        if(userRole != null){
            userRoleRepository.delete(findUserRoleByUserRoleId(id));
        }
    }

}
