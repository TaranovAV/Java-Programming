package ru.sgu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Задание 2\s
                1) Задача с датами\s
                2) Задача с днями недели\s
                3) Задача со строкой\s
                4) Выход из программы""");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число от 1 до 3 для выбора задания, 4 для выхода:");

        while (true) {
            System.out.println();
            if (in.hasNext()) {
                String choice = in.next();

                switch (choice) {
                    case "1":
                        Task1 task1 = new Task1();
                        task1.start();
                        break;
                    case "2":
                        Task2 task2 = new Task2();
                        task2.start();
                        break;
                    case "3":
                        Task3 task3 = new Task3();
                        task3.start();
                        in.close();
                        return;
                    case "4":
                        System.out.println("Выход...");
                        in.close();
                        return;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                }
            } else {
                System.out.println("Завершение программы.");
                in.close();
                return;
            }
        }
    }
}