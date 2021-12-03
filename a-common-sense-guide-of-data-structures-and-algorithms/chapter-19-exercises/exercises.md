1. “Following is the “Word Builder” algorithm we encountered in ​Word Builder​. Describe its space complexity in terms of Big O:

```javascript
​ 	​function​ wordBuilder(array) {
​ 	  ​let​ collection = [];
​ 
​ 	  ​for​(​let​ i = 0; i < array.length; i++) {
​ 	    ​for​(​let​ j = 0; j < array.length; j++) {
​ 	      ​if​ (i !== j) {
​ 	        collection.push(array[i] + array[j]);
​ 	      }
​ 	    }
​ 	  }
​ 
​ 	  ​return​ collection;
​ 	}
```

2. “Following is a function that reverses an array. Describe its space complexity in terms of Big O:

```javascript
​ 	​function​ reverse(array) {
​ 	  ​let​ newArray = [];
​ 
​ 	  ​for​ (​let​ i = array.length - 1; i >= 0; i--) {
​ 	    newArray.push(array[i]);
​ 	  }
​ 
​ 	  ​return​ newArray;
​ 	}
```

3. “Create a new function to reverse an array that takes up just O(1) extra space.”

4. “Following are three different implementations of a function that accepts an array of numbers and returns an array containing those numbers multiplied by 2. For example, if the input is [5, 4, 3, 2, 1], the output will be [10, 8, 6, 4, 2].

```javascript
​ 	​function​ doubleArray1(array) {
​ 	  ​let​ newArray = [];
​ 
​ 	  ​for​(​let​ i = 0; i < array.length; i++) {
​ 	    newArray.push(array[i] * 2);
​ 	  }
​ 
​ 	  ​return​ newArray;
​ 	}
​ 
​ 	​function​ doubleArray2(array) {
​ 	  ​for​(​let​ i = 0; i < array.length; i++) {
​ 	    array[i] *= 2;
​ 	  }
​ 
​ 	  ​return​ array;
​ 	}
​ 
​ 	​function​ doubleArray3(array, index=0) {
​ 	  ​if​ (index >= array.length) { ​return​; }
​ 
​ 	  array[index] *= 2;
​ 	  doubleArray3(array, index + 1);
​ 
​ 	  ​return​ array;
​ 	}
```

Fill in the table that follows to describe the efficiency of these three versions in terms of both time and space:

| Version    | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| Version #1 | ?               | ?                |
| Version #2 | ?               | ?                |
| Version #3 | ?               | ?                |

> 1.r =

N \* N = O(N^2)

> 2.r =

O(N)

> 3.r =

```javascript
function reverse(array) {
  return a.reverse();
}
```

```javascript
function reverse(array) {
  tmp = [];
  for (let i = 0; i < array.length; i++) {
    lastIndex = array.length - 1 - i;
    last = array.get(lastIndex);
    tmp.push(last);
    array[i] = last;
    array[lastIndex] = tmp.pop();
  }
  return array;
}
```

> 4.r =

| Version    | Time Complexity | Space Complexity  |
| ---------- | --------------- | ----------------- |
| Version #1 | O(N)            | O(N)              |
| Version #2 | O(N)            | O(1)              |
| Version #3 | O(N)            | O(N) -> recursion |
