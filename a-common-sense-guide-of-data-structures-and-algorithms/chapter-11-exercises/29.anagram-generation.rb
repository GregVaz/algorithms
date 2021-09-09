# Anagrams of "abcd"
# If we had all six anagrams of "abc", we can come up with every permutation of "abcd", if we stick the "d"
# in every possible spot within each anagram of "abc"
def anagrams_of(string)
  # Base case: if the string is only one character
  # return an array containing just a single-character string
  return [string[0]] if string.length == 1

  collection = []
  # find all anagrams of the substring from the second character until the end
  substring_anagrams = anagrams_of(string[1, string.length - 1])

  # Iterate over each substring
  substring_anagrams.each do |substring_anagram|
    # Iterate over each index of ghe substring
    (0..substring_anagrams.length).each do |index|
      # Create a copy of the substring anagram
      copy = String.new(substring_anagram)
      # Insert the first character of our string into the substring anagram copy
      collection << copy.insert(index, string[0])
    end
  end

  return collection
end

puts anagrams_of("123")

=begin
Explanation of recursive algorithm for "123" in each step
c = []
sub = anagrams_of("23")
  c2 = []
  sub2 = anagrams_of("3")
    return ["3"]
  sub2 = ["3"]
  loop sub2
    loop 0,1
      loop 0
        copy = "3"
        c2.push("23")
      loop 1
        copy = "3"
        c2.push("32")
  c2 = ["23", "32"]
  return c2
sub = ["23", "32"]
loop sub
  ["23"]
    loop 0,1,2
      loop 0
        copy = "23"
        c.push("123")
      loop 1
        copy = "23"
        c.push("213")
      loop 2
        copy = "23"
        c.push("231")
  ["32"]
    loop 0,1,2
      loop 0
        copy = "32"
        c.push("132")
      loop 1
        copy = "32"
        c.push("312")
      loop 2
        copy = "32"
        c.push("321")
c = ["123", "213", "231", "132", "312", "321"]
return c
=end

# The efficiency of the algorithm 
=begin
For a string containing three characters, we create permutations that start with each of the three characters.
Each permutation then picks its middle character from one of the two remaining characters,
and its last character from the last character that's left. This is 3 * 2 * 1, which is six permutations.

Looking at thisfor other string lengths, we get:
4 characters: 4 * 3 * 2 * 1
5 characters: 5 * 4 * 3 * 2 * 1
6 characters: 6 * 5 * 4 * 3 * 2 * 1

We get a factorial patter => O(N!)

=end