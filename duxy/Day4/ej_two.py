passwords = open("input.txt", "r").read().split("\n") 
   
for i in range(len(passwords)):  
  sptd = passwords[i].split()
  for j in range(len(sptd)):
    sptd[j] = ''.join(sorted(sptd[j]))
  passwords[i] = sptd

correct = 0
for passw in passwords:
  if ((len(passw)) == len(set(passw))) & (len(passw) > 1):     
    correct = correct + 1     
print(correct)
