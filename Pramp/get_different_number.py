# https://www.pramp.com/challenge/aK6V5GVZ9MSPqvG1vwQp

def get_different_number(arr):
  for k, v in enumerate(frozenset(arr)):
    if k != v:
      return k
  return v+1


# print(get_different_number([0,5,4,1,3,6,2]))