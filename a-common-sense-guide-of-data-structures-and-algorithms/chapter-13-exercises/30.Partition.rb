class SortableArray
  attr_reader :array

  def initialize(array)
    @array = array
  end

  def partition!(left_pointer, right_pointer)
    # Choose the right-most element as the pivot. 
    pivot_index = right_pointer
    
    # We grab the pivot value itself 
    pivot = @array[pivot_index]

    # We start the right pointer immediately to the left of the pivot
    right_pointer -= 1

    while true
      # Move the left pointer to the right as long as it points to value that is less than the pivot
      while @array[left_pointer] < pivot do
        left_pointer += 1
      end

      # Move the right pointer to the left as long as it points to value that is greater than the pivot
      while @array[right_pointer] > pivot do
        right_pointer -= 1
      end

      # We check whether the left pointer has reached or gone beyond the right pointer. 
      # It it has, we break out the loop so we can swapt te pivot later
      if left_pointer >= right_pointer
        break
      
      # If the left pointer is still to the left of the rifht pointer, we swap the values of the left and right pointers
      else
        @array[left_pointer], @array[right_pointer] = @array[right_pointer], @array[left_pointer]

        # We move the left pointer over the right, gearing up for the next round of left and right pointer movements 
        left_pointer += 1
      end
    end

    # As the final step of the partition, we swap the value of the left pointer with the pivot
    @array[left_pointer], @array[pivot_index] = @array[pivot_index], @array[left_pointer]

    # We return the left_pointer for the sake of the quicksort method
    return left_pointer
  end
end

# array = [3,6,34,1,878,8,32,1,4,9]
# sort = SortableArray.new(array)
# puts sort.partition!(0, array.length - 1) # 6
# puts sort.array # [3, 6, 4, 1, 1, 8, 9, 879, 34, 32]