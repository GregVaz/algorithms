class Node
  attr_accessot :data, :next_node

  def initialize(data)
    @data = data
  end
end

=begin
node_1 = Node.new("once")
node_2 = Node.new("upon")
node_3 = Node.new("a")
node_4 = Node.new("time")

node_1.next_node = node_2
node_2.next_node = node_3
node_3.next_node = node_4
=end