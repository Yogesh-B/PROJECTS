def checkString(str1,str2):
    counter = 0
    if(len(str1) == len(str2)):
        for character in str1:
            if ord(character) - ord(str2[counter]) == 0:
                counter += 1
            else:
                return False
    else:
        return False
        
    if counter == len(str1):
        return True

string1 = input('\nEnter String-1 : ').lower()
string2 = input('\nEnter String-2 : ').lower()

if(checkString(string1,string2)):
    print('\nBoth the Strings are equal')
else:
    print('\nBoth the Strings are not equal')
