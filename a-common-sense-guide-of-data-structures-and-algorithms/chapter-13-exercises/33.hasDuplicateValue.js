// Sorting as a Key to other Algorithms

function hasDuplicateValue(array) {
  // Presort the array
  // Sort the array with the JavaScript function 
  array.sort((a,b) => (a < b) ? -1 : 1)

  for (let i = 0; i < array.length - 1; i++) {
    if (array[i] == array[i + 1]) {
      return true
    }
  }

  return false
}

console.log(hasDuplicateValue([1,2,3,4,5,5,6,7,8,9])) // Big O of O(N)
console.log(hasDuplicateValue([1,2,3,4,5,6,7,8,9]))