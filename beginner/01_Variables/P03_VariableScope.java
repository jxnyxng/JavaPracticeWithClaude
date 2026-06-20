/*
 * ============================================================
 * 파일명: P03_VariableScope.java
 * 주제: 변수의 스코프 (범위)
 * ============================================================
 *
 * [학습목표]
 * 1. 클래스 필드(전역변수)와 메소드 지역변수의 차이를 설명할 수 있다.
 * 2. 블록({}) 안에서 선언된 변수의 유효 범위를 이해할 수 있다.
 * 3. this 키워드를 사용하여 필드 변수와 지역 변수를 구분할 수 있다.
 *
 * [핵심개념]
 * - 스코프(Scope): 변수가 유효하게 사용될 수 있는 코드 영역(범위)
 * - 클래스 필드(Field): 클래스 내부, 메소드 외부에 선언된 변수. 클래스 전체에서 접근 가능
 * - 지역변수(Local Variable): 메소드나 블록 내부에서 선언된 변수. 선언된 블록 내에서만 유효
 * - 블록(Block): 중괄호 {}로 감싸진 코드 영역
 * - this 키워드: 현재 객체 자신을 가리키는 참조 변수. 필드와 지역변수 이름이 같을 때 구분에 사용
 * ============================================================
 */
public class P03_VariableScope {

    // ============================================================
    // 클래스 필드(전역 변수) 선언 영역
    // ============================================================

    // TODO: String형 클래스 필드 name을 선언하고 "기본이름"으로 초기화하세요.
    //       (예: String name = "기본이름";)
    String name = "기본이름";
    // TODO: int형 클래스 필드 score를 선언하고 0으로 초기화하세요.
    int score = 0;
    // TODO: int형 클래스 필드 age를 선언하고 0으로 초기화하세요.
    int age = 0;

    // ============================================================
    // 문제 1: 클래스 필드 vs 메소드 지역변수 차이 이해
    // ============================================================
    /*
     * [문제 설명]
     * 아래 메소드 compareFieldAndLocal()을 완성하시오.
     * 클래스 필드(name, score)와 동일한 이름의 지역변수를 메소드 내에서 선언하고,
     * 필드와 지역변수의 값을 각각 출력하여 차이를 확인하시오.
     *
     * [예상 출력]
     * ===== 문제 1: 필드 vs 지역변수 =====
     * [필드] name = 기본이름
     * [필드] score = 0
     * [지역변수] name = 홍길동
     * [지역변수] score = 100
     * (지역변수가 선언된 블록 안에서는 같은 이름의 지역변수가 우선입니다)
     *
     * [힌트]
     * - 메소드 내부에서 선언한 지역변수는 동일한 이름의 필드를 가립니다(shadowing).
     * - this.name으로 필드에 접근하고, name으로 지역변수에 접근합니다.
     */
    void compareFieldAndLocal() {
        System.out.println("===== 문제 1: 필드 vs 지역변수 =====");

        // TODO: 클래스 필드 name과 score의 현재 값을 "[필드]" 레이블로 출력하세요.
        //       this.name, this.score 로 접근하세요.
        System.out.println("[필드] name = " + this.name);
        System.out.println("[필드] score = " + this.score);
        // TODO: 지역변수 name을 선언하고 "홍길동"으로 초기화하세요.
        String name = "홍길동";
        // TODO: 지역변수 score를 선언하고 100으로 초기화하세요.
        int score = 100;
        // TODO: 지역변수 name과 score의 값을 "[지역변수]" 레이블로 출력하세요.
        System.out.println("[지역변수] name = " + name);
        System.out.println("[지역변수] score = " + score);
        // TODO: 설명 메시지를 출력하세요.
        //       예: "(지역변수가 선언된 블록 안에서는 같은 이름의 지역변수가 우선입니다)"
        System.out.println("(지역변수가 선언된 블록 안에서는 같은 이름의 지역변수가 우선입니다)");
    }


