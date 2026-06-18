/**
 * 파일명: P02_MultipleExceptions.java
 * 주제: 다중 예외 처리
 *
 * =============================================
 * 학습 목표
 * =============================================
 * 1. 하나의 try 블록에 여러 catch를 연결하여 예외를 종류별로 처리한다.
 * 2. Java 7에서 도입된 multi-catch (|) 문법을 사용하여 코드를 간결하게 작성한다.
 * 3. 예외 계층 구조를 이해하고, catch 블록 순서가 왜 중요한지 파악한다.
 * 4. 예외를 다시 던지기(re-throw)로 상위 호출자에게 예외를 전파하는 방법을 익힌다.
 *
 * =============================================
 * 핵심 개념 설명
 * =============================================
 * [다중 catch 블록]
 *   try { ... }
 *   catch (NullPointerException e) { ... }   // 더 구체적인 예외 먼저
 *   catch (RuntimeException e)     { ... }   // 더 일반적인 예외 나중에
 *   catch (Exception e)            { ... }   // 가장 넓은 범위는 마지막
 *
 * [multi-catch (Java 7+)]
 *   catch (IOException | SQLException e) { ... }
 *   - 두 예외를 동일하게 처리할 때 사용
 *   - 두 예외가 상속 관계이면 컴파일 오류 발생
 *
 * [예외 계층 구조]
 *   Throwable
 *   ├── Error           (OutOfMemoryError 등 — 복구 불가)
 *   └── Exception
 *       ├── IOException (체크 예외)
 *       └── RuntimeException (언체크 예외)
 *           ├── ArithmeticException
 *           ├── NullPointerException
 *           ├── NumberFormatException
 *           └── ArrayIndexOutOfBoundsException
 *
 * [re-throw (예외 다시 던지기)]
 *   catch (Exception e) {
 *       // 일부 처리 후
 *       throw e;          // 같은 예외 다시 던지기
 *       // 또는
 *       throw new RuntimeException("래핑 메시지", e); // 새 예외로 감싸기
 *   }
 */
public class P02_MultipleExceptions {

    public static void main(String[] args) {
        System.out.println("=== P02: 다중 예외 처리 ===\n");

        problem1_MultipleCatchBlocks();
        problem2_MultiCatch();
        problem3_ExceptionHierarchy();
        problem4_ReThrow();
    }

    // =========================================================
    // 문제 1: 여러 catch 블록으로 각기 다른 예외 처리
    // =========================================================
    /**
     * [문제 1] 여러 catch 블록 사용하기
     *
     * 설명:
     *   processInput(String input, int index) 메서드를 완성하세요.
     *   - input이 null이면 NullPointerException 발생
     *   - input이 숫자가 아니면 NumberFormatException 발생
     *   - index가 배열 범위를 벗어나면 ArrayIndexOutOfBoundsException 발생
     *   각 예외마다 별도의 catch 블록으로 처리하세요.
     *
     * 예상 출력:
     *   --- 문제 1: 여러 catch 블록 ---
     *   입력 "42", 인덱스 1 처리 결과: 420
     *   [NullPointerException] 입력값이 null입니다.
     *   [NumberFormatException] 숫자가 아닌 입력: abc
     *   [ArrayIndexOutOfBoundsException] 잘못된 인덱스: Index 10 out of bounds for length 5
     *
     * 힌트:
     *   - int[] data = {10, 20, 30, 40, 50}; 사용
     *   - Integer.parseInt(input) * data[index] 계산
     *   - catch 블록을 NullPointerException, NumberFormatException,
     *     ArrayIndexOutOfBoundsException 순으로 작성하세요.
     */
    static void problem1_MultipleCatchBlocks() {
        System.out.println("--- 문제 1: 여러 catch 블록 ---");

        // TODO: processInput("42", 1) 호출
        // TODO: processInput(null, 1) 호출
        // TODO: processInput("abc", 1) 호출
        // TODO: processInput("42", 10) 호출

        System.out.println();
    }

    /**
     * 문자열 입력과 인덱스를 받아 계산을 수행하는 헬퍼 메서드
     * @param input 숫자 문자열
     * @param index 배열 인덱스
     */
    static void processInput(String input, int index) {
        int[] data = {10, 20, 30, 40, 50};

        // TODO: try 블록에서 Integer.parseInt(input) * data[index] 를 계산하고
        //       "입력 \"" + input + "\", 인덱스 " + index + " 처리 결과: " + 결과 출력

        // TODO: catch (NullPointerException e)   → "[NullPointerException] 입력값이 null입니다." 출력
        // TODO: catch (NumberFormatException e)  → "[NumberFormatException] 숫자가 아닌 입력: " + input 출력
        // TODO: catch (ArrayIndexOutOfBoundsException e) → "[ArrayIndexOutOfBoundsException] 잘못된 인덱스: " + e.getMessage() 출력
    }

    // =========================================================
    // 문제 2: multi-catch (Java 7+)
    // =========================================================
    /**
     * [문제 2] multi-catch 문법 사용하기
     *
     * 설명:
     *   parseAndDivide(String numStr, String denomStr) 메서드를 완성하세요.
     *   - 두 문자열을 정수로 파싱한 뒤 나눗셈을 수행합니다.
     *   - NumberFormatException과 ArithmeticException은 동일하게 처리합니다.
     *   - multi-catch 문법 (|) 을 반드시 사용하세요.
     *
     * 예상 출력:
     *   --- 문제 2: multi-catch ---
     *   10 / 2 = 5
     *   [입력/산술 오류] For input string: "두"
     *   [입력/산술 오류] / by zero
     *
     * 힌트:
     *   - catch (NumberFormatException | ArithmeticException e) 사용
     */
    static void problem2_MultiCatch() {
        System.out.println("--- 문제 2: multi-catch ---");

        // TODO: parseAndDivide("10", "2") 호출
        // TODO: parseAndDivide("10", "두") 호출
        // TODO: parseAndDivide("10", "0") 호출

        System.out.println();
    }

