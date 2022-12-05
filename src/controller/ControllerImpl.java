package controller;

import service.EventServiceImpl;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ControllerImpl implements Controller{
    EventServiceImpl eventService = new EventServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Год:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Месяц (1-12):");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("День месяца:");
        int dayOfMonth = Integer.parseInt(scanner.nextLine());
        System.out.println("Час:");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.println("Минуты:");
        int minute = Integer.parseInt(scanner.nextLine());
        LocalDateTime deadline = LocalDateTime.of(year,month,dayOfMonth,hour,minute);
        System.out.println("Название события:");
        String eventName = scanner.nextLine();
        System.out.println("Имя автора:");
        String authorName = scanner.nextLine();
        eventService.createEvent(eventName,deadline,authorName);
    }

    @Override
    public void showAll() {
        eventService.showAllEvent();
    }

    @Override
    public void save() {
        eventService.writeEvent("json.json");
    }

    @Override
    public void load() {
        eventService.readEvent("json.json");
    }
}
