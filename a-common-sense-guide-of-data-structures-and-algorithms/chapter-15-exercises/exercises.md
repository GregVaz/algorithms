1. Imagine you were to take an empty binary search tree and insert thefollowing sequence of numbers in this order: [1, 5, 9, 2, 4, 10, 6, 3, 8].
   Draw a diagram showing what the binary search tree would look like.

2. if a well-balanced binary search tree contains 1,000 values, what i the maximum number of steps it would take to search for a value within it?

3. Write an algorithm that finds the greeates value wthin a binary search tree.

4. In the text I demonstrated how to user inorder traversal to print a list of all the book titles. Another way to traverse a tree is known as preorder traversal. Here is the code for it as applied to our book app.

```python
def traverse_and_print(node):
  if node is None:
    return
  print(node.value)
  traverse_and_print(node.leftChild)
  traverse_and_print(node.rightChild)
```

- For the example of tree in the text, wirte out the order in which the book titles are printeed with preorder traversal.
  List of books: ["Moby Dick", "Great Expectations", "Robinson Crusoe", "Alice in Wonderlan", "Lord of the Flies", "Pride and Prejudice", "The Odyssey"]

5. There is yet another from of traversal called _postorder traversal_. Here is the code as applied to our book app:

```python
def traverse_and_print(node):
  if node is None:
    return
  traverse_and_print(node.leftChild)
  traverse_and_print(node.rightChild)
  print(node.value)
```

- For the example of tree in the text, wirte out the order in which the book titles are printed in postorder traversal.
  List of books: ["Moby Dick", "Great Expectations", "Robinson Crusoe", "Alice in Wonderlan", "Lord of the Flies", "Pride and Prejudice", "The Odyssey"]

> 1.r =

```
    1
      \
        5
      /   \
    2       9
    \     /   \
      4  6    10
    /     \
  3         8
```

> 2.r = 2^10 = 1024 -> 10 steps

> 3.r =

```python
def greatest(node):
  if node.rightChild is None:
    return node.value
  if node.rightChild:
    return greatest(node.rightChild)

def max(node):
  if node.rightChild:
    return max(node.rightChild)
  else:
    return node.value
```

> 4.r =

```
"Moby Dick"
"Great Expectations"
"Alice in Wonderlan"
"Lord of the Flies"
"Robinson Crusoe"
"Pride and Prejudice"
"The Odyssey"
```

> 5.r =

```
"Alice in Wonderlan"
"Lord of the Flies"
"Great Expectations"
"Pride and Prejudice"
"The Odyssey"
"Robinson Crusoe"
"Moby Dick"
```
