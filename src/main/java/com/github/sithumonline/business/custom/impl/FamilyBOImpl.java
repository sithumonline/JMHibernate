package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.FamilyBO;
import com.github.sithumonline.entity.Family;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.FamilyRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FamilyBOImpl implements FamilyBO {

    private FamilyRepository familyRepository;

    public FamilyBOImpl() {
        familyRepository = (FamilyRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.FAMILY);
    }

    @Override
    public boolean addFamily(Family familyDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);

            Family family = new Family(
                    familyDTO.getSurname(),
                    familyDTO.getNumberOfMembers(),
                    familyDTO.getTotalIncome(),
                    familyDTO.getReligion(),
                    familyDTO.getHeadOfFamily()
            );

            boolean result = familyRepository.save(family);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateFamily(Family familyDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);

            Family family = new Family(
                    familyDTO.getId(),
                    familyDTO.getSurname(),
                    familyDTO.getNumberOfMembers(),
                    familyDTO.getTotalIncome(),
                    familyDTO.getReligion(),
                    familyDTO.getHeadOfFamily()
            );

            familyRepository.update(family);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteFamily(String familyId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);
            Family family = familyRepository.findById(Integer.parseInt(familyId));
            if (family != null) {
                familyRepository.delete(family);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Family getFamilyById(String familyId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);
            Family family = familyRepository.findById(Integer.parseInt(familyId));
            session.getTransaction().commit();
            if (family != null) {
                return new Family(
                        family.getSurname(),
                        family.getNumberOfMembers(),
                        family.getTotalIncome(),
                        family.getReligion(),
                        family.getHeadOfFamily()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Family> getAllFamilies() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);
            List<Family> familyList = familyRepository.findAll();
            session.getTransaction().commit();

            if (familyList != null) {
                ObservableList<Family> familyDTOList = FXCollections.observableArrayList();
                for (Family family : familyList
                ) {
                    familyDTOList.add(
                            new Family(
                                    family.getId(),
                                    family.getSurname(),
                                    family.getNumberOfMembers(),
                                    family.getTotalIncome(),
                                    family.getReligion(),
                                    family.getHeadOfFamily()
                            )
                    );
                }
                return familyDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Family> getAllFamiliesById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            familyRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Family", logic);
            Query query = session.createQuery(sqlQuery);
            List<Family> familyList = query.list();

            if (familyList != null) {
                ObservableList<Family> familyDTOList = FXCollections.observableArrayList();
                System.out.println(familyList);
                for (Family family : familyList
                ) {
                    familyDTOList.add(
                            new Family(
                                    family.getId(),
                                    family.getSurname(),
                                    family.getNumberOfMembers(),
                                    family.getTotalIncome(),
                                    family.getReligion(),
                                    family.getHeadOfFamily()
                            )
                    );
                }
                return familyDTOList;
            } else {
                return null;
            }
        }
    }
}
