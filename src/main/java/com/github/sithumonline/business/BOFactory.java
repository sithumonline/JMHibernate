package com.github.sithumonline.business;

import com.github.sithumonline.business.custom.impl.*;

public class BOFactory {

    public enum BOTypes{
        USER, USERQUERY, BENEFICIARYLISTS, EVENT, SOCIETY, CROP, SHOP, FAMILY, PERSON, HOME,
    }

    private BOFactory() {
    }

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory == null)
            boFactory = new BOFactory();
        return boFactory;
    }

    public SuperBO getBOFactory(BOTypes boTypes){
        switch (boTypes){
            case USER: return new UserBOImpl();
            case USERQUERY: return new UserQueryBOImpl();
            case BENEFICIARYLISTS: return new BeneficiaryListsBOImpl();
            case EVENT: return new EventBOImpl();
            case SOCIETY: return new SocietyBOImpl();
            case CROP: return new CropCultivationBOImpl();
            case SHOP: return new ShopBOImpl();
            case FAMILY: return new FamilyBOImpl();
            case PERSON: return new PersonBOImpl();
            case HOME: return new HomeBOImpl();
            default:return null;
        }
    }
}
