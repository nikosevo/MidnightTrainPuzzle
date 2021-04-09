import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//this is where we handle all the algorytms and user inputs
public class AlgoHandler
{
    private LinkedList<Node> queue ;

    // state is an array of boolean that show where each object is located
    //false means that the object is in the right side of the bridge and true on the left
    private boolean state[];
    private int costs[];
    private boolean Goal[];
    
    public AlgoHandler()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of people waiting to cross the bridge:");

        int numberOfPeople = sc.nextInt();

        //we add room for one more variable since we need to know in every state wether the torch is right or left
        state = new boolean[numberOfPeople + 1];
        costs = new int[numberOfPeople];

        for (int i = 0; i < costs.length; i++)

        {
            System.out.println("Please insert the crossing time of Person " + Integer.sum(i, 1) + ":");
            costs[i] = sc.nextInt();
        }

        System.out.println("Please choose which algorithm you would like to run: \n1) UCS\n2) IDS\n3) BFS\n4) A*");
        int algorithm = sc.nextInt();

        //we use linked list since we dont care about choosing a specific node at any point
        queue = new LinkedList<>();

        //and we set the goal now since we now know how many people should be
        this.Goal = new boolean[state.length];
        Arrays.fill(this.Goal, true);

        if (algorithm == 1)
        {
            System.out.println("UCS");
            new UCS(this,queue,state,costs,Goal);
        } else if (algorithm == 2)
        {
            System.out.println("IDS");
            new IDS(this,queue,state,costs,Goal);
        } else if (algorithm == 3)
        {
            System.out.println("BFs");
            new BFS(this,queue,state,costs,Goal);

        } else if (algorithm == 4)
        {
            System.out.println("A*");
            new Astar(this,queue,state,costs,Goal);
        } else System.out.println("Wrong input.\nTerminating the program.");


        sc.close();
    }

    //a function to print the output
    //is called in the algorythm when it finishes running
    public  void printOutput(Node node, String algorithName,int visited) {
        System.out.println("\n" + algorithName + " found a solution to the problem!");
        System.out.println("The final cost is " + node.getTotalCost() + " minutes.");
        System.out.println("The nodes created were " + node.getNodesCreated() + ", with " + visited
                + " of them being visited.\n");

        ArrayList<String> output = new ArrayList<>();

        while (node.getDepth() != 0) {
            if (node.getId().length() > 1) {
                String s = "A" + node.getId().charAt(0) + " and A" + node.getId().charAt(2)
                        + " crossed the bridge in " + (node.getTotalCost() - node.getParentNode().getTotalCost()) + " minute(s)";

                output.add(s);
            } else {
                String s = "A" + node.getId() + " returns back in "
                        + (node.getTotalCost() - node.getParentNode().getTotalCost()) + " minute(s)";

                output.add(s);
            }
            node = node.getParentNode();
        }

        for (int i = output.size() - 1; i >= 0; i--)
            System.out.println(output.get(i));
    }

    public int getCrossingTime(int i) {
        return this.costs[i];
    }

    public boolean[] getGoal(){
        return Goal;
    }
    
}