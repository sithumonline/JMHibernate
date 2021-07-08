package com.github.sithumonline.business.custom;

import com.github.sithumonline.entity.Users;
//import com.github.sithumonline.model.User;
import com.github.sithumonline.business.SuperBO;

import java.util.List;

public interface UserBO extends SuperBO{

    public boolean addUser(Users userDTO)throws Exception;

    public boolean updateUser(Users userDTO)throws Exception;

    public boolean deleteUser(String userId)throws Exception;

    public Users getUserById(String userId)throws Exception;

    public List<Users> getAllUsers()throws Exception;

}
