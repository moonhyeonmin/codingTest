n = int(input())

grade = list(map(int, input().split()))
maxgrade = max(grade)
sum = sum(grade)

print(sum * 100 / maxgrade / int(n))