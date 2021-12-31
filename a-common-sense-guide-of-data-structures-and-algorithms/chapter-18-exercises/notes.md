# Connecting everything with graphs

Lets say we are building a social network that allows people to be friends with one another.
These friends are mutual, so if Alice is friends with Bob, then Bob is also friends with Alice.

One basic approach might be to _use a two dimensional array_ that stores the list of friends

friendships = [
["Alice","Bob"]
["Bob","Cynthia"]
["Alice","Diana"]
.
.
.
]

Unfortunately, with this approach, there is no quick way to see who Alice's friends are. It woudl have comb through all the relationships in the list. This is O(N), which is very slow.

With a data structure **known as a graph, we can find Alice's friends in just O(1) time**.

## Graphs

A graph is a data structure that specializes in relationships, as it easily conveys how data is connected.

### Graphs vs Trees

Trees are types of graphs. Both data structures consist of nodes connected to each other.

While all trees are graphs, not all graps are trees.
For a graph to be considered a ttree, it cannot have cycles, and all nodes must be connected.

`A graph may have nodes that form what is known as a cycle, that is, nodes that reference each other circularly. `

`Trees on the other hand. are not "allowed" to have cycles. If a graph has a cycle, then it's not a tree`

Another characteristic specific to trees is that every node is somehow connected to every other node, even if the connections are indirect. It's possible for a graph to not be fully connected.

## Graph Jargon

Each node is called a _vertex_.
The lines (vertices) between nodes _edges_
And vertices that are connected by an edge are said to be _adjacent_ to each other. Some also refer tp adjacent vertices as _neighbors_

A graph where all the vertices are connected in some way is said to be a _connected graph_

## The Bare-Bone Graph Implementation

Here's a bare-bone ruby implementation of our social network using a hash table.

```ruby
friends = {
  "Alice" => ["Bob", "Diana", "Fred"],
  "Bob" => ["Alice", "Diana", "Cynthia"],
  "Cynthia" => ["Bob"],
  "Diana" => ["Bob", "Bob", "Fred"],
  "Elise" => ["Fred"],
  "Fred" => ["Alice", "Diana", "Elise"]
}
```

With a graph, we can look up Alice's friends in O(1), because we can look up the value of any key in the ahsh table with one step.

## Direct Graphs

In some social networks, relationships are not mutual. For example, a social network may allow Alice to **follow** Bob, but Bob doesn't have to follow Alice back.

This new logic for a grap is known as a **directed graph**, where we have direction for the relationships between the nodes.

We can still use our simple hash-table implementation to store this data:

followes = {
"Alice" => ["Bob", "Cynthia"],
"Bob" => ["Cynthia"],
"Cynthia" => ["Bob"]
}

The only difference here is that we are using the arrays to represent the people each person follows.

## Object Oriented Graph Implementation

```ruby
class Vertex
  attr_accessor :value, :adjacent_vertices

  def initialize(value)
    @value = value
    @adjacent_vertices = []
  end

  def add_adjacent_vertices(vertex)
    @adjacent_vertices << vertex
  end
end
```

The Vertex class has two primary attributes, the _value_ and an array of _adjacent_vertices_.
The adjacent_vertices array contains all the vertices this vertex connects to. We can add a new adjacent vertex to a given using the add_adjacent_vertex method.

Ex. Here's how we can use this class to build a directed graph representing who follows whom

```ruby
alice = Vertex.new("alice")
bob = Vertex.new("bob")
cynthia = Vertex.new("cynthia")

alice.add_adjacent_vertex(bob)
alice.add_adjacent_vertex(cynthia)
bob.add_adjacent_vertex(cynthia)
cynthia.add_adjacent_vertex(bob)
```

Now, _if we were building a undirected graph_ for the social network. If would make sense _if we add Bob to Alice's list of friends_, we should automatically add Alice to Bob's list of friends as well.

To do this we can modify our add_adjacent_vertex method as folllows:

```ruby
def add_adjacent_vertex(vertex)
  return if adjacent_vertices.include?(vertex)
  @adjacent_vertices << vertex
  vertex.add_adjacent_vertex(self)
end
```

## Graph Search

The term "search" can have several connotations. In the simplest sense, to _search_ a graph means to find a particular vertex somewhere within the graph. This would be similar to searching for a value within an array or a key-value pair inside a hash table.

However, when applied to graphs, the term _search_ usually has a more specific connotation, and that is: _if we have access to on vertex in the graph, we must find another particular vertex that is somehow connected to this vertex_

