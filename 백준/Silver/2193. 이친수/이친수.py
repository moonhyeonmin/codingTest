n = int(input())

cnt = [0] * (n + 1)
cnt[0], cnt[1] = 1, 1
for i in range(2, n):
    cnt[i] = cnt[i - 1] + cnt[i - 2]

print(cnt[n - 1])