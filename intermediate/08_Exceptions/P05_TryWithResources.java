/**
 * 파일명: P05_TryWithResources.java
 * 주제: try-with-resources (Java 7+)
 *
 * =============================================
 * 학습 목표
 * =============================================
 * 1. AutoCloseable 인터페이스를 구현하여 자동으로 닫히는 자원 클래스를 작성한다.
 * 2. try-with-resources 구문으로 자원이 자동으로 close()됨을 확인한다.
 * 3. 파일 처리에서 try-with-resources를 활용하여 안전한 I/O 코드를 작성한다.
 *
 * =============================================
 * 핵심 개념 설명
 * =============================================
 * [try-with-resources 구조 (Java 7+)]
 *   try (ResourceType res = new ResourceType()) {
 *       // res 사용
 *   } catch (Exception e) {
 *       // 예외 처리
 *   }
 *   // try 블록이 끝나면 res.close() 가 자동 호출됨
 *   // 예외가 발생해도 close() 보장
 *
 * [AutoCloseable 인터페이스]
 *   interface AutoCloseable {
 *       void close() throws Exception;
 *   }
 *   이 인터페이스를 구현한 클래스만 try-with-resources에서 사용 가능합니다.
 *
 * [기존 finally 방식 vs try-with-resources 비교]
 *   [before - finally 사용]
 *   Connection conn = null;
 *   try {
 *       conn = getConnection();
 *       conn.use();
 *   } finally {
 *       if (conn != null) conn.close();
 *   }
 *
 *   [after - try-with-resources 사용]
 *   try (Connection conn = getConnection()) {
 *       conn.use();
 *   }  // conn.close() 자동 호출
 *
 * [여러 자원을 동시에 관리]
 *   try (Resource1 r1 = new Resource1();
 *        Resource2 r2 = new Resource2()) {
 *       // r1, r2 모두 자동으로 close됨
 *       // close 순서: 선언의 역순 (r2 먼저, r1 나중)
 *   }
 *
 * [Suppressed Exception]
 *   try 블록에서 예외 A 발생 + close() 에서 예외 B 발생 시
 *   예외 A가 주 예외, 예외 B는 억압된(suppressed) 예외로 보존됩니다.
 *   e.getSuppressed() 로 억압된 예외를 확인할 수 있습니다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P05_TryWithResources {

    public static void main(String[] args) {
        System.out.println("=== P05: try-with-resources ===\n");

        problem1_AutoCloseable();
        problem2_AutoCloseVerification();
        problem3_FileHandling();
    }

    // =========================================================
    // 문제 1: AutoCloseable 구현한 커스텀 자원 클래스
    // =========================================================
    /**
     * [문제 1] AutoCloseable을 구현하는 커스텀 자원 클래스 작성
     *
     * 설명:
     *   아래에 정의된 NetworkConnection 클래스 뼈대를 완성하세요.
     *   - AutoCloseable을 implements
     *   - connect() : "네트워크 연결: " + host + ":" + port 출력
     *   - sendData(String data) : "데이터 전송: " + data 출력
     *                             data가 null이면 IOException 발생
     *   - close() : "네트워크 연결 해제: " + host 출력
     *
     * 예상 출력:
     *   --- 문제 1: AutoCloseable 커스텀 자원 ---
     *   네트워크 연결: example.com:8080
     *   데이터 전송: Hello, Server!
     *   네트워크 연결 해제: example.com
     *   자원이 자동으로 닫혔습니다.
     *
     * 힌트:
     *   - try (NetworkConnection conn = new NetworkConnection("example.com", 8080)) 사용
     *   - conn.connect() 와 conn.sendData("Hello, Server!") 호출
     *   - try 블록 종료 후 "자원이 자동으로 닫혔습니다." 출력
     */
    static void problem1_AutoCloseable() {
        System.out.println("--- 문제 1: AutoCloseable 커스텀 자원 ---");

        // TODO: try (NetworkConnection conn = new NetworkConnection("example.com", 8080)) 블록 작성
        //       conn.connect() 호출
        //       conn.sendData("Hello, Server!") 호출
        // TODO: catch (Exception e) → e.getMessage() 출력
        // TODO: try 블록 종료 후 "자원이 자동으로 닫혔습니다." 출력

        System.out.println();
    }

    // =========================================================
    // 문제 2: try-with-resources로 자동 close 확인
    // =========================================================
    /**
     * [문제 2] 예외 발생 시에도 자동 close 보장 확인
     *
     * 설명:
     *   try-with-resources에서 예외가 발생해도 close()가 자동으로 호출됩니다.
     *   정상 케이스와 예외 케이스 모두에서 close()가 실행되는지 확인하세요.
     *   또한 여러 자원을 동시에 열 때 close 순서(선언의 역순)를 확인하세요.
     *
     * 예상 출력:
     *   --- 문제 2: 자동 close 확인 ---
     *   [정상 케이스]
     *   ManagedResource[A] 열림
     *   ManagedResource[A] 사용 중
     *   ManagedResource[A] 닫힘 (자동)
     *
     *   [예외 케이스]
     *   ManagedResource[B] 열림
     *   [예외 발생] 강제 오류
     *   ManagedResource[B] 닫힘 (자동)
     *
     *   [다중 자원 케이스 - close 역순]
     *   ManagedResource[R1] 열림
     *   ManagedResource[R2] 열림
     *   두 자원 모두 사용 중
     *   ManagedResource[R2] 닫힘 (자동)
     *   ManagedResource[R1] 닫힘 (자동)
     *
     * 힌트:
     *   - ManagedResource 클래스는 파일 하단에 뼈대가 있습니다.
     *   - 예외 케이스: try 블록 내에서 throw new RuntimeException("강제 오류")
     *   - 다중 자원: try (ManagedResource r1 = ...; ManagedResource r2 = ...) 사용
     */
    static void problem2_AutoCloseVerification() {
        System.out.println("--- 문제 2: 자동 close 확인 ---");

        System.out.println("[정상 케이스]");
        // TODO: try (ManagedResource resA = new ManagedResource("A")) 블록 작성
        //       resA 사용 ("ManagedResource[A] 사용 중" 출력)
        // TODO: catch 블록은 작성하지 않아도 됨 (정상 케이스)

        System.out.println("\n[예외 케이스]");
        // TODO: try (ManagedResource resB = new ManagedResource("B")) 블록 작성
        //       throw new RuntimeException("강제 오류") 발생
        // TODO: catch (RuntimeException e) → "[예외 발생] " + e.getMessage() 출력
        //       (close는 예외 처리 전에 자동으로 실행됨)

        System.out.println("\n[다중 자원 케이스 - close 역순]");
        // TODO: try (ManagedResource r1 = new ManagedResource("R1");
        //            ManagedResource r2 = new ManagedResource("R2")) 블록 작성
        //       "두 자원 모두 사용 중" 출력

        System.out.println();
    }

    // =========================================================
    // 문제 3: 파일 처리에서 try-with-resources 활용
    // =========================================================
    /**
     * [문제 3] 파일 쓰기와 읽기에 try-with-resources 적용
     *
     * 설명:
     *   writeToFile(String filename, String content) :
     *     BufferedWriter를 try-with-resources로 열어 내용을 씁니다.
     *   readFromFile(String filename) :
     *     BufferedReader를 try-with-resources로 열어 한 줄씩 읽습니다.
     *
     * 예상 출력:
     *   --- 문제 3: 파일 처리 ---
     *   파일 쓰기 완료: test_output.txt
     *   파일 읽기 시작: test_output.txt
     *   줄 1: 자바 예외 처리 연습
     *   줄 2: try-with-resources 파일 I/O
     *   줄 3: 파일 처리 완료!
     *   파일 읽기 완료
     *
     * 힌트:
     *   - writeToFile: try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
     *                  bw.write(content) 와 bw.newLine() 사용
     *   - readFromFile: try (BufferedReader br = new BufferedReader(new FileReader(filename)))
     *                   br.readLine() 로 한 줄씩 읽고 null이 아닌 동안 출력
     *   - IOException을 catch 해야 합니다.
     */
    static void problem3_FileHandling() {
        System.out.println("--- 문제 3: 파일 처리 ---");

        String filename = "test_output.txt";
        String[] lines = {
            "자바 예외 처리 연습",
            "try-with-resources 파일 I/O",
            "파일 처리 완료!"
        };

        // TODO: writeToFile(filename, lines) 호출
        // TODO: readFromFile(filename) 호출

        System.out.println();
    }

    /**
     * 파일에 여러 줄을 쓰는 헬퍼 메서드
     * @param filename 쓸 파일 경로
     * @param lines    쓸 문자열 배열
     */
    static void writeToFile(String filename, String[] lines) {
        // TODO: try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) 블록 작성
        //       lines 배열의 각 줄을 bw.write(line) 과 bw.newLine() 으로 씀
        //       "파일 쓰기 완료: " + filename 출력
        // TODO: catch (IOException e) → "파일 쓰기 오류: " + e.getMessage() 출력
    }

    /**
     * 파일을 한 줄씩 읽어 출력하는 헬퍼 메서드
     * @param filename 읽을 파일 경로
     */
    static void readFromFile(String filename) {
        // TODO: "파일 읽기 시작: " + filename 출력
        // TODO: try (BufferedReader br = new BufferedReader(new FileReader(filename))) 블록 작성
        //       String line; int lineNum = 1;
        //       while ((line = br.readLine()) != null) 루프로
        //       "줄 " + lineNum + ": " + line 출력 후 lineNum++
        //       "파일 읽기 완료" 출력
        // TODO: catch (IOException e) → "파일 읽기 오류: " + e.getMessage() 출력
    }

    // =========================================================
    // 내부 클래스 정의
    // =========================================================

    /**
     * 문제 1: 네트워크 연결을 시뮬레이션하는 AutoCloseable 구현 클래스
     */
    static class NetworkConnection implements AutoCloseable {

        private final String host;
        private final int port;

        public NetworkConnection(String host, int port) {
            this.host = host;
            this.port = port;
        }

        /** 연결을 여는 메서드 */
        void connect() {
            // TODO: "네트워크 연결: " + host + ":" + port 출력
        }

        /**
         * 데이터를 전송하는 메서드
         * @param data 전송할 데이터 (null이면 IOException 발생)
         * @throws IOException data가 null일 때
         */
        void sendData(String data) throws IOException {
            // TODO: data == null 이면 throw new IOException("전송할 데이터가 null입니다.")
            // TODO: 정상이면 "데이터 전송: " + data 출력
        }

        /**
         * AutoCloseable의 close 메서드 구현
         * try-with-resources 종료 시 자동 호출됩니다.
         */
        @Override
        public void close() {
            // TODO: "네트워크 연결 해제: " + host 출력
        }
    }

    /**
     * 문제 2: 자동 close 확인용 관리 자원 클래스
     */
    static class ManagedResource implements AutoCloseable {

        private final String name;

        public ManagedResource(String name) {
            this.name = name;
            // TODO: "ManagedResource[" + name + "] 열림" 출력
        }

        @Override
        public void close() {
            // TODO: "ManagedResource[" + name + "] 닫힘 (자동)" 출력
        }
    }
}
