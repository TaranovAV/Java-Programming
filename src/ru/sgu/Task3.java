package ru.sgu;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task3 {
    public static void start() {

        int lineNumber = 0;

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNextLine()) {
                lineNumber++;
                String[] str = scanner.nextLine().split(" ");
                if (str[0].isEmpty())  {
                    System.out.print(lineNumber + ") Ошибка - пустая строка.\n");
                    continue;
                }
                if (str.length < 3) {
                    System.out.println(lineNumber + ") Ошибка - в строке меньше 3 последовательностей символов.");
                    continue;
                }

                boolean error = false;
                for (int i = 0; i < 3; i++) {
                    String line = str[i];
                    for (int z = 0; z < line.length(); z++) {
                        char c = line.charAt(z);
                        if (Character.isDigit(c) || Character.getType(c) == Character.DASH_PUNCTUATION ||
                                Character.getType(c) == Character.START_PUNCTUATION ||
                                Character.getType(c) == Character.END_PUNCTUATION ||
                                Character.getType(c) == Character.CONNECTOR_PUNCTUATION ||
                                Character.getType(c) == Character.OTHER_PUNCTUATION)
                            error = true;
                    }
                }

                if (error)
                    System.out.println(lineNumber + ") Ошибка - есть постороние символы в предполагаемом ФИО.");
                else {
                    System.out.println(lineNumber + ") " + str[1] + " " + str[0].charAt(0) +
                            "." + str[2].charAt(0) + ".");
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Файл input.txt не найден.");
        }
    }
}
