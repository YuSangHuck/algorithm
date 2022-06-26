# 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
# x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고
# r1, r2는 10,000보다 작거나 같은 자연수이다.


# 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.


import os
import sys

def handleInput():
  suffix = "_input.txt"
  name, _ = os.path.splitext(__file__)

  sys.stdin = open(name + suffix, 'r')

def solution(line):
  x1, y1, r1, x2, y2, r2 = map(int, line.rstrip('\n').split())

  # r1, r2가 자연수이므로 겹치는 경우 생각 안해도 됨
  squareD = (x1-x2) ** 2 + (y1-y2) ** 2
  squareSum = (r1 + r2) ** 2
  squareSub = (r1 - r2) ** 2

  # 교점개수는 아래와 같다

  if x1 == x2 and y1 == y2 and r1 == r2:
    print(-1)
  elif squareD < squareSum and squareD > squareSub:
    print(2)
  elif squareD > squareSum or squareD < squareSub:
    print(0)
  else:
    print(1)

# d^2 = (r1 + r2)^2 # 접
# d^2 = (r1 - r2)^2 # 접

# d^2 > (r1 + r2)^2 # 안만남
# d^2 < (r1 - r2)^2 # 안만남

# d^2 < (r1 + r2)^2 # 2
# d^2 > (r1 - r2)^2

if __name__ == "__main__":
  if os.getenv("IS_LOCAL"):
    handleInput()

  tc = int(input())

  lines = sys.stdin.readlines()
  for line in lines:
    solution(line)