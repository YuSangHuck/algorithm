# FIXME 조합인데 dfs로 중복된 케이스 제외시켜야 함
# 일단은 itertool로 풀거

# N개 수열
# N-1개 연산자

# 계산은 앞에서부터
# 나눗셈은 몫만, 음수 / 양수는 C++ 기준(양수 몫 취하고, 몫을 음수로)
# a / b
# a > 0 => a // b
# a < 0 => -(-a // b)

import sys
import os
from itertools import combinations, permutations

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

def sol():
  inputs = sys.stdin.readlines()
  nCount = int(inputs[0])
  operandList = list(map(int, inputs[1].rstrip('\n').split()))
  operatorList = []
  i = 0
  for operatorCount in map(int, inputs[2].rstrip('\n').split()):
    for _ in range(operatorCount):
      operatorList.append(i)
    i += 1

  # print(operatorList)

  min = 10**9
  max = -10**9
  # FIXME 중복된 경우 있음
  for comb in permutations(operatorList, len(operatorList)):
    res = operandList[0]
    for idx, operand in enumerate(comb):

      if operand == 0: # +
        res = res + operandList[1 + idx]

      elif operand == 1: # -
        res = res - operandList[1 + idx]

      elif operand == 2: # *
        res = res * operandList[1 + idx]

      else: # //
        if res >= 0:
          res = res // operandList[1 + idx]
        else:
          # a < 0 => -(-a // b)
          res = -(-res // operandList[1 + idx])

    if res < min:
      min = res
    if res > max:
      max = res

  print(f'{max}\n{min}')


if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()