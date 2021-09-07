def reverse(string)
  # Base case: string with just one character
  return string[0] if string.length == 1

  return reverse(string[1, string.length - 1]) + string[0]
end

# let's imagine that someone did us the great favor to implementing the reverse function for us

# now, if the reverse function is available for our use and our subproblem is "bcde", that means
# we can already call reverse("bcde"), which would return "edcb"

# Once we can do that, dealing with the "a" is a piece of cake. *We just need to throw it onto the end of the string*.
# So we can write:
def reverse(string)
  return reverse(string[1, string.length - 1]) + string[0]
end

# Finally our base case occur s when the string has one character