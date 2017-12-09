require_relative "eje_one"
require_relative "eje_two"

require "test/unit"
 
class TestSimpleNumber < Test::Unit::TestCase
 
  def test_simple_ej1   
    assert_equal(1, EjerOne.new().solution("input3.txt"))
    assert_equal(9, EjerOne.new().solution("input4.txt"))
    assert_equal(3, EjerOne.new().solution("input5.txt")) 
    assert_equal(16, EjerOne.new().solution("input6.txt"))
    assert_equal(9, EjerOne.new().solution("input7.txt"))  
    assert_equal(50, EjerOne.new().solution("input2.txt")) 
    assert_equal(23588, EjerOne.new().solution("input.txt"))   
  end 

  def test_simple_ej2   
    assert_equal(4, EjerTwo.new().solution("input3.txt"))
    assert_equal(0, EjerTwo.new().solution("input4.txt"))
    assert_equal(17, EjerTwo.new().solution("input5.txt")) 
    assert_equal(0, EjerTwo.new().solution("input6.txt"))
    assert_equal(8, EjerTwo.new().solution("input7.txt"))  
    assert_equal(29, EjerTwo.new().solution("input2.txt")) 
    assert_equal(10045, EjerTwo.new().solution("input.txt"))   
  end 

end