def solver(input):
	return sum(int(input[x]) for x in range (len(input)) if input[x] == input[(x+1)%len(input)])

def solver2(input):
	return sum(int(input[x]) for x in range (len(input)) if input[x] == input[int((x+len(input)/2)%len(input))])
