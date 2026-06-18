/**
 * ================================================================
 * 파일명: P03_NIOFiles.java
 * 주제: NIO Files 클래스 (Java 7+, New I/O)
 * ================================================================
 *
 * 【학습 목표】
 * 1. java.nio.file.Files 클래스의 주요 정적 메소드로 파일을 읽고 쓸 수 있다.
 * 2. Files.copy, Files.move로 파일을 복사하고 이동하는 방법을 이해한다.
 * 3. Files.walk를 사용하여 디렉토리를 재귀적으로 탐색할 수 있다.
 *
 * 【핵심 개념】
 * - NIO (New I/O): Java 1.4에서 도입, Java 7에서 NIO.2(java.nio.file)로 크게 개선
 * - Path 인터페이스: 파일/디렉토리 경로를 나타냄 (File 클래스의 현대적 대안)
 *   생성: Paths.get("경로") 또는 Path.of("경로") [Java 11+]
 * - Files 클래스 주요 메소드:
 *   Files.readAllLines(path)        - 모든 줄을 List<String>으로 읽기
 *   Files.readAllBytes(path)        - 모든 바이트를 배열로 읽기
 *   Files.readString(path)          - 파일 전체를 String으로 읽기 [Java 11+]
 *   Files.write(path, lines)        - List<String>을 파일에 쓰기
 *   Files.writeString(path, str)    - String을 파일에 쓰기 [Java 11+]
 *   Files.copy(src, dst, options)   - 파일 복사
 *   Files.move(src, dst, options)   - 파일 이동 (이름 변경 포함)
 *   Files.delete(path)              - 파일 삭제 (없으면 NoSuchFileException)
 *   Files.deleteIfExists(path)      - 파일이 있으면 삭제 (없으면 무시)
 *   Files.exists(path)              - 파일 존재 여부
 *   Files.walk(path)                - 디렉토리 트리를 Stream<Path>로 반환
 *   Files.list(path)                - 디렉토리의 직접 하위 항목만 Stream<Path>로 반환
 *   Files.createDirectories(path)   - 중간 경로 포함 디렉토리 생성
 * - StandardCopyOption: REPLACE_EXISTING, COPY_ATTRIBUTES, ATOMIC_MOVE
 * ================================================================
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class P03_NIOFiles {

    // ================================================================
    // 문제 1: Files.readAllLines, Files.write
    // ================================================================
    /**
     * 【문제 1】 NIO Files로 파일 읽기/쓰기
     *
     * 설명:
     *   (1) writeWithNIO() 메소드:
     *       Files.write()를 사용하여 Path에 List<String>을 저장하세요.
     *       파일명: "nio_output.txt"
     *       내용:
     *         Java NIO Files 클래스 실습
     *         Path와 Files를 사용한 파일 처리
     *         기존 IO보다 간결하고 편리합니다
     *         UTF-8 인코딩으로 저장됩니다
     *
     *   (2) readAllLinesNIO() 메소드:
     *       Files.readAllLines()로 파일을 읽어 줄 번호와 함께 출력하세요.
     *       출력 형식: "1: 내용", "2: 내용" ...
     *
     *   (3) appendLinesNIO() 메소드:
     *       StandardOpenOption.APPEND 옵션으로 파일에 내용을 추가하세요.
     *       추가 내용: "추가된 다섯 번째 줄"
     *
     *   (4) writeAndReadWithOptions() 메소드:
     *       Files.write()의 OpenOption 파라미터를 사용하여:
     *       - CREATE: 파일이 없으면 생성
     *       - TRUNCATE_EXISTING: 기존 내용 삭제 후 쓰기
     *       "options_test.txt"에 테스트 내용을 쓰고, Files.readString()으로 읽어 출력하세요.
     *       (Java 11 미만이면 new String(Files.readAllBytes(path), StandardCharsets.UTF_8) 사용)
     *
     * 예상 출력:
     *   [NIO 쓰기 완료] nio_output.txt 생성됨
     *   [NIO 읽기]:
     *   1: Java NIO Files 클래스 실습
     *   2: Path와 Files를 사용한 파일 처리
     *   3: 기존 IO보다 간결하고 편리합니다
     *   4: UTF-8 인코딩으로 저장됩니다
     *   [추가 완료] 줄 추가됨
     *   [옵션 쓰기/읽기]:
     *   파일 내용: NIO OpenOption 테스트 내용입니다.
     *
     * 힌트:
     *   - Path path = Paths.get("nio_output.txt");
     *   - Files.write(path, lines, StandardCharsets.UTF_8);
     *   - Files.readAllLines(path, StandardCharsets.UTF_8) -> List<String>
     *   - Files.write(path, List.of("추가 내용"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
     *   - List.of()는 Java 9+, Arrays.asList()는 이전 버전에서도 사용 가능
     */
    static void writeWithNIO(String filename, List<String> lines) throws IOException {
        // TODO: Paths.get()으로 Path 생성
        // TODO: Files.write(path, lines, StandardCharsets.UTF_8) 호출
        // TODO: 완료 메시지 출력
    }

    static void readAllLinesNIO(String filename) throws IOException {
        // TODO: Paths.get()으로 Path 생성
        // TODO: Files.readAllLines(path, StandardCharsets.UTF_8) 호출
        // TODO: 줄 번호와 함께 출력 (for문 또는 스트림 사용)
    }

    static void appendLinesNIO(String filename, String newLine) throws IOException {
        // TODO: Files.write()에 StandardOpenOption.APPEND 옵션 추가
        // TODO: 완료 메시지 출력
    }

    static void writeAndReadWithOptions(String filename, String content) throws IOException {
        // TODO: Files.write()에 StandardOpenOption.CREATE, TRUNCATE_EXISTING 옵션 사용
        // TODO: Files.readString() 또는 new String(Files.readAllBytes(path)) 로 읽기
        // TODO: 읽은 내용 출력
    }

    // ================================================================
    // 문제 2: Files.copy, Files.move
    // ================================================================
    /**
     * 【문제 2】 파일 복사 및 이동
     *
     * 설명:
     *   (1) copyFileNIO() 메소드:
     *       Files.copy()로 파일을 복사하세요.
     *       대상 파일이 이미 존재하면 StandardCopyOption.REPLACE_EXISTING으로 덮어쓰세요.
     *       복사 후 원본과 복사본의 크기를 비교하여 출력하세요.
     *
     *   (2) moveFileNIO() 메소드:
     *       Files.move()로 파일을 새 위치로 이동하세요.
     *       (같은 디렉토리에서 이름만 변경하는 것도 move입니다)
     *       이동 후 원본 파일이 사라졌는지 확인하세요.
     *
     *   (3) backupFile() 메소드:
     *       원본 파일을 "파일명_backup.확장자" 형식으로 백업하세요.
     *       예: "data.txt" -> "data_backup.txt"
     *       백업 파일 생성 후 원본은 유지되어야 합니다.
     *
     * 예상 출력:
     *   [파일 복사]
     *   nio_output.txt -> nio_copy.txt 복사 완료
     *   원본 크기: 120 bytes
     *   복사본 크기: 120 bytes
     *   크기 일치: true
     *
     *   [파일 이동]
     *   nio_copy.txt -> nio_moved.txt 이동 완료
     *   원본 nio_copy.txt 존재: false (이동됨)
     *
     *   [파일 백업]
     *   nio_output.txt -> nio_output_backup.txt 백업 완료
     *   원본 유지 확인: true
     *
     * 힌트:
     *   - Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
     *   - Files.move(source, target, StandardCopyOption.REPLACE_EXISTING)
     *   - Files.size(path): 파일 크기(바이트) 반환
     *   - Files.exists(path): 파일 존재 여부
     *   - 백업 파일명 생성: 파일명에서 확장자 분리 후 "_backup" 추가
     *     String name = filename; // "data.txt"
     *     int dot = name.lastIndexOf('.');
     *     String backupName = name.substring(0, dot) + "_backup" + name.substring(dot);
     */
    static void copyFileNIO(String source, String target) throws IOException {
        // TODO: Paths.get()으로 Path 생성
        // TODO: Files.copy()로 파일 복사 (REPLACE_EXISTING 옵션)
        // TODO: 복사 완료 메시지 출력
        // TODO: Files.size()로 원본과 복사본 크기 비교 출력
    }

    static void moveFileNIO(String source, String target) throws IOException {
        // TODO: Files.move()로 파일 이동
        // TODO: 이동 완료 메시지 출력
        // TODO: Files.exists()로 원본 파일 사라졌는지 확인 출력
    }

    static void backupFile(String filename) throws IOException {
        // TODO: 백업 파일명 생성 (확장자 앞에 "_backup" 삽입)
        // TODO: Files.copy()로 원본을 백업 파일로 복사
        // TODO: 완료 메시지 및 원본 파일 존재 여부 확인 출력
    }

    // ================================================================
    // 문제 3: Files.walk로 디렉토리 탐색
    // ================================================================
    /**
     * 【문제 3】 Files.walk를 사용한 디렉토리 재귀 탐색
     *
     * 설명:
     *   (1) walkDirectory() 메소드:
     *       Files.walk()로 지정된 디렉토리를 재귀적으로 탐색하여 모든 파일과
     *       디렉토리를 들여쓰기와 함께 출력하세요.
     *       깊이(depth)에 따라 "  " (공백 2개)씩 들여쓰기 하세요.
     *       디렉토리는 "[D]", 파일은 "[F]" 접두사를 붙이세요.
     *
     *   (2) findFilesByExtension() 메소드:
     *       Files.walk()와 Stream 필터를 사용하여 특정 확장자의 파일만 찾아
     *       목록을 반환하세요.
     *       예: ".java" 확장자 파일 모두 찾기
     *
     *   (3) calculateTotalSize() 메소드:
     *       Files.walk()로 디렉토리 내 모든 파일의 크기 합계를 계산하세요.
     *       Stream의 mapToLong()과 sum()을 사용하세요.
     *
     *   (4) deleteDirectoryRecursively() 메소드:
     *       Files.walk()로 디렉토리를 깊은 곳에서부터 역순으로 삭제하세요.
     *       파일 먼저, 그다음 디렉토리 순으로 삭제합니다.
     *       (주의: 실제 데이터 삭제이므로 테스트 디렉토리에만 사용하세요)
     *
     * 예상 출력:
     *   [디렉토리 탐색: testDir]
     *   [D] testDir
     *     [D] subDir1
     *     [D] subDir2
     *   탐색 완료
     *
     *   [.java 파일 검색: .]
     *   P01_FileReadWrite.java
     *   P02_FileOperations.java
     *   P03_NIOFiles.java
     *   총 3개 파일 발견
     *
     *   [디렉토리 총 크기]
     *   현재 디렉토리 크기: 12,345 bytes
     *
     *   [디렉토리 삭제: testDir]
     *   testDir 삭제 완료
     *
     * 힌트:
     *   - try (Stream<Path> stream = Files.walk(startPath)) { stream.forEach(...); }
     *   - Stream은 AutoCloseable이므로 try-with-resources 사용 권장
     *   - 깊이 계산: startPath.relativize(path).getNameCount()
     *   - 확장자 필터: path.toString().endsWith(".java")
     *   - 크기 합계: Files.walk(dir).filter(Files::isRegularFile)
     *                              .mapToLong(p -> { try { return Files.size(p); } catch ... })
     *                              .sum()
     *   - 역순 삭제: Files.walk(dir).sorted(Comparator.reverseOrder()).forEach(Files::delete)
     *     단, Files::delete는 IOException을 던지므로 람다 내에서 try-catch 처리 필요
     */
    static void walkDirectory(String directoryPath) throws IOException {
        // TODO: Paths.get(directoryPath)로 Path 생성
        // TODO: try-with-resources로 Files.walk(startPath) 스트림 획득
        // TODO: 각 Path에 대해 깊이 계산 후 들여쓰기와 [D]/[F] 표시와 함께 출력
    }

    static List<Path> findFilesByExtension(String directoryPath, String extension) throws IOException {
        // TODO: Files.walk()와 Stream filter() 사용
        //       Files.isRegularFile()로 파일만 필터
        //       path.toString().endsWith(extension)으로 확장자 필터
        // TODO: collect(Collectors.toList())로 리스트 반환
        return List.of(); // TODO: 실제 반환값으로 수정
    }

    static long calculateTotalSize(String directoryPath) throws IOException {
        // TODO: Files.walk()로 스트림 획득
        // TODO: filter(Files::isRegularFile)로 파일만 필터
        // TODO: mapToLong()으로 각 파일 크기 계산 (Files.size(), 예외 처리 필요)
        // TODO: sum()으로 합계 반환
        return 0L; // TODO: 실제 크기 반환
    }

    static void deleteDirectoryRecursively(String directoryPath) throws IOException {
        // TODO: Files.walk(path)로 스트림 획득
        // TODO: sorted(Comparator.reverseOrder())로 역순 정렬 (하위 파일 먼저)
        // TODO: forEach로 각 Path 삭제 (Files.delete(), IOException 처리 필요)
        // TODO: 완료 메시지 출력
    }

    // ================================================================
    // 헬퍼 메소드
    // ================================================================
    /**
     * 테스트용 디렉토리 구조 생성
     * testDir/subDir1, testDir/subDir2 생성
     */
    static void setupTestDirectory() throws IOException {
        // TODO: Files.createDirectories()로 testDir/subDir1 생성
        // TODO: Files.createDirectories()로 testDir/subDir2 생성
        // TODO: testDir에 샘플 파일 2개 생성
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {
        try {
            System.out.println("=== 문제 1: Files.readAllLines, Files.write ===");
            List<String> lines = Arrays.asList(
                "Java NIO Files 클래스 실습",
                "Path와 Files를 사용한 파일 처리",
                "기존 IO보다 간결하고 편리합니다",
                "UTF-8 인코딩으로 저장됩니다"
            );
            writeWithNIO("nio_output.txt", lines);
            System.out.println("[NIO 읽기]:");
            readAllLinesNIO("nio_output.txt");
            appendLinesNIO("nio_output.txt", "추가된 다섯 번째 줄");
            writeAndReadWithOptions("options_test.txt", "NIO OpenOption 테스트 내용입니다.");

            System.out.println("\n=== 문제 2: Files.copy, Files.move ===");
            System.out.println("[파일 복사]");
            copyFileNIO("nio_output.txt", "nio_copy.txt");

            System.out.println("\n[파일 이동]");
            moveFileNIO("nio_copy.txt", "nio_moved.txt");

            System.out.println("\n[파일 백업]");
            backupFile("nio_output.txt");

            System.out.println("\n=== 문제 3: Files.walk ===");
            setupTestDirectory();

            System.out.println("[디렉토리 탐색: testDir]");
            walkDirectory("testDir");

            System.out.println("\n[.java 파일 검색: .]");
            List<Path> javaFiles = findFilesByExtension(".", ".java");
            javaFiles.forEach(p -> System.out.println(p.getFileName()));
            System.out.println("총 " + javaFiles.size() + "개 파일 발견");

            System.out.println("\n[디렉토리 총 크기]");
            long totalSize = calculateTotalSize(".");
            System.out.printf("현재 디렉토리 크기: %,d bytes%n", totalSize);

            System.out.println("\n[디렉토리 삭제: testDir]");
            deleteDirectoryRecursively("testDir");

        } catch (IOException e) {
            System.err.println("NIO 파일 작업 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
