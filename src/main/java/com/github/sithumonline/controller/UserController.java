package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.UserBO;
import com.github.sithumonline.entity.Users;
import javafx.collections.ObservableList;

public class UserController {

    public static boolean addUser(Users userDTO) throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(Users userDTO) throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.updateUser(userDTO);
    }

    public static boolean deleteUser(String userId) throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.deleteUser(userId);
    }

    public static ObservableList<Users> getUserList() throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.getAllUsers();
    }

    public static ObservableList<Users> getAllUsersById(String id) throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.getAllUsersById(id);
    }

    public static boolean checkUserPassword(String userName, String password) throws Exception {
        UserBO userService = (UserBO) BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.checkPassword(userName, password);
    }

}
