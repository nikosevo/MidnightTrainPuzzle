#start with the class and the basic elements that we will need in order to make this work.
class Person:
    def __init__(self, name, timetotravel,crossed):
        self.name = name
        self.timetotravel = timetotravel
        self.crossed = crossed
    def __str__(self):
        return self.name , self.timetotravel , self.crossed
NumOfPersons = 5
listOfPersons = []
flashlight_side = False

def printlist(): #simple function to print the list
    for i in range(0,len(listOfPersons)):
        print(listOfPersons.__getitem__(i).__str__())


def Fill_List_With_Persons():   #this will need to take as a parameter the users intput 
    for i in range(0 , NumOfPersons):
        tempname = "A" + str(i+1)
        newPerson = Person(tempname, i+2,False)
        listOfPersons.append(newPerson)

Fill_List_With_Persons()
printlist

#cross to the good side
#take two persons and cross them with the flashlight
#listOfPersons.__getitem__(firnum).crossed=True
#listOfPersons.__getitem__(secnum).crossed=True
flashlight_side = True
printlist
#print(max(3,0))
#add time to the total time

