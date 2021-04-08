import java.util.Arrays;
import java.util.LinkedList;
 
public class UCS
{
    int visited = 0;
    //Basically we create a constructor with all the elements that we need in order to run the algorithm we also need to
    //parse a parameter with the type AlgoHandler so that we can run certain functions and checks to avoid static usage
    public UCS(AlgoHandler algo, LinkedList<Node> treeNode,boolean state[], int costs[], boolean Goal[], int createdNodesnum)
    {
        //we create the root node and add it to our tree of seach
        treeNode.add(new Node("head",state,0,0,null,algo));

        while (!treeNode.isEmpty())  //initial check so that we know that the tree is not empty

        {
            visited++; //increment the number of visits by one

            Node minCostNode = null;   //we create new node with all the values set to zero
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < treeNode.size(); i++)  //check for the whole tree to get for the current root the total cost and set it to minimum
            {
                if (treeNode.get(i).getTotalCost() < minCost)
                {
                    minCost = treeNode.get(i).getTotalCost();
                    minCostNode = treeNode.get(i);
                }
            }
            Node node = minCostNode;            
            System.out.println();
            System.out.println("node " + node.getId() + " depth: " + node.getDepth());
            treeNode.remove(node);

            if (!Arrays.equals(node.getState(), algo.getGoal()))
            {
                node.newChild();

                for (Node childNode : node.getSubTree())
                {
                    treeNode.addLast(childNode);
                }
            } else
            {
                algo.printOutput(node, "UCS");
                return;
            }
        }
    }
    public int getVisits(){return visits;}
}
