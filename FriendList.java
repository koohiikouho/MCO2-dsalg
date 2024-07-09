import java.util.*;

public class FriendList {
    private Integer linearSearch(ArrayList<Friendship> list, Integer high, Integer key) {
        for (int i = 0; i < high; i++) {
            if (Integer.compare(list.get(i).getAccount(), key) == 0)
                return i;
        }
        return -1;
    }

    public void displayFriends(ArrayList<Friendship> list, Integer high, Scanner scan) {
        System.out.print("Enter ID of person: ");
        Integer ID = Integer.parseInt(scan.nextLine());
        Integer start = 0;
        Integer friends = 0;
        start = linearSearch(list, high, ID);
        while (start < list.size() && Integer.compare(list.get(start).getAccount(), ID) == 0) {
            System.out.print(list.get(start).getIsFriendsWith() + " ");
            start++;
            friends++;
            if (friends % 5 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("Person " + ID + " has " + friends + " friends!");

    }

    private void getConnections(Graph graph, Integer high, Scanner scan, ArrayList<Friendship> list) {
        System.out.print("Enter ID of first person: ");
        Integer source = Integer.parseInt(scan.nextLine());
        System.out.println();
        System.out.print("Enter ID of second person: ");
        Integer destination = Integer.parseInt(scan.nextLine());
        boolean notFriends = false;
        Integer start = linearSearch(list, high, source);
        while (start < list.size() && Integer.compare(list.get(start).getAccount(), source) == 0) {

            if (Integer.compare(list.get(start).getIsFriendsWith(), destination) == 0) {
                System.out.println(source + " and " + destination + " are already friends!");
                notFriends = true;
                break;
            }
            start++;
        }
        if (notFriends == false)
            graph.DFS(source, destination);

    }

    public boolean mainMenu(Scanner scan, ArrayList<Friendship> list, Integer size, Graph graph) {
        boolean repeat = false;
        System.out.println("\nMAIN MENU");
        System.out.println("[1] Get Friend list");
        System.out.println("[2] Get connection");
        System.out.println("[3] Exit\n");
        System.out.print("Enter your choice: ");
        Integer option = Integer.parseInt(scan.nextLine());
        switch (option) {
            case 1:
                displayFriends(list, size, scan);
                repeat = true;
                break;
            case 2:
                getConnections(graph, size, scan, list);
                repeat = true;
                break;
            default:
                break;
        }
        return repeat;
    }
}