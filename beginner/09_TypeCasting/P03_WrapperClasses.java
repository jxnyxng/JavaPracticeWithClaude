/*
 * ========================================================
 * 파일명: P03_WrapperClasses.java
 * 주제: 래퍼 클래스 (Wrapper Classes)
 * ========================================================
 *
 * [학습목표]
 * 1. 기본 타입과 래퍼 클래스의 관계를 이해하고 오토박싱/언박싱을 설명할 수 있다.
 * 2. String과 기본 타입 사이의 변환 메소드를 활용할 수 있다.
 * 3. 래퍼 클래스에서 제공하는 유용한 상수와 유틸리티 메소드를 활용할 수 있다.
 *
 * [핵심개념]
 * - 래퍼 클래스(Wrapper Class):
 *   기본 타입(primitive type)을 객체로 감싸는 클래스
 *   기본타입 → 래퍼클래스 대응:
 *     byte    → Byte
 *     short   → Short
 *     int     → Integer
 *     long    → Long
 *     float   → Float
 *     double  → Double
 *     char    → Character
 *     boolean → Boolean
 *
 * - 오토박싱(AutoBoxing): 기본 타입 → 래퍼 클래스 자동 변환
 *   예) Integer obj = 42;  // int 42가 Integer 객체로 자동 박싱
 *
 * - 언박싱(Unboxing): 래퍼 클래스 → 기본 타입 자동 변환
 *   예) int val = obj;  // Integer 객체가 int로 자동 언박싱
 *
 * - String 변환:
 *   String → int: Integer.parseInt("123")
 *   String → double: Double.parseDouble("3.14")
 *   int → String: String.valueOf(123) 또는 Integer.toString(123)
 *
 * - 유용한 상수:
 *   Integer.MAX_VALUE  = 2,147,483,647
 *   Integer.MIN_VALUE  = -2,147,483,648
 *   Double.MAX_VALUE, Double.MIN_VALUE
 * ========================================================
 */
public class P03_WrapperClasses {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: 오토박싱과 언박싱
        // ============================================================
        /*
         * [문제 1] Integer, Double, Boolean 오토박싱/언박싱 확인
         *
         * 설명:
         *   Java 5부터 기본 타입과 래퍼 클래스 사이의 변환이 자동으로 이루어집니다.
         *   이를 오토박싱(boxing)과 언박싱(unboxing)이라 합니다.
         *
         * 요구사항:
         *   1) int → Integer 오토박싱 후 출력
         *   2) Integer → int 언박싱 후 출력
         *   3) double → Double 오토박싱
         *   4) Double → double 언박싱
         *   5) boolean → Boolean, Boolean → boolean 오토박싱/언박싱
         *   6) Integer 객체 두 개의 == 비교와 .equals() 비교 결과 출력
         *      (== 는 참조 비교, equals()는 값 비교임을 확인)
         *
         * 예상 출력:
         *   오토박싱: int 42 → Integer 42
         *   언박싱:  Integer 100 → int 100
         *   Double 오토박싱/언박싱: 3.14
         *   Boolean 오토박싱/언박싱: true
         *   Integer 100 == Integer 100 (별도 객체): false
         *   Integer 100 .equals() Integer 100: true
         *
         * 힌트:
         *   - Integer obj = 42; // 오토박싱
         *   - int val = obj;    // 언박싱
         *   - Integer a = new Integer(100); Integer b = new Integer(100);
         *   - a == b → false (다른 객체), a.equals(b) → true (같은 값)
         *   - 주의: Integer a = 127; Integer b = 127; a == b → true (캐싱 범위)
         *           Integer a = 128; Integer b = 128; a == b → false (캐싱 범위 초과)
         */
        System.out.println("=== 문제 1: 오토박싱과 언박싱 ===");

        // TODO: int를 Integer로 오토박싱

        // TODO: Integer를 int로 언박싱

        // TODO: double → Double 오토박싱

        // TODO: Double → double 언박싱

