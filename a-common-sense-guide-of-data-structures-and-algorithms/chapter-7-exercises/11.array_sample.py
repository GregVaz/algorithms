def sample(array):
  first = array[0]                    # N step
  middle = array[int(len(array) / 2)] # + N step
  last = array[-1]                    # + N step

  return [first, middle, last]

# Since the number of steps is constant - that is, it remains the same no matter what N is - this algorithm is considered O(1)