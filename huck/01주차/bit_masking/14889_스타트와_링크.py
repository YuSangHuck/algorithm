# N은 짝수, N/2로 나눠서 축구
# Sij Sji, 능력치는 sum(Sij+Sji)
# 능력치 차이의 최소는?

import sys
import os


def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution(expression):

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  input(line)
  for line in sys.stdin:
    solution(line)