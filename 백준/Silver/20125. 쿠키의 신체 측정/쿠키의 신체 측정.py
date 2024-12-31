n = int(input())
arr = []

heart_x, heart_y = 0, 0
for i in range(n):
    arr.append(list(input()))



for i in range(n):
    for j in range(n):
        if arr[i][j] == '*' and arr[i - 1][j] == '*' and arr[i][j - 1] == '*' and arr[i][j + 1] == '*' and arr[i + 1][j] == '*' and i > 0 and i < n - 1 and j > 0 and j < n - 1:
            heart_x = i
            heart_y = j

x, y = heart_x, heart_y - 1
cnt_left_arm = 0
while arr[x][y] == '*':
    cnt_left_arm += 1
    y -= 1
    if 0 > x or n <= x or 0 > y or y >= n:
        break

x, y = heart_x, heart_y + 1
cnt_right_arm = 0
while arr[x][y] == '*':
    cnt_right_arm += 1
    y += 1
    if 0 > x or n <= x or 0 > y or y >= n:
        break

x, y = heart_x + 1, heart_y
cnt_weist = 0
while arr[x][y] == '*':
    cnt_weist += 1
    x += 1
    if 0 > x or n <= x or 0 > y or y >= n:
        break

left_leg_x, left_leg_y = x, y - 1
cnt_left_leg = 0
while arr[left_leg_x][left_leg_y] == '*':
    cnt_left_leg += 1
    left_leg_x += 1
    if 0 > left_leg_x or n <= left_leg_x or 0 > left_leg_y or left_leg_y >= n:
        break

right_leg_x, right_leg_y = x, y + 1
cnt_right_leg = 0
while arr[right_leg_x][right_leg_y] =='*':
    cnt_right_leg += 1
    right_leg_x += 1
    if 0 > right_leg_x or n <= right_leg_x or 0 > right_leg_y or right_leg_y >= n:
        break

print(heart_x + 1, heart_y + 1)
print(cnt_left_arm, cnt_right_arm, cnt_weist, cnt_left_leg, cnt_right_leg)