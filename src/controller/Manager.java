package controller;

import common.Library;
import java.util.ArrayList;
import model.Contact;
import view.Menu;

public class Manager extends Menu {
    
    ArrayList<Contact> list_C = new ArrayList<>();
    Library l;

    public Manager(String td, String[] mc,String exit) {
        super(td,mc,exit);
        l = new Library();
        list_C = new ArrayList<>();
        
        list_C.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        list_C.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        list_C.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createContact();
                break;
            case 2:
                printAllContact();
                break;
            case 3:
                deleteContactd();
                break;
            case 4:
                System.exit(0);
        }
    }
    //allow user create contact
    public void createContact() {
        int contactID = generateID();
        System.out.print("Enter first name: ");
        String firstName = l.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = l.checkInputString();
        System.out.print("Enter group: ");
        String group = l.checkInputString();
        System.out.print("Enter address: ");
        String address = l.checkInputString();
        System.out.print("Enter phone: ");
        String phone = l.checkInputPhone();
        list_C.add(new Contact(contactID, firstName + " " + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    //allow user display all contact
    public void printAllContact() {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (Contact contact : list_C) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    //allow user delete contact
    public void deleteContactd() {
        System.out.print("Enter id: ");
        int idDelete = l.checkInputInt();
        Contact contactDelete = getContactById(list_C, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            list_C.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
    public int generateID() {
        int id = 0;
        if (list_C.isEmpty()) {
            return 1;
        } else {
            for (Contact s : list_C) {
                if (s.getContactId() == list_C.size()) {
                    id = s.getContactId() + 1;
                }
            }
        }
        return id;
    }
}
