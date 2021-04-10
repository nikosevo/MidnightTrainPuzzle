import java.util.Arrays;
import java.util.LinkedList;
 
public class BFS
{
    int visited = 0;
    AlgoHandler algo;
    //Basically we create a constructor with all the elements that we need in order to run the algorithm we also need to
    //parse a parameter with the type AlgoHandler so that we can run certain functions and checks to avoid static usage
    public BFS(AlgoHandler algo, LinkedList<Node> queue,boolean state[], int costs[], boolean Goal[])
    {   
        this.algo = algo;
        //we create the root node and add it to our tree of seach
        queue.add(new Node("head",state,0,0,0,null,algo));

        while (!queue.isEmpty())  //initial check so that we know that the tree is not empty

        {
            visited++; //increment the number of visits by one

            Node node = null;   
            int minCost = Integer.MAX_VALUE;

            //we search the whole tree to find the path with the least const based on our heuristic funciton
            node = getLeasHeuristic(queue, node, minCost);
            
            //since we found the node we want to expand, we remove it from the queue
            queue.remove(node);


            //if we reached the goal then stop here otherwise we expand the subTree
            if(goalFound(node)){
                algo.displayResults(node, "BFS",visited);
                return;
            }

            //expanding the tree
            node.newChild();
            //we add new childred to the queue
            for (Node childNode : node.getSubTree())
            {
                queue.addLast(childNode);
            }
        }
    }

    private boolean goalFound(Node node){
        //return true if the current state is the same as the goal state
        if(Arrays.equals(node.getState(),algo.getGoal()))
            return true;
        return false;
    }
    private Node getLeasHeuristic(LinkedList<Node> queue, Node node, int minCost) {
        for (int i = 0; i < queue.size(); i++)  
        {  
            //we add the total cost with the heuristic  
            int cost  = queue.get(i).getTotalHeuristic() + queue.get(i).getTotalCost();
            if ( cost < minCost)
            {
                minCost = cost;
                node = queue.get(i);
            }
        }
        return node;
    }
}
