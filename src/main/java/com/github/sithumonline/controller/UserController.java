package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.entity.Users;
import com.github.sithumonline.services.custom.UserService;
import javafx.collections.ObservableList;

public class UserController {

    public static boolean addUser(Users userDTO)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(Users userDTO)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.updateUser(userDTO);
    }

    public static boolean deleteUser(String userId)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.deleteUser(userId);
    }

    public static ObservableList<Users> getUserList()throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.getAllUsers();
    }
    
}
