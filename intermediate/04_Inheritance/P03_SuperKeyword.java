/**
 * ============================================================
 * 파일명: P03_SuperKeyword.java
 * 주제: super 키워드
 * ============================================================
 *
 * [학습 목표]
 * 1. super()를 사용하여 자식 생성자에서 부모 생성자를 호출할 수 있다.
 * 2. super.메소드()를 사용하여 자식이 오버라이딩한 메소드 안에서 부모 메소드를 호출할 수 있다.
 * 3. 부모와 자식이 같은 이름의 필드/메소드를 가질 때 super로 구분할 수 있다.
 *
 * [핵심 개념]
 * - super(): 자식 생성자 첫 줄에서 부모 생성자를 호출하는 구문
 *   → 반드시 생성자의 첫 번째 줄에 작성해야 함
 *   → 명시하지 않으면 컴파일러가 자동으로 super()를 삽입 (단, 부모에 기본 생성자 있어야 함)
 *
 * - super.메소드(): 자식 클래스에서 부모 클래스의 메소드를 명시적으로 호출
 *   → 오버라이딩한 메소드 내에서 부모 버전 로직을 재활용할 때 유용
 *
 * - super.필드: 부모 클래스의 필드를 명시적으로 참조 (보통 this와 구분할 때 사용)
 *
 * - 생성자 호출 순서: 자식 객체 생성 시 부모 생성자가 먼저 실행된 후 자식 생성자 실행
 * ============================================================
 */
public class P03_SuperKeyword {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: super()로 부모 생성자 호출
        // ============================================================
        /*
         * [문제 설명]
         * Person 클래스와 이를 상속하는 Student 클래스를 완성하세요.
         * Student의 생성자에서 super()를 사용하여 Person의 생성자를 호출해야 합니다.
         *
         * [클래스 구조]
         * Person(부모)
         *   - name (String), age (int)
         *   + Person(String name, int age) : 생성자
         *   + introduce() : "이름: [name], 나이: [age]" 출력
         *
         * Student(자식) extends Person
         *   - studentId (String)   : 학번 (추가 필드)
         *   - major (String)       : 전공 (추가 필드)
         *   + Student(String name, int age, String studentId, String major)
         *     → super(name, age) 로 부모 생성자 호출 후 studentId, major 초기화
         *   + introduce() : @Override
         *     → super.introduce() 호출 후 "학번: [studentId], 전공: [major]" 추가 출력
         *
         * [예상 출력]
         * 이름: 김자바, 나이: 20
         * 학번: 2024001, 전공: 컴퓨터공학
         *
         * [힌트]
         * - super(name, age) 는 Student 생성자 첫 번째 줄에 작성
         * - super.introduce() 로 부모의 introduce()를 먼저 실행
         */

        System.out.println("=== 문제 1: super()로 부모 생성자 호출 ===");

        StudentPerson student = new StudentPerson("김자바", 20, "2024001", "컴퓨터공학");
        student.introduce();   // 부모 + 자식 정보 모두 출력

        System.out.println();

        // ============================================================
        // 문제 2: super.메소드()로 부모 메소드 호출
        // ============================================================
        /*
         * [문제 설명]
         * 부모의 메소드를 오버라이딩하면서, 부모 메소드 로직을 재활용하고 싶을 때
         * super.메소드()를 사용합니다.
         *
         * [클래스 구조]
         * BasicCoffee(부모)
         *   + make() : "1. 물 끓이기\n2. 커피 분말 넣기\n3. 완성!" 출력
         *
         * LatteCoffee(자식) extends BasicCoffee
         *   + make() : @Override
         *     → super.make() 호출 (기본 커피 과정)
         *     → 이후 "4. 우유 스팀하기\n5. 우유 붓기\n6. 라떼 완성!" 추가 출력
         *
         * [예상 출력]
         * [기본 커피]
         * 1. 물 끓이기
         * 2. 커피 분말 넣기
         * 3. 완성!
         * ----------
         * [라떼 커피]
         * 1. 물 끓이기
         * 2. 커피 분말 넣기
         * 3. 완성!
         * 4. 우유 스팀하기
         * 5. 우유 붓기
         * 6. 라떼 완성!
         *
         * [힌트]
         * LatteCoffee.make() 안에서 super.make()를 먼저 호출하면
         * 부모의 make() 내용이 그대로 실행됨
         */

        System.out.println("=== 문제 2: super.메소드() 호출 ===");

        BasicCoffee basic = new BasicCoffee();
        System.out.println("[기본 커피]");
        basic.make();

        System.out.println("----------");

