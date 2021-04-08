import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class AlgoHandler
{
     LinkedList<Node> treeNode;

    boolean state[];
    int costs[];
    boolean Goal[];
    
    int createdNodesnum;
    int visits;

    public AlgoHandler()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert the number of people waiting to cross the bridge:");

        int numberOfPeople = sc.nextInt();

        state = new boolean[numberOfPeople + 1];
        costs = new int[numberOfPeople];

        for (int i = 0; i < costs.length; i++)

        {
            System.out.println("Please insert the crossing time of Person " + Integer.sum(i, 1) + ":");
            costs[i] = sc.nextInt();
        }

        System.out.println("Please choose which algorithm you would like to run: \n1) BFS\n2) DFS\n3) UCS\n4) IDS");
        int algorithm = sc.nextInt();


        treeNode = new LinkedList<>();
        this.createdNodesnum = 0;
        this.visits = 0;

        this.Goal = new boolean[state.length];
        Arrays.fill(this.Goal, true);

        if (algorithm == 1)
        {
            System.out.println("UCS");
            UCS ucsalgo = new UCS(new AlgoHandler(),treeNode,state,costs,Goal,createdNodesnum,visits);
        } else if (algorithm == 2)
        {
            System.out.println("2");
        } else if (algorithm == 3)
        {
            System.out.println("3");
        } else if (algorithm == 4)
        {
            System.out.println("4");
        } else System.out.println("Wrong input.\nTerminating the program.");


        sc.close();
    }


  public  void printOutput(Node node, String algorithName) {
        System.out.println("\n" + algorithName + " found a solution to the problem!");
        System.out.println("The final cost is " + node.getCost() + " minutes.");
        System.out.println("The nodes created were " + createdNodesnum + ", with " + visits
                + " of them being visited.\n");

        ArrayList<String> output = new ArrayList<>();

        while (node.getDepth() != 0) {
            if (node.getName().length() > 1) {
                String s = "A" + node.getName().charAt(0) + " and A" + node.getName().charAt(1)
                        + " crossed the bridge in " + (node.getCost() - node.getParentNode().getCost()) + " minute(s)";

                output.add(s);
            } else {
                String s = "A" + node.getName() + " returns back in "
                        + (node.getCost() - node.getParentNode().getCost()) + " minute(s)";

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

    public int calculateCrossingTime(int i, int j) {
        if (this.costs[i] > this.costs[j])
            return this.costs[i];
        else
            return this.costs[j];
    }

    public boolean[] getFiniteState() {
        return Goal;
    }

    public void incrementCreatedNodesCounter() {
        createdNodesnum++;
    }
    
}