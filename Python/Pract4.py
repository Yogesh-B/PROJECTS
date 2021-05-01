number = int(input('\nEnter Number : '))

listRange = list(range(1,number+1))

divisorList = []

for value in listRange:
    if number % value == 0:
        divisorList.append(value)

print('\nAnswer : {}'.format(divisorList))
