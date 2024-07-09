import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public ArrayList<Friendship> load(String fileName) {
        ArrayList<Friendship> list = new ArrayList<Friendship>();
        try {
            File fileOpen = new File(fileName);
            Scanner reader = new Scanner(fileOpen);
            Integer limit = limiter(fileName) + 1;
            for (int i = 0; i < limit; ++i) {
                if (i != 0) {
                    list.add(new Friendship(reader.nextInt(), reader.nextInt()));
                    reader.nextLine();
                } else {
                    reader.nextLine();
                }
            }
            reader.close();
            try {
                FileWriter writer = new FileWriter("output.txt");
                for (int i = 0; i < limit - 1; ++i) {
                    String temp = list.get(i).getAccount() + " " + list.get(i).getIsFriendsWith() + "\n";
                    writer.write(temp);
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Exception encountered");
            }

            return list;
        } catch (FileNotFoundException e) {
            System.err.println("Error occured");
            return list;
        }

    }

}
