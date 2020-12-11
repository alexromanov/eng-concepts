# Intro

Focus of the course:
- Algorithm - method for solving a problem
- Data structure - method to store information

Resources: 
- Textbook: Algorithms (Sedgewick)
- Site: http://www.algs4.princeton.edu

# Dynamic connectivity

Steps to developing a usable algorithm
- Model the problem
- Find an algorithm to solve it
- Fast enough? Fits in memory?
- If not, figure out why
- Find a way to address the problem
- Iterate until satisfied

Given a set of N objects.
- Union command: connect to objects
- Find / connected query: is there a path connecting the two objects

Is there a path between p and q? 

We assume that "is connected to" is equivalence relation:
- reflexive: p is connected to p
- symmetric: if p is connected to q, then q is connected to p
- transitive: if p is connected to q and q is connected to r, then p is connected to r

Connected components. Maximal set of objects that are mutually connected. 

**Implementing the operations**  

Find query. Check if two objects are in the same component.
Union command. Replace components containing two objects with their union.  

Usually, union(2,5) means to merge to connected components - one containing 2 and other containing 5. 

Union-find data type  
- Number of objects N can be huge
- Number of operations M can be huge
- Find queries and union commands may be intermixed
- void union(int p, int q)
- boolean connected(int p, int q)
- public class UF {}
- UF(int N)

# Quick-Find (eager approach)  

Data structure:
- integer array id[] of size N
- interpretation: p and q are connected iff (if and only if) they have the same id

Example:
id[] 0 1 1 8 8 0 0 1 8 8  
Based on the same indexes of array: 0,5,6 are connected, 1,2,7 are connected, 3,4,8,9 are connected
  
**Find:** check if p and q have the same id in the array  
**Union:** To merge components containing p and q, change all entries whose id equals id[p] and id[q].  

Quick-Find is too slow (union is too expensive)

Ex. Takes N^2 array accesses to process sequence of N union commands on N objects.
Quadratic algorithms do not scale.
Rough standard (for now).
- 10^9 operations per second
- 10^9 words in main memory
- touch all words in approx. 1 second.

Ex. Huge problem for quick-find.
- 10^9 union commands on 19^9 objects.
- Quick-find takes more than 10^18 operations
- 30+ years of computer time!

Quadratic algorithms don't scale with technology  
- New computer may be 10x fast.
- But, has 10x as much memory want to solve a problem that is 10x as big.
- With quadratic algorithm, takes 10x as long!

# Quick-union (lazy approach)

Data structure.
- Integer array id[] of size N.
- Interpretation: id[i] is aparent of i.
- Root of i is id[id[id[...id[i]...]]].  

Find. Check if p and q have the same root.  
Union. To merge components containing p and q, set the id of p's root to the id off q's root.

Quick-Find defect.
- Union too expensive (N array accesses).
- Trees are flat, but too expensive to keep them flat.

Quick-Union defect.
- Trees can get tall.
- Find too expensive (could be N array accesses).

# Improvement 1: weighting
Weighted quick-union.
- Modify quick-union to avoid tall trees.
- Keep track of size of each tree (number of objects).
- Balance by linking root of smaller tree to root of larger tree.

Weighted quick-union: Java implementation  
Data structure. Same as quick-union, but maintain an extra array sz[i] to count number of objects in the tree rooted at i.  
Find. Identical to quick-union.  
Union, Modify quick-union to:
- Link root of smaller tree to root of larger tree.
- Update the sz[] array.

Running-time.
- Find: take time proportional to depth of p and q.
- Union: takes constant time, given roots.

Proposition. Depth of any node x is at most lgN.

# Improvement 2: path compression
Quick union with path compression. Just after computing the root of p, set the id of each examined node to point to that root.  

Two-pass implementation: add second loop to root() to set the id[] of each examined node to the root.  
Simpler one-pass variant: make every other node in path point to its grandparent (thereby halving path length)

```
private int root(int i) {
    while (i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
    }
    return i;
}
```

In practice. No reason to! Keeps tree almost completely flat.

Bottom line. Weighted quick union (with path compression) makes it possible to solve problems that could not otherwise be addressed.

| algorithm    | worst-case time    |
| --- | --- |
| quick-find | M N |
| quick-union | M N |
| QU + path compression | N + M log N | 
| weighted QU + path compression | N + M lg N | 

WQUPC creduces time from 30 years to 6 seconds for 10^9 unions and objects finds. 

# Union-find applications
- Percolation
- Games (Go, Hex)
- Dynamic connectivity
- Least common ancestor
- Equivalence of finite state automata
- Hoshen-Kopelman algorithm in physics
- Hinley-Milner polymorphic type reference
- Kruskal's minimum spanning tree algorithm
- Compiling equivalence statements in Fortran
- Morphological attribute openings and closings
- Matlab's bwlabel() function in image processing

# Percolation  
A model for many physical systems:  
- N-by-N grid of sites
- Each site is open with probability p (or blocked with probability 1 - p)
- System percolates iff top and bottn are connected by open sites

| model   | system   | vacant site | occupied site   | percolates   |
| --- | --- | --- | --- | --- |
| electricity | material | conductor | insulated | conducts |
| fluid flow | material | empty | blocked | porous | 
| social interaction | population | person | empty | communicates |

When N is large, theory guarantees a sharp threshold p*.
- p > p*: almost certainly percolates.
- p < p*: almost certainly does not percolate.

P = 0.593 

# Monte Carlo simulation
- Initialize N-by-N whole grid to be blocked.
- Declare random sites open until top connected to bottom.
- Vacancy percentage estimates p*.

Dynamic connectivity solution to estimate percolation threshold
Q. How to check whether an N-by-N system percolates?  
- Create an object for each site and name them 0 to N^2 - 1
- Sites are in same component if connected by open sites
- Percolates iff any site on bottom row is connected to site on top row (brute-force)
- Clever trick: Introduce 2 virtual sites  (and connections to top and bottom)
    - Percolates iff virtual top site is connected to virtual bottom site.
    
Q. How to model opening a new site?  
A. Connect a newly opened site to all of its adjacent open sites.

Q. What is percolation threshold p*?  
A. About 0.592746 for large square lattices.










