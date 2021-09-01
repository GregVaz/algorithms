def mark_inventory(clothing_items):
  clothing_options = []

  for item in clothing_items:
    for size in range(1, 6):
      clothing_options.append(item + " Size: " + str(size))
    
  return clothing_options

# This code contains nested loops, so it's tempting to declares this algorithm to be O(N^2)
# however, while our outer loops runs N times, our inner loop runs a constant five times.
# so the inner loop will always run five times no matter what N is.
# That means our algorithm runs 5N, so it is O(N)