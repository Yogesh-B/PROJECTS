import random


def evaluateNumber(number,correctNumber,numberOfTry):
    if(number > correctNumber):
        print('\nYour number is Big..!!')
        return False
    elif(number < correctNumber):
        print('\nYour number is Small..!!')
        return False
    else:
        print('\nYou won the Game in {} try..!!'.format(numberOfTry))
        print(correctNumber)
        return True

correctNumber = random.randint(1,9)
numberOfTry = 0

print('\nGuess the number between 1 to 9 and type exit to quit the game')

while True:
    number = input('\nEnter the number : ')
    if(number == 'exit'):
        print('\nYou lose the game in {} try & Answer was : {}'.format(numberOfTry,correctNumber))
        break
    else:
        numberOfTry += 1
        if(evaluateNumber(int(number),correctNumber,numberOfTry)):
            break
