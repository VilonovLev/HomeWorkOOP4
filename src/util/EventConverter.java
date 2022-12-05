package util;

import com.google.gson.*;
import data.Event;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventConverter implements JsonSerializer<ArrayList<Event>>, JsonDeserializer<ArrayList<Event>> {

    @Override
    public JsonElement serialize(ArrayList<Event> events,
                                 Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray jsonObject = new JsonArray();
        for (var event : events) {
            jsonObject.add(serialize(event));
        }
        return jsonObject;
    }

    public JsonElement serialize(Event event) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", event.getIdEvent());
        jsonObject.addProperty("eventName", event.getEventName());
        jsonObject.addProperty("createEvent", event.getCreateEvent().toString());
        jsonObject.addProperty("deadline", event.getDeadline().toString());
        jsonObject.addProperty("authorEvent", event.getAuthorName());
        jsonObject.addProperty("priorityEnum", event.getPriorityEnum().toString());
        return jsonObject;
    }

    @Override
    public ArrayList<Event> deserialize(JsonElement jsonElement,
                                        Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        ArrayList<Event> events = new ArrayList<>();
        if (jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                events.add(deserialize(jsonArray.get(i)));
            }
        }
        return events;
    }


    public Event deserialize(JsonElement jsonElement) throws JsonParseException {
        Event event = new Event();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        event.setIdEvent(jsonObject.get("id").getAsLong());
        event.setEventName(jsonObject.get("eventName").getAsString());
        event.setCreateEvent(LocalDateTime.parse(jsonObject.get("createEvent").getAsString()));
        event.setDeadline(LocalDateTime.parse(jsonObject.get("deadline").getAsString()));
        event.setAuthorName(jsonObject.get("authorEvent").getAsString());
        event.setPriorityEnum(Event.Priority.valueOf(jsonObject.get("priorityEnum").getAsString()));
        return event;
    }

}
