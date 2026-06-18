/**
 * 파일명: P04_CustomExceptions.java
 * 주제: 사용자 정의 예외
 *
 * =============================================
 * 학습 목표
 * =============================================
 * 1. Exception을 상속받아 사용자 정의 예외 클래스를 작성한다.
 * 2. throws 키워드로 메서드 시그니처에 예외를 선언하고,
 *    throw 키워드로 예외 객체를 실제로 발생시키는 방법을 익힌다.
 * 3. 체크 예외(Checked Exception)와 언체크 예외(Unchecked Exception)의 차이를 이해한다.
 * 4. 예외 체이닝(Exception Chaining)을 통해 원인 예외를 보존하는 방법을 습득한다.
 *
 * =============================================
 * 핵심 개념 설명
 * =============================================
 * [사용자 정의 예외 작성 기본]
 *   class MyException extends Exception {
 *       public MyException(String message) {
 *           super(message);
 *       }
 *   }
 *
 * [throws vs throw]
 *   - throws : 메서드 선언부에 "이 메서드는 이 예외를 던질 수 있다" 고 명시
 *              예) public void method() throws MyException { ... }
 *   - throw  : 실제로 예외 객체를 생성하여 발생시킴
 *              예) throw new MyException("오류 메시지");
 *
 * [체크 예외 (Checked Exception)]
 *   - Exception을 직접 상속
 *   - 컴파일러가 처리 여부(try-catch 또는 throws)를 강제
 *   - 예) IOException, SQLException
 *
 * [언체크 예외 (Unchecked Exception)]
 *   - RuntimeException을 상속
 *   - 컴파일러가 처리 여부를 강제하지 않음
 *   - 예) NullPointerException, IllegalArgumentException
 *
 * [예외 체이닝 (Exception Chaining)]
 *   low-level 예외를 잡아 high-level 예외로 래핑할 때 원인을 보존합니다.
 *   throw new HighLevelException("메시지", originalException);
 *   나중에 e.getCause() 로 원인 예외를 꺼낼 수 있습니다.
 */
public class P04_CustomExceptions {

    public static void main(String[] args) {
        System.out.println("=== P04: 사용자 정의 예외 ===\n");

        problem1_InvalidAgeException();
        problem2_ThrowsAndThrow();
        problem3_CheckedVsUnchecked();
        problem4_ExceptionChaining();
    }

    // =========================================================
    // 문제 1: InvalidAgeException 클래스 만들기
    // =========================================================
    /**
     * [문제 1] 사용자 정의 예외 클래스 작성
     *
     * 설명:
     *   아래 파일 하단에 정의된 InvalidAgeException 클래스 뼈대를 완성하세요.
     *   - Exception을 상속
     *   - 생성자: InvalidAgeException(int age)
     *     메시지: "유효하지 않은 나이: " + age + " (0~150 범위여야 합니다)"
     *   - 잘못된 나이를 저장하는 invalidAge 필드와 getInvalidAge() 메서드 포함
     *
     * 예상 출력:
     *   --- 문제 1: InvalidAgeException ---
     *   나이 25 설정 완료
     *   예외 발생: 유효하지 않은 나이: -5 (0~150 범위여야 합니다)
     *   잘못된 나이 값: -5
     *   예외 발생: 유효하지 않은 나이: 200 (0~150 범위여야 합니다)
     *   잘못된 나이 값: 200
     *
     * 힌트:
     *   - setAge(int age) 메서드: age < 0 || age > 150 이면 throw new InvalidAgeException(age)
     *   - catch (InvalidAgeException e) 에서 e.getMessage(), e.getInvalidAge() 사용
     */
    static void problem1_InvalidAgeException() {
        System.out.println("--- 문제 1: InvalidAgeException ---");

        // TODO: setAge(25) 호출 — 정상 처리
        // TODO: try-catch로 setAge(-5) 호출 후
        //       "예외 발생: " + e.getMessage() 출력
        //       "잘못된 나이 값: " + e.getInvalidAge() 출력
        // TODO: try-catch로 setAge(200) 호출 후 동일하게 처리

        System.out.println();
    }

    /**
     * 나이를 설정하는 헬퍼 메서드
     * @param age 설정할 나이
     * @throws InvalidAgeException 나이가 0~150 범위를 벗어날 때
     */
    static void setAge(int age) throws InvalidAgeException {
        // TODO: age < 0 || age > 150 이면 throw new InvalidAgeException(age)
        // TODO: 정상이면 "나이 " + age + " 설정 완료" 출력
    }

