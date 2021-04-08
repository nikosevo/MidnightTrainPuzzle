import java.util.LinkedList;
 
public class UCS
{
    public UCS(AlgoHandler algo, LinkedList<Node> treeNode,boolean state[], int costs[], boolean Goal[], int createdNodesnum, int visits)
    {
        treeNode.add(new Node("startingNode", this, null, state, 0, 0));

        while (!treeNode.isEmpty())

        {
            visits++;
            System.out.println("\n" + visits);

            Node minCostNode = null;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < treeNode.size(); i++)
            {
                if (treeNode.get(i).getCost() < minCost)
                {
                    minCost = treeNode.get(i).getCost();
                    minCostNode = treeNode.get(i);
                }
            }
            Node node = minCostNode;
            System.out.println();
            System.out.println("node " + node.getName() + " depth: " + node.getDepth());
            treeNode.remove(node);

            if (!node.checkFiniteState())
            {
                node.createChildren();

                for (Node childNode : node.getChildren())
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
}
