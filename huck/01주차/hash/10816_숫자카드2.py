# 자료 구조
# 정렬
# 이분 탐색
# 해시를 사용한 집합과 맵

import sys
import os

g_result = []

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution():
  global g_result

  nCount = int(input())
  nList = []
  nList.extend(int(char) for char in input().rstrip('\n').split(' '))
  mCount = int(input())
  mList = []
  mList.extend(int(char) for char in input().rstrip('\n').split(' '))
  g_result = [0 for i in range(len(mList))]


  for i, mValue in enumerate(mList):
    for j, nValue in enumerate(nList):
      if mValue == nValue:
        g_result[i] += 1

  print(g_result)


if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()
