def max_sum(array)
  current_sum = 0
  greatest_sum = 0

  array.each do |num|
    if current_sum + num < 0
      current_sum = 0
    else
      current_sum += num

      greatest_sum = current_sum if current_sum > greatest_sum
    end
  end

  return greatest_sum
end