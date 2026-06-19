/*
 * ========================================================
 * P03_StringBuilder.java - StringBuilder / StringBuffer
 * ========================================================
 *
 * 【학습 목표】
 *  1. String의 불변성으로 인한 성능 문제를 이해하고,
 *     StringBuilder를 사용해야 하는 상황을 구분할 수 있다.
 *  2. StringBuilder의 주요 메소드(append, insert, delete,
 *     replace, reverse)를 활용할 수 있다.
 *  3. StringBuilder를 이용하여 회문(팰린드롬)을 판별하는
 *     알고리즘을 구현할 수 있다.
 *
 * 【핵심 개념 설명】
 *  - String vs StringBuilder vs StringBuffer:
 *      String        : 불변(Immutable). + 연산 시 매번 새 객체 생성 → 비효율.
 *      StringBuilder : 가변(Mutable). 단일 스레드 환경에서 사용. 빠름.
 *      StringBuffer  : 가변(Mutable). 멀티 스레드 환경에서 안전(synchronized).
 *                      StringBuilder보다 약간 느림.
 *
 *  - StringBuilder 주요 메소드:
 *      append(str)          : 끝에 추가
 *      insert(idx, str)     : 특정 위치에 삽입
 *      delete(start, end)   : start~end-1 구간 삭제
 *      replace(start, end, str) : start~end-1 구간을 str로 교체
 *      reverse()            : 문자열 뒤집기
 *      toString()           : String으로 변환
 *
 *  - 성능 차이:
 *      String을 루프에서 + 로 연결하면 O(n^2) 성능.
 *      StringBuilder는 O(n) 성능으로 훨씬 효율적.
 * ========================================================
 */
public class P03_StringBuilder {