        // TODO: boolean → Boolean, Boolean → boolean 오토박싱/언박싱

        // TODO: Integer 객체 두 개 생성하여 == 과 .equals() 비교

        System.out.println();

        // ============================================================
        // 문제 2: String → 기본 타입 변환
        // ============================================================
        /*
         * [문제 2] 문자열을 기본 타입으로 파싱
         *
         * 설명:
         *   사용자 입력이나 파일에서 읽은 데이터는 문자열(String) 형태입니다.
         *   이를 숫자나 다른 타입으로 변환하려면 parse 메소드를 사용합니다.
         *
         * 요구사항:
         *   1) "123"을 int로 변환 (Integer.parseInt)
         *   2) "3.14"를 double로 변환 (Double.parseDouble)
         *   3) "true"를 boolean으로 변환 (Boolean.parseBoolean)
         *   4) "9876543210"을 long으로 변환 (Long.parseLong)
         *   5) 변환된 숫자들로 사칙연산 수행
         *   6) 잘못된 형식의 문자열을 변환하면 NumberFormatException이 발생함을
         *      try-catch로 처리하는 예시 작성
         *
         * 예상 출력:
         *   "123" → int: 123
         *   "3.14" → double: 3.14
         *   "true" → boolean: true
         *   "9876543210" → long: 9876543210
         *   123 + 3.14 = 126.14
         *   잘못된 변환 시도: "abc" → NumberFormatException 발생!
         *
         * 힌트:
         *   - Integer.parseInt("123") → 123
         *   - Double.parseDouble("3.14") → 3.14
         *   - Boolean.parseBoolean("true") → true (대소문자 무관)
         *   - try { int n = Integer.parseInt("abc"); }
         *     catch (NumberFormatException e) { ... }
         */
        System.out.println("=== 문제 2: String → 기본 타입 변환 ===");

        // TODO: "123" 을 int로 파싱 후 출력

        // TODO: "3.14"를 double로 파싱 후 출력

        // TODO: "true"를 boolean으로 파싱 후 출력

        // TODO: "9876543210"을 long으로 파싱 후 출력

        // TODO: 파싱된 int + double 계산 후 출력

        // TODO: try-catch로 잘못된 문자열 변환 예외 처리

        System.out.println();

        // ============================================================
        // 문제 3: int → String 변환
        // ============================================================
        /*
         * [문제 3] 기본 타입을 문자열로 변환하는 다양한 방법
         *
         * 설명:
         *   숫자를 문자열로 변환하는 방법은 여러 가지가 있습니다.
         *   각각의 특징을 이해하세요.
         *
         * 요구사항:
         *   정수 42에 대해 다음 4가지 방법으로 String 변환 후 출력:
         *   1) String.valueOf(42)
         *   2) Integer.toString(42)
         *   3) "" + 42  (문자열 연결)
         *   4) String.format("%d", 42)
         *
         *   추가로:
         *   5) double 3.14를 String으로 변환 (String.valueOf)
         *   6) 변환된 String의 length() 확인 (문자열 길이 출력)
         *   7) 정수를 다른 진수(2진, 8진, 16진) 문자열로 변환
         *
         * 예상 출력:
         *   String.valueOf(42): "42" (길이: 2)
         *   Integer.toString(42): "42" (길이: 2)
         *   "" + 42: "42" (길이: 2)
         *   String.format: "42" (길이: 2)
         *   String.valueOf(3.14): "3.14"
         *   255의 2진수: 11111111
         *   255의 8진수: 377
         *   255의 16진수: ff
         *
         * 힌트:
         *   - String.valueOf(값): 모든 기본 타입에 사용 가능
         *   - Integer.toBinaryString(n): n의 2진수 문자열
         *   - Integer.toOctalString(n): n의 8진수 문자열
         *   - Integer.toHexString(n): n의 16진수 문자열
         */
        System.out.println("=== 문제 3: int → String 변환 방법 ===");

