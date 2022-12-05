package service;

import data.Event;

import java.time.LocalDateTime;

public interface EventService<E extends Event> {
    void createEvent(String eventName, LocalDateTime localDateTime,String authorName);

    void readEvent(String fileName);

    void writeEvent(String fileName);

    void showAllEvent();
}
