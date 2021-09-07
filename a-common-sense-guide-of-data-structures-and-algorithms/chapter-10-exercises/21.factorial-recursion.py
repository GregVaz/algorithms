def factorial(number):
  if number == 1: # base case
    return 1
  else:
    return number * factorial(number - 1)

print(factorial(3))

# Process for identify recursion
# 1. Identify the base case
# 2. Walk through the function for the base case
# 3. Identify the "next-to-last" case. This is the case ust before the base case, as I'll demonstrate momentarily
# 4. Walk through the funciton for the "next-to-last" case
# 5. Repeat this process by identify the case before the one you just analyze, and walking though the function for that case

# Factorial recursive process
# 1. factorial(3) is called first. Before it's done
# 2. factorial(2) is called second. Before it's done
# 3. factorial(1) is called third. 
# 4. factorial(1) is completed fist. 
# 5. factorial(2) is completed based on the result of factorial(1)
# Finally, factorial(3) is complete based ond the result of factorial(2) 