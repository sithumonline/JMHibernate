package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.BeneficiaryLists;
import javafx.collections.ObservableList;


public interface BeneficiaryListsBO extends SuperBO{

    boolean addUser(BeneficiaryLists userDTO)throws Exception;

    boolean updateUser(BeneficiaryLists userDTO)throws Exception;

    boolean deleteUser(String userId)throws Exception;

    BeneficiaryLists getUserById(String userId)throws Exception;

//  List<Users> getAllUsers()throws Exception;

    ObservableList<BeneficiaryLists> getAllUsers()throws Exception;

   String getLogicById(String namae) throws Exception;
}
