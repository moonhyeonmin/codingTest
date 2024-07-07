import sys
input = sys.stdin.readline
result= 0

def AddStr(N):
    if N == 'A':
        str_pw[0] += 1
    elif N == 'C':
        str_pw[1] += 1
    elif N == 'G':
        str_pw[2] += 1
    else:
        str_pw[3] += 1

def SubStr(N):
    if N == 'A':
        str_pw[0] -= 1
    elif N == 'C':
        str_pw[1] -= 1
    elif N == 'G':
        str_pw[2] -= 1
    else:
        str_pw[3] -= 1
        
def Check():
    cnt = 0
    for i in range(4):
        if str_pw[i] >= pw[i]:
            cnt += 1
    return cnt


s, p = map(int, input().split())
str = list(map(str, input()))
pw = list(map(int, input().split()))
str_pw = [0] * 4


for i in range(p):
    AddStr(str[i])

if Check() == 4:
        result += 1

for i in range(1, s - p + 1):
    AddStr(str[p - 1 + i])
    SubStr(str[i - 1])
        
    if Check() == 4:
        result += 1
        
print(result)