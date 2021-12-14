# Techniques for Code Optimization

You will see the following mental strategies to make your code more efficient.

## Prerequisite: Determine Your Current Big O

The prerequisite to optimization is _determing the efficiency of your current code_. After all, it's impossible to make an algorithm faster if you don't know how fast it is now.

### Start here: Your Best-Imaginable Big O

The first technique applies to all algorithms, and should be the first step of your optimization process.

Once you've determined the efficiency of your current algorithm, come up with what you velieve to be what I call the **best-imaginable Big O.**
Esentially, the best-imaginable Big O is the absolute best Big O you could dream of for the problem at hand.

> For example, if we were to write a function that prints every item from an arraym we'd probably say that the bestpimaginable Big O for this task is O(N). Given that we have to print each of the N items in the array, we _have no choice_ but the process each of the N items.

Let's summarize these steps:

1. Detemrine the Big O category of your current algorithm
2. Determine the best-imaginable Big O you could dream of for the problem at hand
3. If the best-imaginable Big O is faster than your current Big O, you can now try to optimize your code, with the goal of bringind your algorithm as close to the best-imaginable Big O as possible.

> _It's important to stress that it's not always possible to achieve the best-imaginable BIg O. After all, just because you can dream of something doesn't mean it can become reality._

### Streaching the Imagination

Here's another mental trick that I used for stoking my imagination. I pick a really fast Big O for the problem at hand - Let's call it "_Amazing Big O_". I then ask myself. "If someone told me that they known how to pull off the Amazing Big O for this problem, would I believe them?" If I'd believe someone who said that they figured out how to solve this problem with the efficiency of Amazing Big O, I then make the Amazing Big O my _best-imaginable Big O_.

### Magical Lookups

One of my favorite go-to optimization techniques is to ask myself, _"If I could magically find a desired piece of information in O(1) time, can i make my algorithm faster?"_
If the answer to this is yes, I then use a data structure (often a hash table) to make that magic happen. I call this tech ique "magical lookups".

Let's say we're writing library software and we have data about books and thier authors contained in two separate arrays.

- Authors

```javascript
authors = {
  {author_id: 1, name: "Virginia Woolf"},
  {author_id: 2, name: "Leo Tolstoy"},
  {author_id: 3, name: "Dr. Seuss"},
  {author_id: 4, name: "J. K. Rowling"}
}
```

- Books

```javascript
books = {
  {author_id: 3, title: "Hop on Pop"},
  {author_id: 1, title: "Mrs. Dalloway"},
  {author_id: 1, title: "To the Lighthouse"},
  {author_id: 2, title: "Anna Karenina"},
  {author_id: 3, title: "The Cat in the Hat"},
}
```

Now if we want to write dode that convined this information together to create an array in the following format:

```javascript
books_with_authors = {
  {title: "", author: ""}
}
```

Algorithm

```ruby
def connect_books_with_authors(books, authors)
  books_with_authors = []

  books.each do |book|
    authors.each do |author|
      if book["author_id"] == author["author_id"]
        books_with_authors << {title: book["title"], author: author["name"]}
      end
    end
  end
end
```

But what if we had the magical ability to find an author _in just O(1) time?_
We didn't have to loop through all the authors each time we wanted to look one up, and we could instead find the author immediately?

#### Bringing in the Extra Data Structure

One of the easiest ways we can achieve this magical lookup ability is to birng an additional data structure into our code.
In many cases, the hash table is the perfect data structure for this, since it has O(1) lookups.

```ruby
def connect_books_with_authors(books, authors)
  books_with_authors = []
  author_hash_table = {}

  # convert author data into author hash table:
  authors.each do |author|
    authors_hash_table[author["author_id"]] = author["name"]
  end

  books.each do |book|
    books_with_authors << {title: book["title"], author: author_hash_table[book["author_id"]]}
  end
end
```

It's worth noting that by creating the extra hash table, we're using up an additional O(M) space, whereas our initial algorithm didn't take up any extra space at all. Howe er, this is great optimization if we're willing to sacrifice the memory for the sake of speed.

### The Two Sum Problem

The Two Sum problem is a well known coding excersice. The task is to write a function that accepts an array of numbers an returns tru or false depending on wheter there are any two numebrs in the array that add up to 10 (or another given number). For simplicity, let's assyme there will never be duplicate numbers in the array.

The first solution that comes to minds is to use nested loops to compare each number to every other number and see if they add up to 10.
Javascript implementation

```javascript
function twoSum(array) {
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length; j++) {
      if (i !== j && array[i] + array[j] === 10) {
        return true;
      }
    }
  }
  return false;
}
```

As is typical in a nested loop algorithm, this function has a runtime of O(N^2).

> In this case, it could seem that we absolutely have to visit each number in the array at least once. So, we couldn't beat O(N) And if someone told me that there's an O(N) solution to this problem. I supose I'd believe them. So, let's make O(N) our best-imaginable Big O.

> Thinking about it further, while looking at the 2. I'd want to know whether _there's a 8 somewhere_ in this array. If we could, magically, do an O(1) lookup and know that there's an 8 in the array. we could immediately return true. Let's call the 8 the 2's _counterpart_ since the two numbers add up to 10.

Since we want to be able to look up any number from the array in O(1) time, we'll store those numbers as keys ina hash table. Te ahsh table may look like this:

`{2: true, 0: true, 4: true, 1: true, 7: true, 9: true}`

```javascript
function twoSum(array) {
  let hashTable = {};

  for (let i = 0; i < array.length; i++) {
    if (hashTable[10 - array[i]]) {
      return true;
    }

    hashTable[array[i]] = true;
  }

  return false;
}
```

if we find any number's counterpart, we immediately return true, as that means we've found two numbers that add up to 10.

With this approach, we drastically increased the algorithm's speed to O(N). We pulled this off by sorting all of the data elements in a hash table for the express purpose of being able to perform O(1) lookups throughout the loop.

## Recognize Patterns

One of the most helpful strategies for both code optimizations and algorihtms development in general is to find patterns within the problem at hand. Often, the discovery of a patter can help you cut through all the complexity of a problem and develop an algorithm that is actually quite simple.
