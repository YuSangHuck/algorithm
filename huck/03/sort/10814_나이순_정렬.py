import os
import sys
from operator import itemgetter

def handlerInput():
  suffix = '_input.txt'
  fn, _ = os.path.splitext(__file__)

  sys.stdin = open(fn + suffix, 'r')

def solution():
  _ = int(sys.stdin.readline())
  lines = sys.stdin.readlines()

  people = []
  for line in lines:
    age, name = line.rstrip('\n').split()
    people.append((int(age), name))
  # sort는 기본적으로 stable sort이다
  people.sort(key=itemgetter(0))

  print('\n'.join(map(lambda person:
      str.format('{0} {1}', person[0], person[1]),
    people)))

if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    handlerInput()

  solution()
