import numpy as np
"""
#We pass a sequence of arrays that we want to join to the concatenate() function,
along with the axis.If axis is not explicitly passed, it is taken as 0.
"""
#Joining Two arrays
arr1 = np.array([1, 2, 3])

arr2 = np.array([4, 5, 6])

arr = np.concatenate((arr1, arr2))

print(arr)
print("""********************************1.""")

#Join two 2-D arrays along rows (axis=1):

arr1 = np.array([[1, 2], [3, 4]])

arr2 = np.array([[5, 6], [7, 8]])

arr = np.concatenate((arr1, arr2), axis=1)

print(arr)
print("""********************************2.""")
"""
Joining Arrays Using Stack Functions
Stacking is same as concatenation, the only difference is that stacking is done
along a new axis.

We can concatenate two 1-D arrays along the second axis which would result 
in putting them one over the other, ie. stacking.

We pass a sequence of arrays that we want to join to the stack() method 
along with the axis. If axis is not explicitly passed it is taken as 0.
"""
arr1 = np.array([1, 2, 3, 4])

arr2 = np.array([4, 5, 6, 7])

arr = np.stack((arr1, arr2), axis=1)

print(arr)
print("""********************************3.""")
"""NumPy provides a helper function: hstack() to stack along rows."""

arr1 = np.array([1, 2, 3])

arr2 = np.array([4, 5, 6])

arr = np.hstack((arr1, arr2))

print(arr)
print("""********************************4.""")
"""
NumPy provides a helper function: vstack()  to stack along columns.
"""
arr1 = np.array([1, 2, 3])

arr2 = np.array([4, 5, 6])

arr = np.vstack((arr1, arr2))

print(arr)
print("""********************************5.""")
"""
NumPy provides a helper function: dstack() to stack along height,
which is the same as depth.
"""
arr1 = np.array([1, 2, 3])

arr2 = np.array([4, 5, 6])

arr = np.dstack((arr1, arr2))

print(arr)
print("""********************************6.""")
print("""***************************************
*******************************************
*******************************************""")

"""
Splitting NumPy Arrays
Splitting is reverse operation of Joining.

Joining merges multiple arrays into one and Splitting breaks one array into multiple.

We use array_split() for splitting arrays, we pass it the array we want to split and the number of splits.
"""
#splitting array in three parts
arr = np.array([1, 2, 3, 4, 5, 6])

newarr = np.array_split(arr, 3)

print(newarr)
print("""********************************1.""")
"""
If the array has less elements than required, it will adjust from the end accordingly.
Split the array in 4 parts:
"""
arr = np.array([1, 2, 3, 4, 5, 6])

newarr = np.array_split(arr, 4)

print(newarr)
print("""*********************""")
newarr = np.array_split(arr, 3)

print(newarr[0])
print(newarr[1])
print(newarr[2])