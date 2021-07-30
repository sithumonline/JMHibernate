package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Family;
import javafx.collections.ObservableList;


public interface FamilyBO extends SuperBO{

    boolean addFamily(Family familyDTO)throws Exception;

    boolean updateFamily(Family familyDTO)throws Exception;

    boolean deleteFamily(String familyId)throws Exception;

    Family getFamilyById(String familyId)throws Exception;

//  List<Familys> getAllFamilys()throws Exception;

    ObservableList<Family> getAllFamilies()throws Exception;

    ObservableList<Family> getAllFamiliesById(String id) throws Exception;
}
