/**
 * =====================================================
 * 파일명: P03_ThisKeyword.java
 * 주제: this 키워드 (this Keyword)
 * =====================================================
 *
 * [학습 목표]
 * 1. this.필드명으로 인스턴스 필드와 지역변수(매개변수)를 명확히 구분하는 방법을 익힌다.
 * 2. this()를 활용한 생성자 체이닝으로 코드 중복을 제거하는 기법을 이해한다.
 * 3. 메소드가 this를 반환하는 메소드 체이닝(빌더 패턴)의 기본 원리를 습득한다.
 *
 * [핵심 개념]
 * - this 참조: 현재 객체 자신을 가리키는 참조변수. 모든 인스턴스 메소드 내부에서
 *   암묵적으로 존재하며, 필드와 지역변수 이름이 같을 때 구분에 필수적이다.
 * - this.필드: 현재 객체의 인스턴스 필드를 명시적으로 가리킨다.
 *   매개변수명과 필드명이 동일할 때 this.를 붙여 인스턴스 필드임을 구분한다.
 * - this(): 같은 클래스 내 다른 생성자를 호출. 반드시 생성자 첫 줄에 위치.
 * - 메소드 체이닝(Method Chaining): 메소드가 this를 반환하면 연속으로 메소드를
 *   호출할 수 있다. 빌더 패턴(Builder Pattern)의 기반이 되는 기법이다.
 */
public class P03_ThisKeyword {

    public static void main(String[] args) {

        // =====================================================
        // 문제 1: this.필드 vs 지역변수 구분
        // =====================================================
        // 제목: 매개변수 이름과 필드 이름이 같을 때 this 활용
        //
        // 설명:
        //   Person 클래스의 생성자에서 매개변수 이름과 필드 이름이 동일합니다.
        //   this.를 사용하지 않으면 어떤 문제가 발생하는지 확인하고,
        //   this.를 사용했을 때와 사용하지 않았을 때의 차이를 출력으로 비교하세요.
        //   올바른 버전과 잘못된 버전을 모두 구현하여 차이를 체험하세요.
        //
        // 예상 출력:
        //   [문제 1] this.필드 vs 지역변수
        //   [잘못된 초기화] 이름: null, 나이: 0
        //   [올바른 초기화] 이름: 이준혁, 나이: 25
        //
        // 힌트:
        //   - PersonBad: 생성자에서 this 없이 "name = name;" 처럼 작성하면
        //     지역변수에 지역변수를 대입하는 것과 같아 필드가 초기화되지 않습니다.
        //   - PersonGood: "this.name = name;" 처럼 작성해야 인스턴스 필드에 대입됩니다.
        //   - 이름과 나이가 같은 값으로 두 객체 생성 후 출력 결과를 비교하세요.

        System.out.println("[문제 1] this.필드 vs 지역변수");
        System.out.println("---------------------------------------------");

        // TODO: PersonBad 객체 생성 (this 없이 잘못 초기화) 후 출력
        // PersonBad bad = ...

        // TODO: PersonGood 객체 생성 (this 올바르게 사용) 후 출력
        // PersonGood good = ...

        System.out.println();

        // =====================================================
        // 문제 2: this()로 생성자 체이닝
        // =====================================================
        // 제목: 한 생성자에서 다른 생성자 호출하기
        //
        // 설명:
        //   Address 클래스에는 세 가지 생성자가 있습니다.
        //   (1) 도시명(city)만 받는 생성자: this(city, "미입력", "미입력") 호출
        //   (2) 도시+구(district)를 받는 생성자: this(city, district, "미입력") 호출
        //   (3) 도시+구+상세주소(detail)를 모두 받는 생성자 (실제 필드 초기화)
        //   this()를 사용하면 초기화 로직이 완전한 생성자 한 곳에만 있어야 합니다.
        //   각 생성자로 Address 객체를 생성하고 주소를 출력하세요.
        //
        // 예상 출력:
        //   [문제 2] this()로 생성자 체이닝
        //   주소: 서울시 미입력구 미입력
        //   주소: 서울시 강남구 미입력
        //   주소: 서울시 강남구 테헤란로 123번지
        //
        // 힌트:
        //   - this(...)는 생성자 내 반드시 첫 번째 줄에 위치해야 합니다.
        //   - 가장 많은 매개변수를 가진 생성자가 실제 필드에 값을 설정합니다.
        //   - 나머지 생성자들은 this()로 그 생성자에게 책임을 위임합니다.

        System.out.println("[문제 2] this()로 생성자 체이닝");
        System.out.println("---------------------------------------------");

        // TODO: 도시명만으로 Address 생성 후 출력 ("서울시")
        // Address a1 = ...

        // TODO: 도시+구로 Address 생성 후 출력 ("서울시", "강남구")
        // Address a2 = ...

        // TODO: 도시+구+상세주소로 Address 생성 후 출력
        // Address a3 = ...

        System.out.println();

        // =====================================================
        // 문제 3: this를 반환값으로 사용하는 빌더 패턴
        // =====================================================
        // 제목: 메소드 체이닝을 이용한 객체 설정
        //
        // 설명:
        //   QueryBuilder 클래스는 SQL 쿼리를 단계적으로 조립하는 클래스입니다.
        //   각 설정 메소드(setTable, setCondition, setLimit, setOrderBy)는
        //   this를 반환하여 메소드 체이닝이 가능하도록 구현되어 있습니다.
        //   아래처럼 한 줄로 연속 호출하여 쿼리를 완성하세요.
        //
        //   QueryBuilder query = new QueryBuilder()
        //       .setTable("users")
        //       .setCondition("age > 20")
        //       .setOrderBy("name")
        //       .setLimit(10);
        //
        // 예상 출력:
        //   [문제 3] this 반환 - 빌더 패턴
        //   생성된 쿼리: SELECT * FROM users WHERE age > 20 ORDER BY name LIMIT 10
        //
        // 힌트:
        //   - 각 setter 메소드의 반환 타입을 QueryBuilder로 설정하세요.
        //   - 메소드 마지막에 return this; 를 작성하면 자기 자신을 반환합니다.
        //   - build() 메소드는 지금까지 설정된 값을 조합하여 쿼리 문자열을 반환합니다.

        System.out.println("[문제 3] this 반환 - 빌더 패턴");
        System.out.println("---------------------------------------------");

        // TODO: QueryBuilder를 메소드 체이닝으로 구성하고 build() 호출 후 출력
        // QueryBuilder query = new QueryBuilder()
        //     .setTable(...)
        //     ...

    }

