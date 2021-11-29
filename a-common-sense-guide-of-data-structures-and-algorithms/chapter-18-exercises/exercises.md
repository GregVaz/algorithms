1. The first graph powers an e-commerce store’s recommendation engine. Each vertex represents a product available on the store’s website. The edges connect each product to other “similar” products the site will recommend to the user when browsing a particular item.

If the user is browsing “nails,” what other products will be recommended to the user?

2. If we perform depth-first search on the second graph starting with the “A” vertex, what is the order in which we’ll traverse all the vertices? Assume that when given the choice to visit multiple adjacent vertices, we’ll first visit the node that is earliest in the alphabet.”

3. If we perform breadth-first search on the previous graph starting with the “A” vertex, what is the order in which we’ll traverse all the vertices? Assume that when given the choice to visit multiple adjacent vertices, we’ll first visit the node that is earliest in the alphabet.”

4. In this chapter, I only provided the code for breadth-first traversal, as discussed in ​Breadth-First Search​. That is, the code simply printed the value of each vertex. Modify the code so that it performs an actual search for a vertex value provided to the function. (We did this for depth-first search.) That is, if the function finds the vertex it’s searching for, it should return that vertex’s value. Otherwise, it should return null.

5. In ​Dijkstra’s Algorithm​, we saw how Dijkstra’s algorithm helped us find the shortest path within a weighted graph. However, the concept of a shortest path exists within an unweighted graph as well. How?

The shortest path in a classic (unweighted) graph is the path that takes the fewest number of vertices to get from one vertex to another.

This can be especially useful in social networking applications. Take the example network that follows:

If we want to know how Idris is to connected Lina, we’d see that she’s connected to her from two different directions. That is, Idris is a second-degree connection to Lina through Kamil, but she is also a fifth-degree connection through Talia. Now, we’re probably interested in how closely Idris is connected to Lina, so the fact that she’s a fifth-degree connection is unimportant given that they’re also second-degree connections.

Write a function that accepts two vertices from a graph and returns the shortest path between them. The function should return an array containing the precise path, such as ["Idris", "Kamil", "Lina"].

Hint: The algorithm may contain elements of both breadth-first search and Dijkstra’s algorithm.

> 1.r =

The main products to recommend to the user could be those that are directly connected -> ["nail polish", "pins", "needles", "hammer"]

> 2.r =

The result if we perform a depth-first search is:
-> A, B, E, J, O, F, C, G, K, D, H, L, M, I, N, P

> 3.r =

The result if we perform a breadth-first search is:
-> A, B, C, D, E, F, J, O, G, K, H, I, L, M, N, P

> 4.r =

```ruby

def bfs(starting_vertex, search_value)
  return starting_vertex if starting_vertex.value == search_value
  queue = Queue.new

  visited_vertices = {}
  visited_vertices[starting_vertex.value] = true
  queue.enqueue(starting_vertex)

  # While the queue is not empty:
  while queue.read
    # Remove the first vertex off the queue and make it the current vertex
    current_vertex = queue.dequeue

    # Iterate over current vertex's adjacent vertices
    current_vertex.adjacent_vertices.each do |adjacent_vertex|
      return adjacent_vertex if adjacent_vertex.value == search_value

      # if we have not yet visited yhe adjacent_vertex
      if !visited_vertices[adjacent_vertex.value]

        # Mark the adjacent vertex as visited:
        visited_vertices[adjacent_vertex.value] = true

        # Add the adjacent vertex to the queue
        queue.enqueue(adjacent_vertex)
      end
    end

    return nil
  end
end
```

> 5.r =
