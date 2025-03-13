

cnt = []
n = int(input())
arr = input()

balls = arr.rstrip('R')
cnt.append(balls.count('R'))

balls = arr.rstrip('B')
cnt.append(balls.count('B'))

balls = arr.lstrip('B')
cnt.append(balls.count('B'))

balls = arr.lstrip('R')
cnt.append(balls.count('R'))




print(min(cnt))