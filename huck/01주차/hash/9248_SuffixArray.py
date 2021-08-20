# 문자열
# 접미사 배열과 lcp 배열

# Suffix tree를 찾아봐야겠ㄷㅏ..

import sys
import os

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def getStringFromSuffixArrayIndex(string, suffixIndex):
  return string[suffixIndex - 1:]

def getSuffixArrayFromString(string):
  # 1. string의 suffix들을 모아놓은 배열.
  # 2. 1에서 구한 배열을 suffix기준 사전순 정렬
  # suffixAray = [1 + x for x in sorted(range(len(string)), key = lambda i: string[i:])]
  suffixAray = sorted(range(1, len(string) + 1), key = lambda i: getStringFromSuffixArrayIndex(string, i))
  return suffixAray

# O(N^2)
# FIXME O(N)으로 고칠것
def getLCPArrayFromSuffixArray(string, suffixArray):
  lcpArray = []
  for i, _ in enumerate(suffixArray[1:]):
    # getStringFromSuffixArrayIndex(string, i)

    prevSuffix = getStringFromSuffixArrayIndex(string, suffixArray[i])
    curSuffix = getStringFromSuffixArrayIndex(string, suffixArray[1 + i])

    commonLength = 0
    for j, _ in enumerate(prevSuffix):
      if prevSuffix[j] != curSuffix[j]:
        break
      else:
        commonLength += 1



    lcpArray.append(commonLength)

  return lcpArray


def solution(string):
  # 첫째 줄에는 Suffix Array
  # 둘째 줄에는 LCP Array
  # 공백으로 구분하여 출력한다. LCP Array의 첫 값은 항상 'x'이다.
  suffixArray = getSuffixArrayFromString(string)
  lcpArray = getLCPArrayFromSuffixArray(string, suffixArray)
  suffixArrayString = str(suffixArray[0]) + ''.join(map(lambda n: ' ' + str(n), suffixArray[1:]))
  lcpArrayString = 'x ' + str(lcpArray[0]) + ''.join(map(lambda n: ' ' + str(n), lcpArray[1:]))
  print(suffixArrayString)
  print(lcpArrayString)

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  for string in sys.stdin:
    solution(string.rstrip('\n'))


