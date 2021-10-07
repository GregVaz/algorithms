Recursive patterns and techniques to "write in recursive"

# Recursive Category

## Repeatedly Execute

The category that we can say is the easiest was one in which the goal of the algorithm
was to repeatedly execute a task

A countdown algorithm is a great example; The code prints a number such as 10, and then 9, all the way down to 0
the code's essence to the fact that it is repeatedly executing a task-namely, the printing of a number

Javascript implementation:

```javascript
function countdown(number) {
  console.log(number);

  if (number === 0) {
    return;
  } else {
    countdown(number - 1);
  }
}
```

The problems for this category, the last line of code in the function was a simple, single call to the function again.
And we found the same behaviour in the find directories algorithm of the chapter 10

### Recursive trick: Passing Extra parameters

For the following function to double an array of numbers

```python
def double_array(array):
  index = 0

  while (index < len(array)):
    array[index] *= 2
    index += 1
```

In a recursive version, though, the only argument to our
function is the array. We need some way to keep track of and increment and index. How do we pull this off?
Let's pass in extra parameters!

```python
def double_array(array):
  # Base case
  if index >= len(array):
    return

  array[index] *= 2
  double_array(array, index + 1)
```

## Recursive category: Calculations

performing a calculation based on a subproblem

- One area in which recursion shines is where we need to act on a problem that has an arbitraty number of levels of depth.
- Also it is able to make calculation based on a subproblem of the problem at hand

A subproblem is a version of tge very same problem applied to a smaller input.

Ex.

```ruby
def factorial(n)
  product = 1
  (1..n).each do |num|
    product \*= num
  end

  return product
end
```

If you think about it, factorial(6) will be 6 multiplied by whatever the result of factorial(5) is.
Since factorial(6) is:
6 \* 5 \* 4 \* 3 \* 2 \* 1
and factorial(5) is:
5 \* 4 \* 3 \* 2 \* 1
we can conclude that factorial(6) is equivalent to:
6 \* factorial(5)

That is, since factorial(5) is the smaller problem that can be used to compute the result for the bigger
problem, we call factorial(5) a subproblem of factorial(6)

So the las implementation will be:

```ruby
def factorial(number)
  if number == 1
    return 1
  else
    return number * factorial(number - 1)
  end
end
```

## Two approaches to calculations

Writing a function that makes a calculation, there are two potential approaches: 1. We can try to build the solution from the "bottom up" 2. Or we can attack the problem going "top down" by making the calculation based on the problem's subproblem

- bottom-up strategy

```ruby
def factorial(n, i=1, product=1)
  return product if i > n
  return factorial(n, i + 1, product * i)
end
```

Not a particulary elegant and does not add much value over using a classic loop

- top-down strategy
  But to go top-down, we need recursion. And because recursion is the only way to achievea top-down strategy,
  it's one of the key factors that makes recursion a powerful tool

Going top down _offers a new mental strategy for tackling a problem_

let's take another look at the key line from our top-down factorial implementation

- return number \* factorial(number - 1)

This line of code makes its calculation based on factorial(number - 1). When we write this line of code
_Do we have to understand how the factorial functions it's calling works?_ Technically, we don't

---

When we write "in recursive" to implementa top-down strategy, we get to relax our brains a little bit.
We can even choose to ignore the details of how the calculations actually works. We get to say,
"let's just rely on the subproblem to deal with the details."

> Excerpt From: Jay Wengrow. “A Common-Sense Guide to Data Structures and Algorithms, Second Edition, 2nd Edition. Chapter-11”

---

### The Top-Down thought process

1. Imagine that the function you're writing has already been implemented by someone else
2. Identify the subproblem of the problem
3. See what happens when you call the function on the subproblem and go from there
