# CollectionsAssignment

The aim of the assignment is to remove the duplicates available in the integer array and print it and store in collection object.
We have chosen ArrayList as the collection object to store the deduped integers.

Here we follow four approaches to do the same:

Approach 1:
  1. We use the approach similar to binary sort alogorithm and remove the duplicates.
  2. Clone the integer array using deep clone util method created in the same class.
  3. Now, we sort the new array in ascending order.
  4. Now, we traverse through the array and compare the current value with the value we got from the prev traversal.
  5. The current item in the traversal will be added to a temporary array list, if any of the below conditions are satisfied:
    i.  If the traversal count is 1 (First iteration)
    ii. Item's value of the current traversal didn't match the value of the element got from the previous traversal.
  6. After traversing all the elements, the temporary arraylist will have only the unique values from the random integers array.
  
  Disadvantage with approach 1:
  1. Original order present in the given integer array is not maintained.
  
  Approach 2:
    1. To overcome the condition of preserving the original order from the input array, we will use the approach 2.
    2. We will create a boolean array with the same length as original integer array.
    3. We have to create two for loop to compare the every element present in the integer array with the rest of the array
    4. If the result returns the presence of duplicate element, the element location will be noted and the boolean of the binary array will be made true. For e.g., if the 5th element in the original integer is duplicate, then the 5th element in the newly created binary array will be marked as true.
    5. Now, we will again traverse the original list and items in the original integer array will be included in the newly created array list, if the position in the binary array is false.
      -> For e.g., if the binary array is [false, true, false], then only 1st and 3rd element from the integer array will be added to the array list.
  
  Disadvantage with approach 2:
    1. Nearly three times, the entire integer array is traversed.
  
  Approach 3:
    1. To reduce the traversal path to remove the duplicates we will use approach 3/
    2. We will use LinkedHashset and store all the elements from the integer array.
    3. Hashset will do an internal comparison with the newly added elements and store only the unique elements.
    4. Linked Hashset preserves the original order.
  
  Approach 4:
    1. We can use HashMap also to achieve the similar result.
    2. To ensure only unique elements are stored and the order is maintained we will add following constraints, while adding the elements to hashmap.
    3. Hashmap elements will be checked whether map already has a same element.
    4. We will maintain a counter and add the counter value as a key while adding the elements in HashMap.
