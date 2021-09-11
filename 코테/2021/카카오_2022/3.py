# 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
# 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
# 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return
import math

ACCUM_TIME = 'accum_time'
LAST_TIMESTAMP = 'last_timestamp'
LAST_DIR = 'last_dir'
IN = 'IN'
OUT = 'OUT'

def solution(fees, records):
  answer = []

  status = {}
  for r in records:
    _, car, _ = r.split()
    status[car] = {ACCUM_TIME: 0, LAST_TIMESTAMP: 0, LAST_DIR: None}

  for r in records:
    timestamp, car, direction = r.split()

    if direction == OUT:
      cur = timestamp
      prev = status[car][LAST_TIMESTAMP]
      prevH, prevM = prev.split(':')
      curH, curM = cur.split(':')
      status[car][ACCUM_TIME] = status[car][ACCUM_TIME] + (60 * (int(curH) - int(prevH))) + (int(curM) - int(prevM))

    status[car][LAST_TIMESTAMP] = timestamp
    status[car][LAST_DIR] = direction

  status = sorted(status.items())

  for car in status:
    if car[1][LAST_DIR] == IN:
      cur = '23:59'
      prev = car[1][LAST_TIMESTAMP]
      prevH, prevM = prev.split(':')
      curH, curM = cur.split(':')
      car[1][ACCUM_TIME] = car[1][ACCUM_TIME] + (60 * (int(curH) - int(prevH))) + (int(curM) - int(prevM))

    remain = car[1][ACCUM_TIME] - fees[0]
    res = fees[1]
    if remain > 0:
      res += (math.ceil(remain / fees[2])) * fees[3]

    answer.append(res)

  return answer


# 기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)
fees = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
result = [14600, 34400, 5000]

fees = [120, 0, 60, 591]
records = ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]
result = [0, 591]

print(solution(fees, records))