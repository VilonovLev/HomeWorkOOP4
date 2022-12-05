package data;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class Event implements Iterator<String> {
    public enum Priority {LOW, MIDDLE, HIGH}

    private static long countEvents;

    private long idEvent;
    private String eventName;
    private LocalDateTime createEvent;
    private LocalDateTime deadline;
    private String authorName;
    private Enum<Priority> priorityEnum;

    static {
        countEvents = 0;
    }

    public Event(){
    }

    private Event(String eventName, LocalDateTime createEvent, LocalDateTime deadline, String authorName, Enum<Priority> priorityEnum) {
        countEvents++;
        this.idEvent = countEvents;
        this.eventName = eventName;
        this.createEvent = createEvent;
        this.deadline = deadline;
        this.authorName = authorName;
        this.priorityEnum = priorityEnum;
    }

    public static Event createEvent(String eventName, LocalDateTime deadline, String authorName) {
        return new Event(eventName,LocalDateTime.now(),deadline,authorName,Priority.LOW);
    }

    public void setIdEvent(long idEvent) {
        this.idEvent = idEvent;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCreateEvent(LocalDateTime createEvent) {
        this.createEvent = createEvent;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setPriorityEnum(Enum<Priority> priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    public long getIdEvent() {
        return idEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getCreateEvent() {
        return createEvent;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Enum<Priority> getPriorityEnum() {
        return priorityEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return idEvent == event.idEvent &&
                eventName.equals(event.eventName) &&
                createEvent.equals(event.createEvent) &&
                deadline.equals(event.deadline) &&
                authorName.equals(event.authorName) &&
                priorityEnum.equals(event.priorityEnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, eventName, createEvent, deadline, authorName, priorityEnum);
    }

    private int indexIter = 0;

    @Override
    public boolean hasNext() {
        return (indexIter++ < 5);
    }

    @Override
    public String next() {
        return switch (indexIter) {
            case 0: yield  String.valueOf(getIdEvent());
            case 1: yield  this.getEventName();
            case 2: yield  createEvent.toString();
            case 3: yield  deadline.toString();
            case 4: yield  this.getAuthorName();
            case 5: yield  this.getPriorityEnum().toString();
            default: yield  this.getClass().toString();
        };
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", eventName='" + eventName + '\'' +
                ", createEvent=" + createEvent +
                ", deadline=" + deadline +
                ", authorName='" + authorName + '\'' +
                ", priorityEnum=" + priorityEnum +
                '}';
    }
}
