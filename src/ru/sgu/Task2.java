package ru.sgu;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
    private Day today;
    private Integer addDays;

    enum Day {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday;

        public Day calcDay(int days) {
            int newIndex = (ordinal() + (days % values().length) + values().length) % values().length;
            return values()[newIndex];
        }
    }

    public Task2() {
        System.out.println("Введите день недели и число:");
        try (Scanner scanner = new Scanner(System.in)) {
            String weekday = scanner.next().toLowerCase();
            this.addDays = scanner.nextInt();
            this.addDays = (this.addDays % 7 + 7) % 7;
            this.today = Day.valueOf(weekday);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void start() {
        if (this.today == null || this.addDays == null) {
            System.out.println("Нет значения для текущего дня и (или) количества дней.");
            return;
        }
        System.out.println(today.calcDay(this.addDays));
    }
}
