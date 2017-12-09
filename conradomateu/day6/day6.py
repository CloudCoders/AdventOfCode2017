def getBeginIndex(arr, lastIndex):
    findNextMax = False
    resIndex = lastIndex
    while (findNextMax == False):
        resIndex = nextIndexOf(arr, resIndex)
        findNextMax = max(arr) == arr[resIndex]
    return resIndex


def nextIndexOf(arr, index):
    return index + 1 if index + 1 < len(arr) else 0


def lowerBalance(arr, index):
    res = arr[:]
    numbersToSum = res[index]
    res[index] = 0
    currentIndex = nextIndexOf(res, index)
    while numbersToSum != 0:
        numbersToSum -= 1
        res[currentIndex] = res[currentIndex] + 1
        currentIndex = nextIndexOf(res, currentIndex)
    return res


def sol(arr):
    res = 1
    beginArr = arr[:]
    beginIndex = arr.index(max(arr))
    solutions = []
    solutions.append(beginArr)
    lastSolution = wichResolver(arr, beginIndex)
    while lastSolution not in solutions:
        res += 1
        solutions.append(lastSolution)
        beginIndex = getBeginIndex(lastSolution, beginIndex)
        lastSolution = wichResolver(lastSolution,beginIndex)


    return res


def wichResolver(arr,index):
    if arr[index] > len(arr)-1:
        return greaterBalance(arr, index)
    else:
        return lowerBalance(arr, index)


def greaterBalance(arr,maxIndex):
    sumOtherNumbers = arr[maxIndex]//(len(arr)-1)
    maxUpdated = arr[maxIndex]-sumOtherNumbers*(len(arr)-1)
    return list([x + sumOtherNumbers if i != maxIndex else maxUpdated for i, x in enumerate(arr)])




