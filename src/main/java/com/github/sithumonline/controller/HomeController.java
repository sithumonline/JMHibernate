package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.HomeBO;
import com.github.sithumonline.entity.Home;
import javafx.collections.ObservableList;

public class HomeController {

    public static boolean addHome(Home homeDTO)throws Exception{
        HomeBO homeService = (HomeBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.HOME);
        return homeService.addHome(homeDTO);
    }

    public static boolean updateHome(Home homeDTO)throws Exception{
        HomeBO homeService = (HomeBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.HOME);
        return homeService.updateHome(homeDTO);
    }

    public static boolean deleteHome(String homeId)throws Exception{
        HomeBO homeService = (HomeBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.HOME);
        return homeService.deleteHome(homeId);
    }

    public static ObservableList<Home> getHomeList()throws Exception{
        HomeBO homeService = (HomeBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.HOME);
        return homeService.getAllHomes();
    }

    public static ObservableList<Home> getAllHomesById(String id)throws Exception{
        HomeBO homeService = (HomeBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.HOME);
        return homeService.getAllHomesById(id);
    }
    
}
