n = int(input())
arr = list(map(int, input().split()))
arr_dec = list(reversed(arr))
dp_increase = [1] * n
dp_decrease = [1] * n


for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp_increase[i] = max(dp_increase[i], dp_increase[j] + 1)

        if arr_dec[i] > arr_dec[j]:
            dp_decrease[i] = max(dp_decrease[i], dp_decrease[j] + 1)

dp_decrease = list(reversed(dp_decrease))
# print(dp_increase, dp_decrease)

res = []
for i in range(n):
    res.append(dp_increase[i] + dp_decrease[i] - 1)
print(max(res))