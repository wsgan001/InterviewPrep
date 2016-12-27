package org.practice.numbers;

public class LargeMultiplication
{
    public static void main( String[] args )
    {
        int[] num1 = { 5,3,6,2,8,2,0,2,8 };
        int[] num2 = { 3,5,2,3,2,1,3,4 };
        int sum = 0, carry;

        int k = num1.length + num2.length;
        int[] result= new int[k];

        for( int i = num1.length - 1; i >= 0; i-- )
        {
            carry = 0;
            for( int j = num2.length - 1; j >= 0; j-- )
            {
                sum = num1[i] * num2[j] + carry + result[k - 1];
                carry = sum / 10;
                result[--k] = sum % 10;
            }
            result[--k] = carry;
            k += num2.length;
        }

        for( int j = 0; j < result.length; j++ )
        {
            System.out.print(result[j]+" ");
        }
    }
}
