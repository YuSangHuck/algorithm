# 파이썬 정렬에 대해 알아보자

## sorted vs list.sort

> - 공통점
> 둘다 stable sort임
> - 차이점
> sorted는 copy 후 sort해서 copy된 list를 return\
> list.sort는 list 자체를 sort. return은 Null

## itemgetter 과 attrgetter

> 정렬시 정렬 기준의 key가 될 수 있음\
> attrgetter는 custom class define시 편리\
> itemgetter는 tuple에 사용하기 편리\
> 중첩 정렬도 가능\
> from operator import itemgetter, attrgetter
