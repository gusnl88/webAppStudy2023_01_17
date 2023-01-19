package com.acon;

public class L06Casting {
    public static void main(String[] args) {
        byte b =127;
        System.out.println(Byte.MAX_VALUE);
//        b=128; //컴파일 오류( 해당 타입은 byte보다 큰 값을 참조할 수 있다.)
        b= (byte) 130; //기본형은 수를 값으로 저장하기 떄문에 해당 타입보다 큰수를 참조하는 것은 불가능 하다.
        System.out.println(b); //loss of data (값의 손실이 발생 byte<short<int<long 간의 형변환)

        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483648l);
        //수를 리터럴하게 선언하면 무조건 int 가 정의된다.
        //수 끝에 L을 붙여서 리터럴하게 선언해야 long이 정의된다.
        long l=2147483649l;
        int i = (int) l;
        System.out.println(i);

        //왜 실수를 리터럴하게 선언하면 float가아니라 double이 정의되는 걸까?

        float f = 13.3f;//실수끝에 f를 붙이고 리터럴하게 선언하면 float 된다.
        double d= 13.3;//실수를 리터럴하게 선언하면 기본이 double 이된다.

        System.out.println(Double.MAX_VALUE);
        d=179769313486231570000000000.0*1.0E300;
        System.out.println(d);
        System.out.println(Float.MAX_VALUE);
        f= (float) 3.4028235E50;
        System.out.println(f);
        //실수는 참조할 수 있는 수보다 큰수를 무한대라 한다.

        //정수가 ->실수 : 실수의 가수부가 정수로 정의하고 가수부로 표현할 수 있는 수보다 크면 지수부가 정의된다.
        //정수가 ->실수 : 해당정수를 지수표기법(부동소수점)으로 변경하고 가수가 표현할 수 있는 수만 가수부의 정의.
        //2147483647 -> 2.147483647E9 지수부에 9 가수가 21474를 저장
        i = Integer.MAX_VALUE;
        f= i; //실수가 정수보다 큰수를 정의할 수 있기 때문에 캐스팅 형변환할 필요가 없다.

        //정수로 표현할 수 없는 큰 실수가 정수로 변환 : 정수 타입이 정의할 수 있는 가장 큰수를 정의

        d= 12345678901234567890.0;
        System.out.println(d);
        i= (int) d;
        System.out.println("(큰)실수를 정수로 변환: "+i);
    }
}
