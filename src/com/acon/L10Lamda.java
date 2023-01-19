package com.acon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class L10Lamda {
    static int sum2;
    public static <numlist> void main(String[] args) {
        //람다식이 무엇인가요?: 추상메소드가 1개있는 인터페이스를 화살표함수를 이용해 객체로 생성하는 것
        //타입 생성 없이 실행 가능한 함수
        //익명 함수를 표현하는 간단한 방법
        //객체지향 문법에서 함수를 매개변수로 사용하기 위한 문법적 설탕(할수있는 척)!(람다식)
        //1.객체지향 문법에서 함수를 매개변수로 사용할 수 없나요?
            // 함수는 타입이 아니기 때문에 매개변수로 전달 할 수 없다.
        //2.람다식을 사용한다는 것은 자바가 함수형언어의 특징은 갖는 것이 아닌가요?
            // 아닙니다. 자바가 코드를 줄이기 위해 함수를 매개변수로 보낼 수 있는 척 하는 것 입니다.
        //3.함수형 언어가 무엇인가요?
            //함수가 타입이되는 언어입니다. 대표적으로 자바스크립트가 있고 프로토타입의 함수형 언어 입니다.


        ActionListener actionListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener actionListener1=e -> {};

        //자바는 타입이 명확한 언어기 떄문에 람다식으로 사용하는 인터페이스를 미리 정의해 두었다.(Stream API에서 대부분 사용됨)
                        //o는 Object
        Function<Integer,String> function= p -> {return p+"";};
        Consumer<Integer> consumer= (o)->{};
        BiConsumer<Integer,Integer> biConsumer=(P,P1)->{};
        Supplier<String> supplier=()->{return "";};
        Supplier<String> supplier1=()->"";
        UnaryOperator<Integer> operator=(e)->e*e;//단항연산
        BinaryOperator<Integer> sumOperator=(i,i2)->i+i2;//다항연산
        Predicate<String> predicate=(s)->{
            try {
                Integer.parseInt(s);
                return true;
            }catch (Exception E){}
            return false;
        };

        //java lib 개발자는 아주아주 매우 게으르다.

        //Runnable(run): 매개변수와 반환값이 없는함수(멀티스레드를 생성할때 정의한다.)
        //Function(apply) : 매개변수와 반환값이 있고 타입이 다른 것
        //Consumer (accept): 매개변수만 존재하는 함수
        //Supplier (get) : 리턴만 존재하는 함수 (블럭이 없으면 return 을 자동으로 한다.)
        //BinaryOperator(apply) : 매개변수가 2개고 반환하는 값이 있는 함수로 타입이 모두 같다.(2개의 값을 연산하기 위해 정의)
        //Predicate(test) : 매개변수를 검사한 결과(boolean)를 반환하는 함수
        //(Function,predicate,Cunsumer)매개변수가 있는 것들은 Bi를 사용하면 매개변수가 2개인 함수 정의
        //(Double,Int,Long)BinaryOperator : 기본형을 연산의 매개로 사용하는 함수 정의요(제네릭이 자료형만 정의 가능)

        System.out.println();

        String[] str={"1","23","삼","101"};

        for (String s :str){
            System.out.println("배열의 값은 정수 인가요?"+predicate.test(s));
        }
        //Stream API:내부반복문을 작성해서 반복문을 재사용하기 위해
        //filter (Predicate): 검사식을 만족하지 않는 요소를 제외하는 내부 반복문.
        //forEach (Consumer) : 최종연산으로 스트립을 소비하는 내부 반복문,보통 검사할 때 많이 사용

        //함수와 메소드: 함수는 메서드의 한국말이다. 함수는 수학에서 유래되었고 프로그래밍에서는 정의할 수 있는 연산의 단위가 된다.
        //함수와 메서드는 같은 말이다. 함수형 언어에서 함수는 유닛이고 객체지향 언어에서 함수는 유닛의 피드다.
        Arrays.stream(str)
                .filter((s)->{
                  try {
                      Integer.parseInt(s);
                      return true;
                  }catch (Exception E){}
                      return false;
                })
                .forEach((s)->{
                    System.out.println(s);
                });


        //Collection(List,Map,Set) 의 메소드를 람다로 재정의 가능
        List<Integer> numlist=new ArrayList<Integer>();

        numlist.add(77);
        numlist.add(7);
        numlist.add(777);
        numlist.add(7777);
        numlist.add(77777);
        int sum=0;
        for (int i=0;i<numlist.size();i++){
            sum+=numlist.get(i);
        }
        System.out.println(sum);

        sum=0;
        for(int num: numlist){
            sum+=num; //num.intValue(); 랩퍼클래스는 연산 시 자동으로 기본형을 반환
        }
        System.out.println(sum);

        //js 같은 생산성이 높은 언어들은 내부반복문 사용한다. -> 자바에서도 내부반복문 도입!

        sum = 0;
        //람다식과 익명클래스는 중첩클래스로 정의된 타입으로 지역변수를 참조할 수 없다.
        //하지만 java가 참조할 수 있도록 도와준다.(컴파일러가 코드변환을 하는 것을 추측)
        //도움에 한계가 있어서 지역변수를 상수로 취급한다.

        numlist.forEach(num ->
                sum2 += num
        );
        System.out.println(sum2);


    }

}
