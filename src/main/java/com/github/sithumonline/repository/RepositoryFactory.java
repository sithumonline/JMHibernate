package com.github.sithumonline.repository;

import com.github.sithumonline.repository.custom.impl.*;

public class RepositoryFactory {

    public enum RepositoryFactoryTypes{
        USER, USERQUERY, BENEFICIARYLISTS, EVENT, SOCIETY, CROP, SHOP,
    }

    private RepositoryFactory() {
    }

    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null)
            repositoryFactory = new RepositoryFactory();
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryFactoryTypes repositoryFactoryTypes){
        switch (repositoryFactoryTypes){
            case USER: return new UserRepositoryImpl();
            case USERQUERY: return new UserQueryRepositoryImpl();
            case BENEFICIARYLISTS: return new BeneficiaryListsRepositoryImpl();
            case EVENT: return new EventRepositoryImpl();
            case SOCIETY: return new SocietyRepositoryImpl();
            case CROP: return new CropCultivationImpl();
            case SHOP: return new ShopRepositoryImpl();
            default: return null;
        }
    }
}
