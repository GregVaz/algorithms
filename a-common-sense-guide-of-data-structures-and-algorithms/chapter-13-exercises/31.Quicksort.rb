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
end

array = [3,6,34,1,878,8,32,1,4,9]
sort = SortableArray.new(array)
sort.quicksort!(0, array.length - 1)
puts sort.array
