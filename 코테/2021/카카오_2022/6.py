def printBoard(board):
  for b in board:
    print(b)


def solution(board, skill):
  answer = 0

  for s in skill:
    # type, r1, c1, r2, c2, degree
    t = s[0]
    r1 = s[1]
    c1 = s[2]
    r2 = s[3]
    c2 = s[4]
    degree = s[5]

    # r이 0 ~ 3
    # c가 0 ~ 4
    for x in range(r1, 1 + r2):
      for y in range(c1, 1 + c2):
        if t == 1:
          # 공격
          board[x][y] -= degree
        else:
          # 회복
          board[x][y] += degree

  for row in board:
    for p in row:
      if p > 0:
        answer += 1


  return answer

board = [[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]
# type, r1, c1, r2, c2, degree
skill = [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]
result = 10

print(solution(board, skill))