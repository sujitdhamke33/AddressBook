package AddressBook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManager {
    static Map<String, Contact> AddressBooks = new HashMap<>();
    static Map<String, List<String>> citys = new HashMap<>();
    static Map<String, String> states = new HashMap<String, String>();
    static Contact contact = new Contact();
    static Person person = new Person();
    static Scanner sc = new Scanner(System.in);

    public static void addAddressBook(String addressBookname) {
        if (AddressBooks.containsKey(addressBookname)) {
            System.out.println("Address Book with name " + addressBookname + " Already Present.");
        } else {
            AddressBooks.put(addressBookname, contact);
            System.out.println("Sucessfully added Address Book with Name " + addressBookname);
        }
    }

    public static void useAddressbook(String addressBookname) {
        contact = AddressBooks.get(addressBookname);
        if (contact == null) {
            System.out.println("Address Book with name " + addressBookname + " not found");
            return;
        }


        int choice;

        do {
            System.out.println("0.Exit 1.Add contact 2.Edit Contact 3.Delete Contact 4.Show All Contact");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting Address Book " + addressBookname + "...");
                    sc.close();
                    break;

                case 1:
                    contact.Addcontact();
                    break;

                case 2:
                    contact.Editcontact();
                    break;

                case 3:
                    contact.Deletecontact();
                    break;

                case 4:
                    contact.showAllcontact();
                    break;

                case 5:
                    System.out.println("Enter the state : ");
                    String state = sc.next();
                    searchState(AddressBooks, state);
                    break;

                case 6:
                    System.out.println("Enter the city : ");
                    String city = sc.next();
                    searchCity(AddressBooks, city);
                    break;

                default:
                    System.out.println("Invalid Choice...");
                    break;
            }
        } while (choice != 0);
    }

    private static void searchCity(Map<String, Contact> addressBooks, String city) {
        for (String addressBookname : addressBooks.keySet()) {
            Contact contact = addressBooks.get(addressBookname);
            List<Person> searchbyCity = contact.searchbyCity(city);
            if (!searchbyCity.isEmpty()) {
                System.out.println("Contacts in city : " + city + " in address Book " + addressBookname + "\n");
            } else {
                System.out.println("There is no any person with" + city + " you entered");
            }

            for (Person person : searchbyCity) {
                System.out.println(" First Name is : " + person.getFirstName());
                System.out.println(" Last Name is : " + person.getLastName());
                System.out.println(" Address is : " + person.getAddress());
                System.out.println(" City is : " + person.getCity());
                System.out.println(" State is : " + person.getState());
                System.out.println(" ZIP code is : " + person.getZIP());
                System.out.println(" Phone Number is : " + person.getPhone_Number());
                System.out.println(" Email is : " + person.getEmail());
                System.out.println("------------------------------------------------------------------------------------");
            }
        }
    }

    private static void searchState(Map<String, Contact> addressBooks, String state) {
        for (String addressBookname : addressBooks.keySet()) {
            Contact contact = addressBooks.get(addressBookname);
            List<Person> searchbystate = contact.searchbyState(state);

            if (!searchbystate.isEmpty()) {
                System.out.println("Contacts in state : " + state + " in addresss Book " + addressBookname + "\n");

                for (Person person : searchbystate) {
                    System.out.println(" First Name is : " + person.getFirstName());
                    System.out.println(" Last Name is : " + person.getLastName());
                    System.out.println(" Address is : " + person.getAddress());
                    System.out.println(" City is : " + person.getCity());
                    System.out.println(" State is : " + person.getState());
                    System.out.println(" ZIP code is : " + person.getZIP());
                    System.out.println(" Phone Number is : " + person.getPhone_Number());
                    System.out.println(" Email is : " + person.getEmail());
                    System.out.println("  #####################################################################-");
                }
            } else {
                System.out.println("There is no any person with state you entered");
            }
            states.put(state,state);
            System.out.println("State is :" + states);

        }
    }
}
