require_relative "eje_one"
require_relative "eje_two"
require "test/unit"
 
class TestSimpleNumber < Test::Unit::TestCase
 
  def test_simple_ej1
    assert_equal(4877, EjerOne.new().solution("input.txt"))
    assert_equal(1, EjerOne.new().solution("input2.txt"))
  end

  def test_simple_ej2
    assert_equal(5471, EjerTwo.new().solution("input.txt")) 
    assert_equal(10, EjerTwo.new().solution("input2.txt"))       
  end
 
end