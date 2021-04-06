#start with the class and a two way constructor one for the starting node and one for the other nodes
class Node:
    def __init__(self, state, args,action,totalcost,totaldepth):
        if isinstance(args,Node):
            self.state = state
            self.args = Node
            self.action = action
            self.totalcost = totalcost
            self.totaldepth = totaldepth
        if args == None:
            self.state = state
            self.args = None
            self.action = action
            self.totalcost = totalcost
            self.totaldepth = totaldepth
            

#This can be changed later as to how we will calculate the cost and the depth
prevcost=0
newcost=0
prevdepth=0
newdepth=0

#initialized states later to be made by a def function
startingstate=[["A",2,False],["A1",3,False]]
action=[["A",2,False],["A1",3,True]]

startignNode = Node(startingstate,None,action,prevcost+newcost,prevdepth+newdepth)
print(startignNode)