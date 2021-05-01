import sys
if len(sys.argv)==1:
	print("Missing required input")
	quit()

def function(str, k):
    list = []
    for i in range(len(str)):
        if i %k == 0:
            lst = []
            sub = str[i:i+k]
            for j in sub:
                lst.append(j)
            list.append(''.join(lst))
    return list

K = int(sys.argv[1])
userString = '*'.join(sys.argv[2:])

numberOfExtraCharacter = (K - (len(userString) % K))

if(numberOfExtraCharacter != K):
    paddingCharacter = "$" * numberOfExtraCharacter
    userString = userString + paddingCharacter

output = function(userString,K)

string = ''
for index in range(K):
    temp = ''
    for item in output:
        temp += item[index]

    string += temp[::-1]

print(string)
