# N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제

# input
# 첫째 줄에 N이 주어진다. (1 ≤ N < 15)

# output
# N개를 서로 공격할 수 없게 놓는 경우의 수

import sys
import os
import copy

g_res = 0
g_n = 0

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def showMap(m, remainQ):
  global g_n
  print(f'remainQueen: {remainQ}')
  for i in range(g_n):
    print(m[i * g_n:i * g_n + g_n])
  print('\n\n')

# FIXME canBeInsertPos 업데이트하는게 오래걸릴거같은데..
# FIXME len(canBeInsertPos) 대신 그냥 n번 돌면서 체크하는게 낫지않을까?
# canBeInsertPos: 놓을수 있는 pos. len(canBeInsertPos) == 0 이면 끝
#  일차원 배열
#  초기값은 0부터 n*n - 1
# remainQueenNum: 남은 queen 수
#  정수
#  초기값은 n
# mapOfPos: 체스판 상태
#  일차원 배열
#  초기값은 -1
def insertQueen(canBeInsertPos, remainQueenNum, mapOfPos):
  global g_res, g_n
  # print(canBeInsertPos)
  # print(remainQueenNum)
  # print(mapOfPos)
  # showMap(mapOfPos, remainQueenNum)

  # 남은 queen이 없다면
  if remainQueenNum == 0:
    # 결과값 +1
    g_res += 1
    return

  # 더이상 놓을 수 있는 위치가 없다면
  if len(canBeInsertPos) == 0:
    # 더 놓는게 의미가 없음
    # FIXME 이걸 플래그로 써야될거같음
    # return -1
    return

  for selectedPos in canBeInsertPos:
    copiedCanBeInsertPos = copy.deepcopy(canBeInsertPos)
    copiedmapOfPos = copy.deepcopy(mapOfPos)
    # 다음 위치는 selectedPos
    print(f'selectedPos: {selectedPos}')
    # 이 값 기반으로 remainQueenNum 업데이트
    remainQueenNum -= 1

    # 이 값 기반으로 mapOfPos 업데이트
    copiedmapOfPos[selectedPos] = -1

    # 이 값 기반으로 copiedCanBeInsertPos 업데이트

    # 가로
    # z = []
    garo = selectedPos // g_n
    for garoIdx in range(g_n * garo, g_n * garo + g_n, 1):
      # print(garoIdx)
      if copiedCanBeInsertPos.count(garoIdx):
        # z.append(garoIdx)
        copiedCanBeInsertPos.remove(garoIdx)
        copiedmapOfPos[garoIdx] = -1
    # print(z)

    # 세로
    # z = []
    sero = selectedPos % g_n
    for seroIdx in range(0 + sero, g_n * g_n, g_n):
      # print(seroIdx)
      if copiedCanBeInsertPos.count(seroIdx):
        # z.append(seroIdx)
        copiedCanBeInsertPos.remove(seroIdx)
        copiedmapOfPos[seroIdx] = -1
    # print(z)
    # 대각
    remainLeft = selectedPos % g_n
    remainRight = g_n - remainLeft - 1
    remainUp = selectedPos // g_n
    remainDown = g_n - remainUp - 1

    # 좌측은 left,up ~ right,down
    # 좌측은 step이 g_n + 1
    # print('leftAsideIdx')
    # z = []
    for leftAsideIdx in range(
        selectedPos - min(remainLeft, remainUp) * (g_n + 1),
        selectedPos + min(remainRight, remainDown) * (g_n + 1) + 1,
        g_n + 1
      ):
      # print(leftAsideIdx)
      if copiedCanBeInsertPos.count(leftAsideIdx):
        # z.append(leftAsideIdx)
        copiedCanBeInsertPos.remove(leftAsideIdx)
        copiedmapOfPos[leftAsideIdx] = -1
    # print(z)


    # 우측은 right,up ~ left,down
    # 우측은 step이 g_n - 1
    # print('rightAsideIdx')
    # z = []
    for rightAsideIdx in range(
        selectedPos - min(remainRight, remainUp) * (g_n - 1),
        selectedPos + min(remainLeft, remainDown) * (g_n - 1) + 1,
        g_n - 1
      ):
      # print(rightAsideIdx)
      if copiedCanBeInsertPos.count(rightAsideIdx):
        # z.append(rightAsideIdx)
        copiedCanBeInsertPos.remove(rightAsideIdx)
        copiedmapOfPos[rightAsideIdx] = -1
    # print(z)

    showMap(copiedmapOfPos, remainQueenNum)
    insertQueen(copiedCanBeInsertPos, remainQueenNum, copiedmapOfPos)

    remainQueenNum += 1
    # if insertQueen(copiedCanBeInsertPos, remainQueenNum, mapOfPos) == -1:
    #   return





def sol():
  global g_n
  g_n = int(sys.stdin.readline())
  canBeInsertPos = []
  mapOfPos = []
  for i in range(g_n * g_n):
    canBeInsertPos.append(i)
    mapOfPos.append(i)
  remainQueenNum = g_n
  # mapOfPos = [-1] * (g_n * g_n)
  insertQueen(canBeInsertPos, remainQueenNum, mapOfPos)

  print(g_res)



if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()
