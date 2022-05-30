import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 29.05.2022
 * \* ----- group JAVA-27 -----
 * \*
 * \* Description:  Домашнее задание к занятию 1.5 Клиент-серверное взаимодействие. Blocking и Non-Blocking IO.
 * \*
 * \* Задача 1. Тяжелые вычисления
 * \
 * Выбран способ взаимодействия IO, поскольку нам не нужны промежуточные данные,
 * нам нужен конечный результат.
 */

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 23444);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String number;
            while (true) {
                System.out.println("Введите целое число...(\"end\" для завершения программы)");
                number = scanner.nextLine();
                out.println(number);
                if ("end".equals(number)) break;
                System.out.println("SERVER: " + in.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
