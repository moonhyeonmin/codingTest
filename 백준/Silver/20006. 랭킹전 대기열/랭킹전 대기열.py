p, m = map(int, input().split())

room = [[] for _ in range(p)]
cnt = 0
level, name = input().split()
room[cnt].append((level, name))
cnt += 1

for _ in range(p - 1):
    level, name = input().split()
    flag = 0

    for i in range(cnt):
        if abs(int(room[i][0][0]) - int(level)) <= 10 and len(room[i]) < m:
            room[i].append((level, name))
            flag = 1
            break

    if flag == 0:
        room[cnt].append((level, name))
        cnt += 1

for i in range(cnt):
    room[i].sort(key=lambda x: x[1])
    if len(room[i]) == m:
        print("Started!")
        for j in range(len(room[i])):
            print(*room[i][j])
    else:
        print("Waiting!")
        for j in range(len(room[i])):
            print(*room[i][j])