import os, sys

g_m = {
  'A': 0, 'B': 1, 'C': 2, 'D': 3, 'E': 4, 'F': 5, 'G': 6, 'H': 7, 'I': 8, 'J': 9, 'K': 10, 'L': 11, 'M': 12, 'N': 13, 'O': 14, 'P': 15, 'Q': 16, 'R': 17, 'S': 18, 'T': 19, 'U': 20, 'V': 21, 'W': 22, 'X': 23, 'Y': 24, 'Z': 25,
  0: 'A', 1: 'B', 2: 'C', 3: 'D', 4: 'E', 5: 'F', 6: 'G', 7: 'H', 8: 'I', 9: 'J', 10: 'K', 11: 'L', 12: 'M', 13: 'N', 14: 'O', 15: 'P', 16: 'Q', 17: 'R', 18: 'S', 19: 'T', 20: 'U', 21: 'V', 22: 'W', 23: 'X', 24: 'Y', 25: 'Z',
}

def setStdin():
  suffix = '_input.txt'
  fn,_ = os.path.splitext(__file__)
  sys.stdin = open(fn + suffix, 'r')

def divide(str):
  halfPos = int(len(str)/2)
  return [str[0:halfPos], str[halfPos:]]

def rotate(str):
  rotationValue = 0
  candiForRotateList = []
  for c in str:
    candiForRotateList.append(c)
    rotationValue += g_m[c]

  rotatedList = []
  for c in candiForRotateList:
    rotatedList.append(g_m[(g_m[c] + rotationValue) % 26])

  return ''.join(rotatedList)

def merge(strList):
  resList = []
  for i,_ in enumerate(strList[1]):
    # c를 rotate
    # g_m[(g_m[c] + rotationValue) % 26]
    c = strList[0][i]
    rotationValue = g_m[strList[1][i]]
    res = g_m[(g_m[c] + rotationValue) % 26]
    resList.append(res)
  return ''.join(resList)

def sol():
  s = sys.stdin.readline()
  # divide
  # half
  dividedList = divide(s)

  # rotate
  # rotation value만큼 움직임
  rotatedList = []
  for divided in dividedList:
    rotatedList.append(rotate(divided))

  # merge
  return merge(rotatedList)


if __name__ == '__main__':
  if os.getenv('IS_LOCAL'):
    setStdin()

  res = sol()
  print(res)