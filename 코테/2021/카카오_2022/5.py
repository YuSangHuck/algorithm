# FIXME 못풀겟다.........

IDX = 'index'
IS_VISITED = 'isVisited'
CHILDREN = 'children'

def getChildren(targetDepth, graph):
  currentDepth = 1
  res = []

  currentChildren = graph[0][CHILDREN]
  nextChilredn = []

  while targetDepth > currentDepth:
    for currentChild in currentChildren:
      for child in currentChild[CHILDREN]:
        nextChilredn.append(child)

    currentChildren = nextChilredn
    nextChilredn = []
    currentDepth += 1
  
  print(currentChildren)

  cur = [] # 1,8
  while targetDepth >= currentDepth:

    next = []
    for child in cur:
      for c in child[CHILDREN]:
        next.append(c)
        res = next
    cur = next
    currentDepth += 1

  indexList = []
  for node in res:
    indexList.append(node[IDX])

  return indexList


def solution(info, edges):
  answer = 0

  # graph[parent] == parent의 children
  graph = {}
  for i in range(0, 1 + len(info)):
    graph[i] = {IDX: i, IS_VISITED: False, CHILDREN: []}

  for edge in edges:
    parent = edge[0]
    child = edge[1]

    graph[parent][CHILDREN].append({IDX: child, IS_VISITED: False, CHILDREN: []})

  # info[i] == 1, 늑대
  # for k in graph:
  #   print(k)
  #   print(graph[k])

  print(getChildren(2,graph))


    # 2. depth + 1의 인접 리스팅(notVisited)
    #  if 양이있거나
    #   양부터 방문안한 부모 주르륵 => cost 계산\
    #   if cost가 감당가능하다면
    #    방문처리하고 counting(양,늑대 둘 다)
    #  else 양이 없거나
  # 1. 방문하고

  # graph[0][IS_VISITED] = True
  # sheepCount = 1
  # sheepCandiList = [0]
  # wolfCount = 0
  # wolfCandiList = []
  # depth = 1
  # while(len(wolfCandiList) + len(sheepCandiList) != 0):
  #   wolfCandiList = []
  #   sheepCandiList = []
  #   childrenIndexList = getChildren(depth)
  #   for childIndex in childrenIndexList:
  #     # print(child)
  #     if info[child[IDX]]:
  #       wolfCandiList.append(child[IDX])
  #     else:
  #       sheepCandiList.append(child[IDX])

  #   for sheepCandi in sheepCandiList:
  #     print(sheepCandi)




  return answer


info = [0,0,1,1,1,0,1,0,1,0,1,1]
edges = [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]
result = 5

solution(info, edges)