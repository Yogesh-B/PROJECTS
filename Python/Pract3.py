# 1.

userData = []
print('\nEnter number to add in the list.(Press Q to Quit)\n')
while True:
    data = input('Enter Number :')
    if(str(data).upper() == "Q"):
        break
    else:
        userData.append(int(data))

output = ""
for data in userData:
    if data < 5:
        output += str(data)+" "

newList = []
for data in userData:
    if data < 5:
        newList.append(data)

print('\nOutput Without Creating New List : {}'.format(output)) # Without creating new list
print('\nOutput With Creating New List : {}'.format(newList)) # Without creating new list

# 2.

answer = [data for data in userData if data < 5]
print('\nOne Line Answer : {}'.format(answer)) # One Line Answer

# 3.

userInput = int(input('\nEnter Number :'))

newOutput = ""
for data in userData:
    if data < userInput:
        newOutput += str(data)+" "

print('\nList which has all number less than {} : {}'.format(userInput,newOutput)) # Filtered List
