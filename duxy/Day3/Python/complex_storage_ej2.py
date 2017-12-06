
import numpy as np

N = 607 #17
matrix = []
for i in range(N):
  matrix.append([0]*N)
matrix = np.matrix(matrix)

findn = 368078 #211
find = [0,0]

fn = 1
x = N//2
y = N//2
expo = 1

while(fn < N*N):  
  per = expo**2 - (expo-2)**2 
  if per == 0:
    matrix[x,y] = 1

  else:    
    x = x + 1
    fn = fn + 1
    matrix[y,x] = matrix[y-1,x-1] + matrix[y-1,x] + matrix[y-1,x+1] + matrix[y,x+1] 
    matrix[y,x] = matrix[y+1,x-1] + matrix[y+1,x] + matrix[y+1,x+1] + matrix[y,x-1] + matrix[y,x]
    if findn < matrix[y,x] : 
      find = [x,y] 
      break
    if find != [0,0] : break
    for j in range(expo-2):
      y = y - 1
      fn = fn + 1
      matrix[y,x] = matrix[y-1,x-1] + matrix[y-1,x] + matrix[y-1,x+1] + matrix[y,x+1]
      matrix[y,x] = matrix[y+1,x-1] + matrix[y+1,x] + matrix[y+1,x+1] + matrix[y,x-1] + matrix[y,x]
      if findn < matrix[y,x] : 
        find = [x,y] 
        break
    if find != [0,0] : break
    for j in range(1,expo):
      x = x - 1
      fn = fn + 1    
      matrix[y,x] = matrix[y-1,x-1] + matrix[y-1,x] + matrix[y-1,x+1] + matrix[y,x+1]
      matrix[y,x] = matrix[y+1,x-1] + matrix[y+1,x] + matrix[y+1,x+1] + matrix[y,x-1] + matrix[y,x]
      if findn < matrix[y,x] : 
        find = [x,y] 
        break
    if find != [0,0] : break
    for j in range(1,expo):
      y = y + 1
      fn = fn + 1
      matrix[y,x] = matrix[y-1,x-1] + matrix[y-1,x] + matrix[y-1,x+1] + matrix[y,x+1]
      matrix[y,x] = matrix[y+1,x-1] + matrix[y+1,x] + matrix[y+1,x+1] + matrix[y,x-1] + matrix[y,x]
      if findn < matrix[y,x] : 
        find = [x,y]
        break
    if find != [0,0] : break
    for j in range(1,expo):
      x = x + 1
      fn = fn + 1
      matrix[y,x] = matrix[y-1,x-1] + matrix[y-1,x] + matrix[y-1,x+1] + matrix[y,x+1]
      matrix[y,x] = matrix[y+1,x-1] + matrix[y+1,x] + matrix[y+1,x+1] + matrix[y,x-1] + matrix[y,x] 
      if findn < matrix[y,x] : 
        find = [x,y] 
        break
  expo = expo + 2;    
  if find != [0,0] : break

print(matrix[find[1],find[0]])


