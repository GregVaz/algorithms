# It doesn't hurt to Trie

## Tries

The _trie_ is a kind of tree that is ideal for text-based features such as autocomplete.

### The trie node

Like most other trees, the trie is a collections of nodes that point to other nodes.
However, the trie is _not a binary tree_. Whereras a binary tree doesn't allow any node to have more than two child nodes, a trie node can have any number of child nodes.

The implementation of the actual trie node itself is very simple

```python
class TrieNode:
  def __init__(self):
    self.children = {}
```

As you can see, **A TrieNode just constains a hash table**

In this hash table, the keys are individual character strings, and the values are instances of other TrieNodes.

### The Trie Class

to fully create our trie, we will also need a separete Trie class, which will keep track of the root node:

```python
class Trie:
  def __init__(self):
    self.root = TrieNode()
```

The class keeps track of a self.root variable that points to the root node.
In this implementation, when we create a new Trie, it begins with an empty TrieNode as its root.

### Storing words

Now, the point of our trie is to store words. Let's see how the following trie stores the words, "ace", "bad", and "cat"

This trie stores the tree words by turning each character of each words into its own trie node.

```
    {"a": °, "b": °, "c": °}
          |       |       |
         /       /       /
      {"c": °}  {"a": °}  {"a": °}
            |         |         |
      {"e": °}  {"d": °}  {"t": °}
            |         |         |
    {"*",: nil}  {"*",: nil}   {"*",: nil}
```

### The need for the Asterisk

Let's say we want to store the words "bat" and "batter" in a trie. This is an interesting case, since the word "batter" actually contains the word "bat".

The first "t" points to a node that has _two keys_. One key is a "\*" key, while the other is "t" whose value points to another node. This indicates that "bat" is itself a word, even though it's also a prefix of the longer word "batter"

## Trie Search

The most classic trie operation is search, determing whether a string is found in the trie.
There are two flabors of search: we can search to seee whether the string is a _complete word_, or we can search to see whether the string is at least a word _prefix_.

Now we will look for prefixes. This search will end up finding complete words as well, since a complete wordis at least as good as prefix.

The algorithm for prefix search performs the following steps:

1. We establish variable called **currentNode**. At the beginning of our algorithm, this points to the root node.
2. We iterate over each character of our search string.
3. As we point to each character of our searching string, we look to see if the _currentNode_ has a child with that character as a key.
4. If it does not, we return _None_, as it means our search string does not exist in the trie.
5. If the _currentNode_ does have a child with the current character as the key, we update the currentNode to become that child. We then go back to Step 2, continiung to iterate over each character in our search string.
6. If we get to the end of our search string, it means we've found our search string.

## The Efficiency of Trie Search

The great thing about trie search is that it's incredibly efficient.

In out algorithm, we focus on each character of our search string one at a time. As we do so, we use each node's hash table to find the appropiate child node in one step. As you know, a hsah table lookup takes just O(1) time. It turns out, then, that our algorithm takes as any steps as _there are characters in our search string_

This can be much faster than using binary search on an ordered array. Binary Search is O(log N), with N being he number of words in our dictionary. Trie search, on the other hand, takes only as many steps as the number of character in our search term. For a word like "cat", that's just three steps.

Most references have decided to call this O(K), where K is the number of characters in our search string.

## Trie Insertion

Inserting a new word into a trie is similar to searching for an existing word.

1. We establish a variable called _currentNode_. At the beginning of our algorithm, this points to the root node.
2. We iterate over eac character of our search string.
3. As we point to each character of our search string, we look to see if the _currentNode_ has a child with that character as a key.
4. If it does, we update the _currentNode_ to become that child node and we go back to Step 2, moving on to the next character of our search string.
5. If the _currentNode_ does not have a child node that matches the current character, we create such a child node and update the _currentNode_ to this new node. We then go back to Step 2, moving on to the next character of our search string.
6. After we insert the final character of our new word, we add a "\*" child to the last node to indicate the word is complete.

# Building Autocomplete

We are ready to build a real autocomplete feature.
First let's build a slighly simpler function that we'll help us

## Collection all the Words

The next method we're going to add to our Trie class is a method that returns an array of all the words in the trie.
Now it's rare that we'd actually want to list the _entire dictionary_. However we are going to allow this method to accept any node of the trie as an argument so taht it can list all the words that start from that node.

The following method, called _collectAllWords_, collects a list of all the trie's words starting from a particular node.

## Completing Autocomplete

By using our search method and collectAllWords method together we can autocomplete any prefix.

The autocomplete method accepts the prefix parameter, which is the string of characters the user begins typing in.

First we search the trie for the existence of the prefix. If the _search_ method doesn't find the prefix in the trie, it returns None. However, if the prefix is found in the trie, the method returns _the node in the trie that represents the final character in the prefix_.

We noted earlier that we could have simply had the search method return True once it finds the word. The reason t=why we had ir return the final node was so that we could use the search method to help us with the autocomplete feature.

Out autocomplete method continues by calling the _collectAllWords_ method on the node returned by the search method. This fins and collects all words that stem from that final node, which represents all the complete words that can be appended to the original predix to form a word.

Our method finally returns an array of all possible endings to the user's prefix, which we could then display to the user as possible automcomplete options.

# Tries with Values: A Better Autocomplete

A good autocomplete feature isn't necessarily foinf to display every possible word the user might be intending to type.
Showing, say, sixteen options would be overwhelming tot he user, so we'd rather show just to most popular words from the available list.

In order to display the most popular word options, we somehow need to store te word popularity data in our trie as well.
And we're in luch, since we only need to make a slight modification to our trie to accomplish this.

In out current trie implementation, every time we've set a "\*" key, we've made its value null. THis is because we've only ever paid attention to the "\*" key. However, we can take advantage of these values to store additional data about the popularity of them.
To keep thigs simple, let's work with a simple range of 1 to 10, with 1 being the rarest kind of word, and 10 being the extremely popular word.

Excerpt From: Jay Wengrow. “A Common-Sense Guide to Data Structures and Algorithms, Second Edition, 2nd Edition. Chapter-17 It doen's hurt to Trie”
