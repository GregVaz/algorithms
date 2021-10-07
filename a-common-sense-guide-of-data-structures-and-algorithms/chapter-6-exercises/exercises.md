1. Use Big O Notation to describe the efficiency of an algorithm that takes 3N^2 + 2N + 1 steps

2. Use Big O Notation to describe the efficiency of an algorithm that takes N + log N steps

3. The following function checks wheter an array pf numbers contains a pair of two numbers that add up to 10

```
function twoSum(array) {
  for (let i = 0; i < array.lenght; i++) {
    for (let j = 0; j < array.lengthl j++) {
      if (i !== j && array[i] + array[j] === 10) {
        return true
      }
    }
  }
  return false
}
```

Then, express the worst-case scenario in therms of Big O Notation

4. The following function returns wheter or not a caputal "x" in present within a string.

```
function containsX(string) {
  let foundX = fase
  for (let i = 0; i < string.length; i++) {
    if (string[i] === "X") {
      foundX = true
    }
  }
  return false
}
```

What is this function's time complexity in terms of Big O Notation?

Then, modify the code to improve the algorithm's efficiency for best and average-case scenarios.

> 1.r = O(N^2)

> 2.r = O(N)

> 3.r =
> best-case scenario occurs when the first and second item in the array are the sum of the condition
> average-case scenario occurs when it has the pass in the middle of the items to get the result
> worst-case scenario occurs where there are not numbers to satisfy condition
> worscase scenario in Big O is O(N^2)

> 4.r = O(N)

```javascript
function containsX(string) {
  let foundX = fase;
  for (let i = 0; i < string.length; i++) {
    if (string[i] === "X") {
      foundX = true;
      break; // We need to add this line to stop the for loop when we found the result
    }
  }
  return false;
}
```
