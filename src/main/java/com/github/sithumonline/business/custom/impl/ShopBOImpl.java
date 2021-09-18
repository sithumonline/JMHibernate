package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.ShopBO;
import com.github.sithumonline.entity.Shops;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.ShopRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ShopBOImpl implements ShopBO {

    private ShopRepository shopRepository;

    public ShopBOImpl() {
        shopRepository = (ShopRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.SHOP);
    }

    @Override
    public boolean addShop(Shops shopDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);

            Shops shop = new Shops(
                    shopDTO.getName(),
                    shopDTO.getRegistrationNumber(),
                    shopDTO.getOwnersName(),
                    shopDTO.getAddress(),
                    shopDTO.getType()
            );

            boolean result = shopRepository.save(shop);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateShop(Shops shopDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);

            Shops shop = new Shops(
                    shopDTO.getId(),
                    shopDTO.getName(),
                    shopDTO.getRegistrationNumber(),
                    shopDTO.getOwnersName(),
                    shopDTO.getAddress(),
                    shopDTO.getType()
            );

            shopRepository.update(shop);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteShop(String shopId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);
            Shops shop = shopRepository.findById(Integer.parseInt(shopId));
            if (shop != null) {
                shopRepository.delete(shop);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Shops getShopById(String shopId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);
            Shops shop = shopRepository.findById(Integer.parseInt(shopId));
            session.getTransaction().commit();
            if (shop != null) {
                return new Shops(
                        shop.getName(),
                        shop.getRegistrationNumber(),
                        shop.getOwnersName(),
                        shop.getAddress(),
                        shop.getType()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Shops> getAllShops() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);
            List<Shops> shopList = shopRepository.findAll();
            session.getTransaction().commit();

            if (shopList != null) {
                ObservableList<Shops> shopDTOList = FXCollections.observableArrayList();
                for (Shops shop : shopList
                ) {
                    shopDTOList.add(
                            new Shops(
                                    shop.getId(),
                                    shop.getName(),
                                    shop.getRegistrationNumber(),
                                    shop.getOwnersName(),
                                    shop.getAddress(),
                                    shop.getType()
                            )
                    );
                }
                return shopDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Shops> getAllShopsById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            shopRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Shops", logic);
            Query query = session.createQuery(sqlQuery);
            List<Shops> shopList = query.list();

            if (shopList != null) {
                ObservableList<Shops> shopDTOList = FXCollections.observableArrayList();
                System.out.println(shopList);
                for (Shops shop : shopList
                ) {
                    shopDTOList.add(
                            new Shops(
                                    shop.getId(),
                                    shop.getName(),
                                    shop.getRegistrationNumber(),
                                    shop.getOwnersName(),
                                    shop.getAddress(),
                                    shop.getType()
                            )
                    );
                }
                return shopDTOList;
            } else {
                return null;
            }
        }
    }
}
