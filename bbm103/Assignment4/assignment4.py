import sys

inputfile = open("{}".format(sys.argv[1]),"r",encoding="utf-8")
matrix = []
score = 0
for row in inputfile:
    liste = row.split()
    matrix.append(liste)
for row in matrix:
    print(" ".join(row))
print(" ")
print("Your Score is:", score,"\n")
def scorecal(letter):
    global score
    if letter == "B":
        score += 9
    elif letter == "G":
        score += 8
    elif letter == "W":
        score += 7
    elif letter == "Y":
        score += 6
    elif letter == "R":
        score += 5
    elif letter == "P":
        score += 4
    elif letter == "O":
        score += 3
    elif letter == "D":
        score += 2
    elif letter == "F":
        score += 1
    return score

def rightchechker(inputlist):
    position = [inputlist[0],inputlist[1] + 1]
    global letter
    if 0 <= position[0] < len(matrix) and 0 <= position[1] < len(matrix[position[0]]):
        if matrix[position[0]][position[1]] == letter:
            scorecal(letter)
            matrix[position[0]][position[1]] = " "
            return rightchechker(position),downchechker(position),leftchechker(position),upperchechker(position)

def downchechker(inputlist):
    position = [inputlist[0] + 1, inputlist[1]]
    global letter
    if 0 <= position[0] < len(matrix) and 0 <= position[1] < len(matrix[position[0]]):
        if matrix[position[0]][position[1]] == letter:
            scorecal(letter)
            matrix[position[0]][position[1]] = " "
            return rightchechker(position),downchechker(position),leftchechker(position),upperchechker(position)
def leftchechker(inputlist):
    position = [inputlist[0], inputlist[1] - 1]
    global letter
    if 0 <= position[0] < len(matrix) and 0 <= position[1] < len(matrix[position[0]]):
        if matrix[position[0]][position[1]] == letter:
            scorecal(letter)
            matrix[position[0]][position[1]] = " "
            return rightchechker(position),downchechker(position),leftchechker(position),upperchechker(position)
def upperchechker(inputlist):
    position = [inputlist[0] - 1, inputlist[1]]
    global letter
    if 0 <= position[0] < len(matrix) and 0 <= position[1] < len(matrix[position[0]]):
        if matrix[position[0]][position[1]] == letter:
            scorecal(letter)
            matrix[position[0]][position[1]] = " "
            return rightchechker(position),downchechker(position),leftchechker(position),upperchechker(position)

def matrixletterdel(inputlist):
    position = [inputlist[0],inputlist[1]]
    global letter
    if 0 <= position[0] <= len(matrix) - 1 and 0 <= position[1] <= len(matrix[position[0]]) and matrix[position[0]][position[1]] != " ":
        return rightchechker(position),downchechker(position),leftchechker(position),upperchechker(position)

def multiempty(a_matrix,number_,number):
    if 0 <= number_ - 1 < len(a_matrix):
        a_matrix[number_][number] = a_matrix[number_ - 1][number]
        a_matrix[number_ - 1][number] = " "
        return multiempty(a_matrix,number_ - 1,number)
    else:
        return
def deleterhor(a_matrix):
    for number in range(len(matrix)):
        if matrix[number].count(" ") == len(matrix[number]):
            matrix.pop(number)
            return deleterhor(matrix)
def deleterver(a_matrix):
    for number in range(len(matrix[0])):
        count = 0
        for number_ in range(len(matrix)):
            if matrix[number_][number] == " ":
                count += 1
        if count == len(matrix):
            for row in matrix:
                row.pop(number)
            return deleterver(matrix)
def matrixchanger(a_matrix):
    witdh = set()
    height_ = set()
    for number in range(len(a_matrix)):
        height_.add(number)
    for number in range(len(a_matrix[0])):
        witdh.add(number)
    witdh = list(witdh)
    witdh.sort()
    height_ = list(height_)
    height_.sort()
    for number in witdh:
        for number_ in height_:
            if 0 <= number_ < witdh[-1] + 1:
                if matrix[number_][number] == " ":
                    multiempty(matrix,number_,number)
    for number1 in range(len(a_matrix)):
        count_list = []
        for number1_ in range(len(a_matrix)):
            if a_matrix[number1_][number1] == " ":
                count_list.append(".")
        if count_list.count(".") == len(a_matrix):
            for number__ in range(len(matrix)):
                a_matrix[number__].pop(number1)
    last_column_count = []
    for row in a_matrix:
        if row[-1] == " ":
            last_column_count.append(".")
    if last_column_count.count(".") == len(a_matrix):
        for row in matrix:
            row.pop(-1)
    for row in matrix:
        if row.count(" ") == len(row):
            matrix.remove(row)
    deleterhor(matrix)
    deleterver(matrix)



