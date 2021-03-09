import sys
import os

# 트리는 비선형 자료구조 & 계층구조
# (트리 기본지식)[https://towardsdatascience.com/8-useful-tree-data-structures-worth-knowing-8532c7231e8c]
# 최소힙 https://www.geeksforgeeks.org/min-heap-in-python/



class MinimumHeap:
  def __init__(self, maxSize = 100000):
    self.__maxSize = maxSize
    self.__ROOT_NODE_IDX = 1
    self.__data = [0] * (1 + maxSize) # one-based array. minHeap이니까 0으로 초기화.
    self.__data[0] = -1 * sys.maxsize # index가 0은 제일 작은값이 되어야 한다.
    self.__size = 0

  def parent(self, pos):
    return pos // 2
  def leftChid(self, pos):
    return 2 * pos
  def rightChid(self, pos):
    return 1 + (2 * pos)
  def isLeaf(self, pos):
    if ((self.__size // 2) <= pos) and (pos <= self.__size):
      return True
    return False
  def swap(self, pos1, pos2):
    self.__data[pos1], self.__data[pos2] = self.__data[pos2], self.__data[pos1]
  # pos부터 minHeap정렬. 자식으로 퍼져나간다.
  def minimumHeapify(self, pos):
    if (self.__size and (not self.isLeaf(pos))):
      leftChildPos = self.leftChid(pos)
      rightChildPos = self.rightChid(pos)
      # 부모보다 자식노드가 크다면
      if (self.__data[leftChildPos] < self.__data[pos] or
        self.__data[rightChildPos] < self.__data[pos]):
        # 왼쪽자식보다 더 크면
        if (self.__data[leftChildPos] < self.__data[pos]):
          self.swap(leftChildPos, pos)
          self.minimumHeapify(leftChildPos)
        # 오른쪽자식보다 더 크면
        else:
          self.swap(rightChildPos, pos)
          self.minimumHeapify(rightChildPos)


  def insert(self, element):
    if (self.__size >= self.__maxSize):
      return -1 # maxSize 이상 insert 할 수 없다.

    self.__size += 1
    # 마지막 리프 다음 자리에 element를 넣고
    self.__data[self.__size] = element

    curPos = self.__size
    # curPos와 curPos의 parent랑 비교해서 바꿀 수 있을때까지 바꾼다.
    while( self.__data[curPos] < self.__data[self.parent(curPos)]):
      self.swap(curPos, self.parent(curPos))
      curPos = self.parent(curPos)

  def delete(self):
    if (self.__size == 0):
      return 0
    # min은 root
    min = self.__data[self.__ROOT_NODE_IDX]
    # max를 root에 대입
    self.__data[self.__ROOT_NODE_IDX] = self.__data[self.__size]
    self.__size -= 1
    self.minimumHeapify(self.__ROOT_NODE_IDX)

    return min

def solution():
  # 첫줄은 연산개수 N
  N = int(input())
  minHeap = MinimumHeap(N)
  lines = sys.stdin.readlines()
  # N개의줄 연산정보(x)
  for line in lines:
    x = int(line)
    if x != 0:
      # 최소힙에 대입
      minHeap.insert(x)
    else:
      # min을 출력하고 최소힙에서 min 제거
      minimum = minHeap.delete()
      print(minimum)

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()



