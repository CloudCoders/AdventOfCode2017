
import numpy as np

N = 607
findn = 368078 
find = [0,0]

fn = 1
x = N//2
y = N//2
expo = 1

while(fn < N*N):  
  per = expo**2 - (expo-2)**2 
  if per == 0:
    if findn == fn : find = [x,y]
  else:    
    x = x + 1
    fn = fn + 1
    if findn == fn : find = [x,y]
    for j in range(expo-2):
      y = y - 1
      fn = fn + 1
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      x = x - 1
      fn = fn + 1
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      y = y + 1
      fn = fn + 1
      if findn == fn : find = [x,y]
    for j in range(1,expo):
      x = x + 1
      fn = fn + 1
      if findn == fn : find = [x,y]   
  expo = expo + 2;
print( N//2 - find[0] + find[1] - N//2)
