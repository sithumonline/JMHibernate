package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Person;
import javafx.collections.ObservableList;


public interface PersonBO extends SuperBO{

    boolean addPerson(Person personDTO)throws Exception;

    boolean updatePerson(Person personDTO)throws Exception;

    boolean deletePerson(String personId)throws Exception;

    Person getPersonById(String personId)throws Exception;

//  List<Persons> getAllPersons()throws Exception;

    ObservableList<Person> getAllPersons()throws Exception;

    ObservableList<Person> getAllPersonsById(String id) throws Exception;
}
