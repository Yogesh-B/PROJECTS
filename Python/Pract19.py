def binary_search(arr, low, high, x):

    if high >= low:

        mid = (high + low) // 2

        if arr[mid] == x:
            return mid

        elif arr[mid] > x:
            return binary_search(arr, low, mid - 1, x)

        else:
            return binary_search(arr, mid + 1, high, x)

    else:
        return -1


list1 = [item for item in input("\nEnter the list of names : ").split()]

search = str(input('\nEnter Name to be searched : '))

list1.sort()

print('\nList : ',list1)

index = binary_search(list1,0,len(list1)-1,search)

if (index == -1):
    print('\nElement Not Found')
else:
    print('\nElement Found At Index : ',str(index))
