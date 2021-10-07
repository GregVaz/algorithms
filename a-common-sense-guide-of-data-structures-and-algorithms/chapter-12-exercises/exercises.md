1. The following function accepts an array of numbers and returns the sum, as long as a particular number doesn’t bring the sum above 100. If adding a particular number will make the sum higher than 100, that number is ignored. However, this function makes unnecessary recursive calls. Fix the code to eliminate the unnecessary recursion:

```ruby
​def​ ​add_until_100​(array)
​ 	  ​return​ 0 ​if​ array.​length​ == 0
​ 	  ​if​ array[0] + add_until_100(array[1, array.​length​ - 1]) > 100
​ 	    ​return​ add_until_100(array[1, array.​length​ - 1])
​ 	  ​else​
​ 	    ​return​ array[0] + add_until_100(array[1, array.​length​ - 1])
​ 	  ​end​
​ 	​end​
```

2. The following function uses recursion to calculate the Nth number from a mathematical sequence known as the “Golomb sequence.” It’s terribly inefficient, though! Use memoization to optimize it. (You don’t have to actually understand how the Golomb sequence works to do this exercise.)”

```ruby
def golomb(n)
return​ 1 ​if​ n == 1
​ return​ 1 + golomb(n - golomb(golomb(n - 1)));
​end​
```

3.  Here is a solution to the “Unique Paths” problem from an exercise in the previous chapter. Use memoization to improve its efficiency:

```ruby
def unique_paths(rows, columns)
  return 1 if rows == 1 || columns == 1
  return unique_paths(rows - 1, columns) + unique_paths(rows, columns - 1)
end
```
