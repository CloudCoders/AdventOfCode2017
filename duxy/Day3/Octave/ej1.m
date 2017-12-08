N = 607;
findn = 368078; 
find = [0 0];

fn = 1;
x = floor(N./2);
y = floor(N./2);
expo = 1;

while (fn < N*N)
  per = expo**2 - (expo-2)**2;
  if(per == 0)
    if(findn == fn)
      find = [x y];
    endif    
  else
    x = x + 1;
    fn = fn + 1;
    if(findn == fn)
      find = [x y]
    endif
    for j=0:(expo-3)
      y = y - 1;
      fn = fn + 1;
      if(findn == fn)
        find = [x y];
      endif
    endfor
    for j=1:(expo-1)
      x = x - 1;
      fn = fn + 1;
      if(findn == fn)
        find = [x y];
      endif
    endfor
    for j=1:(expo-1)
      y = y + 1;
      fn = fn + 1;
      if(findn == fn)
        find = [x y];
      endif
    endfor
    for j=1:(expo-1)
      x = x + 1;
      fn = fn + 1;
      if(findn == fn)
        find = [x y];
      endif
    endfor  
  endif 
  expo = expo + 2;
endwhile
floor(N/2) - find(1) + find(2) - floor(N/2)