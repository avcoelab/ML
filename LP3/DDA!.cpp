#include<iostream>
using namespace std;
int fib(int n)
{
  if(n<=0)
    return 0;
  else if(n==1)
     return 1;
  int a=0;
  int b=1;
  int temp=0;
  for(int i=2;i<n;i++)
  {
      temp=a+b;
      a=b;
      b=temp;

  }
  return temp;
  
}
int main()
{
  int n;
  cout<<"Enter the number which we want to create an series for an fibonacci series";
  cin>>n;
  cout<<fib(n);
  return 0;
}