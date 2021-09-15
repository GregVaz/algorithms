function greatestProduct(array) {
  array.sort((a, b) => (a < b) ? -1 : 1)

  return array[array.length - 3] * array[array.length - 2] * array[array.length - 1]
}

console.log(greatestProduct([8,2,6,4,9,1,5,7,2]))