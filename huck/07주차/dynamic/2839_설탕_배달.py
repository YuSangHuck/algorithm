import os
import sys

def handleInput():
  suffix = '_input.txt'
  name, ext = os.path.splitext(__file__)
  inputFileName = name + suffix

  sys.stdin = open(inputFileName, 'r')

def solution(n):
  res = -1

  # 5의 개수 범위
  max5 = n // 5

  # 5는 max5 ~ 0개
  for count5 in range(max5, -1, -1):
    remain = n - (5 * count5)
    if remain == 0:
      res = max5
      break

    # 5개수 기반 3 확인
    if remain % 3 == 0:
      count3 = remain // 3
      res = count5 + count3
      break

  return res


if __name__ == '__main__':
  # select stdin
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  # handle input
  tc = int(input())
  for _ in range(tc):
    n = int(input()) # <= 500,000

    # solution
    print(solution(n))
