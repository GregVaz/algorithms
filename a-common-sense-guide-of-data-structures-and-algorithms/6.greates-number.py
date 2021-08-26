def greatestNumber(array):
    greatest = array[0]
    for i in range(1, len(array)):
        if array[i] > greatest:
            greatest = array[i]
    return greatest

print(greatestNumber([3,2,7,4,2,5,7,9]))