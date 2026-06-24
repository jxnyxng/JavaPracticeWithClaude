/*
 * ============================================================
 * 파일명: P02_Switch.java
 * 주제: switch 문 (Switch Statement)
 * ============================================================
 *
 * [ 학습 목표 ]
 * 1. switch-case 구조를 이해하고 if-else와의 차이점을 설명할 수 있다.
 * 2. break 문의 역할과 fall-through(낙하) 현상을 이해하고 활용할 수 있다.
 * 3. Java 14+에서 도입된 switch 표현식(->)을 기존 switch 문과 비교하여 작성할 수 있다.
 *
 * [ 핵심 개념 ]
 * - switch 문: 하나의 변수값을 여러 상수값과 비교하여 해당 블록을 실행한다.
 *   예)
 *   switch (day) {
 *       case 1: System.out.println("월요일"); break;
 *       case 2: System.out.println("화요일"); break;
 *       default: System.out.println("알 수 없음");
 *   }
 *
 * - break: case 블록 실행 후 switch 문을 탈출한다. 생략 시 다음 case로 실행이 이어진다(fall-through).
 * - default: 어떤 case와도 일치하지 않을 때 실행된다. (생략 가능)
 * - fall-through: break 없이 여러 case를 하나의 블록으로 묶을 때 의도적으로 사용한다.
 *
 * - switch 표현식 (Java 14+):
 *   String result = switch (day) {
 *       case 1 -> "월요일";
 *       case 2 -> "화요일";
 *       default -> "알 수 없음";
 *   };
 *
 * [ 사용법 ]
 * 1. 각 문제의 메소드 안에 있는 // TODO: 주석을 찾는다.
 * 2. 해당 위치에 알맞은 코드를 작성한다.
 * 3. main() 메소드를 실행하여 출력 결과를 확인한다.
 * ============================================================
 */
public class P02_Switch {

    // ============================================================
    // 문제 1: 숫자로 요일 출력
    // ============================================================
    /*
     * 제목: 숫자 입력으로 요일 이름 반환하기
     *
     * 설명:
     *   1~7 사이의 정수를 입력받아 해당 요일 이름을 반환한다.
     *   범위를 벗어난 숫자는 "알 수 없는 요일"을 반환한다.
     *     1 -> "월요일"
     *     2 -> "화요일"
     *     3 -> "수요일"
     *     4 -> "목요일"
     *     5 -> "금요일"
     *     6 -> "토요일"
     *     7 -> "일요일"
     *
     * 예상 출력:
     *   getDayName(1) -> "월요일"
     *   getDayName(5) -> "금요일"
     *   getDayName(9) -> "알 수 없는 요일"
     *
     * 힌트:
     *   - switch(day)로 시작하여 각 case에 요일 이름을 작성한다.
     *   - 각 case 끝에 break;를 잊지 않는다.
     *   - 1~7 외의 값은 default:에서 처리한다.
     */
    public static String getDayName(int day) {
        String result = "";

        // TODO: switch(day) 문을 작성하여 각 숫자에 해당하는 요일 이름을 result에 저장
        // case 1: result = "월요일"; break;
        // case 2: ...
        // ...
        // default: result = "알 수 없는 요일";

        return result;
    }

    // ============================================================
    // 문제 2: 월 번호로 계절 출력
    // ============================================================
    /*
     * 제목: 월(月) 번호로 계절 이름 반환하기
     *
     * 설명:
     *   1~12 사이의 월 번호를 입력받아 해당 계절 이름을 반환한다.
     *   계절 기준은 다음과 같다.
     *     3, 4, 5월  -> "봄"
     *     6, 7, 8월  -> "여름"
     *     9, 10, 11월 -> "가을"
     *     12, 1, 2월 -> "겨울"
     *   범위를 벗어난 숫자는 "유효하지 않은 월"을 반환한다.
     *
     * 예상 출력:
     *   getSeason(4)  -> "봄"
     *   getSeason(7)  -> "여름"
     *   getSeason(10) -> "가을"
     *   getSeason(1)  -> "겨울"
     *   getSeason(13) -> "유효하지 않은 월"
     *
     * 힌트:
     *   - fall-through를 활용하면 여러 case를 하나로 묶을 수 있다.
     *   - 예) case 3: case 4: case 5: result = "봄"; break;
     *   - break 없이 여러 case를 연속으로 나열하면 같은 블록으로 실행된다.
     */
    public static String getSeason(int month) {
        String result = "";

        // TODO: switch(month) 문을 작성하여 fall-through로 계절을 구분
        // 봄: 3, 4, 5월
        // 여름: 6, 7, 8월
        // 가을: 9, 10, 11월
        // 겨울: 12, 1, 2월
        // 그 외: "유효하지 않은 월"

        return result;
    }

