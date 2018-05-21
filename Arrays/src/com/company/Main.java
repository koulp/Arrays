package com.company;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Mobile_Phone mobile_phone = new Mobile_Phone("0039 330 4404");

    public static void main(String[] args) {
//         Create a program that implements a simple mobile phone with the following capabilities.
//         Able to store, modify, remove and query contact names.
//         You will want to create a separate class for Contacts (name and phone number).
//         Create a master class (MobilePhone) that holds the ArrayList of Contacts
//         The MobilePhone class has the functionality listed above.
//         Add a menu of options that are available.
//         Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
//         and search/find contact.
//         When adding or updating be sure to check if the contact already exists (use name)
//         Be sure not to expose the inner workings of the Arraylist to MobilePhone
//         e.g. no ints, no .get(i) etc
//         MobilePhone should do everything with Contact objects only.

        boolean quit = false;
        startPhone();
        printMenu();
        while (!quit) {
            System.out.println("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobile_phone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContactByName();
                case 6:
                    printMenu();
                    break;
            }
        }

    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void addNewContact() {
        System.out.println("Type the Name of the Contact You Want to Add");
        String name = scanner.nextLine();

        System.out.println("Type the Phone Number of the Contact");
        int phone = scanner.nextInt();
        Contact newContact = Contact.createContact(name, phone);
        if(mobile_phone.addNewContact(newContact)) {
            System.out.println("New Contact added: name = " + name + ", phone = " + phone);
        }else
            System.out.println("Cannot add, " + name + " already on file");
    }

    private static void updateContact() {
        System.out.println("Type the Name of the Contact You Want to Update");
        String name = scanner.nextLine();

        Contact existingContact = mobile_phone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Now Type the New Name");
        String newName = scanner.nextLine();
        System.out.println("Now Type the phone number");
        int newNumber = scanner.nextInt();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobile_phone.updateContact(existingContact, newContact)){
            System.out.println("Successfully updated record");
        }else{
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Type the Name of the Contact You Want to Remove");
        String name = scanner.nextLine();

        Contact existingContact = mobile_phone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }

        if(mobile_phone.removeContact(existingContact)){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Error deleting contact");
        }
    }

    public static void searchContactByName(){
        System.out.println("Type the Name of the Contact You Want to Search");
        String name = scanner.nextLine();

        Contact existingContact = mobile_phone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + ", phone number is " + existingContact.getPhoneNumber());
    }

    public static void printMenu(){
        System.out.println("\nAvailable actions:\nPress:");
        System.out.println( "0  - to shutdown\n" +
                            "1  - to print contacts\n" +
                            "2  - to add a new contact\n" +
                            "3  - to update an existing contact\n" +
                            "4  - to remove an existing contact\n" +
                            "5  - query if an existing contact exists\n" +
                            "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

//    public static void quit(){
//        System.exit(0);
//    }

//    public  static int[] getIntegers(int number){
//
//        System.out.println("Enter " + number + " integer values.\r");
//
//        int[] values = new int[number];
//
//        for(int i=0; i<values.length; i++) {
//            values[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(values);
//        return values;
//    }
 }
