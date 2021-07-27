package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.SocietyBO;
import com.github.sithumonline.entity.Societies;
import javafx.collections.ObservableList;

public class SocietyController {

    public static boolean addSociety(Societies societyDTO)throws Exception{
        SocietyBO societyService = (SocietyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SOCIETY);
        return societyService.addSociety(societyDTO);
    }

    public static boolean updateSociety(Societies societyDTO)throws Exception{
        SocietyBO societyService = (SocietyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SOCIETY);
        return societyService.updateSociety(societyDTO);
    }

    public static boolean deleteSociety(String societyId)throws Exception{
        SocietyBO societyService = (SocietyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SOCIETY);
        return societyService.deleteSociety(societyId);
    }

    public static ObservableList<Societies> getSocietyList()throws Exception{
        SocietyBO societyService = (SocietyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SOCIETY);
        return societyService.getAllSocieties();
    }

    public static ObservableList<Societies> getAllSocietysById(String id)throws Exception{
        SocietyBO societyService = (SocietyBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.SOCIETY);
        return societyService.getAllSocietiesById(id);
    }
    
}
