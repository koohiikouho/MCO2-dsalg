import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input file path: ");
        // String fileName = "data/" + scan.nextLine();
        String fileName = "data/Caltech36.txt";
        GraphLoader loader = new GraphLoader();
        FriendList menu = new FriendList();

        Graph g = new Graph(loader.accountSize(fileName));
        g = loader.load(fileName);

        System.out.println("Graph loaded!");
        while (menu.mainMenu(scan, loader.limiter(fileName), g) == true)
            ;

    }

}