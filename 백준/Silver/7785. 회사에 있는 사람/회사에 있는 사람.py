n = int(input())

dic = {}
for i in range(n):
    name, record = map(str, input().split())
    if record == 'enter':
        dic[name] = 1
    else:
        del dic[name]

sort = sorted(dic, reverse=True)
for res in sort:
    print(res)
