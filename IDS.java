
import java.util.Arrays;
import java.util.LinkedList;

public class IDS
{   //We create an object of the IDS algorithm using the elements that we need to
    //check and make some functions operate properly.
    int visited = 0;
    public IDS(AlgoHandler algo, LinkedList<Node> queue, boolean state[], int costs[], boolean Goal[])
    {   
        int deepness = 0; //we initialize our searchDepth to zero to represent the root number
        for (int j = 0; j <= deepness; j++, deepness++)
        {
            //we create the root node and add it to our tree of seach
            queue.add(new Node("head",state,0,0,0,null,algo));

            while (!queue.isEmpty()) //to check if the tree is empty
            {
                visited++;
                System.out.println("\n" + visited);

                Node node = queue.getFirst();  //we copy the first node of the tree 

                System.out.println("node " + node.getId() + " depth: " + node.getDepth());
                queue.removeFirst();     //we remove the first node from the tree

                if (!Arrays.equals(node.getState(), algo.getGoal()))  //we check if the node that we took is the goal one 
                {
                    //we check if the depth is equal or less to the current search depth if it is we create a new child node
                    //because this means that we have reach out maximun number of nodes for this depth and we need to go deeper
                    if (node.getDepth() <= deepness)
                    {   
                        node.newChild(); 
                        // we get the subtree of the current node and we add the new node to it 
                        for (int i = node.getSubTree().size() - 1; i >= 0; i--)
                        {
                            Node childNode = node.getSubTree().get(i);
                            queue.addFirst(childNode);
                        }
                    }

                } else
                {
                    algo.displayResults(node, "IDS ",visited);
                    return;
                }
            }

            queue.clear();

        }
    }
}
