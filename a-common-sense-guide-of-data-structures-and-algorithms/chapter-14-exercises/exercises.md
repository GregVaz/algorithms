1. Add a method to the classic LinkedList class that prints all the elements of the list.

2. Add a method to the DoublyLinkedList class that prints all the elements of the list in reverse order.

3. Add a method to the classic LinkedList class that returns the last element from the list. Assume you don’t know how many elements are in the list.

4. Here’s a tricky one. Add a method to the classic LinkedList class that reverses the list. That is, if the original list is A -> B -> C, all of the list’s links should change so that C -> B -> A.

5. Here’s a brilliant little linked list puzzle for you. Let’s say you have access to a node from somewhere in the middle of a classic linked list, but not the linked list itself. That is, you have a variable that points to an instance of Node, but you don’t have access to the LinkedList instance. In this situation, if you follow this node’s link, you can find all the items from this middle node until the end, but you have no way to find the nodes that precede this node in the list. “Write code that will effectively delete this node from the list. The entire remaining list should remain complete, with only this node removed.”

> 1.r =

```ruby
def print
  current_node = first_node
  begin
    puts current_node.data
    current_node = current_node.next_node
  end while curren_node
end
```

> 2.r =

```ruby
def print_reverse
  current_node = last_node
  begin
    puts current_node.data
    current_node = current_node.previous_node
  end while current_node
end
```

> 3.r =

```ruby
def last_item
  last_node = first_node
  begin
    last_node = last_node.next_node
  end while last_node.next_node
  return last_node.data
end
```

> 4.r =

```ruby
def reverse_list_array
  array = []
  current_node = first_node
  while current_node do
    array.push(current_node)
    current_node = current_node.next_node
  end

  self.first_node = array.pop
  current_node = first_node
  while unless array.empty?
    current_node.next_node = array.pop
    current_node = current_node.next_node
  end
end

def reverse_list_index
  # We suppose we have a property to tell us the size of the linked list
  repeat = size - 1
  current_node = first_node
  while repeat > 0 do
    temporal_node = current_node.next_node
    current_node.next_node = current_node.next_node.next_node
    temporal_node.next_node = current_node
    self.first_node = temporal_node
    (repeat - 1).times do |index|
      temporal_node = current_node.next_node
      current_node.next_node = current_node.next_node.next_node
      temporal_node.next_node = current_node
    end
    repeat -= 1
    current_node = fist_node
  end
end

# reverse_book_implementation Awesome!!!!
# All you have to think it is in the properties and advantages of the Nodes.
def reverse!
  previous_node = nil
  current_node = first_node

  while current_node
    next_node = current_node.next_node

    current_node.next_node = previous_node

    previous_node = current_node
    current_node = next_node
  end
end
```

> 5.r =

```ruby
current_node = node_instance
while current_node do
  current_node.data = current_node.next_node.data
  if current_node.next_node.next_node == nil
    current_node.next_node = nil
    break
  end
end

# Book solution
def delete_middle_node(node)
  node.data = node.next_node.data
  node.next_node = node.next_node.next_node
end
```
