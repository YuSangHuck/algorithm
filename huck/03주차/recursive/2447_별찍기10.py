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
  # pattern3[0:3]  # '* * *'
  # pattern3[4:7]  # '*   *'
  # pattern3[8:11] # '* * *'

  pattern = '''***
* *
***'''

  a = pattern[0*(n+1) : n + 0*(n+1)] # '* * *'
  b = pattern[1*(n+1) : n + 1*(n+1)] # '*   *'
  c = pattern[2*(n+1) : n + 2*(n+1)] # '* * *'

  if n == 3:
    return pattern

  newPattern = solution(n//3)

  return pattern

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  # 3^1 ~ 3^7
  n = int(input())

  print(solution(n))
  # print(pattern3*2)