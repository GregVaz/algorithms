# Keep you priorities straight with Heaps

We will explore the heap, a type of tree data structure that has special powers that can be leaveraged for specific scenarios. When we want to constantly keep tas on the greatest or least data element in a dataset.

Let's first check a completely different data structure: the priority queue

## Priority Queue

A priority queue is a list whose deletions and access are just like a classic queue, but whose insertions are like an ordered array. That is, we only delete and access data from the fron of the priority queue, but when we insert data, we always make sure the data remains sorted in a specific order.

The priority queue is an example of an abstract data type. It can be implemented using other more fundamental data structures. One straightforward way we can implement a priority queue us by using an ordered array.

Then, we use an array and apply the following constraints:

- When we insert data, we ensure we always maintain proper order.
- Data can only be removed from the end of the array. (This will represent the fron of the priority queue)

Let's analyze the efficiency

The priority queue has two primary operations: deletions and insertions.

Deleting ffrom the front of an array is O(N), since we have to shift all the data over to fill the gap created at index 0.
However, we have cleverly tweaked our implementation so that we consider the end of array to be the front of the priotity queue. This way, we are always deleting from the end of the array. which is O(1).

Our array-based priority queue, then, has deletions that are O(1) and insertions that are O(N). If we expect there to be many items in our priority queue, the O(N) insertions may cause some real unwanted drag in our application.

## Heaps

We are going to focus on the binary heap.

The binary heap is a specific ind of binary tree. As a reminder, a binary tree is a tree where each node has a maximum of two child nodes.

The binary heap is a binary tree that maintains the following conditions:

- The value of each node must be greater that each of its descendant nodes. This rule is known as the heap condition.
- The tree must be complete

### Heap condition

The _heap condition_ says that each node's value must be greater that each and every one of its descendants.

In a binary search tree, each node's right child is greater than it. In a heap, however, a node nerver has any descendant that is greater than it.

### Complete Trees

A _complete tree_ is a tree that is completely filled with nodes; no nodes are missing. So, if you read each level of the tree from left to right, all of the nodes are there. However, the bottom row can have empty positions, as long as there aren't any nodes to the right of these empty positions.

## Heap Properties

- Heaps are said to be weakly ordered as compared to binary search trees. While heaps some order, as descendants cannot be greater that eir ancestors, this isn't enough order to make heaps worth searching through.
- In a heap, the root node will always have the greatest value. This will be the key as to why the heap is a great tool for implementing priority queues.
- The heaps has two primary operations: inserting and deleting. As we noted, searching within a heap would required us to inspect each node, so searching is not an operatios usually implemented in this context of heaps.
- The heap has something called a _last node_. A heap's last node is the rightmost node in its bottom level.

## Heap Insertions

To insert a new value into the heap, we perform the following algorithm:

1. We create a node containing the new value and insert it at the next available rightmost spot in the bottom level. Thus, the value becomes the heap's last node.
2. Next, we compare this new node with its parent node.
3. If the new node is freater that its parent node, we swap the node with the parent node
4. We repeat Step 3, effectively moving the new node up through the heap, until it has a parent whose value is greater than it

The process to moving the new node up the heap, is called trickling the node up through the heap.

The efficiency of insertin into a heap is O(log N)

## Heap Deletion

The first thing to know about deleting a value from a heap is that _we only ever delete the root node_. This is right in line with the way a priority queue works, in that we only access and remove the highest-priority item.

The algorithm for deleting the root node of a heap is as follows:

1. Move the last node into where the root node was, effectively removing the original root node
2. Trickle the root node down into its proper place.

### Trickle down

Each time we trickle a node down, we have two possible directions as to where we will trickle it down. That is, we can either swap it with its left child or its right child.

The algorith for Trickle down:

1. We check both children of the trickle node and see which one is larger
2. If the trickle node is smalller than the larger of the two child nodes, we swap the trickle node with that larger child
3. We repeat Steps 1 and 2 until the trickle node has no children who are greater than it

Like insertion, the time complexity of deletion from a heap is O(log N), as we have to trickle a node from the root down through all log(N) levels of the heap.

## Heaps vs. Ordered Arrays

| .         | Ordered Array | Heap     |
| --------- | ------------- | -------- |
| Insertion | O(N)          | O(log N) |
| Deletion  | O(1)          | O(log N) |

At first glance, it seeems that it's a wash. Ordered arrays are slower thatn heaps when it comes to insertion, but faster than heaps for deletion.

However, heaps are considered to be the better choice, and here's why.

While O(1) is extremely fast, O(log N) is still very fast, and O(N), by comparision, is slow. With this in mind it becomes clearer as to why the heaps is considered the better choice.

| .         | Ordered Array  | Heap      |
| --------- | -------------- | --------- |
| Insertion | slow           | Very fast |
| Deletion  | Extremely fast | Very fast |

## Looking for the Last Node

The first step has us place the new value as the heap's last node.
How do we find the spot that will be the last node?

Look the following diagram:

```
             100
            /    \
          /        \
        88          25
      /   \        /  \
    87     16     8   12
  /   \   /  \   /
86    50 2   15 3
```

First let's explore why insertion and deletion are so dependent on the last node anyway. Why could not we insert new values elsewhere in the heap? And Why, when deleting, can't we replace the root node with some other node other than the last node?

So you can realize that if you use other nodes, the heap would become incomplete. But this begs the next question: why is completeness important for the heap?

The reason is because we want **to ensure our heap reamins well-balanced**

The reason why this balance is so important is because it's what allows to achieve O(log N) operations. In a severely imbalance tree like the following once, traversing it could take O(N) steps instead.

But this brings us back to the Problem of the Last Node. What algoritm would allow us to consistently find the last node of any heap?

## Arrays as Heaps

Because finding the last node is so critical to the heap's operations, and we want to make sure that finding the last node is efficient, heaps are usually implemented using arrays.

```
             100
            /    \
          /        \
        88          25
      /   \        /  \
    87     16     8   12
  /   \   /  \   /
86    50 2   15 3

[100, 88 ,25, 87, 16, 8, 12, 86, 50, 2, 15, 3]
```

The way this works is that we assign each node to an index within the array.

The root node is always stored at index 0. We can move down a level and go form left to rigth.

When we implement the heap in this fashion, _the last node will always be the final element of the array_.

# Heaps as Priority queues

Now, the primary function of the priority queue is to allow us immediate acess to the highest-priority item in the queue.

It's for this reason that a heap is a natural fit for priority queue implementations. The heap fives us immediate access to the _highest-priority item_, which can always be found at the root node.
Each time we take care of the highest-priority item, the _next-highest_ item floats to the top of the heap and is on dech to be addressed next.

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
