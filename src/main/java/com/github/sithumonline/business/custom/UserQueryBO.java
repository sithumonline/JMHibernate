package com.github.sithumonline.business.custom;

import com.github.sithumonline.entity.UsersQuery;
import com.github.sithumonline.business.SuperBO;
import javafx.collections.ObservableList;


public interface UserQueryBO extends SuperBO{

    boolean addUser(UsersQuery userDTO)throws Exception;

    boolean updateUser(UsersQuery userDTO)throws Exception;

    boolean deleteUser(String userId)throws Exception;

    UsersQuery getUserById(String userId)throws Exception;

//  List<Users> getAllUsers()throws Exception;

    ObservableList<UsersQuery> getAllUsers()throws Exception;
}
