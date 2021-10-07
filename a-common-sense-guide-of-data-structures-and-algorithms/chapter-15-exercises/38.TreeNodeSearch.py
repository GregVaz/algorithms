class TreeNode:
  def __init__(self, val, left=None, right=None):
    self.value = val
    self.leftChild = left
    self.rightChild = right

  def search(searchValue, node):
    # Base case: If the node is nonexistent or we've found the value we're looking for:
    if node is None or node.value == searchValue:
      return node
    # If the value is less than the current node, perform search on the left child:
    elif searchValue < node.value:
      return search(searchValue, node.leftChild)
    # If the value is greater than the current node, perform search on the right child:
    else:
      return search(searchValue, node.rightChild)