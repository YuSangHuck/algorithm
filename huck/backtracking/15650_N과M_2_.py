import os
import sys

g_n = 0
g_m = 0

def setStdin():
  suffix = '_input.txt'
  fn,_ = os.path.splitext(__file__)
  sys.stdin=open(fn+suffix, 'r')

def dfs(depth, l):
  global g_n, g_m

  if depth == g_m:
    print(' '.join(list(map(str, l))))
    return

  min = 1
  if len(l) != 0:
    min = l[-1]
  for m in range(min, 1 + g_n):
    if m not in l:
      l.append(m)
      dfs(1 + depth, l)
      l.remove(m)


def sol():
  global g_n, g_m

  g_n, g_m = map(int, sys.stdin.readline().split())

  dfs(0, [])

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  sol()