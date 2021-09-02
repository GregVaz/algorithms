class Linter
  def initialize
    @stack = Stack.new
  end

  def lint(text)
    text.each_char do |char|
      if is_opening_brace?(char)
        @stack.push(char)
      elsif is_closing_brace?(char)
        popped_opening_brace = @stack.pop

        if !popped_opening_brace
          return "#{char} does not have opening brace"
        end

        if is_not_a_match(popped_opening_brace, char)
          return "#{char} has mismatched opening brace"
        end
      end
    end
    
    if @stack.read
      return "#{@stack.read} does not have closing read"
    end

    return true
  end

  private
  
  def is_opening_brace?(char)
    ["(", "[", "{"].include?(char)
  end

  def is_closing_brace?(char)
    [")", "]", "}"].include?(char)
  end

  def is_not_a_match(opening_brace, closing_brace)
    closing_brace != {"(" => ")", "[" => "]", "{" => "}"}[opening_brace]
  end
end