    // =====================================================
    // 내부 클래스: PersonBad (문제 1 - 잘못된 예시)
    // =====================================================
    static class PersonBad {
        String name;    // 이름
        int age;        // 나이

        // TODO: 생성자 작성 - this 없이 "name = name;" 으로 작성 (의도적으로 잘못된 버전)

        // 정보 출력 메소드 (시그니처만 - 내용 작성 필요)
        void displayInfo() {
            // TODO: "[잘못된 초기화] 이름: %s, 나이: %d" 형태로 출력
        }
    }

    // =====================================================
    // 내부 클래스: PersonGood (문제 1 - 올바른 예시)
    // =====================================================
    static class PersonGood {
        String name;    // 이름
        int age;        // 나이

        // TODO: 생성자 작성 - this.name = name; 으로 올바르게 작성

        // 정보 출력 메소드 (시그니처만 - 내용 작성 필요)
        void displayInfo() {
            // TODO: "[올바른 초기화] 이름: %s, 나이: %d" 형태로 출력
        }
    }

    // =====================================================
    // 내부 클래스: Address (문제 2 사용)
    // =====================================================
    static class Address {
        String city;        // 도시
        String district;    // 구
        String detail;      // 상세주소

        // TODO: 도시만 받는 생성자 -> this(city, "미입력", "미입력") 호출

        // TODO: 도시+구 받는 생성자 -> this(city, district, "미입력") 호출

        // TODO: 도시+구+상세주소 모두 받는 생성자 (실제 초기화)

        // 주소 출력 메소드 (시그니처만 - 내용 작성 필요)
        void displayInfo() {
            // TODO: "주소: %s %s %s" 형태로 출력
        }
    }

    // =====================================================
    // 내부 클래스: QueryBuilder (문제 3 사용)
    // =====================================================
    static class QueryBuilder {
        String table;       // 테이블명
        String condition;   // WHERE 조건
        String orderBy;     // 정렬 기준
        int limit;          // 결과 개수 제한

        // 기본 생성자 (기본값 초기화)
        QueryBuilder() {
            // TODO: table="", condition="", orderBy="", limit=-1 로 초기화
        }

        // TODO: setTable(String table) - this 반환
        QueryBuilder setTable(String table) {
            // TODO: this.table 설정 후 return this
            return this;
        }

        // TODO: setCondition(String condition) - this 반환
        QueryBuilder setCondition(String condition) {
            // TODO: this.condition 설정 후 return this
            return this;
        }

        // TODO: setOrderBy(String orderBy) - this 반환
        QueryBuilder setOrderBy(String orderBy) {
            // TODO: this.orderBy 설정 후 return this
            return this;
        }

        // TODO: setLimit(int limit) - this 반환
        QueryBuilder setLimit(int limit) {
            // TODO: this.limit 설정 후 return this
            return this;
        }

        // 쿼리 문자열 생성 메소드 (시그니처만 - 내용 작성 필요)
        String build() {
            // TODO: "SELECT * FROM table WHERE condition ORDER BY orderBy LIMIT limit"
            //       형태의 쿼리 문자열 생성 후 반환
            //       (condition, orderBy, limit 은 설정된 경우에만 포함)
            return "";
        }
    }
}
