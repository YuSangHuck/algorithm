import sys
import os

def handleInput():
  inputFileSuffix = '_input.txt'
  fileName, fileExtension = os.path.splitext(__file__)
  inputFileName = fileName + inputFileSuffix
  sys.stdin = open(inputFileName, "r")

def solution(string):
  # 첫 줄에는 라우터 내부에 존재하는 버퍼의 크기를 나타내는 자연수 N
  # 둘째 줄부터 한 줄에 하나씩 라우터가 처리해야 할 정보가 주어진다.
  # 모든 정보는 발생한 시간순으로 주어졌다고 가정한다.
  # 양의 정수는 해당하는 번호의 패킷이 입력으로 들어왔다는 것을 의미하고,
  # 0은 라우터가 패킷 하나를 처리했다는 것을 의미한다.
  # 이때, 버퍼가 비어있을때는 0이 입력으로 들어오지 않는다.
  # -1은 입력의 끝을 나타낸다
  # full일때는 새로운 패킷을 버린다.

  # 라우터에 남아있는 패킷을 앞에서부터 순서대로 공백으로 구분해서 출력하면 된다. 만약 비어있을 경우 empty라고 출력한다.
  print(string)

def isEmpty(frontPos, rearPos, buffer):
  return (frontPos == rearPos) and (buffer[rearPos] == 0)
def isFull(frontPos, rearPos, buffer):
  return (frontPos == rearPos) and (buffer[rearPos] != 0)

if __name__ == "__main__":
  if None != os.getenv('IS_LOCAL'):
    handleInput()

  bufferSize = int(input())
  buffer = [0] * bufferSize
  rearPos = frontPos = 0

  while True:
    packet = int(input())
    # 3. packet이 -1이면 끝
    if packet == -1:

      if isEmpty(frontPos, rearPos, buffer):
        print('empty')
      else:
        pos = frontPos
        result = str(buffer[pos % bufferSize])
        pos += 1
        while pos % bufferSize != rearPos:
          result += ' ' + str(buffer[pos % bufferSize])
          pos += 1
        print(result)

      break
    elif packet > 0:
      # enqueue
      # 꽉차있으면 새로운 packet 버림. => front,rear가 같은걸 보고, 거기에 패킷이 있을때
      if not isFull(frontPos, rearPos, buffer):
        buffer[rearPos] = packet
        rearPos = (1 + rearPos) % bufferSize
    elif packet == 0:
      # dequeue
      # dequeue한 자리는 무조건 0으로 채워줘야 함
      if not isEmpty(frontPos, rearPos, buffer):
        buffer[frontPos] = 0
        frontPos = (1 + frontPos) % bufferSize
    else:
      print('wrong packet')





