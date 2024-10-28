package user;

import java.util.Scanner;

public interface CommunityInterface {
    void addMember(String user);

    void removeMember(String user);

    void manageCommunity(Scanner scanner);

}
