# Unnecesary Recursive Calls

```ruby
def max(array)
  return array[0] if array.length == 1
  if array[0] > max(array[1, array.length - 1])
    return array[0]
  else
    return max(array[1, array.length - 1])
  end
end
```

What is wrong with this recursive function?
The problem with this is that each time we mention max(array[1, array.length - 1]),
we trigger an entire avalanche of recusive Calls

```
For an example array of [1,2,3,4]
  max([1,2,3,4])
    max([2,3,4])
      max([3,4])
        max([4])
        max([4])
      max([3,4])
        max([4])
        max([4])
    max([2,3,4])
      max([3,4])
        max([4])
        max([4])
      max([3,4])
        max([4])
        max([4])
```

If we print the string "Recursion" at the beginning of the max function,
we will see the word, "Recursion" printed to our terminal 15 times

So in order to resolve all these extra recursive calls. We will call max only once within our code, and save the result to a variable

```ruby
def max(array)
  return array[0] if array.length == 1

  max_of_remainder = max(array[1, array.length - 1])

  if array[0] > max_of_remainder
    return array[0]
  else
    return max_of_remainder
  end
end
```

With this change now the recursive function only calls 4 times itself

Now if we analyze the behaviour of our previous implementation with the question
if there are N data elements, how many steps will ghe alforhtm take?

## Big O

| N elements | Numbers of calls |
| ---------- | ---------------- |
| 1          | 1                |
| 2          | 3                |
| 3          | 7                |
| 4          | 15               |
| 5          | 31               |

When we increase the data by one, we roughly double the number of steps the algorithm takes.
This is a pattern of O(2^N). Which is an extremely slow algorithm

The improved version of the max function, however, only cals max for as many elements as there are inside the array.
This means that the second max function has an efficiency of O(N)

## Overlapping Subproblems

The fibonacci sequence is a mathematical sequence of numbers that goes like this until infinity
0,1,1,2,3,5,8,13,21,34,55

The following function returns the Nth number in the Fibonacci sequence

```
def fib(n)
  if n == 0 or n == 1:
    return n

  return fib(n - 2) + fib(n - 1)
```

The key line is return fib(n - 2) + fib(n - 1). It's a beautiful recursive function

However, alarm bells should be going off in your head because our function calls irselft twice

```
fib(6)
  fib(4)
    fib(2)
      fib(0)
      fib(1)
    fib(3)
      fib(1)
      fib(2)
        fib(0)
        fib(1)
  fib(5)
    fib(3)
      fib(1)
      fib(2)
        fib(0)
        fib(1)
    fib(4)
      fib(2)
        fib(0)
        fib(1)
      fib(3)
        fib(1)
        fib(2)
          fib(0)
          fib(1)
```

O(2^N) looks pretty scary

Optimizing our Fibonacci function is not as simple as save the result in a variable.
When a problem is solved by solving smaller versions of the same problem, the smaller problems is called a subproblem.
This concept is not new, we compute each number by first computing the smaller numbers in the sequence.

What makes these subproblems overlapping, though, is the fact that fib(n - 2) and fib(n - 1) end up calling many of the same functions as each other.
That is, fib(n - 1) needs up making some of the very same calculations previously made by fib(n - 2).

Luckily, we have options, and that is through something called dynamic programming.

# Dynamic programming

Dynamic programming is the process of optimizing recursive problems that have overlapping subproblems.
Optimizing an algorithm with dynamic programming is typically accomplished with one of two techniques.

The first technique is called memoization.
The second technique is called Going Bottom-up

## Memoization

Memoization reduces recursive calls by remembering previously computed functions.

### Fibonacci memoization implementation

```python
def fib(n, memo):
  if n == 0 or n == 1:
    return n

  # Only if the calculation for n has not yet been made do we proceed with the calculations:
  if not memo.get(n):
    memo[n] = fib(n - 2, memo) + fib(n - 1, memo)

  return memo[n]
```

```
Development of the memoization function
fib(6)
  fib(4)
    fib(2)
      fib(0)
      fib(1)
    fib(3)
      fib(1)
      memo(fib(2))
  fib(5)
    memo(fib(3))
    memo(fib(4))
```

## Big O

| N elements | Numbers of calls |
| ---------- | ---------------- |
| 1          | 1                |
| 2          | 3                |
| 3          | 5                |
| 4          | 7                |
| 5          | 9                |
| 6          | 11               |

The memoization function, only calls fib for (2N) - 1.
This means that the memoization fib function has an efficiency of O(N)

## Bottom-up Fibonacci

```
def fib(n):
  if n == 0:
    return 0

  a = 0
  b = 1

  for i in range(1, n):
    temp = a
    a = b
    b = temp + a

  return b
```

Because our code is a simple loop from 1 to N, our code takes N steps. Like the memoization approach, it is O(N)

# Conclusions

If recursions presents an elegant and intuitive solution to a given problem, you may want to stick with it and use memoization to deal with any overlapping subproblems.
However, if the iterative approach is equally intuitive, you may want to go with that.

It is important to point out that even with memoization, recursion does carry some extra overjead versus iteration.
Specifically, with any recursion, the computer need to keep track of all the calls in a call stack, which consumes memory.
the memoization itself also requires the use of a hash table, which will take up additional space on your computer as well.

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
