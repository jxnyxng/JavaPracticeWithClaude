/**
 * 파일명: P01_TryCatch.java
 * 주제: try-catch 기본
 *
 * =============================================
 * 학습 목표
 * =============================================
 * 1. try-catch 블록의 기본 구조를 이해하고 예외를 안전하게 처리한다.
 * 2. 자주 발생하는 런타임 예외(ArithmeticException, NumberFormatException,
 *    ArrayIndexOutOfBoundsException)의 원인과 처리 방법을 익힌다.
 * 3. 예외 객체의 getMessage()와 printStackTrace()를 활용하여
 *    예외 정보를 출력하는 방법을 습득한다.
 *
 * =============================================
 * 핵심 개념 설명
 * =============================================
 * [try-catch 구조]
 *   try {
 *       // 예외가 발생할 수 있는 코드
 *   } catch (예외타입 변수명) {
 *       // 예외 발생 시 처리 코드
 *   }
 *
 * [주요 런타임 예외]
 *   - ArithmeticException      : 산술 오류 (예: 0으로 나누기)
 *   - NumberFormatException    : 숫자 형식 오류 (예: "abc"를 int로 변환)
 *   - ArrayIndexOutOfBoundsException : 배열 인덱스 범위 초과
 *
 * [예외 정보 출력 메서드]
 *   - e.getMessage()       : 예외 메시지 문자열 반환
 *   - e.printStackTrace()  : 예외 발생 경로(스택 트레이스) 출력
 *   - e.getClass().getName(): 예외 클래스 이름 반환
 */
public class P01_TryCatch {

    public static void main(String[] args) {
        System.out.println("=== P01: try-catch 기본 예외 처리 ===\n");

        // 문제 1 ~ 4 순서대로 실행
        problem1_ArithmeticException();
        problem2_NumberFormatException();
        problem3_ArrayIndexOutOfBoundsException();
        problem4_ExceptionMessage();
    }

    // =========================================================
    // 문제 1: ArithmeticException — 0으로 나누기
    // =========================================================
    /**
     * [문제 1] 0으로 나누기 예외 처리
     *
     * 설명:
     *   정수를 0으로 나누면 ArithmeticException이 발생합니다.
     *   try-catch로 이 예외를 잡아 안전하게 처리하세요.
     *
     * 예상 출력:
     *   --- 문제 1: ArithmeticException ---
     *   10 / 2 = 5
     *   0으로 나눌 수 없습니다: / by zero
     *   프로그램이 계속 실행됩니다.
     *
     * 힌트:
     *   - int result = 10 / 0; 을 try 블록 안에 작성하세요.
     *   - catch (ArithmeticException e) 로 잡으세요.
     */
    static void problem1_ArithmeticException() {
        System.out.println("--- 문제 1: ArithmeticException ---");

        // TODO: 10 / 2 를 계산하여 결과를 출력하세요.

        // TODO: try-catch를 사용하여 10 / 0 을 시도하고
        //       ArithmeticException을 잡아 "0으로 나눌 수 없습니다: " + e.getMessage() 를 출력하세요.

        // TODO: catch 블록 이후 "프로그램이 계속 실행됩니다." 를 출력하세요.

        System.out.println();
    }

    // =========================================================
    // 문제 2: NumberFormatException — 잘못된 숫자 변환
    // =========================================================
    /**
     * [문제 2] 잘못된 문자열을 숫자로 변환할 때 예외 처리
     *
     * 설명:
     *   Integer.parseInt()에 숫자가 아닌 문자열을 전달하면
     *   NumberFormatException이 발생합니다.
     *
     * 예상 출력:
     *   --- 문제 2: NumberFormatException ---
     *   "123" 변환 성공: 123
     *   "abc" 변환 실패 - 숫자 형식 오류: For input string: "abc"
     *   "12.34" 변환 실패 - 숫자 형식 오류: For input string: "12.34"
     *
     * 힌트:
     *   - Integer.parseInt(str) 를 사용하세요.
     *   - parseNumber(String str) 헬퍼 메서드를 호출하세요.
     */
    static void problem2_NumberFormatException() {
        System.out.println("--- 문제 2: NumberFormatException ---");

        // TODO: parseNumber("123") 를 호출하여 결과를 출력하세요.
        // TODO: parseNumber("abc") 를 호출하여 예외를 처리하세요.
        // TODO: parseNumber("12.34") 를 호출하여 예외를 처리하세요.

        System.out.println();
    }

