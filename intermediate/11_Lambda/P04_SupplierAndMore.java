/**
 * 파일명: P04_SupplierAndMore.java
 * 주제: Supplier, BiFunction 및 함수형 인터페이스 조합 활용
 *
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. Supplier<T>의 지연 평가(Lazy Evaluation) 개념과 활용법을 이해한다.
 * 2. BiFunction<T,U,R>을 사용하여 두 입력을 받아 처리하는 람다를 작성할 수 있다.
 * 3. 여러 함수형 인터페이스를 조합하여 실용적인 예제를 구현할 수 있다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [Supplier<T>]
 * - 입력 없이 T 타입 값을 공급(반환)하는 함수형 인터페이스
 * - 핵심 메소드: T get()
 * - 지연 평가: get()이 호출될 때까지 값 생성을 미룸
 * - 활용: 객체 팩토리, 기본값 제공, 비용이 큰 연산의 지연 실행
 *
 * [BiFunction<T, U, R>]
 * - T와 U 두 가지 타입의 입력을 받아 R 타입을 반환
 * - 핵심 메소드: R apply(T t, U u)
 * - andThen(Function<R,V>) 으로 후속 처리 가능
 *
 * [지연 평가(Lazy Evaluation)란?]
 * - 값이 실제로 필요한 시점까지 계산을 미루는 전략
 * - Supplier를 통해 "나중에 필요할 때 get() 호출" 패턴으로 구현
 * - 조건부 실행, 메모이제이션, Optional의 orElseGet() 등에 활용
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class P04_SupplierAndMore {

    public static void main(String[] args) {
        System.out.println("===== Supplier, BiFunction 및 조합 =====\n");

        problem1_SupplierLazy();
        problem2_BiFunction();
        problem3_CombinedExample();
    }

    // =====================================================
    // 문제 1: Supplier<T> get 메소드와 지연 평가
    // =====================================================
    /**
     * [문제 1] Supplier<T>의 get() 메소드와 지연 평가
     *
     * 설명:
     *   Supplier를 이용한 다양한 지연 평가 패턴을 구현하세요.
     *
     *   기본 사용:
     *     1) 고정 문자열을 반환하는 Supplier<String>
     *     2) 현재 시각(밀리초)을 반환하는 Supplier<Long> (get() 호출 시마다 새로운 값)
     *     3) 1~100 사이 랜덤 정수를 반환하는 Supplier<Integer>
     *
     *   지연 평가 패턴:
     *     4) 아래 메소드 getValueOrDefault()를 Supplier를 활용해 완성하세요.
     *        조건: value가 null이면 defaultSupplier.get()을 호출해 반환
     *              value가 null이 아니면 value를 그대로 반환
     *
     *   비교:
     *     5) 즉시 평가 vs 지연 평가 차이를 출력으로 확인
     *        (get()을 두 번 호출해 다른 값이 나오는 것을 확인)
     *
     * 예상 출력:
     *   고정 문자열: "Hello Supplier"
     *   시각1 != 시각2 (지연 평가로 다른 값)
     *   랜덤 값 (1~100 사이): N
     *   null 대신 기본값: "기본값입니다"
     *   실제값 우선: "실제 데이터"
     *
     * 힌트:
     *   - Supplier<String> s = () -> "Hello";
     *   - System.currentTimeMillis()로 현재 시각 조회
     *   - new Random().nextInt(100) + 1
     */
    static void problem1_SupplierLazy() {
        System.out.println("--- 문제 1: Supplier와 지연 평가 ---");

        // TODO: 고정 문자열 "Hello Supplier" 반환하는 Supplier 구현
        Supplier<String> fixedStr = null; // TODO
        // System.out.println("고정 문자열: " + fixedStr.get());

        // TODO: 현재 시각(밀리초)를 반환하는 Supplier 구현
        Supplier<Long> currentTime = null; // TODO
        // long time1 = currentTime.get();
        // long time2 = currentTime.get();
        // System.out.println("시각1: " + time1);
        // System.out.println("시각2: " + time2);

        // TODO: 1~100 사이의 랜덤 정수를 반환하는 Supplier 구현
        Supplier<Integer> randomInt = null; // TODO
        // System.out.println("랜덤 값 (1~100 사이): " + randomInt.get());

        // TODO: getValueOrDefault() 메소드를 호출하는 예시 코드 작성
        // null인 경우 → 기본값 반환
        // String result1 = getValueOrDefault(null, () -> "기본값입니다");
        // System.out.println("null 대신 기본값: " + result1);

        // null이 아닌 경우 → 실제값 반환 (Supplier.get() 호출 안 함)
        // String result2 = getValueOrDefault("실제 데이터", () -> "기본값입니다");
        // System.out.println("실제값 우선: " + result2);

        System.out.println();
    }

    // =====================================================
    // 문제 2: BiFunction<T,U,R>으로 두 입력 처리
    // =====================================================
    /**
     * [문제 2] BiFunction<T,U,R>의 apply 메소드와 andThen 활용
     *
     * 설명:
     *   두 개의 입력을 처리하는 BiFunction을 구현하세요.
     *
     *   기본 BiFunction 구현:
     *     1) (문자열, 정수) -> 문자열을 정수 횟수만큼 반복한 결과 반환
     *        BiFunction<String, Integer, String>
     *     2) (이름, 나이) -> "이름: OOO, 나이: N세" 형식의 문자열 반환
     *        BiFunction<String, Integer, String>
     *     3) (정수 리스트, 기준값) -> 기준값보다 큰 수의 개수 반환
     *        BiFunction<List<Integer>, Integer, Long>
     *
     *   andThen 조합:
     *     4) BiFunction에 andThen(Function)으로 후속 처리 추가
     *        (이름, 나이) 문자열 생성 후 대문자로 변환
     *
     * 예상 출력:
     *   "ab" 3회 반복: ababab
     *   인물 정보: 이름: 홍길동, 나이: 25세
     *   기준(5) 초과 개수: 4
     *   대문자 변환: 이름: 홍길동, 나이: 25세  (대문자는 영문에서 확인)
     *
     * 힌트:
     *   - String.repeat(n) (자바 11+) 또는 반복문 사용
     *   - BiFunction<T,U,R>.andThen(Function<R,V>) 로 체이닝
     */
    static void problem2_BiFunction() {
        System.out.println("--- 문제 2: BiFunction ---");

        // TODO: (문자열, 반복횟수) -> 반복된 문자열 반환하는 BiFunction 구현
        BiFunction<String, Integer, String> repeatStr = null; // TODO

        // TODO: (이름, 나이) -> "이름: OOO, 나이: N세" 반환하는 BiFunction 구현
        BiFunction<String, Integer, String> personInfo = null; // TODO

        // TODO: (정수 리스트, 기준값) -> 기준값 초과 수의 개수 반환하는 BiFunction 구현
        BiFunction<List<Integer>, Integer, Long> countGreaterThan = null; // TODO

        // TODO: 각 BiFunction apply() 결과 출력
        // System.out.println("\"ab\" 3회 반복: " + repeatStr.apply("ab", 3));
        // System.out.println("인물 정보: " + personInfo.apply("홍길동", 25));

        // List<Integer> nums = Arrays.asList(1, 3, 5, 7, 9, 2, 4);
        // System.out.println("기준(5) 초과 개수: " + countGreaterThan.apply(nums, 5));

        // TODO: andThen 조합: personInfo 결과를 대문자(영문) 변환
        // BiFunction<String, Integer, String> personInfoUpper = personInfo.andThen(...);
        // System.out.println("andThen 결과: " + personInfoUpper.apply("Tom", 30));

        System.out.println();
    }

    // =====================================================
    // 문제 3: 함수형 인터페이스 조합 예제
    // =====================================================
    /**
     * [문제 3] 함수형 인터페이스를 조합한 실용 예제
     *
     * 설명:
     *   여러 함수형 인터페이스를 조합하여 데이터 처리 파이프라인을 구성하세요.
     *
     *   시나리오: 학생 점수 처리 시스템
     *     - 입력 데이터: 학생 이름(String), 점수(Integer) 목록
     *     - 처리 파이프라인:
     *       1) Predicate: 점수가 60점 이상인 학생 필터링 (합격 기준)
     *       2) Function: 점수를 등급 문자열로 변환
     *                    90 이상=A, 80 이상=B, 70 이상=C, 60 이상=D, 미만=F
     *       3) BiFunction: (이름, 점수) -> "이름: OOO [등급: X]" 형식 문자열 생성
     *       4) Consumer: 결과 문자열 출력
     *       5) Supplier: 전체 학생 목록을 제공하는 데이터 소스 역할
     *
     *   추가 미니 예제:
     *     6) Supplier로 랜덤 비밀번호 생성기 구현
     *        (영문 대소문자 + 숫자로 구성된 8자리 랜덤 문자열)
     *
     * 예상 출력:
     *   === 합격 학생 성적표 ===
     *   학생: 홍길동 [점수: 85, 등급: B]
     *   학생: 이순신 [점수: 92, 등급: A]
     *   학생: 강감찬 [점수: 71, 등급: C]
     *   학생: 유관순 [점수: 60, 등급: D]
     *   (55점 김철수는 합격 기준 미달로 제외)
     *   랜덤 비밀번호: Xk3mP9aQ (8자리)
     *
     * 힌트:
     *   - 데이터는 String[] names, int[] scores 배열로 준비
     *   - Predicate<Integer> passCheck = score -> score >= 60;
     *   - Function<Integer, String> toGrade = score -> score >= 90 ? "A" : ...
     *   - BiFunction<String, Integer, String> report = (name, score) -> ...
     */
    static void problem3_CombinedExample() {
        System.out.println("--- 문제 3: 함수형 인터페이스 조합 예제 ---");

        // 학생 데이터 (변경하지 마세요)
        String[] names  = {"홍길동", "김철수", "이순신", "강감찬", "유관순"};
        int[]    scores = {85,       55,       92,       71,       60};

        // TODO: 점수 60 이상 합격 여부를 검사하는 Predicate<Integer> 구현
        Predicate<Integer> passCheck = null; // TODO

        // TODO: 점수를 등급 문자열(A/B/C/D/F)로 변환하는 Function<Integer, String> 구현
        Function<Integer, String> toGrade = null; // TODO

        // TODO: (이름, 점수) -> "학생: OOO [점수: N, 등급: X]" 형식 반환하는 BiFunction 구현
        BiFunction<String, Integer, String> reportLine = null; // TODO

        // TODO: 문자열을 출력하는 Consumer<String> 구현
        Consumer<String> printer = null; // TODO

        // TODO: 학생 목록 전체를 인덱스 배열로 공급하는 Supplier<int[]> 구현
        //       (단순히 {0,1,2,3,4} 인덱스 배열을 반환)
        Supplier<int[]> indexSupplier = null; // TODO

        System.out.println("=== 합격 학생 성적표 ===");
        // TODO: indexSupplier.get()으로 인덱스 배열을 가져온 뒤,
        //       각 인덱스에 대해 passCheck, toGrade, reportLine, printer를 조합하여 출력

        System.out.println();

        // TODO: 랜덤 비밀번호 생성기 (8자리, 영문 대소문자 + 숫자)
        Supplier<String> passwordGen = null; // TODO: 랜덤 8자리 문자열 생성

        // System.out.println("랜덤 비밀번호: " + passwordGen.get());

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 시그니처 (내용 직접 구현)
    // =====================================================

    /**
     * value가 null이면 defaultSupplier.get()을 호출해 기본값 반환,
     * null이 아니면 value를 그대로 반환 (Optional.orElseGet과 유사)
     *
     * @param value           검사할 값 (null 가능)
     * @param defaultSupplier null일 때 기본값을 제공하는 Supplier
     * @return value 또는 defaultSupplier.get() 결과
     */
    static <T> T getValueOrDefault(T value, Supplier<T> defaultSupplier) {
        // TODO: value가 null이면 defaultSupplier.get() 반환, 아니면 value 반환
        return null;
    }

    /**
     * BiFunction으로 두 리스트를 각 인덱스 위치에서 합산한 결과 리스트 반환
     * 두 리스트 길이가 같다고 가정
     *
     * @param list1    첫 번째 정수 리스트
     * @param list2    두 번째 정수 리스트
     * @param combiner (정수, 정수) -> 결과를 반환하는 BiFunction
     * @return 각 위치 원소가 combiner로 처리된 결과 리스트
     */
    static List<Integer> zipWith(List<Integer> list1,
                                  List<Integer> list2,
                                  BiFunction<Integer, Integer, Integer> combiner) {
        // TODO: 두 리스트를 같은 인덱스로 묶어 combiner.apply() 호출 후 결과 리스트 반환
        return null;
    }
}
