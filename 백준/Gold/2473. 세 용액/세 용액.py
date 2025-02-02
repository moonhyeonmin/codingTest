import sys
input = sys.stdin.readline

n = int(input())
liquid = list(map(int, input().split()))

min = 4000000001

liquid.sort()


for mid in range(n - 2):
    st = mid + 1
    en = n - 1

    while st < en:
        sum = liquid[st] + liquid[mid] + liquid[en]
        if abs(sum) < min:
            min = abs(sum)
            res = [liquid[mid], liquid[st], liquid[en]]

        if sum < 0:
            st += 1
        elif sum > 0:
            en -= 1
        else:
            break

print(*res)

# 5
# -99 0 1 1 99