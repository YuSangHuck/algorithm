import sys
import os

class Stack:
  def __init__(self):
    self.__data = []

  # push X: 정수 X를 스택에 넣는 연산이다.
  def push(self, x):
    self.__data.append(x)
    return

  # pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  def pop(self):
    if (self.size() == 0):
      return -1
    return self.__data.pop()

  # size: 스택에 들어있는 정수의 개수를 출력한다.
  def size(self):
    return len(self.__data)

  # empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
  def empty(self):
    return 0 if self.size() else 1

  # top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  def top(self):
    return self.__data[-1]

  def clear(self):
    self.__data.clear()
    return


def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  s = Stack()

  lines = sys.stdin.readlines()
  lines = lines[1:len(lines)]
  for line in lines:
    l = line.rstrip('\n').split()

    operator = l[0]
    operand = 0
    if len(l) > 1:
      operand = l[1]

    if operator == "push":
      s.push(operand)
    elif operator == "pop":
      print(s.pop())
    elif operator == "size":
      print(s.size())
    elif operator == "empty":
      print(s.empty())
    else:
      print(s.top())
