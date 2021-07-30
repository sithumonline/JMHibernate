package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.HomeBO;
import com.github.sithumonline.entity.Home;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.HomeRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HomeBOImpl implements HomeBO {

    private HomeRepository homeRepository;

    public HomeBOImpl() {
        homeRepository = (HomeRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.HOME);
    }

    @Override
    public boolean addHome(Home homeDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);

            Home home = new Home(
                    homeDTO.getNumber(),
                    homeDTO.getConstructionsStatus(),
                    homeDTO.getAreaOfTheHouse(),
                    homeDTO.getAddress(),
                    homeDTO.getElectricityAndWaterSupply()
            );

            boolean result = homeRepository.save(home);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateHome(Home homeDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);

            Home home = new Home(
                    homeDTO.getId(),
                    homeDTO.getNumber(),
                    homeDTO.getConstructionsStatus(),
                    homeDTO.getAreaOfTheHouse(),
                    homeDTO.getAddress(),
                    homeDTO.getElectricityAndWaterSupply()
            );

            homeRepository.update(home);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteHome(String homeId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);
            Home home = homeRepository.findById(Integer.parseInt(homeId));
            if (home != null) {
                homeRepository.delete(home);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Home getHomeById(String homeId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);
            Home home = homeRepository.findById(Integer.parseInt(homeId));
            session.getTransaction().commit();
            if (home != null) {
                return new Home(
                        home.getNumber(),
                        home.getConstructionsStatus(),
                        home.getAreaOfTheHouse(),
                        home.getAddress(),
                        home.getElectricityAndWaterSupply()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Home> getAllHomes() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);
            List<Home> homeList = homeRepository.findAll();
            session.getTransaction().commit();

            if (homeList != null) {
                ObservableList<Home> homeDTOList = FXCollections.observableArrayList();
                for (Home home : homeList
                ) {
                    homeDTOList.add(
                            new Home(
                                    home.getId(),
                                    home.getNumber(),
                                    home.getConstructionsStatus(),
                                    home.getAreaOfTheHouse(),
                                    home.getAddress(),
                                    home.getElectricityAndWaterSupply()
                            )
                    );
                }
                return homeDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Home> getAllHomesById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            homeRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Home", logic);
            Query query = session.createQuery(sqlQuery);
            List<Home> homeList = query.list();

            if (homeList != null) {
                ObservableList<Home> homeDTOList = FXCollections.observableArrayList();
                System.out.println(homeList);
                for (Home home : homeList
                ) {
                    homeDTOList.add(
                            new Home(
                                    home.getId(),
                                    home.getNumber(),
                                    home.getConstructionsStatus(),
                                    home.getAreaOfTheHouse(),
                                    home.getAddress(),
                                    home.getElectricityAndWaterSupply()
                            )
                    );
                }
                return homeDTOList;
            } else {
                return null;
            }
        }
    }
}
