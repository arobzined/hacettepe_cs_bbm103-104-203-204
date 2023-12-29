import sys

users_dict = {}
usernames_set = set()
output = open("output.txt","w")
output.write("""Welcome Assignment 3
-------------------------\n""")
def ANU(username):
    if username in usernames_set:
        output.write("ERROR: Wrong input type! for 'ANU'!--This user already exists!!\n")
    else:
        usernames_set.add(username)
        users_dict[username] = set()
        output.write("User {} has been added to the social network successfully\n".format(username))
    return usernames_set , users_dict
def DEU(username):
    if username in usernames_set:
        usernames_set.discard(username)
        users_dict.pop(username)
        for i in users_dict.values():
            if username in i:
                i.remove(username)
            else:
                continue
        output.write("User {} and his/her all relations have been deleted successfully\n".format(username))
        return usernames_set , users_dict
    else:
        output.write("ERROR: Wrong input type! for 'DEU'!--There is no user named {}!!\n".format(username))
        return usernames_set , users_dict
def ANF(source_user,target_user):
    if source_user and target_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'ANF'!--No user named {} and {} found!!\n".format(source_user,target_user))
    elif target_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'ANF'!--No user named {} found!!\n".format(target_user))
    elif source_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'ANF'!--No user named {} found!!\n".format(source_user))
    else:
        if target_user in users_dict[source_user]:
            output.write("ERROR: A relation between {} and {} already exists!!\n".format(source_user,target_user))
        else:
            users_dict[source_user].add(target_user)
            users_dict[target_user].add(source_user)
            output.write("Relation between {} and {} has been added successfully\n".format(source_user,target_user))
    return
def DEF(source_user,target_user):
    if source_user and target_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'DEF'!--No user named {} and {} found!\n".format(source_user,target_user))
    elif target_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'DEF'!--No user named {} found!!\n".format(target_user))
    elif source_user not in usernames_set:
        output.write("ERROR: Wrong input type! for 'DEF'!--No user named {} found!!\n".format(source_user))
    else:
        if target_user not in users_dict[source_user]:
            output.write("ERROR: No relation between {} and {} found!!\n".format(source_user,target_user))
        else:
            users_dict[source_user].remove(target_user)
            users_dict[target_user].remove(source_user)
            output.write("Relation between {} and {} has been deleted successfully\n".format(source_user,target_user))
    return
def CF(username):
    if username not in usernames_set:
        output.write("ERROR: Wrong input type! for 'CF'!--No user named {} found!\n".format(username))
    else:
        output.write("User named {} has {} friends.\n".format(username,len(users_dict[username])))
def FPF(username,maximum_distance):
    possible_friends = {}
    possible_friends = set(possible_friends)
    maximum_distance = int(maximum_distance)
    if username not in usernames_set:
        output.write("ERROR: Wrong input type! for 'FPF'!--No user named {} found!\n".format(username))
    else:
        if 3 >= maximum_distance >= 1:
            if maximum_distance >= 1:
                for user in users_dict[username]:
                    possible_friends.add(user)
                if maximum_distance >= 2:
                    for user1 in possible_friends.copy():
                        for user2 in users_dict[user1]:
                            possible_friends.add(user2)
                        if username in possible_friends:
                            possible_friends.remove(username)
                    if maximum_distance == 3:
                        for user3 in possible_friends.copy():
                            for user4 in users_dict[user3]:
                                possible_friends.add(user4)
                            if username in possible_friends:
                                possible_friends.remove(username)
                        output.write("User {} has {} possible friends when maximum distance is {}.\nThese possible friends:{}\n".format(username, len(possible_friends), maximum_distance, sorted(possible_friends)))
                    else:
                        output.write("User {} has {} possible friends when maximum distance is {}.\nThese possible friends:{}\n".format(username, len(possible_friends), maximum_distance, sorted(possible_friends)))
                else:
                    output.write("User {} has {} possible friends when maximum distance is {}.\nThese possible friends:{}\n".format(username, len(possible_friends), maximum_distance, sorted(possible_friends)))
        else:
            output.write("ERROR: Maximum distance is out of range!!\n")

def SF(username, mutual_degree):
    friends_pool = []
    mutual_degree = int(mutual_degree)
    if username in usernames_set:
        if 3 >= mutual_degree >= 2:
            for user in users_dict[username]:
                for user1 in users_dict[user]:
                    friends_pool.append(user1)
                    if username in friends_pool:
                        friends_pool.remove(username)

            if mutual_degree == 2:
                output.write("Suggestion List for {} (when MD is 2):\n".format(username))
                md2_list = []
                md3_list = []
                friends_pool_set = set(friends_pool)
                for x in friends_pool_set:
                    if friends_pool.count(x) == 2:
                        md2_list.append(x)
                    elif friends_pool.count(x) == 3:
                        md3_list.append(x)
                for element in md2_list:
                    output.write("{} has 2 mutual friends with {}\n".format(username, element))
                for element in md3_list:
                    output.write("{} has 3 mutual friends with {}\n".format(username, element))
                output.write("The suggested friends for {}:[{},{}]\n".format(username,(",").join(sorted(md2_list)),(",").join(sorted(md3_list))))
            elif mutual_degree == 3:
                output.write("Suggestion List for {} (when MD is 3):\n".format(username))
                md3_list = []
                friends_pool_set = set(friends_pool)
                for x in friends_pool_set:
                    if friends_pool.count(x) == 3:
                        md3_list.append(x)
                for element in md3_list:
                    output.write("{} has 3 mutual friends with {}\n".format(username, element))
                output.write("The suggested friends for {}:[{}]\n".format(username, (",").join(sorted(md3_list))))

        else:
            output.write("Error: Mutually Degree cannot be less than 1 or greater than 4\n")
    else:
        output.write("ERROR: Wrong input type! for 'SF'!--No user named {} found!\n".format(username))
with open("{}".format(sys.argv[1]),"r+",encoding="utf-8") as file:
    for users in file:
        users = users[:-1]
        users_list = users.split(":")
        users_dict[users_list[0]] = set(users_list[1].split(" "))
        usernames_set.add(users_list[0])
    with open("{}".format(sys.argv[2]),"r",encoding="utf-8") as file2:
        cmmnd_list = []
        for line in file2:
            line = line[:-1]
            cmmnd_line = line.split(" ")
            cmmnd_list.append(cmmnd_line)
        for element in cmmnd_list:
            if element[0] == "ANU":
                ANU(element[1])
            elif element[0] == "DEU":
                DEU(element[1])
            elif element[0] == "ANF":
                ANF(element[1],element[2])
            elif element[0] == "DEF":
                DEF(element[1],element[2])
            elif element[0] == "CF":
                CF(element[1])
            elif element[0] == "FPF":
                FPF(element[1],element[2])
            elif element[0] == "SF":
                SF(element[1], element[2])
            else:
                output.write("You use wrong command type , please try again...\n")
output.close()