    // ============================================================
    // 문제 3: 간단한 계산기
    // ============================================================
    /*
     * 제목: 사칙연산 계산기 구현하기 (switch 활용)
     *
     * 설명:
     *   두 개의 실수(double)와 연산자 문자(char)를 입력받아 계산 결과를 반환한다.
     *   지원하는 연산자: '+', '-', '*', '/'
     *   나누기(/)에서 b가 0이면 "0으로 나눌 수 없습니다."를 출력하고 Double.NaN을 반환한다.
     *   지원하지 않는 연산자는 "지원하지 않는 연산자입니다."를 출력하고 Double.NaN을 반환한다.
     *
     * 예상 출력:
     *   calculate(10, 3, '+') -> 13.0
     *   calculate(10, 3, '-') -> 7.0
     *   calculate(10, 3, '*') -> 30.0
     *   calculate(10, 3, '/') -> 3.3333...
     *   calculate(10, 0, '/') -> (메시지 출력) Double.NaN
     *   calculate(10, 3, '%') -> (메시지 출력) Double.NaN
     *
     * 힌트:
     *   - switch(operator)로 char 값을 분기한다.
     *   - case '+': return a + b;  형태로 직접 반환할 수 있다.
     *   - 나누기의 경우 b == 0 인지 먼저 if로 확인한다.
     */
    public static double calculate(double a, double b, char operator) {
        // TODO: switch(operator) 문을 작성하여 각 연산자에 맞는 계산 결과 반환
        // case '+': ...
        // case '-': ...
        // case '*': ...
        // case '/': 0으로 나누기 예외 처리 후 결과 반환
        // default: "지원하지 않는 연산자입니다." 출력 후 Double.NaN 반환

        return Double.NaN; // 이 줄을 수정하지 말고, 위 TODO 안에서 반환하게 하세요.
    }

    // ============================================================
    // 문제 4: switch 표현식 (Java 14+) 비교
    // ============================================================
    /*
     * 제목: 전통 switch 문과 switch 표현식(화살표 문법) 비교
     *
     * 설명:
     *   동일한 기능(요일 번호 -> 요일 구분: 평일/주말)을
     *   두 가지 방식으로 구현하여 차이를 비교한다.
     *
     *   [방식 A] 전통 switch 문 (Java 1.0~)
     *     - switch 블록 안에서 변수에 값을 대입하고 break를 사용한다.
     *     - fall-through 위험이 있다.
     *
     *   [방식 B] switch 표현식 (Java 14+)
     *     - -> (화살표)를 사용하여 간결하게 작성한다.
     *     - break 불필요, fall-through 없음.
     *     - 값을 직접 반환하거나 변수에 대입할 수 있다.
     *
     *   요일 기준:
     *     1(월), 2(화), 3(수), 4(목), 5(금) -> "평일"
     *     6(토), 7(일)                        -> "주말"
     *     그 외                               -> "알 수 없음"
     *
     * 예상 출력:
     *   getDayTypeTraditional(3) -> "평일"
     *   getDayTypeExpression(3)  -> "평일"
     *   getDayTypeTraditional(6) -> "주말"
     *   getDayTypeExpression(6)  -> "주말"
     *
     * 힌트:
     *   - 방식 A: case 1: case 2: case 3: case 4: case 5: result = "평일"; break;
     *   - 방식 B: case 1, 2, 3, 4, 5 -> "평일";
     *             (Java 14 이상에서만 컴파일됩니다)
     */

    /** 방식 A: 전통 switch 문으로 평일/주말 반환 */
    public static String getDayTypeTraditional(int day) {
        String result = "";

        // TODO: 전통 switch 문을 사용하여 1~5는 "평일", 6~7은 "주말", 그 외는 "알 수 없음" 반환
        // fall-through를 활용하여 case 1, 2, 3, 4, 5를 한 번에 처리한다.

        return result;
    }

    /** 방식 B: switch 표현식(Java 14+)으로 평일/주말 반환 */
    public static String getDayTypeExpression(int day) {
        // TODO: switch 표현식(화살표 문법)을 사용하여 1~5는 "평일", 6~7은 "주말", 그 외는 "알 수 없음" 반환
        // 형태: String result = switch (day) { case 1, 2, 3, 4, 5 -> "평일"; ... };

        return ""; // 위 TODO에서 result를 선언한 뒤 여기서 result를 반환하거나, 직접 switch 표현식을 반환하세요.
    }

    // ============================================================
    // 헬퍼 메소드 (내용 직접 구현 불필요 - 시그니처만 참고)
    // ============================================================

    /** 연산자 문자가 유효한지 확인한다. */
    private static boolean isValidOperator(char op) { return false; /* 구현 생략 */ }

    // ============================================================
    // main 메소드 - 테스트 실행
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: 요일 이름 출력 ===");
        System.out.println("1 -> " + getDayName(1));
        System.out.println("5 -> " + getDayName(5));
        System.out.println("7 -> " + getDayName(7));
        System.out.println("9 -> " + getDayName(9));

        System.out.println();
        System.out.println("=== 문제 2: 계절 출력 ===");
        System.out.println(" 4월 -> " + getSeason(4));
        System.out.println(" 7월 -> " + getSeason(7));
        System.out.println("10월 -> " + getSeason(10));
        System.out.println(" 1월 -> " + getSeason(1));
        System.out.println("13월 -> " + getSeason(13));

        System.out.println();
        System.out.println("=== 문제 3: 사칙연산 계산기 ===");
        System.out.println("10 + 3 = " + calculate(10, 3, '+'));
        System.out.println("10 - 3 = " + calculate(10, 3, '-'));
        System.out.println("10 * 3 = " + calculate(10, 3, '*'));
        System.out.println("10 / 3 = " + calculate(10, 3, '/'));
        System.out.println("10 / 0 = " + calculate(10, 0, '/'));
        System.out.println("10 % 3 = " + calculate(10, 3, '%'));

        System.out.println();
        System.out.println("=== 문제 4: switch 표현식 비교 ===");
        System.out.println("[전통] 3 -> " + getDayTypeTraditional(3));
        System.out.println("[표현식] 3 -> " + getDayTypeExpression(3));
        System.out.println("[전통] 6 -> " + getDayTypeTraditional(6));
        System.out.println("[표현식] 6 -> " + getDayTypeExpression(6));
        System.out.println("[전통] 9 -> " + getDayTypeTraditional(9));
        System.out.println("[표현식] 9 -> " + getDayTypeExpression(9));
    }
}