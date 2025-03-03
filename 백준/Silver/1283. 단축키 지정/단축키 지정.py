n = int(input())

res = []

for _ in range(n):
    flag = 0
    arr = list(input().split())

    for i in range(len(arr)):
        if arr[i][0].lower() not in res:
            res.append(arr[i][0].lower())
            flag = 1
            arr[i] = '[' + arr[i][0] + ']' + arr[i][1:]
            print(' '.join(arr))
            break

    if flag == 0:
        for i in range(len(arr)):
            flag1 = 0
            for j in range(len(arr[i])):
                if arr[i][j].lower() not in res:
                    res.append(arr[i][j].lower())
                    flag = 1
                    flag1 = 1
                    arr[i] = arr[i][:j] + '[' + arr[i][j] + ']' + arr[i][j+1:]
                    print(' '.join(arr))
                    break
            if flag1 == 1:
                break

    if flag == 0:
        print(' '.join(arr))

    # print(arr[i])