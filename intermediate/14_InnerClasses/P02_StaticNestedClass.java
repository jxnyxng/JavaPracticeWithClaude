/**
 * ================================================================
 * 파일명: P02_StaticNestedClass.java
 * 주제: 정적 중첩 클래스 (Static Nested Class)
 * ================================================================
 *
 * 【학습 목표】
 * 1. static 키워드를 사용한 중첩 클래스를 정의하고 활용할 수 있다.
 * 2. 정적 중첩 클래스와 멤버 내부 클래스의 차이점을 설명할 수 있다.
 * 3. Builder 패턴에서 정적 중첩 클래스를 활용하는 방법을 이해한다.
 *
 * 【핵심 개념】
 * - 정적 중첩 클래스: static으로 선언된 내부 클래스
 * - 외부 클래스 인스턴스 없이도 독립적으로 인스턴스 생성 가능
 *   문법: new 외부클래스.정적중첩클래스()
 * - 외부 클래스의 static 멤버에만 직접 접근 가능 (인스턴스 멤버 접근 불가)
 * - Builder 패턴: 복잡한 객체 생성 시 단계별로 값을 설정하는 패턴
 *   장점: 생성자 매개변수가 많을 때 가독성 향상, 불변 객체 생성에 유리
 * ================================================================
 */
public class P02_StaticNestedClass {

    // ================================================================
    // 문제 1: static 내부 클래스 정의
    // ================================================================
    /**
     * 【문제 1】 대학교와 학과 - 정적 중첩 클래스
     *
     * 설명:
     *   University 외부 클래스와 Department 정적 중첩 클래스를 정의하세요.
     *   University는 static 필드로 universityName("한국대학교")을 가집니다.
     *   Department는 학과명(deptName), 학생수(studentCount), 교수수(professorCount)를 가집니다.
     *   Department의 displayInfo() 메소드는 소속 대학명(static 필드 접근)과
     *   학과 정보를 함께 출력합니다.
     *
     *   main에서 University 인스턴스 없이 Department를 직접 생성하여 테스트하세요.
     *
     * 예상 출력:
     *   [컴퓨터공학과]
     *   소속 대학: 한국대학교
     *   학생 수: 150명
     *   교수 수: 12명
     *
     * 힌트:
     *   - 정적 중첩 클래스 생성: University.Department dept = new University.Department(...)
     *   - 정적 중첩 클래스에서 외부 클래스 static 필드 접근: University.universityName
     *   - 인스턴스 필드(비static)에는 직접 접근 불가
     */
    static class University {
        static String universityName = "한국대학교";
        private String location; // 정적 중첩 클래스에서 직접 접근 불가

        // TODO: University 생성자 작성

        // TODO: Department 정적 중첩 클래스 정의 (static class Department)
        //       - String deptName 필드
        //       - int studentCount 필드
        //       - int professorCount 필드
        //       - 생성자 작성 (3개 매개변수)
        //       - displayInfo() 메소드: 소속 대학명(University.universityName)과 학과 정보 출력
        static class Department {
            // TODO: 필드 선언

            // TODO: 생성자 작성

            // TODO: displayInfo() 메소드 작성
        }
    }

    // ================================================================
    // 문제 2: static 내부 클래스 vs 멤버 내부 클래스 차이
    // ================================================================
    /**
     * 【문제 2】 도서관과 책 - 두 방식 비교
     *
     * 설명:
     *   Library 클래스를 아래와 같이 구성하세요:
     *
     *   [멤버 내부 클래스] BookRecord (non-static)
     *     - 도서 제목(title), 대출 횟수(loanCount)를 가집니다.
     *     - displayWithLibrary() 메소드에서 외부 클래스의 libraryName에 직접 접근합니다.
     *
     *   [정적 중첩 클래스] BookInfo (static)
     *     - ISBN, 도서 제목(title)을 가집니다.
     *     - displayISBNInfo() 메소드에서 Library의 static 필드만 접근 가능합니다.
     *
     *   main에서 두 클래스 인스턴스 생성 방법의 차이를 주석으로 설명하고,
     *   각각의 인스턴스를 생성하여 메소드를 호출하세요.
     *
     * 예상 출력:
     *   [멤버 내부 클래스 - BookRecord]
     *   도서관: 중앙도서관
     *   책 제목: 자바의 정석
     *   대출 횟수: 42회
     *
     *   [정적 중첩 클래스 - BookInfo]
     *   ISBN: 978-89-1234-567-8
     *   책 제목: Clean Code
     *
     * 힌트:
     *   - 멤버 내부 클래스: library.new BookRecord(...) (외부 인스턴스 필요)
     *   - 정적 중첩 클래스: new Library.BookInfo(...) (외부 인스턴스 불필요)
     */
    static class Library {
        private String libraryName;
        static String librarySystem = "도서관 관리 시스템 v2.0";