    // =========================================================
    // 문제 2: throws로 예외 선언, throw로 예외 발생
    // =========================================================
    /**
     * [문제 2] throws와 throw 키워드 사용
     *
     * 설명:
     *   은행 계좌 입출금을 시뮬레이션합니다.
     *   - InsufficientBalanceException(체크 예외) 을 직접 정의하세요 (파일 하단).
     *   - withdraw(int amount, int balance) 메서드:
     *     throws InsufficientBalanceException 선언
     *     amount > balance 이면 throw new InsufficientBalanceException(amount, balance)
     *   - 호출 측에서 반드시 try-catch 또는 throws로 처리해야 합니다.
     *
     * 예상 출력:
     *   --- 문제 2: throws와 throw ---
     *   출금 성공: 잔액 = 50000원
     *   [InsufficientBalanceException] 잔액 부족: 출금 요청 80000원, 현재 잔액 50000원
     *
     * 힌트:
     *   - InsufficientBalanceException 생성자: (int requested, int available)
     *     메시지: "잔액 부족: 출금 요청 " + requested + "원, 현재 잔액 " + available + "원"
     */
    static void problem2_ThrowsAndThrow() {
        System.out.println("--- 문제 2: throws와 throw ---");

        // TODO: int balance = 50000; 선언
        // TODO: try 블록에서 withdraw(30000, balance) 호출 후
        //       balance를 갱신하고 "출금 성공: 잔액 = " + balance + "원" 출력
        // TODO: try-catch로 withdraw(80000, balance) 호출 후
        //       "[InsufficientBalanceException] " + e.getMessage() 출력

        System.out.println();
    }

    /**
     * 출금을 처리하는 헬퍼 메서드
     * @param amount  출금 금액
     * @param balance 현재 잔액
     * @return 출금 후 잔액
     * @throws InsufficientBalanceException 잔액이 부족할 때
     */
    static int withdraw(int amount, int balance) throws InsufficientBalanceException {
        // TODO: amount > balance 이면 throw new InsufficientBalanceException(amount, balance)
        // TODO: 정상이면 balance - amount 반환
        return 0; // 이 줄을 삭제하고 올바른 구조로 작성하세요
    }

    // =========================================================
    // 문제 3: 체크 예외 vs 언체크 예외
    // =========================================================
    /**
     * [문제 3] 체크 예외와 언체크 예외의 차이
     *
     * 설명:
     *   - checkedMethod() : CheckedException(Exception 상속)을 발생시킵니다.
     *     호출 시 반드시 try-catch 또는 throws 처리가 필요합니다.
     *   - uncheckedMethod() : UncheckedException(RuntimeException 상속)을 발생시킵니다.
     *     컴파일러가 처리를 강제하지 않습니다.
     *   두 메서드의 차이를 코드로 확인하세요.
     *
     * 예상 출력:
     *   --- 문제 3: 체크 예외 vs 언체크 예외 ---
     *   [체크 예외] 컴파일러가 처리를 강제합니다: 체크 예외 발생
     *   [언체크 예외] 컴파일러가 처리를 강제하지 않습니다: 언체크 예외 발생
     *
     * 힌트:
     *   - CheckedException은 파일 하단에 정의되어 있습니다. (Exception 상속)
     *   - UncheckedException은 파일 하단에 정의되어 있습니다. (RuntimeException 상속)
     *   - checkedMethod() 는 throws CheckedException 선언 필요
     */
    static void problem3_CheckedVsUnchecked() {
        System.out.println("--- 문제 3: 체크 예외 vs 언체크 예외 ---");

        // TODO: try-catch로 checkedMethod() 호출 후
        //       "[체크 예외] 컴파일러가 처리를 강제합니다: " + e.getMessage() 출력

        // TODO: try-catch로 uncheckedMethod() 호출 후
        //       "[언체크 예외] 컴파일러가 처리를 강제하지 않습니다: " + e.getMessage() 출력

        System.out.println();
    }

    /**
     * 체크 예외를 발생시키는 헬퍼 메서드
     * @throws CheckedException 항상 발생
     */
    static void checkedMethod() throws CheckedException {
        // TODO: throw new CheckedException("체크 예외 발생")
    }

