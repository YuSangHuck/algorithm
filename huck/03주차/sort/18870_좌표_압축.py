import os
import sys

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

def sol():
  res = []
  _ = sys.stdin.readline()
  # set의 ordering으 위해서 list[int]가 필요
  xList = list(map(int, sys.stdin.readline().split()))
  sortedXSet = sorted(set(xList))

  m = {}

  count = 0
  for sortedX in sortedXSet:
    m[sortedX] = count
    count += 1

  for x in xList:
    res.append(str(m[x]))

  print(' '.join(res))

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()