        // TODO: Library 생성자 작성

        // TODO: BookRecord 멤버 내부 클래스 (non-static) 정의
        //       외부 클래스의 libraryName에 직접 접근하여 출력
        class BookRecord {
            // TODO: 필드 선언 (title, loanCount)

            // TODO: 생성자 작성

            // TODO: displayWithLibrary() 메소드 작성
        }

        // TODO: BookInfo 정적 중첩 클래스 (static) 정의
        //       외부 클래스의 static 필드만 접근 가능
        static class BookInfo {
            // TODO: 필드 선언 (isbn, title)

            // TODO: 생성자 작성

            // TODO: displayISBNInfo() 메소드 작성
        }
    }

    // ================================================================
    // 문제 3: Builder 패턴 구현 (static 내부 클래스 활용)
    // ================================================================
    /**
     * 【문제 3】 피자 주문 Builder 패턴
     *
     * 설명:
     *   Pizza 클래스를 Builder 패턴으로 구현하세요.
     *   Pizza는 다음 필드를 가집니다:
     *     - String size (필수): "Small", "Medium", "Large"
     *     - String crustType (필수): "씬", "씩", "치즈크러스트"
     *     - String sauce (선택): 기본값 "토마토"
     *     - boolean extraCheese (선택): 기본값 false
     *     - String[] toppings (선택): 기본값 빈 배열
     *
     *   Pizza.Builder 정적 중첩 클래스를 구현하세요:
     *     - Builder(String size, String crustType): 필수값을 받는 생성자
     *     - sauce(String sauce): 소스 설정, Builder 반환
     *     - extraCheese(boolean extra): 추가 치즈 설정, Builder 반환
     *     - toppings(String... toppings): 토핑 설정, Builder 반환
     *     - build(): Pizza 인스턴스 반환
     *
     *   Pizza의 생성자는 private으로, Builder만을 통해 생성 가능하게 하세요.
     *   Pizza의 displayOrder() 메소드로 주문 내역을 출력하세요.
     *
     * 예상 출력:
     *   === 피자 주문 내역 ===
     *   크기: Large
     *   크러스트: 치즈크러스트
     *   소스: 토마토
     *   추가 치즈: 예
     *   토핑: 페퍼로니, 버섯, 올리브
     *
     *   === 피자 주문 내역 ===
     *   크기: Small
     *   크러스트: 씬
     *   소스: 바베큐
     *   추가 치즈: 아니오
     *   토핑: 없음
     *
     * 힌트:
     *   - Pizza 생성자를 private Pizza(Builder builder)로 선언하세요.
     *   - 메소드 체이닝: builder.sauce("바베큐").extraCheese(false).build()
     *   - toppings가 없을 경우 "없음"을 출력하세요.
     *   - String.join(", ", 배열)으로 토핑 목록을 연결할 수 있습니다.
     */
    static class Pizza {
        // TODO: Pizza 필드 선언 (모두 private final)

        // TODO: private Pizza(Builder builder) 생성자 작성
        //       Builder의 각 필드값을 Pizza의 필드에 할당

        // TODO: displayOrder() 메소드 작성

        // TODO: Pizza.Builder 정적 중첩 클래스 정의
        static class Builder {
            // TODO: Builder 필드 선언 (Pizza와 동일한 필드)

            // TODO: Builder 생성자 작성 (size, crustType 필수값)

            // TODO: sauce() 메소드 작성 (return this)

            // TODO: extraCheese() 메소드 작성 (return this)

            // TODO: toppings() 메소드 작성 (return this)

            // TODO: build() 메소드 작성 (return new Pizza(this))
        }
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: static 내부 클래스 정의 ===");
        // TODO: University.Department 인스턴스를 University 인스턴스 없이 직접 생성
        // TODO: dept.displayInfo() 호출

        System.out.println("\n=== 문제 2: static vs non-static 내부 클래스 비교 ===");
        // TODO: Library 인스턴스 생성 ("중앙도서관")
        // TODO: 멤버 내부 클래스 - library.new BookRecord(...) 로 생성
        // TODO: 정적 중첩 클래스 - new Library.BookInfo(...) 로 생성
        // TODO: 각각의 displayX() 메소드 호출

        System.out.println("\n=== 문제 3: Builder 패턴 ===");
        // TODO: Builder 패턴으로 피자 1 생성
        //       Pizza pizza1 = new Pizza.Builder("Large", "치즈크러스트")
        //           .sauce("토마토").extraCheese(true).toppings("페퍼로니","버섯","올리브").build()
        // TODO: Builder 패턴으로 피자 2 생성 (소스만 바베큐, 나머지 기본값)
        // TODO: 각 피자 displayOrder() 호출
    }
}
