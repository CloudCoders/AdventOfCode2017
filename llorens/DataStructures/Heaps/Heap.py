class Heap(object):

    def __init__(self, array=[]):

        self.array = []

        for i in range(len(array)):
            self.array.append(array[i])
            self.sift_up(i)

    def sift_up(self, i):
        if (len(self.array) is 0) or i >= len(self.array):
            return self.array

        while self.array[int((i-1)/2)] < self.array[i]:
            father = int((i-1)/2)
            aux = self.array[i]
            self.array[i] = self.array[father]
            self.array[father] = aux
            i = father

        return self.array

    def sift_down(self, i):

        while i <= int(self.get_size()/2)-1:

            if i*2 + 2 >= self.get_size():
                if self.array[(i * 2) + 1] > self.array[i]:
                    left_child = self.array[i * 2 + 1]
                    self.array[i * 2 + 1] = self.array[i]
                    self.array[i] = left_child
                break

            if self.array[i*2 + 1] < self.array[i] and i*2 + 2 < self.get_size():
                if self.array[i*2 + 2] < self.array[i]:
                    break

            left_child = self.array[i*2 + 1]
            right_child = self.array[i*2 + 2]

            if left_child > right_child:
                self.array[i*2 + 1] = self.array[i]
                self.array[i] = left_child
                i = (i*2)+1
            else:
                self.array[i*2 + 2] = self.array[i]
                self.array[i] = right_child
                i = (i*2)+2

        return self.array

    def get_heap(self):
        return self.array

    def insert(self, new_value):
        self.array.append(new_value)
        self.sift_up(len(self.array)-1)

    def find_max(self):

        if self.array is []:
            return None

        return self.array[0]

    def get_size(self):
        return len(self.array)

    def pop(self):

        if self.get_size() is 1:
            result = self.array[0]
            self.array = []
            return result

        result = self.array[0]
        self.array[0] = self.array.pop()
        self.sift_down(0)

        return result




