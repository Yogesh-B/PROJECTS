def insertion_sort(arr):

    for i in range(1, len(arr)):

        val = arr[i]

        j = i-1
        while j >=0 and val < arr[j] :
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = val

    return arr


item = input('\nEnter Word : ')
print('\nInput : ',item)
print('\nOutput : ',insertion_sort(list(item))) 
