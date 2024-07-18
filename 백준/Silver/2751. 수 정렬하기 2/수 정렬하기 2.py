import sys
input = sys.stdin.readline

N = int(input())

arr = [0] * (N)
sorted_arr = [0] * N
for i in range(N):
    arr[i] = int(input())

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]
        left = merge_sort(left)
        right = merge_sort(right)
        
        return merge(left, right)
    return arr


def merge(left, right):
    i, j = 0, 0
    sort = []

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            sort.append(left[i])
            i += 1
        else:
            sort.append(right[j])
            j += 1
    
    while i < len(left):
        sort.append(left[i])
        i += 1

    while j < len(right):
        sort.append(right[j])
        j += 1

    return sort

sorted_arr = merge_sort(arr)

for i in range(N):
    print(sorted_arr[i])