    // ============================================================
    // 문제 2: 블록 내부 변수가 블록 밖에서 사용될 수 없는 이유 설명
    // ============================================================
    /*
     * [문제 설명]
     * 아래 메소드 blockScope()를 완성하시오.
     * if 블록 또는 for 블록 내부에 변수를 선언하고,
     * 해당 블록이 끝난 후 그 변수를 사용하면 어떻게 되는지 주석으로 설명하시오.
     *
     * [예상 출력]
     * ===== 문제 2: 블록 스코프 =====
     * if 블록 내부 값: 50
     * for 블록 0회 실행
     * for 블록 1회 실행
     * for 블록 2회 실행
     * (블록 외부에서는 위 변수들에 접근 불가)
     *
     * [힌트]
     * - if (true) { int blockVar = 50; ... } 로 블록을 만드세요.
     * - blockVar는 if 블록 밖에서 사용하면 컴파일 오류가 발생합니다.
     * - 오류가 발생하는 코드는 주석 처리하여 오류 이유를 설명하세요.
     */
    void blockScope() {
        System.out.println("\n===== 문제 2: 블록 스코프 =====");

        // TODO: if (true) 블록 안에서 int형 변수 blockVar를 선언하고 50으로 초기화하세요.
        //       블록 내부에서 blockVar 값을 출력하세요.
        if(true) {
            int blockVar = 50;
            System.out.println("if 블록 내부 값: " + blockVar);
        }

        // 블록 외부에서 blockVar에 접근을 시도하는 코드 (주석 처리된 상태로 남겨두세요)
        // System.out.println(blockVar); // 컴파일 오류: blockVar는 if 블록 내에서만 유효합니다.

        // TODO: for 반복문을 작성하고, 반복 변수 i는 블록 내부에서만 유효함을 확인하세요.
        //       반복문 안에서 "for 블록 i회 실행"을 출력하세요.

        for (int i = 0; i < 3; i++) {
            System.out.println("for 블록 " + i + "회 실행");
        }

        // for 반복문 외부에서 변수 i에 접근을 시도하는 코드 (주석 처리된 상태로 남겨두세요)
        // System.out.println(i); // 컴파일 오류: i는 for 블록 내에서만 유효합니다.

        System.out.println("(블록 외부에서는 위 변수들에 접근 불가)");
    }


    // ============================================================
    // 문제 3: 같은 이름의 지역변수와 필드 변수 구분 (this 사용)
    // ============================================================
    /*
     * [문제 설명]
     * 아래 메소드 useThisKeyword(String name, int age)를 완성하시오.
     * 매개변수 name, age와 클래스 필드 name, age가 같은 이름일 때,
     * this 키워드를 사용하여 필드에 매개변수 값을 올바르게 대입하고 출력하시오.
     *
     * [예상 출력]
     * ===== 문제 3: this 키워드로 필드 구분 =====
     * 매개변수 name: 김자바
     * 매개변수 age: 25
     * 필드 name (this.name): 김자바
     * 필드 age  (this.age): 25
     *
     * [힌트]
     * - 매개변수와 필드의 이름이 같을 때 this를 사용하지 않으면 자기 자신에게 대입하는 꼴이 됩니다.
     * - this.name = name; 으로 필드(this.name)에 매개변수(name) 값을 대입합니다.
     * - this는 주로 생성자나 setter 메소드에서 자주 사용됩니다.
     */
    void useThisKeyword(String name, int age) {
        System.out.println("\n===== 문제 3: this 키워드로 필드 구분 =====");

        // TODO: 매개변수 name과 age를 "[매개변수]" 레이블로 출력하세요.
        System.out.println("매개변수 name: " + name);
        System.out.println("매개변수 age: " + age);
        // TODO: this.name에 매개변수 name의 값을 대입하세요.
        this.name = name;
        // TODO: this.age에 매개변수 age의 값을 대입하세요.
        this.age = age;
        // TODO: 필드 this.name과 this.age를 "[필드]" 레이블로 출력하세요.
        System.out.println("필드 name (this.name): " + this.name);
        System.out.println("필드 age (this.age): " + this.age);
    }


    // ============================================================
    // main 메소드: 위의 문제들을 실행
    // ============================================================
    public static void main(String[] args) {

        // P03_VariableScope 객체 생성 후 각 메소드 호출
        P03_VariableScope obj = new P03_VariableScope();

        // TODO: obj.compareFieldAndLocal() 을 호출하세요.
        obj.compareFieldAndLocal();
        // TODO: obj.blockScope() 를 호출하세요.
        obj.blockScope();
        // TODO: obj.useThisKeyword("김자바", 25) 를 호출하세요.
        obj.useThisKeyword("김자바", 25);

    } // main 메소드 끝

} // P03_VariableScope 클래스 끝
