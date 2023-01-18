package com.acon;
interface InterTest1{
     void a();
}

@FunctionalInterface //추상메서드가 오직 1개있는 인터페이스에 정의가능
    //람다식으로 구현을 대신할 수 있다.(익명클래스 생성이 안된다.)
interface InterTest2{
    void a();
}

class InterTestImpl implements InterTest1,InterTest2{

    @Override
    public void a() {

    }
}
public class L03Interface {
    public static void main(String[] args) {
        //인터페이스 : 엄청 추상화된  설계도 (이렇게 이렇게 하세요 ~) ,
        //설계도를 추상화 하는 이유 : 설계도 모두 구체화 되어 있으면 파악하기 어렵다.
        //추상화된 설계도를 재사용하기 용이하다. = 유지 보수가 용이
        //다른 설계도와 중복되어도 문제되지 않는다.


//        InterTest1 interTest1=new InterTest1();
        //설계도를 객체로 생성할 수 없다.
        InterTestImpl interTest=new InterTestImpl();     //--1번

        //인터페이스나 추상클래스를 객체로 생성하려면 인스턴트 생성과 동시에 구현하면 된다.
        //클래스를 만들고 추상메서드를 구현하는 행위를 생략해도 jvm 이 자동으로 익명클래스를 만들어서 구현함.

        InterTest1 interTest1 =new InterTest1(){//  --2번

            @Override
            public void a() {

            }
        };


        //jvm이 자동으로 하는 일
        //L03Interface 의 내부클래스로 1을 생성(익명 클래스)
        //class 1 implement InterTest1{public void a(){} } //이걸 대신해준다.

        //람다식 (문법적 설탕 : 문법만 존재하고 실존하지 않는다.)
        //인터페이스에 추상메서드가 1개 있는 @FunctionalInterface 명시하면 작성 가능 (1번,2번 이랑 동일한것)
        InterTest2 interTest2= ()->{

        }; //a함수
    }
}
