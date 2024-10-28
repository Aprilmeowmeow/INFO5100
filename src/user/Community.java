package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Community implements CommunityInterface {
    private String commuName;
    private String type;  // Family, Friends, Work, etc.
    private List<String> members;
    private String language;
    private String region;
    public static Community miamiCampus = new Community("Miami Campus", "Work", "English", "USA");
    public static Community infoCommunity = new Community("NEU IS Community", "student", "English", "USA");

    public Community(String commuName, String type, String language, String region) {
        this.commuName = commuName;
        this.type = type;
        this.language = language;
        this.region = region;
        this.members = new ArrayList<>();
    }

    public Community() {
        this.members = new ArrayList<>();
    }

    @Override
    public void addMember(String user) {
        members.add(user);
        System.out.println(user + " added to the " + commuName + " community.");
    }

    @Override
    public void removeMember(String user) {
        if (members.contains(user)) {
            members.remove(user);
            System.out.println(user + " removed from the " + commuName + " community.");
        } else {
            System.out.println(user + " is not in the community.");
        }
    }

    public void manageCommunity(Scanner scanner) {
        System.out.println("-----Management Community-----");
        System.out.println("1. add member to community");
        System.out.println("2. remove member from community");
        System.out.println("3. return to menu");
        System.out.println("Input selection: ");

        int communityChoice = scanner.nextInt();
        scanner.nextLine();

        if (communityChoice == 1) {
            System.out.println("Enter Community you want to add member: ");
            System.out.println("1. Miami Campus");
            System.out.println("2. NEU IS Community");
            System.out.println("3. Enter Community option to add member:");
            int commuChoice = scanner.nextInt();
            scanner.nextLine();
            if (commuChoice == 1) {//not yet to the direct community
                System.out.println("Enter member name to add member to community: ");
                addMember(scanner.nextLine());
            }
            else if(commuChoice == 2) {
                System.out.println("Enter member name to add member to community: ");
                addMember(scanner.nextLine());
            }

        }
        else if (communityChoice == 2) {
            System.out.println("Enter member name to remove member from community: ");
            removeMember(scanner.nextLine());
        }
        else if (communityChoice == 3) {
            return;
        }
    }
}
