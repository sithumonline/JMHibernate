package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.FamilyBO;
import com.github.sithumonline.entity.Family;
import javafx.collections.ObservableList;

public class FamilyController {

    public static boolean addFamily(Family eventDTO)throws Exception{
        FamilyBO eventService = (FamilyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.FAMILY);
        return eventService.addFamily(eventDTO);
    }

    public static boolean updateFamily(Family eventDTO)throws Exception{
        FamilyBO eventService = (FamilyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.FAMILY);
        return eventService.updateFamily(eventDTO);
    }

    public static boolean deleteFamily(String eventId)throws Exception{
        FamilyBO eventService = (FamilyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.FAMILY);
        return eventService.deleteFamily(eventId);
    }

    public static ObservableList<Family> getFamilyList()throws Exception{
        FamilyBO eventService = (FamilyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.FAMILY);
        return eventService.getAllFamilies();
    }

    public static ObservableList<Family> getAllFamilysById(String id)throws Exception{
        FamilyBO eventService = (FamilyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.FAMILY);
        return eventService.getAllFamiliesById(id);
    }
    
}
