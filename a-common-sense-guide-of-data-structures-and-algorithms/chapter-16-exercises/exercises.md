1. Draw what the following heap would look like after we insert the value 11 into it:

```
              10
            /    \
          /        \
        9           8
      /   \        /  \
    6      5     7    4
  /   \   /
 2     1  3
```

2. Draw what the previous heap would like after we delete the root node

3. Imagine you've build a brand-new heap by inserting the following numbers into the heap in this particular order: 55, 22, 34, 10, 2, 99, 68. If you then pop them from the heap one at a time and insert them numbers into a new array, in what order would the numbers now appear?

> 1.r=

```
              11
            /     \
          10        8
         /   \    /   \
        6     9  7    4
      /  \   /  \
     2    1 3    5
```

> 2.r =

1st state

```
              11
            /     \
          10        8
         /   \    /   \
        6     9  7    4
      /  \   /  \
     2    1 3    5
```

2nd state

```
              5
            /     \
          10        8
         /   \    /   \
        6     9  7    4
      /  \   /
     2    1 3
```

3rd state

```
              10
            /     \
          5        8
         /   \    /   \
        6     9  7    4
      /  \   /
     2    1 3
```

4th state

```
              10
            /     \
           9        8
         /   \    /   \
        6     5  7    4
      /  \   /
     2    1 3
```

> 3.r =

```
        99
      /     \
    22      68
  /   \    /   \
10     2  34    55
```

> arr = []

```
        68
      /     \
    22      55
  /   \    /
10     2  34
```

> arr = [99]

```
        55
      /     \
    22      34
  /   \
10     2
```

> arr = [99, 68]

```
        34
      /   \
    22     2
  /
10
```

> arr = [99, 68, 55]

```
        22
      /   \
    10     2
```

> arr = [99, 68, 55, 34]

```
        10
      /
    2
```

> arr = [99, 68, 55, 34, 22]

```
        2
```

> arr = [99, 68, 55, 34, 22, 10]

```
        °
```

> arr = [99, 68, 55, 34, 22, 10, 2]
