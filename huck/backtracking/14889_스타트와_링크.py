import os
import sys
from itertools import combinations, permutations

score = []

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

def sum(tup):
  global score
  res = 0
  permuList = list(permutations(tup,2))
  for permu in permuList:
    # TODO
    # res += score[permu[0]][permu[1]] + score[permu[1]][permu[0]]
    res += score[permu[0]][permu[1]]

  return res

def sol():
  global score

  n = int(sys.stdin.readline())
  lines = sys.stdin.readlines()
  # score = [line.split() for line in lines]
  score = [list(map(int, line.split())) for line in lines]

  min = sys.maxsize
  # loop 모든 A,B팀:
  combList = list(combinations(range(n), n//2))
  combLen = len(combList)
  for idx in range(0, combLen//2):
    sumA = sum(combList[idx])
    sumB = sum(combList[combLen - idx - 1])
    # TODO
    #   if min <= abs(sumA - tempSumB):
    #     break

    s = str.format('sumA: {0}, sumB: {1}', sumA, sumB)
    if min > abs(sumA - sumB):
      min = abs(sumA - sumB)
      s = str.format('{0}, min: {1}', s, abs(sumA - sumB))

  print(min)

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()