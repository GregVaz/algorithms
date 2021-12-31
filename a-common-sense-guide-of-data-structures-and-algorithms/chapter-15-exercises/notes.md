# Speeding Up All the Things with Binary Search Trees

What do we do if we want a data structure that maintains order yet also has fast search, insertion and deletion?
Neither an ordered array nor a hash table is ideal.
-> Enter the Binary Search Tree

## Trees

In classic linked list, each node contains a link that conects the node to a single other node.
A tree is also a node-based data structure, but within a tree, each node can have links to multiple nodes.

```
      "j"
     /   \
    /     \
  "m"     "b"
  / \     / \
"q" "z"  "t" "s"
```

Tree nomenclature:

- The uppermost node (the "j") is called the root. The root is the top of the tree.
- We would say that the "j" is a parent to a "m" and "b"
  - Conversely, "m" and "b" are children of "j"
  - Similary, the "m" is a parent of "q" and "z"
- as in a family tree, a node can have descendants and ancestors.
  A node's descendants are all the nodes that stem from a node.
  while a node's ancestors are all the nodes that it stems from.
- Trees are said to have levels. Each level is a row within the tree.
  The tree above has tree levels
- One property of the tree is _how balanced it is_. A tree is balances when its node's subtrees have the same number of nodes in it.

## Binary Search Tree

Note that there are two adjectives here: binary and search.

A binary tree is a tree in which each node has zero, one or two children.
A binary search tree aalso abides by the following rules:

- Each node can have at most one "left" child ad one "right" child.
- A node's "left" descendants can only contain values that are less than the node itself.
  Likewise, a node's "right" descendants can only contains values that are greater than the node itself.

```
         50
        /   \
      25     75
      / \    / \
    10  33  56 89
```

It's a binary tree because each node has zero, one or two children.

## Searching

The algorithm for searching within a binary search tree is as follows:

1. Designate a node to be the "current node" (At the beginning of the algorithm, the root node is the first "current node")
2. Inspect the value at the current node
3. If we've found the value we're looking for, great!
4. If the value we're looking for is less than the current node, search for it in its left subtree.
5. If the value we're looking for is greater than the current node, search for it in its right subtree.
6. Repeat steps 1 through 5 until we find the value we're searching for, or until we hit the bottom of the tree, in which case our value must not be in the tree

### The efficiency of searching a Binary Search Tree

Each step eliminates half of the remaining nodes from our serach, so when we begin our search, we start at the root node, and our desired value may be found among any of the root's descendants.
However, when we then ecide to continue the search with, say, the root's right child, we eliminate the left child and all of its descendants from the search.

The searching in a binary search tree is O(log N)

### Log(N) Levels

If there are N nodes in a balanced binary tree, there will be about log N levels.
It emerges that each new level doubles the size of the tree. Accordingly, a tree containing N nodes will require log(N) levels to hold all the nodes.

## Insertion

Binary search trees are at their best when it comes to insertion.

Insertion always takes just one extra step beyond a search, which means insertion takes (log N) + 1 steps.
In Big O Notation, which ignores constantas, this is O(log N).

In an ordered array, by contrast, insertion takes O(N), because in addition to search, we must shift a lot of data to the right to make room for the value we're inserting.

This is what makes binary search trees si efficient.
While ordered arrays have O(log N) search and O(N) insertion. Binary search trees have O(log N) search and O(log N) insertion.

### The order of insertion

It is important that only wen creatin a tree out of randomly sorted data do trees usually wind up being well-balanced.
However, if we insert sirted data into a tree, it can become imvalanced and less efficient.

For example, if we were to insert the following data in this order [1, 2, 3, 4, 5]
we'd end up with a tree that looks like this:

```
  1
    \
      2
        \
          3
            \
              4
                \
                  5
```

This tree is completely linear, so searching for the 5 within this tree would take O(N).

However, if we insert the same data in the following order [3, 2, 4, 1, 5] the tree would be evenly balance

```
        3
       /  \
      2     4
    /         \
  1             5
```

## Deletion

Deletion is the least straightforward operation within a binary search tree and requires some caregul maneavering

Our deletion algorithm has to follow these rules:

- If the node being deleted has no children, simply delete it.
- If the node being deleted has one child, delete the node and plug the child info the spot where the deleted node was.
- When deleting a node with two childre, replace the deleted node with the successor node. The successor node is the child node whose value is _the least of all values that are greater than the deleted node_
- To find the successor node: visit the right child of the deleted value, and then keep on visiint the left child of each subsequent child until there are no more left children. The bottom value is the successor node.
- If the successor node has a right child, after plugging the successor node into the spot of the deleted node, take the former right child of the successor node and turn it into the _left child of the former parent of the successor node_

### What does the lift function do?

1. It finds the successor node
2. It overwrites the value of the nodeToDelete and makes it the value of the successor node. This is how we get the successor node into the correct spot. Note that we don't move the actual successor node _object_ anywhere; we simply copy its value into the node we're "deleting".
3. To eliinate the original successor node object, the function then turns tohe original successor node's right child into its parent's left child.
4. After all the recursion is said and done, it finally returns either the original rightChild passed into the first place, or None if the original rightChild ended up serving as the succesor node (which would happen if it had no left children of its own.)

### The efficiency of Binary Search Tree Deletion

Like search and insertion, deleting from trees is also tipicallu O(log N). This is because deletion requires a search plus a few extra sptes t deal with any hanging children.

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
