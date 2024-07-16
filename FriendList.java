import java.util.*;

public class FriendList {

    public void displayFriends(Graph list, Integer high, Scanner scan) {
        System.out.print("Enter ID of person: ");
        Integer ID = Integer.parseInt(scan.nextLine());
        Iterator<Integer> i = list.getAdj()[ID].listIterator();
        Integer counter = 0;
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
            counter++;
            if (counter % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\nPerson " + ID + " has " + list.getAdj()[ID].size() + " friends!");

    }

    private void getConnectionsDFS(Graph graph, Integer high, Scanner scan) {
        System.out.print("Enter ID of first person: ");
        Integer source = Integer.parseInt(scan.nextLine());
        System.out.println();
        System.out.print("Enter ID of second person: ");
        Integer destination = Integer.parseInt(scan.nextLine());
        boolean notFriends = true;

        Iterator<Integer> i = graph.getAdj()[source].listIterator();
        do {
            if (Integer.compare(i.next(), destination) == 0) {
                notFriends = false;
                System.out.println(source + " and " + destination + " are already friends!");
                break;
            }
        } while (i.hasNext());
        if (notFriends == true)
            graph.DFS(source, destination);

    }

    private void getConnectionsBFS(Graph graph, Integer high, Scanner scan) {
        System.out.print("Enter ID of first person: ");
        Integer source = Integer.parseInt(scan.nextLine());
        System.out.println();
        System.out.print("Enter ID of second person: ");
        Integer destination = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> path = new ArrayList<>();
        path = graph.showConnection(source, destination);
        if (path != null) {
            for (int i = 0; i < path.size() - 1; ++i)
                System.out.println(path.get(i) + " is friends with " + path.get(i + 1));

        } else {
            System.out.println("Cannot find a connection between " + source + " and " + destination);
        }

    }

    public boolean mainMenu(Scanner scan, Integer size, Graph graph) {
        boolean repeat = false;
        System.out.println("\nMAIN MENU");
        System.out.println("[1] Get Friend list");
        System.out.println("[2] Get connection");
        System.out.println("[3] Exit\n");
        System.out.print("Enter your choice: ");
        Integer option = Integer.parseInt(scan.nextLine());
        switch (option) {
            case 1:
                displayFriends(graph, size, scan);
                repeat = true;
                break;
            case 2:
                getConnectionsBFS(graph, size, scan);
                repeat = true;
                break;
            default:
                break;
        }
        return repeat;
    }
}