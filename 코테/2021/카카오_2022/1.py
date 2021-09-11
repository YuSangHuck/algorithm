REPORT = 'report'
BLOCKED = 'blocked'

def solution(id_list, report, k):
  answer = []

  reportCount = {}
  relations = {}
  for id in id_list:
    reportCount[id] = 0
    relations[id] = {REPORT:[], BLOCKED: []}

  uniqReport = set(report)
  for item in uniqReport:
    fromID, toID = item.split()
    reportCount[toID] = reportCount[toID] + 1
    relations[fromID][REPORT].append(toID)

  for user in relations:
    for reported in relations[user][REPORT]:
      if reportCount[reported] >= k:
        relations[user][BLOCKED].append(reported)

  for id in id_list:
    answer.append(len(relations[id][BLOCKED]))


  return answer


a = ["muzi", "frodo", "apeach", "neo"]
b = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
c = 2
print(solution(a,b,c))