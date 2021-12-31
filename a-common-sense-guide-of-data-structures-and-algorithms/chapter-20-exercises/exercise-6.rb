def longest_sequence_length(array)
  hash_table = {}
  greatest_sequence_length = 0

  array.each do |number|
    hash_table[number] = true
  end

  array.each do |number|
    # if the current number is the first in the sequence, there isn't a number one lower than it
    if !hash_table[number - 1]
      current_sequence_length = 1

      current_number = number

      while hash_table[current_number + 1]
        current_number += 1

        current_sequence_length += 1

        if current_sequence_length > greatest_sequence_length
          greatest_sequence_length = current_sequence_length
        end
      end
    end
  end

  return greatest_sequence_length
end

puts longest_sequence_length([10, 5, 12, 3, 55, 30, 4, 11, 2])