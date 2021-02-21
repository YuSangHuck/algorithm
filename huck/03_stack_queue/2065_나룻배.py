import sys
import os
from queue import PriorityQueue

# 1. range
# - M 나룻배 정원(10000)
# - t 정박장 편도 시간(10000)
# - N 손님 수(10000)

# 2. input
# - 첫째줄에 M, t, N
# - 다음 N개줄에 도착시간과 정박장위치

# 3. output
# - 입력받은 순서대로 각 손님이 목적지에 도착하는 시간
# 손님 {
#   idx
#   readyAt
#   arriveAt
# }

# 4. spec
# - 2초
# - 128MB

class Passenger:
  def __init__(self, idx, readyAt, readyFrom, arriveAt = None):
    self.idx = idx
    self.readyAt = readyAt
    self.readyFrom = readyFrom
    # self.to = None
    self.arriveAt = arriveAt
  def __lt__(self, other):
    if self.arriveAt is None:
      return self.readyAt < other.readyAt
    else:
      return self.idx < other.idx
  def __repr__(self):
    return 'idx: {}, readAt: {}, arriveAt: {}'.format(self.idx, self.readyAt, self.arriveAt)

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  LEFT = 'left'
  RIGHT = 'right'

  passengers = PriorityQueue(maxsize=10000)
  onBoarding = PriorityQueue(maxsize=10000)
  done = PriorityQueue(maxsize=10000)

  M, t, N = map(int, input().split())

  lines = sys.stdin.readlines()
  for idx, line in enumerate(lines):
    readyAt, position = line.rstrip('\n').split()
    passengers.put(Passenger(idx, int(readyAt), position))

  # - M 나룻배 정원(10000)
  # - t 정박장 편도 시간(10000)
  # 태우고 반대쪽으로
  timestamp = 0
  currentPos = LEFT
  while (not passengers.empty()):
    # 그 정박장으로 가고자 하는 사람들을 우선 모두 내려준다
    while (not onBoarding.empty()):
      p = onBoarding.get()
      p.arriveAt = timestamp
      done.put(p)

    boardingCount = 0
    while(not passengers.empty()):
      p = passengers.get()
      # 기다리는 사람이 있다면, (from == currentPos) && (readyAt <= timestamp)
      if (p.readyFrom == currentPos and p.readyAt <= timestamp):
        # 그 정박장에서 기다리고 있던 손님들을 배에 태울 수 있는 데까지 태운다
        if (boardingCount < M):
          onBoarding.put(p)
          boardingCount += 1
        # 손님을 다 태운 후에는 반대쪽 정박장
        else:
          passengers.put(p)
          timestamp += t
          currentPos = LEFT if currentPos == RIGHT else RIGHT
          break
      # 없다면
      else:
        # 반대쪽 정박장 사람이 있다면
        if (p.readyAt <= timestamp):
          # 반대쪽으로이동
          passengers.put(p)
          timestamp += t
          currentPos = LEFT if currentPos == RIGHT else RIGHT
          break
        # 반대쪽 정박장 사람이 없다면
        # elif (p.readyFrom == currentPos):
        else:
          # 대기
          passengers.put(p)
          timestamp += t

  while (not done.empty()):
    p = done.get()
    print(p.arriveAt)

