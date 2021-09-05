import os
import sys

g_n = 0
g_m = 0

def setStdin():
  suffix = '_input.txt'
  fn,_ = os.path.splitext(__file__)
  sys.stdin = open(fn+suffix, 'r')

def dfs(depth, res):
  global g_m

  if depth == g_m:
    print(' '.join(list(map(str, res))))
    return

  for m in range(1, 1 + g_n):
    if m not in res:
      res.append(m)
      dfs(depth + 1, res)
      res.remove(m)

def sol():
  global g_n, g_m
  # 1 ~ n 중
  # m개 뽑아라. 중복없이
  g_n, g_m = map(int, sys.stdin.readline().split())

  dfs(0, [])

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()
