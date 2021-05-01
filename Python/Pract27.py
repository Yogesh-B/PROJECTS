

def getResult(data):
    result = filter(lambda x:len(x)==5 and x.startswith('m'),data)
    return list(result)

# 1. From Console
list1 = []

print('\nType exit to stop writing.')
print('\nEnter string :')

while True:
    line = input('')
    if line == 'exit':
        break
    else:
        temp = line.split(' ')
        for item in temp:
            list1.append(item)

print('\nOutput From Console')
print('\nWords Starting with \'m\' and length 5 is : ')
print(getResult(list1))


# 2. From File
fileName = input('\nEnter File Name : ')

text = open(fileName,'r').read()
text = text.lower()
words = text.split()

words = [word.strip('.,!;()[]') for word in words]
words = [word.replace("'s", '') for word in words]

print('\nOutput From File')
print('\nWords Starting with \'m\' and length 5 is : ')
print(getResult(words))
