package com.github.sithumonline.business.custom;

import com.github.sithumonline.entity.Users;
import com.github.sithumonline.business.SuperBO;
import javafx.collections.ObservableList;


public interface UserBO extends SuperBO{

    boolean addUser(Users userDTO)throws Exception;

    boolean updateUser(Users userDTO)throws Exception;

    boolean deleteUser(String userId)throws Exception;

    Users getUserById(String userId)throws Exception;

//  List<Users> getAllUsers()throws Exception;

    ObservableList<Users> getAllUsers()throws Exception;

    ObservableList<Users> getAllUsersByLogic(String logic) throws Exception;
}
