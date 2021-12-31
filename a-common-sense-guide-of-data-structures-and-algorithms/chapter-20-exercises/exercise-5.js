// First approximation
function sortTemperatureReadings(array) {
  const sortArray = [array.pop()]
  for (let temperature of array) {
    console.log('Array before search:', sortArray)
    let index = binarySearch(sortArray, temperature, 0)
    console.log('Array after search:', sortArray, ' index:', index)
    sortArray.splice(index, 0, temperature)
  }

  return sortArray
}

function binarySearch(array, value, index) {
  if (array.length === 1) {
    console.log('Array in search:', array, ' index:', index, ' value:', value)
    if (value > array[0]) {
      return index + 1
    } else {
      return index
    }
  }
  let middle = array.length / 2
  if (value > array[middle]) {
    binarySearch(array.slice(middle + 1), value, index + middle + 1)
  } else {
    binarySearch(array.slice(0, middle), value, index)
  }
}

// const result = sortTemperatureReadings([98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1])

// Second approximation

/*
You have a limited number of temperatures from 97.0 to 99.0, so we are going to save in a hash table in order to know how many temperatures we have
then we can create an loop since 99.0 to 97.0 to know if there are a coincidence we can fill a array with the correct order. 
*/
function sortTemperatures(array) {
  const hashTable = {}

  for(let temperature of array) {
    if (hashTable[temperature]) {
      hashTable[temperature] = hashTable[temperature] + 1;
    } else {
      hashTable[temperature] = 1;
    }
  }

  let sortArray = []

  for(let i = 970; i <= 990; i++) {
    let currentTemperature = i / 10
    if (hashTable[currentTemperature]) {
      let repeatTemperature = hashTable[currentTemperature]
      while (repeatTemperature > 0) {
        sortArray.push(currentTemperature)
        repeatTemperature -= 1
      }
    }
  }
  return sortArray
}

const result = sortTemperatures([98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1])
console.log(result)
