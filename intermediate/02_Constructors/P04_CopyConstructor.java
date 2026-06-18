/**
 * =====================================================
 * 파일명: P04_CopyConstructor.java
 * 주제: 복사 생성자와 깊은 복사 (Copy Constructor & Deep Copy)
 * =====================================================
 *
 * [학습 목표]
 * 1. 얕은 복사(shallow copy)의 문제점을 이해하고 참조 공유로 인한 부작용을 체험한다.
 * 2. 복사 생성자(copy constructor)를 구현하여 깊은 복사(deep copy)를 수행하는 방법을 익힌다.
 * 3. clone() 메소드와 복사 생성자의 차이점을 비교하여 각각의 장단점을 이해한다.
 *
 * [핵심 개념]
 * - 얕은 복사(Shallow Copy): 객체의 참조값만 복사. 원본과 복사본이 같은 내부 객체를 공유.
 *   한쪽을 수정하면 다른 쪽에도 영향을 미치는 문제 발생.
 * - 깊은 복사(Deep Copy): 내부 객체까지 새로 생성하여 완전히 독립된 복사본 만들기.
 *   원본과 복사본이 서로 독립적으로 동작.
 * - 복사 생성자(Copy Constructor): 같은 타입의 객체를 매개변수로 받아
 *   필드를 하나씩 복사하는 생성자. "ClassName(ClassName other)" 형태.
 * - clone(): Object 클래스가 제공하는 복사 메소드. Cloneable 인터페이스 구현 필요.
 *   기본 동작은 얕은 복사이므로 깊은 복사를 위해 오버라이드해야 함.
 */
public class P04_CopyConstructor {

    public static void main(String[] args) {

        // =====================================================
        // 문제 1: 얕은 복사(shallow copy)의 문제점 확인
        // =====================================================
        // 제목: 대입 연산자(=)로 복사 시 참조 공유 문제 체험
        //
        // 설명:
        //   Team 클래스는 팀 이름과 멤버 목록(String 배열)을 가집니다.
        //   team1을 생성하고, "team2 = team1" 으로 복사한 뒤,
        //   team2의 멤버를 변경했을 때 team1에도 영향이 가는지 확인하세요.
        //   이것이 얕은 복사의 문제점입니다.
        //
        // 예상 출력:
        //   [문제 1] 얕은 복사 문제점
        //   team2 멤버 변경 전 team1: [김철수, 이영희, 박민준]
        //   team2 멤버 변경 후 team1: [김철수, 홍길동, 박민준]  <- team1이 변경됨!
        //   원인: team1과 team2는 같은 배열 객체를 참조하고 있습니다.
        //
        // 힌트:
        //   - "team2 = team1" 은 team2가 team1과 동일한 객체를 가리키게 합니다.
        //   - team2.members[1] = "홍길동"; 으로 변경 후 team1.members[1]을 출력하세요.
        //   - 배열은 참조 타입이므로 복사 시 주소값만 복사됩니다.

        System.out.println("[문제 1] 얕은 복사 문제점");
        System.out.println("---------------------------------------------");

        // TODO: Team 객체 team1 생성 ("드림팀", ["김철수", "이영희", "박민준"])

        // TODO: team2 = team1 으로 얕은 복사

        // TODO: team2 변경 전 team1 멤버 출력

        // TODO: team2.members[1] = "홍길동" 으로 변경

        // TODO: team2 변경 후 team1 멤버 출력 (team1도 바뀌어 있음을 확인)

        System.out.println();

        // =====================================================
        // 문제 2: 복사 생성자로 깊은 복사 구현
        // =====================================================
        // 제목: 복사 생성자를 이용한 독립적인 복사본 만들기
        //
        // 설명:
        //   TeamDeep 클래스에 복사 생성자를 구현하세요.
        //   복사 생성자는 원본 객체의 members 배열을 새로 할당하고
        //   각 원소를 하나씩 복사해야 합니다.
        //   복사본을 수정해도 원본에 영향이 없는지 확인하세요.
        //
        // 예상 출력:
        //   [문제 2] 복사 생성자로 깊은 복사
        //   원본 팀명: 드림팀, 복사본 팀명: 드림팀
        //   복사본 멤버 변경 전 원본: [김철수, 이영희, 박민준]
        //   복사본 멤버 변경 후 원본: [김철수, 이영희, 박민준]  <- 원본 변경 없음!
        //   복사본 멤버: [김철수, 홍길동, 박민준]
        //
        // 힌트:
        //   - 복사 생성자 형태: TeamDeep(TeamDeep other) { ... }
        //   - 배열 깊은 복사: this.members = new String[other.members.length];
        //     그 후 반복문으로 each 원소 복사
        //   - System.arraycopy() 또는 Arrays.copyOf()를 사용해도 됩니다.

        System.out.println("[문제 2] 복사 생성자로 깊은 복사");
        System.out.println("---------------------------------------------");

        // TODO: TeamDeep 원본 객체 생성

        // TODO: 복사 생성자로 복사본 생성

        // TODO: 변경 전 원본 출력

        // TODO: 복사본 멤버 변경 (members[1] = "홍길동")

        // TODO: 변경 후 원본과 복사본 모두 출력

        System.out.println();

        // =====================================================
        // 문제 3: clone() 메소드 vs 복사 생성자 비교
        // =====================================================
        // 제목: 두 가지 복사 방법의 장단점 비교
        //
        // 설명:
        //   Document 클래스는 Cloneable을 구현하여 clone() 메소드를 제공합니다.
        //   (1) clone()으로 복사한 객체를 수정해도 원본에 영향이 없는지 확인하세요.
        //   (2) 복사 생성자로 복사한 객체를 수정해도 원본에 영향이 없는지 확인하세요.
        //   두 방법의 결과를 비교하고 각각의 특징을 주석으로 정리하세요.
        //
        // 예상 출력:
        //   [문제 3] clone() vs 복사 생성자 비교
        //   원본 제목: 자바 입문
        //   clone() 복사본 제목 변경 후 원본: 자바 입문  (변경 없음)
        //   복사 생성자 복사본 제목 변경 후 원본: 자바 입문  (변경 없음)
        //   [비교 결론]
        //   clone(): Cloneable 구현 필요, 반환타입 캐스팅 필요, checked exception 처리 필요
        //   복사 생성자: 구현 간단, 타입 안전, 상속 시 더 유연
        //
        // 힌트:
        //   - clone() 사용: (Document) doc.clone() 형태이며 try-catch 필요
        //   - 복사 생성자 사용: new Document(original) 형태
        //   - String은 불변(immutable)이므로 별도 깊은 복사 불필요
        //   - int[] 같은 배열 필드가 있다면 배열은 깊은 복사 필요

        System.out.println("[문제 3] clone() vs 복사 생성자 비교");
        System.out.println("---------------------------------------------");

        // TODO: Document 원본 객체 생성 ("자바 입문", [1, 2, 3] 페이지 목록)

        // TODO: clone()으로 복사본 생성 (CloneNotSupportedException 처리 필요)

        // TODO: 복사 생성자로 복사본 생성

        // TODO: 각 복사본의 제목 변경 후 원본 비교 출력

        System.out.println("[비교 결론]");
        // TODO: clone()과 복사 생성자의 차이점을 출력으로 정리
    }

