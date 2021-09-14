package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.entity.Users;
import com.github.sithumonline.business.custom.UserBO;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.UserRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserBOImpl implements UserBO {

    private UserRepository userRepository;

    public UserBOImpl() {
        userRepository = (UserRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.USER);
    }

    @Override
    public boolean addUser(Users userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);

            Users user = new Users(
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullname(),
                    userDTO.getEmail()
            );

            boolean result = userRepository.save(user);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateUser(Users userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);

            Users user = new Users(
                    userDTO.getUserId(),
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullname(),
                    userDTO.getEmail()
            );

            userRepository.update(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);
            Users user = userRepository.findById(userId);
            if (user != null) {
                userRepository.delete(user);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Users getUserById(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);
            Users user = userRepository.findById(userId);
            session.getTransaction().commit();
            if (user != null) {
                return new Users(
                        user.getUsername(),
                        user.getPassword(),
                        user.getFullname(),
                        user.getEmail()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Users> getAllUsers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);
            List<Users> userList = userRepository.findAll();
            session.getTransaction().commit();

            if (userList != null) {
                ObservableList<Users> userDTOList = FXCollections.observableArrayList();
                for (Users user : userList
                ) {
                    userDTOList.add(
                            new Users(
                                    user.getUserId(),
                                    user.getUsername(),
                                    user.getPassword(),
                                    user.getFullname(),
                                    user.getEmail()
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
    public ObservableList<Users> getAllUsersById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Users", logic);
            Query query = session.createQuery(sqlQuery);
            List<Users> userList = query.list();

            if (userList != null) {
                ObservableList<Users> userDTOList = FXCollections.observableArrayList();
                System.out.println(userList);
                for (Users user : userList
                ) {
                    userDTOList.add(
                            new Users(
                                    user.getUserId(),
                                    user.getUsername(),
                                    user.getPassword(),
                                    user.getFullname(),
                                    user.getEmail()
                            )
                    );
                }
                return userDTOList;
            } else {
                return null;
            }
        }
    }

    public boolean checkPassword(String userName, String password) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            userRepository.setSession(session);
            List<Users> userList = userRepository.findAll();
            session.getTransaction().commit();

            if (userList != null) {
                for (Users user : userList
                ) {
                    if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
    }

}
