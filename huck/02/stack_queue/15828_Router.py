import sys
import os

g_buffer = []
g_bufferSize = 0
g_frontPos = g_rearPos = 0

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def isEmpty():
  global g_buffer, g_frontPos, g_rearPos
  return (g_frontPos == g_rearPos) and (g_buffer[g_rearPos] == 0)
def isFull():
  global g_buffer, g_frontPos, g_rearPos
  return (g_frontPos == g_rearPos) and (g_buffer[g_rearPos] != 0)

def handlePacket(packet):
  global g_buffer, g_bufferSize, g_frontPos, g_rearPos

  if packet > 0:
    # enqueue
    # 꽉차있으면 새로운 packet 버림. => front,rear가 같은걸 보고, 거기에 패킷이 있을때
    if not isFull():
      g_buffer[g_rearPos] = packet
      g_rearPos = (1 + g_rearPos) % g_bufferSize
    return False
  elif packet == 0:
    # dequeue
    # dequeue한 자리는 무조건 0으로 채워줘야 함
    if not isEmpty():
      g_buffer[g_frontPos] = 0
      g_frontPos = (1 + g_frontPos) % g_bufferSize
    return False
  else:
    # 3. packet이 -1이면 끝
    if isEmpty():
      print('empty')
    else:
      pos = g_frontPos
      result = str(g_buffer[pos % g_bufferSize])
      pos += 1
      while pos % g_bufferSize != g_rearPos:
        result += ' ' + str(g_buffer[pos % g_bufferSize])
        pos += 1
      print(result)

    return True


if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  g_bufferSize = int(input())
  g_buffer = [0] * g_bufferSize
  g_rearPos = g_frontPos = 0

  lines = sys.stdin.readlines()
  for line in lines:
    packet = int(line.rstrip('\n'))
    isEnd = handlePacket(packet)
    if isEnd:
      break
