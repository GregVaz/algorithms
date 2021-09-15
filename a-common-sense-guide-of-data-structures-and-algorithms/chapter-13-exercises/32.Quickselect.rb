class SortableArray
  attr_reader :array

  def initialize(array)
    @array = array
  end

  def partition!(left_pointer, right_pointer)
    pivot_index = right_pointer
    
    pivot = @array[pivot_index]

    right_pointer -= 1

    while true
      while @array[left_pointer] < pivot do
        left_pointer += 1
      end

      while @array[right_pointer] > pivot do
        right_pointer -= 1
      end


      if left_pointer >= right_pointer
        break 
      else
        @array[left_pointer], @array[right_pointer] = @array[right_pointer], @array[left_pointer]

        left_pointer += 1
      end
    end

    @array[left_pointer], @array[pivot_index] = @array[pivot_index], @array[left_pointer]

    return left_pointer
  end

  def quicksort!(left_index, right_index)
    if right_index - left_index <= 0
      return
    end
  
    pivot_index = partition!(left_index, right_index)
  
    quicksort!(left_index, pivot_index - 1)
  
    quicksort!(pivot_index + 1, right_index)
  end

  def quickselect!(kth_lowest_value, left_index, right_index)
    # If we reach a base case - that is, that the subarray has one cell, we know we've found the value we're looking for
    if right_index - left_index <= 0
      return @array[left_index]
    end

    # Partition the array and gran the index of the pivot
    pivot_index = partition!(left_index, right_index)

    # If what we're looking for is to the left of the pivot
    if kth_lowest_value < pivot_index
      # Recursively perform quickselect on the subarray to the left of the pivot:
      quickselect!(kth_lowest_value, left_index, pivot_index - 1)
    elsif kth_lowest_value > pivot_index
      # Recursively perform quickselect on the subarray to the right of the pivot:
      quickselect!(kth_lowest_value, pivot_index + 1, right_index)
    else # if the kth_lowest_value == pivot_index
      # if after the partition, the pivot position is in the same spot as the kth lowest value, we've found the value we're looking for
      return @array[pivot_index]
    end
  end
end

# If you want to find the third-to-lowest value of an unsorted array, you would run the following code

array = [3,6,34,1,878,8,32,1,4,9]
sort = SortableArray.new(array)
puts sort.quickselect!(2, 0, array.length - 1)
