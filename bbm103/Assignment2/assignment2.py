
position = [1,1] #[x,y] positions in matrix
brush_down = False
orientation = ["East","South","West","North"]
current_orientation = 0

def initialize_matrix(matrix):#Creating the matrix with using user command.
    for liste in matrix:
        liste[0] = "+"
        liste[n-1] = "+"
        
    for i in range(n):
        matrix[0][i] = "+"
        matrix[n-1][i] = "+"

    return matrix


def print_matrix(matrix):#for the command "8",thats would help us to see the map.
    for liste in matrix:
        str = ""
        for a in liste:
            str += a
        
        print(str)


def apply_commands(matrix,user_commands):
    global current_orientation,brush_down,orientation,position


    for command in user_commands:
        
        #brush down
        if command == "1":
            brush_down = True
            matrix[position[1]][position[0]] = "*"
            #That's draw the dot to the place where the wehicle at.

        #brush up
        elif command == "2":
            brush_down = False
            #

        #for the "3" and "4" command , its simpyly going around the current_orientation list and change the
        #direction where we get from user.

        # turn right
        elif command == "3":
            if current_orientation == 3:
                current_orientation = 0
            else:
                current_orientation = orientation.index(orientation[current_orientation + 1])

        #turn left
        elif command == "4":
            if current_orientation == 0:
                current_orientation = 3
            else:
                current_orientation = orientation.index(orientation[current_orientation - 1])
 
        #move up to x
        #I get the "5_x" command and separate it with split method , then I get the second index
        #of this list and use it for moving around the map.
        elif "5_" in command:

            target_x = command.split("_")[1] # how_many step
            target_x = int(target_x)
            target_y = command.split("_")[1]
            target_y = int(target_y)
            #targetx == targety ===> True

            if current_orientation == 0 or current_orientation == 2:
    
                    if current_orientation == 0:
                        max_move = (n - 2) - position[0] # 20 - 14 = 6
                        #other_move = abs(max_move)
                        
                        #it should go back otherside(like snakegame).
                        if target_x > max_move:
                            if brush_down:
                                for i in range(position[0],n-1,1):
                                    matrix[position[1]][i] = "*" 
                            position[0] = 1
                            if brush_down:
                                for i in range(position[0], abs(max_move - target_x) + 1,1):
                                    matrix[position[1]][i] = "*" 
                            position[0] = abs(max_move - target_x)

                        else:
                            if brush_down:
                                for i in range(position[0],position[0]+target_x+1,1):
                                    matrix[position[1]][i] = "*"
                            position[0] = target_x + position[0]


                    #same for west side , just max_move value changes because of
                    #vehicle has to go opposite direction.
                    elif current_orientation == 2:
                        max_move = position[0] - 1 # 1 - 1

                        if target_x > max_move:
                            if brush_down:
                                for i in range(position[0],0,-1):
                                    matrix[position[1]][i] = "*"
                            position[0] = n-2
                            if brush_down:
                                for i in range(n-2, n-2 - abs(target_x - max_move) + 1, -1):
                                    matrix[position[1]][i] = "*"
                            position[0] = n-2 - abs(target_x - max_move) #???


                        else:
                            if brush_down:
                                for i in range(position[0],(position[0]-target_x) -1, -1):
                                    matrix[position[1]][i] = "*"
                            position[0] = position[0] - target_x




            #Moving in y axes.

            elif current_orientation == 1 or current_orientation == 3:

                    if current_orientation == 1:
                        max_move = (n - 2) - position[1] #lenght of the matrix minus position of the vehicle.

                        if target_y > max_move:
                            if brush_down:
                                for i in range(position[1],(n-1),1):
                                    matrix[i][position[0]] = "*"
                            position[1] = 1
                            if brush_down:
                                for i in range(position[1],abs(target_y - max_move)+1,1):
                                    matrix[i][position[0]]  ="*"
                            position[1] = abs(target_y - max_move)


                        else:
                            if brush_down:
                                for i in range(position[1],position[1]+target_y+1,1):
                                    matrix[i][position[0]] = "*"
                            position[1] = target_y + position[1]



                    elif current_orientation == 3:
                        max_move = position[1] - 1
                        if (target_y > max_move):
                            if brush_down == True:
                                for i in range(position[1], 0, -1):
                                    matrix[i][position[0]] = "*"
                            position[1] = n - 2
                            if brush_down == True:
                                for i in range(n-2,n-2 - abs(target_y - max_move) +1,-1):
                                    matrix[i][position[0]] = "*"
                            position[1] = n - 1 - abs(target_y - max_move)


                        else:
                            if brush_down:
                                for i in range(position[1], position[1]-target_y -1, -1):
                                    matrix[i][position[0]] = "*"
                            position[1] =position[1]-target_y



        #jumping
        #its like command "5_x" but more special one we can say.We have to move this vehicle 3
        #times to direction where its lokking at and we have to change the value of brush_down
        #(which can be only True or False) to False.
        elif command == "6":
            jump = 3
            brush_down = False
            if current_orientation == 0 or current_orientation == 2:

                if current_orientation == 0:
                    max_move = n - 2 - position[0]
                    if jump > max_move:

                        position[0] = abs(max_move - jump)

                    else:
                        position[0] += 3

                elif current_orientation == 2:
                    max_move = position[0] - 1
                    if jump > max_move:

                        position[0] = n - 2 - abs(max_move - jump)

                    else:

                        position[0] -= jump


            elif current_orientation == 1 or current_orientation == 3:

                if current_orientation == 1:
                    max_move = n - 2 - position[1]
                    if jump > max_move:
                        position[1] = abs(max_move - jump)

                    else:

                        position[1] += jump

                elif current_orientation == 3:
                    max_move = position[1] - 1
                    if jump > max_move:


                        position[1] = n - 2 - abs(max_move - jump)

                    else:


                        position -= jump

        #rotating 180* oppossite site
        #like command 3 or 4.
        elif command == "7":
            if current_orientation == 0:
                current_orientation = orientation.index(orientation[2])

            elif current_orientation == 1:
                current_orientation = orientation.index(orientation[3])
            
            elif current_orientation == 2:
                current_orientation = orientation.index(orientation[0])
            elif current_orientation == 3:
                current_orientation = orientation.index(orientation[1])
        #viewing matrix
        #we're gonna use print_matrix func. if the user is gonna call this command.
        elif command == "8":
            print_matrix(matrix)
        #finishing process
        elif command == "0":
            exit()
        else:

            print("The commands you just type cant run in here.Please try again." )

            return  user_input


    return matrix



if __name__ == "__main__":

    print("""
<------RULES------>
1. Brush Down
2. Brush Up 
3. Vehicle Rotates to Right
4. Vehicles Rotate To Left
5. Move Up to X
6. Jump
7. Reverse Direction
8. View the matrix
0. Exit
Please enter the commands with a plus sign(+) between them.
    
    """)
    def user_input():
        global n
        user_input = input("Please type your commands:")#getting commands from user.

        user_commands = user_input.split("+") #list

        n = int(user_commands[0]) + 2

        user_commands.pop(0)

        matrix = [[' ' for x in range(n)] for y in range(n)]

        #drawing "+" 's.
        matrix = initialize_matrix(matrix)

        apply_commands(matrix=matrix,user_commands=user_commands)

    user_input()
