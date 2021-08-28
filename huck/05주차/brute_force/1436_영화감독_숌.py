import os
import sys

def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)
  sys.stdin = open(filename + suffix)

def solution(n):
  hitCount = 0
  i = 665

  while hitCount != n:
    i += 1
    if str(i).find('666') != -1:
      hitCount += 1

  return i

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  n = int(sys.stdin.readline())
  print(solution(n))

  # for n in range(1, 100):
  #   print(solution(n))

