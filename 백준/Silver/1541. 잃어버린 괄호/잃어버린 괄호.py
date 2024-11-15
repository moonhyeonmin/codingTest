arr = input().split('-')

def SUM(i):
    num = list(map(int, i.split('+')))
    cnt = 0
    

    for i in num:
        cnt += i
        
    return cnt


score = []


for i in arr:
    score.append(SUM(i))

result = 0
for i in range(len(score)):
    if i == 0:
        result += score[i]

    else:
        result -= score[i]

print(result)
    
