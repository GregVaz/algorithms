1. Use Big O Notation to describe the time complexityof the following function that determines wheteher a given year is a leap year:

```
function isLeapYear(year) {
  return (year % 100 === 0) ? (year % 400 === 0) : (year % 4 === 0)
}
```

2. Use Big O Notation to descrive the time complexity of the following function that sums up all the numbers from a given array:

```
function arraySum(array) {
  let sum = 0

  for(let i = 0; i < array.length; i++) {
    sum += array[i]
  }

  return sum
}
```

3. The following function is based on the age-old analogy used to describe the power of compounding interest:

Image you have a chessboard and put a single grain of rice on one square. On the second square, you put 2 grains of rice, since that is double the amount of rice on the previous square. On the third square, you put 4 grains. On the fourth square, you put 8 grains, and on the fifth square, you put 16 grains, and so on.
Use Big O Notation to descrive the time complexity of the following function:

```
function chessboardSpace(numberOfGrains) {
  let chessboardSpaces = 1
  let placedGrains = 1

  while(placedGrains < numberOfGrains) {
    placedGrains += 2
    chessboardSpaces += 1
  }

  return chessboardSpaces
}
```

4. The following funciont accepts an array of strings and returs a new array that only contains the strings that start with the character "a".
   Use Big O Notation to describe the time complexity of the function:

```
function selectAStrings(array) {
  let newArray = []

  for(let i = 0; i < array.length; i++) {
    if (array[i].startsWith("a")) {
      newArray.push(array[i])
    }
  }

  reutnr newArray
}
```

5. The following function calculates the median from an ordered array. Describe its time complexity in terms of Big O Notation

```
function median(array) {
  const middle = Math.floor(array.length / 2)

  if (array.length % 2 === 0) {
    return (array[middle - 1] + array[middle]) / 2
  } else {
    return array[middle]
  }
}
```

> 1.r = O(1)

> 2.r = O(N)

> 3.r = O(log N)

> 4.r = O(N)

> 5.r = O(1)
