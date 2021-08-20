# 문자열
# 접미사 배열과 lcp 배열

import sys
import os

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution(str1, str2):
  # 첫째 줄에 두 문자열의 최장 공통 부분 문자열의 길이를 출력한다.
  # 둘째 줄에 해당 부분 문자열을 출력한다.


if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  for str1 in sys.stdin:
    str2 = sys.stdin.__next__() # 문자열길이 스킵
    solution(str1, str2)
