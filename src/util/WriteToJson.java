package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Event;

import java.util.ArrayList;

public class WriteToJson {
    public static void write(String fileName, ArrayList<Event> eventsArrayList) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(ArrayList.class, new EventConverter());
        Gson gson = builder.create();
        String string = gson.toJson(eventsArrayList);
        WriteToFile.write(string,fileName);
    }
}
