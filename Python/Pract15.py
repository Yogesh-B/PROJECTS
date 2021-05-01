def usingLoop(x):
  y = []
  for i in x:
    if i not in y:
      y.append(i)
  return y

def usingSet(x):
    return list(set(x))

list1 = [int(item) for item in input("\nEnter the list items : ").split()]
print('\nYour List :',list1)
print('\nUsing Loop : ',usingLoop(list1))
print('\nUsing Set : ',usingSet(list1))
