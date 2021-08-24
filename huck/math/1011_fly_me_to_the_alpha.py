import os
import sys
import math

def handleInput():
  suffix = '_input.txt'
  file, _ = os.path.splitext(__file__)

  sys.stdin = open(file + suffix, 'r')

def solution(x, y):
  d = y - x

  n = math.sqrt(d)
  f = math.floor(n)

  if f ** 2 == d:
    return 2 * f - 1
  elif f ** 2 < d and d <= (f ** 2) + f:
    return 2 * f
  else:
    return 2 * f + 1

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  _ = input()

  lines = sys.stdin.readlines()
  for line in lines:
    x, y = map(int, line.rstrip('\n').split())
    print(solution(x, y))