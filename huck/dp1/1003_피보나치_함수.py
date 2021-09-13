import sys
import os


g_dp = [-1] * 41 # max(n) == 40
g_dpZero = [-1] * 41 # max(n) == 40
g_dpOne = [-1] * 41 # max(n) == 40

def setStdin():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def fibo(n):
  global g_dp

  if g_dp[n-1] != -1 and g_dp[n-2] != -1:
    g_dp[n] = g_dp[n-1] + g_dp[n-2]
    g_dpZero[n] = g_dpZero[n-1] + g_dpZero[n-2]
    g_dpOne[n] = g_dpOne[n-1] + g_dpOne[n-2]
    return g_dp[n]

  if n == 0:
    g_dp[0] = 0
    g_dpZero[0] = 1
    g_dpOne[0] = 0
    return 0
  elif n == 1:
    g_dp[1] = 1
    g_dpZero[1] = 0
    g_dpOne[1] = 1
    return 1
  else:
    g_dp[n-1] = fibo(n-1)
    g_dp[n-2] = fibo(n-2)
    g_dpZero[n] = g_dpZero[n-1] + g_dpZero[n-2]
    g_dpOne[n] = g_dpOne[n-1] + g_dpOne[n-2]
    return g_dp[n-1] + g_dp[n-2]

def sol():
  t = int(sys.stdin.readline())

  for _ in range(t):
    n = int(sys.stdin.readline())
    fibo(n)
    print(f'{g_dpZero[n]} {g_dpOne[n]}')

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()