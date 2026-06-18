/**
 * 파일명: P03_FinallyBlock.java
 * 주제: finally 블록
 *
 * =============================================
 * 학습 목표
 * =============================================
 * 1. finally 블록이 예외 발생 여부와 무관하게 항상 실행됨을 이해한다.
 * 2. try-catch-finally 패턴으로 자원(연결, 파일 등)을 안전하게 정리하는 방법을 익힌다.
 * 3. return 문이 있어도 finally 블록이 실행되는 동작을 확인한다.
 *
 * =============================================
 * 핵심 개념 설명
 * =============================================
 * [try-catch-finally 구조]
 *   try {
 *       // 예외가 발생할 수 있는 코드
 *   } catch (Exception e) {
 *       // 예외 처리
 *   } finally {
 *       // 예외 발생 여부와 무관하게 항상 실행
 *       // 주로 자원 해제(close, disconnect 등)에 사용
 *   }
 *
 * [finally가 실행되지 않는 극히 드문 경우]
 *   - System.exit() 호출
 *   - JVM 크래시
 *   - 무한 루프로 try/catch가 끝나지 않는 경우
 *
 * [return과 finally의 관계]
 *   try 블록에서 return을 만나도 finally가 먼저 실행된 후 반환됩니다.
 *   finally 블록에서도 return을 사용하면 try의 return 값이 무시됩니다.
 *   (finally에서 return 사용은 권장하지 않음)
 *
 * [자원 정리 패턴]
 *   Resource res = null;
 *   try {
 *       res = new Resource();
 *       res.use();
 *   } catch (Exception e) {
 *       // 예외 처리
 *   } finally {
 *       if (res != null) res.close();  // 항상 자원 해제
 *   }
 */
public class P03_FinallyBlock {

    public static void main(String[] args) {
        System.out.println("=== P03: finally 블록 ===\n");

        problem1_FinallyAlwaysRuns();
        problem2_ResourceCleanup();
        problem3_ReturnWithFinally();
    }

    // =========================================================
    // 문제 1: finally가 항상 실행되는 것 확인
    // =========================================================
    /**
     * [문제 1] finally 블록의 항상 실행 보장
     *
     * 설명:
     *   testFinally(boolean causeException) 메서드를 완성하세요.
     *   - causeException이 true이면 예외를 발생시키고,
     *     false이면 정상 실행합니다.
     *   - 두 경우 모두 finally 블록이 실행되는지 확인하세요.
     *
     * 예상 출력:
     *   --- 문제 1: finally 항상 실행 ---
     *   [정상 실행]
     *   try 블록 실행 중...
     *   정상 처리 완료
     *   finally 블록 실행됨 (항상 실행)
     *
     *   [예외 발생]
     *   try 블록 실행 중...
     *   catch 블록: 의도적인 예외 발생
     *   finally 블록 실행됨 (항상 실행)
     *
     * 힌트:
     *   - causeException이 true면 throw new RuntimeException("의도적인 예외 발생")
     *   - finally 블록에서 "finally 블록 실행됨 (항상 실행)" 출력
     */
    static void problem1_FinallyAlwaysRuns() {
        System.out.println("--- 문제 1: finally 항상 실행 ---");

        System.out.println("[정상 실행]");
        // TODO: testFinally(false) 호출

        System.out.println("\n[예외 발생]");
        // TODO: testFinally(true) 호출

        System.out.println();
    }

    /**
     * finally가 항상 실행됨을 보여주는 헬퍼 메서드
     * @param causeException true면 예외 발생
     */
    static void testFinally(boolean causeException) {
        // TODO: try 블록에서:
        //       "try 블록 실행 중..." 출력
        //       causeException이 true면 throw new RuntimeException("의도적인 예외 발생")
        //       false면 "정상 처리 완료" 출력

        // TODO: catch (RuntimeException e) 에서:
        //       "catch 블록: " + e.getMessage() 출력

        // TODO: finally 블록에서:
        //       "finally 블록 실행됨 (항상 실행)" 출력
    }

