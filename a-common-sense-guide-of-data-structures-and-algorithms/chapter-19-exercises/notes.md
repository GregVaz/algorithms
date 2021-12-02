# Dealing with Space Constraints

Another measure of efficiency that can be useful, which is how much _memory_ and algorithm consumes. This measure is known as _space complexity_.

Space complexity becomes an important factor when memory is limited. If we have an enormous amount of data, or are programming for a small device with limited memory, space complexity can matter a lot.

## Big O of Space Complexity

Computer scientists use Big O Notation to describe space complexity just as they do for time complexity.

We described Big O in terms of waht I called the "Key question". For time complexity, the key question was: _if there are N data elements, how many steps will the algorithm take?_
To use Big O for space complexity, we just need to reframe the key question. When it comes to memory consumption, the key question is: _if there are N data elements, how many units of memory will the algorithm consume?_

Here's an example:

For the next Javascript function that accepts an array of strings and returns an array of those strings in ALL CAPS.

```javascript
function makeUpperCase(array) {
  let newArray = [];
  for (let i = 0; i < array.length; i++) {
    newArray[i] = array[i].toUpperCase();
  }
  return newArray;
}
```

In this makeUpperCase() function, we accept an array, then we create a brand-new array called newArray and fill it with uppercase versions of each string from the original array.
Because our function generated an additional N data elements (in the form of newArray), we'd say that this function has a space efficiency of O(N)

Now, let's write an alternative makeUpperCase() function that is more memory-efficient

```javascript
function makeUpperCase(array) {
  for (let i = 0; i < array.length; i++) {
    array[i] = array[i].toUpperCase();
  }
  return array;
}
```

In this second version, we do not create any new arrays. Insteadm we modify each string within the original _array in place_, transforming them into uppercase one at a time. We return the modified array.
Recall that with time complexity, an O(1) algorithm was one whose speed remained constant no matter how large the data. Similarly, with space complexity, O(1) means that the memory consumed by an algorithm is constant no matter how large the data.

| Version    | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| Version #1 | O(N)            | O(N)             |
| Version #2 | O(N)            | O(1)             |
