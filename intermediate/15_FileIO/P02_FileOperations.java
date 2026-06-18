/**
 * ================================================================
 * 파일명: P02_FileOperations.java
 * 주제: File 클래스와 파일 작업 (File Class and File Operations)
 * ================================================================
 *
 * 【학습 목표】
 * 1. java.io.File 클래스를 사용하여 파일과 디렉토리의 메타데이터를 조회한다.
 * 2. 파일 존재 확인, 생성, 삭제 등의 기본 파일 작업을 수행한다.
 * 3. 디렉토리 목록을 조회하고 필터링하는 방법을 익힌다.
 *
 * 【핵심 개념】
 * - File 클래스: 파일/디렉토리의 경로를 나타내며 메타데이터 조회 및 작업 수행
 *   (실제 파일 내용 읽기/쓰기는 Stream 클래스 사용)
 * - 주요 메소드:
 *   exists()       - 파일/디렉토리 존재 여부
 *   isFile()       - 파일 여부
 *   isDirectory()  - 디렉토리 여부
 *   getName()      - 파일명 반환
 *   getPath()      - 상대 경로 반환
 *   getAbsolutePath() - 절대 경로 반환
 *   length()       - 파일 크기(바이트)
 *   lastModified() - 마지막 수정 시간(밀리초)
 *   createNewFile() - 새 파일 생성 (이미 있으면 false 반환)
 *   mkdir()        - 단일 디렉토리 생성
 *   mkdirs()       - 중간 경로 포함 디렉토리 생성
 *   delete()       - 파일/빈 디렉토리 삭제
 *   list()         - 디렉토리 내 파일명 배열 반환
 *   listFiles()    - 디렉토리 내 File 객체 배열 반환
 *   renameTo(File) - 파일 이름 변경 또는 이동
 * ================================================================
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_FileOperations {

    // ================================================================
    // 문제 1: File 클래스로 파일/디렉토리 정보 조회
    // ================================================================
    /**
     * 【문제 1】 파일 및 디렉토리 정보 출력
     *
     * 설명:
     *   (1) displayFileInfo() 메소드:
     *       주어진 File 객체의 상세 정보를 출력하세요.
     *       출력 항목:
     *         - 이름 (getName())
     *         - 절대 경로 (getAbsolutePath())
     *         - 존재 여부 (exists())
     *         - 파일/디렉토리 구분 (isFile() / isDirectory())
     *         - 크기 (length() 바이트)
     *         - 마지막 수정 시간 (lastModified()를 날짜 형식으로 변환)
     *         - 읽기 가능 (canRead())
     *         - 쓰기 가능 (canWrite())
     *
     *   (2) compareFilesAndDir() 메소드:
     *       현재 디렉토리(".")와 특정 파일("students.txt")의 정보를 각각 출력하세요.
     *
     * 예상 출력:
     *   === 파일 정보 ===
     *   이름: students.txt
     *   절대 경로: /Users/.../students.txt
     *   존재 여부: true
     *   종류: 파일
     *   크기: 72 바이트
     *   마지막 수정: 2026-06-18 14:30:00
     *   읽기 가능: true
     *   쓰기 가능: true
     *
     *   === 디렉토리 정보 ===
     *   이름: intermediate
     *   절대 경로: /Users/.../intermediate
     *   존재 여부: true
     *   종류: 디렉토리
     *   ...
     *
     * 힌트:
     *   - File file = new File("students.txt");
     *   - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()))
     *   - 파일이 없을 경우 크기/수정시간 등은 의미가 없습니다.
     */
    static void displayFileInfo(File file) {
        // TODO: System.out.println("=== 파일 정보 ===");
        // TODO: 이름, 절대 경로, 존재 여부, 종류(파일/디렉토리), 크기, 마지막 수정 시간, 읽기/쓰기 가능 여부 출력
        //       종류는 isFile() 이면 "파일", isDirectory() 이면 "디렉토리" 출력
        //       마지막 수정 시간은 SimpleDateFormat으로 포맷
    }

    static void compareFilesAndDir() {
        // TODO: File 객체 생성: "students.txt"와 "." (현재 디렉토리)
        // TODO: displayFileInfo() 호출하여 각각 정보 출력
    }

    // ================================================================
    // 문제 2: 파일 존재 확인, 생성, 삭제
    // ================================================================
    /**
     * 【문제 2】 파일 생성, 이름 변경, 삭제
     *
     * 설명:
     *   (1) createFileIfNotExists() 메소드:
     *       파일이 이미 존재하면 "이미 존재합니다" 메시지를 출력하고,
     *       존재하지 않으면 createNewFile()로 파일을 생성하고 결과를 출력하세요.
     *
     *   (2) createDirectoryStructure() 메소드:
     *       다음 디렉토리 구조를 생성하세요:
     *       testDir/
     *           subDir1/
     *           subDir2/
     *       mkdir()와 mkdirs()의 차이를 주석으로 설명하세요.
     *       각 디렉토리 생성 성공/실패 여부를 출력하세요.
     *
     *   (3) renameAndDelete() 메소드:
     *       "temp_file.txt"를 생성하고 "renamed_file.txt"로 이름을 변경하세요.
     *       변경 후 파일을 삭제하고 삭제 성공 여부를 출력하세요.
     *
     * 예상 출력:
     *   [파일 생성]
     *   new_file.txt 생성 성공
     *   new_file.txt 이미 존재합니다. (두 번째 호출)
     *
     *   [디렉토리 생성]
     *   testDir 생성: 성공
     *   testDir/subDir1 생성: 성공
     *   testDir/subDir2 생성: 성공
     *
     *   [이름 변경 및 삭제]
     *   temp_file.txt 생성: 성공
     *   renamed_file.txt로 이름 변경: 성공
     *   renamed_file.txt 삭제: 성공
     *
     * 힌트:
     *   - file.createNewFile(): IOException 발생 가능, throws 또는 try-catch 필요
     *   - file.mkdir(): 상위 디렉토리가 없으면 실패
     *   - file.mkdirs(): 중간 경로 포함 모든 디렉토리를 한 번에 생성
     *   - file.renameTo(new File("newname.txt")): 성공시 true 반환
     *   - file.delete(): 성공시 true 반환, 비어있지 않은 디렉토리는 삭제 불가
     */
    static void createFileIfNotExists(String filename) throws IOException {
        // TODO: File 객체 생성
        // TODO: exists()로 존재 여부 확인
        //       이미 존재: "X 이미 존재합니다." 출력
        //       존재하지 않음: createNewFile() 호출, 결과에 따라 "생성 성공/실패" 출력
    }

    static void createDirectoryStructure() {
        // TODO: "testDir" 디렉토리 생성 (mkdir 사용)
        // TODO: "testDir/subDir1" 생성 (mkdir 사용)
        // TODO: "testDir/subDir2" 생성 (mkdir 사용)
        // TODO: 각 생성 결과를 "성공" 또는 "실패(이미 존재하거나 상위 경로 없음)" 로 출력
        // 주석: mkdir() vs mkdirs() 차이 설명
        // mkdir(): 단일 디렉토리만 생성, 상위 디렉토리 없으면 실패
        // mkdirs(): 필요한 모든 중간 디렉토리를 함께 생성
    }

    static void renameAndDelete() throws IOException {
        // TODO: "temp_file.txt" 파일 생성
        // TODO: renameTo()로 "renamed_file.txt"로 이름 변경, 결과 출력
        // TODO: 변경된 파일 delete()로 삭제, 결과 출력
    }

    // ================================================================
    // 문제 3: 디렉토리 목록 출력
    // ================================================================
    /**
     * 【문제 3】 디렉토리 탐색 및 파일 필터링
     *
     * 설명:
     *   (1) listCurrentDirectory() 메소드:
     *       현재 디렉토리(".")의 모든 파일과 디렉토리를 나열하세요.
     *       각 항목 앞에 [파일] 또는 [디렉토리] 표시를 붙이세요.
     *       파일이면 크기도 함께 표시하세요.
     *
     *   (2) listJavaFiles() 메소드:
     *       주어진 디렉토리에서 .java 파일만 필터링하여 출력하세요.
     *       FilenameFilter 인터페이스를 익명 클래스로 구현하세요.
     *       각 .java 파일의 이름과 크기를 출력하세요.
     *
     *   (3) calculateDirectorySize() 메소드:
     *       디렉토리의 모든 파일 크기 합계를 재귀적으로 계산하여 반환하세요.
     *       하위 디렉토리도 포함합니다.
     *
     * 예상 출력:
     *   [현재 디렉토리 목록]
     *   [파일] students.txt (72 bytes)
     *   [파일] hello_java.txt (85 bytes)
     *   [디렉토리] testDir
     *   ...
     *
     *   [.java 파일 목록]
     *   P01_FileReadWrite.java (3,200 bytes)
     *   P02_FileOperations.java (4,100 bytes)
     *   ...
     *
     *   [디렉토리 크기]
     *   현재 디렉토리 총 크기: 12,345 bytes
     *
     * 힌트:
     *   - File dir = new File(".");
     *   - File[] files = dir.listFiles(); // File 객체 배열 반환 (null 주의)
     *   - FilenameFilter 사용:
     *     dir.list(new FilenameFilter() {
     *         public boolean accept(File dir, String name) {
     *             return name.endsWith(".java");
     *         }
     *     })
     *   - 재귀 탐색: for (File f : files) { if (f.isDirectory()) calculateSize(f); }
     *   - String.format("%,d", bytes)로 천 단위 구분자(,) 포함 출력 가능
     */
    static void listCurrentDirectory() {
        // TODO: File dir = new File(".");
        // TODO: dir.listFiles()로 파일 목록 가져오기
        // TODO: null 체크 후 각 파일/디렉토리 정보 출력
        //       파일: "[파일] 파일명 (크기 bytes)"
        //       디렉토리: "[디렉토리] 디렉토리명"
    }

    static void listJavaFiles(String directoryPath) {
        // TODO: File 객체 생성
        // TODO: FilenameFilter를 익명 클래스로 구현 (.java로 끝나는 파일만)
        // TODO: dir.listFiles(filter)로 .java 파일 목록 가져오기
        // TODO: 각 파일명과 크기 출력
    }

    static long calculateDirectorySize(File directory) {
        // TODO: 디렉토리가 아니면 파일 크기 반환
        // TODO: 디렉토리면 모든 하위 항목의 크기를 재귀적으로 합산하여 반환
        //       listFiles()가 null을 반환할 수 있으므로 null 체크 필요
        return 0L; // TODO: 실제 크기 반환
    }

    // ================================================================
    // 헬퍼 메소드
    // ================================================================
    /**
     * 바이트를 읽기 좋은 형식으로 변환
     * 예: 1024 -> "1.0 KB", 1048576 -> "1.0 MB"
     */
    static String formatFileSize(long bytes) {
        // TODO: 1GB 이상이면 GB, 1MB 이상이면 MB, 1KB 이상이면 KB, 그 외는 bytes
        return "";
    }

    /**
     * 밀리초를 날짜 문자열로 변환
     */
    static String formatDate(long milliseconds) {
        // TODO: SimpleDateFormat으로 "yyyy-MM-dd HH:mm:ss" 형식 반환
        return "";
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {
        try {
            System.out.println("=== 문제 1: 파일/디렉토리 정보 조회 ===");
            compareFilesAndDir();

            System.out.println("\n=== 문제 2: 파일 생성, 이름 변경, 삭제 ===");
            System.out.println("[파일 생성]");
            createFileIfNotExists("new_file.txt");
            createFileIfNotExists("new_file.txt"); // 두 번째 호출: 이미 존재

            System.out.println("\n[디렉토리 생성]");
            createDirectoryStructure();

            System.out.println("\n[이름 변경 및 삭제]");
            renameAndDelete();

            System.out.println("\n=== 문제 3: 디렉토리 목록 출력 ===");
            System.out.println("[현재 디렉토리 목록]");
            listCurrentDirectory();

            System.out.println("\n[.java 파일 목록]");
            listJavaFiles(".");

            System.out.println("\n[디렉토리 크기]");
            long size = calculateDirectorySize(new File("."));
            System.out.printf("현재 디렉토리 총 크기: %,d bytes%n", size);

        } catch (IOException e) {
            System.err.println("파일 작업 오류: " + e.getMessage());
        }
    }
}
