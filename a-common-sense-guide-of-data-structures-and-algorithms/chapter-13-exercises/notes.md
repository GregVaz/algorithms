# Recursive Algorithms for Speed

Quicksort is an extremely fast sorting algorithm that is particularly efficient for average scenarios.
While in worst-case scenarios it performs similarly to InsertionSort or SelectionSort

Quicksort relies on a concept called partitioning.

## Partitioning

Partitioning an array is to take a random value from the array (called the pivot) and
make sure that every number that is less that the pivot ends up t the left of the pivot
and that every number greater that the pivot ends up to the right of the pivot.

1. The left pointer continuously moves one cell to the right until it reaches a value that is greater than or equal to the pivot, and the stops

2. Then, the right pointer continuously moves one cell to the left until it reaches a value that is less than or equal to the pivot,
   and then stops. The right pointer will also stop oif it reaches the beginning of the array.

3. Once the right pointer has stopped, we reach a crossroads. If the left pointer has reached (or gone beyond) the right pointer, we move on the Step 4.
   Otherwise, we swap the values that the left and right pointers are pointing to, and then go back to repeat Steps 1, 2, and 3 again.

4. Finally, we swap the pivot with the value that the left pointer is currently pointing to.

\*\*\* To see the implementation for Partitioning check the 30.Partition.rb code

# Quicksort

The quicksort algorithm is a combination of partitions and recursion.
It works as follows:

1. Partition the array. The pivot is now in its proper place
2. Treat the subarrays to the left and right of the pivot as their own arraysm and recursively repeat Steps 1 and 2.
   That means we'll partition each subarray and end up with even smaller sub-subarrays to the left and right of each subarray's pivot.
   We then partition those sub-subarrays, and so on and so forth.
3. When we have subarray that has zero or one elements, that is our base case and we do nothing.

## The Big O of QuickSort

If we look at the pattern shown earlier, we'll note that the number of Quicksort steps for N elements, in the array is about N multiplied by log N
N | log N | N log N | Quicksort Steps (approx)
--- | ----- | --------- | -----------------------
4 | 2 | 8 | 8
8 | 3 | 24 | 24
16 | 4 | 64 | 64
32 | 5 | 160 | 160

QuickSort is an algorithmof O(N log N)

\*\*\* To see the implementation for Quicksort check the 31.Quicksort.rb code

# Quickselect

Let say you have an array in random order, and you want to know the tenth-lower value in the array, or if we had a lot of test frades and want to know what the 25th percentile was, on if we want to find the median grade.

Quicselect relies on partitioning and can be thought of as a hybrid of Quicksort and Binary search

\*\*\* To see the implementation for Quickselect check the 32.Quickselect.rb code

# Conclusion

Plenty of algorithms employ sorting as part of a larger process. We now know that any time we do so, we have an algorithm that is at least O( N log N).
Of course, the algorithm may be slower that this if it has other things going on, but we know that O(N log N) will always be the _base line_

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
