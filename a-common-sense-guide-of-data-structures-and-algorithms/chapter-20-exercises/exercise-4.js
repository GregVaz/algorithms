function greatestProduct(array) {
  let positiveIndex = 0;
  let negativeIndex = 0;
  let current_product = 0;
  let temporal_product = 0;

  for (let i = 1; i < array.length; i++) {
    let current_number = array[i]
    if (current_number > 0) {
      // if the current number is positive, then we can multiply the greatest positive number in the array with the current positive number
      temporal_product = array[positiveIndex] * current_number
      // if the previous product is greater than the current product then we change the current product
      if (temporal_product > current_product) current_product = temporal_product
      // if the current positive number is greater then the current greatest positive number then we change the index
      if (current_number > array[positiveIndex]) positiveIndex = i;
    } else {
      // if the current number is negative, then we can multiply the lowest negative number in the array with the current negative number
      temporal_product = array[negativeIndex] * current_number
      // if the previous product is greater than the current product then we change the current product
      if (temporal_product > current_product) current_product = temporal_product
      // if the current negative number is lower then the current lowest negative number then we change the index
      if (current_number < array[negativeIndex]) negativeIndex = i;
    }
  }
  return current_product
}

const result = greatestProduct([5, -10, -6, 9, 4])
console.log(result) // 60