N = 607;
findn = 368078; 
find = [0 0];

fn = 1;
x = floor(N./2);
y = floor(N./2);
expo = 1;

matrix = zeros(N,N);

while (fn < N*N)
  per = expo**2 - (expo-2)**2;
  if(per == 0)
    matrix(x,y) = 1;
  else
    x = x + 1;
    fn = fn + 1;
    matrix(y,x) = matrix(y-1,x-1) + matrix(y-1,x) + matrix(y-1,x+1) + matrix(y,x+1); 
    matrix(y,x) = matrix(y+1,x-1) + matrix(y+1,x) + matrix(y+1,x+1) + matrix(y,x-1) + matrix(y,x);
    if(findn < matrix(y,x))
      find = [x y];
      break;
    endif
    if find != [0 0]
      break;
    endif
    for j=0:(expo-3)
      y = y - 1;
      fn = fn + 1;
      matrix(y,x) = matrix(y-1,x-1) + matrix(y-1,x) + matrix(y-1,x+1) + matrix(y,x+1); 
      matrix(y,x) = matrix(y+1,x-1) + matrix(y+1,x) + matrix(y+1,x+1) + matrix(y,x-1) + matrix(y,x);
      if(findn < matrix(y,x))
        find = [x y];
        break;
      endif    
    endfor
    if find != [0 0]
      break;
    endif
    for j=1:(expo-1)
      x = x - 1;
      fn = fn + 1;
      matrix(y,x) = matrix(y-1,x-1) + matrix(y-1,x) + matrix(y-1,x+1) + matrix(y,x+1); 
      matrix(y,x) = matrix(y+1,x-1) + matrix(y+1,x) + matrix(y+1,x+1) + matrix(y,x-1) + matrix(y,x);
      if(findn < matrix(y,x))
        find = [x y];
        break;
      endif    
    endfor
    if find != [0 0]
      break;
    endif
    for j=1:(expo-1)
      y = y + 1;
      fn = fn + 1;
      matrix(y,x) = matrix(y-1,x-1) + matrix(y-1,x) + matrix(y-1,x+1) + matrix(y,x+1); 
      matrix(y,x) = matrix(y+1,x-1) + matrix(y+1,x) + matrix(y+1,x+1) + matrix(y,x-1) + matrix(y,x);
      if(findn < matrix(y,x))
        find = [x y];
        break;
      endif    
    endfor
    if find != [0 0]
      break;
    endif
    for j=1:(expo-1)
      x = x + 1;
      fn = fn + 1;
      matrix(y,x) = matrix(y-1,x-1) + matrix(y-1,x) + matrix(y-1,x+1) + matrix(y,x+1); 
      matrix(y,x) = matrix(y+1,x-1) + matrix(y+1,x) + matrix(y+1,x+1) + matrix(y,x-1) + matrix(y,x);
      if(findn < matrix(y,x))
        find = [x y];
        break;
      endif    
    endfor
    if find != [0 0]
      break;
    endif 
  endif 
  expo = expo + 2;
endwhile
matrix(find(1),find(2))