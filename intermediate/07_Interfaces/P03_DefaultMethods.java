/*
 * =====================================================
 * 파일명: P03_DefaultMethods.java
 * 주제: 디폴트 메소드 (Default Methods, Java 8+)
 * =====================================================
 *
 * 【학습목표】
 * 1. 인터페이스에 default 키워드로 구현이 있는 메소드를 추가하는 방법을 익힌다.
 * 2. 구현 클래스에서 디폴트 메소드를 오버라이딩하는 방법을 이해한다.
 * 3. 다이아몬드 문제(두 인터페이스에 동일한 default 메소드) 발생 원인과 해결 방법을 익힌다.
 *
 * 【핵심개념】
 * - 디폴트 메소드(Default Method):
 *   → Java 8부터 인터페이스에 구현이 있는 메소드를 추가할 수 있게 됨
 *   → 기존 인터페이스를 구현한 클래스를 수정하지 않고 새 기능을 추가할 때 유용
 *   → 선언: default 반환타입 메소드명() { 구현 }
 *
 * - 디폴트 메소드 오버라이딩:
 *   → 구현 클래스에서 필요하면 @Override로 재정의 가능
 *   → 오버라이딩하지 않으면 인터페이스의 기본 구현이 사용됨
 *
 * - 다이아몬드 문제(Diamond Problem):
 *   → 두 인터페이스 A, B 가 동일한 이름의 default 메소드를 가지고
 *     클래스 C가 A, B를 모두 구현하면 어느 쪽 default를 사용할지 모호해짐
 *   → 해결: 구현 클래스에서 반드시 해당 메소드를 오버라이딩
 *     또는 A.super.메소드명() 으로 특정 인터페이스의 default를 명시적으로 호출
 * =====================================================
 */
public class P03_DefaultMethods {

    // ================================================================
    // 【문제 1】 default 메소드로 인터페이스에 구현 추가
    // ================================================================
    /*
     * 문제 제목: Greeting 인터페이스의 default 메소드
     *
     * 상세 설명:
     *   1) Greeting 인터페이스를 선언하세요:
     *      - 추상 메소드: String getName()   → 구현 클래스가 반드시 구현
     *      - 디폴트 메소드: greet()           → "안녕하세요, [getName() 결과]님!" 출력
     *      - 디폴트 메소드: farewell()        → "[getName() 결과]님, 안녕히 가세요!" 출력
     *   2) KoreanUser 클래스가 Greeting을 구현하도록 작성하세요.
     *      - getName() 반환: 생성자로 받은 name 값
     *      - greet(), farewell()은 오버라이딩하지 않음 (디폴트 구현 사용)
     *   3) EnglishUser 클래스가 Greeting을 구현하도록 작성하세요.
     *      - getName() 반환: 생성자로 받은 name 값
     *      - greet(), farewell()은 오버라이딩하지 않음 (디폴트 구현 사용)
     *
     * 예상 출력:
     *   안녕하세요, 김철수님!
     *   김철수님, 안녕히 가세요!
     *   안녕하세요, John님!
     *   John님, 안녕히 가세요!
     *
     * 힌트:
     *   - default void greet() { System.out.println("안녕하세요, " + getName() + "님!"); }
     *   - default 메소드 내에서 추상 메소드(getName())를 호출할 수 있음
     */

    // TODO: Greeting 인터페이스를 선언하세요.
    // (getName() 추상 메소드, greet() 디폴트 메소드, farewell() 디폴트 메소드 포함)


    // TODO: KoreanUser 클래스를 작성하세요. (Greeting 구현, getName()만 오버라이딩)


    // TODO: EnglishUser 클래스를 작성하세요. (Greeting 구현, getName()만 오버라이딩)


