costs = {}
state = {}
finalState = {}
class Node:
    def __init__(self,name,parent,state,deapth,cost):
        self.name = name
        self.parent = parent
        self.state = state
        self.deapth = deapth
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

                    newState.add(Node(str(i," ",self,newState,self.deapth,self.cost)))
        
    @property
    def getParentNode(self):
        return self.parent
    @property
    def getChildNode(self):
        return self.child
    @property
    def getDeapth(self):
        return self.deapth
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
