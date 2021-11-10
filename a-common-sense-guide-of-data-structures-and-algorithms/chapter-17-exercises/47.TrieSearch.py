class TrieNode:
  def __init__(self):
    self.children = {}

class Trie:
  def __init__(self):
    self.root = TrieNode()

  def search(self, word):
    currentNode = self.root

    for char in word:
      # If the current node has child key with current character
      if currentNode.children.get(char):
        # follow the child node:
        currentNode = currentNode.children[char]
      else:
        # If the current character isn't found among the current node's children
        # our search word must not be in the trie
        return None

    return currentNode