    public static void main(String[] args) {

        // ====================================================
        // 문제 1: StringBuilder로 문자열 효율적으로 연결
        // ====================================================
        /*
         * [문제 1] StringBuilder 기본 사용법
         * -------------------------------------------------------
         * 설명:
         *   StringBuilder를 사용하여 1~5까지의 숫자를 쉼표로 이어 붙여
         *   "1, 2, 3, 4, 5" 형태의 문자열을 만들고 출력하세요.
         *
         *   조건:
         *     - for 루프를 사용하세요.
         *     - 마지막 숫자 뒤에는 쉼표와 공백이 붙지 않아야 합니다.
         *     - 최종 완성된 문자열의 길이도 함께 출력하세요.
         *
         * 예상 출력:
         *   결과: 1, 2, 3, 4, 5
         *   길이: 13
         *
         * 힌트:
         *   - new StringBuilder()로 생성.
         *   - sb.append(i)로 숫자 추가.
         *   - 마지막 요소가 아닐 때만 ", " 추가 (if i < 5).
         *   - sb.length()로 길이 확인.
         *   - sb.toString()으로 String 변환.
         */
        System.out.println("=== 문제 1: StringBuilder 기본 사용 ===");

        StringBuilder sb1 = new StringBuilder();

        // TODO: for 루프를 사용하여 1~5를 ", "로 이어 붙이세요.

        // TODO: 결과 문자열과 길이를 출력하세요.

        System.out.println();

        // ====================================================
        // 문제 2: append, insert, delete, replace, reverse
        // ====================================================
        /*
         * [문제 2] StringBuilder 다양한 메소드 활용
         * -------------------------------------------------------
         * 설명:
         *   StringBuilder sb = new StringBuilder("Hello World")
         *   위 sb를 사용하여 단계별로 변환하고 각 단계 결과를 출력하세요.
         *     1단계: 끝에 "!" 추가 (append)
         *     2단계: 인덱스 5에 "," 삽입 (insert)  → "Hello, World!"
         *     3단계: 인덱스 7~12 삭제 (delete)      → "Hello, !"
         *     4단계: 인덱스 7~8을 "Java" 로 교체 (replace) → "Hello, Java!"
         *     5단계: 전체 문자열 뒤집기 (reverse)
         *
         * 예상 출력:
         *   초기: Hello World
         *   append 후: Hello World!
         *   insert 후: Hello, World!
         *   delete 후: Hello, !
         *   replace 후: Hello, Java!
         *   reverse 후: !avaJ ,olleH
         *
         * 힌트:
         *   - insert(5, ",") → 5번 인덱스 앞에 삽입.
         *   - delete(7, 12)  → 7~11번 인덱스 삭제.
         *   - replace(7, 8, "Java") → 7번 인덱스 문자를 "Java"로 교체.
         *   - 각 단계마다 sb의 내용이 바뀌므로 인덱스에 주의.
         */
        System.out.println("=== 문제 2: StringBuilder 메소드 ===");

        StringBuilder sb2 = new StringBuilder("Hello World");
        System.out.println("초기: " + sb2);

        // TODO: 1단계 - 끝에 "!" 추가하고 출력

        // TODO: 2단계 - 인덱스 5에 "," 삽입하고 출력

        // TODO: 3단계 - 인덱스 7~12 삭제하고 출력

        // TODO: 4단계 - 인덱스 7~8을 "Java"로 교체하고 출력

        // TODO: 5단계 - 전체 문자열 뒤집고 출력

        System.out.println();

        // ====================================================
        // 문제 3: String vs StringBuilder 성능 비교
        // ====================================================
        /*
         * [문제 3] 성능 차이 측정
         * -------------------------------------------------------
         * 설명:
         *   10,000번 반복하여 문자열을 연결하는 두 가지 방법의
         *   실행 시간(밀리초)을 측정하여 비교하세요.
         *     방법A: String + 연산자로 반복 연결
         *     방법B: StringBuilder로 반복 연결
         *
         *   System.currentTimeMillis()로 시작/종료 시간을 기록하세요.
         *
         * 예상 출력 (실제 값은 환경마다 다름):
         *   String + 연산: XX ms
         *   StringBuilder: X ms
         *   StringBuilder가 약 XX배 빠름
         *
         * 힌트:
         *   - long start = System.currentTimeMillis();
         *   - long end   = System.currentTimeMillis();
         *   - 소요시간 = end - start (밀리초).
         *   - String + 연산은 매번 새 객체를 생성하므로 느리다.
         *   - 반복 횟수가 클수록 차이가 더 크게 난다.
         */
        System.out.println("=== 문제 3: 성능 비교 ===");

        int repeatCount = 10000;

        // TODO: 방법A - String + 연산자로 repeatCount번 반복, 시간 측정

        // TODO: 방법B - StringBuilder로 repeatCount번 반복, 시간 측정

        // TODO: 두 방법의 소요 시간 출력 및 배수 비교 출력

        System.out.println();

        // ====================================================
        // 문제 4: StringBuilder로 회문(팰린드롬) 판별
        // ====================================================
        /*
         * [문제 4] 팰린드롬 판별기
         * -------------------------------------------------------
         * 설명:
         *   isPalindrome(String s) 헬퍼 메소드를 완성하고,
         *   아래 문자열들이 팰린드롬인지 출력하세요.
         *     "racecar" → true
         *     "hello"   → false
         *     "level"   → true
         *     "java"    → false
         *     "madam"   → true
         *
         *   팰린드롬이란 앞에서 읽으나 뒤에서 읽으나 같은 문자열이다.
         *   예: "racecar", "level", "madam"
         *
         * 예상 출력:
         *   "racecar" 팰린드롬 여부: true
         *   "hello" 팰린드롬 여부: false
         *   "level" 팰린드롬 여부: true
         *   "java" 팰린드롬 여부: false
         *   "madam" 팰린드롬 여부: true
         *
         * 힌트:
         *   - new StringBuilder(s).reverse().toString()으로 뒤집힌 문자열 생성.
         *   - 원본과 뒤집힌 문자열을 equals()로 비교.
         *   - 대소문자를 무시하려면 toLowerCase()를 먼저 적용.
         */
        System.out.println("=== 문제 4: 팰린드롬 판별 ===");

        String[] words = {"racecar", "hello", "level", "java", "madam"};

        // TODO: 각 단어에 대해 isPalindrome() 결과를 출력하세요.

    }

    // ====================================================
    // 헬퍼 메소드 (내용을 직접 구현하세요)
    // ====================================================

    /**
     * 주어진 문자열이 팰린드롬(회문)인지 판별한다.
     * StringBuilder의 reverse() 메소드를 활용하여 구현하세요.
     *
     * @param s 검사할 문자열
     * @return 팰린드롬이면 true, 아니면 false
     */
    static boolean isPalindrome(String s) {
        // TODO: StringBuilder로 s를 뒤집어 원본과 비교하여 반환
        return false;
    }
}
