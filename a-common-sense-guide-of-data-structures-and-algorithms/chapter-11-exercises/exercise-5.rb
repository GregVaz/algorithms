def countShortestPaths(row, col)
  return 1 if row == 1 || col == 1
  return countShortestPaths(row - 1, col) + countShortestPaths(row, col - 1)
end

puts countShortestPaths(3,3)

# To see an example of the development of this problem, you can see the exercise-5.pdf document