    // =========================================================
    // 문제 2: try-catch-finally로 자원 정리 패턴
    // =========================================================
    /**
     * [문제 2] finally를 활용한 자원 정리
     *
     * 설명:
     *   DatabaseConnection 내부 클래스(아래 정의됨)를 사용하여
     *   데이터베이스 연결을 열고, 쿼리를 실행하고, 반드시 연결을 닫는
     *   패턴을 구현하세요.
     *   예외가 발생해도 연결이 반드시 닫혀야 합니다.
     *
     * 예상 출력 (정상):
     *   --- 문제 2: 자원 정리 패턴 ---
     *   [정상 쿼리]
     *   DB 연결 열림
     *   쿼리 실행: SELECT * FROM users
     *   DB 연결 닫힘
     *
     * 예상 출력 (오류):
     *   [오류 쿼리]
     *   DB 연결 열림
     *   [오류] 잘못된 쿼리입니다: null query
     *   DB 연결 닫힘
     *
     * 힌트:
     *   - DatabaseConnection conn = null; 로 선언한 뒤 try 블록에서 초기화
     *   - finally 블록에서 conn != null 확인 후 conn.close() 호출
     *   - executeQuery(null) 은 예외를 발생시킵니다.
     */
    static void problem2_ResourceCleanup() {
        System.out.println("--- 문제 2: 자원 정리 패턴 ---");

        System.out.println("[정상 쿼리]");
        // TODO: DatabaseConnection conn = null; 선언
        // TODO: try 블록에서 conn = new DatabaseConnection(); conn.open();
        //       conn.executeQuery("SELECT * FROM users") 호출
        // TODO: catch (Exception e) → "[오류] " + e.getMessage() 출력
        // TODO: finally 블록에서 conn != null 이면 conn.close() 호출

        System.out.println("\n[오류 쿼리]");
        // TODO: 위와 동일한 패턴으로 conn.executeQuery(null) 호출 (예외 발생)

        System.out.println();
    }

    // =========================================================
    // 문제 3: return이 있어도 finally 실행됨 확인
    // =========================================================
    /**
     * [문제 3] return 문과 finally 블록
     *
     * 설명:
     *   getValueWithFinally() 메서드는 try 블록에서 return 10을 실행합니다.
     *   그럼에도 finally 블록이 먼저 실행됩니다.
     *   실행 순서를 확인하고, finally에서 return을 사용하면 어떻게 되는지도 확인하세요.
     *
     * 예상 출력:
     *   --- 문제 3: return이 있어도 finally 실행 ---
     *   getValueWithFinally() 호출 시작
     *   try 블록: return 10 직전
     *   finally 블록: return 전에 실행됨
     *   반환값: 10
     *
     *   getValueFinallyOverride() 호출 시작
     *   try 블록: return 10 직전
     *   finally 블록: return 99 (try의 return 10 을 덮어씀)
     *   반환값: 99
     *
     * 힌트:
     *   - getValueWithFinally() : try에서 return 10, finally에서 출력만
     *   - getValueFinallyOverride() : try에서 return 10, finally에서 return 99
     *     (finally의 return이 try의 return을 덮어씁니다 — 권장하지 않는 패턴)
     */
    static void problem3_ReturnWithFinally() {
        System.out.println("--- 문제 3: return이 있어도 finally 실행 ---");

        System.out.println("getValueWithFinally() 호출 시작");
        // TODO: int result1 = getValueWithFinally(); 호출 후 "반환값: " + result1 출력

        System.out.println();
        System.out.println("getValueFinallyOverride() 호출 시작");
        // TODO: int result2 = getValueFinallyOverride(); 호출 후 "반환값: " + result2 출력

        System.out.println();
    }

    /**
     * try 블록에서 return을 해도 finally가 먼저 실행됨을 보여주는 헬퍼 메서드
     * @return try 블록의 return 값
     */
    static int getValueWithFinally() {
        // TODO: try 블록에서:
        //       "try 블록: return 10 직전" 출력
        //       return 10;

        // TODO: finally 블록에서:
        //       "finally 블록: return 전에 실행됨" 출력
        return 0; // 이 줄을 삭제하고 올바른 구조로 작성하세요
    }

    /**
     * finally 블록의 return이 try 블록의 return을 덮어쓰는 것을 보여주는 헬퍼 메서드
     * (실제 코드에서는 권장하지 않는 패턴)
     * @return finally 블록의 return 값
     */
    static int getValueFinallyOverride() {
        // TODO: try 블록에서:
        //       "try 블록: return 10 직전" 출력
        //       return 10;

        // TODO: finally 블록에서:
        //       "finally 블록: return 99 (try의 return 10 을 덮어씀)" 출력
        //       return 99;
        return 0; // 이 줄을 삭제하고 올바른 구조로 작성하세요
    }

    // =========================================================
    // 내부 클래스: 문제 2에서 사용하는 DB 연결 시뮬레이션
    // =========================================================
    /**
     * 데이터베이스 연결을 시뮬레이션하는 내부 클래스
     * 실제 DB 연결 대신 콘솔 출력으로 동작을 시뮬레이션합니다.
     */
    static class DatabaseConnection {

        private boolean isOpen = false;

        /** 연결을 여는 메서드 */
        void open() {
            isOpen = true;
            System.out.println("DB 연결 열림");
        }

        /**
         * 쿼리를 실행하는 메서드
         * @param query 실행할 쿼리 (null이면 예외 발생)
         * @throws IllegalArgumentException query가 null일 때
         */
        void executeQuery(String query) {
            if (query == null) {
                throw new IllegalArgumentException("null query");
            }
            System.out.println("쿼리 실행: " + query);
        }

        /** 연결을 닫는 메서드 */
        void close() {
            if (isOpen) {
                isOpen = false;
                System.out.println("DB 연결 닫힘");
            }
        }
    }
}
