import java.util.Arrays;
import java.util.LinkedList;
 
public class BFS
{
    int visited = 0;
    //Basically we create a constructor with all the elements that we need in order to run the algorithm we also need to
    //parse a parameter with the type AlgoHandler so that we can run certain functions and checks to avoid static usage
    public BFS(AlgoHandler algo, LinkedList<Node> queue,boolean state[], int costs[], boolean Goal[])
    {
        //we create the root node and add it to our tree of seach
        queue.add(new Node("head",state,0,0,0,null,algo));

        while (!queue.isEmpty())  //initial check so that we know that the tree is not empty

        {
            visited++; //increment the number of visits by one

            Node node = null;   
            int minCost = Integer.MAX_VALUE;
            //we search the whole tree to find the path with the least cost
            for (int i = 0; i < queue.size(); i++)  
            {  
                //we add the total cost with the heuristic  
                int cost  = queue.get(i).getTotalHeuristic();
                if ( cost < minCost)
                {
                    minCost = cost;
                    node = queue.get(i);
                }
            }
            //this is used for testing 
            //System.out.println("node " + node.getId() + " depth: " + node.getDepth());
            
            //and since the node is now expaned we remove the node from the queue
            queue.remove(node);
            
            //if the current node is not our goal we expand the tree
            if (!Arrays.equals(node.getState(), algo.getGoal()))
            {
                node.newChild();

                for (Node childNode : node.getSubTree())
                {
                    queue.addLast(childNode);
                }
            } else
            {
                //otherwise,since we already have the node with the minimum cost,we can safely say that the algorytm finished and found the most cost efficient way
                algo.displayResults(node, "BFS",visited);
                return;
            }
        }
    }
}
