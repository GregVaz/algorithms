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

  def delete
    # We only delete the root node from a heap, so we pop the last node from the array to make it the root node
    @data[0] = @data.pop

    # Track the current index of the "trickle node"
    trickle_node_index = 0

    # The following loop executes the "trickle down" algorithm:

    # We run the loop as long as the trickle node has a child that is greatear than it
    while has_greater_child(trickle_node_index)
      # Save the larger child index in variable
      larger_child_index = calculate_larger_child_index(trickle_node_index)

      # swap the trickle node with its larger child
      @data[trickle_node_index], @data[larger_child_index] = 
        @data[larger_child_index], @data[trickle_node_index]

      # Update trickle node's new index
      trickle_node_index = larger_child_index
    end

    def has_greater_child(index)
      # We check wheter the node at index has left and right children and if either of those 
      # children are greater than the node at index:
      (@data[left_child_index] && @data[left_child_index] > @data[index]) ||
      (@data[right_child_index] && @data[right_child_index] > @data[index])
    end

    def calculate_larger_child_index(index)
      # If there is no right child:
      if !@data[right_child_index(index)]
        # return the left child index
        return left_child_index(index)
      end

      # If right child value is freater than left child value
      if @data[right_child_index(index)] > @data[left_child_index(index)]
        # return right child index
        return right_child_index(index)
      else # if the left child value is greater or equal to right child
        # return the left child index
        return left_child_index(index)
      end
    end
  end
end