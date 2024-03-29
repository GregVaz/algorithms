1. Replace the question marks in the fllowing table to describe how many steps occur for a given number of data elements across various types of Big O

| N. Elements | O(N) | O(log N) | O(N^2) |
| ----------- | ---- | -------- | ------ |
| 100         |      |          |
| 2000        |      |          |

2. If we have an O(N^2) algorithm that processes an array and find that it takes 256 steps, what is the size of the array?

3. Use Big O Notation to describe the time complexity of the following function.

It finds the greates product of any pair of two numbers within a given array:

```python
def greatesProduct(array):
  greatesProductSoFar = array[0] * array[1]

  for i, iVal in enumerate(array):
    for j, jVal in enumerate(array):
      if i != j and iVal * jVal > greatesProductSoFar:
        greatesProductSoFar = iVal * jVal

  return greatesProductSoFar
```

4. The following function finds the greatest single number within an array, but has an efficiency of O(N^2), Rewrite the function so it becomes a speedi O(N)

```python
def greatestNumber(array):
  for i in array:
    isIValTheGreatest = True

    for j in array:
      if j > i:
        isIValTheGreatest = False

    if isIValTheGreatest:
      return i
```

> 1.r =

| N. Elements | O(N) | O(log N) | O(N^2)    |
| ----------- | ---- | -------- | --------- |
| 100         | 100  | 8        | 10,000    |
| 2000        | 2000 | 12       | 4,000,000 |

> 2.r = 16

> 3.r = O(N^2)

> 4.r =

```python
def greatestNumber(array):
    greatest = array[0]
    for i in range(1, len(array)):
        if array[i] > greatest:
            greatest = array[i]
    return greatest
```
