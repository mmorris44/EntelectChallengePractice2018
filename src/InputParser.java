import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputParser {

    public ArrayList<ArrayList<Node>> grid = new ArrayList<>();
    public int numberOfWorkers;

    public void read(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            numberOfWorkers = scanner.nextInt();
            scanner.nextLine();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                grid.add(new ArrayList<>());
                for (char c : line.toCharArray()) {
                    if (c == '#') {
                        grid.get(grid.size() - 1).add(new Space());
                    } else if (Character.isUpperCase(c)) {
                        grid.get(grid.size() - 1).add(new Mine(c));
                    } else if (Character.isLowerCase(c)) {
                        grid.get(grid.size() - 1).add(new Depot(c));
                    } else {
                        System.out.println("INPUT PROBLEM");
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

abstract class Node {
    char id;

    public Node(char id) {
        this.id = id;
    }
}

class Mine extends Node {
    public Mine(char id) {
        super(id);
    }
}

class Depot extends Node {
    public Depot(char id) {
        super(id);
    }
}

class Space extends Node {
    public Space() {
        super('0');
    }
}