/**
 * =====================================================================
 * 파일명: P01_StreamBasics.java
 * 주제: Stream API 기본
 * =====================================================================
 *
 * 【학습목표】
 * 1. 컬렉션(List, Set 등)에서 stream()을 이용해 스트림을 생성할 수 있다.
 * 2. 배열에서 Arrays.stream() 또는 Stream.of()로 스트림을 생성할 수 있다.
 * 3. forEach, count, findFirst, findAny 등 기본 최종 연산을 사용할 수 있다.
 *
 * 【핵심개념】
 * - Stream: 데이터의 흐름(파이프라인)을 추상화한 인터페이스.
 *   컬렉션이나 배열의 원소를 순차/병렬로 처리할 수 있게 해준다.
 * - 스트림은 "원본 데이터를 변경하지 않음", "일회성(한 번 소비되면 재사용 불가)",
 *   "지연 연산(중간 연산은 최종 연산 호출 시 실행)" 특성을 가진다.
 * - 중간 연산(Intermediate Operation): filter, map, sorted 등 → Stream 반환
 * - 최종 연산(Terminal Operation): forEach, count, collect 등 → 결과 반환
 * =====================================================================
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class P01_StreamBasics {

    // ----------------------------------------------------------------
    // 문제 1: 컬렉션에서 스트림 생성 (stream())
    // ----------------------------------------------------------------
    /**
     * 【문제 1】 List에서 스트림 생성 후 출력
     *
     * 설명:
     *   정수 리스트 [10, 20, 30, 40, 50]을 생성한 뒤,
     *   stream()을 호출하여 스트림으로 변환하고
     *   forEach로 각 원소를 출력하시오.
     *
     * 예상 출력:
     *   10
     *   20
     *   30
     *   40
     *   50
     *
     * 힌트:
     *   List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
     *   list.stream().forEach(...)
     */
    static void problem1() {
        System.out.println("=== 문제 1: List에서 스트림 생성 ===");
        // TODO: 정수 리스트 [10, 20, 30, 40, 50] 생성

        // TODO: stream()으로 스트림 생성 후 forEach로 각 원소 출력

    }

    // ----------------------------------------------------------------
    // 문제 2: 배열에서 스트림 생성 (Arrays.stream, Stream.of)
    // ----------------------------------------------------------------
    /**
     * 【문제 2】 배열에서 두 가지 방식으로 스트림 생성
     *
     * 설명:
     *   (1) String 배열 {"사과", "바나나", "체리"}를 Arrays.stream()으로
     *       스트림을 생성하고 forEach로 출력하시오.
     *   (2) 같은 값을 Stream.of()로 스트림을 생성하고 forEach로 출력하시오.
     *
     * 예상 출력:
     *   --- Arrays.stream() ---
     *   사과
     *   바나나
     *   체리
     *   --- Stream.of() ---
     *   사과
     *   바나나
     *   체리
     *
     * 힌트:
     *   String[] arr = {"사과", "바나나", "체리"};
     *   Arrays.stream(arr).forEach(...)
     *   Stream.of("사과", "바나나", "체리").forEach(...)
     */
    static void problem2() {
        System.out.println("=== 문제 2: 배열에서 스트림 생성 ===");
        String[] fruits = {"사과", "바나나", "체리"};

        System.out.println("--- Arrays.stream() ---");
        // TODO: Arrays.stream()으로 스트림 생성 후 forEach 출력

        System.out.println("--- Stream.of() ---");
        // TODO: Stream.of()로 스트림 생성 후 forEach 출력

    }

    // ----------------------------------------------------------------
    // 문제 3: forEach, count, findFirst, findAny
    // ----------------------------------------------------------------
    /**
     * 【문제 3】 기본 최종 연산 활용
     *
     * 설명:
     *   문자열 리스트 ["Java", "Python", "C++", "Kotlin", "Go"]를 이용해
     *   다음을 각각 수행하시오.
     *   (1) forEach로 모든 원소를 출력한다.
     *   (2) count()로 원소 개수를 출력한다.
     *   (3) findFirst()로 첫 번째 원소를 Optional로 받아 출력한다.
     *   (4) findAny()로 임의의 원소를 Optional로 받아 출력한다.
     *       (순차 스트림에서는 보통 첫 번째 원소를 반환)
     *
     * 예상 출력:
     *   --- forEach ---
     *   Java
     *   Python
     *   C++
     *   Kotlin
     *   Go
     *   --- count ---
     *   원소 개수: 5
     *   --- findFirst ---
     *   첫 번째 원소: Java
     *   --- findAny ---
     *   임의 원소: Java
     *
     * 힌트:
     *   Optional<String> first = list.stream().findFirst();
     *   first.ifPresent(System.out::println);
     *   또는 first.get()으로 값 추출 (값이 없으면 예외 발생 주의)
     */
    static void problem3() {
        System.out.println("=== 문제 3: forEach / count / findFirst / findAny ===");
        List<String> languages = Arrays.asList("Java", "Python", "C++", "Kotlin", "Go");

        System.out.println("--- forEach ---");
        // TODO: forEach로 모든 원소 출력

        System.out.println("--- count ---");
        // TODO: count()로 원소 개수 출력 (형식: "원소 개수: X")

        System.out.println("--- findFirst ---");
        // TODO: findFirst()로 첫 번째 원소를 Optional로 받아 출력

        System.out.println("--- findAny ---");
        // TODO: findAny()로 임의 원소를 Optional로 받아 출력

    }

    // ----------------------------------------------------------------
    // 헬퍼 메소드
    // ----------------------------------------------------------------
    /** 구분선 출력 */
    static void printDivider() {}

    // ----------------------------------------------------------------
    // main 메소드
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }
}
