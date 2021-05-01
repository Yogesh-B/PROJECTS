import sys
import re
if len(sys.argv)==1:
	print("Missing required input")
	quit()

userString = (sys.argv[1])

if not re.match('^[a-zA-Z0-9]+$',userString):
    print('String must have only alphabets and digits.')
    sys.exit()

stringLength = len(userString)
number = ''
output = ''
list = []

for item in range(stringLength):
    currentInput = userString[item]
    if currentInput.isalpha():
        list.append(currentInput)
        number = ''
    else:
        number += str(currentInput)
        if  (item+1) != stringLength and userString[item+1].isalpha():
            list.append(int(number))

if number != '':
    list.append(int(number))

previousInput = ''
newList = []
for currentInput in list:
    if isinstance(currentInput,str) and isinstance(previousInput,str) and previousInput != '':
        newList.append(1)
        newList.append(currentInput)
    else:
        newList.append(currentInput)
    previousInput = currentInput

newList.append(1)

for item in range(len(newList)):
    if isinstance(newList[item],str):
        if (item+1) != len(newList):
            output += (newList[item] * newList[item+1])

print(output)
