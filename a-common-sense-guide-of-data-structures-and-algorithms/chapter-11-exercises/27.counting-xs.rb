# Write a function called count_x that returns the numbers of "x's" ina given string.

# Identify the subproblem
#   We'll say the subproblem is the original string minus its first character. So, for "axbxcxd", the subproblem is "xbxcxd"

# Now let's imagine that count_x has already been implemented. if we call count_x on out subproblem, by calling count_x("xbxcxd"), we get 3
#   So we just need to add 1 if our first character is also a "x"
#     If the first character is not a "x" we do not need to add anything to the result of our subproblem

# So, we can write
def count_x_v1(string)
  if string[0] == "x"
    return 1 + count_x(string[1, string.length - 1])
  else
    return count_x(string[1, string.length - 1])
  end
end

# Finally all we need to do is deal with the base case

# We can say that the base case here is when a string has only one character, but it is also have two base cases, 
# as the single character may be an "x" or maybe not

def count_x(string)
  # Base case
  if string.length == 1
    if string[0] == "x"
      return 1
    else
      return 0
    end
  end

  if string[0] == "x"
    return 1 + count_x(string[1, string.length - 1])
  else
    return count_x(string[1, string.length - 1])
  end
end

# We can simply this

def count_x_simple(string)
  return 0 if string.length == 0

  if string[0] == "x"
    return 1 count_x_simple(string[1, string.length - 1])
  else
    return count_x_simple(string[1, string.length - 1])
  end
end