def thebombworker(coordinates):
    for i,j in coordinates:
        for row in matrix:
            scorecal(row[j])
            row[j] = " "
    for i,j in coordinates:
        for number in range(len(matrix[i])):
            scorecal(matrix[i][number])
            matrix[i][number] = " "
    deleterver(matrix)
    deleterhor(matrix)

coordinates = []
def thebombsfinder(row,column):
    global coordinates
    coordinates.append((row,column))
    matrix[row][column] = " "
    global letter
    position = [row,column]
    row_numbers = set()
    column_numbers = set()
    for row_ in matrix:
        row_numbers.add(matrix.index(row_))
        for column_ in row_:
            column_numbers.add(row_.index(column_))
    row_numbers = list(row_numbers)
    column_numbers = list(column_numbers)


    for number_ in column_numbers:
        if matrix[row][number_] == "X":
            coordinates.append((row,number_))
            return thebombsfinder(row,number_)
    for number in row_numbers:
        if matrix[number][column] == "X":
            coordinates.append((number,column))
            return thebombsfinder(number,column)
    coordinates = set(coordinates)
    coordinates = list(coordinates)
    thebombworker(coordinates)


def isgameover(a_matrix):
    a = 0
    if len(matrix) == 1:
        if len(matrix[0]) == 1:
            if a_matrix[0][0] == "X":
                a += 1
        else:
            for number in range(len(a_matrix[0])):
                if number == 0:
                    if a_matrix[0][number] != " " and (a_matrix[0][number] == "X" or a_matrix[0][number + 1] == a_matrix[0][number]):
                        a += 1
                if 0 < number < len(a_matrix[0]) - 1:
                    if a_matrix[0][number] != " " and (a_matrix[0][number] == "X" or a_matrix[0][number + 1] == a_matrix[0][number]):
                        a += 1
                if a_matrix[0][number] == len(a_matrix[0]) - 1:
                    if a_matrix[0][number] != " " and a_matrix[0][number] == "X":
                        a += 1

    else:
        for number in range(len(a_matrix)):
            for number_ in range(len(a_matrix[number])):
                if number == 0:
                    if number_ == 0:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_] == a_matrix[number][number_] or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if 0 < number_ < len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_] == a_matrix[number][number_] or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if number_ == len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_]) == a_matrix[number][number_]:
                            a += 1
                if 0 < number < len(a_matrix) - 1:
                    if number_ == 0:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_] == a_matrix[number][number_] or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if 0 < number_ < len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_] == a_matrix[number][number_] or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if number_ == len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number+1][number_] == a_matrix[number][number_]):
                            a += 1
                if number == len(a_matrix) - 1:
                    if number_ == 0:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if 0 < number_ < len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and (a_matrix[number][number_] == "X" or a_matrix[number][number_ + 1] == a_matrix[number][number_]):
                            a += 1
                    if a_matrix[number][number_] == len(a_matrix[number]) - 1:
                        if a_matrix[number][number_] != " " and a_matrix[number][number_] == "X":
                            a += 1
    if a > 0:
        return 1
    else:
        return 0

while True:
    if isgameover(matrix) == 1:

        inputtxt = input("Please enter a row and a column number:")
        inputtxt = inputtxt.split(" ")
        inputtxt = [int(i) for i in inputtxt]
        row = inputtxt[0]
        column = inputtxt[1]
        if (row <= len(matrix)-1) and (column <= len(matrix[0])-1):
            letter = matrix[row][column]
            if letter == "X":
                thebombsfinder(row, column)
                print("")
                for row in matrix:
                    print(" ".join(row))
                print(" ")
                print("Your Score is:", score, "\n")
            elif letter == " ":
                print("Please enter a valid location!!!")
            else:
                matrixletterdel(inputtxt)
                matrixchanger(matrix)
                print()
                for row in matrix:
                    print(" ".join(row))

                print("\nYour Score is:", score, "\n")
        else:
            print("Please enter a valid location!!!")
        coordinates.clear()
    else:
        print("---Game Over---")
        break
