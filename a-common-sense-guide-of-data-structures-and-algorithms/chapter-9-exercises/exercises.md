1. If you were writing software for a call center that places callers on hold and then assigns them to "the next availale representative", would you use a stack or a queue?

2. If you pushed numbers onto a stack in the following order, 1,2,3,4,5,6, and then dequeued two items, which number would you be able to read from the queue?

3. If you inserted numbers into a queue in the following order, 1,2,3,4,5,6, and then dequeue two items, which number would you be able to read fri the queue?

4. Write a function that uses a stack to reverse a string. (For a example, "abcde" would become "edcba").

> 1.r = Queue

> 2.r = 6 and 5

> 3.r = 1 and 2

> 4.r =

```
def reverseString(string)
  stack = Stack.new

  string.each_char do |char|
    stack.push(char)
  end

  reversed_string = ''
  while stack.read do
    reversed_string += stack.pop
  end

  reversed_string
end
```
