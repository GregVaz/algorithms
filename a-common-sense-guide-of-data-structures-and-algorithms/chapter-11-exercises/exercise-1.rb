def countString(array)
  return 0 if array.length == 0
  return array[0].length + countString(array[1, array.length - 1])
end

puts countString(["ab", "c", "def", "ghij", "zxysjw"])