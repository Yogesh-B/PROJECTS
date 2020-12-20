#practical Tic Tac Toe game
#computer O ,,human X
board = [' ' for x in range(10)]


def insertLetter(letter, pos):
    board[pos] = letter

def isPositionFree(pos):
    return board[pos]==' '

def printBoard(board):
    print('   |   |')
    print(' '+board[1]+' | '+board[2]+' | '+board[3])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' '+board[4]+' | '+board[5]+' | '+board[6])
    print('   |   |')
    print('-----------')
    print('   |   |')
    print(' '+board[7]+' | '+board[8]+' | '+board[9])
    print('   |   |')


def isWinner(bo,le):
    return ( (bo[1]==le and bo[2]==le and bo[3]==le) or
    (bo[4]==le and bo[5]==le and bo[6]==le) or
    (bo[7]==le and bo[8]==le and bo[9]==le) or
    (bo[1]==le and bo[4]==le and bo[7]==le) or
    (bo[2]==le and bo[5]==le and bo[8]==le) or
    (bo[3]==le and bo[6]==le and bo[9]==le) or
    (bo[1]==le and bo[5]==le and bo[9]==le) or
    (bo[3]==le and bo[5]==le and bo[7]==le) )

def playerMove():
    run = True
    while run:
        move = input("Please select a position to place an \'X\' (1-9):")
        try:
            move = int(move)
            if move>0 and move<10:
                if isPositionFree(move):
                    run = False
                    insertLetter('X',move)
                else:
                    print("Selected position is already occupied!!!")
            else:
                print("Please enter number in Range (1-9)!!!")
        except:
            print("Please type a NUMBER!!!")


def compMove():
    possibleMoves = [x for x, letter in enumerate(board) if letter == ' ' and x!=0]
    move = 0
    for let in ['O','X']:    #Tries AI to win and block user from winning
        for i in possibleMoves:
            boardCopy = board[:]
            boardCopy[i] = let
            if isWinner(boardCopy,let):
                move = i
                return move
    cornersOpen = []
    for i in possibleMoves:
        if i in [1,3,7,9]:
           cornersOpen.append(i)
    if len(cornersOpen) > 0:
        move = selectRandom(cornersOpen)
        return move
    if 5 in possibleMoves:
        move = 5
        return move

    edgesOpen = []
    for i in possibleMoves:
        if i in [2,4,6,8]:
           edgesOpen.append(i)
    if len(edgesOpen) > 0:
        move = selectRandom(edgesOpen)

    return move
  

def selectRandom(li):
    import random
    ln = len(li)
    r = random.randrange(0,ln)
    return li[r]


def isBoardFull(board):
    if board.count(' ')>1:
        return False
    else:
        return True 

def main():
    print("....This is Tic Tac Toe....")
    printBoard(board)



    while not(isBoardFull(board)):
        if not (isWinner(board,'O')):
            playerMove()
            printBoard(board)
        else:
            print("Sorry, O\'s won this time!")
            break
        
        if not (isWinner(board,'X')):
            move = compMove()
            if move==0:
                print("Game Tie!!!")
            else:
                insertLetter('O',move)
                print("Computer placed an \'O\' in position ",move,":")
                printBoard(board)
        else: 
            print("X\'s won this time! Good Job!")
            break
        


    # if isBoardFull(board):
    #     print("Game Tie!!!")
    # else:
    #     pass

if __name__ == "__main__":
    main()