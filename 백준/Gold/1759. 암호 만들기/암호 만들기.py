cnt_n, cnt_m = 0, 0
l, c = map(int, input().split())
arr = list(map(str, input().split()))
vowels = ['a', 'e', 'i', 'o', 'u']

arr.sort()


res = []
def func(k, idx):
    flag = 0
    global cnt_m, cnt_n
    if k == l:
        if cnt_n >= 2 and cnt_m >= 1:
            for items in res:
                print(items, end='')
            print()
        return

    for i in range(idx, c):
        if arr[i] in vowels:
            cnt_m += 1
            flag = 1
        else:
            cnt_n += 1
            flag = 2
        res.append(arr[i])
        func(k + 1, i + 1)
        if flag == 1:
            cnt_m -= 1
        else:
            cnt_n -= 1
        res.pop()

func(0, 0)