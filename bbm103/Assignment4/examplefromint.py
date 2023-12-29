def print_victory():
    if targets_count == 0:
        print(f'Mission accomplished! All {initial_targets} targets destroyed.')
    else:
        print(f'Mission failed! {targets_count} targets left.')
    [print(" ".join(row)) for row in field]
    exit()


n = int(input())
field = []

dirs = {
    "up": [-1, 0],
    "down": [1, 0],
    "left": [0, -1],
    "right": [0, 1]
}
targets_count = 0

for row in range(n):
    input_line = input()
    line = list(input_line.split())
    field.append(line)
    if 'p' in line:
        player_pos = [row, line.index("p")]
    targets_count += input_line.count('t')

commands_count = int(input())
initial_targets = targets_count

for _ in range(commands_count):
    if targets_count == 0:
        print_victory()

    command = input().split()
    action = command[0]  # shoot
    direction = command[1]  # down
    number = int(command[2])  # 2

    direction_change = [number * n for n in dirs[direction]]
    row_to_shoot = int(player_pos[0]) + direction_change[0]
    col_to_shoot = int(player_pos[1]) + direction_change[1]
    next_pos = [row_to_shoot, col_to_shoot]

    if n > row_to_shoot >= 0 and 0 <= col_to_shoot < n:
        if action == "shoot":
            if field[row_to_shoot][col_to_shoot] == 't':
                targets_count -= 1
            field[row_to_shoot][col_to_shoot] = "x"
        elif action == "move":
            if field[row_to_shoot][col_to_shoot] == '.':
                field[row_to_shoot][col_to_shoot] = "p"
                field[player_pos[0]][player_pos[1]] = '.'
                player_pos = next_pos
    # [print(" ".join(row)) for row in field]
    # print("------------------------------------")
print_victory()