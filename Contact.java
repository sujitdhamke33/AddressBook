package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact
{
    List<Person> contactList=new ArrayList<>();

    Scanner sc=new Scanner(System.in);

    public void Addcontact()
    {
        Person person=new Person();

        System.out.println("Enter your First Name : ");
        String firstName=sc.next();
        person.setFirstName(firstName);

        System.out.println("Enter your Last Name : ");
        String lastName=sc.next();
        person.setLastName(lastName);

        System.out.println("Enter your Address :");
        String Address=sc.next();
        person.setAddress(Address);

        System.out.println("Enter your city : ");
        String city=sc.next();
        person.setCity(city);

        System.out.println("Enter your State :");
        String state=sc.next();
        person.setState(state);

        System.out.println("Enter your ZIP : ");
        String ZIP=sc.next();
        person.setZIP(ZIP);

        System.out.println("Enter your Phone Number :");
        String phone_Number=sc.next();
        person.setPhone_Number(phone_Number);

        System.out.println("Enter your city : ");
        String email=sc.next();
        person.setEmail(email);

        contactList.add(person);
        System.out.println(contactList);
    }

    public void Editcontact()
    {
        System.out.println("Enter your first Name : ");
        String firstName=sc.next();

        for(int i=0;i<contactList.size();i++)
        {
            Person person=contactList.get(i);// method dispatch
            int choicetoedit;
            if(person.getFirstName().equals(firstName))
            {
                System.out.println(" Enter to edit 1.lastName 2.Address 3.city 4.State 5.ZIP 6.phone Number 7.Email");
                choicetoedit = sc.nextInt();
                switch(choicetoedit)
                {
                    case 1 :
                        System.out.println("correct your last name :");
                        String lastName=sc.next();
                        person.setLastName(lastName);
                        break;

                    case 2 :
                        System.out.println("correct your Address :");
                        String Address=sc.next();
                        person.setAddress(Address);
                        break;

                    case 3 :
                        System.out.println("correct your city :");
                        String city=sc.next();
                        person.setCity(city);
                        break;

                    case 4 :
                        System.out.println("correct your state :");
                        String state=sc.next();
                        person.setState(state);
                        break;
                    case 5:

                        System.out.println("correct your ZIP code :");
                        String ZIP=sc.next();
                        person.setZIP(ZIP);
                        break;

                    case 6 :
                        System.out.println("correct your Phone No. :");
                        String  phone_Number=sc.next();
                        person.setPhone_Number(phone_Number);
                        break;

                    case 7 :
                        System.out.println("correct your Email :");
                        String Email=sc.next();
                        person.setEmail(Email);
                        break;
                }
            }
        }
    }

    public void Deletecontact()
    {
        System.out.println("Enter your first Name : ");
        String firstName=sc.next();
        for(int i=0;i<contactList.size();i++)
        {
            Person person=contactList.get(i);
            if(person.getFirstName().equals(firstName))
            {
                contactList.remove(i);
            }
        }
        System.out.println("Delete Sucessfully...");
        System.out.println(contactList);
    }
}