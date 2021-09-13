def findX(string, index = 0)
  return -1 if string.length <= index
  return string[index] == 'x' ? index : findX(string, index + 1)
end

puts findX("abcdefghijklmnopqrstuvwxyz")