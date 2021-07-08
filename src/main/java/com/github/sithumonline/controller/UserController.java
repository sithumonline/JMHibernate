package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.entity.Users;
import com.github.sithumonline.services.custom.UserService;
import javafx.collections.ObservableList;

public class UserController {

    public static boolean addUser(Users userDTO)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(Users userDTO)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.updateUser(userDTO);
    }

//    public static Users getUserById(String userId)throws Exception{
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        return userService.getByUserId(userId);
//    }

    public static boolean deleteUser(String userId)throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.deleteUser(userId);
    }

    public static ObservableList<Users> getUserList()throws Exception{
        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.getAllUsers();
    }

//    public static boolean addUserObserver(UserObserver userObserver)throws Exception{
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        return userService.addUserObserver(userObserver);
//    }
//
//    public static boolean removeUserObserver(UserObserver userObserver)throws Exception{
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        return userService.removeUserObserver(userObserver);
//    }
//
//    public static boolean reserveUser(String userId)throws Exception{
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        return userService.reserve(userId);
//    }
//
//    public static boolean releaseUser(String userId)throws Exception{
//        UserService userService = (UserService)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
//        return userService.release(userId);
//    }
    
}
