import sys
from curses.ascii import isdigit

input = sys.stdin.readline

n, m = map(int, input().split())

dic = {}
for i in range(1, n + 1):
    name = input().rstrip()
    dic[name] = i
    dic[i] = name
for i in range(m):
    com = input().rstrip()
    if com.isdigit():
        print(dic[int(com)])
    else:
        print(dic[com])