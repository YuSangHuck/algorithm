import os
import sys

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix

  sys.stdin = open(inputFileName, "r")

def solution():
  # 크로아티아어 리스트
  chroatiaList = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

  count = 0

  word = sys.stdin.readline().rstrip('\n')
  while(len(word)):
    containedChroatia = None
    for chroatia in chroatiaList:
      if word.startswith(chroatia):
        containedChroatia = chroatia
        break

    if containedChroatia:
      word = word[len(containedChroatia):len(word)]
    else:
      word = word[1:len(word)]
    count += 1
  print(count)

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  solution()