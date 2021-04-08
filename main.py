costs = {}
state = {}
finalState = {}

visits=0
createdNodesNum=0

treeNode = []
class Node:
    def __init__(self,name,parent,state,depth,cost):
        self.name = name
        self.parent = parent
        self.state = state
        self.depth = depth
        self.cost = cost
        self.children = {}
    
    @property
    def checkForFinalState(self):
        if (state == finalState):
            return True
        return False
    @property
    def newChildren(self):
        if state[-1] == False: #which mean the torch is in the left side
            for i in range(0,state.length -1):
                for j in range(i+1,state.length -1):
                    if(self.state[i] == 0 and self.state[j] == 0): #all pairs but only in the left side
                        newState = state
                        newState[i] = True
                        newState[j] = True
                        newState[-1] = True

                        if (costs[i] > costs[j]):
                            requiredTime = costs[i]
                        else:
                            requiredTime = costs[j]
                        newState.add(Node(str(i," ",j),self,newState,self.deapth,self.cost + requiredTime))
        else: #which mean the torch is in the right side
            for i in range(0,state.length -1):
                if (self.state[i] == 1):
                    newState = state
                    newState[i] = False
                    newState[-1] = False

                    requiredTime = costs[i]

                    newState.add(Node(str(i," ",self,newState,self.depth,self.cost)))
        
    @property
    def getParentNode(self):
        return self.parent
    @property
    def getChildNode(self):
        return self.child
    @property
    def getDeapth(self):
        return self.depth
    @property 
    def getCost(self):
        return self.cost
    @property
    def getName(self):
        return self.name

def askUserForInputs():

    numOfPeople = int(input("how many people are waiting on the bridge: "))

    for i in range(0,numOfPeople):
        costs[i] = int(input("how fast can person " + str(i) +" cross the bridge: "))

    for i in range(0,numOfPeople + 1):
        state[i] = False

    for i in range(0,numOfPeople + 1):
        finalState[i] = True

############## UCS ALGO #########################
def Ucs():
    treeNode.add(NewNode = Node("Starting",None,state,0,0))
    while treeNode !=None:
        visits= visits+1
        print(visits)

        minCostNode = Node(None,None,None,None,0)
        mincost=0 #this will need to become as big as possible Max_Value
        for i in range(treeNode.size()):
            if treeNode[i].getCost() <= minCost:
                minCost = treeNode[i].getCost()
                minCostNode = treeNode[i]
        
        tempNode = minCostNode
        print("node " , tempNode.name , " depth " , tempNode.depth)
        if tempNode.state != finalState:
            tempNode.newChildren()
            for i in range( : node.children):
                treeNode.add(new Node) #this needs to be added to the end of the list
        else :
            print("UCS ENDED")
######################################################
