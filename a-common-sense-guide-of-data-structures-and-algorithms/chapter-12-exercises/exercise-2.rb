def golomb(n, memo = {})
  return 1 if n == 1
  if !memo.key?(n)
    memo[n] = golomb(n - golomb(golomb(n - 1, memo), memo), memo)
  end
  
  return 1 + memo[n]
end

puts golomb(5)