    /**
     * 문자열을 정수로 변환하는 헬퍼 메서드
     * @param str 변환할 문자열
     */
    static void parseNumber(String str) {
        // TODO: Integer.parseInt(str) 를 try 블록에서 시도하고
        //       성공 시 "\"" + str + "\" 변환 성공: " + 결과 출력,
        //       NumberFormatException 발생 시 "\"" + str + "\" 변환 실패 - 숫자 형식 오류: " + e.getMessage() 출력
    }

    // =========================================================
    // 문제 3: ArrayIndexOutOfBoundsException — 배열 인덱스 초과
    // =========================================================
    /**
     * [문제 3] 배열 인덱스 범위를 벗어날 때 예외 처리
     *
     * 설명:
     *   크기가 3인 배열에서 인덱스 5에 접근하면
     *   ArrayIndexOutOfBoundsException이 발생합니다.
     *
     * 예상 출력:
     *   --- 문제 3: ArrayIndexOutOfBoundsException ---
     *   arr[0] = 10
     *   arr[1] = 20
     *   arr[2] = 30
     *   인덱스 오류: Index 5 out of bounds for length 3
     *   유효한 인덱스 범위: 0 ~ 2
     *
     * 힌트:
     *   - int[] arr = {10, 20, 30}; 으로 배열을 선언하세요.
     *   - for 반복문으로 정상 접근을 출력한 뒤,
     *     arr[5] 접근 시 ArrayIndexOutOfBoundsException을 잡으세요.
     */
    static void problem3_ArrayIndexOutOfBoundsException() {
        System.out.println("--- 문제 3: ArrayIndexOutOfBoundsException ---");

        // TODO: int[] arr = {10, 20, 30}; 선언

        // TODO: for 반복문으로 arr의 모든 원소를 "arr[i] = 값" 형식으로 출력

        // TODO: try-catch로 arr[5] 접근을 시도하고
        //       ArrayIndexOutOfBoundsException을 잡아
        //       "인덱스 오류: " + e.getMessage() 출력 후
        //       "유효한 인덱스 범위: 0 ~ " + (arr.length - 1) 출력

        System.out.println();
    }

    // =========================================================
    // 문제 4: 예외 메시지 출력 — getMessage vs printStackTrace
    // =========================================================
    /**
     * [문제 4] 예외 정보 출력 방법 비교
     *
     * 설명:
     *   같은 예외를 잡아 getMessage()와 printStackTrace()의
     *   출력 차이를 확인합니다.
     *
     * 예상 출력:
     *   --- 문제 4: 예외 메시지 출력 ---
     *   [getMessage()] / by zero
     *   [getClass()] class java.lang.ArithmeticException
     *   [printStackTrace()] 아래에 스택 트레이스가 출력됩니다:
     *   java.lang.ArithmeticException: / by zero
     *       at P01_TryCatch.problem4_ExceptionMessage(P01_TryCatch.java:...)
     *       ...
     *
     * 힌트:
     *   - int x = 10 / 0; 을 try 블록에서 시도하세요.
     *   - catch 블록에서 e.getMessage(), e.getClass(), e.printStackTrace() 를 각각 호출하세요.
     */
    static void problem4_ExceptionMessage() {
        System.out.println("--- 문제 4: 예외 메시지 출력 ---");

        // TODO: try 블록에서 int x = 10 / 0; 을 시도하세요.

        // TODO: catch (ArithmeticException e) 블록에서:
        //       1) "[getMessage()] " + e.getMessage() 출력
        //       2) "[getClass()] " + e.getClass() 출력
        //       3) "[printStackTrace()] 아래에 스택 트레이스가 출력됩니다:" 출력 후 e.printStackTrace() 호출

        System.out.println();
    }
}
