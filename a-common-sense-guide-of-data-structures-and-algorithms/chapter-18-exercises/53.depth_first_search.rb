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

# Code for Depth first traversal search for a particular vertex
def dfs(vertex, search_value, visited_vertices = {})
  return vertex if vertex.value == search_value

  visited_vertices[vertex.value] = true

  # Iterate through the current vertex's adjacent vertices:
  vertex.adjacent_vertices.each do [adjacent_vertex]
    next if visited_vertices[adjacent_vertex.value]

    return adjacent_vertex if adjacent_vertex.value == search_value

    vertex_were_searching_for = dfs(adjacent_vertex, search_value, visited_vertices)

    return vertex_were_searching_for if vertex_were_searching_for
  end

  return nil
end