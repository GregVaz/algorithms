// Algorithm that collects every combination of two characters
function wordBuilder(array) {
  let collection = []

  for(let i = 0; i < array.length; i++) {     // N times
    for(let j = 0; j < array.length; j++) {   // * N times
      if(i !== j) {
        collection.push(array[i] + array[j])
      }
    }
  }
  return collection
}

// Big O Notation: N*N = O(N^2)

function wordBuilder(array) {
  let collection = []

  for(let i = 0; i < array.length; i++) {       // N times
    for(let j = 0; j < array.length; j++) {     // * N times
      for(let k = 0; k < array.length; k++) {   // * N times
        if(i !== j && j !== k && i !== k) {
          collection.push(array[i] + array[j] + array[k])
        }
      }
    }
  }
  return collection
}

// Big O Notation: N*N*N = O(N^3)