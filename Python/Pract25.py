fileName = input('\nEnter file name: ')
numOfLines = 0

with open(fileName, 'r') as f:
    for line in f:
        numOfLines += 1

print('\nNumber of lines : ',numOfLines)

text = open(fileName,'r').read()

text = text.lower()
words = text.split()

words = [word.strip('.,!;()[]') for word in words]
words = [word.replace("'s", '') for word in words]

unique = []
for word in words:
    if word not in unique:
        unique.append(word)

print('\nNumber of Unique Words : ',len(unique))
