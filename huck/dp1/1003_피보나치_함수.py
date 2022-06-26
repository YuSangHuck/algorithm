# FIXME 실제 fibo의 값은 필요없어서 제거했는데 왜 틀리지?
import sys
import os


g_dp = [[-1] * 41, [-1] * 41] # max(n) == 40
ZERO = 0
ONE = 1

def setStdin():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def fibo(n):
  global g_dp

  if g_dp[ZERO][n-1] != -1 and g_dp[ZERO][n-2] != -1 and g_dp[ONE][n-1] != -1 and g_dp[ONE][n-2] != -1:
    g_dp[ZERO][n] = g_dp[ZERO][n-1] + g_dp[ZERO][n-2]
    g_dp[ONE][n] = g_dp[ONE][n-1] + g_dp[ONE][n-2]
    return

  if n == 0:
    g_dp[ZERO][0] = 1
    g_dp[ONE][0] = 0
    return
  elif n == 1:
    g_dp[ZERO][1] = 0
    g_dp[ONE][1] = 1
    return
  else:
    fibo(n-1)
    fibo(n-2)
    g_dp[ZERO][n] = g_dp[ZERO][n-1] + g_dp[ZERO][n-2]
    g_dp[ONE][n] = g_dp[ONE][n-1] + g_dp[ONE][n-2]
    return

def sol():
  t = int(sys.stdin.readline())

  for _ in range(t):
    n = int(sys.stdin.readline())
    fibo(n)
    print(f'{g_dp[ZERO][n]} {g_dp[ONE][n]}')

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()