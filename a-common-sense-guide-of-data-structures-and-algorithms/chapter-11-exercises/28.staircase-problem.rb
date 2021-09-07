# "Why do we need this new mental strategy anyway? I've "
# Indeed, you may not need a new mental strategy for simpler computations
# But we are going to see when it comes to more complex functions, you may find that the
# recursive mindset makes the writing of code much easier.

# The Staircase Problem
=begin
  Let's say we have a staircase of N steps, and a person has the ability to climb one, two or three steps at the time.
  How many different possible "paths" can someone take to reach the top?
  Write a function that will calculate this for N steps

  Image to visualize the problem (https://media.geeksforgeeks.org/wp-content/uploads/nth-stair.png)
=end

# let's first explore this problem with a bottom-up approach. We'll work our way up from the simples cases to the more complex ones.

## Obviusly, if there's only one step, there's only one possible path.

## With two steps, there are two paths. The person can climb one step twice, or the person can 
## jump up two steps at once. 
# - 1, 1
# - 2

## With a staircase of three steps 
# 1, 1, 1
# 1, 2
# 2, 1
# 3

## Now try to draw up all the combinations for a five-steps staircase. Imagine how many combinations there are for 11 steps
## So, How would we write the code to count all the paths?

# with the top-down way of thinking, the problem can become surprisingly easy

## For an 11-step staircase, the first subproblem taht comes to mind is a 10-step staircase. Let's go with that for now
## If we knew how many possible paths there are to climb a 10-steps staircase, can we use that as a base for calculating the paths for an 11-steps staircase?

## We don't know that climbing a 11-steps staircase will take _at least_ as amny steps as climbing a 10-steps staircase.
## That is, we have all the paths to get to stair number 10, and from theer, one can climb one more step to fet to the top

## However, this can't be the complete solution, since we know that someone can also jump to the top from stair numbers 9 and 8 as well.

## If we think about it further, we'll realize that if you're taking any path tgat includes going from stair 10 to stair 11,
## you're not taking any og the paths that include jumping from stair 9 to stair 11. Conversily, if you jump from stair 9 to stair 11, 
## you're not taking any of the paths taht include stepping on stair 10.

## So, we know that the number of paths to the top will include at least the number of paths to stairs 10 plus the number of paths to stair 9.

## And since it's possible to also jump from stair 8 to stair 11, as one can jump three steps three steps at a time, 
## we need to include the coung of those paths as well.

## We've determined, then, that the number of steps to the top is at least the sum of all the paths to stairs 10, 9, 8

## However, in thinking abuot it event further, it's evident there are'nt any other possible paths to the top beyond these.
## After all, one cannot jump from stair 7 to stair 9. So we can conclude that for N steps, the number of paths is:

# - number_of_paths(n - 1) + number_of_paths(n - 2) + number_of_paths(n - 3)

def number_of_paths_v1(n)
  return number_of_paths(n - 1) + number_of_paths(n - 2) + number_of_paths(n - 3)
end

# Staircase problem base case
## Determing the base case for this problem is slightly tricky. That's because when this functoins gets to an n of 3, 2 or 1
## the function will call itself for a number_of_paths(1), number_of_paths(2), number_of_paths(-1).

# One way we can deal with this is by "hardcoding" all the bottom cases

def number_of_paths_v2(n)
  return 0 if n <= 0
  return 1 if n == 1
  return 2 if n == 2
  return 4 if n == 3
  return number_of_paths(n - 1) + number_of_paths(n - 2) + number_of_paths(n - 3)
end

## Now, we know that we want number_of_paths(2) to return(2), but we don't have to create that base case explicity. 
## Instead, we an take advantage of the fact that number_of_paths(2) will compute as number_of_paths(1) + number_of_paths(0) + number_of_paths(-1)
## Since number_of_paths(1) returns 1, if we made the number_of_paths(0) also return 1, and number_of_paths(-1) return 0,
## we'd end up with a sum of 2, which is what we want.

## So, we can add the following base cases:

# - return 0 if n < 0
# - return 1 if n == 1 || n == 0

# Let's move onto number_of_paths(3), which will return the sum of number_of_paths(2) + number_of_paths(1) + number_of_paths(0)
# We know that we want the result to be 4, so let's see if the math works out. We already rigged number_of_paths(2) to return 2
# number_of_paths(1) will return 1, and number_of_paths(0) will also return 1, so we end up getting the sum of 4.

def number_of_paths(n)
  return 0 if n < 0
  return 1 if n == 1 || n == 0
  return number_of_paths(n - 1) + number_of_paths(n - 2) + number_of_paths(n - 3)
end

print(number_of_paths(5))

# 4 steps are 7 options
=begin
  1, 1, 1, 1
  1, 1, 2
  1, 2, 1
  1, 3
  2, 1, 1
  2, 2
  3, 1
=end