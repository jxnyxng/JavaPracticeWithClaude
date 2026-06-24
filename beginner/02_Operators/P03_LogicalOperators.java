/*
 * ============================================================
 * 파일명: P03_LogicalOperators.java
 * 주제: 논리 연산자 (&&, ||, !)
 * ============================================================
 *
 * [학습목표]
 * 1. 논리 연산자(&&, ||, !)의 진리표를 이해하고 복합 조건을 작성할 수 있다.
 * 2. 단락 평가(short-circuit evaluation)의 동작 원리를 이해하고 활용한다.
 * 3. 실생활 문제(윤년, 로그인, 삼각형)를 논리 연산자로 표현할 수 있다.
 *
 * [핵심개념]
 * - && (AND): 두 조건이 모두 true일 때만 true
 *     예) (x > 0) && (x < 10)  → x가 0 초과이고 10 미만일 때 true
 * - || (OR): 두 조건 중 하나라도 true이면 true
 *     예) (x == 0) || (x == 1)  → x가 0이거나 1일 때 true
 * - ! (NOT): 조건을 반전 (true → false, false → true)
 *     예) !(x > 0)  → x가 0 이하일 때 true
 *
 * - 단락 평가(Short-Circuit Evaluation):
 *     &&: 왼쪽 조건이 false이면 오른쪽 조건을 평가하지 않음
 *     ||: 왼쪽 조건이 true이면 오른쪽 조건을 평가하지 않음
 *     → 성능 최적화 및 NullPointerException 방지에 활용 가능
 *
 * - 진리표:
 *     A     B     A&&B   A||B   !A
 *     true  true  true   true   false
 *     true  false false  true   false
 *     false true  false  true   true
 *     false false false  false  true
 * ============================================================
 */

import java.util.Scanner;

public class P03_LogicalOperators {

    public static void main(String[] args) {
        System.out.println("=== 논리 연산자 연습 ===\n");

        problem1();
        problem2();
        problem3();
        problem4();
    }