The term _path_ is an official graph term, and it means the specific sequence of edges to get from one vertex to another.

Search can be used to find any vertex within thr entire graph even if we have access to just one random vertex.

Another use for graph search is to _discover whether two vertices are connected_.

Search can also be used even if we aren't looking for one particular vertex. That is, we can use graph search to merely traverse a graph.

There are two well-known approaches for graph search: depth-first search, and breadth-first search.

### Depth First Search

Also named as DFS (depth first search)

The key to any graph search algorithm is keeping track of which vertices we've visited so far. Of we don't do this, we can end up in an infinite cycle.

One way to keep track of our visited vertices is by using a hash table. We visit each vertex, we add the vertex (or its value) as a key in the hash table and assign it an arbitrary value, such as the boolean true. if a vertex is present in the hash table, it means we've already visited it.

With this in mind, the depth first search algorithm works as follows:

1. Start at any random vertex within the graph
2. Add the current vertex to the hash table to mark it as having been visited.
3. Iterate through the current vertex's adjacent vertices
4. For each adjacent vertex, if the adjacent vertex has already been visited, ignore it.
5. If the adjacent vertex has not yet been visited, recursively perform depth-first search on that vertex.

Code implementation

```ruby
def dfs_traverse(vertex, visited_vertices = {})
  # Mark vertex as visited by adding it to the hash table:
  visited_vertices[vertex.value] = true

  # Print the vertex's value, so we can make sure our traversal really works
  puts vertex.value

  # Iterate through the current vertex's adjacent vertices:
  vertex.adjacent_vertices.each do [adjacent_vertex]

    # ignore an adjacent vertex if we've already visited it:
    next if visited_vertices[adjacent_vertex.value]

    # Revursively call this method on the adjacent vertex:
    dfs_traverse(adjacent_vertex, visited_vertices)
  end
end
```

> If we want to use depth-first search to actually search for a particular vertex, we can use a modified version of the previous function

```ruby
def dfs(vertex, search_value, visited_vertices = {})
  return vertex if vertex.value == search_value

  visited_vertices[vertex.value] = true

  # Iterate through the current vertex's adjacent vertices:
  vertex.adjacent_vertices.each do [adjacent_vertex]
    next if visited_vertices[adjacent_vertex.value]

    # if the adjacent vertex is the vertex we're searching for, just return that vertex:
    return adjacent_vertex if adjacent_vertex.value == serach_value

    # Attemp to find the vertex we;re searching for by using by recursively calling this method on the adjacent vertex:
    vertex_were_searching_for = dfs(adjacent_vertex, search_value, visited_vertices)

    # If we were able to find the correct vertex using the above recursion, return the correct vertex
    return vertex_were_searching_for if vertex_were_searching_for
  end

  # if we haven't found the vertex we're searching for
  return nil
end
```

## Breadth-First Search

Breadth-first search, often abbreviated _BFS_, is another way to search a graph. Unlike depth-first search, breadth-first search does _not use recursion_. Instead, the alforithm revolves around our old friend, the queue. As you'll recall, the queue is a FIFO data structure, and whatever goes in first, comes out first.

Algorithm for breadth-first traversal:

1. Start at any vertex within the graph. We'll call this the "starting vertex"
2. Add the starting vertex to the hash table to mark it has having been visited
3. Add a starting vertex to a queue
4. Start a loop that runs while the queue isn't empty
5. Within this loop, remove the first vertex from the queue. We'll call this the "current vertex"
6. Iterate over all the adjacent vertices of current vertex
7. If the adjacent vertex was already visited, ignore it
8. If the adjacent vertex has _not_ yet been visited, mark it as visited by adding it to a hash table, and add it to the queue
9. Repeat this loop (starting from Step 4) until the queue is empty

> Code implementation

```ruby
def bfs_traverse(starting_vertex)
  queue = Queue.new

  visited_vertices = {}
  visited_vertices[starting_vertex.value] = true
  queue.enqueue(starting_vertex)

  # While the queue is not empty:
  while queue.read
    # Remove the first vertex off the queue and make it the current vertex
    current_vertex = queue.dequeue

    puts current_vertex.value

    # Iterate over current vertex's adjacent vertices
    current_vertex.adjacent_vertices.each do |adjacent_vertex|
      # if we have not yet visited yhe adjacent_vertex
      if !visited_vertices[adjacent_vertex.value]

        # Mark the adjacent vertex as visited:
        visited_vertices[adjacent_vertex.value] = true

        # Add the adjacent vertex to the queue
        queue.enqueue(adjacent_vertex)
      end
    end
  end
end
```

