/**
 * =====================================================================
 * 파일명: P05_AdvancedStreams.java
 * 주제: 스트림 심화
 * =====================================================================
 *
 * 【학습목표】
 * 1. flatMap()으로 중첩된 컬렉션(List<List<T>>)을 하나의 스트림으로 평탄화할 수 있다.
 * 2. mapToInt(), mapToDouble() 등 기본형 스트림(IntStream, DoubleStream)을 생성하고
 *    sum(), average() 등 수치 연산 메소드를 사용할 수 있다.
 * 3. Collectors.groupingBy()로 객체 리스트를 특정 속성 기준으로 그룹핑할 수 있다.
 * 4. Optional을 활용하여 null 안전하게 값을 처리할 수 있다.
 *
 * 【핵심개념】
 * - flatMap(Function<T, Stream<R>>): 각 원소를 스트림으로 변환한 뒤, 그 스트림들을
 *   하나의 스트림으로 합쳐(평탄화)서 반환하는 중간 연산.
 *   예) List<List<Integer>> → flatMap(Collection::stream) → Stream<Integer>
 *
 * - mapToInt(ToIntFunction<T>): 객체 스트림을 IntStream으로 변환.
 *   IntStream은 sum(), average(), min(), max(), count() 등 수치 전용 메소드 제공.
 *
 * - Collectors.groupingBy(classifier): 분류 함수 반환값을 키로 하는 Map<K, List<T>> 생성.
 *   두 번째 인자로 downstream Collector를 받아 집계 방식 지정 가능.
 *   예) .collect(Collectors.groupingBy(Student::getGrade))
 *
 * - Optional<T>: null을 직접 다루지 않고 값의 존재 여부를 명시적으로 표현하는 컨테이너.
 *   isPresent(), ifPresent(Consumer), orElse(T), orElseGet(Supplier), orElseThrow() 제공.
 * =====================================================================
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class P05_AdvancedStreams {

    // ----------------------------------------------------------------
    // 내부 클래스: Student (문제 3에서 사용)
    // ----------------------------------------------------------------
    /**
     * 학생 정보를 담는 클래스.
     * 이름(name), 점수(score), 학점(grade)을 가진다.
     * 학점은 점수에 따라 "A"(90이상), "B"(80이상), "C"(70이상), "D"(그 외)로 나뉜다.
     */
    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() { return name; }
        public int getScore() { return score; }

        /** 점수에 따른 학점 반환 (90이상: A, 80이상: B, 70이상: C, 그 외: D) */
        public String getGrade() {
            // TODO: 점수에 따라 "A", "B", "C", "D" 반환
            return "";
        }

        @Override
        public String toString() {
            return name + "(" + score + ")";
        }
    }

    // ----------------------------------------------------------------
    // 문제 1: flatMap으로 중첩 컬렉션 평탄화
    // ----------------------------------------------------------------
    /**
     * 【문제 1】 flatMap()으로 중첩 리스트 펼치기
     *
     * 설명:
     *   List<List<Integer>>가 [[1, 2, 3], [4, 5], [6, 7, 8, 9]]처럼
     *   중첩되어 있을 때, flatMap()으로 하나의 스트림으로 평탄화하여
     *   모든 원소를 오름차순으로 정렬한 뒤 출력하시오.
     *
     *   추가로, 문장 리스트 ["Hello World", "Java Stream", "flatMap Example"]에서
     *   각 문장을 공백(" ")으로 분리하여 모든 단어를 하나의 리스트로 만들어 출력하시오.
     *
     * 예상 출력:
     *   평탄화 후 정렬: [1, 2, 3, 4, 5, 6, 7, 8, 9]
     *   모든 단어: [Hello, World, Java, Stream, flatMap, Example]
     *
     * 힌트:
     *   nestedList.stream().flatMap(List::stream).sorted().collect(...)
     *   sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(...)
     */
    static void problem1() {
        System.out.println("=== 문제 1: flatMap() 중첩 컬렉션 평탄화 ===");
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        List<String> sentences = Arrays.asList("Hello World", "Java Stream", "flatMap Example");

        // TODO: nestedList를 flatMap으로 평탄화 후 정렬하여 출력 (형식: "평탄화 후 정렬: [...]")

        // TODO: sentences를 단어 단위로 분리하여 하나의 리스트로 출력 (형식: "모든 단어: [...]")

    }

    // ----------------------------------------------------------------
    // 문제 2: mapToInt, mapToDouble → IntStream, sum/average
    // ----------------------------------------------------------------
    /**
     * 【문제 2】 기본형 스트림(IntStream, DoubleStream) 활용
     *
     * 설명:
     *   학생 점수 리스트 [85, 92, 78, 95, 60, 73, 88, 91]을 이용하여
     *   (1) mapToInt()로 IntStream을 생성하고 sum()으로 총점을 출력하시오.
     *   (2) mapToDouble()로 DoubleStream을 생성하고 average()로 평균을 출력하시오.
     *       (OptionalDouble 반환 → ifPresent로 출력)
     *   (3) IntStream의 min()과 max()로 최저점과 최고점을 출력하시오.
     *
     *   문자열 리스트 ["apple", "banana", "fig", "kiwi"]에서
     *   (4) mapToInt(String::length)로 문자열 길이의 합계를 출력하시오.
     *
     * 예상 출력:
     *   총점: 662
     *   평균: 82.75
     *   최저점: 60
     *   최고점: 95
     *   문자열 길이 합계: 19
     *
     * 힌트:
     *   List<Integer> scores = ...;
     *   scores.stream().mapToInt(Integer::intValue).sum()
     *   scores.stream().mapToDouble(Integer::doubleValue).average()
     *   OptionalDouble avg = ...; avg.ifPresent(v -> ...)
     */
    static void problem2() {
        System.out.println("=== 문제 2: mapToInt / mapToDouble 기본형 스트림 ===");
        List<Integer> scores = Arrays.asList(85, 92, 78, 95, 60, 73, 88, 91);
        List<String> fruits = Arrays.asList("apple", "banana", "fig", "kiwi");

        // TODO: mapToInt로 총점 계산 후 출력 (형식: "총점: X")

        // TODO: mapToDouble로 평균 계산 후 출력 (형식: "평균: X.XX")

        // TODO: min()으로 최저점 출력 (형식: "최저점: X")

        // TODO: max()로 최고점 출력 (형식: "최고점: X")

        // TODO: 문자열 길이 합계 출력 (형식: "문자열 길이 합계: X")

    }

    // ----------------------------------------------------------------
    // 문제 3: 학생 리스트에서 성적별 그룹핑 (groupingBy)
    // ----------------------------------------------------------------
    /**
     * 【문제 3】 객체 스트림과 groupingBy 심화 활용
     *
     * 설명:
     *   아래 학생 데이터를 Student 객체로 만든 뒤,
     *   (1) Collectors.groupingBy(Student::getGrade)로
     *       학점별로 그룹핑하여 Map<String, List<Student>>를 생성하고 출력하시오.
     *   (2) 각 학점 그룹별 학생 수를 출력하시오.
     *       (Collectors.groupingBy + Collectors.counting() 활용)
     *   (3) 학점별 평균 점수를 출력하시오.
     *       (Collectors.groupingBy + Collectors.averagingInt() 활용)
     *
     *   학생 데이터:
     *   {"홍길동", 92}, {"김철수", 85}, {"이영희", 78}, {"박민준", 95},
     *   {"최수진", 63}, {"정다은", 88}, {"강준혁", 72}, {"윤소희", 91}
     *
     * 예상 출력 (키 순서는 다를 수 있음):
     *   학점별 그룹핑:
     *   A학점: [홍길동(92), 박민준(95), 윤소희(91)]
     *   B학점: [김철수(85), 정다은(88)]
     *   C학점: [이영희(78), 강준혁(72)]
     *   D학점: [최수진(63)]
     *
     *   학점별 학생 수:
     *   {A=3, B=2, C=2, D=1}
     *
     *   학점별 평균 점수:
     *   {A=92.67, B=86.5, C=75.0, D=63.0}
     *
     * 힌트:
     *   Map<String, List<Student>> grouped = students.stream()
     *       .collect(Collectors.groupingBy(Student::getGrade));
     *   grouped.forEach((grade, list) -> System.out.println(grade + "학점: " + list));
     *   Collectors.groupingBy(Student::getGrade, Collectors.counting())
     *   Collectors.groupingBy(Student::getGrade, Collectors.averagingInt(Student::getScore))
     */
    static void problem3() {
        System.out.println("=== 문제 3: 학생 성적 그룹핑 (groupingBy) ===");
        List<Student> students = Arrays.asList(
            new Student("홍길동", 92),
            new Student("김철수", 85),
            new Student("이영희", 78),
            new Student("박민준", 95),
            new Student("최수진", 63),
            new Student("정다은", 88),
            new Student("강준혁", 72),
            new Student("윤소희", 91)
        );

        // TODO: 먼저 Student.getGrade()를 구현하시오 (상단 내부 클래스 참고)

        System.out.println("학점별 그룹핑:");
        // TODO: groupingBy(Student::getGrade)로 그룹핑 후 각 학점별 학생 목록 출력

        System.out.println("\n학점별 학생 수:");
        // TODO: groupingBy + Collectors.counting()으로 학점별 학생 수 출력

        System.out.println("\n학점별 평균 점수:");
        // TODO: groupingBy + Collectors.averagingInt(Student::getScore)로 학점별 평균 출력

    }

    // ----------------------------------------------------------------
    // 문제 4: Optional로 null 안전하게 처리
    // ----------------------------------------------------------------
    /**
     * 【문제 4】 Optional 활용 — null 안전 처리
     *
     * 설명:
     *   (1) Optional.of(), Optional.ofNullable(), Optional.empty()의 차이를 이해하고,
     *       각각 생성 후 isPresent()와 isEmpty()로 값 존재 여부를 출력하시오.
     *
     *   (2) 문자열 리스트 ["Java", "Python", null, "C++", null, "Go"]에서
     *       null인 원소를 제거하고 남은 원소들을 출력하시오.
     *       (filter(Objects::nonNull) 활용)
     *
     *   (3) 스트림에서 "Kotlin"을 찾아 Optional로 반환받은 뒤,
     *       값이 있으면 출력하고, 없으면 "찾을 수 없음"을 출력하시오.
     *       orElse() 또는 ifPresentOrElse()를 활용한다.
     *
     * 예상 출력:
     *   --- Optional 생성 ---
     *   of("hello") 존재 여부: true
     *   ofNullable(null) 존재 여부: false
     *   empty() isEmpty: true
     *   --- null 제거 ---
     *   null 제거 후: [Java, Python, C++, Go]
     *   --- findFirst + Optional ---
     *   Java 검색 결과: Java
     *   Kotlin 검색 결과: 찾을 수 없음
     *
     * 힌트:
     *   Optional<String> opt = Optional.of("hello");
     *   opt.isPresent()  → true/false
     *   Optional.ofNullable(null).isEmpty()
     *   .filter(Objects::nonNull).collect(Collectors.toList())
     *   list.stream().filter(s -> "Kotlin".equals(s)).findFirst()
     *   .orElse("찾을 수 없음")
     */
    static void problem4() {
        System.out.println("=== 문제 4: Optional null 안전 처리 ===");

        System.out.println("--- Optional 생성 ---");
        // TODO: Optional.of("hello") 생성 후 isPresent() 출력 (형식: "of(\"hello\") 존재 여부: true")

        // TODO: Optional.ofNullable(null) 생성 후 isPresent() 출력

        // TODO: Optional.empty() 생성 후 isEmpty() 출력

        System.out.println("--- null 제거 ---");
        List<String> listWithNulls = Arrays.asList("Java", "Python", null, "C++", null, "Go");
        // TODO: filter(Objects::nonNull)으로 null 제거 후 출력 (형식: "null 제거 후: [...]")

        System.out.println("--- findFirst + Optional ---");
        List<String> languages = Arrays.asList("Java", "Python", "C++", "Go");
        // TODO: "Java" 검색 → findFirst() → orElse로 없으면 "찾을 수 없음" 출력

        // TODO: "Kotlin" 검색 → findFirst() → orElse로 없으면 "찾을 수 없음" 출력

    }

    // ----------------------------------------------------------------
    // 헬퍼 메소드
    // ----------------------------------------------------------------
    /** Student 리스트에서 특정 학점(grade)의 학생만 반환 */
    static List<Student> filterByGrade(List<Student> students, String grade) { return null; }

    /** Student 리스트의 평균 점수를 OptionalDouble로 반환 */
    static OptionalDouble averageScore(List<Student> students) { return OptionalDouble.empty(); }

    /** null이 포함된 문자열 리스트에서 null을 제거하여 반환 */
    static List<String> removeNulls(List<String> list) { return null; }

    // ----------------------------------------------------------------
    // main 메소드
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
        System.out.println();
        problem4();
    }
}