    // ============================================================
    // 문제 1: 윤년 판별
    // ============================================================
    /*
     * [문제 설명]
     * 연도를 입력받아 윤년(leap year)인지 판별하세요.
     *
     * 윤년 조건 (다음 중 하나를 만족):
     *   조건 1: 4의 배수이면서 100의 배수가 아닌 경우
     *   조건 2: 400의 배수인 경우
     *
     * 공식으로 표현:
     *   (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
     *
     * [예상 출력 예시]
     * 연도 입력: 2024
     * 2024년은 윤년입니까? true
     * 2024년은 윤년입니다.
     *
     * 연도 입력: 1900
     * 1900년은 윤년입니까? false
     * 1900년은 평년입니다.
     *
     * 연도 입력: 2000
     * 2000년은 윤년입니까? true
     * 2000년은 윤년입니다. (400의 배수)
     *
     * [힌트]
     * - 4의 배수: year % 4 == 0
     * - 100의 배수가 아님: year % 100 != 0
     * - 400의 배수: year % 400 == 0
     * - 최종 윤년 조건을 boolean 변수에 저장하세요
     */
    static void problem1() {
        System.out.println("--- 문제1: 윤년 판별 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 연도(int)를 입력받으세요

        // TODO: 4의 배수 여부를 boolean 변수에 저장하세요
        // boolean isDivisibleBy4 = ...;

        // TODO: 100의 배수 여부를 boolean 변수에 저장하세요
        // boolean isDivisibleBy100 = ...;

        // TODO: 400의 배수 여부를 boolean 변수에 저장하세요
        // boolean isDivisibleBy400 = ...;

        // TODO: 윤년 여부를 논리 연산자로 계산하세요
        // boolean isLeapYear = ...;

        // TODO: 윤년 여부(boolean값)를 출력하세요

        // TODO: 윤년이면 "윤년입니다.", 아니면 "평년입니다."를 출력하세요

        System.out.println();
    }

    // ============================================================
    // 문제 2: 로그인 유효성 검사
    // ============================================================
    /*
     * [문제 설명]
     * 아이디와 비밀번호를 입력받아 유효성을 검사하세요.
     *
     * 유효성 조건:
     *   - 아이디: 길이가 4자 이상 20자 이하
     *   - 비밀번호: 길이가 8자 이상 16자 이하
     *   - 두 조건을 모두 만족해야 로그인 가능
     *
     * [예상 출력 예시]
     * 아이디 입력: abc
     * 비밀번호 입력: password123
     * 아이디 길이(3): 유효하지 않음 (4~20자 필요)
     * 비밀번호 길이(11): 유효함
     * 아이디 유효: false
     * 비밀번호 유효: true
     * 로그인 가능: false
     *
     * [힌트]
     * - String 길이: str.length()
     * - 아이디 유효: id.length() >= 4 && id.length() <= 20
     * - 비밀번호 유효: pw.length() >= 8 && pw.length() <= 16
     * - 최종 유효성: isValidId && isValidPw
     */
    static void problem2() {
        System.out.println("--- 문제2: 로그인 유효성 검사 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 아이디(String)를 입력받으세요

        // TODO: 비밀번호(String)를 입력받으세요

        // TODO: 아이디 길이 유효성을 boolean 변수에 저장하세요
        // boolean isValidId = ...;

        // TODO: 비밀번호 길이 유효성을 boolean 변수에 저장하세요
        // boolean isValidPw = ...;

        // TODO: 최종 로그인 가능 여부를 && 연산자로 계산하세요
        // boolean canLogin = ...;

        // TODO: 아이디 길이와 유효 여부를 출력하세요
        // TODO: 비밀번호 길이와 유효 여부를 출력하세요
        // TODO: 로그인 가능 여부를 출력하세요

        System.out.println();
    }

    // ============================================================
    // 문제 3: 삼각형 성립 조건
    // ============================================================
    /*
     * [문제 설명]
     * 세 변의 길이를 입력받아 삼각형이 성립하는지 확인하세요.
     *
     * 삼각형 성립 조건:
     *   두 변의 합이 나머지 한 변보다 커야 한다.
     *   즉, 아래 세 조건을 모두 만족:
     *     조건 1: a + b > c
     *     조건 2: b + c > a
     *     조건 3: a + c > b
     *
     * [예상 출력 예시]
     * 변 a 입력: 3
     * 변 b 입력: 4
     * 변 c 입력: 5
     * a + b > c : 7 > 5 → true
     * b + c > a : 9 > 3 → true
     * a + c > b : 8 > 4 → true
     * 삼각형 성립 여부: true
     * 3, 4, 5로 삼각형을 만들 수 있습니다.
     *
     * [힌트]
     * - 세 조건을 각각 boolean 변수에 저장하세요
     * - 최종 결과: cond1 && cond2 && cond3
     * - ! 연산자로 불가능한 경우도 표현해 보세요 (선택)
     */
    static void problem3() {
        System.out.println("--- 문제3: 삼각형 성립 조건 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 세 변의 길이(int)를 입력받으세요 (변수명: a, b, c)

        // TODO: 조건1 (a + b > c) 을 boolean 변수에 저장하세요
        // boolean cond1 = ...;

        // TODO: 조건2 (b + c > a) 을 boolean 변수에 저장하세요
        // boolean cond2 = ...;

        // TODO: 조건3 (a + c > b) 을 boolean 변수에 저장하세요
        // boolean cond3 = ...;

        // TODO: 세 조건을 && 로 결합하여 삼각형 성립 여부를 계산하세요
        // boolean isTriangle = ...;

        // TODO: 각 조건의 계산 과정과 결과를 출력하세요
        // TODO: 삼각형 성립 여부를 출력하세요

        System.out.println();
    }

    // ============================================================
    // 문제 4: 단락 평가(Short-Circuit Evaluation) 동작 확인
    // ============================================================
    /*
     * [문제 설명]
     * 단락 평가(short-circuit)는 논리 연산자가 결과를 조기 확정할 때
     * 나머지 피연산자 평가를 건너뛰는 동작입니다.
     * 헬퍼 메소드를 활용하여 각 피연산자가 실제로 평가되는지 실험하세요.
     *
     * 실험 A: && 의 단락 평가 (왼쪽이 false일 때)
     *   - false && checkRight("B")
     *   - 왼쪽이 false이므로 checkRight가 호출되지 않아야 함
     *
     * 실험 B: || 의 단락 평가 (왼쪽이 true일 때)
     *   - true || checkRight("D")
     *   - 왼쪽이 true이므로 checkRight가 호출되지 않아야 함
     *
     * 실험 C: 단락 없이 전체 평가 (&&, 왼쪽이 true일 때)
     *   - true && checkRight("F")
     *   - 왼쪽이 true이므로 오른쪽도 평가됨 → checkRight 호출됨
     *
     * 실험 D: 단락 없이 전체 평가 (||, 왼쪽이 false일 때)
     *   - false || checkRight("H")
     *   - 왼쪽이 false이므로 오른쪽도 평가됨 → checkRight 호출됨
     *
     * [예상 출력 예시]
     * [실험 A - && 단락 평가: 왼쪽 false]
     * checkLeft("A") 호출됨
     * checkRight("B") 호출 안됨 ← 단락 평가로 건너뜀
     * 결과: false
     *
     * [실험 B - || 단락 평가: 왼쪽 true]
     * checkLeft("C") 호출됨
     * checkRight("D") 호출 안됨 ← 단락 평가로 건너뜀
     * 결과: true
     *
     * [실험 C - && 전체 평가: 왼쪽 true]
     * checkLeft("E") 호출됨
     * checkRight("F") 호출됨
     * 결과: true
     *
     * [실험 D - || 전체 평가: 왼쪽 false]
     * checkLeft("G") 호출됨
     * checkRight("H") 호출됨
     * 결과: true
     *
     * [힌트]
     * - checkLeft, checkRight 헬퍼 메소드가 호출될 때 출력을 남기도록 구현
     * - checkLeft(String label)가 false 반환 → &&에서 오른쪽 평가 안 됨
     * - checkLeft(String label)가 true 반환 → ||에서 오른쪽 평가 안 됨
     * - 실무 활용: obj != null && obj.method() 로 NPE 방지
     */
    static void problem4() {
        System.out.println("--- 문제4: 단락 평가(Short-Circuit) 동작 확인 ---");

        // 실험 A: && 단락 평가 (왼쪽 false)
        System.out.println("[실험 A - && 단락 평가: 왼쪽 false]");
        // TODO: checkLeft("A")가 false를 반환하도록 하고 && checkRight("B") 조합 실험
        // boolean resultA = checkLeft("A") && checkRight("B");
        // TODO: resultA 를 출력하세요
        System.out.println();

        // 실험 B: || 단락 평가 (왼쪽 true)
        System.out.println("[실험 B - || 단락 평가: 왼쪽 true]");
        // TODO: checkLeft("C")가 true를 반환하도록 하고 || checkRight("D") 조합 실험
        // boolean resultB = checkLeft("C") || checkRight("D");
        // TODO: resultB 를 출력하세요
        System.out.println();

        // 실험 C: && 전체 평가 (왼쪽 true)
        System.out.println("[실험 C - && 전체 평가: 왼쪽 true]");
        // TODO: checkLeft("E")가 true를 반환하도록 하고 && checkRight("F") 조합 실험
        // boolean resultC = checkLeft("E") && checkRight("F");
        // TODO: resultC 를 출력하세요
        System.out.println();

        // 실험 D: || 전체 평가 (왼쪽 false)
        System.out.println("[실험 D - || 전체 평가: 왼쪽 false]");
        // TODO: checkLeft("G")가 false를 반환하도록 하고 || checkRight("H") 조합 실험
        // boolean resultD = checkLeft("G") || checkRight("H");
        // TODO: resultD 를 출력하세요
        System.out.println();
    }

    // ============================================================
    // 헬퍼 메소드 시그니처 (내용을 직접 구현하세요)
    // ============================================================

    /**
     * 단락 평가 실험용 - 왼쪽 피연산자 역할을 하는 메소드
     * 호출 시 "[label] 왼쪽 평가됨"을 출력하고, label이 홀수 인덱스면 false, 짝수면 true 반환
     * @param label 식별용 레이블 문자열
     * @return label에 따른 boolean 값
     */
    static boolean checkLeft(String label) {
        // TODO: 호출 사실을 출력하고 적절한 boolean 값을 반환하세요
        return false; // TODO: 실험에 맞게 수정하세요
    }

    /**
     * 단락 평가 실험용 - 오른쪽 피연산자 역할을 하는 메소드
     * 호출 시 "[label] 오른쪽 평가됨"을 출력하고 true를 반환
     * @param label 식별용 레이블 문자열
     * @return 항상 true
     */
    static boolean checkRight(String label) {
        // TODO: 호출 사실을 출력하고 true를 반환하세요
        return false; // TODO: true로 수정하세요
    }

    /**
     * 윤년 여부를 반환하는 헬퍼 메소드 (선택 구현)
     * @param year 판별할 연도
     * @return 윤년이면 true, 아니면 false
     */
    static boolean isLeapYear(int year) {
        // TODO: 윤년 조건을 논리 연산자로 구현하여 반환하세요
        return false; // TODO: 올바른 값을 반환하도록 수정하세요
    }
}