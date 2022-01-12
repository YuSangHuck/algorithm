# 자료 구조
# 정렬
# 이분 탐색
# 해시를 사용한 집합과 맵

import sys
import os

g_result = ''

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution():
  global g_result

  nCount = int(input())
  # - n을 dict(hashmap)으로 저장
  # FIXME nDict에서 값을 넣을때 정렬해서 넣어서 추후에 찾을때 속도 향상
  # -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
  # nDict = dict.fromkeys([i for i in range(-10000000, 10000000)],0)
  nDict = {} # { str: int }
  for s_n in sys.stdin.readline().rstrip('\n').split(' '):
    preVal = 0
    if nDict.get(s_n) is not None:
      preVal = nDict[s_n]
    nDict[s_n] = 1 + preVal

  mCount = int(input())
  # - m을 바로바로 result에 삽입
  # FIXME nDict에서 값을 찾을때 이분탐색으로
  tmpeMCountList = []
  for s_m in sys.stdin.readline().rstrip('\n').split(' '):
    res = 0
    if nDict.get(s_m) is not None:
      res = nDict[s_m]
    # g_result.append(res)
    tmpeMCountList.append(str(res) + ' ')

  g_result = ''.join(tmpeMCountList)

  print(g_result)


if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()
