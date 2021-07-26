package com.github.sithumonline.business;

import com.github.sithumonline.business.custom.impl.*;

public class BOFactory {

    public enum BOTypes{
        USER, USERQUERY, BENEFICIARYLISTS, EVENT,
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
            case EVENT:return new EventBOImpl();
            default:return null;
        }
    }
}
