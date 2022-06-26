# 정박장에서 손님
# 배는 정박장 왔다갔다
# 배는 최대 M(1 ~ 10000)명 태울 수 있다
# 정박장 이동할때는 t(1 ~ 10000)의 시간 소모
# 정박장 도착시 손님모두내려주고
# 정박장에 대기중인 손님이 있다면 오래기다린 순으로 태워줌
# 정박장에 대기중인 손님이 없다면 손님을 기다림
# 반대쪽에 먼저 오면 반대쪽으로 이동

# 첫줄에 M,t,N 입력
# 그 이후 N줄만큼 (정박장 도착시각, 정박장위치) 가 주어짐

# 이때, 입력받은 순서대로 도착 시각 출력

# 입력 순서대로 오래기다린다고 가정해보자


import sys
import os
import heapq

class Passenger:
  def __init__(self, idx, readyAt, arrivedAt):
    self.idx = idx
    self.readyAt = readyAt
    self.arrivedAt = arrivedAt
  def __lt__(self, other):
    return self.idx < other.idx

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution():
  max = 10000
  isLeftSide = True
  lq = []
  rq = []
  onBoarding = []
  done = []
  qs = {}
  qs[isLeftSide] = lq
  qs[not isLeftSide] = rq

  M, t, N = map(int, input().split())

  lines = sys.stdin.readlines()

  # (우선순위, 아이템)
  # 우선순위는 대기시작시각
  # 아이템은 Passenger(idx, 대기시작시각, 도착시각)
  for i, line in enumerate(lines):
    arrivedAt, side = line.rstrip('\n').split()
    if side == 'left':
      heapq.heappush(lq, (int(arrivedAt), Passenger(i, int(arrivedAt), None)))
    else:
      heapq.heappush(rq, (int(arrivedAt), Passenger(i, int(arrivedAt), None)))

  # 대기손님 없을때까지 반복
  timestamp = 0
  while not(len(lq) == 0 and len(rq) == 0):
    # 정박장 도착시 손님모두내려주고
    for i, _ in enumerate(onBoarding):
      onBoarding[i].arrivedAt = timestamp
      heapq.heappush(done, (onBoarding[i].idx, onBoarding[i]))
    onBoarding.clear()

    curFront = qs[isLeftSide][0] if not len(qs[isLeftSide]) == 0 else None
    otherFront = qs[not isLeftSide][0] if not len(qs[not isLeftSide]) == 0 else None

    # 1. 이쪽에 있거나
    if (curFront and curFront[1].readyAt <= timestamp):
      # 태울수 있는만큼 태우고
      count = 0
      while count < M:
        if len(qs[isLeftSide]) == 0 or qs[isLeftSide][0][1].readyAt > timestamp:
          break
        onBoarding.append(heapq.heappop(qs[isLeftSide])[1])
        count += 1

      isLeftSide = not isLeftSide
    # 2. 저쪽에 있거나
    elif (otherFront and otherFront[1].readyAt <= timestamp):
      isLeftSide = not isLeftSide
    # 3. 양쪽 다 없거나
    # (curFront and curFront[1].readyAt > timestamp) and (otherFront and otherFront[1].readyAt > timestamp):
    else:
      # cur과 other 비교해서 timestamp 셋팅
      if curFront and otherFront:
        # 둘중에 빠른놈
        if curFront[1].readyAt > otherFront[1].readyAt:
          timestamp = otherFront[1].readyAt
        else:
          timestamp = curFront[1].readyAt - t
      elif curFront:
        timestamp = curFront[1].readyAt - t
      elif otherFront:
        timestamp = otherFront[1].readyAt

    timestamp += t

  for i, _ in enumerate(onBoarding):
    onBoarding[i].arrivedAt = timestamp
    heapq.heappush(done, (onBoarding[i].idx, onBoarding[i]))
  onBoarding.clear()

  res = []
  while len(done) != 0:
    res.append(str(heapq.heappop(done)[1].arrivedAt) + '\n')
  res[-1] = res[-1][:-1]
  print(''.join(res))

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()
