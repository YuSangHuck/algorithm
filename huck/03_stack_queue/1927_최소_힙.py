import sys
import os

# 트리는 비선형 자료구조 & 계층구조
# (트리 기본지식)[https://towardsdatascience.com/8-useful-tree-data-structures-worth-knowing-8532c7231e8c]

class MinimumHeap:
  def __init__(self):
    self.__data = [None] # one-based array

  def size(self):
    return len(self.__data) - 1
  def childrens(self, key):
    ret = []
    s = self.size()
    lcKey = 2 * key
    rcKey = 1 + lcKey
    if (lcKey<= s):
      ret.append(lcKey)
    if (rcKey <= s):
      ret.append(rcKey)
    return ret

  def insert(self, element):
    self.__data.append(element) # size 1개 늘려놓고
    i = self.size()

    # 루트노드(i != 1)가 아니고
    # 부모랑 비교.
    # 최소힙이므로 parentEl.value >= curEl.value 여야 한다.
    # 같은건 어떻게?
    # parentKey = i // 2
    while((i > 1) and (self.__data[i] < self.__data[i // 2])):
      # 부모(self.__data[i // 2])의 value를 자식(self.__data[i])한테 넣어준다
      self.__data[i] = self.__data[i // 2]
      i //= 2

    self.__data[i] = element

  def delete(self):
    min = float('inf')
    size = self.size()
    if (size > 1):
      i = 1
      # 일단 최소는 루트노드
      min = self.__data[i]

      # 루트에 leaf 넣어주고
      self.__data[i] = self.__data[size]
      del self.__data[size]

      while (True):
        # 부모가 i일때, chlidrens 중 하나라도 부모보다 작으면
        childrens = self.childrens(i)
        minKey = None
        tmpMin = self.__data[i]
        for childKey in childrens:
          if (tmpMin > self.__data[childKey]):
            tmpMin = self.__data[childKey]
            minKey = childKey

        if (not minKey):
          break

        self.__data[minKey] = self.__data[i]
        self.__data[i] = tmpMin

        i *= 2
    elif (size > 0):
      # 루트노드 반환
      min = self.__data[1]
      del self.__data[1]
    else:
      min = 0

    return min


    min = self.__data[1]
    size = self.size()
    i = self.size()

    # 자식 중 더 작은놈이랑 교환

    del self.__data[size]


    size = self.size()
    if size != 0:
      pos = 0
      # sibling끼리는 상관관계가 없으므로 비교가 필요하면 해야함.
      if (size > 1 and size % 2):
        if (self.__data[size] > self.__data[size-1]):
          pos = size
        else:
          pos = size-1
      else:
        pos = size
      max = self.__data[pos]
      del self.__data[pos]
    else:
      max = 0
    return min

def solution():
  minHeap = MinimumHeap()
  # 첫줄은 연산개수 N
  N = int(input())
  lines = sys.stdin.readlines()
  # N개의줄 연산정보(x)
  for line in lines:
    x = int(line)
    if x != 0:
      # 최소힙에 대입
      minHeap.insert(x)
    else:
      # min을 출력하고 최소힙에서 min 제거
      maximum = minHeap.delete()
      print(maximum)

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()