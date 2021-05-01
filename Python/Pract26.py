list = []

print('\nType exit to stop writing.')
print('\nEnter content of file to be appended in \'python.py\' file : ')
while True:
    line = input('')
    if line == 'exit':
        break
    else:
        line += '\n'
        list.append(line)

fileName = 'python.py'
file = open(fileName,'a')
file.writelines(list)
file.close()

print('\nContent of \'python.py\' file is\n')
with open(fileName,'r') as reader:
    print(reader.read())
