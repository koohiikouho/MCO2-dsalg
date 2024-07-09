import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input file path: ");
        String fileName = "data/" + scan.nextLine();
        // String fileName = "data/Caltech36.txt";
        GraphLoader loader = new GraphLoader();
        FriendList menu = new FriendList();

        ArrayList<Friendship> friendships = new ArrayList<Friendship>();

        friendships = loader.load(fileName);
        Graph g = new Graph(loader.accountSize(fileName));
        for (int i = 0; i < friendships.size(); ++i)
            g.addEdge(friendships.get(i).getAccount(), friendships.get(i).getIsFriendsWith());

        System.out.println("Graph loaded!");
        while (menu.mainMenu(scan, friendships, loader.limiter(fileName), g) == true)
            ;

    }

}