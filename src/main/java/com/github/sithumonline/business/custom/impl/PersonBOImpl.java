package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.PersonBO;
import com.github.sithumonline.entity.Person;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.PersonRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonBOImpl implements PersonBO {

    private PersonRepository personRepository;

    public PersonBOImpl() {
        personRepository = (PersonRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.PERSON);
    }

    @Override
    public boolean addPerson(Person personDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);

            Person person = new Person(
                    personDTO.getName(),
                    personDTO.getNic(),
                    personDTO.getGender(),
                    personDTO.getAddress(),
                    personDTO.getEmploymentStats()
            );

            boolean result = personRepository.save(person);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updatePerson(Person personDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);

            Person person = new Person(
                    personDTO.getId(),
                    personDTO.getName(),
                    personDTO.getNic(),
                    personDTO.getGender(),
                    personDTO.getAddress(),
                    personDTO.getEmploymentStats()
            );

            personRepository.update(person);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deletePerson(String personId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);
            Person person = personRepository.findById(Integer.parseInt(personId));
            if (person != null) {
                personRepository.delete(person);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Person getPersonById(String personId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);
            Person person = personRepository.findById(Integer.parseInt(personId));
            session.getTransaction().commit();
            if (person != null) {
                return new Person(
                        person.getName(),
                        person.getNic(),
                        person.getGender(),
                        person.getAddress(),
                        person.getEmploymentStats()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Person> getAllPersons() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);
            List<Person> personList = personRepository.findAll();
            session.getTransaction().commit();

            if (personList != null) {
                ObservableList<Person> personDTOList = FXCollections.observableArrayList();
                for (Person person : personList
                ) {
                    personDTOList.add(
                            new Person(
                                    person.getId(),
                                    person.getName(),
                                    person.getNic(),
                                    person.getGender(),
                                    person.getAddress(),
                                    person.getEmploymentStats()
                            )
                    );
                }
                return personDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Person> getAllPersonsById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            personRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Person", logic);
            Query query = session.createQuery(sqlQuery);
            List<Person> personList = query.list();

            if (personList != null) {
                ObservableList<Person> personDTOList = FXCollections.observableArrayList();
                System.out.println(personList);
                for (Person person : personList
                ) {
                    personDTOList.add(
                            new Person(
                                    person.getId(),
                                    person.getName(),
                                    person.getNic(),
                                    person.getGender(),
                                    person.getAddress(),
                                    person.getEmploymentStats()
                            )
                    );
                }
                return personDTOList;
            } else {
                return null;
            }
        }
    }
}
