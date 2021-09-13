def evenNumbers(array)
  return [] if array.length <= 0
  if array[0].even?
    return [array[0]] + evenNumbers(array[1, array.length - 1])
  else
    return [] + evenNumbers(array[1, array.length - 1])
  end
end

puts evenNumbers([1,2,3,4,5,6,7,8,9,10,11,12])