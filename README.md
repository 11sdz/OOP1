# Ex1 OOP class - ariel CS


## Brief overview
In this assignment we were requested to make an algorithm that implements the design pattern
Observer for the UndoableStringBuilder class that we created last assignment.

## class structure
being an OOP course we had to make our classes to accomplish out desired algorithm. The classes we implemented are:

## Observer design pattern
The Observer design pattern is a behavioral design pattern that allows an object (called the subject)
to be observed by other objects (called observers). The idea is that the subject maintains a list of its
observers and provides an interface for adding or removing observers. When the subject's state changes,
it automatically notifies all of its observers, who can then update themselves accordingly.


| Name                  | Description                                                                                                        |
|-----------------------|--------------------------------------------------------------------------------------------------------------------|
| UndoableStringBuilder | The class we created in Ex0. In this task we implements the design pattern                                         |
| GroupAdmin            | This class implements the interface Sender. Represents observerable UndoableStringBuilder Observer for this class. |
| ConcreteMember        | This class implements the interface Member. Represents an observer.                                                |

## Algorithm
We implemented the design pattern Observer in the following way: 
GroupAdmin class contains UndoableStringBuilder and a list of Members. It has functions of register and unregister
members, and also the functions of UndoableStringBuilder, such as insert, append, delete, undo.
After performing each action of the UndoableStringBuilder class the algorithm calls notifyMembers()
which calls the Member class function update() for each member in the list get a UndoableStringBuilder and creates 
a shallow copy of the updated UndoableString.

## Testing
We created a test class using the UniTest library to test all the public functions of GroupAdmin and Member.

