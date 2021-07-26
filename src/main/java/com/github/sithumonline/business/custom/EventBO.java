package com.github.sithumonline.business.custom;

import com.github.sithumonline.business.SuperBO;
import com.github.sithumonline.entity.Event;
import javafx.collections.ObservableList;


public interface EventBO extends SuperBO{

    boolean addEvent(Event eventDTO)throws Exception;

    boolean updateEvent(Event eventDTO)throws Exception;

    boolean deleteEvent(String eventId)throws Exception;

    Event getEventById(String eventId)throws Exception;

//  List<Events> getAllEvents()throws Exception;

    ObservableList<Event> getAllEvents()throws Exception;

    ObservableList<Event> getAllEventsById(String id) throws Exception;
}
