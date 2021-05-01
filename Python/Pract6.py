inputA = []
inputB = []
result = []

print('\nEnter List-A value.(Press Q to Quit)\n')
while True:
    data = input('Enter Number :')
    if(data.upper() == 'Q'):
        break
    else:
        inputA.append(int(data))

print('\nEnter List-B value.(Press Q to Quit)\n')
while True:
    data = input('Enter Number :')
    if(data.upper() == 'Q'):
        break
    else:
        inputB.append(int(data))

result = [items for items in inputA if items in inputB]
result = list(set(result))

print('\nAnswer : {}'.format(result))
