def unique_paths_memoization(rows, columns, memo = {})
  return 1 if rows == 1 || columns == 1
  index = "#{rows}-#{columns}"
  if !memo.key?(index)
    memo[index] = unique_paths_memoization(rows - 1, columns) + unique_paths_memoization(rows, columns - 1)
  end
  return memo[index]
end

puts unique_paths_memoization(3,7)