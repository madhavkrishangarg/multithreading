# multithreading

Used bubble sort to sort array without parallelisation
Used odd even transposition to sort array by creating threads that perform swaps in the given array at given indices
All 5 sizes of arrays (1,10,100,1000,10000) is being handled by the code
When code runs, it prints the array along with time taken with parallelisation and without parallelisation to sort this respective array.
Parallel sort some time shows more time in arrays of shorter length this may be because the overhead threads create and join() which pre-empts the execution of parents process until thread has finished

9 trees are being created out of 3 arrays of sizes 10,1000,1000000
Each array is used 3 times to
1. Build a tree without parallelisation
2. Build a tree with 2 threads
3. Build a tree with 4 threads
Sliced array are being passed to threads that build the tree
Time taken for the simulations are recorded and printed
Tree class has height() function which is recursive and prints the height of tree
An element of Inorder traversal of binary tree is being searched by linear search in both parallel and non-parallel simulation
Parallel simulation slices the in order traversal as per number of threads and searches the required element.
