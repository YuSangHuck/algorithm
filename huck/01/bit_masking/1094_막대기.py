# 1. sum(막대s) > X
#   if true
#     가장짧은거 반띵 = a
#     합 - a >= X
#     또버려?
#   else
#     완성

# ex) 23 / 16,4,2,1
# 64
# 64 / 32 32 / 32
# 32 / 16 16 / 

# ---

import sys
import os

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix

  sys.stdin = open(inputFileName, "r")


def solution(targetLength):
  # 조건에서 애초에 X의 범위가 주어졌음
  # if (targetLength > 64):
  #   # 예외처리 해야 함.
  #   print('64보다 큰 길이는 만들 수 없음')
  #   return


  count = 0
  while(targetLength != 0):
    count += targetLength & 1
    targetLength >>= 1

  print(count)
  return count

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  for line in sys.stdin:
    solution(int(line))