# FIXME 빡세네..

# 어피치가 유리
# 어피치 후 라이언
# apc[k]와 lion[k]가 동일하면 apc[k]가 k점 획득
# apc[k] == lion[k] == 0, then 둘 다 0점

# sum(lion) > sum(apc)인 경우에만 lion 우승
# 그 외는 어피치 우승

# 라이언이 쏠 차례

# 우승할 수 없는 경우(무조건 지거나 비기는 경우)는 [-1]을 return
# 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 10점부터 0점까지 순서대로 정수 배열에 담아 return
# 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
# 가장 낮은 점수를 맞힌 개수가 같을 경우 계속해서 그다음으로 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.

def iToScore(i):
  return 10 - i

def solution(n, info):
  answer = []
  return answer


n = 5
info = [2,1,1,1,0,0,0,0,0,0,0]
result = [0,2,2,0,1,0,0,0,0,0,0]


solution(n, info)