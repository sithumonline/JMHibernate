package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.UserQueryBO;
import com.github.sithumonline.entity.UsersQuery;
import javafx.collections.ObservableList;

public class UserQueryController {

    public static boolean addUser(UsersQuery userDTO)throws Exception{
        UserQueryBO userService = (UserQueryBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USERQUERY);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(UsersQuery userDTO)throws Exception{
        UserQueryBO userService = (UserQueryBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USERQUERY);
        return userService.updateUser(userDTO);
    }

    public static boolean deleteUser(String userId)throws Exception{
        UserQueryBO userService = (UserQueryBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USERQUERY);
        return userService.deleteUser(userId);
    }

    public static ObservableList<UsersQuery> getUserList()throws Exception{
        UserQueryBO userService = (UserQueryBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USERQUERY);
        return userService.getAllUsers();
    }
    
}
