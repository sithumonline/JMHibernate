package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.entity.UsersQuery;
import com.github.sithumonline.business.custom.UserQueryBO;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.UserQueryRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class UserQueryBOImpl implements UserQueryBO {

    private UserQueryRepository userRepository;

    public UserQueryBOImpl() {
        userRepository = (UserQueryRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.USERQUERY);
    }

    @Override
    public boolean addUser(UsersQuery userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);

            UsersQuery user = new UsersQuery(
                    userDTO.getName(),
                    userDTO.getLogic()
            );

            boolean result = userRepository.save(user);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateUser(UsersQuery userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);

            UsersQuery user = new UsersQuery(
                    userDTO.getName(),
                    userDTO.getLogic()
            );

            userRepository.update(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            UsersQuery user = userRepository.findById(userId);
            if (user != null){
                userRepository.delete(user);
                session.flush();
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public UsersQuery getUserById(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            UsersQuery user = userRepository.findById(userId);
            session.getTransaction().commit();
            if (user != null){
                return new UsersQuery(
                        user.getName(),
                        user.getLogic()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<UsersQuery> getAllUsers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            List<UsersQuery> userList = userRepository.findAll();
            session.getTransaction().commit();

            if (userList != null){
                ObservableList<UsersQuery> userDTOList = FXCollections.observableArrayList();
                for (UsersQuery user: userList
                     ) {
                    userDTOList.add(
                            new UsersQuery(
                                    user.getQueryId(),
                                    user.getName(),
                                    user.getLogic()
                            )
                    );
                }
                return userDTOList;
            }else {
                return null;
            }
        }
    }
}
