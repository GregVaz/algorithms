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

## Trade-offs Between Time and Space

- Version#1

```javascript
function hasDuplicateValue(array) {
  let steps = 0;
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length; j++) {
      steps++;
      if (j !== i && array[i] === array[j]) {
        return true;
      }
    }
  }
  console.log(`Steps: ${steps}`);
  return false;
}
```

This algorithm uses nested loops and has a time complexity of O(N^2). We'll call this implementation Version#1

- Version#2

```javascript
function hasDuplicateValue(array) {
  let exsitingValues = {}
  fot(let i = 0; i < array.length; i++) {
    if(!existingValues[array[i]]) {
      existingValues[array[i]] = true
    } else {
      return false
    }
  }
  return false
}
```

Now, which of these two algorithms is more efficient? Well, it all matters wheter you consider time or space. As far as time is concerned, Version #2 is much more efficient. as it's only O(N), compared with Version #1's O(N^2)

However, when it comes to space, Version #1 is actually more efficient that Version#2. _Version#2 consumes up to O(N) space_, as it created a hash table that may end up cotaining all N values from the array passed to the function. Version#1, however, does not consume any additional memory beyond the original array, and therefore has a _space complexity of O(1)_

| Version    | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| Version #1 | O(N^2)          | O(1)             |
| Version #2 | O(N)            | O(N)             |

let's look at the third version of the same functions, and see where it falls compared to the first two versions:

- Version #3

```javascript
fucntion hasDuplicateValue(array) {
  array.sort((a, b) => (a < b) ? -1 : 1)

  for(let i = 0; i < array.length - 1; i++) {
    if (array[i] === array[i + 1]) {
      return true
    }
  }
  return false
}
```

In terms of time complexity, this algorithm is O(N log N). We can asuume that JavaScript's sorting algorithm is one that takes O(N log N), as the gastest known sorting alforithms are known to do. The additional N steps of iterating over the array are trivial beside the sorting steps, so O(N log N) is the gran total when it comes to speed.

So, let's see whwere Version #3 lands in comparision with the previous two versions:

| Version    | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| Version #1 | O(N^2)          | O(1)             |
| Version #2 | O(N)            | O(N)             |
| Version #3 | O(N log N)      | O(log N)         |

It turns out Version #3 strikes an interesting balance between time and space. In therms of time, Version #3 is faster than Version #1, but slower thatn Version #2. When it comes to space, it's more efficient than Version #2, but less efficient than Version #1.

## The hidden Cost of Recursion

We've deal quite a bit with recursive algorithms in this book. Let's look at a simple recursive function:

```javascript
function recurse(n) {
  if (n < 0) {
    return;
  }
  console.log(n);
  recurse(n - 1);
}
```

This function accepts a number n and counts down to 0, printing each decrementing number along the way.

It's a pretty straighforward but of recursion and seems pretty harmeless. Its speed is O(N), as the function will run as many times as the argument n. And it doesn't create an new data structures, so it doesn't seem to take up any additional space.

**Or does it?**

Each time a function recursively calls irself, an item is added to the call stack so that the computer can come back to the ourter function once the inner function is complete.

If we pass the number 100 into our recursive function, it would add recurse(100) before proceeding to execute recurse(99). And it ouwld then add recurse(99) to the call stack before executing recurse(98).

It emerges, then, that our recursive function _takes up O(N) space_. In this case, N is the number passed into the function if we pass in the number 100, we need to temporarily store 100 function calls in the call stack.

At first, this may seem a bit trivial. After all, our modern computers can handle a few items on the call stack, rigth? Well, let's see.

When I pass in the number 20,000 into the _recurse_ function on mu sleek, up-to-date laptop, _the computer cannot process it_. Now, 20,000 doesn't seem like a very large numebr. But this is what happens when I run recurse(20000)

The computer prints the number 20000 until 5387 and then terminates with the message:

> RangeError: Maximum call stack size exceeded

This is a _huge limitation_ on recursion, as I can't use the beautiful recurse function on a number much greater than 15,000.

Let's contrast this to a simple loop approach:

```javascript
function loop(n) {
  while (n >= 0) {
    console.log(n);
    n--;
  }
}
```

Because this function does not use recursion, and does not take up any additional memory, it can run with huge number without ever causing _the computer to run out of space_.

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
