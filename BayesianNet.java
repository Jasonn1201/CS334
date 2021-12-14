import java.io.File;
import java.util.Scanner;

public class BayesianNet {
    static int startNode, endNode, numberOfNodes;
    static int[] subsetArray;

    public static void getUserInput() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of nodes in the graph: ");
        numberOfNodes = input.nextInt();

        System.out.print("\nEnter two nodes to verify their independence: \n> ");
        startNode = input.nextInt();

        System.out.print("> ");
        endNode = input.nextInt();

        // For debugging purposes only.
        System.out.println(startNode + ", " + endNode);

        System.out.print("\nSpecify the number of elements in your subset: ");
        subsetArray = new int[input.nextInt()];

        System.out.println("Enter your elements below:");
        for (int index = 0; index < subsetArray.length; index++) {
            System.out.print("> ");
            subsetArray[index] = input.nextInt();
        }

        input.close();
    }

    public static void main(String[] args) throws Exception {

        getUserInput();
        Graph directedGraph = new Graph(numberOfNodes); 
        Graph undirectedGraph = new Graph(numberOfNodes);
          
         File directedFile = new File("src/DirectedGraph.txt");
         Scanner inputFile1 = new Scanner(directedFile);
 
         File undirectedFile = new File("src/UndirectedGraph.txt");
         Scanner inputFile2 = new Scanner(undirectedFile);
 
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                if(inputFile1.nextInt() == 1)
                    directedGraph.addEdge(i, j);
                if(inputFile2.nextInt() == 1)
                    undirectedGraph.addEdge(i, j);
            }
        }

        System.out.println(
                "Following are all different directed paths from "
                        + startNode + " to " + endNode);
        directedGraph.printAllPaths(startNode, endNode);

        System.out.println(
                "\nFollowing are all different undirected paths from "
                        + startNode + " to " + endNode);
        undirectedGraph.printAllPaths(startNode, endNode);

        inputFile1.close();
        inputFile2.close();

    }
}
