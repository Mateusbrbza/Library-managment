package Library;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    public Admin(String name, String phoneNumber, String email) {
        super(name, email, phoneNumber);
    }

    @Override
    public void menu() {
        System.out.println("1. View Books");
        System.out.println("2. Add Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search Book");
        System.out.println("5. Delete all data");
        System.out.println("6. Exit");

    }
}
