import os
import sys

CHESS_SIZE = 8
CHESS_TYPES = ['BWBWBWBW', 'WBWBWBWB']

def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)
  sys.stdin = open(filename + suffix, 'r')

def getDiffCountStrings(str1, str2):
  count = 0
  for i in range(len(str1)):
    if str1[i] != str2[i]:
      count += 1
  return count

def solution():
  res = sys.maxsize
  N, M = map(int, sys.stdin.readline().rstrip('\n').split())
  lines = []
  for n in range(N):
    lines.append(sys.stdin.readline().rstrip('\n'))

  # print(N, M)
  # print(lines)

  for mStart in range(0, N - CHESS_SIZE + 1):
    for nStart in range(0, M - CHESS_SIZE + 1):
      # mStart는 lines의 sub
      # nstart는 lines[mStart]의 sub
      # print(nStart, mStart)
      # CHESS_SIZE * CHESS_SIZE 체스판 출력
      # for n in range(CHESS_SIZE):
        # print(lines[n + mStart][nStart:CHESS_SIZE+nStart])

      # case1
      t = 0
      temp = 0
      for n in range(CHESS_SIZE):
        temp += getDiffCountStrings(lines[n + mStart][nStart:CHESS_SIZE+nStart], CHESS_TYPES[t])
        if res <= temp:
          break
        t = 1^t

      if res > temp:
        res = temp

      # case2
      t = 1
      temp = 0
      for n in range(CHESS_SIZE):
        temp += getDiffCountStrings(lines[n + mStart][nStart:CHESS_SIZE+nStart], CHESS_TYPES[t])
        if res <= temp:
          break
        t = 1^t

      if res > temp:
        res = temp

  return res

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  print(solution())
