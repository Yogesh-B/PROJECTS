def list_ends(a_list):
    return [a_list[0], a_list[len(a_list)-1]]


lst1 = []
lst1 = [int(item) for item in input("\nEnter the list items : ").split()]
print('\nGiven List  : ',lst1)
print('\nNew List : ',list_ends(lst1))
