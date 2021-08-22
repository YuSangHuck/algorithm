import sys
import os

def handleInput():
  suffix = '_input.txt'
  fileName, _ = os.path.splitext(__file__)
  inputFileName = fileName + suffix

  sys.stdin = open(inputFileName, 'r')

def isGroupWord(word):
  m = {}
  # print(word)
  prev = None
  for char in word:
    if m.get(char) != None and char != prev:
      return False

    m[char] = True
    prev = char

  return True


def solution():
  _ = input()
  wordList = sys.stdin.readlines()

  count = 0
  for word in wordList:
    if isGroupWord(word.rstrip('\n')):
      count += 1

  print(count)


if __name__ == "__main__":
  if os.getenv("IS_LOCAL"):
    handleInput()

  solution()