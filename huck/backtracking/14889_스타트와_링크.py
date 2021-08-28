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
  combList = list(combinations(tup,2))
  for comb in combList:
    res += score[comb[0]][comb[1]] + score[comb[1]][comb[0]]

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

    if min > abs(sumA - sumB):
      min = abs(sumA - sumB)

  print(min)

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()