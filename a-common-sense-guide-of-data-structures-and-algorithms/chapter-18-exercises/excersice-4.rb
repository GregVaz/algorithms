class Queue
  def initialize
    @data = []
  end

  def enqueue(element)
    @data << element
  end

  def dequeue
    # The ruby shift method removes and returns the first element of an array
    @data.shift
  end

  def read
    @data.first
  end
end

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
  end
  return nil
end

atlanta = Vertex.new("Atlanta")
boston = Vertex.new("Boston")
chicago = Vertex.new("Chicago")
denver = Vertex.new("Denver")
el_paso = Vertex.new("El Paso")

atlanta.add_adjacent_vertices(boston)
atlanta.add_adjacent_vertices(denver)
boston.add_adjacent_vertices(chicago)
boston.add_adjacent_vertices(denver)
chicago.add_adjacent_vertices(el_paso)
denver.add_adjacent_vertices(chicago)
denver.add_adjacent_vertices(el_paso)

puts(bfs(atlanta, "El Paso"))