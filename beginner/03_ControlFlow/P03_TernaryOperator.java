/*
 * ============================================================
 * 파일명: P03_TernaryOperator.java
 * 주제: 삼항 연산자 (Ternary Operator)
 * ============================================================
 *
 * [ 학습 목표 ]
 * 1. 삼항 연산자의 구조(조건 ? 참일 때 값 : 거짓일 때 값)를 이해하고 작성할 수 있다.
 * 2. 삼항 연산자가 if-else 문을 간결하게 대체할 수 있음을 이해한다.
 * 3. 중첩 삼항 연산자의 동작 원리와 가독성 문제를 인식하고, 적절한 상황을 판단할 수 있다.
 *
 * [ 핵심 개념 ]
 * - 삼항 연산자 문법:
 *   (조건식) ? 참일_때_값 : 거짓일_때_값
 *
 * - 예시:
 *   int max = (a > b) ? a : b;
 *   // a > b가 true이면 max = a, false이면 max = b
 *
 * - if-else와 비교:
 *   [if-else]
 *   int max;
 *   if (a > b) { max = a; } else { max = b; }
 *
 *   [삼항 연산자]
 *   int max = (a > b) ? a : b;  // 같은 결과, 더 간결
 *
 * - 중첩 삼항 연산자: 삼항 연산자 안에 또 다른 삼항 연산자를 사용하는 방식.
 *   간결하지만 depth가 깊어질수록 가독성이 매우 나빠지므로 주의한다.
 *   예) String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
 *
 * [ 사용법 ]
 * 1. 각 문제의 메소드 안에 있는 // TODO: 주석을 찾는다.
 * 2. 해당 위치에 알맞은 코드를 작성한다.
 * 3. main() 메소드를 실행하여 출력 결과를 확인한다.
 * ============================================================
 */
public class P03_TernaryOperator {

    // ============================================================
    // 문제 1: 두 수 중 최대값 찾기
    // ============================================================
    /*
     * 제목: 삼항 연산자로 두 수 중 최대값 반환하기
     *
     * 설명:
     *   두 개의 정수 a, b를 입력받아 더 큰 값을 반환한다.
     *   반드시 삼항 연산자(? :)를 사용하여 한 줄로 구현한다.
     *   두 값이 같으면 그 값을 반환한다.
     *
     * 예상 출력:
     *   getMax(10, 20) -> 20
     *   getMax(30, 15) -> 30
     *   getMax(7, 7)   -> 7
     *
     * 힌트:
     *   - return (a > b) ? a : b;  형태로 작성한다.
     *   - 괄호는 필수가 아니지만 가독성을 위해 조건식에 괄호를 씌우는 것이 좋다.
     */
    public static int getMax(int a, int b) {
        // TODO: 삼항 연산자를 사용하여 a와 b 중 더 큰 값을 반환 (한 줄로 작성)
        return 0; // 이 줄을 삼항 연산자를 사용한 return 문으로 교체하세요.
    }

    // ============================================================
    // 문제 2: 절대값 계산
    // ============================================================
    /*
     * 제목: 삼항 연산자로 절대값 반환하기
     *
     * 설명:
     *   정수 하나를 입력받아 그 절대값을 반환한다.
     *   Math.abs() 내장 메소드를 사용하지 않고, 삼항 연산자만으로 구현한다.
     *   절대값: 음수이면 부호를 바꾸고, 양수(또는 0)이면 그대로 반환한다.
     *
     * 예상 출력:
     *   getAbsolute(5)   -> 5
     *   getAbsolute(-5)  -> 5
     *   getAbsolute(0)   -> 0
     *   getAbsolute(-99) -> 99
     *
     * 힌트:
     *   - number < 0 이면 -number를 반환한다.
     *   - number >= 0 이면 number를 그대로 반환한다.
     *   - return (number < 0) ? -number : number;
     */
    public static int getAbsolute(int number) {
        // TODO: 삼항 연산자를 사용하여 number의 절대값을 반환 (한 줄로 작성)
        return 0; // 이 줄을 삼항 연산자를 사용한 return 문으로 교체하세요.
    }

    // ============================================================
    // 문제 3: 짝수 / 홀수 판별
    // ============================================================
    /*
     * 제목: 삼항 연산자로 짝수/홀수 문자열 반환하기
     *
     * 설명:
     *   정수 하나를 입력받아 짝수이면 "짝수", 홀수이면 "홀수" 문자열을 반환한다.
     *   삼항 연산자를 사용하여 한 줄로 구현한다.
     *
     * 예상 출력:
     *   isEvenOrOdd(4)  -> "짝수"
     *   isEvenOrOdd(7)  -> "홀수"
     *   isEvenOrOdd(0)  -> "짝수"
     *   isEvenOrOdd(-3) -> "홀수"
     *
     * 힌트:
     *   - 짝수 판별: number % 2 == 0
     *   - 홀수 판별: number % 2 != 0  (또는 number % 2 == 1)
     *   - 음수에서 % 연산 결과는 -1이 될 수 있으므로 == 0 조건이 더 안전하다.
     */
    public static String isEvenOrOdd(int number) {
        // TODO: 삼항 연산자를 사용하여 짝수이면 "짝수", 홀수이면 "홀수" 반환 (한 줄로 작성)
        return ""; // 이 줄을 삼항 연산자를 사용한 return 문으로 교체하세요.
    }

