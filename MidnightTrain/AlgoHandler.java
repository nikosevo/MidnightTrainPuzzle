package MidnightTrain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//this is where we handle all the algorytms and user inputs
public class AlgoHandler {
    private LinkedList<Node> queue;

    // state is an array of boolean that show where each object is located
    // false means that the object is in the right side of the bridge and true on
    // the left
    private boolean state[];
    private int costs[];
    private boolean Goal[];

    public AlgoHandler() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount of people that will try to cross the Bridge:");

        int numberOfPeople = sc.nextInt();

        // we add room for one more variable since we need to know in every state wether
        // the torch is right or left
        state = new boolean[numberOfPeople + 1];
        costs = new int[numberOfPeople];

        for (int i = 0; i < costs.length; i++)

        {
            System.out.println("Crossing time for Person " + Integer.sum(i, 1) + ":");
            costs[i] = sc.nextInt();
        }
        // we use linked list since we dont care about choosing a specific node at any
        // point
        queue = new LinkedList<>();

        // and we set the goal now since we now know how many people should be
        this.Goal = new boolean[state.length];
        Arrays.fill(this.Goal, true);

        // We ask for the users choice to choose an algorithm
        int choice = 0; // we initialize this variable with one for the while to work
        while (choice < 1 || choice > 4) {
            System.out.println(
                    "Please choose an algorithm: \n1) UCS (Uniform Cost Search)\n2) IDS (Iterative Deepening Search)\n3) BFS (Best-first search)\n4) A*");
            choice = sc.nextInt();
            // We take the user's input and with a simple switch we select his choice
            switch (choice) {
            case 1:
                System.out.println("UCS");
                new UCS(this, queue, state, costs, Goal);
                break;
            case 2:
                System.out.println("IDS");
                new IDS(this, queue, state, costs, Goal);
                break;
            case 3:
                System.out.println("BFS");
                new BFS(this, queue, state, costs, Goal);
                break;
            case 4:
                System.out.println("A*");
                new Astar(this, queue, state, costs, Goal);
                break;
            default:
                System.out.println("Wrong input.\nPlease follow the instructions.");
                break;
            }
        }
        sc.close();
    }

    // a function to print the output
    // is called in the algorythm when it finishes running
    public void displayResults(Node node, String algorithm, int visited) {
        System.out.println("\nAlgorithm: " + algorithm + "\nResult: Solution Found!");
        System.out.println("Nodes created: " + node.getNodesCreated() + "\nNodes visited: " + visited);
        System.out.println("Final cost: " + node.getTotalCost() + " (minutes)\n\nSolution in text :");
        ArrayList<String> output = new ArrayList<>();

        while (node.getDepth() != 0) {
            if (node.getId().length() > 1) {
                String s = "A" + node.getId().charAt(0) + " and A" + node.getId().charAt(2) + " cross in "
                        + (node.getTotalCost() - node.getParentNode().getTotalCost()) + " minute(s)";

                output.add(s);
            } else {
                String s = "A" + node.getId() + " returns in "
                        + (node.getTotalCost() - node.getParentNode().getTotalCost()) + " minute(s)";

                output.add(s);
            }
            node = node.getParentNode();
        }

        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.println(output.get(i));
        }
    }

    public int getCrossingTime(int i) {
        return this.costs[i];
    }

    public boolean[] getGoal() {
        return Goal;
    }

}