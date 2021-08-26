# n이 3인 패턴
# ***
# * *
# ***

# n이 3보다 클 때 패턴
# 공백분을 n/3 패턴으로


import os
import sys

g_resList = []


def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)
  sys.stdin = open(filename + suffix, 'r')

def solution(i, j, n):
  global g_resList
  if (i // n) % 3 == 1 and (j // n) % 3 == 1:
    g_resList.append(' ')
  else:
    if n // 3 == 0:
      g_resList.append('*')
    else:
      solution(i, j, n//3)

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  # 3^1 ~ 3^7
  n = int(input())

  for i in range(n):
    for j in range(n):
      solution(i, j, n)
    g_resList.append('\n')

  print(g_resList)
  print(''.join(g_resList))