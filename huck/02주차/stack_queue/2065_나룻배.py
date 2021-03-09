import sys
import os
from operator import attrgetter

class Passenger:
  def __init__(self, idx, readyAt, arriveAt = None):
    self.idx = idx
    self.readyAt = readyAt
    self.arriveAt = arriveAt
  def __repr__(self):
    return 'idx: {}, readyAt: {}, arriveAt: {}'.format(self.idx, self.readyAt, self.arriveAt)

class Queue:
  def __init__(self):
    self.__data = []

  def size(self):
    return len(self.__data)

  def isEmpty(self):
    return False if self.size() != 0 else True

  def front(self):
    if (self.isEmpty()):
      return None
    return self.__data[0]

  def rear(self):
    if (self.isEmpty()):
      return None
    return self.__data[-1]

  def enqueue(self, data):
    self.__data.append(data)

  def dequeue(self):
    if (self.isEmpty()):
      return None
    val = self.__data[0]
    del self.__data[0]
    return val

  def sort(self, attrSortBy, isDescending = False):
    self.__data = sorted(self.__data, key=attrgetter(attrSortBy), reverse=isDescending)

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution():
  lPassengers = Queue()
  rPassengers = Queue()
  onBoarding = Queue()
  done = Queue()

  M, t, N = map(int, input().split())

  lines = sys.stdin.readlines()
  for idx, line in enumerate(lines):
    readyAt, readyFrom = line.rstrip('\n').split()
    if (readyFrom == 'left'):
      lPassengers.enqueue(Passenger(idx, int(readyAt)))
    else:
      rPassengers.enqueue(Passenger(idx, int(readyAt)))

  lPassengers.sort('readyAt')
  rPassengers.sort('readyAt')

  timestamp = 0
  isLeft = True
  boardingCount = 0
  all = { isLeft: lPassengers, not isLeft: rPassengers }
  curPassengers = all[isLeft]
  # 대기하는사람이 없을때까지 반복
  while (not (lPassengers.isEmpty() and rPassengers.isEmpty())):
    # 정박장에 도착하면

    # 1. 그 정박장으로 가고자 하는 사람들을 우선 모두 내려준다
    if (not onBoarding.isEmpty()):
      boardingCount = 0
      while (not onBoarding.isEmpty()):
        p = onBoarding.dequeue()
        p.arriveAt = timestamp
        done.enqueue(p)

    # 2. 승선 가능한 사람 있다면
    if (not curPassengers.isEmpty()):
      # 가능한 다 태워
      while (curPassengers.front() and curPassengers.front().readyAt <= timestamp and boardingCount < M):
        onBoarding.enqueue(curPassengers.dequeue())
        boardingCount += 1

    # 3-1. 한명이라도 탔을때
    if (boardingCount > 0):
      # 반대쪽으로
      isLeft = not isLeft
      timestamp += t
      curPassengers = all[isLeft]
    # 3-2. 아무도 안탔을때
    else:
      oppsitePassengers = all[not isLeft]
      # 반대쪽에 있으면 이동
      if (not oppsitePassengers.isEmpty() and oppsitePassengers.front().readyAt <= timestamp):
        isLeft = not isLeft
        timestamp += t
        curPassengers = all[isLeft]
      # 반대쪽에 없으면 대기
      else:
        timestamp += t

  while (not onBoarding.isEmpty()):
    p = onBoarding.dequeue()
    p.arriveAt = timestamp
    done.enqueue(p)

  done.sort('idx')
  while (not done.isEmpty()):
    p = done.dequeue()
    print(p.arriveAt)

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()
