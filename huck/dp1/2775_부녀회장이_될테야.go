// “a층의 b호에 살려면
// 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다”
// f(a,b) = f(a-1,1), f(a-1,2), ..., f(a-1,b) = f(a,b-1) + f(a-1,b)

// 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
// 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
// f(k,n)에는 몇명?

// 1 ≤ k, n ≤ 14

package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
)

var g_dp [15][15]int

func init() {
	for i := 0; i < 15; i++ {
		g_dp[0][i] = i
	}
}

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-len(".go")] + "_input.txt")
}

// k층 n호
func getMemCount(k int, n int) int {
	if g_dp[k][n] != 0 {
		return g_dp[k][n]
	}

	if n == 1 {
		g_dp[k][n] = 1
		return 1
	}
	// f(a,b)
	// = f(a-1,1), f(a-1,2), ..., f(a-1,b)
	// = f(a,b-1) + f(a-1,b)
	g_dp[k][n-1] = getMemCount(k, n-1)
	g_dp[k-1][n] = getMemCount(k-1, n)

	return g_dp[k][n-1] + g_dp[k-1][n]
}
func sol() {
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	tc := 0
	fmt.Fscan(r, &tc)

	for i := 0; i < tc; i++ {
		k, n := 0, 0
		fmt.Fscan(r, &k)
		fmt.Fscan(r, &n)
		fmt.Println(getMemCount(k, n))
	}

	return
}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}
	sol()
}
