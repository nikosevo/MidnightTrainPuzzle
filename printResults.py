def printResults(Node node , AlgoName):
    print(AlgoName , " solved the puzzle")
    print("Total cost : " ,node.getCost())
    print("The nodes created were " , createdNodesNum , ", with " , visits , " of them being visited.")

    output = []
    while node.depth != 0:
        if node.name.size() > 1
            s ="A", node.name.get(0)," and A" , node.name.get(1),"crossed the bridge in" ,node.cost-node.parent.cost,"minutes"
            output.add(s)
        else:
            s = "A" , node.name , " returns back in " , (node.cost - node.parent.cost) , " minute(s)"

            output.add(s)
        node = node.parent
   print(output  )