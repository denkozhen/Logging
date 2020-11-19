package sample;


import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.Scanner;

public class Log {

    public static Scanner scan = new Scanner(System.in);

    public static class initLogger {
    }
        private static Logger logger;
        static {
            try(FileInputStream configFile = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Loging\\src\\sample\\logger_config")){
                LogManager.getLogManager().readConfiguration(configFile);
                logger = Logger.getLogger(initLogger.class.getName());
            }   catch (Exception ignore){
                ignore.printStackTrace();
            }
        }


    public static void main(String[] args) {

        logger.log(Level.INFO, "Начало работы программы, объявление переменных");
        int a = 0;
        int b = 0;
        int c = 0;
        int max = 0;
        int result;

        int n = scan.nextInt();
        logger.log(Level.INFO, "Старт работы цикла с предусловием");
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if (x % 33 == 0 && x > c) {
                a= c;
            }
            else {
                if (x % 11 > a){
                    a = x;
                }
                if (x % 3 == 0 && x > b) {
                    b = x;
                }
                if (x % 11 == 0 && x > c) {
                    c = x;
                }
            }
            if (c > max) {
                max = c;
            }
            if (n > max) {
                max = n;
            }
            logger.log(Level.INFO, "Объявление новой переменной f");
            int f = scan.nextInt();
            logger.log(Level.INFO, "Вычисление максимального значения");
            result = Math.max(a * b, c * max);

            System.out.println("Вычисленное контрольное значение:" + result);
            logger.log(Level.INFO, "Проверка значений + вариативный вывод");
            if (f == result) {
                System.out.println("Контроль пройден");
            }
            else System.out.println("Контроль не пройден");

        }
    }
}


