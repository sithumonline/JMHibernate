package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Shops;
import javafx.collections.ObservableList;


public interface ShopBO extends SuperBO{

    boolean addShop(Shops shopDTO)throws Exception;

    boolean updateShop(Shops shopDTO)throws Exception;

    boolean deleteShop(String shopId)throws Exception;

    Shops getShopById(String shopId)throws Exception;

//  List<Shops> getAllShops()throws Exception;

    ObservableList<Shops> getAllShops()throws Exception;

    ObservableList<Shops> getAllShopsById(String id) throws Exception;
}
