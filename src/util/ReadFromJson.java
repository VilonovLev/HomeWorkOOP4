package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Event;

import java.util.ArrayList;

public class ReadFromJson {
    public static ArrayList<Event> read(String fileName) {
        String string = ReadFromTxt.read(fileName);
        ArrayList<Event> events = new ArrayList<>();
        Gson builder = new GsonBuilder().registerTypeAdapter(ArrayList.class,new EventConverter()).create();
        events = builder.fromJson(string,ArrayList.class);
        return events;
    }
}
