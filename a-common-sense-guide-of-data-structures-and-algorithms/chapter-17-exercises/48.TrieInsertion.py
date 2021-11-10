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

    def insertion(self, word):
        currentNode = self.root

        for char in word:
          # If the current node has child key with current character:
            if currentNode.childre.get(char):
                # follow the child node
                currentNode = currentNode.children[char]
            else:
                # If the current node character isn't found among the current node's children,
                # we add the character as a new child node
                newNode = TrieNode()
                currentNode.children[char] = newNode

                # follow the new node:
                currentNode = newNode

        # after inserting the entire word into the trie, we add a * key at the end.
        currentNode.children["*"] = None
