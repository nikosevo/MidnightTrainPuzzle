import java.util.LinkedList;

public class IDS
{
    public IDS(AlgoHandler algo, LinkedList<Node> treeNode, boolean state[], int costs[], boolean Goal[], int createdNodesnum, int visits)
    {
        int searchDepth = 0;
        for (int j = 0; j <= searchDepth; j++, searchDepth++)
        {
            treeNode.add(new Node("startingNode", this, null, state, 0, 0));

            while (!treeNode.isEmpty())
            {
                visits++;
                System.out.println("\n" + visits);

                Node node = treeNode.getFirst();

                System.out.println("node " + node.getName() + " depth: " + node.getDepth());
                treeNode.removeFirst();

                if (!node.checkFiniteState())
                {

                    if (node.getDepth() <= searchDepth)
                    {
                        node.createChildren();

                        for (int i = node.getChildren().size() - 1; i >= 0; i--)
                        {
                            Node childNode = node.getChildren().get(i);
                            treeNode.addFirst(childNode);
                        }
                    }

                } else
                {
                    algo.printOutput(node, "IDS");
                    return;
                }
            }
            treeNode.clear();
        }
    }
}
