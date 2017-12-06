passwords = open("input.txt", "r").read().split("\n") 
correct = 0
for passw in passwords:
  if (len(passw.split()) == len(set(passw.split()))) & (len(passw.split()) > 1): correct = correct + 1     
print(correct)
