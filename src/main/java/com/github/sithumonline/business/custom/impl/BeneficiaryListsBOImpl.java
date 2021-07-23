package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.BeneficiaryListsBO;
import com.github.sithumonline.entity.BeneficiaryLists;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.BeneficiaryListsRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BeneficiaryListsBOImpl implements BeneficiaryListsBO {

    private BeneficiaryListsRepository BeneficiaryListsRepository;

    public BeneficiaryListsBOImpl() {
        BeneficiaryListsRepository = (BeneficiaryListsRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.BENEFICIARYLISTS);
    }

    @Override
    public boolean addUser(BeneficiaryLists userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            BeneficiaryListsRepository.setSession(session);

            BeneficiaryLists user = new BeneficiaryLists(
                    userDTO.getKind(),
                    userDTO.getName(),
                    userDTO.getLogic()
            );

            boolean result = BeneficiaryListsRepository.save(user);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateUser(BeneficiaryLists userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            BeneficiaryListsRepository.setSession(session);

            BeneficiaryLists user = new BeneficiaryLists(
                    userDTO.getName(),
                    userDTO.getLogic()
            );

            BeneficiaryListsRepository.update(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            BeneficiaryListsRepository.setSession(session);
            BeneficiaryLists user = BeneficiaryListsRepository.findById(userId);
            if (user != null) {
                BeneficiaryListsRepository.delete(user);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public BeneficiaryLists getUserById(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            BeneficiaryListsRepository.setSession(session);
            BeneficiaryLists user = BeneficiaryListsRepository.findById(userId);
            session.getTransaction().commit();
            if (user != null) {
                return new BeneficiaryLists(
                        user.getName(),
                        user.getLogic()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<BeneficiaryLists> getAllUsers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            BeneficiaryListsRepository.setSession(session);
            List<BeneficiaryLists> userList = BeneficiaryListsRepository.findAll();
            session.getTransaction().commit();

            if (userList != null) {
                ObservableList<BeneficiaryLists> userDTOList = FXCollections.observableArrayList();
                for (BeneficiaryLists user : userList
                ) {
                    userDTOList.add(
                            new BeneficiaryLists(
                                    user.getKind(),
                                    user.getQueryId(),
                                    user.getName(),
                                    user.getLogic()
                            )
                    );
                }
                return userDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public String getLogicById(String id) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String sqlQuery = String.format("SELECT logic FROM %s WHERE query_id = '%s'", "BeneficiaryLists", id);
            Query query = session.createQuery(sqlQuery);
            List logic = query.list();

            if (logic != null) {
                return logic.get(0).toString();
            } else {
                return null;
            }
        }
    }
}
