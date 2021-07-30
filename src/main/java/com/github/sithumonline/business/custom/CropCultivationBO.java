package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.CropCultivation;
import javafx.collections.ObservableList;


public interface CropCultivationBO extends SuperBO{

    boolean addCropCultivation(CropCultivation cropCultivationDTO)throws Exception;

    boolean updateCropCultivation(CropCultivation cropCultivationDTO)throws Exception;

    boolean deleteCropCultivation(String cropCultivationId)throws Exception;

    CropCultivation getCropCultivationById(String cropCultivationId)throws Exception;

//  List<CropCultivations> getAllCropCultivations()throws Exception;

    ObservableList<CropCultivation> getAllCropCultivations()throws Exception;

    ObservableList<CropCultivation> getAllCropCultivationsById(String id) throws Exception;
}
