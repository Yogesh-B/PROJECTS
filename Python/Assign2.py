import sys

class Manager:
    def __init__(self,accountNumber=0,BranchName=None,Balance=0):
        self.accountNumber = accountNumber
        self.BranchName = BranchName
        self.Balance = Balance

    def readFromFile(self,file):
        list = []
        f1 = open(file,'r')
        Lines = f1.readlines()
        f1.close()
        for line in Lines:
            row = line.strip().split(' ')
            object = Manager(int(row[0]),row[1],float(row[2]))
            list.append(object)
        return list

    def getDataBranchWise(self,list,branchName):
        totalAccounts = 0
        totalBalance = 0.0
        higheshBalance = lowestBalance  = list[0].Balance
        isBranchPresent = False

        for object in list:
            if(object.BranchName.lower() == branchName.lower()):
                isBranchPresent = True
                totalAccounts += 1
                totalBalance += object.Balance

                if(object.Balance > higheshBalance):
                    higheshBalance = object.Balance

                if(object.Balance < lowestBalance):
                    lowestBalance = object.Balance

        if(not isBranchPresent):
            print('No Such Branch Found')
            return

        averageBalance = (totalBalance/totalAccounts)
        output ="\nTotal Accounts : {0}\n".format(totalAccounts)
        output +="Average Balance : {0} Rs\n".format(averageBalance)
        output +="Highest Balance : {0} Rs\n".format(higheshBalance)
        output +="Lowest Balance :  {0} Rs".format(lowestBalance)
        print(output)



if(len(sys.argv) > 2 or len(sys.argv) < 2):
    print('Missing required inputs')
    sys.exit()

p1 = Manager()
output = p1.readFromFile('accounts.txt')
p1.getDataBranchWise(output,sys.argv[1])
