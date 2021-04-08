import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class AlgoHandler
{
    private LinkedList<Node> treeNode;

    private boolean state[];
    private int costs[];
    private boolean Goal[];
    
    private int createdNodesnum;
    private int visits;

    public int[] getCrossingTime;

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

        System.out.println("Please choose which algorithm you would like to run: \n1) UCS\n2) IDS\n3) BFS\n4) A*");
        int algorithm = sc.nextInt();


        treeNode = new LinkedList<>();
        this.createdNodesnum = 0;
        this.visits = 0;

        this.Goal = new boolean[state.length];
        Arrays.fill(this.Goal, true);

        if (algorithm == 1)
        {
            System.out.println("UCS");
            UCS ucsalgo = new UCS(this,treeNode,state,costs,Goal,createdNodesnum);
            visits = ucsalgo.getVisits();
        } else if (algorithm == 2)
        {
            System.out.println("2");
            IDS idsalgo = new IDS(this,treeNode,state,costs,Goal,createdNodesnum,visits);
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
        System.out.println("The final cost is " + node.getTotalCost() + " minutes.");
        System.out.println("The nodes created were " + node.getNodesCreated() + ", with " + visits
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
    public boolean[] getGoal(){
        return Goal;
    }
    
}