    // =====================================================
    // 내부 클래스: Team (문제 1 사용 - 얕은 복사 시연)
    // =====================================================
    static class Team {
        String teamName;        // 팀 이름
        String[] members;       // 멤버 목록

        // TODO: 팀 이름과 멤버 배열을 받는 생성자

        // 멤버 목록 출력 메소드 (시그니처만 - 내용 작성 필요)
        void printMembers() {
            // TODO: "[멤버1, 멤버2, ...]" 형태로 출력
        }
    }

    // =====================================================
    // 내부 클래스: TeamDeep (문제 2 사용 - 깊은 복사 시연)
    // =====================================================
    static class TeamDeep {
        String teamName;        // 팀 이름
        String[] members;       // 멤버 목록

        // TODO: 팀 이름과 멤버 배열을 받는 일반 생성자

        // TODO: 복사 생성자 - TeamDeep(TeamDeep other)
        //       members 배열을 새로 할당하고 원소 하나씩 복사

        // 멤버 목록 출력 메소드 (시그니처만 - 내용 작성 필요)
        void printMembers() {
            // TODO: "[멤버1, 멤버2, ...]" 형태로 출력
        }
    }

    // =====================================================
    // 내부 클래스: Document (문제 3 사용 - clone vs 복사 생성자)
    // =====================================================
    // Cloneable 인터페이스 구현: clone() 메소드 사용을 허용
    static class Document implements Cloneable {
        String title;       // 문서 제목
        int[] pageNumbers;  // 페이지 번호 배열

        // TODO: 제목과 페이지 번호 배열을 받는 일반 생성자

        // TODO: 복사 생성자 - Document(Document other)
        //       title과 pageNumbers를 깊은 복사

        // TODO: clone() 메소드 오버라이드
        //       super.clone() 호출 후 pageNumbers 배열 깊은 복사
        @Override
        protected Object clone() throws CloneNotSupportedException {
            // TODO: super.clone() 으로 기본 복사 수행 후
            //       pageNumbers 배열을 별도로 깊은 복사하여 반환
            return null;
        }

        // 제목 변경 메소드 (시그니처만 - 내용 작성 필요)
        void setTitle(String title) {
            // TODO: this.title = title
        }

        // 문서 정보 출력 메소드 (시그니처만 - 내용 작성 필요)
        void printInfo() {
            // TODO: "제목: %s, 페이지: %d장" 형태로 출력
        }
    }
}