        // TODO: String.valueOf(42) 출력 및 길이 확인

        // TODO: Integer.toString(42) 출력 및 길이 확인

        // TODO: "" + 42 출력 및 길이 확인

        // TODO: String.format("%d", 42) 출력 및 길이 확인

        // TODO: double 3.14를 String으로 변환

        // TODO: 255를 2진수, 8진수, 16진수 문자열로 변환 출력

        System.out.println();

        // ============================================================
        // 문제 4: 래퍼 클래스의 유용한 상수와 메소드
        // ============================================================
        /*
         * [문제 4] 래퍼 클래스에서 제공하는 상수와 유틸리티 메소드 활용
         *
         * 설명:
         *   각 래퍼 클래스는 해당 타입의 최댓값, 최솟값 등 유용한 상수와
         *   다양한 유틸리티 메소드를 제공합니다.
         *
         * 요구사항:
         *   1) 각 정수 타입의 MAX_VALUE, MIN_VALUE 출력
         *      (Byte, Short, Integer, Long)
         *   2) Integer.toBinaryString(255): 255를 2진수로
         *   3) Integer.toHexString(255): 255를 16진수로
         *   4) Integer.bitCount(255): 1인 비트 개수 출력
         *   5) Double.isNaN(0.0/0.0): NaN 확인
         *   6) Double.isInfinite(1.0/0.0): 무한대 확인
         *   7) Integer.compare(10, 20): 두 정수 비교 (-1, 0, 1)
         *   8) Integer.sum(10, 20), Integer.max(10, 20), Integer.min(10, 20)
         *
         * 예상 출력:
         *   Byte: -128 ~ 127
         *   Short: -32768 ~ 32767
         *   Integer: -2147483648 ~ 2147483647
         *   Long: -9223372036854775808 ~ 9223372036854775807
         *   255의 2진수: 11111111
         *   255의 16진수: ff
         *   255에서 1인 비트 수: 8
         *   0.0/0.0 is NaN: true
         *   1.0/0.0 is Infinite: true
         *   compare(10, 20): -1
         *   sum(10, 20): 30, max(10, 20): 20, min(10, 20): 10
         *
         * 힌트:
         *   - Byte.MAX_VALUE, Byte.MIN_VALUE
         *   - Integer.MAX_VALUE = 2^31 - 1 = 2147483647
         *   - Double.NaN, Double.POSITIVE_INFINITY
         *   - Integer.compare(a, b): a < b → -1, a == b → 0, a > b → 1
         */
        System.out.println("=== 문제 4: 래퍼 클래스 상수와 유틸리티 메소드 ===");

        // TODO: Byte, Short, Integer, Long의 MAX_VALUE, MIN_VALUE 출력

        // TODO: 255의 2진수 문자열 출력

        // TODO: 255의 16진수 문자열 출력

        // TODO: 255에서 1인 비트 수 출력 (Integer.bitCount)

        // TODO: 0.0/0.0 이 NaN인지 확인 (Double.isNaN)

        // TODO: 1.0/0.0 이 무한대인지 확인 (Double.isInfinite)

        // TODO: Integer.compare(10, 20) 결과 출력

        // TODO: Integer.sum, Integer.max, Integer.min 결과 출력

    } // main 끝

    /*
     * 헬퍼 메소드: 문자열이 정수로 변환 가능한지 확인
     * @param str 확인할 문자열
     * @return 변환 가능하면 true, 불가능하면 false
     */
    static boolean isNumeric(String str) {
        // TODO: Integer.parseInt를 try-catch로 시도하여 성공 여부 반환
    }

    /*
     * 헬퍼 메소드: 정수 배열의 최댓값 반환 (Integer.max 활용)
     * @param arr 정수 배열
     * @return 최댓값
     */
    static int maxOfArray(int[] arr) {
        // TODO: Integer.MIN_VALUE로 초기화 후 Integer.max로 최댓값 탐색
    }

} // 클래스 끝
