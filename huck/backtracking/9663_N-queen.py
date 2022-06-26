import os
import sys

g_cnt = 0
g_n = 0
g_visited = []
g_visited2 = [] #/
g_visited3 = [] #\

def handleInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def recur(cur=0):
  global g_n, g_visited, g_visited2, g_visited3, g_cnt

  if cur == g_n:
    g_cnt += 1
    return

  for i in range(g_n):
    if g_visited[i] or g_visited2[cur + i] or g_visited3[cur + g_n - i]:
      continue

    g_visited[i] = True
    g_visited2[cur + i] = True
    g_visited3[cur + g_n - i] = True
    recur(cur + 1)
    g_visited[i] = False
    g_visited2[cur + i] = False
    g_visited3[cur + g_n - i] = False

def sol():
  global g_n, g_cnt, g_visited, g_visited2, g_visited3

  g_n = int(sys.stdin.readline())
  g_visited = [False] * g_n
  g_visited2 = [False] * 3 * g_n #/
  g_visited3 = [False] * 3 * g_n #\

  recur()
  print(g_cnt)

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  sol()