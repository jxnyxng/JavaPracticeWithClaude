/**
 * ============================================================
 * 파일명: Challenge04_LibrarySystem.java
 * 제  목: 도서관 관리 시스템
 * ============================================================
 *
 * [학습 목표]
 * 1. 추상 클래스(abstract class)와 상속을 활용하여 도서 계층 구조를 설계할 수 있다.
 * 2. TreeMap과 Stream의 groupingBy를 사용하여 데이터를 효율적으로 관리하고 분류할 수 있다.
 * 3. 커스텀 예외 클래스를 작성하고 비즈니스 로직에서 예외를 적절히 던지고 처리할 수 있다.
 *
 * [핵심 개념 설명]
 * - 추상 클래스(Abstract Class): 직접 인스턴스화할 수 없으며, 공통 속성/메소드를 정의하고
 *   하위 클래스가 반드시 구현해야 하는 추상 메소드를 선언한다.
 * - TreeMap: HashMap과 달리 키를 자연 순서(또는 Comparator)로 정렬하여 저장한다.
 *   ISBN 기준 정렬 조회 시 유용하다.
 * - Stream groupingBy: Collectors.groupingBy()를 사용하면 특정 기준으로 요소를 그룹화하여
 *   Map<K, List<V>> 형태로 수집할 수 있다.
 * - 커스텀 예외: RuntimeException 또는 Exception을 상속하여 도메인에 특화된 예외를 정의한다.
 * ============================================================
 */

import java.util.*;
import java.util.stream.*;

// ============================================================
// 커스텀 예외 클래스
// ============================================================

/**
 * 이미 대출 중인 도서를 대출하려 할 때 발생하는 예외
 */
class BookAlreadyBorrowedException extends RuntimeException {
    // TODO: 생성자 작성 (메시지를 받아 부모 생성자에 전달)
}

/**
 * 대출되지 않은 도서를 반납하려 할 때 발생하는 예외
 */
class BookNotBorrowedException extends RuntimeException {
    // TODO: 생성자 작성 (메시지를 받아 부모 생성자에 전달)
}

// ============================================================
// 도서 추상 클래스 및 하위 클래스
// ============================================================

/**
 * [추상 클래스] Book - 모든 도서 유형의 공통 속성 및 동작 정의
 *
 * 필드:
 * - title    : 도서 제목 (String)
 * - author   : 저자명 (String)
 * - isbn     : ISBN 번호 (String, 고유 식별자)
 * - borrowed : 대출 여부 (boolean, 기본값 false)
 *
 * 추상 메소드:
 * - getGenre() : 장르 문자열 반환 (하위 클래스마다 다름)
 * - getInfo()  : 도서 상세 정보 문자열 반환
 */
abstract class Book {
    // TODO: 필드 선언 (private 또는 protected 선택하여 작성)

    // TODO: 생성자 작성 (title, author, isbn 초기화)

    // TODO: getter 메소드 작성 (getTitle, getAuthor, getIsbn, isBorrowed)

    /**
     * 도서 대출 메소드
     * - 이미 대출 중이면 BookAlreadyBorrowedException 발생
     * - 대출 성공 시 borrowed = true
     */
    public void borrow() {
        // TODO: 구현
    }

    /**
     * 도서 반납 메소드
     * - 대출 상태가 아니면 BookNotBorrowedException 발생
     * - 반납 성공 시 borrowed = false
     */
    public void returnBook() {
        // TODO: 구현
    }

    /**
     * 장르 반환 (하위 클래스에서 반드시 구현)
     */
    public abstract String getGenre();

    /**
     * 도서 상세 정보 반환 (하위 클래스에서 반드시 구현)
     * 예: "[소설] 제목: 해리포터 | 저자: J.K.롤링 | ISBN: 978-0 | 대출가능"
     */
    public abstract String getInfo();

    @Override
    public String toString() {
        // TODO: 제목, 저자, ISBN, 대출여부를 포함한 문자열 반환
        return null;
    }
}

/**
 * [문제 1] FictionBook - 소설 도서
 *
 * 제목: 소설 도서 클래스 구현
 *
 * 상세 설명:
 * Book을 상속하는 소설 도서 클래스를 완성하세요.
 * 소설은 장르(예: "판타지", "로맨스", "추리")를 추가 필드로 가집니다.
 *
 * 예상 출력 (getInfo 호출 시):
 * [소설-판타지] 제목: 해리포터와 마법사의 돌 | 저자: J.K.롤링 | ISBN: 978-0439708180 | 대출가능
 *
 * 힌트:
 * - super(title, author, isbn) 으로 부모 생성자 호출
 * - getGenre()는 "소설-" + subGenre 형태로 반환
 */
class FictionBook extends Book {
    // TODO: 추가 필드 선언 (subGenre: 소설의 세부 장르)

    // TODO: 생성자 작성

    @Override
    public String getGenre() {
        // TODO: 구현
        return null;
    }

    @Override
    public String getInfo() {
        // TODO: 구현
        return null;
    }
}

/**
 * [문제 2] TextBook - 교재 도서
 *
 * 제목: 교재 도서 클래스 구현
 *
 * 상세 설명:
 * Book을 상속하는 교재 클래스를 완성하세요.
 * 교재는 과목명(subject)과 학년(grade) 정보를 추가로 가집니다.
 *
 * 예상 출력 (getInfo 호출 시):
 * [교재-수학] 제목: 수학의 정석 | 저자: 홍성대 | ISBN: 978-8933490 | 학년: 고1 | 대출중
 *
 * 힌트:
 * - getGenre()는 "교재-" + subject 형태로 반환
 * - isBorrowed()가 true면 "대출중", false면 "대출가능"
 */
