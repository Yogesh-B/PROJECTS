def bubbleSort(arr):

	n = len(arr)

	for i in range(n-1):
		for j in range(0, n-i-1):
			if arr[j] > arr[j+1] :
				arr[j], arr[j+1] = arr[j+1], arr[j]



arr = [int(item) for item in input('\nEnter list of Numbers : ').split()]

print('\nGiven Array is : ',arr)

bubbleSort(arr)

print('\nSorted Array is : ',arr)
