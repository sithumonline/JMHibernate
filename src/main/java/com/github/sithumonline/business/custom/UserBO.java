package com.github.sithumonline.business.custom;

import com.github.sithumonline.model.User;
import com.github.sithumonline.business.SuperBO;

import java.util.List;

public interface UserBO extends SuperBO{

    public boolean addUser(User userDTO)throws Exception;

    public boolean updateUser(User userDTO)throws Exception;

    public boolean deleteUser(String userId)throws Exception;

    public User getUserById(String userId)throws Exception;

    public List<User> getAllUsers()throws Exception;

}
