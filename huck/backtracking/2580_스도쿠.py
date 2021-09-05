# 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
# 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

import sys
import os

g_board = []
g_isEnd = False
g_candidates = [1,2,3,4,5,6,7,8,9]

def setStdin():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def printBoard():
  global g_board

  print('\n'.join([' '.join(list(map(str, g_board[y]))) for y in range(9)]))



def promising(xPos, yPos):
  global g_board

  # 가로체크
  check = [0] * 10
  for x in range(9):
    if g_board[yPos][x] != 0 and check[g_board[yPos][x]] == 1:
      return False
    else:
      check[g_board[yPos][x]] = 1
  # 세로체크
  check = [0] * 10
  for y in range(9):
    if g_board[y][xPos] != 0 and check[g_board[y][xPos]] == 1:
      return False
    else:
      check[g_board[y][xPos]] = 1
  # subSquare체크
  check = [0] * 10
  for y in range(3*(yPos//3), 3 + 3*(yPos//3)):
    for x in range(3*(xPos//3), 3 + 3*(xPos//3)):
      if g_board[y][x] != 0 and check[g_board[y][x]] == 1:
        return False
      else:
        check[g_board[y][x]] = 1

  return True


# row, col부터 탐색
def dfs(row, col):
  global g_board, g_isEnd, g_candidates

  g_isEnd = 0 not in g_board[8]

  if g_isEnd:
    printBoard()
    return g_isEnd

  # if 0 in g_board[row]:
  #   x = g_board[row].index(0)
  #   for candidate in g_candidates:
  #     g_board[row][x] = candidate

  #     if promising(x, row):
  #       if 0 in g_board[row]:
  #         dfs(row, x + 1)
  #       else:
  #         dfs(row + 1, 0)

  #       if g_isEnd:
  #         return

  # y는 row로 고정, x만 탐색
  for x in range(col, 9):
    # 값이 비어있다면
    if g_board[row][x] == 0:
      # 1~9를 넣어놓고
      for candidate in g_candidates:
        g_board[row][x] = candidate

        # 유효한지 체크
        if promising(x, row):
          # 유효하면 다음 진행
          if 0 in g_board[row]:
            dfs(row, x + 1)
          else:
            dfs(row + 1, 0)

          if g_isEnd:
            return
        else:
          # 유효하지않으면 값 초기화
          g_board[row][x] = 0

def sol():
  global g_board
  g_board = [list(map(int, line.split())) for line in sys.stdin.readlines()]

  dfs(0, 0)



if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()
