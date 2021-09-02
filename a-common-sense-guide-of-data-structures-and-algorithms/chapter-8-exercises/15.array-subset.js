
function isSubset(array1, array2) {
  let largerArray
  let smallerArray

  if (array1.length > array2.length) {
    largerArray = array1
    smallerArray = array2
  } else {
    largerArray = array2
    smallerArray = array1
  }

  for(let i = 0; i < smallerArray.length; i++) {
    let foundMatch = false

    for(let j = 0; j < largerArray.length; j++) {
      if(smallerArray[i] === largerArray[j]) {
        foundMatch = true
        break
      }
    }

    if (foundMatch === false) { return false }
  }

  return true
}

console.log(isSubset(["a", "b", "c", "d", "e", "f"], ["b", "d", "f"]))