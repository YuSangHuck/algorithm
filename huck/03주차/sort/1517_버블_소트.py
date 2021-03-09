import os
import sys

g_res = 0

def handleInput():
  suffix = '_input.txt'
  name, ext = os.path.splitext(__file__)
  inputFileName = name + suffix

  sys.stdin = open(inputFileName, 'r')

def merge(arr, start, mid, end):
  global g_res
  # left은 start ~ mid => mid - start + 1
  # right는 mid+1 ~ end => end - mid
  # start부터 end까지니 총 개수는 1 - start + end
  lLen = 1 + mid - start
  rLen = end - mid
  tempSorted = [0] * (lLen + rLen)
  lPos = start
  rPos = 1 + mid
  lCount = 0
  rCount = 0
  # 임시정렬
  while(not (lCount == lLen and rCount == rLen)):
    lVal = arr[lPos] if lCount != lLen else sys.maxsize
    rVal = arr[rPos] if rCount != rLen else sys.maxsize
    # 오른쪽에 있는걸 넣어주고
    if lVal > rVal:
      tempSorted[lCount + rCount] = rVal
      rCount += 1
      rPos += 1
      g_res += lLen - lCount
    # 왼쪽에 있는걸 넣어주고
    else:
      tempSorted[lCount + rCount] = lVal
      lCount += 1
      lPos += 1
  # 임시정렬된거 복사
  for i in range(lLen + rLen):
    arr[start + i] = tempSorted[i]


def mergeSort(arr, start, end):
  if (start >= end):
    return

  mid = (start + end) // 2
  mergeSort(arr, start, mid) # 부분문제 1
  mergeSort(arr, 1 + mid, end) # 부분문제 2
  merge(arr, start, mid, end) # 부분문제 1,2를 합병 start ~ mid, 1+mid ~ end

def combine(arr, start, mid, end):
  print('combine')

def solution(arr):
  global g_res
  g_res = 0
  mergeSort(arr, 0, len(arr) - 1)
  print(g_res)


if __name__ == '__main__':
  # select stdin
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  # handle input
  tc = int(input())
  for _ in range(tc):
    n = int(input()) # <= 500,000
    an = list(map(int, input().split())) # <= 1,000,000,000
    # solution
    solution(an)
