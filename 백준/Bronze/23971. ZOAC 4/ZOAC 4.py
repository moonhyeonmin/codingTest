h, w, n, m = list(map(int, input().split()))

cnt_w, cnt_h = 0, 0


for i in range(0, h, n + 1):
    cnt_h += 1
for i in range(0, w, m + 1):
    cnt_w += 1

print(cnt_w * cnt_h)