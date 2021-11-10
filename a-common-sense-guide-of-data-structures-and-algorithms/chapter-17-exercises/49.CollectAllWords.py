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

    def collectAllWords(self, node=None, word="", words=[]):
      # This method accepts three arguments,
      # The first is the node whose descendants we're collecting words from.
      # The second argument, begins as an empty string, and we add characters to it as we move through the trie.
      # The third argument, begins as an empty array, and by the end of the function will containt all the words from the trie.

        # The current node is the node passed in as the first parameters, or the oort node if none is provided:
        currentNode = node or self.root

        # We iterate through all the current node's children
        for key, childNode in currentNode.children.items():
            # If the current key is *, it means we hit the end of a complete word, so we can add it to our words array
            if key == "*":
                words.append[word]
            else:  # If we're still in the middle of a word
                # We recursively call this function on the child node
                self.collectAllWords(childNode, word + key, words)

        return words
