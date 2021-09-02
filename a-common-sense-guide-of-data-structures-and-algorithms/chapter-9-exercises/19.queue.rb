class Queue
  def initialize
    @data = []
  end

  def enqueueu(element)
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