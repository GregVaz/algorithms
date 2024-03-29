# In-Place modifications

Let’s take a look at the concept of in-place modifications, just in case it’s not clear.

Generally speaking, there are two basic approaches to manipulating data.
Let’s take the example of doubling the values in an array. If I had the array, [1, 2, 3, 4, 5],
and wanted to “double” it to produce the array, [2, 4, 6, 8, 10], I could do one of two things.

The first option is to create a new array that contains the “doubled” data, but leave the original array alone. Take the following code:

​  a = [1, 2, 3, 4, 5]

​  b = double_array(a)

Since the double_array function is creating and returning a brand-new array, if we were to check the values of a and b, we’d get:

​  a ​# [1, 2, 3, 4, 5]​

​  b ​# [2, 4, 6, 8, 10]​

The original array a was unmodified, and b holds a brand-new array.

The second option is called in-place modification, meaning the function actually changes the original array passed into function.
With in-place modification, if we now check a and b, we’d find:

​  a ​# [2, 4, 6, 8, 10]​

​  b ​# [2, 4, 6, 8, 10]​

The in-place function actually modifies a, and b is actually just pointing to the very same array that a is.

> Excerpt From: Jay Wengrow. “A Common-Sense Guide to Data Structures and Algorithms, Second Edition, 2nd Edition.”
