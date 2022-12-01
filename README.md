# Sudoku

How to play sudoku?
A Sudoku board consists of a 9x9 grid of squares, subdivided into 3x3 squares, therefore, the total number of slots is 81.
At the end of the game, each slot will contain exactly one number.
In the beginning, some slots have numbers, and the player tries to complete the other slots using the following rules:
(1) Each slot must contain a single number between 1 and 9.
(2) Each column can only contain numbers from 1 to 9 once.
(3) Each row must contain numbers from 1 to 9 once.
(4) Each 3x3 square must contain numbers from 1 to 9 once.
![image](https://user-images.githubusercontent.com/92684210/205090954-61a2dcc8-8638-4c5e-97c9-394d0a67930f.png)


Backtracking Algorithm -
In sudoKo solving Problem, we try filling digits one by one.
Whenever we find that current digit cannot lead to a solution, we remove it (backtrack) and try next digit.
This is better than naive approach (generating all possible combinations of digits and then trying every combination one by one)
as it drops a set of permutations whenever it backtracks.
In backtracking solution algo, we iterate through the matrix and whenever an empty cell
(cell with the digit 0) is found, we assign a digit to the cell, where such digit is not present in the current column, row, and 3×3 submatrix.
After assigning the digit to the current cell, we recursively check whether this assignment leads to a valid solution or not.
If the assignment doesn’t lead to a valid solution, then we try the next valid digit for the current empty cell.
And if none of the digits leads to a valid solution, then the instance is infeasible.


Sudoku using Cross-Hatching with backtracking -
Like we used to fill sudoku by first identifying the element which is almost filled.
It starts with identifying the row and column where the element should be placed.
Picking the almost-filled elements first will give better pruning.
Follow the steps below to solve the problem:
Build a graph with pending elements mapped to row and column coordinates where they can be fitted in the original matrix.
Pick the elements from the graph sorted by fewer remaining elements to be filled.
Recursively fill the elements using a graph into the matrix. Backtrack once an unsafe position is discovered.

Sudoku using DFS with backtracking -
The Depth-first Search is a “blind” search algorithm that can be used to find a solution to problems that can be modeled as graphs.
It’s called “blind” because this algorithm doesn’t care about the cost between vertices on the graph.
The algorithm starts from a root node and explores as far as possible along each branch before backtracking.
If the algorithm finds a solution then it returns the solution and stops the search. 


Sources - 
(1) https://python.plainenglish.io/solve-sudoku-using-depth-first-search-algorithm-dfs-in-python-2be3caa08ccd.
(2) https://www.geeksforgeeks.org/sudoku-backtracking-7/?ref=rp.
