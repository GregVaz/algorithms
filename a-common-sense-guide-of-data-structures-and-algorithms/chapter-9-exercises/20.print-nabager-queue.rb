class PrintManager
  def initialize
    @queue = Queue.new
  end

  def queue_print_job(document)
    @queue.enqueue(document)
  end

  def run
    while @queue.read
      print(@queue.dequeue)
    end
  end

  private
  def print(document)
    puts document
  end
end

print_manager = PrintManager.new
print_manager.queue_print_job("First document")
print_manager.queue_print_job("Second document")
print_manager.queue_print_job("Third document")
print_manager.run