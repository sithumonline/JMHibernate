package com.github.sithumonline.services.custom;

import com.github.sithumonline.entity.Users;
import com.github.sithumonline.services.SuperService;
import javafx.collections.ObservableList;

import java.util.List;

public interface UserService extends SuperService{

    public boolean addUser(Users userDTO)throws Exception;

    public boolean updateUser(Users userDTO)throws Exception;

    public boolean deleteUser(String userId)throws Exception;

    public Users getUserById(String userId)throws Exception;

//    public List<Users> getAllUsers()throws Exception;

    public ObservableList<Users> getAllUsers()throws Exception;

}
