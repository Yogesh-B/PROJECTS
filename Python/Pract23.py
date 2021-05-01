def display_hash(hashTable):
	for i in range(len(hashTable)):
		print(i, end = " ")

		for j in hashTable[i]:
			print("-->", end = " ")
			print(j, end = " ")

		print()

HashTable = [[] for _ in range(10)]

def Hashing(key):
	return key % len(HashTable)

def insert(Hashtable, key, value):
	hash_key = Hashing(key)
	Hashtable[hash_key].append(value)

insert(HashTable, 10, 'Ironman')
insert(HashTable, 20, 'Thor')
insert(HashTable, 25, 'Falcon')
insert(HashTable,35,'Captain America')
insert(HashTable, 9, 'Vision')
insert(HashTable,19,'Hawk Eye')
insert(HashTable, 21, 'Hulk')
insert(HashTable, 21, 'Loki')

display_hash (HashTable)
