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




