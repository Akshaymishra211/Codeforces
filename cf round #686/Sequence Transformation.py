import sys
import math
import bisect
from math import floor,sqrt,log
from collections import defaultdict
scanf=lambda n: [int(i) for i in sys.stdin.readline().split()][:n]
cin=lambda : map(int,sys.stdin.readline().split())
rint=lambda : int(sys.stdin.readline())
rstring=lambda : sys.stdin.readline()
cout=lambda tt,x: sys.stdout.write("Case #"+str(tt)+": "+str(x)+'\n')
abserror=lambda ans,upto:"{:.{}f}".format(ans,upto)
sys.setrecursionlimit(100000)
mod=1000000007
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
def mod_inverse(a, n):
    N = n
    xx = 0
    yy = 1
    y = 0
    x = 1
    while(n > 0):
        q = a // n
        t = n
        n = a % n
        a = t
        t = xx
        xx = x - q * xx
        x = t
        t = yy
        yy = y - q * yy
        y = t
    x %= N
    x += N
    x %= N
    return x
def sieve(n):
    prime = [True for i in range(n + 1)] 
    p = 2
    while (p * p <= n):  
        if (prime[p] == True):  
            for i in range(p * 2, n + 1, p): 
                prime[i] = False
        p += 1
    prime[0]= False
    prime[1]= False
    # return all prime numbers below n in O(n*log(log(n))
    return prime
def solve():
    n=rint()
    l=scanf(n)
    unique=set(l)
    mini,maxi=min(l),max(l)
    if mini==maxi:
        print(0)
    else:
        idx=[-1 for i in range(maxi+1)]
        val=[-1 for i in range(maxi+1)]
        for i in range(n):
            if idx[l[i]]==-1:
                idx[l[i]]=i
                val[l[i]]=0
            else:
                if i-idx[l[i]]>1:
                    idx[l[i]]=i
                    val[l[i]]+=1
                else:
                    idx[l[i]]=i
        for i in unique:
            if i==l[0] and i!=l[-1]:
                val[i]+=1
            elif i!=l[0] and i==l[-1]:
                val[i]+=1
            elif i!=l[0] and i!=l[-1]:
                val[i]+=2
        cnt=float('inf')
        for i in val:
            if i!=-1:
                cnt=min(cnt,i)
        print(cnt)

if __name__ == "__main__":
    #if ("in.txt" and "out.txt"):
    #    sys.stdin=open("in.txt",'r')
    #    sys.stdout=open("out.txt",'w')
    ttestcases=rint()
    for testcase in range(1,ttestcases+1):
        #cout(testcase,solve())
        solve()
