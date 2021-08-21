import sys
import os
import heapq

# 트리는 비선형 자료구조 & 계층구조
# (트리 기본지식)[https://towardsdatascience.com/8-useful-tree-data-structures-worth-knowing-8532c7231e8c]
# 최소힙 https://www.geeksforgeeks.org/min-heap-in-python/



def solution():
  # 첫줄은 연산개수 N
  N = int(input())
  minHeap = []
  lines = sys.stdin.readlines()
  # N개의줄 연산정보(x)
  for line in lines:
    x = int(line)
    if x != 0:
      # 최소힙에 대입
      # minHeap.insert(x)
      heapq.heappush(minHeap, x)
    else:
      # min을 출력하고 최소힙에서 min 제거
      # minimum = minHeap.delete()
      if len(minHeap) == 0:
        print(0)
      else:
        print(heapq.heappop(minHeap))

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()



