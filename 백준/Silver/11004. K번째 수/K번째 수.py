import sys

input = sys.stdin.readline
N, K = map(int, input().split())
arr = list(map(int, input().split()))

def quick_sort(arr, left, right, K):
    if left < right:
        pv = partiton(arr, left, right)
        if pv == K:
            return
        elif pv > K:
            quick_sort(arr, left, pv - 1, K)
        else:
            quick_sort(arr, pv + 1, right, K)

    
def partiton(arr, left, right):
    if left + 1 == right:
        if arr[left] > arr[right]:
            arr[left], arr[right] = arr[right], arr[left]
        return right
    
    pv_idx = (left + right) // 2
    arr[left], arr[pv_idx] = arr[pv_idx], arr[left]
    pv = arr[left]
    i = left + 1
    j = right

    while i <= j:
        while pv < arr[j] and j > 0:
            j -= 1
        while pv > arr[i] and i < (len(arr) - 1):
            i += 1
        if i <= j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
            
    arr[left] = arr[j]
    arr[j] = pv
    return j

quick_sort(arr, 0, N - 1, K - 1)
print(arr[K - 1])