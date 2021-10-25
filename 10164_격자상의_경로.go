// 3 by 2
// 3C1
// 가로 2번 세로 1번
// --|
// -|-
// |--

// 3 by 3
// 가로 2번 세로 2번
// --||
// 4C2
// 6

// -|-|
// |--|
// -||-
// |-|-
// ||--

package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
)

var g_is_local bool

func init() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		g_is_local = true
	} else {
		g_is_local = false
	}

}

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-len(".go")] + "_input.txt")
}

// n by m에서 경우의수를 구한다
func getCaseOfPaths(n int, m int) int {
	// n by m이면
	// 가로로 n-1, 세로로 m-1
	// n-1 + m-1 C min(n-1, m-1)
	// a C b
	a := n - 1 + m - 1
	// b := n - 1
	res := 1
	// a C b
	for i := 1; i < m; i++ {
		res = res * (a - i + 1) / (i)
	}
	return res
}

func sol() {
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	tc := 1
	if g_is_local {
		fmt.Fscanln(r, &tc)
	}

	for i := 0; i < tc; i++ {
		// N과 M(1 ≤ N, M ≤ 15) // 격자 사이즈
		// K(K=0 또는 1 < K < N×M) // 필수 지나가는 숫자
		// 1	9
		// 1 ≤ N, M ≤ 5, K = 0
		// 2	24
		// 1 ≤ N, M ≤ 5, 1 < K < N × M
		// 3	23
		// 1 ≤ N, M ≤ 15, K = 0
		// 4	44
		// 원래의 제약조건 이외에 아무 제약조건이 없다.
		n, m, k := 0, 0, 0
		fmt.Fscanf(r, "%d %d %d\n", &n, &m, &k)

		// n,m,k가 주어졌을 때, 가능한 모든 경우의 수
		res := 0
		if k == 0 {
			// 나눌 필요 없음
			res = getCaseOfPaths(n, m)
		} else {
			// 나눠서 각각 곱
			// (k - 1) % m // 4%5 = 4 // 열
			// (k - 1) / m // 4/5 = 0 // 행
			subRow, subCol := (k-1)/m, (k-1)%m
			// 0,0 0,1 0,2 0,3 0,4
			// 1,0 1,1 1,2 1,3 1,4
			res = getCaseOfPaths(1+subRow, 1+subCol) * getCaseOfPaths(n-subRow, m-subCol)
		}
		fmt.Fprintln(w, res)
	}
}

func main() {
	if g_is_local {
		setStdin()
	}
	sol()
}
