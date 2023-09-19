package shop.mtcoding.streamstudy.lab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class StreamEx01Test {

    // 스트림 사용하지 않고 중복 제거하기
    @Test
    public void ex04() {

        // 리스트 생성
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> newList = new ArrayList<>();

        // 깊은복사
        for (Integer i : list) {
            newList.add(i);
        }

        // 정렬용 변수 선언
        int n = newList.size();
        int temp;

        // 깊은 복사한 newList에서 순차적으로 원소를 비교하면서
        // 앞의 값이 다음 값보다 크면 자리를 바꿔준다.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (newList.get(j) > newList.get(j + 1)) {
                    temp = newList.get(j);
                    newList.set(j, newList.get(j + 1));
                    newList.set(j + 1, temp);
                }
            }
        }

        System.out.println("버블정렬 오름차순 :" + newList);

        // 중복 제거
        for (int i = 0; i < newList.size() - 1; i++) {
            int currentValue = newList.get(i);
            int nextValue = newList.get(i + 1);

            // 정렬을 했으므로 현재 원소와 다음 원소가 같으면 중복으로 간주
            if (currentValue == nextValue) {
                newList.remove(i);
                i--; // 리스트 크기가 줄어들었으므로 인덱스를 다시 검사하도록 i를 하나 감소시킵니다.
            }
        }
        System.out.println("중복 제거 후 : " + newList);
    }

    @Test
    public void ex03() {
        // 리스트 생성
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        // 얕은복사 : 원본을 덮어 씌움
        lowList = list;

        // 깊은복사, 원본에 영향 없음
        for (Integer i : list) {
            highList.add(i);
        }
    }

    // http://www.tcpschool.com/java/java_stream_intermediate
    @Test
    public void ex02() {
        // 리스트 생성
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        // 스트림 생성
        Stream<Integer> stream = list.stream();
        // 중복제거(distinct)후 출력
        stream.distinct().forEach(t -> {
            System.out.println(t);
        });
    }


    // http://www.tcpschool.com/java/java_stream_creation
    @Test
    public void ex01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        // 컬렉션에서 스트림 생성
        Stream<Integer> stream = list.stream();

        // forEach() 메소드를 이용한 스트림 요소의 순차 접근
        // 매개변수가 2개면 괄호를 쳐준다. (a, b) -> {}
        stream.forEach(t -> {
            // System.out.println("값 : " + t); // 처음엔 4가 들어온다.
            System.out.println(t);
        });

        System.out.println("================");
        // 람다식을 쓰지 않았을때의 같은 표현
        // 스트림은 일회성 개체, 한번 닫히면 다시 사용불가
        // 따라서 스트림을 재사용하지 않도록 주의하자.
        // 위에서 사용했으므로 오류가 터진다.
        // 그래서 다시 스트림을 생성 해줘야 함.
        Stream<Integer> stream1 = list.stream();

        stream1.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });
    }
}
