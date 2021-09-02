def nonDuplicated(string):
  hashTable = {}

  for value in string:
    if hashTable.get(value):
      hashTable[value] = hashTable[value] + 1
    else:
      hashTable[value] = 1
    

  for value in string:
    if hashTable[value] == 1:
      return value

  return None


print(nonDuplicated("minimum"))