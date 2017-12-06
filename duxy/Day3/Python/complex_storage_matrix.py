
import numpy as np

N = 17 #607 #17
matrix = []
for i in range(N):
  matrix.append([0]*N)
matrix = np.matrix(matrix)

findn = 211 #368078 #211
find = [0,0]

fn = 1
x = N//2
y = N//2
expo = 1

while(fn < N*N):  
  per = expo**2 - (expo-2)**2 
  if per == 0:
    matrix[x,y] = 1
    if findn == fn : find = [x,y]
  else:    
    x = x + 1
    fn = fn + 1
    matrix[y,x] = fn
    if findn == fn : find = [x,y]
    for j in range(expo-2):
      y = y - 1
      fn = fn + 1
      matrix[y,x] = fn
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      x = x - 1
      fn = fn + 1
      matrix[y,x] = fn
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      y = y + 1
      fn = fn + 1
      matrix[y,x] = fn
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      x = x + 1
      fn = fn + 1
      matrix[y,x] = fn
      if findn == fn : find = [x,y]   
  expo = expo + 2;


print(matrix)
print(find)

print(N//2,find[0], N//2 - find[0] , find[1] - N//2)
print( N//2 - find[0] + find[1] - N//2)
