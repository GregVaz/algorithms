function findMissingNumber(array) {
  array.sort((a, b) => (a < b) ? -1 : 1)

  for(let i = 0; i <= array[array.length - 1]; i++) {
    if (array[i] !== i) {
      return i
    }
  }

  return null
}

console.log(findMissingNumber([0,1,6,3,8,2,9,4,5,7]))