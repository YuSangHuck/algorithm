import os
import sys

global dp

def handleInput():
  suffix = '_input.txt'
  name, ext = os.path.splitext(__file__)
  inputFileName = name + suffix

  sys.stdin = open(inputFileName, 'r')

def solution(n):
  global dp
  for i in range(5, n):
    num = 1 + i # 1 ~ n

    dp[num] = sys.maxsize
    j =1
    while (j <= num - j):
      if (dp[j] != -1 and dp[num - j] != -1):
        sum = dp[j] + dp[num-j]
        if dp[num] > sum:
          dp[num] = sum
      j += 1

  return dp[n]

def init():
  global dp
  dp = [-1, -1, -1, 1, -1, 1] + [-1] * 4995

if __name__ == '__main__':
  # select stdin
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  # handle input
  tc = int(input())
  for _ in range(tc):
    n = int(input()) # <= 500,000
    init()

    # solution
    print(solution(n))