## DFS vs. BFS

If you look at the order of _breadth-first search_, you will notice that we first traverse all of Alice's immediate connections.
With _depth-first search_, though, we immediately move as far away from Alice as we possibly can until we're forced to return to her.

Is one apporach better than the other?

Usually one of the main factors in determining which algorithm to use in the nature of the graph you're searching and what you're searching for. The key here, as mentioned earlier, is that breadth-first search traverses all the vertices closest to the starting vertex before moving father away.

### The efficiency of Graph Search

In both depth-first search and breadth-first search, we traverse all the vertices in a worst-case scenario.
In any case, we touch all the vertices in the graph. At first glance, this would seem to be O(N), with N being the number of vertices.

However in both search algorithms, for each vertex we traverse, we also iterate over all of its adjacent vertices.

So, for each vertex we visit, we also spend steps checking each of the vertex's adjacent neighbors.

It emerges that we can't just count how many vertices are in the graph. Instead we also need to consider how many adjacent neighbors each vertex has.

To effectively describe the efficiency of graph search, then, we're going to need to use two variables. We need one to represent the number of vertices in the graph, and another to be the total number of adjacent neighbors each vertex has.

## O(V + E)

The V is the easiear one. V stands for _vertex_ and representes the number of vertices in the graph.

E, interestingly, stands for _edge_, meaning the number of edges in the graph.

Now, computer scientists describe the efficiency of graph search as O(V + E). This means that the number of steps is the number vertices in the graph _plus_ the number of _edges_ in the graph.

The most accurate way to describe the efficiency of graph search in a graph with 5 nodes all connected would be to count the five vertices, plus:

- 2 \* edge between V and W
- 2 \* edge between V and X
- 2 \* edge between V and Y
- 2 \* edge between V and Z

So, this comes out to be V + 2E, since V is 5, and each edge is used twice.

The answer, though, to why we just call this O(V + E), is because _Big O drops the constants_. While in really the number of steps is V + 2E, we reduce this to O(V + E).

At the end of the day, graph search is O(V + E) in a worst-case scenario, where the vertex, we're searching for is the last one we find (or isn't present int he graph at all). And this is true for both breadth-first searc as well as depth-first search.

## Weighted Graphs

Another useful type of graph, known as a weighted graph, adds additional information to the _edges_ of the graph.

> Code implementation

```ruby
class WeightedGraphVertex
  attr_accessor :value, :adjacent_vertices

  def initialize(value)
    @value = value
    @adjacent_vertices = {}
  end

  def add_adjacent_vertex(vertex, weight)
    @adjacent_vertices[vertex] = weight
  end
end
```

### Dijkstra's Algorithm Setup

The first thing to note is that Dijkstra's algorithm comes with a free bonus. We're not just going to find the cheapest price from Atlanta to El Paso, but also we're going to find the cheapest prices from Atlanta to all known cities.

> Steps of Dijkstra's Algorithm

1. We visit the starting city, making it our "current city"
2. We check the prices from the current city to each of its adjacent cities.
3. If the price to an adjacent city from the starting city is cheaper than the price currently in _cheapest_previous_stopover_city_table_ (or the adjacent city isn't yet in the _cheapest_prices_table_)
   a. We update the _cheapest_prices_table_ to reflect this cheaper price
   b. We update the _cheapest_previous_stopover_city_table_, making the adjacent city the key and the current city the value
4. We then visit whichever unvisited city has the cheapest price from the starting city, making it the current city.
5. We repeat the Steps 2 throught 4 until we've visited every known city.

### The effiiency of dijkstra's algorithm

Dijkstra's algorithm is a general description of the approach for finding the shortest parth within a weighted graph, bit it does not specify the precise code implementation. IN fat, there are a number of variations out there in how this algorithm can be written.

In out code implementation, we used a simple arrau for the unvisited_cities data structure, but I noted that a priority queue could be used instead.

When we used a simple array for keeping track of the cities we haven't visited yet (unvisited_cities), our algorithm can take up to O(V^2) steps. This is because the worst-case scenario for Dijkstra's algorithm is when each vertex has an edge leading to every other vertex within the graph. In this case, for every vertex we visit, we check the weight of the path from that vertex to every other vertex. This V vertices multiplied by V vertices, which is O(V^2).

> Notes from the book [A Common-Sense Guide to Data Structures and Algorithms, Second Edition]
