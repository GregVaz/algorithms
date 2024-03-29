# Node-Based Data Structures

Nodes are pieces of data that may be dispersed throughout the computer's memory.

## Data structure - Linked list

Linked list is a data structure that represents a list of items

As mentioned, memory inside a computer can be visualized as a giant set of cells in which bits of data are stored.
When we create an array, the code finds a contiguous group of empty cells in memory and esignates them to store data for your application.
The computer has the ability to access any memory address in one step, and can use that power also immediately access any index with the array.
This is because the program knows which memory address the array starts at (say memory address 1000) and therefore knows that if it wants to look up index 4, it just have to add 4 to the current address (1004).

The data of a Linked list can be scattered across different cells throughout the computer's memory

Nodes are known as connected data that is dispersed throughout memory.
So in a Linked list, each node represetns one item in the list.
The key of a Linked list> each node comes with a little extra information, namely, the memory address of the next node in the list.
This extra piece of data is known as a _link_.

"When dealing with a LinkedList, we only have immediate access to its first node."

## Reading

If you want to read from the las node in the list, it would take N steps for N nodes in the list.
Linked list having a worst-case read of O(N) is a major disadvantage when compared with arrays that can read any element in just O(1)

## Searching

Linked list also have a search speed of O(N). To search for a value, we need fo through a similar process as we did with reading.
We begin with the first node and follow the links of each node to the next one

## Insertion

Insertion into a linked list is O(N), as the worst-case scenario of inserting at the end of the list will take N + 1 steps
However, in te best-case scenario of inserting at the beginning of the list is only O(1)

| Scenario               | Array        | Linked List  |
| ---------------------- | ------------ | ------------ |
| Inserting at beginning | Worst case   | Best case    |
| Inserting at middle    | Average case | Average case |
| Inserting at end       | Best case    | Worst case   |

## Deletion

The delete a node from the beginning of a linked list, all we need to do is perform one step,
we change the first_node of the linked list to now point to the second node.

| Scenario            | Array        | Linked List  |
| ------------------- | ------------ | ------------ |
| Delete at beginning | Worst case   | Best case    |
| Delete at middle    | Average case | Average case |
| Delete at end       | Best case    | Worst case   |

## Efficiency of Linked List Operations

| Operation | Array | Linked List |
| --------- | ----- | ----------- |

Reading | O(1) | O(N)
Search | O(N) | O(N)
Insertion | O(N) (O(1) at the end) | O(N) (O(1) at the beginning)
Deletion | O(N) (O(1) at the end) | O(N) (O(1) at the beginning)

# Queues as Doubly Linked List

Because Doubly Linked Lists have immediate access to both the front and end of the list,
they can insert data on either side at O(1) as well as delete data on either side at O(1)

We look at Queues, you'll recall that they are lists of items in which data can only be inserted at the end and removed from the beginning.
While Arrays are O(1) for insertions at the end, they're O(N) for deleting from the beginning.
A doubly linked list, on the other hand, is O(1) for both inserting at the end and for deleting from the beginning.
That's what makes it a perfect fit for serving as the queue's underlying data structure.

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
