package Library;

import java.util.Scanner;

public class Main {
    static Scanner s;
    static Database database;

    public static void main(String[] args) {
        database = new Database();
        System.out.println("Welcome to LMS!");

        int num;
        do {
            System.out.println("0. Exit\n" + "1.Login\n2. New User");
            s = new Scanner(System.in);
            num = s.nextInt();

            switch (num) {
                case 1:
                    login();
                    break;
                case 2:
                    newUser();
                    break;
            }
        } while (num != 0);
    }

    private static void login() {
        System.out.println("Enter phone number: ");
        String phoneNumber = s.next();
        System.out.println("Enter Email: ");
        String email = s.next();

        int n = database.login(phoneNumber, email);

        if (n != -1) {
            User user = database.getUser(n);
            user.menu();
        } else {
            System.out.println("User doesn't exist!");
            return;
        }
    }

    private static void newUser() {
        System.out.println("Enter name: ");
        String name = s.next();

        System.out.println("Enter email: ");
        String email = s.next();

        System.out.println("Enter phone number: ");
        String phoneNumber = s.next();

        System.out.println("1. Admin\n2. Normal User");
        int n2 = s.nextInt();

        User user;

        if (n2 == 1) {
            user = new Admin(name, email, phoneNumber);
        } else {
            user = new NormalUser(name, email, phoneNumber);
        }
        database.AddUser(user);

        user.menu();
    }
}
