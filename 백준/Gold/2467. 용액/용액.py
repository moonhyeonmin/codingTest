n = int(input())
liquid = list(map(int, input().split()))

st = 0
en = n - 1
min = 2000000001

while st < en:
    if abs(liquid[st] + liquid[en]) < min:
        min = abs(liquid[st] + liquid[en])
        min_st = st
        min_en = en

    if liquid[st] + liquid[en] < 0:
        st += 1
    else:
        en -= 1

print(liquid[min_st], liquid[min_en])