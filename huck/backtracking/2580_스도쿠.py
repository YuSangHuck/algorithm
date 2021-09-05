# 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
# 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

import sys
import os

g_board = []
g_zeros = []
g_isEnd = False

def setStdin():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def printBoard():
  global g_board

  print('\n'.join([' '.join(list(map(str, g_board[y]))) for y in range(9)]))



def getCandidates(x, y):
  global g_board

  candidates = [1,2,3,4,5,6,7,8,9]

  for idx in range(9):
    # 가로
    if g_board[idx][x] in candidates:
      candidates.remove(g_board[idx][x])
    # 세로
    if g_board[y][idx] in candidates:
      candidates.remove(g_board[y][idx])

  offsetY = y // 3
  offsetX = x // 3
  for j in range(3 * offsetY, 3 * (1 + offsetY)):
    for i in range(3 * offsetX, 3 * (1 + offsetX)):
      if g_board[j][i] in candidates:
        candidates.remove(g_board[j][i])

  return candidates


# row, col부터 탐색
def dfs(idx):
  global g_board, g_zeros, g_isEnd

  if g_isEnd:
    return

  if idx == len(g_zeros):
    printBoard()
    g_isEnd = True
    return

  (x, y) = g_zeros[idx]
  candidates = getCandidates(x,y)
  for candidate in candidates:
    g_board[y][x] = candidate
    dfs(idx + 1)
    g_board[y][x] = 0

def sol():
  global g_board, g_zeros
  g_board = [list(map(int, line.split())) for line in sys.stdin.readlines()]
  g_zeros = [(x,y) for y in range(9) for x in range(9) if g_board[y][x] == 0]

  dfs(0)



if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()

# case0 (idx)
# elapse: 0.001680612564086914 // all zero

# cas1 (row, col)
# elapse: 0.00022721290588378906
# elapse: 0.016598939895629883 // all zero

# case2 (col)
# elapse: 0.0002460479736328125
# elapse: 0.41098690032958984

# case3 ()
# elapse: 0.0003452301025390625