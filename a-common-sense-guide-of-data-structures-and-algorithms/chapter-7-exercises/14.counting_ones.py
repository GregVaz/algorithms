def count_ones(outer_array):
  count = 0
  for inner_array in outer_array:
    for number in inner_array:
      if number == 1:
        count++
  
  return count

# The outer loop is iterating over the inner arrays, and the inner loop is iterating over the actual numbers
# At the end of the day, our inner loop only runs for as many numbers as there are in total

# We can say that N represents how many numbers there are, and since our algorithm simply processes each number,
# the function's time complexity is O(N)