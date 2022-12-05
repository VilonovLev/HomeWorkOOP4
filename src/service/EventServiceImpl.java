package service;

import data.Event;
import util.ReadFromJson;
import util.WriteToJson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

public class EventServiceImpl implements EventService<Event>{
    private ArrayList<Event> eventsArrayList = new ArrayList<>();
    Logger logger = Logger.getAnonymousLogger();

    @Override
    public void createEvent(String eventName, LocalDateTime deadline, String authorName) {
        if (eventName.length() > 0 && authorName.length() > 0 && deadline.isAfter(LocalDateTime.now())) {
            eventsArrayList.add(Event.createEvent(eventName, deadline, authorName));
        } else {
            logger.info("Input error");
        }
    }

    public ArrayList<Event> getEvents() {
        return eventsArrayList;
    }

    public void setEventsArrayList(ArrayList<Event> eventsArrayList) {
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public void readEvent(String fileName) {
        eventsArrayList = ReadFromJson.read(fileName);
    }

    @Override
    public void writeEvent(String fileName) {
        WriteToJson.write(fileName,eventsArrayList);
    }

    @Override
    public void showAllEvent() {
        for (var event:eventsArrayList) {
            System.out.println(event);
        }
    }
}
