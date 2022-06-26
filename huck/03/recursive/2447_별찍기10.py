# n이 3인 패턴
# ***
# * *
# ***

# n이 3보다 클 때 패턴
# 공백분을 n/3 패턴으로


import os
import sys

def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)
  sys.stdin = open(filename + suffix, 'r')

def solution(n):
  if n == 1:
    return ['*']

  arr = solution(n // 3)
  newArr = list()
  for i in arr:
    newArr.append(i * 3)
  for i in arr:
    newArr.append(i + ' '*(n//3) + i)
  for i in arr:
    newArr.append(i * 3)

  return newArr

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  # 3^1 ~ 3^7
  n = int(input())

  print('\n'.join(solution(n)))