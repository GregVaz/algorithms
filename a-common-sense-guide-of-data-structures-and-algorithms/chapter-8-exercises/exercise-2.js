function areDuplicates(array) {
  let hashTable = {}

  for(const value of array) {
    if (hashTable[value]) {
      return value
    } else {
      hashTable[value] = true
    }
  }

  return true
}

console.log(areDuplicates(["a", "b", "c", "d", "e", "f", "c"]))