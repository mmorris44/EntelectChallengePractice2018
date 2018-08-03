import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EasySolution {

    public static void main(String[] args) {

        try {
            PrintWriter pr = new PrintWriter(new FileWriter("output"));

            String inputFile = "input/map_1.input";

            InputParser ip = new InputParser();
            ip.read(inputFile);

            int nWorkers = ip.numberOfWorkers;

            // Find all things to do
            ArrayList<Character> route = new ArrayList<>();
            for (int i = 0; i < ip.grid.size(); ++i) {
                for (int j = 0; j < ip.grid.get(i).size(); ++j) {
                    Node node = ip.grid.get(i).get(j);
                    if (node instanceof Mine) {
                        route.add(node.id);
                        route.add(Character.toLowerCase(node.id));
                    }
                }
            }

            // Ouput route
            pr.print(route.get(0));
            for (int i = 1; i < route.size(); ++i) {
                pr.print("," + route.get(i));
            }
            pr.println();

            pr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
