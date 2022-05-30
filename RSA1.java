package lp3;

import java.util.*; 

import java.math.*; 

 

class RSA1 

{ 

//to find gcd 

public static double gcd(double a, double h) 

{ 

    double temp; 

    while(true) 

    { 

        temp = a%h; 

        if(temp==0) 

        return h; 

        a = h; 

        h = temp; 

    } 

} 

 

public static void main(String[] args) 

{ 

    //2 random prime numbers 

    double p = 7;  

    double q = 17; 

    double n=p*q; 

    double count; 

    double totient = (p-1)*(q-1); //eulers totient function 

 

    //public key 

    //e stands for encrypt 

    double e = 2; //select e such that it is 1<= e <totient (e should be co prime to totient...such that gcd btwm e and totient should be 1) 

 

    //for checking co-prime which satisfies e>1 

    while(e<totient) 

    { 

    count = gcd(e,totient); 

    if(count==1) 

        break; 

    else 

        e++; 

    } 

 

    //private key 

    //d stands for decrypt 

    double d; 

 

    //k can be any arbitrary value 

    double k =1; 

    while(true) 

    { 

    	if((1 + (k*totient))%e==0) 

    	{ 

    		d = (1 + (k*totient))/e; 

    		break; 

    	} 

    	else 

    	{ 

    		k++; 

    	} 

    } 

 

    //choosing d such that it satisfies d*e = 1 + k * totient 

     //d is multiplicative inverse of e 

    double msg = 10; 

    double c = (Math.pow(msg,e))%n; 

     

    //BigInteger helps in the calculation of large numbers which are beyond the limits of primitive datatypes. 

    //cannot convert form int to bigint hence have to convert to bigdecimal first 

    BigInteger N=BigDecimal.valueOf(n).toBigInteger(); 

    //BigInteger D=BigDecimal.valueOf(d).toBigInteger(); 

    BigInteger C=BigDecimal.valueOf(c).toBigInteger(); 

    int dd=(int)d; 

    BigInteger m = (C.pow(dd)).mod(N); 

    System.out.println("Message data = "+msg); 

    System.out.println("p = "+p); 

    System.out.println("q = "+q); 

    System.out.println("n = pq = "+n); 

    System.out.println("totient = "+totient); 

    System.out.println("e = "+e); 

    System.out.println("d = "+d); 

   System.out.println("Public Key{"+e+","+n+"}");
   
   System.out.println("Private Key{"+d+","+n+"}");
   
    System.out.println("Encrypted data = "+c); 

    System.out.println("Original Message Sent = "+m); 

 

} 

}
