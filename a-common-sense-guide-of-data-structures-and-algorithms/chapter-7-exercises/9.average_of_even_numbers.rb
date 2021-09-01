def average_of_even_numbers(array)
  sum = 0.0                           # 1 step
  count_of_even_numbers = 0           # 1 step

  array.each do |number|              # N steps
    if number.even?                   # 1 step inside the N steps
      sum += number                   # 1 step inside the N steps
      count_of_even_numbers += 1      # 1 step inside the N steps
    end
  end
  return sum / count_of_even_numbers  # 1 step
end

# The total number of steps is 3N + 3
# so instead of calling our algorithm O(3N + 3)
# Big O Notation = O(N)