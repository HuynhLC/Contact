
import controller.Manager;

public class Main {

    public static void main(String[] args) {
        String mChon[] = {"Add a contact.","Display all contact.","Delete a contact."};
        Manager c = new Manager("Enter your choice: ",mChon , "Exit.");
        c.run();
    }
}