class TextBook extends Book {
    // TODO: 추가 필드 선언 (subject: 과목명, grade: 학년)

    // TODO: 생성자 작성

    @Override
    public String getGenre() {
        // TODO: 구현
        return null;
    }

    @Override
    public String getInfo() {
        // TODO: 구현
        return null;
    }
}

/**
 * Magazine - 잡지 도서
 *
 * 상세 설명:
 * Book을 상속하는 잡지 클래스를 완성하세요.
 * 잡지는 발행월(issueMonth: int)을 추가 필드로 가집니다.
 *
 * 예상 출력 (getInfo 호출 시):
 * [잡지] 제목: 과학동아 2024년 6월호 | 저자: 동아사이언스 | ISBN: 978-0001 | 발행월: 6월 | 대출가능
 */
class Magazine extends Book {
    // TODO: 추가 필드 선언 (issueMonth: 발행월)

    // TODO: 생성자 작성

    @Override
    public String getGenre() {
        // TODO: 구현
        return null;
    }

    @Override
    public String getInfo() {
        // TODO: 구현
        return null;
    }
}

// ============================================================
// 도서관 관리 클래스
// ============================================================

/**
 * [문제 3] Library - 도서관 관리 클래스
 *
 * 제목: TreeMap 기반 도서관 관리 시스템 구현
 *
 * 상세 설명:
 * TreeMap<String, Book>을 사용하여 ISBN 기준으로 도서를 관리하는
 * 도서관 클래스를 완성하세요.
 *
 * 구현해야 할 기능:
 * 1. 도서 추가 (addBook)
 * 2. ISBN으로 도서 조회 (findByIsbn)
 * 3. 저자명으로 도서 검색 (findByAuthor) - Stream filter 사용
 * 4. 제목 키워드로 도서 검색 (searchByTitleKeyword) - Stream filter + contains 사용
 * 5. 장르별 도서 목록 (groupByGenre) - Collectors.groupingBy 사용
 * 6. 대출 가능한 도서 목록 (getAvailableBooks) - Stream filter + isBorrowed 사용
 * 7. 전체 도서 목록 출력 (printAllBooks)
 *
 * 예상 출력 (groupByGenre 호출 후 출력):
 * === 장르별 도서 목록 ===
 * [교재-수학] (2권)
 *   - 수학의 정석 (홍성대)
 *   - 미적분학 (제임스 스튜어트)
 * [소설-판타지] (1권)
 *   - 해리포터 (J.K.롤링)
 * ...
 *
 * 힌트:
 * - TreeMap은 생성 시 자동으로 키(ISBN) 기준 정렬됨
 * - groupingBy: books.values().stream().collect(Collectors.groupingBy(Book::getGenre))
 * - Optional 사용: findByIsbn은 Optional<Book> 반환 권장
 */
class Library {
    // TODO: TreeMap<String, Book> 필드 선언 (ISBN -> Book)

    // TODO: 생성자 작성

    /** 도서 추가 (ISBN이 이미 존재하면 IllegalArgumentException 발생) */
    public void addBook(Book book) {
        // TODO: 구현
    }

    /** ISBN으로 도서 조회 */
    public Optional<Book> findByIsbn(String isbn) {
        // TODO: 구현
        return null;
    }

    /** 저자명으로 도서 검색 (Stream filter 사용) */
    public List<Book> findByAuthor(String author) {
        // TODO: 구현
        return null;
    }

    /** 제목 키워드로 도서 검색 (대소문자 무시) */
    public List<Book> searchByTitleKeyword(String keyword) {
        // TODO: 구현
        return null;
    }

    /** 장르별 도서 목록 반환 (Collectors.groupingBy 사용) */
    public Map<String, List<Book>> groupByGenre() {
        // TODO: 구현
        return null;
    }

    /** 대출 가능한 도서 목록 반환 (Stream filter 사용) */
    public List<Book> getAvailableBooks() {
        // TODO: 구현
        return null;
    }

    /** 전체 도서 수 반환 */
    public int getTotalBookCount() {
        // TODO: 구현
        return 0;
    }

    /** 전체 도서 목록 출력 */
    public void printAllBooks() {
        // TODO: 구현
    }
}

// ============================================================
// 메인 클래스 (테스트)
// ============================================================

public class Challenge04_LibrarySystem {

    public static void main(String[] args) {

        System.out.println("=== 도서관 관리 시스템 테스트 ===\n");

        // 도서관 생성
        Library library = new Library();

        // 도서 추가 테스트
        // TODO: FictionBook, TextBook, Magazine 객체를 각 2개 이상 생성하여 library에 추가

        System.out.println("총 도서 수: " + library.getTotalBookCount());
        System.out.println();

        // 전체 도서 목록 출력
        System.out.println("=== 전체 도서 목록 ===");
        library.printAllBooks();

        // 장르별 분류 출력
        System.out.println("\n=== 장르별 도서 목록 ===");
        Map<String, List<Book>> grouped = library.groupByGenre();
        // TODO: grouped를 순회하며 장르별 도서 출력

        // 대출 테스트
        System.out.println("\n=== 대출/반납 테스트 ===");
        // TODO: 특정 도서를 ISBN으로 찾아 대출 시도
        // TODO: 같은 도서를 다시 대출 시도하여 BookAlreadyBorrowedException 확인 (try-catch)

        // 대출 가능 도서 목록
        System.out.println("\n=== 대출 가능한 도서 ===");
        library.getAvailableBooks().forEach(b -> System.out.println(b.getInfo()));

        // 저자 검색 테스트
        System.out.println("\n=== 저자 검색 테스트 ===");
        // TODO: 특정 저자로 검색하여 결과 출력
    }
}
