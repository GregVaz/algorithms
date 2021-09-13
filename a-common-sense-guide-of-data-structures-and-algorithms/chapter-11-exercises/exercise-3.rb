def triangularNumber(n)
  return 1 if n == 1
  return n + triangularNumber(n - 1)
end

puts triangularNumber(7)