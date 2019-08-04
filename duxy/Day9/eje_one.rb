class EjerOne

  def solution(name)
    alllines = ""
    score = 0
    File.open(name, "r") do |f|
      f.each_line do |line|
        alllines = alllines + line
      end
    end 
    numofgroups = 0
    groups_open = 0
    novalid = 0
    garbage_open = 0
    alllines = alllines.split("")
    for character in alllines 
      if novalid == 0  
        if garbage_open <= 0
          if character == "{"
            groups_open+= 1
          end
          if character == "}"
            score = score + 1*groups_open
            groups_open-= 1
            numofgroups+= 1
          end
          if character == "<"
            garbage_open+= 1
          end
        end
        if character == "!"
          novalid = 1
        end 
        if character == ">"
          garbage_open-= 1
        end
      else
        novalid = 0
      end
    end
    return score
  end
end