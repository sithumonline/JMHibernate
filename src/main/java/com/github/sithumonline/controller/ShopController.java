package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.ShopBO;
import com.github.sithumonline.entity.Shops;
import javafx.collections.ObservableList;

public class ShopController {

    public static boolean addShop(Shops shopDTO)throws Exception{
        ShopBO shopService = (ShopBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SHOP);
        return shopService.addShop(shopDTO);
    }

    public static boolean updateShop(Shops shopDTO)throws Exception{
        ShopBO shopService = (ShopBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SHOP);
        return shopService.updateShop(shopDTO);
    }

    public static boolean deleteShop(String shopId)throws Exception{
        ShopBO shopService = (ShopBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SHOP);
        return shopService.deleteShop(shopId);
    }

    public static ObservableList<Shops> getShopList()throws Exception{
        ShopBO shopService = (ShopBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SHOP);
        return shopService.getAllShops();
    }

    public static ObservableList<Shops> getAllShopsById(String id)throws Exception{
        ShopBO shopService = (ShopBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SHOP);
        return shopService.getAllShopsById(id);
    }
    
}
