package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.CropCultivationBO;
import com.github.sithumonline.entity.CropCultivation;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.CropCultivationRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CropCultivationBOImpl implements CropCultivationBO {

    private CropCultivationRepository cropCultivationRepository;

    public CropCultivationBOImpl() {
        cropCultivationRepository = (CropCultivationRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.CROP);
    }

    @Override
    public boolean addCropCultivation(CropCultivation cropCultivationDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);

            CropCultivation cropCultivation = new CropCultivation(
                    cropCultivationDTO.getCropType(),
                    cropCultivationDTO.getNumberOfAcres(),
                    cropCultivationDTO.getNumberOfCultivators(),
                    cropCultivationDTO.getEstimatedFertilizer(),
                    cropCultivationDTO.getReceivedFertilize()
            );

            boolean result = cropCultivationRepository.save(cropCultivation);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateCropCultivation(CropCultivation cropCultivationDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);

            CropCultivation cropCultivation = new CropCultivation(
                    cropCultivationDTO.getId(),
                    cropCultivationDTO.getCropType(),
                    cropCultivationDTO.getNumberOfAcres(),
                    cropCultivationDTO.getNumberOfCultivators(),
                    cropCultivationDTO.getEstimatedFertilizer(),
                    cropCultivationDTO.getReceivedFertilize()
            );

            cropCultivationRepository.update(cropCultivation);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteCropCultivation(String cropCultivationId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);
            CropCultivation cropCultivation = cropCultivationRepository.findById(Integer.parseInt(cropCultivationId));
            if (cropCultivation != null) {
                cropCultivationRepository.delete(cropCultivation);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public CropCultivation getCropCultivationById(String cropCultivationId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);
            CropCultivation cropCultivation = cropCultivationRepository.findById(Integer.parseInt(cropCultivationId));
            session.getTransaction().commit();
            if (cropCultivation != null) {
                return new CropCultivation(
                        cropCultivation.getCropType(),
                        cropCultivation.getNumberOfAcres(),
                        cropCultivation.getNumberOfCultivators(),
                        cropCultivation.getEstimatedFertilizer(),
                        cropCultivation.getReceivedFertilize()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<CropCultivation> getAllCropCultivations() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);
            List<CropCultivation> cropCultivationList = cropCultivationRepository.findAll();
            session.getTransaction().commit();

            if (cropCultivationList != null) {
                ObservableList<CropCultivation> cropCultivationDTOList = FXCollections.observableArrayList();
                for (CropCultivation cropCultivation : cropCultivationList
                ) {
                    cropCultivationDTOList.add(
                            new CropCultivation(
                                    cropCultivation.getId(),
                                    cropCultivation.getCropType(),
                                    cropCultivation.getNumberOfAcres(),
                                    cropCultivation.getNumberOfCultivators(),
                                    cropCultivation.getEstimatedFertilizer(),
                                    cropCultivation.getReceivedFertilize()
                            )
                    );
                }
                return cropCultivationDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<CropCultivation> getAllCropCultivationsById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cropCultivationRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "CropCultivation", logic);
            Query query = session.createQuery(sqlQuery);
            List<CropCultivation> cropCultivationList = query.list();

            if (cropCultivationList != null) {
                ObservableList<CropCultivation> cropCultivationDTOList = FXCollections.observableArrayList();
                System.out.println(cropCultivationList);
                for (CropCultivation cropCultivation : cropCultivationList
                ) {
                    cropCultivationDTOList.add(
                            new CropCultivation(
                                    cropCultivation.getId(),
                                    cropCultivation.getCropType(),
                                    cropCultivation.getNumberOfAcres(),
                                    cropCultivation.getNumberOfCultivators(),
                                    cropCultivation.getEstimatedFertilizer(),
                                    cropCultivation.getReceivedFertilize()
                            )
                    );
                }
                return cropCultivationDTOList;
            } else {
                return null;
            }
        }
    }
}
