def sum(array)
  # Base case: only one element in the array
  return array[0] if array.length == 1

  return array[0] + sum(array[1, array.length - 1])
end

# The first thing we'll do is imagine that the sum function has already been implemented.

# Next, let's identify the subproblem
=begin
    we can say thta the subproblem is the array [2,3,4,5]-that is
    All the numbers from the array save the first one

    Now what happens when we apply the sum function to our subproblem!

    If the sum function "already works", and the subproblem is [2,3,4,5], what happens when we call
    sum([2,3,4,5])? Well, we get the sum of 2 + 3 + 4 + 5, which is 14

    To solve our problem of finding the sum of [1,2,3,4,5] then, we can just add 
    the first number, 1, to the result of sum([2,3,4,5])
    
    Something like this:
      - return array[0] + sum(array[1, array[1, array.length - 1]])
=end
