import sys
import os

# 트리는 비선형 자료구조 & 계층구조
# (트리 기본지식)[https://towardsdatascience.com/8-useful-tree-data-structures-worth-knowing-8532c7231e8c]
# 최소힙 https://www.geeksforgeeks.org/min-heap-in-python/

class MinimumHeap:
  def __init__(self, maxSize = 100000):
    self.maxSize = maxSize
    self.size = 0
    self.Heap = [0]*(self.maxSize + 1)
    self.Heap[0] = -1 * sys.maxsize
    self.FRONT = 1

  # Function to return the position of
  # parent for the node currently
  # at pos
  def parent(self, pos):
    return pos // 2
  # Function to return the position of
  # the left child for the node currently
  # at pos
  def leftChild(self, pos):
    return 2 * pos

  # Function to return the position of
  # the right child for the node currently
  # at pos
  def rightChild(self, pos):
    return 1 + (2 * pos)

  # Function that returns true if the passed
  # node is a leaf node
  def isLeaf(self, pos):
    if ((self.size // 2) <= pos) and (pos <= self.size):
      return True
    return False

  # Function to swap two nodes of the heap
  def swap(self, fpos, spos):
    self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]

  # Function to heapify the node at pos
  def minimumHeapify(self, pos):
    if self.size == 0:
      return

    # If the node is a non-leaf node and greater
    # than any of its child
    if not self.isLeaf(pos):
      if (self.Heap[pos] > self.Heap[self.leftChild(pos)] or
        self.Heap[pos] > self.Heap[self.rightChild(pos)]):

        # Swap with the left child and heapify
        # the left child
        if self.Heap[self.leftChild(pos)] < self.Heap[self.rightChild(pos)]:
          self.swap(pos, self.leftChild(pos))
          self.minimumHeapify(self.leftChild(pos))

        # Swap with the right child and heapify
        # the right child
        else:
          self.swap(pos, self.rightChild(pos))
          self.minimumHeapify(self.rightChild(pos))

  # Function to insert a node into the heap
  def insert(self, element):
    if self.size >= self.maxSize :
      return
    self.size+= 1
    self.Heap[self.size] = element

    current = self.size

    while self.Heap[current] < self.Heap[self.parent(current)]:
      self.swap(current, self.parent(current))
      current = self.parent(current)

  # Function to delete and return the minimum
  # element from the heap
  def delete(self):
    if self.size == 0:
      return 0

    min = self.Heap[self.FRONT]
    self.Heap[self.FRONT], self.Heap[self.size] = self.Heap[self.size], 0
    self.size-= 1
    self.minimumHeapify(self.FRONT)
    return min

  # Function to build the min heap using
  # the minimumHeapify function
  def minHeap(self):

    for pos in range(self.size//2, 0, -1):
      self.minimumHeapify(pos)


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