    // ================================================================
    // 【문제 2】 디폴트 메소드 오버라이딩
    // ================================================================
    /*
     * 문제 제목: 디폴트 메소드를 오버라이딩하여 동작 변경
     *
     * 상세 설명:
     *   문제 1의 Greeting 인터페이스를 계속 사용합니다.
     *
     *   1) FormalUser 클래스가 Greeting을 구현하도록 작성하세요.
     *      - getName(): 생성자로 받은 title(직함)과 name을 조합하여 반환
     *        예) title="부장", name="박영수" → "박영수 부장"
     *      - greet() 오버라이딩: "안녕하십니까, [getName()] 님. 만나서 영광입니다."
     *      - farewell()은 오버라이딩하지 않음 (디폴트 구현 사용)
     *   2) VIPUser 클래스가 Greeting을 구현하도록 작성하세요.
     *      - getName(): 생성자로 받은 name 반환
     *      - greet() 오버라이딩: "VIP [getName()]님, 특별히 환영합니다!"
     *      - farewell() 오버라이딩: "VIP [getName()]님, 다음에 또 방문해 주세요!"
     *
     * 예상 출력:
     *   안녕하십니까, 박영수 부장 님. 만나서 영광입니다.
     *   박영수 부장님, 안녕히 가세요!          ← 디폴트 메소드 사용
     *   VIP 이지은님, 특별히 환영합니다!
     *   VIP 이지은님, 다음에 또 방문해 주세요!  ← 오버라이딩된 버전 사용
     *
     * 힌트:
     *   - @Override public void greet() { ... } 로 디폴트 메소드를 재정의
     *   - 오버라이딩하지 않은 farewell()은 인터페이스의 default 구현이 그대로 실행됨
     */

    // TODO: FormalUser 클래스를 작성하세요.
    // (title, name 필드, 생성자, getName() + greet() 오버라이딩)


    // TODO: VIPUser 클래스를 작성하세요.
    // (name 필드, 생성자, getName() + greet() + farewell() 오버라이딩)


    // ================================================================
    // 【문제 3】 다이아몬드 문제와 해결 (두 인터페이스의 같은 default 메소드)
    // ================================================================
    /*
     * 문제 제목: 다이아몬드 문제 발생 상황과 해결 방법
     *
     * 상세 설명:
     *   두 인터페이스가 동일한 이름의 default 메소드를 가질 때 충돌이 발생합니다:
     *
     *     InterfaceA → default void hello() { "A의 hello" 출력 }
     *     InterfaceB → default void hello() { "B의 hello" 출력 }
     *     class DiamondClass implements InterfaceA, InterfaceB
     *       → 어느 hello()를 사용할지 모호 → 컴파일 오류!
     *
     *   1) InterfaceA, InterfaceB를 선언하세요.
     *      - 둘 다 default void hello() 메소드를 가짐 (다른 내용 출력)
     *      - InterfaceA의 hello(): "InterfaceA의 default hello() 입니다."
     *      - InterfaceB의 hello(): "InterfaceB의 default hello() 입니다."
     *   2) DiamondSolver 클래스가 두 인터페이스를 구현하도록 작성하세요.
     *      - hello()를 오버라이딩하여 다이아몬드 문제를 해결하세요.
     *      - 해결 방법 A: 완전히 새로운 구현 작성
     *      - 해결 방법 B: InterfaceA.super.hello() 로 특정 인터페이스의 default 명시 호출
     *   3) BothCaller 클래스가 두 인터페이스를 구현하도록 작성하세요.
     *      - hello(): InterfaceA와 InterfaceB의 hello()를 둘 다 호출
     *
     * 예상 출력:
     *   [DiamondSolver] DiamondSolver가 hello()를 직접 구현하여 해결했습니다.
     *   [BothCaller] InterfaceA의 default hello() 입니다.
     *   [BothCaller] InterfaceB의 default hello() 입니다.
     *
     * 힌트:
     *   - InterfaceA.super.hello();  // 인터페이스의 super 호출 문법
     *   - 구현 클래스에서 반드시 hello()를 @Override 하여 모호성을 제거해야 함
     */

    // TODO: InterfaceA를 선언하세요. (default void hello() 포함)


    // TODO: InterfaceB를 선언하세요. (default void hello() 포함)


    // TODO: DiamondSolver 클래스를 작성하세요.
    // (InterfaceA, InterfaceB 구현, hello() 오버라이딩으로 다이아몬드 문제 해결)


    // TODO: BothCaller 클래스를 작성하세요.
    // (InterfaceA, InterfaceB 구현, hello() 에서 두 인터페이스의 default를 모두 호출)


    public static void main(String[] args) {

        System.out.println("=== 문제 1: 디폴트 메소드 기본 사용 ===");
        // TODO: KoreanUser, EnglishUser 객체 생성 후 greet(), farewell() 호출


        System.out.println("\n=== 문제 2: 디폴트 메소드 오버라이딩 ===");
        // TODO: FormalUser, VIPUser 객체 생성 후 greet(), farewell() 호출


        System.out.println("\n=== 문제 3: 다이아몬드 문제 해결 ===");
        // TODO: DiamondSolver, BothCaller 객체 생성 후 hello() 호출

    }
}
