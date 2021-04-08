
class Node:
    
    def __init__(self,name, parent=None, state, depth,cost):
        self.name = name
        self.parent = parent
        self.state = state
        self.depth = depth + 1
        self.cost = cost
    
    @property
    def checkForFinalState():
        return false

print("hi")