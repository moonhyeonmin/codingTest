n = int(input())
arr = list(map(int, input().split()))
plus, minus, mult, div = map(int, input().split())

Max = -1e9
Min = 1e9

def func(k, res, plus, minus, mult, div):
        global Max, Min
        if k == n:
            Max = max(res, Max)
            Min = min(res, Min)
            return

        if plus:
            func(k + 1, res + arr[k], plus - 1, minus, mult, div)
        if minus:
            func(k + 1, res - arr[k], plus, minus - 1, mult, div)
        if mult:
            func(k + 1, res * arr[k], plus, minus, mult - 1, div)
        if div:
            func(k + 1, int(res / arr[k]), plus, minus, mult, div - 1)

func(1, arr[0], plus, minus, mult, div)
print(Max)
print(Min)