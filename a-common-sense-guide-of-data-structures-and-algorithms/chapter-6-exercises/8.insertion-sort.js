function insertionSort(array) {
  for (let i = 1; i < array.length; i++) {
    let position = i - 1
    let temp_value = array[i]
    while (position >= 0) {
      if (array[position] > temp_value) {
        array[position + 1] = array[position]
        position--
      } else {
        break
      }
      array[position + 1] = temp_value
    }
  }

  return array
}

console.log(insertionSort([1,5,11,5,43,342,6,2354,2,56,3]))