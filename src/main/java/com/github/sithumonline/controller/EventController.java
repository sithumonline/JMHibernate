package com.github.sithumonline.controller;

import com.github.sithumonline.business.BOFactory;
import com.github.sithumonline.business.custom.EventBO;
import com.github.sithumonline.entity.Event;
import javafx.collections.ObservableList;

public class EventController {

    public static boolean addEvent(Event eventDTO)throws Exception{
        EventBO eventService = (EventBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.EVENT);
        return eventService.addEvent(eventDTO);
    }

    public static boolean updateEvent(Event eventDTO)throws Exception{
        EventBO eventService = (EventBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.EVENT);
        return eventService.updateEvent(eventDTO);
    }

    public static boolean deleteEvent(String eventId)throws Exception{
        EventBO eventService = (EventBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.EVENT);
        return eventService.deleteEvent(eventId);
    }

    public static ObservableList<Event> getEventList()throws Exception{
        EventBO eventService = (EventBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.EVENT);
        return eventService.getAllEvents();
    }

    public static ObservableList<Event> getAllEventsById(String id)throws Exception{
        EventBO eventService = (EventBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.EVENT);
        return eventService.getAllEventsById(id);
    }
    
}
