import os, sys

# a,b,c => -50 ~ 50 => 0 ~ 100
g_dp = [[[None] * 101] * 101] * 101
A, B, C = 0, 1, 2

def setStdin():
  suffix = '_input.txt'
  fn,_ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def sol():
  while(1):
    a,b,c = map(int, sys.stdin.readline().split())
    if a == -1 and b == -1 and c == -1:
      break
    print(f'w({a}, {b}, {c}) = {w(a,b,c)}')

def w(a,b,c):

  if a <= 0 or b <= 0 or c <= 0:
    return 1
  elif a > 20 or b > 20 or c > 20:
    return w(20, 20, 20)
  elif a < b and b < c:
    if g_dp[50 + a][50 + b][50 + c-1] != None and g_dp[50 + a][50 + b-1][50 + c-1] != None and g_dp[50 + a][50 + b-1][50 + c] != None:
      return g_dp[50 + a][50 + b][50 + c-1] + g_dp[50 + a][50 + b-1][50 + c-1] + g_dp[50 + a][50 + b-1][50 + c]
    else:
      return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
  else:
    if g_dp[50 + a-1][50 + b][50 + c] != None and \
      g_dp[50 + a-1][50 + b-1][50 + c] != None and \
      g_dp[50 + a-1][50 + b, ][50 + c-1] != None and \
      g_dp[50 + a-1][50 + b-1][50 + c-1] != None:
      return g_dp[50 + a-1][50 + b][50 + c] + g_dp[50 + a-1][50 + b-1][50 + c] + g_dp[50 + a-1][50 + b, ][50 + c-1] + g_dp[50 + a-1][50 + b-1][50 + c-1]

    else:
      return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()