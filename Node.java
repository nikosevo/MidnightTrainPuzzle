import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    private static int nodesCreated = 0;
    private Node parent;
    private ArrayList<Node> subTree; // basically this is the child but the has also the childs's children

    private AlgoHandler handler;

    private String id;
    private boolean state[]; // since the state is an array and the size wont be changing we save its length
                             // to a variable
    private int stateLen;
    private int depth;
    private int totalCost; // this is the total cost from the head node until here

    public Node(String id, boolean state[], int depth, int totalCost, Node parent, AlgoHandler handler) {
        this.id = id;
        this.state = state;
        this.stateLen = state.length;
        this.depth = depth;
        this.totalCost = totalCost;
        this.parent = parent;
        this.handler = handler;
        nodesCreated++;
    }

    public void newChild() {
        subTree = new ArrayList<Node>();

        // when the torch is left then only people from the left can cross the bridge
        // if the torch is rightside of the bridge,only people from the right side can
        // cross
        // and we also know that people who cross the left to right there is going to be
        // pair of people crossing
        // and only one person if the torch is located leftside

        // also nodes wont be visited twice since this only happens when 2 people from
        // the left want to cross the bridge together
        // but this is not efficient for our solution
        // so knowing that the childrens or the subTrees will be creates like so

        // if the torch is located in the left side of the bridge we create all the
        // possible pairs
        if (state[stateLen - 1] == false) {
            for (int i = 0; i < stateLen - 1; i++) {
                for (int j = i + 1; j < stateLen - 1; j++) {
                    // and we create the node only if both of these people are on the right side of
                    // the bridge
                    if (state[i] == false && state[j] == false) {
                        // the state of the child must be that same as the current but
                        // will only change the 2 people that crossed right now and the torch
                        boolean stateOfTheChild[] = new boolean[stateLen];
                        for (int k = 0; k < stateLen - 1; k++) {
                            stateOfTheChild[k] = state[k];
                        }
                        stateOfTheChild[i] = true;
                        stateOfTheChild[j] = true;
                        stateOfTheChild[stateLen - 1] = true;

                        // now we need to add the time of the slowest to the total cost of the child
                        int totalCostOfTheChild = findTotalCostOfChild(i, j);

                        // and the id of the new node will simple be the combination of people that
                        // crossed
                        String idOfChild = i + " " + j;

                        // now that we have everything needed, we create the new child
                        // and add it to the subtree list

                        subTree.add(
                                new Node(idOfChild, stateOfTheChild, depth + 1, totalCostOfTheChild, this, handler));
                    }
                }
            }
        }

        // if the torch is located in the right side of the bridge we only sent 1 person
        // to cross with the torch
        if (state[stateLen - 1] == true) {
            for (int i = 0; i < stateLen - 1; i++) {
                // and we sent across only people who are alredy located to the right side of
                // the bridge
                if (state[i] == true) {
                    boolean stateOfTheChild[] = new boolean[stateLen];
                    // we copy the state as before
                    for (int k = 0; k < stateLen - 1; k++) {
                        stateOfTheChild[k] = state[k];
                    }
                    // ans we only change the value of the person who crossed and the torch
                    stateOfTheChild[i] = false;
                    stateOfTheChild[stateLen - 1] = false;

                    int totalCostOfTheChild = totalCost + handler.getCrossingTime(i);

                    // the id of the child node will be the person who crossed so:
                    String idOfChild = i + "";

                    subTree.add(new Node(idOfChild, stateOfTheChild, depth + 1, totalCostOfTheChild, this, handler));

                }
            }
        }

    }

    // returns the slowest out of 2 people
    private int findTotalCostOfChild(int i, int j) {
        if (handler.getCrossingTime(i) > handler.getCrossingTime(j))
            return totalCost + handler.getCrossingTime(i);

        return totalCost + handler.getCrossingTime(j);
    }

    public Node getParentNode() {
        return parent;
    }

    public ArrayList<Node> getSubTree() {
        return subTree;
    }

    public int getDepth() {
        return depth;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getId() {
        return id;
    }
    public boolean[] getState() {return state;}
    
}
