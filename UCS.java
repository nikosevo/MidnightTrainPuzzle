import java.util.Arrays;
import java.util.LinkedList;
 
public class UCS
{
    int visited = 0;
    //Basically we create a constructor with all the elements that we need in order to run the algorithm we also need to
    //parse a parameter with the type AlgoHandler so that we can run certain functions and checks to avoid static usage
    public UCS(AlgoHandler algo, LinkedList<Node> treeNode,boolean state[], int costs[], boolean Goal[])
    {
        //we create the root node and add it to our tree of seach
        treeNode.add(new Node("head",state,0,0,null,algo));

        while (!treeNode.isEmpty())  //initial check so that we know that the tree is not empty

        {
            visited++; //increment the number of visits by one

            Node node = null;   
            int minCost = Integer.MAX_VALUE;
            //we search the whole tree to find the path with the least cost
            for (int i = 0; i < treeNode.size(); i++)  
            {
                if (treeNode.get(i).getTotalCost() < minCost)
                {
                    minCost = treeNode.get(i).getTotalCost();
                    node = treeNode.get(i);
                }
            }
            //this is used for testing 
            //System.out.println("node " + node.getId() + " depth: " + node.getDepth());
            treeNode.remove(node);
            
            //if the current node is not our goal we expand the tree
            if (!Arrays.equals(node.getState(), algo.getGoal()))
            {
                node.newChild();

                for (Node childNode : node.getSubTree())
                {
                    treeNode.addLast(childNode);
                }
            } else
            {
                //otherwise,since we already have the node with the minimum cost,we can safely say that the algorytm finished and found the most cost efficient way
                algo.printOutput(node, "UCS",visited);
                return;
            }
        }
    }
}
