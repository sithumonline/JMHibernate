package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.SocietyBO;
import com.github.sithumonline.entity.Societies;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.SocietyRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SocietyBOImpl implements SocietyBO {

    private SocietyRepository societyRepository;

    public SocietyBOImpl() {
        societyRepository = (SocietyRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.SOCIETY);
    }

    @Override
    public boolean addSociety(Societies societyDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);

            Societies society = new Societies(
                    societyDTO.getName(),
                    societyDTO.getOrientation(),
                    societyDTO.getOfficeBearer(),
                    societyDTO.getMonthlyMembershipFee(),
                    societyDTO.getAgeGroup()
            );

            boolean result = societyRepository.save(society);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateSociety(Societies societyDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);

            Societies society = new Societies(
                    societyDTO.getId(),
                    societyDTO.getName(),
                    societyDTO.getOrientation(),
                    societyDTO.getOfficeBearer(),
                    societyDTO.getMonthlyMembershipFee(),
                    societyDTO.getAgeGroup()
            );

            societyRepository.update(society);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteSociety(String societyId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);
            Societies society = societyRepository.findById(Integer.parseInt(societyId));
            if (society != null) {
                societyRepository.delete(society);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Societies getSocietyById(String societyId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);
            Societies society = societyRepository.findById(Integer.parseInt(societyId));
            session.getTransaction().commit();
            if (society != null) {
                return new Societies(
                        society.getName(),
                        society.getOrientation(),
                        society.getOfficeBearer(),
                        society.getMonthlyMembershipFee(),
                        society.getAgeGroup()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Societies> getAllSocieties() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);
            List<Societies> societyList = societyRepository.findAll();
            session.getTransaction().commit();

            if (societyList != null) {
                ObservableList<Societies> societyDTOList = FXCollections.observableArrayList();
                for (Societies society : societyList
                ) {
                    societyDTOList.add(
                            new Societies(
                                    society.getId(),
                                    society.getName(),
                                    society.getOrientation(),
                                    society.getOfficeBearer(),
                                    society.getMonthlyMembershipFee(),
                                    society.getAgeGroup()
                            )
                    );
                }
                return societyDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Societies> getAllSocietiesById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            societyRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Societies", logic);
            Query query = session.createQuery(sqlQuery);
            List<Societies> societyList = query.list();

            if (societyList != null) {
                ObservableList<Societies> societyDTOList = FXCollections.observableArrayList();
                System.out.println(societyList);
                for (Societies society : societyList
                ) {
                    societyDTOList.add(
                            new Societies(
                                    society.getId(),
                                    society.getName(),
                                    society.getOrientation(),
                                    society.getOfficeBearer(),
                                    society.getMonthlyMembershipFee(),
                                    society.getAgeGroup()
                            )
                    );
                }
                return societyDTOList;
            } else {
                return null;
            }
        }
    }
}
