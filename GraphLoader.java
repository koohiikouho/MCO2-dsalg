import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphLoader {

    public Integer limiter(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            myReader.nextInt();
            Integer isFriendsFriendships = myReader.nextInt();
            myReader.close();
            return isFriendsFriendships;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return -1;
        }

    }

    public Integer accountSize(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            Integer nAccounts = myReader.nextInt();
            myReader.close();
            return nAccounts;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return -1;
        }

    }

    public Graph load(String fileName) {
        Graph list = new Graph(accountSize(fileName));
        try {
            File fileOpen = new File(fileName);
            Scanner reader = new Scanner(fileOpen);
            Integer limit = limiter(fileName) + 1;
            for (int i = 0; i < limit; ++i) {
                if (i != 0) {
                    list.addEdge(reader.nextInt(), reader.nextInt());
                    reader.nextLine();
                } else {
                    reader.nextLine();
                }
            }
            reader.close();

            return list;
        } catch (FileNotFoundException e) {
            System.err.println("Error occured");
            return list;
        }

    }

}
