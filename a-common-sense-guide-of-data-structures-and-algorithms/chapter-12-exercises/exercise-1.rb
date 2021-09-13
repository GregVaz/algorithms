def add_until_100(array)
  return 0 if array.length == 0
  if array[0] + add_until_100(array[1, array.length - 1]) > 100
    return add_until_100(array[1, array.length - 1])
  else 
    return array[0] + add_until_100(array[1, array.length - 1])
  end
end

def add_until_100_v2(array)
  return 0 if array.length == 0
  until_sum = add_until_100_v2(array[1, array.length - 1])
  if array[0] + until_sum > 100
    return until_sum
  else 
    return array[0] + until_sum
  end
end

puts add_until_100_v2([1,2,3,4,5,6,7,8,9,10,11,12,13,14])