    // ============================================================
    // 문제 4: 중첩 삼항 연산자 - 등급 출력
    // ============================================================
    /*
     * 제목: 중첩 삼항 연산자로 A / B / C 등급 반환하기
     *
     * 주의: 중첩 삼항 연산자는 가독성이 매우 낮아 실무에서는 지양합니다.
     *       학습 목적으로만 사용하며, 가능하면 if-else 문으로 대체하는 것이 좋습니다.
     *
     * 설명:
     *   점수(정수)를 입력받아 등급을 반환한다.
     *   등급 기준:
     *     - 90 이상 : "A"
     *     - 70 이상 : "B"
     *     - 70 미만 : "C"
     *   삼항 연산자를 중첩하여 한 줄(또는 두 줄)로 구현한다.
     *
     * 예상 출력:
     *   getGradeABC(95) -> "A"
     *   getGradeABC(75) -> "B"
     *   getGradeABC(55) -> "C"
     *
     * 힌트:
     *   - 중첩 삼항 형태:
     *     (score >= 90) ? "A" : (score >= 70) ? "B" : "C"
     *   - 가독성을 위해 줄 바꿈과 들여쓰기를 활용할 수 있다.
     *     예)
     *     String grade = (score >= 90) ? "A"
     *                  : (score >= 70) ? "B"
     *                  : "C";
     *
     * [비교] 아래의 if-else 버전과 결과가 동일함을 확인하라.
     *   if (score >= 90)      { grade = "A"; }
     *   else if (score >= 70) { grade = "B"; }
     *   else                  { grade = "C"; }
     */
    public static String getGradeABC(int score) {
        // TODO: 중첩 삼항 연산자를 사용하여 90 이상 "A", 70 이상 "B", 70 미만 "C" 반환
        return ""; // 이 줄을 중첩 삼항 연산자를 사용한 return 문으로 교체하세요.
    }

    // ============================================================
    // 헬퍼 메소드 (내용 직접 구현 불필요 - 시그니처만 참고)
    // ============================================================

    /** 두 값 중 더 작은 값을 반환한다. */
    private static int getMin(int a, int b) { return 0; /* 구현 생략 */ }

    /** 숫자가 홀수인지 확인한다. */
    private static boolean isOdd(int number) { return false; /* 구현 생략 */ }

    // ============================================================
    // main 메소드 - 테스트 실행
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: 두 수 중 최대값 ===");
        System.out.println("getMax(10, 20) -> " + getMax(10, 20));
        System.out.println("getMax(30, 15) -> " + getMax(30, 15));
        System.out.println("getMax(7, 7)   -> " + getMax(7, 7));

        System.out.println();
        System.out.println("=== 문제 2: 절대값 계산 ===");
        System.out.println("getAbsolute(5)   -> " + getAbsolute(5));
        System.out.println("getAbsolute(-5)  -> " + getAbsolute(-5));
        System.out.println("getAbsolute(0)   -> " + getAbsolute(0));
        System.out.println("getAbsolute(-99) -> " + getAbsolute(-99));

        System.out.println();
        System.out.println("=== 문제 3: 짝수 / 홀수 판별 ===");
        System.out.println("isEvenOrOdd(4)  -> " + isEvenOrOdd(4));
        System.out.println("isEvenOrOdd(7)  -> " + isEvenOrOdd(7));
        System.out.println("isEvenOrOdd(0)  -> " + isEvenOrOdd(0));
        System.out.println("isEvenOrOdd(-3) -> " + isEvenOrOdd(-3));

        System.out.println();
        System.out.println("=== 문제 4: 중첩 삼항 연산자 등급 출력 ===");
        System.out.println("getGradeABC(95) -> " + getGradeABC(95));
        System.out.println("getGradeABC(75) -> " + getGradeABC(75));
        System.out.println("getGradeABC(55) -> " + getGradeABC(55));

        // [심화] 삼항 연산자 vs if-else 비교 출력
        System.out.println();
        System.out.println("=== [심화] 삼항 연산자 vs if-else 비교 ===");
        int x = 15;
        // 삼항 연산자 버전
        String resultTernary = (x % 2 == 0) ? "짝수" : "홀수";
        // if-else 버전
        String resultIfElse;
        if (x % 2 == 0) {
            resultIfElse = "짝수";
        } else {
            resultIfElse = "홀수";
        }
        System.out.println(x + "은 삼항 연산자 결과: " + resultTernary);
        System.out.println(x + "은 if-else 결과: " + resultIfElse);
        System.out.println("두 결과 일치 여부: " + resultTernary.equals(resultIfElse));
    }
}