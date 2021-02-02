import sys
import os

ALL_VISITED = 0 # 0
res = float('inf') # 임시 최소값
COST = None # cost 배열
N = 0

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

# 시작도시(0-base), 현재방문한도시(0-base), 현재방문한도시까지의 임시sum
def dfs(startCity, currentCity, tmpSumOfCost, visited):
  global COST
  global ALL_VISITED
  global res
  global N

  # 1. visited 체크
  visited = visited | 1 << currentCity

  # 2. 전부 다 돌았는지 체크 후, 이 경로와 기존의 최소값중 더 작은값으로 업데이트
  if visited == ALL_VISITED:
    res = min(res, tmpSumOfCost + COST[currentCity][startCity])
    return

  # 3. 다 안돌았으면 나머지 도시도 순회
  # visited에서 찾음
  # 0번비트 ~ N-1번 비트 사이에서 0인놈들 반복: # nextCity라고 하자
  for nextCity in range(N):
    if (COST[currentCity][nextCity] != 0) and (1 & (visited >> nextCity) == 0):
      dfs(startCity, nextCity, tmpSumOfCost + COST[currentCity][nextCity], visited)


def solution(expression):
  print('solution')

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  lines = sys.stdin.readlines()

  # N set
  N = int(lines.pop(0).rstrip('\n'))
  # COST set
  COST = [list(map(int, line.split())) for line in lines]
  ALL_VISITED = (1 << N) - 1

  for startCity in range(N):
    dfs(startCity, startCity, 0, 0)

  print(res)



