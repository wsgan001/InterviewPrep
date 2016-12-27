package org.practice.numbers;

//Convert a number to its binary representation
public class HexConvertor {
    public static void hexa(int num) {
        int m = 0;
        if( (m = num >>> 4) != 0 ) {
            hexa( m );
        }
        System.out.print((char)((m = num & 0x0F)+(m<10 ? 48 : 55)));
    }

    public static void main(String args[]) {
        hexa(1281);
    }
}
