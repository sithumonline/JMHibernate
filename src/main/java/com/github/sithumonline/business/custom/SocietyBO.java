package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Societies;
import javafx.collections.ObservableList;


public interface SocietyBO extends SuperBO{

    boolean addSociety(Societies eventDTO)throws Exception;

    boolean updateSociety(Societies eventDTO)throws Exception;

    boolean deleteSociety(String eventId)throws Exception;

    Societies getSocietyById(String eventId)throws Exception;

//  List<Societys> getAllSocietys()throws Exception;

    ObservableList<Societies> getAllSocieties()throws Exception;

    ObservableList<Societies> getAllSocietiesById(String id) throws Exception;
}
