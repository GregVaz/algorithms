function greatestNumber_N2(array) {
  let greatest = array[0]
  let count = 0

  for(let i = 0; i < array.length; i++) {
    for(let j = i + 1; j < array.length; j++) {
      count++
      if (array[j] > greatest) {
        greatest = array[j]
      }
    }
  }
  console.log(`Llamadas en funcion O(N^2): ${count}`)
  return greatest
}

function greatestNumber_logN(array) {
  array.sort((a, b) => (a < b) ? -1 : 1) // O(N log N) 
  console.log('Funcion con O(N log N)')
  return array[array.length - 1]
}

function greatestNumber_N(array) {
  let greatest = array[0]
  let count = 0
  for(let i = 0; i < array.length; i++) {
    count++
    if (array[i] > greatest) {
      greatest = array[i]
    }
  }
  console.log(`Llamadas en funcion O(N): ${count}`)

  return greatest
}

console.log(greatestNumber_N2([3,1,6,2,78,5,9,3,8,3,7,4,55,3,5,77,6,3,5,8,55,4,4,3,3,33,776]))
console.log(greatestNumber_logN([3,1,6,2,78,5,9,3,8,3,7,4,55,3,5,77,6,3,5,8,55,4,4,3,3,33,776]))
console.log(greatestNumber_N([3,1,6,2,78,5,9,3,8,3,7,4,55,3,5,77,6,3,5,8,55,4,4,3,3,33,776]))