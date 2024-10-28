package user;

import java.util.Scanner;

public class Profile implements ProfileInterface{
    private String name;
    private String dateOfBirth;
    private String country;
    public static Profile profileUser1 = new Profile("Fiona", "1999-04-17", "TW");
    public static Profile profileUser2 = new Profile("East Wang", "1998-12-02", "US");

    public Profile(String name, String dateOfBirth, String country) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public Profile(){

    }

    public void updateProfile(String name, String dob, String country) {
        this.name = name;
        this.dateOfBirth = dob;
        this.country = country;
    }

    public String getProfileDetails() {
        return "Name: " + name + "\nDate of Birth: " + dateOfBirth + "\nCountry: " + country;
    }


    public void manageProfiles(Scanner scanner){

        System.out.println("1. Update Profile");
        System.out.println("2. See my Profile");
        System.out.print("Select an option: ");
        int profileChoice = scanner.nextInt();
        scanner.nextLine();

        if (profileChoice == 1) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new date of birth (YYYY-MM-DD):");
            String newDOB = scanner.nextLine();
            System.out.println("Enter new country:");
            String newCountry = scanner.nextLine();

            User.user1.getProfile().updateProfile(newName, newDOB, newCountry);
            System.out.println("Profile updated successfully.");
        }
        else if (profileChoice == 2) {
            System.out.println(User.user1.getProfile().getProfileDetails());
        }
    }
}


