package user;

public class Profile {
    private String name;
    private String dateOfBirth;
    private String country;

    public Profile(String name, String dateOfBirth, String country) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public void updateProfile(String name, String dob, String country) {
        this.name = name;
        this.dateOfBirth = dob;
        this.country = country;
    }

    public String getProfileDetails() {
        return "Name: " + name + "\nDate of Birth: " + dateOfBirth + "\nCountry: " + country;
    }
}


