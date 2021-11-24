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