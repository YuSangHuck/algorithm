package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
)

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-len(".go")] + "_input.txt")
}

func divide(originStr []byte) [][]byte {
	half := len(originStr) / 2
	divided := [][]byte{originStr[0:half], originStr[half:]}

	return divided
}

func rotateChar(str []byte, pos int, rotationVal byte) {
	newValue := (str[pos]-65+rotationVal)%26 + 65
	copy(str[pos:], string(newValue))
}
func rotateStr(str []byte) []byte {
	var rotationVal byte
	for _, v := range str {
		rotationVal += v - 65
	}

	for i := range str {
		rotateChar(str, i, rotationVal)
	}
	return str
}

func merge(charStr []byte, rotateValue []byte) []byte {
	for i := 0; i < len(rotateValue); i++ {
		rotateChar(charStr, i, rotateValue[i]-65)
	}
	return charStr
}

func sol() {
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	var s []byte
	fmt.Fscanf(r, "%s\n", &s)
	// divide
	dividedByteList := divide(s)

	// rotate
	rotatedList := [][]byte{}
	for i := range dividedByteList {
		rotatedList = append(rotatedList, rotateStr(dividedByteList[i]))
	}

	// merge
	res := merge(rotatedList[0], rotatedList[1])
	fmt.Fprint(w, string(res))
}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}
	sol()
}
