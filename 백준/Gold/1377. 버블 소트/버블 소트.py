import sys
input = sys.stdin.readline

N = int(input())
arr = []
Max = 0

for i in range(N):
    arr.append((int(input()), i))
sorted_arr = sorted(arr)

for i in range(N):
    if sorted_arr[i][1] - i > Max:
        Max = sorted_arr[i][1] - i
        
print(Max + 1)