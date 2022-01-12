# 1. 공집합 S

# - add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
# - remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
# - check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
# - toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
# - all: S를 {1, 2, ..., 20} 으로 바꾼다.
# - empty: S를 공집합으로 바꾼다. 

# ---

import sys
import os

g_result = 0

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix

  sys.stdin = open(inputFileName, "r")

# def parseOperator():
#   `${operator} ${operand}` 의 형태를 분석한다

def solution(expression):
  global g_result
  l = expression.split()
  operator = l[0]
  operand = None
  if operator == 'add' or operator == 'remove' or operator == 'check' or operator == 'toggle':
    operand = int(l[1])

  if operator == 'add':
    g_result |= 1 << operand
  elif operator == 'remove':
    g_result &= ~(1 << operand)
  elif operator == 'check':
    print(1 & (g_result>> operand))
  elif operator == 'toggle':
    g_result ^= 1 << operand
  elif operator == 'all':
    g_result = (1 << 21) - 1
  elif operator == 'empty':
    g_result= 0

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  sys.stdin.__next__()
  for line in sys.stdin:
    solution(line)