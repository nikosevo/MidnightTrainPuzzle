import java.util.Arrays;
import java.util.LinkedList;

public class IDS
{   //We create an object of the IDS algorithm using the elements that we need to
    //check and make some functions operate properly.
    int visited = 0;
    public IDS(AlgoHandler algo, LinkedList<Node> treeNode, boolean state[], int costs[], boolean Goal[], int createdNodesnum)
    {   
        int searchDepth = 0; //we initialize our searchDepth to zero to represent the root number
        for (int j = 0; j <= searchDepth; j++, searchDepth++)
        {
            //we create the root node and add it to our tree of seach
            treeNode.add(new Node("head",state,0,0,null,algo));

            while (!treeNode.isEmpty()) //to check if the tree is empty
            {
                visited++;
                System.out.println("\n" + visited);

                Node node = treeNode.getFirst();  //we copy the first node of the tree 

                System.out.println("node " + node.getId() + " depth: " + node.getDepth());
                treeNode.removeFirst();     //we remove the first node from the tree

                if (!Arrays.equals(node.getState(), algo.getGoal()))  //we check if the node that we took is the goal one 
                {
                    //we check if the depth is equal or less to the current search depth if it is we create a new child node
                    //because this means that we have reach out maximun number of nodes for this depth and we need to go deeper
                    if (node.getDepth() <= searchDepth)
                    {   
                        node.newChild(); 
                        // we get the subtree of the current node and we add the new node to it 
                        for (int i = node.getSubTree().size() - 1; i >= 0; i--)
                        {
                            Node childNode = node.getSubTree().get(i);
                            treeNode.addFirst(childNode);
                        }
                    }

                } else
                {
                    algo.printOutput(node, "IDS found a result in the search",visited);
                    return;
                }
            }
            treeNode.clear();
        }
    }
}
