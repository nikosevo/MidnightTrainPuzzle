treeNode = []
def IDS():
    searchDepth = 0
    counter = 0
    while counter <= searchDepth:
        treeNode.add(new Node("starting",this,None,state,0,0))
        while treeNode.isEmpty == False:
            visits = visits + 1
            Node node = treeNode.get(counter)
            treeNode.remove(counter)
            if node.state != goalstate:
                if node.depth != searchDepth:
                    node.expand()
                    for i in range(node.getChild.size()-1,0,-1):
                        Node child = node.getChild.get(i)
                        treeNode.add(child)
            else:
                print("IDS ENDED")
                return
    treeNode.clear()
IDS()