    /**
     * 언체크 예외를 발생시키는 헬퍼 메서드
     */
    static void uncheckedMethod() {
        // TODO: throw new UncheckedException("언체크 예외 발생")
    }

    // =========================================================
    // 문제 4: 예외 체이닝 (cause 설정)
    // =========================================================
    /**
     * [문제 4] 예외 체이닝으로 원인 보존
     *
     * 설명:
     *   파일 로드 → 파싱 → 저장 의 3단계 처리에서
     *   각 단계의 저수준 예외를 고수준 예외로 래핑합니다.
     *   getCause()를 통해 원인 예외 체인을 추적하세요.
     *
     * 예상 출력:
     *   --- 문제 4: 예외 체이닝 ---
     *   최종 예외: 데이터 처리 파이프라인 실패
     *   원인 1: 파일 파싱 실패
     *   원인 2: 원본 파일을 찾을 수 없음: config.txt
     *
     * 힌트:
     *   - loadFile("config.txt")   : throw new RuntimeException("원본 파일을 찾을 수 없음: " + filename)
     *   - parseFile(filename)      : loadFile() 호출, catch 후
     *                                throw new RuntimeException("파일 파싱 실패", e)
     *   - processPipeline(filename): parseFile() 호출, catch 후
     *                                throw new RuntimeException("데이터 처리 파이프라인 실패", e)
     *   - main에서: e.getMessage(), e.getCause().getMessage(), e.getCause().getCause().getMessage() 출력
     */
    static void problem4_ExceptionChaining() {
        System.out.println("--- 문제 4: 예외 체이닝 ---");

        // TODO: try-catch로 processPipeline("config.txt") 호출 후
        //       "최종 예외: " + e.getMessage() 출력
        //       "원인 1: " + e.getCause().getMessage() 출력
        //       "원인 2: " + e.getCause().getCause().getMessage() 출력

        System.out.println();
    }

    /**
     * 파일 로드 시뮬레이션 헬퍼 메서드
     * @param filename 로드할 파일 이름
     * @throws RuntimeException 항상 파일 없음 예외 발생
     */
    static void loadFile(String filename) {
        // TODO: throw new RuntimeException("원본 파일을 찾을 수 없음: " + filename)
    }

    /**
     * 파일 파싱 시뮬레이션 헬퍼 메서드 — loadFile 예외를 래핑
     * @param filename 파싱할 파일 이름
     */
    static void parseFile(String filename) {
        // TODO: try 블록에서 loadFile(filename) 호출
        // TODO: catch (RuntimeException e) 에서
        //       throw new RuntimeException("파일 파싱 실패", e)
    }

    /**
     * 전체 처리 파이프라인 헬퍼 메서드 — parseFile 예외를 래핑
     * @param filename 처리할 파일 이름
     */
    static void processPipeline(String filename) {
        // TODO: try 블록에서 parseFile(filename) 호출
        // TODO: catch (RuntimeException e) 에서
        //       throw new RuntimeException("데이터 처리 파이프라인 실패", e)
    }

    // =========================================================
    // 사용자 정의 예외 클래스 정의
    // =========================================================

    /**
     * 문제 1: 유효하지 않은 나이 예외 (체크 예외)
     * - Exception을 상속
     */
    static class InvalidAgeException extends Exception {
        // TODO: private int invalidAge; 필드 선언

        // TODO: 생성자 InvalidAgeException(int age):
        //       super("유효하지 않은 나이: " + age + " (0~150 범위여야 합니다)")
        //       this.invalidAge = age;

        // TODO: getInvalidAge() 메서드: return invalidAge;
    }

    /**
     * 문제 2: 잔액 부족 예외 (체크 예외)
     * - Exception을 상속
     */
    static class InsufficientBalanceException extends Exception {
        // TODO: 생성자 InsufficientBalanceException(int requested, int available):
        //       super("잔액 부족: 출금 요청 " + requested + "원, 현재 잔액 " + available + "원")
    }

    /**
     * 문제 3: 체크 예외 예시
     * - Exception을 직접 상속 → 체크 예외
     */
    static class CheckedException extends Exception {
        // TODO: 생성자 CheckedException(String message): super(message)
    }

    /**
     * 문제 3: 언체크 예외 예시
     * - RuntimeException을 상속 → 언체크 예외
     */
    static class UncheckedException extends RuntimeException {
        // TODO: 생성자 UncheckedException(String message): super(message)
    }
}
