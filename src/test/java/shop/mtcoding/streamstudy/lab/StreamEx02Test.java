package shop.mtcoding.streamstudy.lab;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx02Test {
    // skip & limit -> 페이징을 구현할 수 있다. but DB에서 해주니 query를 짜는게 더 중요하다.
    @Test
    public void ex05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 1번지를 Skip하고 크기를 2로 제한
        List<Integer> newList = list.stream()
                .skip(1)
                .peek(t -> {
                    System.out.println("Peek : " + t);
                })
                .limit(3) // 먼저 발동됨
                .collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }

    // limit
    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 크기를 2로 제한
        List<Integer> newList = list.stream()
                .limit(2)
                .collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }

    // 필터
    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 3일때만 false가 나오므로 3만 필터링 된다.
        List<Integer> newList = list.stream()  // 1. 스트림을 생성한다. (생성)
                .filter(t -> t != 3)           // 2-1. 뜰채로 3만 필터링 (가공)
                .map(t -> {
                    Integer r = t * 2;
                    return r;
                })               // 2-2. 다시 처음부터 각각의 값을 연산한다. (가공)
                .collect(Collectors.toList()); // 3. 연산한 값을 수집한다. (수집)

        newList.stream().forEach(t -> System.out.println(t));
    }

    // 필터
    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 3일때만 false가 나오므로 3만 필터링 된다.
        List<Integer> newList = list.stream().filter(t -> t != 3).collect(Collectors.toList());

        newList.stream().forEach(t -> System.out.println(t));
    }


    // 필터
    @Test
    public void ex01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 짝수는 2로 나눴을때 나머지가 0으로 필터링 -> 홀수만 뽑아낼 수 있다.
        List<Integer> newList = list.stream().filter(t -> t % 2 != 0).collect(Collectors.toList());

        newList.stream().forEach(t -> System.out.println(t));

    }
}