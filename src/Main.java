import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String TELEPHONE_BOOK_TXT = "./res/telephone_book.txt";
    public static void main(String[]args) throws IOException {
        List<Contact> contacts =loadContacts();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String choice;
            do {
                System.out.println("Желаете добавить контакт? да/нет");
                choice = reader.readLine().trim();
                if (choice.equalsIgnoreCase("да")) {
                    System.out.println("Введите имя");
                    String firstName = reader.readLine().trim();
                    System.out.println("Введите фамилию");
                    String lastName = reader.readLine().trim();
                    System.out.println("Введите номер");
                    String phone = reader.readLine().trim();
                    Contact contact = new Contact(firstName,lastName,phone);
                    contacts.add(contact);
                }
            }
            while (!choice.equalsIgnoreCase("нет"));

        } catch (IOException e){
            e.printStackTrace();
        }
        saveContacts(contacts);
    }

    private static List<Contact> loadContacts()throws IOException {
        List<Contact>contacts= new ArrayList<>();
        BufferedReader reader= new BufferedReader((new FileReader(TELEPHONE_BOOK_TXT)));
        String line;
        while ((line= reader.readLine())!=null) {
            String[] parts = line.split(",");
            String firstName = parts[0].trim();
            String lastName = parts[1].trim();
            String phone = parts[2].trim();

            Contact contact = new Contact(firstName,lastName,phone);
            contacts.add(contact);
        }
        reader.close();
        return contacts;
    }
}