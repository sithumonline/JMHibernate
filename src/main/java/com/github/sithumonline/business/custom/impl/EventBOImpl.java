package com.github.sithumonline.business.custom.impl;

import com.github.sithumonline.business.custom.EventBO;
import com.github.sithumonline.entity.Event;
import com.github.sithumonline.repository.RepositoryFactory;
import com.github.sithumonline.repository.custom.EventRepository;
import com.github.sithumonline.resources.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EventBOImpl implements EventBO {

    private EventRepository eventRepository;

    public EventBOImpl() {
        eventRepository = (EventRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.EVENT);
    }

    @Override
    public boolean addEvent(Event eventDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);

            Event event = new Event(
                    eventDTO.getName(),
                    eventDTO.getVenue(),
                    eventDTO.getDate(),
                    eventDTO.getOrganizer(),
                    eventDTO.getNumberOfSponsorships()
            );

            boolean result = eventRepository.save(event);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateEvent(Event eventDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);

            Event event = new Event(
                    eventDTO.getId(),
                    eventDTO.getName(),
                    eventDTO.getVenue(),
                    eventDTO.getDate(),
                    eventDTO.getOrganizer(),
                    eventDTO.getNumberOfSponsorships()
            );

            eventRepository.update(event);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteEvent(String eventId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);
            Event event = eventRepository.findById(Integer.parseInt(eventId));
            if (event != null) {
                eventRepository.delete(event);
                session.flush();
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Event getEventById(String eventId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);
            Event event = eventRepository.findById(Integer.parseInt(eventId));
            session.getTransaction().commit();
            if (event != null) {
                return new Event(
                        event.getName(),
                        event.getVenue(),
                        event.getDate(),
                        event.getOrganizer(),
                        event.getNumberOfSponsorships()
                );
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Event> getAllEvents() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);
            List<Event> eventList = eventRepository.findAll();
            session.getTransaction().commit();

            if (eventList != null) {
                ObservableList<Event> eventDTOList = FXCollections.observableArrayList();
                for (Event event : eventList
                ) {
                    eventDTOList.add(
                            new Event(
                                    event.getId(),
                                    event.getName(),
                                    event.getVenue(),
                                    event.getDate(),
                                    event.getOrganizer(),
                                    event.getNumberOfSponsorships()
                            )
                    );
                }
                return eventDTOList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ObservableList<Event> getAllEventsById(String logic) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            eventRepository.setSession(session);
            String sqlQuery = String.format("SELECT ur FROM %s ur WHERE %s", "Event", logic);
            Query query = session.createQuery(sqlQuery);
            List<Event> eventList = query.list();

            if (eventList != null) {
                ObservableList<Event> eventDTOList = FXCollections.observableArrayList();
                System.out.println(eventList);
                for (Event event : eventList
                ) {
                    eventDTOList.add(
                            new Event(
                                    event.getId(),
                                    event.getName(),
                                    event.getVenue(),
                                    event.getDate(),
                                    event.getOrganizer(),
                                    event.getNumberOfSponsorships()
                            )
                    );
                }
                return eventDTOList;
            } else {
                return null;
            }
        }
    }
}
