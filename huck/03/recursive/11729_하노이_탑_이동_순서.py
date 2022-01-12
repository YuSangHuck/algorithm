import sys
import os

g_res = []

def handleInput():
  suffix = '_input.txt'
  filename, _ = os.path.splitext(__file__)

  sys.stdin = open(filename + suffix, 'r')

def solution(n, a, b):
  global g_res

  if n == 0:
    return

  solution(n-1, a, 6-a-b)
  g_res.append('{0} {1}'.format(a, b))
  solution(n-1, 6-a-b, b)




if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handleInput()

  n = int(sys.stdin.readline().rstrip('\n'))

  solution(n, 1, 3)

  g_res.insert(0, str(len(g_res)))
  print('\n'.join(g_res))