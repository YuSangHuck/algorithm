import os
import sys

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

def sol():
  res = []
  _ = sys.stdin.readline()
  xList = list(map(int, sys.stdin.readline().split()))
  xSet = set(xList)
  sortedXSet = sorted(xSet)


  # l 순회
  # 정렬된 s와 비교하면서 index 찾으면 됨
  for x in xList:
    # print('\t', x)
    hitCount = 0
    for sortedX in sortedXSet:
      # print(sortedX)
      if x > sortedX:
        hitCount += 1
      else:
        break
    res.append(str(hitCount))

  # print(l)
  # print(s)
  # print(sorted(s))
  # print(res)
  print(' '.join(res))

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()