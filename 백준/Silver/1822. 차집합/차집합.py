import sys
input = sys.stdin.readline

def binary_search(start, end, tar):
    if start > end:
        return 0
    
    mid = (start + end) // 2
    if A[mid] == tar:
        return tar
    elif A[mid] > tar:
        end = mid - 1
    else:
        start = mid + 1
    return binary_search(start, end, tar)  

a, b = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
A_set = set(A)
cnt = 0

for i in B:
    if i in A_set:
        A_set.remove(i)
        cnt += 1

remain_A = sorted(A_set)
print(len(A) - cnt)
print(*remain_A)
        



