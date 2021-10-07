class TreeNode:
  def __init__(self, val, left=None, right=None):
    self.value = val
    self.leftChild = left
    self.rightChild = right

node1 = TreeNode(25)
node2 = TreeNode(75)
root = TreeNode(50, node1, node2)