    /**
     * 두 문자열을 파싱하여 나눗셈을 수행하는 헬퍼 메서드
     * @param numStr   분자 문자열
     * @param denomStr 분모 문자열
     */
    static void parseAndDivide(String numStr, String denomStr) {
        // TODO: try 블록에서 두 문자열을 parseInt로 파싱 후 나눗셈 결과 출력
        // TODO: catch (NumberFormatException | ArithmeticException e) 로
        //       "[입력/산술 오류] " + e.getMessage() 출력
    }

    // =========================================================
    // 문제 3: 예외 계층 구조
    // =========================================================
    /**
     * [문제 3] catch 블록 순서와 예외 계층 구조
     *
     * 설명:
     *   catch 블록은 구체적인 예외 → 일반적인 예외 순서로 작성해야 합니다.
     *   순서가 잘못되면 컴파일 오류가 발생합니다.
     *   아래 메서드에서 올바른 catch 순서를 적용하세요.
     *
     * 예상 출력:
     *   --- 문제 3: 예외 계층 구조 ---
     *   테스트 1 - [ArithmeticException 처리] / by zero
     *   테스트 2 - [RuntimeException 처리] Index 99 out of bounds for length 3
     *   테스트 3 - [Exception 처리] null
     *
     * 힌트:
     *   - catch 순서: ArithmeticException → RuntimeException → Exception
     *   - NullPointerException은 RuntimeException의 하위 클래스입니다.
     *   - testHierarchy(int testCase) 에서 testCase 값에 따라 다른 예외 발생
     */
    static void problem3_ExceptionHierarchy() {
        System.out.println("--- 문제 3: 예외 계층 구조 ---");

        // TODO: testHierarchy(1), testHierarchy(2), testHierarchy(3) 호출
        //       각각 "테스트 " + testCase + " - " + 결과 출력

        System.out.println();
    }

    /**
     * testCase 값에 따라 서로 다른 예외를 발생시키는 헬퍼 메서드
     * @param testCase 1=ArithmeticException, 2=ArrayIndexOutOfBoundsException, 3=NullPointerException
     */
    static void testHierarchy(int testCase) {
        // TODO: try 블록에서:
        //       testCase == 1 : int x = 1 / 0;
        //       testCase == 2 : int[] arr = new int[3]; int y = arr[99];
        //       testCase == 3 : String s = null; s.length();

        // TODO: catch 순서 (구체적 → 일반적):
        //       catch (ArithmeticException e) → "[ArithmeticException 처리] " + e.getMessage()
        //       catch (RuntimeException e)    → "[RuntimeException 처리] " + e.getMessage()
        //       catch (Exception e)           → "[Exception 처리] " + e.getMessage()
    }

    // =========================================================
    // 문제 4: 예외를 다시 던지기 (re-throw)
    // =========================================================
    /**
     * [문제 4] 예외 re-throw
     *
     * 설명:
     *   loadData(int id) 메서드는 id가 0 이하이면 IllegalArgumentException을 발생시킵니다.
     *   processData(int id) 메서드는 loadData()를 호출하고,
     *   예외를 로깅한 뒤 RuntimeException으로 래핑하여 다시 던집니다.
     *   main에서 processData()를 호출하고 최종 예외를 처리하세요.
     *
     * 예상 출력:
     *   --- 문제 4: re-throw ---
     *   데이터 로드 성공: ID=5
     *   [processData 로그] 데이터 처리 실패 - 원인: ID는 양수여야 합니다: -1
     *   [main] 처리 중 오류 발생: 데이터 처리 실패
     *   [원인] ID는 양수여야 합니다: -1
     *
     * 힌트:
     *   - loadData() 에서 id <= 0 이면 throw new IllegalArgumentException("ID는 양수여야 합니다: " + id)
     *   - processData() 에서 catch 후 로그 출력, throw new RuntimeException("데이터 처리 실패", e)
     *   - main에서 최종 catch 시 e.getMessage() 와 e.getCause().getMessage() 출력
     */
    static void problem4_ReThrow() {
        System.out.println("--- 문제 4: re-throw ---");

        // TODO: processData(5) 호출 (정상 처리)
        // TODO: try-catch로 processData(-1) 호출 후
        //       "[main] 처리 중 오류 발생: " + e.getMessage() 출력
        //       "[원인] " + e.getCause().getMessage() 출력

        System.out.println();
    }

    /**
     * 주어진 ID로 데이터를 로드하는 헬퍼 메서드
     * @param id 데이터 ID (양수여야 함)
     * @throws IllegalArgumentException id가 0 이하일 때
     */
    static void loadData(int id) {
        // TODO: id <= 0 이면 throw new IllegalArgumentException("ID는 양수여야 합니다: " + id)
        // TODO: 정상이면 "데이터 로드 성공: ID=" + id 출력
    }

    /**
     * 데이터를 처리하는 헬퍼 메서드 — 내부 예외를 래핑하여 다시 던짐
     * @param id 데이터 ID
     * @throws RuntimeException loadData() 실패 시 래핑하여 던짐
     */
    static void processData(int id) {
        // TODO: try 블록에서 loadData(id) 호출
        // TODO: catch (IllegalArgumentException e) 에서:
        //       "[processData 로그] 데이터 처리 실패 - 원인: " + e.getMessage() 출력
        //       throw new RuntimeException("데이터 처리 실패", e)
    }
}
