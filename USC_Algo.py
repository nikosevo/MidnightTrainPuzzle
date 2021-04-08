import Node.python
def Ucs():
    treeNode.add(new Node("starting",this,null,state,0,0))
    while treeNode !=None:
        visits= visits+1
        print(visits)

        Node minCostNode = None
        mincost=0 #this will need to become as big as possible Max_Value
        for i in range(treeNode.size()):
            if treeNode.get(i).cost <= minCost:
                minCost = treeNode.get(i).cost
                minCostNode = treeNode.get(i)
        
        Node node = minCostNode
        print("node " , node.name , " depth " , node.depth)
        if node != goalstate:
            node.expand()
            for i in range(Node node : node.children):
                treeNode.add(new Node) #this needs to be added to the end of the list
        else :
            print("UCS ENDED")