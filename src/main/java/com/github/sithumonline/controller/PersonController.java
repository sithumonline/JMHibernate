package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.PersonBO;
import com.github.sithumonline.entity.Person;
import javafx.collections.ObservableList;

public class PersonController {

    public static boolean addPerson(Person personDTO)throws Exception{
        PersonBO personService = (PersonBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.PERSON);
        return personService.addPerson(personDTO);
    }

    public static boolean updatePerson(Person personDTO)throws Exception{
        PersonBO personService = (PersonBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.PERSON);
        return personService.updatePerson(personDTO);
    }

    public static boolean deletePerson(String personId)throws Exception{
        PersonBO personService = (PersonBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.PERSON);
        return personService.deletePerson(personId);
    }

    public static ObservableList<Person> getPersonList()throws Exception{
        PersonBO personService = (PersonBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.PERSON);
        return personService.getAllPersons();
    }

    public static ObservableList<Person> getAllPersonsById(String id)throws Exception{
        PersonBO personService = (PersonBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.PERSON);
        return personService.getAllPersonsById(id);
    }
    
}
