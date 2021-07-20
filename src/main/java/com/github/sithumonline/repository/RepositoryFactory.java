package com.github.sithumonline.repository;

import com.github.sithumonline.repository.custom.impl.*;

public class RepositoryFactory {

    public enum RepositoryFactoryTypes{
        USER, USERQUERY
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
            default: return null;
        }
    }
}
