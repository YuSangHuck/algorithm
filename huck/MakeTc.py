import os

def makeTC():
  tcFileSuffix = '_custom_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  tcFileName = fileName + tcFileSuffix
  f = open(tcFileName, "w")

  lines = []
  N = 100000
  lines.append(str(N) + '\n')

  n = (2 ** 31) - 1
  for _ in range(N - 1):
    lines.append(str(n) + '\n')

  f.writelines(lines)
  f.close()

if __name__ == "__main__":
  makeTC()