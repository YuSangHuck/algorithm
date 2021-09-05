# M개 선택
# M은 중복 가능

# 수열끼리 중복 불가

import os
import sys

g_n = 0
g_m = 0

def setStdin():
  suffix = '_input.txt'

  fn,_ = os.path.splitext(__file__)
  sys.stdin = open(fn+suffix, 'r')

def dfs(depth,l):
  global g_n, g_m

  if depth == g_m:
    print(' '.join(list(map(str, l))))
    return

  for m in range(1, 1 + g_n):
    l.append(m)
    dfs(1 + depth, l)
    l = l[0:depth]

def sol():
  global g_n, g_m
  g_n, g_m = map(int, sys.stdin.readline().split())

  dfs(0, [])

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()
