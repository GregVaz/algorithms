class Heap
  def initialize
    @data = []
  end

  def root_node
    return @data.first
  end

  def last_node
    return @data.last
  end

  def left_child_index(index)
    return (index * 2) + 1
  end

  def right_child_index(index)
    return (index * 2) + 2
  end

  def parent_index(index)
    return (index - 1) / 2
  end

  def insertion(value)
    # Turn value into last node by inserting it at the end of the array
    @data << value

    # Keep track of the index of the newly inserted node
    new_node_index = @data.length - 1

    # The following loopexecutes the "trickle up" algorithm

    # if the new node is not in the root position, and it's greater than its parent node
    while new_node_index > 0 && 
      # swap the ndew node with the parent node:
      @data[new_node_index] > @data[parent_index[new_node_index]]
      @data[parent_index(new_node_index)], @data[new_node_index] = 
        @data[new_node_index], @data[parent_index[new_node_index]]

      # update the nidex of the new node
      new_node_index = parent_index(new_node_index)
    end
  end
end