        LatteCoffee latte = new LatteCoffee();
        System.out.println("[라떼 커피]");
        latte.make();

        System.out.println();

        // ============================================================
        // 문제 3: 부모와 자식의 같은 이름 필드 구분 (super.필드 vs this.필드)
        // ============================================================
        /*
         * [문제 설명]
         * 부모 클래스 Base와 자식 클래스 Derived 모두 "value"라는 이름의 필드를 가집니다.
         * Derived 클래스에서 super.value와 this.value를 구분하여 출력하세요.
         *
         * [클래스 구조]
         * Base(부모)
         *   - value = "부모 값"   (String 타입)
         *
         * Derived(자식) extends Base
         *   - value = "자식 값"   (String 타입, 부모의 value를 가림)
         *   + printValues() :
         *       "부모의 value: " + super.value 출력
         *       "자식의 value: " + this.value  출력
         *       "그냥 value:   " + value        출력 (this 생략, 자식 우선)
         *
         * [예상 출력]
         * 부모의 value: 부모 값
         * 자식의 value: 자식 값
         * 그냥 value:   자식 값
         *
         * [힌트]
         * 자식 클래스에서 부모와 같은 이름의 필드를 선언하면 부모 것을 '숨김(hiding)'
         * super.value 로 부모 필드에 접근 가능
         */

        System.out.println("=== 문제 3: super.필드 vs this.필드 ===");

        Derived derived = new Derived();
        derived.printValues();
    }
}

// ============================================================
// PersonPerson 클래스 (문제 1 - 부모)
// ============================================================
class PersonPerson {

    // TODO: name(String), age(int) 필드를 선언하세요.

    /**
     * 부모 생성자
     */
    public PersonPerson(String name, int age) {
        // TODO: this.name = name; this.age = age; 로 초기화하세요.
    }

    /**
     * 자기소개 출력
     */
    public void introduce() {
        // TODO: "이름: " + name + ", 나이: " + age 를 출력하세요.
    }
}

// ============================================================
// StudentPerson 클래스 (문제 1 - PersonPerson 상속)
// ============================================================
class StudentPerson extends PersonPerson {

    // TODO: studentId(String), major(String) 필드를 선언하세요.

    /**
     * 자식 생성자 — super()로 부모 생성자 먼저 호출
     */
    public StudentPerson(String name, int age, String studentId, String major) {
        // TODO: super(name, age) 를 첫 줄에 작성하세요.
        //       그 다음 this.studentId = studentId; this.major = major; 로 초기화
    }

    /**
     * 자기소개 오버라이딩 — 부모 내용 + 학생 추가 정보
     */
    @Override
    public void introduce() {
        // TODO: super.introduce() 를 호출한 뒤
        //       "학번: " + studentId + ", 전공: " + major 를 추가로 출력하세요.
    }
}

// ============================================================
// BasicCoffee 클래스 (문제 2 - 부모)
// ============================================================
class BasicCoffee {

    /**
     * 기본 커피 제조 과정
     */
    public void make() {
        // TODO: 아래 3줄을 출력하세요.
        //       "1. 물 끓이기"
        //       "2. 커피 분말 넣기"
        //       "3. 완성!"
    }
}

// ============================================================
// LatteCoffee 클래스 (문제 2 - BasicCoffee 상속)
// ============================================================
class LatteCoffee extends BasicCoffee {

    /**
     * 라떼 제조 과정 — 기본 커피 과정 후 우유 추가
     */
    @Override
    public void make() {
        // TODO: super.make() 를 먼저 호출하세요. (기본 커피 과정 실행)
        //       그 다음 아래 3줄을 추가로 출력하세요.
        //       "4. 우유 스팀하기"
        //       "5. 우유 붓기"
        //       "6. 라떼 완성!"
    }
}

// ============================================================
// Base 클래스 (문제 3 - 부모)
// ============================================================
class Base {
    // TODO: value 필드를 String 타입으로 선언하고 "부모 값" 으로 초기화하세요.
}

// ============================================================
// Derived 클래스 (문제 3 - Base 상속)
// ============================================================
class Derived extends Base {
    // TODO: value 필드를 String 타입으로 선언하고 "자식 값" 으로 초기화하세요.
    //       (부모의 value 필드와 이름이 같아서 부모 것을 숨기게 됨)

    /**
     * 부모 value와 자식 value를 구분하여 출력
     */
    public void printValues() {
        // TODO: 아래 3줄을 출력하세요.
        //       "부모의 value: " + super.value
        //       "자식의 value: " + this.value
        //       "그냥 value:   " + value
    }
}
