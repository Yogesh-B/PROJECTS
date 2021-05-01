import json

inp_str = input('\nEnter String : ')

out = {x : inp_str.count(x) for x in set(inp_str )}

print('Occurrence of all characters in {} is : '.format(inp_str))
print(json.dumps(out, indent=4, sort_keys=True))
