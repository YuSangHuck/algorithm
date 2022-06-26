package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
	"sort"
	"strconv"
	"strings"
)

func sol() {
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	var n int
	fmt.Fscanf(r, "%d\n", &n)

	Nums := make(map[int]int, n)
	result := make(map[int]int, n)

	strs, _ := r.ReadString('\n')

	tmp := strings.Fields(strs)
	numList := make([]int, n)

	for i, ele := range tmp {
		numList[i], _ = strconv.Atoi(ele)
	}

	// logic

	for _, v := range numList {
		Nums[v] = 1
	}

	var UniqueNumber []int

	for k, _ := range Nums {
		UniqueNumber = append(UniqueNumber, k)
	}

	sort.Ints(UniqueNumber)

	for i, v := range UniqueNumber {
		result[v] = i
	}

	// output
	resList := []string{}
	for _, v := range numList {
		resList = append(resList, strconv.Itoa(result[v]))
	}

	fmt.Println(strings.Join(resList, " "))
	return
}

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-3] + "_input.txt")
}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}
	sol()
}
