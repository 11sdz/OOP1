## Ex1 OOP class - ariel CS

### Brief overview
In this assignment we were requested to make an algorithm that implements the design pattern
Observer for the UndoableStringBuilder class that we created last assignment.

### Observer design pattern
The Observer design pattern is a behavioral design pattern that allows an object (called the subject)
to be observed by other objects (called observers). the subject (in our code GroupAdmin) maintains a list of its dependents called observers (ConcreteMembers) and notifies them automatically of any state changes (actions taken on the UndoableStringBuilder in GroupAdmin) by calling their method (update()).

### class structure
being an OOP course we had to make our classes to accomplish out desired design pattern. The classes we implemented are:

| Name                  | Description                                                                                                        |
|-----------------------|--------------------------------------------------------------------------------------------------------------------|
| UndoableStringBuilder | The class we created in Ex0. a StringBuilder with the ability to undo                                       |
| GroupAdmin            | This class implements the interface Sender. Represents Subject maintains a list contains dependents (Members Subscribed |
| ConcreteMember        | This class implements the interface Member. Represents a Member that can subcribe to the subject (GroupAdmin).    |

### Algorithm
We implemented the design pattern Observer in the following way: 
GroupAdmin class contains UndoableStringBuilder and a list of Members. It has functions of register and unregister
members, and also the functions of UndoableStringBuilder, such as insert, append, delete, undo.
After performing each action of the UndoableStringBuilder class the algorithm calls notifyMembers()
which calls the Member class function update() for each member in the list get a UndoableStringBuilder and creates 
a shallow copy of the updated UndoableString.

### Testing
We created a test class using the UniTest library to test all the public functions of GroupAdmin ,Member and UndoableStringBuilder.

### Clone Ex1
 clone using :
    git clone https://github.com/11sdz/OOP1.git
  
