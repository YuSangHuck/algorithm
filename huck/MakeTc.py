
def makeTC():
  tcFileSuffix = '_custom_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  tcFileName = fileName + tcFileSuffix
  f = open(tcFileName, "w")
  # N(1 ≤ N ≤ 500,000)
  # -10,000,000보다 크거나 같고, 10,000,000
  # M(1 ≤ M ≤ 500,000)
  # -10,000,000보다 크거나 같고, 10,000,000

  lines = []
  N = 500000
  lines.append(str(N) + '\n')

  s = '10000000'
  for n in range(N - 1):
    s += ' 10000000'
  lines.append(s + '\n')

  M = 500000
  lines.append(str(M) + '\n')

  s = '0'
  for n in range(M):
    s += ' ' + str(1+n)
  lines.append(s + '\n')

  f.writelines(lines)
  f.close()
