class EjerTwo

  def do_comparation(number, op, comparational, dic)    
    case op
    when "<"
      return (dic[number] < comparational.to_i)
    when ">"
     return (dic[number] > comparational.to_i)
    when "<="
      return (dic[number] <= comparational.to_i) 
    when ">="
      return (dic[number] >= comparational.to_i) 
    when "=="
      return (dic[number] == comparational.to_i)
    when "!="
      return (dic[number] != comparational.to_i) 
    end  
  end

  def do_operation(var, op, numebr, dic)
    case op
    when "inc"
      dic[var] = dic[var] + numebr.to_i    
    when "dec"
      dic[var] = dic[var] - numebr.to_i
       
    end    
  end

  

  def solution(name)
    lines_of_code = []
    dictio_of_vars = {}
    max = 0

    File.open(name, "r") do |f|
      f.each_line do |line|
        aux_code = line.split(" ")
        dictio_of_vars[aux_code[0]]=0
        lines_of_code.insert(-1,aux_code)
      end
    end

    for line in lines_of_code
      if do_comparation(line[4], line[5], line[6],dictio_of_vars)
        do_operation(line[0],line[1],line[2],dictio_of_vars)
      end
      for key,value in dictio_of_vars
        if value > max
          max = value
        end
      end
    end
    return max
  end

end
