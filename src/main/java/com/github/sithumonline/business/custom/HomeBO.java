package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Home;
import javafx.collections.ObservableList;


public interface HomeBO extends SuperBO{

    boolean addHome(Home personDTO)throws Exception;

    boolean updateHome(Home personDTO)throws Exception;

    boolean deleteHome(String personId)throws Exception;

    Home getHomeById(String personId)throws Exception;

//  List<Homes> getAllHomes()throws Exception;

    ObservableList<Home> getAllHomes()throws Exception;

    ObservableList<Home> getAllHomesById(String id) throws Exception;
}
