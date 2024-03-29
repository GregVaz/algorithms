1. Given an array of positive numbers, write a function that returns the greatest product of any three numbers. The approach of using three nested loops would clock in at O(N3), which is very slow. Use sorting to implement the function in a way that it computes at O(N log N) speed. (There are even faster implementations, but we’re focusing on using sorting as a technique to make code faster.)

2. The following function finds the “missing number” from an array of integers. That is, the array is expected to have all integers from 0 up to the array’s length, but one is missing. As examples, the array, [5, 2, 4, 1, 0] is missing the number 3, and the array, [9, 3, 2, 5, 6, 7, 1, 0, 4] is missing the number 8.

   Here’s an implementation that is O(N2) (the includes method alone is already O(N), since the computer needs to search the entire array to find n):

```javascript
function findMissingNumber(array) {
  ​for​(let i = 0; i < array.​length​; i++) {
    ​if​(!array.​includes​(i)) {
      return​ i;
    }
  }
  //​ If all numbers are ​present:​
  ​​return​ null;
}
```

3. Write three different implementations of a function that finds the greatest number within an array. Write one function that is O(N2), one that is O(N log N), and one that is O(N).
