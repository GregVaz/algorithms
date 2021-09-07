def​ ​sum​(low, high)
  return 0 if low > high
  ​​return​ high + sum(low, high - 1)
end​

puts sum(1, 10)