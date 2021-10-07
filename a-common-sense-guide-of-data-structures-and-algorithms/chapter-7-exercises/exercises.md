1. Use Big O Notation to describe the time complexity of the following function. The function returns true if the array is a "100 sum array" and flase if it is not

```python
def one_hundred_sum?(array)
  left_index = 0
  right_index = array.length - 1

  while left_index < array.length / 2
    if array[left_index] + array[right_index] != 100
      return false
    end

    left_index += 1
    right_index -= 1
  end

  return true
end
```

2. “Use Big O Notation to describe the time complexity of the following function. It merges two sorted arrays together to create a new sorted array containing all the values from both arrays:

```python
def​ ​merge​(array_1, array_2)
​ 	  new_array = []
​ 	  array_1_pointer = 0
​ 	  array_2_pointer = 0
​ 
​ 	  ​while​ array_1_pointer < array_1.​length​ ||
​ 	      array_2_pointer < array_2.​length​
​ 
​ 	    ​if​ !array_1[array_1_pointer]
​ 	      new_array << array_2[array_2_pointer]
​ 	      array_2_pointer += 1
​ 	    ​elsif​ !array_2[array_2_pointer]
​ 	      new_array << array_1[array_1_pointer]
​ 	      array_1_pointer += 1
​ 	    ​elsif​ array_1[array_1_pointer] < array_2[array_2_pointer]
​ 	      new_array << array_1[array_1_pointer]
​ 	      array_1_pointer += 1
​ 	    ​else​
​ 	      new_array << array_2[array_2_pointer]
​ 	      array_2_pointer += 1
​ 	    ​end​
​ 	  ​end​
​ 
​ 	  ​return​ new_array
​ 	​end​
```

3. “Use Big O Notation to describe the time complexity of the following function. This function solves a famous problem known as “finding a needle in the haystack.”
   Both the needle and haystack are strings. For example, if the needle is "def" and the haystack is "abcdefghi", the needle is contained somewhere in the haystack, as "def" is a substring of "abcdefghi". However, if the needle is "dd", it cannot be found in the haystack of "abcdefghi".
   This function returns true or false, depending on whether the needle can be found in the haystack:

```python
​ 	​def​ ​find_needle​(needle, haystack)
​ 	  needle_index = 0
​ 	  haystack_index = 0
​ 
​ 	  ​while​ haystack_index < haystack.​length​
​ 	    ​if​ needle[needle_index] == haystack[haystack_index]
​ 	      found_needle = ​true

​ 	      while​ needle_index < needle.​length​
​ 	        ​if​ needle[needle_index] != haystack[haystack_index + needle_index]
​ 	          found_needle = ​false​
​ 	          ​break​
​ 	        ​end​
​ 	        needle_index += 1
​ 	      ​end​
​ 
​ 	      ​return​ ​true​ ​if​ found_needle
​ 	      needle_index = 0
​ 	    ​end​
​ 
​ 	    haystack_index += 1
​ 	  ​end​
​ 
​ 	  ​return​ ​false​
​ 	​end​
```

4. “Use Big O Notation to describe the time complexity of the following function. This function finds the greatest product of three numbers from a given array:

```python
​ 	​def​ ​largest_product​(array)
​ 	  largest_product_so_far = array[0] * array[1] * array[2]
​ 	  i = 0
​ 
​ 	  ​while​ i < array.​length​
​ 	    j = i + 1
​ 	    ​while​ j < array.​length​
​ 	      k = j + 1
​ 	      ​while​ k < array.​length​
​ 	        ​if​ array[i] * array[j] * array[k] > largest_product_so_far
​ 	          largest_product_so_far = array[i] * array[j] * array[k]
​ 	        ​end​
​ 	        k += 1
​ 	      ​end​
​ 	      j += 1
​ 	    ​end​
​ 	    i += 1
​ 	  ​end​
​ 
​ 	  ​return​ largest_product_so_far
​ 
​ 	​end”

```

5. “I once saw a joke aimed at HR people: “Want to immediately eliminate the unluckiest people from your hiring process? Just take half of the resumes on your desk and throw them in the trash.”

If we were to write software that kept reducing a pile of resumes until we had one left, it might take the approach of alternating between throwing out the top half and the bottom half. That is, it will first eliminate the top half of the pile, and then proceed to eliminate the bottom half of what remains. It keeps alternating between eliminating the top and bottom until one lucky resume remains, and that’s who we’ll hire!

Describe the efficiency of this function in terms of Big O:

```python
​ 	​def​ ​pick_resume​(resumes)
​ 	  eliminate = ​"top"​
​ 
​ 	  ​while​ resumes.​length​ > 1
​ 	    ​if​ eliminate == ​"top"​
​ 	      resumes = resumes[resumes.​length​ / 2, resumes.​length​ - 1]
​ 	      eliminate = ​"bottom"​
​ 	    ​elsif​ eliminate == ​"bottom"​
​ 	      resumes = resumes[0, resumes.​length​ / 2]
​ 	      eliminate = ​"top"​
​ 	    ​end​
​ 	  ​end​
​ 
​ 	  ​return​ resumes[0]
​ 	​end​”
```

> 1.r = O(N / 2) ~ O(N)

> 2.r = O(N \* M)

> 3.r = O(N \* M)

> 4.r = O(N^3)

> 5.r = O(log N)
