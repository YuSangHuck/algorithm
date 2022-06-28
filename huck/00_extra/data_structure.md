## tree

- 파이썬에는 tree관련 모듈이 잇다.

### heapq module

> import heapq

- min heap 자료구조 제공

#### min heap

- 원소추가
> heapq.heappush(list, item)
- 최소값
> list[0]
- 원소삭제
> heapq.heappop(list)
- 리스트를 최소힙으로 변환
> heapq.heapify(list)

#### max heap

> min heap과 거의 동일하나 약간의 응용\
> item이 튜플인 경우, 첫 요소가 정렬의 기준이 되는걸 이용하자\
> heapq.heappush(list, (-item, item)) 형태로 넣으면 됨.

> 꺼낼때는 heapq.heappop(list)[1] 하면 됨


## Queue

### PriorityQueue module

> from queue import PriorityQueue

- queue의 item의 type이 custom class인 경우 정렬함수 오버라이딩 필요
> TypeError: '<' not supported between instances of 'Custom Class' and 'Custom Class'
``` python
    def __lt__(self, other):
        return self.price < other.price
```