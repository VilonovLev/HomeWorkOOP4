package com.company;

import controller.ControllerImpl;

import java.util.Scanner;

public class App {
    public void run() {
        ControllerImpl controller = new ControllerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");

        while (true) {
            System.out.println(" 0 - Показать все события \n 1 - Добавить событие " +
                    "\n 2 - сохранить все события \n 3 - загрузить события");
            switch (Integer.parseInt(scanner.nextLine())){
                case 0: {controller.showAll(); break;}
                case 1: {controller.add(); break;}
                case 2: {controller.save(); break;}
                case 3: {controller.load(); break;}
                default: break;
            }
        }

    }
}
