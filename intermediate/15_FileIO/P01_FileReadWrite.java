/**
 * ================================================================
 * 파일명: P01_FileReadWrite.java
 * 주제: 파일 읽기/쓰기 기본 (File Read/Write Basics)
 * ================================================================
 *
 * 【학습 목표】
 * 1. FileWriter/FileReader를 사용하여 텍스트 파일을 쓰고 읽는 방법을 이해한다.
 * 2. BufferedWriter/BufferedReader를 통해 효율적인 파일 입출력을 구현한다.
 * 3. try-with-resources 문법으로 자원을 자동으로 안전하게 해제한다.
 *
 * 【핵심 개념】
 * - FileWriter: 문자 단위로 파일에 데이터를 쓰는 스트림
 *   생성자: new FileWriter("경로") - 덮어쓰기
 *          new FileWriter("경로", true) - 추가 모드(append)
 * - FileReader: 문자 단위로 파일에서 데이터를 읽는 스트림
 * - BufferedWriter/BufferedReader: 버퍼를 사용하여 성능을 향상시킨 스트림
 *   BufferedWriter에는 newLine() 메소드 제공
 *   BufferedReader에는 readLine() 메소드 제공 (줄 단위 읽기)
 * - try-with-resources: Java 7+, AutoCloseable을 구현한 자원을 자동으로 close()
 *   문법: try (자원선언) { } - finally 블록 없이도 자원이 반드시 닫힘
 * - 파일 경로: 절대 경로("C:/temp/file.txt") 또는 상대 경로("output/file.txt")
 * ================================================================
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P01_FileReadWrite {

    // ================================================================
    // 문제 1: FileWriter / FileReader로 텍스트 파일 쓰기/읽기
    // ================================================================
    /**
     * 【문제 1】 FileWriter/FileReader 기본 사용
     *
     * 설명:
     *   (1) writeWithFileWriter() 메소드:
     *       FileWriter를 사용하여 "hello_java.txt" 파일에 다음 내용을 작성하세요.
     *       내용:
     *         안녕하세요, Java 파일 IO입니다.
     *         FileWriter로 텍스트를 씁니다.
     *         세 번째 줄입니다.
     *
     *   (2) readWithFileReader() 메소드:
     *       FileReader를 사용하여 "hello_java.txt" 파일을 문자 단위로 읽어 출력하세요.
     *       read()는 한 문자씩 읽으며, -1을 반환하면 파일 끝입니다.
     *
     *   (3) appendWithFileWriter() 메소드:
     *       추가 모드(append=true)로 "hello_java.txt"에 내용을 추가하세요.
     *       추가 내용: "\n추가된 네 번째 줄입니다."
     *
     * 예상 출력:
     *   [FileWriter 쓰기 완료] hello_java.txt 파일이 생성되었습니다.
     *   [FileReader 읽기]:
     *   안녕하세요, Java 파일 IO입니다.
     *   FileWriter로 텍스트를 씁니다.
     *   세 번째 줄입니다.
     *   [FileWriter 추가 완료] 내용이 추가되었습니다.
     *
     * 힌트:
     *   - FileWriter fw = new FileWriter("hello_java.txt");
     *   - fw.write("텍스트"); 로 내용을 씁니다.
     *   - '\n' 또는 System.lineSeparator()로 줄바꿈을 추가합니다.
     *   - FileReader fr = new FileReader("hello_java.txt");
     *   - int ch; while ((ch = fr.read()) != -1) { System.out.print((char)ch); }
     *   - 반드시 close()를 호출하거나 try-with-resources를 사용하세요.
     */
    static void writeWithFileWriter(String filename) throws IOException {
        // TODO: FileWriter로 파일 쓰기 구현
        //       try 블록에서 FileWriter 생성 후 3줄 내용 작성
        //       finally 또는 try-with-resources로 close() 보장
        //       완료 메시지 출력
    }

    static void readWithFileReader(String filename) throws IOException {
        // TODO: FileReader로 파일 읽기 구현
        //       read()로 한 문자씩 읽어 출력 (-1이면 종료)
        //       try-with-resources 사용 권장
    }

    static void appendWithFileWriter(String filename, String content) throws IOException {
        // TODO: FileWriter를 추가 모드(append=true)로 열어 내용 추가
        //       완료 메시지 출력
    }

    // ================================================================
    // 문제 2: BufferedWriter / BufferedReader로 효율적 처리
    // ================================================================
    /**
     * 【문제 2】 BufferedWriter/BufferedReader 사용
     *
     * 설명:
     *   (1) writeWithBufferedWriter() 메소드:
     *       BufferedWriter로 "students.txt" 파일에 학생 목록을 작성하세요.
     *       학생 목록:
     *         홍길동,20,컴퓨터공학
     *         김영희,22,전자공학
     *         이철수,21,수학
     *         박지수,23,물리학
     *       각 학생 정보는 한 줄씩 저장합니다 (bw.newLine() 사용).
     *
     *   (2) readWithBufferedReader() 메소드:
     *       BufferedReader로 "students.txt"를 줄 단위로 읽어
     *       각 줄을 파싱하여 학생 정보를 출력하세요.
     *       출력 형식: "이름: X, 나이: Y, 전공: Z"
     *
     *   (3) countLinesWithBufferedReader() 메소드:
     *       BufferedReader로 파일을 읽어 총 줄 수를 반환하세요.
     *
     * 예상 출력:
     *   [BufferedWriter 쓰기 완료] students.txt 파일에 4명 저장되었습니다.
     *   [BufferedReader 읽기]:
     *   이름: 홍길동, 나이: 20, 전공: 컴퓨터공학
     *   이름: 김영희, 나이: 22, 전공: 전자공학
     *   이름: 이철수, 나이: 21, 전공: 수학
     *   이름: 박지수, 나이: 23, 전공: 물리학
     *   [줄 수] students.txt: 총 4줄
     *
     * 힌트:
     *   - BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
     *   - bw.write("내용"); bw.newLine(); 으로 줄바꿈 포함하여 작성
     *   - BufferedReader br = new BufferedReader(new FileReader(filename));
     *   - String line; while ((line = br.readLine()) != null) { ... }
     *   - line.split(",")으로 CSV 데이터 파싱 가능
     */
    static void writeWithBufferedWriter(String filename, String[] students) throws IOException {
        // TODO: BufferedWriter로 학생 목록 파일 작성
        //       try-with-resources 사용
        //       각 학생 정보를 한 줄씩 저장 (newLine() 사용)
        //       완료 메시지 출력
    }

    static void readWithBufferedReader(String filename) throws IOException {
        // TODO: BufferedReader로 줄 단위로 읽어 파싱 후 출력
        //       line.split(",")으로 이름, 나이, 전공 분리
    }

    static int countLinesWithBufferedReader(String filename) throws IOException {
        // TODO: BufferedReader로 파일의 총 줄 수를 세어 반환
        return 0; // TODO: 실제 줄 수 반환
    }

    // ================================================================
    // 문제 3: try-with-resources로 자원 자동 해제
    // ================================================================
    /**
     * 【문제 3】 try-with-resources와 예외 처리
     *
     * 설명:
     *   (1) safeCopyFile() 메소드:
     *       try-with-resources를 사용하여 소스 파일을 읽고 대상 파일에 복사하세요.
     *       BufferedReader와 BufferedWriter를 하나의 try 문에서 함께 선언하세요.
     *       복사 중 진행 상황(복사된 줄 수)을 출력하세요.
     *
     *   (2) safeReadFile() 메소드:
     *       존재하지 않는 파일을 읽을 때 FileNotFoundException을 처리하세요.
     *       파일이 없으면 "파일을 찾을 수 없습니다: [파일명]" 메시지를 출력하세요.
     *       파일이 있으면 내용을 읽어 List<String>으로 반환하세요.
     *
     *   (3) writeAndReadDemo() 메소드:
     *       "demo.txt"에 숫자 1~10을 한 줄씩 쓰고, 다시 읽어서 합계를 계산하세요.
     *       쓰기와 읽기 모두 try-with-resources를 사용하세요.
     *
     * 예상 출력:
     *   [파일 복사]
     *   줄 1 복사됨
     *   줄 2 복사됨
     *   ...
     *   students.txt -> students_copy.txt 복사 완료 (4줄)
     *
     *   [안전한 파일 읽기]
     *   파일을 찾을 수 없습니다: notexist.txt
     *
     *   [쓰기 후 읽기]
     *   demo.txt에 1~10 저장 완료
     *   읽기 완료. 합계: 55
     *
     * 힌트:
     *   - try-with-resources 다중 자원:
     *     try (BufferedReader br = ...; BufferedWriter bw = ...) { ... }
     *   - 자원은 선언 역순으로 자동 close됩니다.
     *   - catch (FileNotFoundException e) { e.getMessage()로 파일명 얻기 }
     *   - Integer.parseInt(line)으로 문자열을 정수로 변환
     */
    static void safeCopyFile(String source, String destination) throws IOException {
        // TODO: try-with-resources로 BufferedReader와 BufferedWriter 동시 선언
        //       소스 파일을 줄 단위로 읽어 대상 파일에 씀
        //       각 줄마다 "줄 N 복사됨" 출력
        //       완료 메시지 출력
    }

    static List<String> safeReadFile(String filename) {
        // TODO: try-with-resources로 파일 읽기
        //       FileNotFoundException 처리: 파일 없으면 빈 리스트 반환 + 메시지 출력
        //       파일 있으면 모든 줄을 List에 담아 반환
        return new ArrayList<>(); // TODO: 실제 반환값으로 수정
    }

    static void writeAndReadDemo(String filename) throws IOException {
        // TODO: try-with-resources로 1~10을 파일에 쓰기
        //       완료 메시지 출력
        // TODO: try-with-resources로 파일 읽어 합계 계산
        //       Integer.parseInt(line)으로 변환 후 합산
        //       합계 출력
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {
        String[] students = {
            "홍길동,20,컴퓨터공학",
            "김영희,22,전자공학",
            "이철수,21,수학",
            "박지수,23,물리학"
        };

        try {
            System.out.println("=== 문제 1: FileWriter/FileReader ===");
            writeWithFileWriter("hello_java.txt");
            System.out.println();
            System.out.println("[FileReader 읽기]:");
            readWithFileReader("hello_java.txt");
            System.out.println();
            appendWithFileWriter("hello_java.txt", "\n추가된 네 번째 줄입니다.");

            System.out.println("\n=== 문제 2: BufferedWriter/BufferedReader ===");
            writeWithBufferedWriter("students.txt", students);
            System.out.println("[BufferedReader 읽기]:");
            readWithBufferedReader("students.txt");
            int lineCount = countLinesWithBufferedReader("students.txt");
            System.out.println("[줄 수] students.txt: 총 " + lineCount + "줄");

            System.out.println("\n=== 문제 3: try-with-resources ===");
            System.out.println("[파일 복사]");
            safeCopyFile("students.txt", "students_copy.txt");

            System.out.println("\n[안전한 파일 읽기]");
            safeReadFile("notexist.txt");

            System.out.println("\n[쓰기 후 읽기]");
            writeAndReadDemo("demo.txt");

        } catch (IOException e) {
            System.err.println("파일 IO 오류: " + e.getMessage());
        }
    }
}
