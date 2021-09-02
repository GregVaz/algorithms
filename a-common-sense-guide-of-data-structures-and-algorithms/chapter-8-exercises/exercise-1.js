function intersection(array1, array2) {
  let largerArray
  let smallerArray
  let hashTable = {}
  let intersection = []

  if (array1.length > array2.length) {
    largerArray = array1
    smallerArray = array2
  } else {
    largerArray = array2
    smallerArray = array1
  }

  for(const value of largerArray) {
    hashTable[value] = true
  }

  for(const value of smallerArray) {
    if(hashTable[value]) intersection.push(value)
  }

  return intersection
}

console.log(intersection(["a", "b", "c", "d", "e", "f"], ["b", "d", "f", "z", "l"]))