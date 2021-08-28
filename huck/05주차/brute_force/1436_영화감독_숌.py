import os
import sys

def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)
  sys.stdin = open(filename + suffix)

def solution(n):
  return ((n-1) * 1000) + 666

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  n = int(sys.stdin.readline())
  print(solution(n))
