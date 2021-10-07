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

  def insertion(value, node):
    if value < node.value:
      # If the left child does not exist, we want to insert the value as the left child
      if node.leftChild is None:
        node.leftChild = TreeNode(value)
      else:
        insert(value, node.leftChild)
    else:
      # if the right child odes not exits, we want to insert the value as the right child
      if node.rightChild is None:
        node.rightChild = TreeNode(value)
      else:
        insert(value, node.rightChild)

  def delete(valueToDelete, node):
    # the base case is when we've hit the bottom of the tree, 
    # and the parent node has no children
    if node is None:
      return None
    # If the value we're deleting is less or greater than the current node,
    # we set the left or right child respectively to be the return value of a recursive call of this
    # very method on tue current node's left or right subtree 
    elif valueToDelete < node.value:
      node.leftChild = delete(valueToDelete, node.leftChild)
      # We return the current node (and its subtree if exists) to be used
      # as the new value of its parent's left or right child:
      return node
    elif valueToDelete > node.value:
      node.rightChild = delete(valueToDelete, node.rightChild)
      return node
    # If the current node is the one we want to delete:
    elif valueToDelete == node.value:
      # If the current node has no left child, we delete it by returnint its right child
      # (and its subtree if existent) to be its parent's new subtree
      if node.leftChild is None:
        return node.rightChild

        # (if the current node has no left or right child, this endsup being None as per the base case) 
      elif node.rightChild is None:
        return node.leftChild

      # Id the current node has two children, we delete current node by calling the lift() function,
      # which changes the current node's value to the value of its successor node:
      else: 
        node.rightChild = lift(node.rightChild, node)
        return node
    
  def lift(node, nodeToDelete):
    # If the current node of this functions has a left child,
    # we recursively call this function to continue down
    # the left subtree to find the successor node.
    if node.leftChild:
      node.leftChild = lift(node.leftChild, nodeToDelete)
      return node
    # If the current node has no left child, that means the current node
    # of this functions is the successor node, and we take its value
    # and make it the new value of the node taht we're deleting:
    else:
      nodeToDelete.value = node.value
      # we return the successor node's right child to be now used as its parent's left child:
      return node.rightChild