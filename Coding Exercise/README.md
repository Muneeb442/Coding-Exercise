## 1. Does the solution work for larger graphs? 
   - The solution should work for larger graphs as well. However, it might have some speed and memory constraints.  

## 2. Can you think of any optimizations? 
   - We can use memoization to avoid repetitive calculations. 

## 3. What’s the computational complexity of your solution? 
   - Time and space complexity will be O(V+E) 
   - V: vertices
   - E: Edges

## 4. Are there any unusual cases that aren't handled? 
   - I believe if we have a cyclic graph then the dfs algorithm will get stuck in an infinite loop.
