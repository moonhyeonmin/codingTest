import sys

cnt = [0]
n = int(sys.stdin.readline().strip())
arr = []
flag = None

for i in range(n):
    arr.append(sys.stdin.readline().strip())
    
arr.sort(key = lambda x : (len(x), x))

sorted_arr = []

for i in range(n):
    if arr[i] != flag:
        sorted_arr.append(arr[i])
    flag = arr[i]
        
for i in sorted_arr:
    print(i, end="\n")
        