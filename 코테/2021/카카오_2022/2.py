# 0P0처럼 소수 양 쪽에 0이 있는 경우
# P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
# 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
# P처럼 소수 양쪽에 아무것도 없는 경우
# 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
# 예를 들어, 101은 P가 될 수 없습니다.

# 437674을 3진수로 바꾸면 211 0 2 0 1 0 1 0 11
# 211, 2, 11
# 211은 P0
# 2는 0P0
# 11은 0P

# 211
# 2
# 1
# 1
# 11

def convert(num, base) :
  q = num
  r = 0
  result = ''
  l = []

  while q != 0:
    r = q % base
    l.append(str(r))
    q //= base

  result = ''.join(l)[::-1]
  while result[0] == 0:
    result = result[1:]

  return result


def isPrimeNumber(n):
  prime = [True for i in range(n+1)]
  prime[1] = False

  p = 2
  while(p * p <= n):
    if (prime[p] == True):
      for i in range(p * p, n + 1, p):
        prime[i] = False
    p += 1

  return prime[n]

def solution(n, k):
  answer = 0

  # n을 k진수 변환
  convertedN = str(n)
  if k != 10:
    convertedN = convert(n,k)

  # k를 0기준으로 split -> int[]
  candidateList = convertedN.split('0')
  candidateList = [candidate for candidate in candidateList if candidate != '']

  # loop로 각 item이 소수인지 확인
  for candidate in candidateList:
    if isPrimeNumber(int(candidate)):
      answer = 1 + answer

  return answer

n = 1000000
k = 9
print(solution(n,k))