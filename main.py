class Node:
    def __init__(self,name,parent,state,deapth,cost,counter):
        self.name = name
        self.parent = parent
        self.state = state
        self.deapth = deapth
        self.cost = cost
        self.counter = counter + 1

    @property
    def checkForFinalState(self):
        if self.state == finalState:
            return True
        return False



finalState =    {True,True,True}
currentState =  {False,False,False}
costs =         {  1,    3,    6}

nodes_created = 0
nodes_visited = 0

