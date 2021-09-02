function nonDuplicated(string) {
  let hashTable = {}

  for (const value of string) {
    if (hashTable[value]) {
      hashTable[value] = hashTable[value] + 1
    } else {
      hashTable[value] = 1
    }
  }

  for (const value of string) {
    if (hashTable[value] === 1) {
      return value
    }
  }

  return null
}

console.log(nonDuplicated("minimum"))