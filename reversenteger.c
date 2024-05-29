#include<math.h>
int reverse(long int x){
    long int rem=0,rev=0,sign=1;
    if(x<=0){
        sign=-1;
        x*=-1;
    }
    while(x>0)
    {
        rem=x%10;
        rev=(rev*10)+rem;
        if(rev>pow(2,31) || rev<-1*pow(2,31))
        return 0;

        x/=10;
    }
    return rev*sign;

}