Description : Two kingdoms are at war. Kingdom 1 has N soldiers (numbered as 1 to N) and the war goes on for K days. Each day only one soldier from each kingdom fights. 

Kingdom 1 can select one soldier from soldier number Ni to Nj. Ni and Nj are provided to you for each day.

Selection criteria: Each soldier has 2 parameters - A & B. A soldier is/are selected if A is max. If more than one soldier has A max then the soldier with min. B (of the shortlisted soldiers) is/are selected. If more than one soldier is still available, then the soldier with least index (of the shortlisted soldiers) is selected.
Print the soldier number selected for each day of the war.

Input: 
Line 1 contains number of soldiers of Kingdom1 => N
Line 2 contains N space-separated values of A
Line 3 contains N space-separated values of B
Line 4 contains number of days fight goes on => K
Next K lines contain space separated values of Ni and Nj

Output: 
K lines contain soldier number selected for each day of the war.

Sample Input:
10
2 5 3 7 9 2 9 8 7 15
5 2 1 8 3 1 2 9 0 5
3
1 5
3 8
4 10

Result:
5
7
10
