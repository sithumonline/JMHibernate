package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.BeneficiaryListsBO;
import com.github.sithumonline.entity.BeneficiaryLists;
import javafx.collections.ObservableList;

public class BeneficiaryListsController {

    public static boolean addUser(BeneficiaryLists userDTO)throws Exception{
        BeneficiaryListsBO userService = (BeneficiaryListsBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.BENEFICIARYLISTS);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(BeneficiaryLists userDTO)throws Exception{
        BeneficiaryListsBO userService = (BeneficiaryListsBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.BENEFICIARYLISTS);
        return userService.updateUser(userDTO);
    }

    public static boolean deleteUser(String userId)throws Exception{
        BeneficiaryListsBO userService = (BeneficiaryListsBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.BENEFICIARYLISTS);
        return userService.deleteUser(userId);
    }

    public static ObservableList<BeneficiaryLists> getUserList()throws Exception{
        BeneficiaryListsBO userService = (BeneficiaryListsBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.BENEFICIARYLISTS);
        return userService.getAllUsers();
    }

    public static String getLogicById(String name)throws Exception{
        BeneficiaryListsBO userService = (BeneficiaryListsBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.BENEFICIARYLISTS);
        return userService.getLogicById(name);
    }

}
