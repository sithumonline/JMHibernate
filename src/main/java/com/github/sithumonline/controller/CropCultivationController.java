package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.CropCultivationBO;
import com.github.sithumonline.entity.CropCultivation;
import javafx.collections.ObservableList;

public class CropCultivationController {

    public static boolean addCropCultivation(CropCultivation cropCultivationDTO)throws Exception{
        CropCultivationBO cropCultivationService = (CropCultivationBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.CROP);
        return cropCultivationService.addCropCultivation(cropCultivationDTO);
    }

    public static boolean updateCropCultivation(CropCultivation cropCultivationDTO)throws Exception{
        CropCultivationBO cropCultivationService = (CropCultivationBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.CROP);
        return cropCultivationService.updateCropCultivation(cropCultivationDTO);
    }

    public static boolean deleteCropCultivation(String cropCultivationId)throws Exception{
        CropCultivationBO cropCultivationService = (CropCultivationBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.CROP);
        return cropCultivationService.deleteCropCultivation(cropCultivationId);
    }

    public static ObservableList<CropCultivation> getCropCultivationList()throws Exception{
        CropCultivationBO cropCultivationService = (CropCultivationBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.CROP);
        return cropCultivationService.getAllCropCultivations();
    }

    public static ObservableList<CropCultivation> getAllCropCultivationsById(String id)throws Exception{
        CropCultivationBO cropCultivationService = (CropCultivationBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.CROP);
        return cropCultivationService.getAllCropCultivationsById(id);
    }
    
}
