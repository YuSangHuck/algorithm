# N개 수열
# N-1개 연산자

# 계산은 앞에서부터
# 나눗셈은 몫만, 음수 / 양수는 C++ 기준(양수 몫 취하고, 몫을 음수로)
# a / b
# a > 0 => a // b
# a < 0 => -(-a // b)

import sys
import os

g_max = -sys.maxsize
g_min = sys.maxsize
g_nCount = 0
g_operandList = []
g_operatorList = []

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

# NOTE dfs depth별 저장해야되는 상태값은 아래와 같다.
# - min,max 업데이트 시점 확인을 위해 지금까지 사용된 연산자갯수: usedCount
# - 이전까지의 결과값: res
# - 이전까지 사용한 연산자 리스트: operatorList
def dfs(usedCount, res, operatorList):
  global g_max, g_min, g_nCount, g_operandList, g_operatorList

  # 인자 usedCount가 처음 입려받은 nCount와 동일하면
  if usedCount == g_nCount - 1:
    # max,min 업데이트
    g_max = max(g_max, res)
    g_min = min(g_min, res)

  for i in range(4): # 0,1,2,3
    if operatorList[i]:
      operatorList[i] -= 1
      usedCount += 1
      n = g_operandList[usedCount]

      if i == 0: # +
        dfs(usedCount, res + n, operatorList)
      elif i == 1: # -
        dfs(usedCount, res - n, operatorList)
      elif i == 2: # *
        dfs(usedCount, res * n, operatorList)
      else:
        if res >= 0:
          dfs(usedCount, res // n, operatorList)
        else:
          dfs(usedCount, -(abs(res) // n), operatorList)

      operatorList[i] += 1
      usedCount -= 1



def sol():
  global g_nCount, g_operandList, g_operatorList, g_max, g_min

  g_nCount = int(sys.stdin.readline())
  g_operandList = list(map(int, sys.stdin.readline().split()))
  g_operatorList = list(map(int, sys.stdin.readline().split()))

  dfs(0, g_operandList[0], g_operatorList)

  print(f'{g_max}\n{g_min}')



if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()