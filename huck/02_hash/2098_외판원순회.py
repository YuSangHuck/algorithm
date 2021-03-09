import sys
import os

ALL_VISITED = 0 # 0
INF = float('inf')
res = INF # 임시 최소값
COST = None # cost 배열
N = 0
cache = None

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

# currentCity(현재도시, 0-base), visited(currentCity 포함 방문한 도시)
def dfs(currentCity, visited):
  global COST
  global ALL_VISITED
  global res
  global N
  global INF

  # 모두 다 방문하면 cache에 있는값 return
  # FIXME 왜 모든도시를 다 방문했는데 j의 값이 0이지? ALL_VISITED 이 맞지않음?
  if visited == ALL_VISITED:
    return cache[currentCity][0] or INF

  if cache[currentCity][visited] is not None:
    return cache[currentCity][visited]

  # cache[currentCity][visited]의 의미는 아래와 같다.
  # visited의 구성을 거쳐서 currentCity에 도착했을 때, 다음도시까지의 최소값
  tmp = INF
  for nextCity in range(N):
    # 아직 방문 안함 && 연결되어있으면
    if (visited >> nextCity) == 0 and COST[currentCity][nextCity] != 0:
      tmp = min(tmp,
                dfs(nextCity, visited | (1 << nextCity)) + COST[currentCity][nextCity]
                )

  cache[currentCity][visited] = tmp


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
  # cache[i][j]는 i에서 j(도시들의 방문 상태값)에서의 최소비용
  cache = [[None] * (1 << N) for _ in range(N)]

  # 0번도시부터 시작했다고 가정.
  dfs(0, 1)

  print(res)



