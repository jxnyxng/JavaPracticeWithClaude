/**
 * 파일명: P05_MethodReferences.java
 * 주제: 메소드 참조 (Method Reference)
 *
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. 람다 표현식을 메소드 참조로 대체하는 네 가지 형태를 이해한다.
 * 2. 정적/인스턴스/특정객체 메소드 참조를 상황에 맞게 활용할 수 있다.
 * 3. 생성자 참조(Constructor Reference)를 사용해 객체를 생성할 수 있다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [메소드 참조 4가지 형태]
 *
 * 1. 정적 메소드 참조 (Static Method Reference)
 *    형식: 클래스명::정적메소드명
 *    예시: Integer::parseInt   →   s -> Integer.parseInt(s)
 *
 * 2. 특정 인스턴스의 메소드 참조 (Bound Instance Method Reference)
 *    형식: 인스턴스변수::메소드명
 *    예시: myStr::startsWith   →   s -> myStr.startsWith(s)
 *    특징: 메소드를 호출할 인스턴스가 이미 고정되어 있음
 *
 * 3. 임의 인스턴스의 메소드 참조 (Unbound Instance Method Reference)
 *    형식: 클래스명::인스턴스메소드명
 *    예시: String::toUpperCase →   s -> s.toUpperCase()
 *    특징: 첫 번째 람다 매개변수가 메소드를 호출하는 객체
 *
 * 4. 생성자 참조 (Constructor Reference)
 *    형식: 클래스명::new
 *    예시: Person::new          →   name -> new Person(name)
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class P05_MethodReferences {

    public static void main(String[] args) {
        System.out.println("===== 메소드 참조 (Method Reference) =====\n");

        problem1_StaticMethodReference();
        problem2_UnboundInstanceMethodReference();
        problem3_BoundInstanceMethodReference();
        problem4_ConstructorReference();
    }

    // =====================================================
    // 문제 1: 정적 메소드 참조 (클래스명::정적메소드)
    // =====================================================
    /**
     * [문제 1] 정적 메소드 참조 (Static Method Reference)
     *
     * 설명:
     *   아래 람다 표현식을 메소드 참조로 변환하세요.
     *   형식: 클래스명::정적메소드명
     *
     *   변환 목록:
     *     1) s -> Integer.parseInt(s)          → Integer::parseInt
     *     2) s -> Double.parseDouble(s)        → Double::?
     *     3) s -> String.valueOf(s)            → String::?
     *     4) n -> Math.abs(n)                  → Math::?
     *     5) (a, b) -> Integer.max(a, b)       → Integer::?
     *     6) s -> System.out.println(s)        → System.out::println
     *        (주의: System.out은 인스턴스이므로 특정 인스턴스 참조)
     *
     *   목록에 적용:
     *     7) 문자열 숫자 목록을 Integer::parseInt로 변환
     *     8) 정수 목록을 Integer::max를 이용해 가장 큰 수 찾기
     *
     * 예상 출력:
     *   parseInt: 42
     *   parseDouble: 3.14
     *   valueOf: "100"
     *   abs(-7): 7
     *   max(10, 20): 20
     *   정수 변환: [1, 2, 3, 4, 5]
     *   최댓값: 99
     *
     * 힌트:
     *   - Function<String, Integer> parseInt = Integer::parseInt;
     *   - parseInt.apply("42")
     *   - 목록 변환은 반복문 + Function.apply() 사용
     */
    static void problem1_StaticMethodReference() {
        System.out.println("--- 문제 1: 정적 메소드 참조 ---");

        // TODO: Integer::parseInt 메소드 참조로 Function 구현
        Function<String, Integer> parseInt = null; // TODO: Integer::parseInt 사용

        // TODO: Double::parseDouble 메소드 참조로 Function 구현
        Function<String, Double> parseDouble = null; // TODO

        // TODO: String::valueOf 메소드 참조로 Function 구현
        Function<Integer, String> valueOf = null; // TODO

        // TODO: Math::abs 메소드 참조로 Function 구현
        Function<Integer, Integer> absRef = null; // TODO

        // TODO: Integer::max 메소드 참조로 BiFunction 구현
        BiFunction<Integer, Integer, Integer> maxRef = null; // TODO

        // TODO: System.out::println 메소드 참조로 Consumer 구현
        Consumer<String> printlnRef = null; // TODO

        // TODO: 각 결과 출력
        // System.out.println("parseInt: " + parseInt.apply("42"));
        // System.out.println("parseDouble: " + parseDouble.apply("3.14"));
        // System.out.println("valueOf: " + valueOf.apply(100));
        // System.out.println("abs(-7): " + absRef.apply(-7));
        // System.out.println("max(10, 20): " + maxRef.apply(10, 20));
        // printlnRef.accept("Consumer로 출력 테스트");

        // TODO: 문자열 숫자 목록을 Integer::parseInt 로 정수 변환 후 출력
        List<String> strNumbers = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("정수 변환: [");
        // TODO: 반복문으로 parseInt.apply() 호출하여 변환 결과 출력
        System.out.println("]");

        // TODO: 정수 목록에서 Integer::max를 이용해 최댓값 구하기
        List<Integer> numbers = Arrays.asList(33, 77, 99, 12, 54, 86);
        // TODO: 반복문으로 maxRef.apply() 를 사용해 최댓값 계산
        // System.out.println("최댓값: " + max);

        System.out.println();
    }

    // =====================================================
    // 문제 2: 임의 인스턴스의 메소드 참조 (클래스명::인스턴스메소드)
    // =====================================================
    /**
     * [문제 2] 임의 인스턴스의 메소드 참조 (Unbound Instance Method Reference)
     *
     * 설명:
     *   첫 번째 람다 매개변수가 메소드를 호출하는 대상이 되는 형태입니다.
     *   형식: 클래스명::인스턴스메소드명
     *
     *   변환 목록:
     *     1) s -> s.toUpperCase()          → String::toUpperCase
     *     2) s -> s.trim()                 → String::trim
     *     3) s -> s.length()               → String::length
     *     4) (s, prefix) -> s.startsWith(prefix) → String::startsWith
     *
     *   목록에 적용:
     *     5) 단어 목록을 String::toUpperCase로 모두 대문자 변환
     *     6) 단어 목록을 String::length로 길이 리스트 변환
     *     7) 단어 목록을 String::compareTo로 정렬 (Comparator로 사용)
     *
     * 예상 출력:
     *   대문자: HELLO
     *   공백제거: "hello"
     *   길이: 5
     *   startsWith("He"): true
     *   대문자 변환 목록: [APPLE, BANANA, CHERRY]
     *   길이 목록: [5, 6, 6]
     *   정렬 결과: [apple, banana, cherry]
     *
     * 힌트:
     *   - Function<String, String> upper = String::toUpperCase;
     *   - upper.apply("hello") → "HELLO"
     *   - Comparator<String> comp = String::compareTo;
     *   - List.sort(Comparator) 활용
     */
    static void problem2_UnboundInstanceMethodReference() {
        System.out.println("--- 문제 2: 임의 인스턴스 메소드 참조 ---");

        // TODO: String::toUpperCase 메소드 참조로 Function 구현
        Function<String, String> toUpperRef = null; // TODO

        // TODO: String::trim 메소드 참조로 Function 구현
        Function<String, String> trimRef = null; // TODO

        // TODO: String::length 메소드 참조로 Function 구현
        Function<String, Integer> lengthRef = null; // TODO

        // TODO: String::startsWith 메소드 참조로 BiFunction 구현
        BiFunction<String, String, Boolean> startsWithRef = null; // TODO

        // TODO: 각 결과 출력
        // System.out.println("대문자: " + toUpperRef.apply("hello"));
        // System.out.println("공백제거: " + trimRef.apply("  hello  "));
        // System.out.println("길이: " + lengthRef.apply("Hello"));
        // System.out.println("startsWith(\"He\"): " + startsWithRef.apply("Hello", "He"));

        List<String> words = Arrays.asList("cherry", "apple", "banana");

        // TODO: toUpperRef를 사용해 모든 단어를 대문자로 변환한 목록 출력
        System.out.print("대문자 변환 목록: [");
        // TODO
        System.out.println("]");

        // TODO: lengthRef를 사용해 각 단어의 길이 목록 출력
        System.out.print("길이 목록: [");
        // TODO
        System.out.println("]");

        // TODO: String::compareTo를 Comparator로 사용해 정렬
        List<String> toSort = Arrays.asList("cherry", "apple", "banana");
        Comparator<String> compareRef = null; // TODO: String::compareTo
        // toSort.sort(compareRef);
        // System.out.println("정렬 결과: " + toSort);

        System.out.println();
    }

    // =====================================================
    // 문제 3: 특정 인스턴스의 메소드 참조 (인스턴스변수::메소드)
    // =====================================================
    /**
     * [문제 3] 특정 인스턴스의 메소드 참조 (Bound Instance Method Reference)
     *
     * 설명:
     *   메소드를 호출할 인스턴스가 이미 고정된 형태입니다.
     *   형식: 인스턴스변수::인스턴스메소드명
     *
     *   구현 목록:
     *     1) 특정 문자열 인스턴스의 startsWith 메소드 참조
     *        String prefix = "Java";
     *        Predicate<String> startsWithJava = prefix::startsWith; // 오류! 반대 방향
     *        올바른 형태: s -> s.startsWith(prefix) 또는
     *                    prefix.equals()를 활용한 Predicate
     *
     *        실제 bound 예시:
     *        String target = "JavaProgramming";
     *        Predicate<String> containedInTarget = target::contains;
     *        → s -> target.contains(s)  (target이 s를 포함하는지)
     *
     *     2) 특정 StringBuilder 인스턴스의 append 메소드 참조
     *        Consumer<String>으로 활용
     *
     *     3) 특정 Comparator 인스턴스의 compare 메소드 참조
     *        (커스텀 비교기를 인스턴스로 만들어서 활용)
     *
     *     4) 목록에서 특정 문자열을 포함하는 단어 필터링
     *        (target::contains 활용)
     *
     * 예상 출력:
     *   target이 "Java" 포함? true
     *   target이 "Python" 포함? false
     *   StringBuilder 결과: "사과 바나나 체리 "
     *   길이순 정렬: [kiwi, apple, cherry, banana, durian]
     *   "an" 포함 단어: [banana, mango]
     *
     * 힌트:
     *   - String target = "JavaProgramming"; Predicate<String> p = target::contains;
     *   - StringBuilder sb = new StringBuilder(); Consumer<String> append = sb::append;
     *   - Comparator<String> byLength = Comparator.comparingInt(String::length);
     *     Comparator<String> boundComp = byLength::compare;
     */
    static void problem3_BoundInstanceMethodReference() {
        System.out.println("--- 문제 3: 특정 인스턴스 메소드 참조 ---");

        // TODO: target 문자열의 contains 메소드를 참조하는 Predicate 구현
        String target = "JavaProgramming";
        Predicate<String> containedInTarget = null; // TODO: target::contains

        // TODO: 결과 출력
        // System.out.println("target이 \"Java\" 포함? " + containedInTarget.test("Java"));
        // System.out.println("target이 \"Python\" 포함? " + containedInTarget.test("Python"));

        // TODO: StringBuilder 인스턴스의 append를 Consumer로 활용
        StringBuilder sb = new StringBuilder();
        Consumer<String> appendToSb = null; // TODO: sb::append

        List<String> fruits = Arrays.asList("사과", "바나나", "체리");
        // TODO: fruits 각 원소에 appendToSb 적용 (단어 + 공백 형태로)
        // System.out.println("StringBuilder 결과: " + sb.toString());

        // TODO: Comparator 인스턴스의 compare 메소드를 참조해 목록 정렬
        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> boundComp = null; // TODO: byLength::compare

        List<String> words = Arrays.asList("apple", "kiwi", "banana", "cherry", "durian");
        // words.sort(boundComp);
        // System.out.println("길이순 정렬: " + words);

        // TODO: "an"을 포함하는 단어 필터링 (target::contains 패턴 응용)
        String keyword = "an";
        Predicate<String> containsAn = null; // TODO: keyword::?? (힌트: 어떤 인스턴스의 어떤 메소드?)

        List<String> testWords = Arrays.asList("banana", "apple", "mango", "grape", "orange");
        System.out.print("\"an\" 포함 단어: [");
        // TODO: containsAn.test()를 사용해 필터링 후 출력
        System.out.println("]");

        System.out.println();
    }

    // =====================================================
    // 문제 4: 생성자 참조 (클래스명::new)
    // =====================================================
    /**
     * [문제 4] 생성자 참조 (Constructor Reference)
     *
     * 설명:
     *   아래 Person 클래스와 Box 클래스를 이용해 생성자 참조를 구현하세요.
     *   형식: 클래스명::new
     *
     *   구현 목록:
     *     1) Person 기본 생성자 참조: Supplier<Person>
     *        () -> new Person()   → Person::new
     *
     *     2) Person 이름 생성자 참조: Function<String, Person>
     *        name -> new Person(name)   → Person::new
     *
     *     3) Person 이름+나이 생성자 참조: BiFunction<String, Integer, Person>
     *        (name, age) -> new Person(name, age)   → Person::new
     *
     *     4) 이름 목록으로 Person 리스트 생성
     *        Function<String, Person>을 사용해 이름 목록 → Person 목록 변환
     *
     *     5) Box<String> 생성자 참조: Function<String, Box<String>>
     *
     * 예상 출력:
     *   기본 생성자: Person{name='이름없음', age=0}
     *   이름 생성자: Person{name='홍길동', age=0}
     *   이름+나이 생성자: Person{name='이순신', age=30}
     *   Person 목록:
     *     Person{name='김철수', age=0}
     *     Person{name='이영희', age=0}
     *     Person{name='박지성', age=0}
     *   Box 생성: Box{value='Hello Box'}
     *
     * 힌트:
     *   - Supplier<Person> personSupplier = Person::new; (기본 생성자)
     *   - Function<String, Person> personFactory = Person::new; (이름 생성자)
     *   - 오버로딩된 생성자는 매개변수 수/타입에 맞는 함수형 인터페이스로 자동 선택
     */
    static void problem4_ConstructorReference() {
        System.out.println("--- 문제 4: 생성자 참조 ---");

        // TODO: Person 기본 생성자를 참조하는 Supplier<Person> 구현
        Supplier<Person> personSupplier = null; // TODO: Person::new (기본 생성자)

        // TODO: Person 이름 생성자를 참조하는 Function<String, Person> 구현
        Function<String, Person> personFactory = null; // TODO: Person::new (이름 생성자)

        // TODO: Person 이름+나이 생성자를 참조하는 BiFunction<String, Integer, Person> 구현
        BiFunction<String, Integer, Person> personFullFactory = null; // TODO: Person::new

        // TODO: 각 생성자 참조로 Person 객체 생성 후 출력
        // Person p1 = personSupplier.get();
        // System.out.println("기본 생성자: " + p1);

        // Person p2 = personFactory.apply("홍길동");
        // System.out.println("이름 생성자: " + p2);

        // Person p3 = personFullFactory.apply("이순신", 30);
        // System.out.println("이름+나이 생성자: " + p3);

        // TODO: 이름 목록으로 Person 리스트 생성 (personFactory 활용)
        List<String> names = Arrays.asList("김철수", "이영희", "박지성");
        System.out.println("Person 목록:");
        // TODO: 반복문으로 personFactory.apply() 호출해 Person 생성 후 출력

        // TODO: Box<String> 생성자 참조로 Function<String, Box<String>> 구현
        Function<String, Box<String>> boxFactory = null; // TODO: Box::new

        // Box<String> box = boxFactory.apply("Hello Box");
        // System.out.println("Box 생성: " + box);

        System.out.println();
    }

    // =====================================================
    // 내부 클래스 정의 (수정 금지)
    // =====================================================

    /**
     * 생성자 참조 실습에 사용할 Person 클래스
     */
    static class Person {
        private String name;
        private int age;

        // 기본 생성자
        Person() {
            this.name = "이름없음";
            this.age = 0;
        }

        // 이름만 받는 생성자
        Person(String name) {
            this.name = name;
            this.age = 0;
        }

        // 이름과 나이를 받는 생성자
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge()     { return age; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    /**
     * 생성자 참조 실습에 사용할 제네릭 Box 클래스
     */
    static class Box<T> {
        private T value;

        Box(T value) {
            this.value = value;
        }

        public T getValue() { return value; }

        @Override
        public String toString() {
            return "Box{value='" + value + "'}";
        }
    }

    // =====================================================
    // 헬퍼 메소드 시그니처 (내용 직접 구현)
    // =====================================================

    /**
     * Function(메소드 참조 포함)을 사용해 문자열 목록을 변환
     * @param list      원본 문자열 목록
     * @param transform 각 원소에 적용할 변환 Function (메소드 참조 전달 가능)
     * @return 변환된 결과 목록
     */
    static <R> List<R> mapList(List<String> list, Function<String, R> transform) {
        // TODO: 반복문과 transform.apply()를 사용하여 구현
        return null;
    }

    /**
     * Predicate(메소드 참조 포함)를 사용해 문자열 목록 필터링
     * @param list      원본 문자열 목록
     * @param predicate 필터 조건 Predicate (메소드 참조 전달 가능)
     * @return 조건을 만족하는 원소만 담긴 목록
     */
    static List<String> filterList(List<String> list, Predicate<String> predicate) {
        // TODO: 반복문과 predicate.test()를 사용하여 구현
        return null;
    }
}
