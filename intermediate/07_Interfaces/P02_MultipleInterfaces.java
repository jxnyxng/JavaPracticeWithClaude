/*
 * =====================================================
 * 파일명: P02_MultipleInterfaces.java
 * 주제: 다중 인터페이스 구현 (Multiple Interface Implementation)
 * =====================================================
 *
 * 【학습목표】
 * 1. 한 클래스가 여러 인터페이스를 동시에 구현하는 방법을 익힌다.
 * 2. 다중 인터페이스 구현 시 발생하는 메소드 충돌 상황과 해결 방법을 이해한다.
 * 3. 인터페이스가 다른 인터페이스를 상속(extends)하는 방법을 익힌다.
 *
 * 【핵심개념】
 * - 다중 인터페이스 구현:
 *   → 자바는 클래스 다중 상속을 허용하지 않지만, 인터페이스는 다중 구현 가능
 *   → class Duck implements Swimmable, Runnable, Flyable { ... }
 *   → 구현 클래스는 모든 인터페이스의 추상 메소드를 반드시 구현해야 함
 *
 * - 메소드 시그니처 충돌:
 *   → 두 인터페이스에 동일한 메소드 시그니처가 있으면, 구현 클래스에서 한 번만 구현
 *   → 반환 타입까지 다르면 컴파일 오류 → 인터페이스 설계 시 주의 필요
 *
 * - 인터페이스 상속(extends):
 *   → 인터페이스는 다른 인터페이스를 extends 할 수 있음 (다중 상속도 가능)
 *   → interface SuperFly extends Flyable, Swimmable { void superAbility(); }
 * =====================================================
 */
public class P02_MultipleInterfaces {

    // ================================================================
    // 【문제 1】 Duck 클래스가 Swimmable, Runnable, Flyable을 모두 구현
    // ================================================================
    /*
     * 문제 제목: 오리(Duck)의 다중 인터페이스 구현
     *
     * 상세 설명:
     *   1) 아래 세 인터페이스를 선언하세요:
     *      - Swimmable: swim() 메소드
     *      - MyRunnable: run() 메소드  (java.lang.Runnable과 구분하기 위해 My 접두사 사용)
     *      - MyFlyable:  fly() 메소드
     *   2) Duck 클래스가 위 세 인터페이스를 모두 구현하도록 작성하세요.
     *      - swim() 출력: "오리가 물 위에서 헤엄칩니다."
     *      - run()  출력: "오리가 뒤뚱뒤뚱 달립니다."
     *      - fly()  출력: "오리가 낮게 날아갑니다."
     *      - name 필드(String), 생성자 포함
     *   3) Duck 객체를 각 인터페이스 타입으로 참조하여 해당 메소드 호출
     *
     * 예상 출력:
     *   오리가 물 위에서 헤엄칩니다.
     *   오리가 뒤뚱뒤뚱 달립니다.
     *   오리가 낮게 날아갑니다.
     *   [Swimmable로 참조] 오리가 물 위에서 헤엄칩니다.
     *
     * 힌트:
     *   - class Duck implements Swimmable, MyRunnable, MyFlyable { ... }
     *   - Swimmable s = new Duck("도널드"); → s.swim() 만 호출 가능
     */

    // TODO: Swimmable 인터페이스를 선언하세요. (swim() 추상 메소드)


    // TODO: MyRunnable 인터페이스를 선언하세요. (run() 추상 메소드)


    // TODO: MyFlyable 인터페이스를 선언하세요. (fly() 추상 메소드)


    // TODO: Duck 클래스를 작성하세요. (세 인터페이스 모두 구현)
    // (name 필드, 생성자, swim/run/fly 오버라이딩 포함)


    // ================================================================
    // 【문제 2】 인터페이스 충돌 문제와 해결
    // ================================================================
    /*
     * 문제 제목: 두 인터페이스의 동일 메소드 시그니처 충돌 해결
     *
     * 상세 설명:
     *   다음 두 인터페이스는 동일한 이름/시그니처의 메소드를 가지고 있습니다:
     *     - Printable: void print()
     *     - Displayable: void print()
     *
     *   1) Printable, Displayable 인터페이스를 선언하세요.
     *      - 둘 다 void print() 메소드를 가짐
     *   2) Document 클래스가 두 인터페이스를 모두 구현하도록 작성하세요.
     *      - print() 구현: "문서를 출력합니다. (Printable + Displayable 공통 구현)"
     *      - 충돌이 발생하지 않는 이유를 주석으로 설명하세요.
     *   3) 만약 반환 타입이 달랐다면 어떤 문제가 생기는지 주석으로 설명하세요.
     *
     * 예상 출력:
     *   문서를 출력합니다. (Printable + Displayable 공통 구현)
     *
     * 힌트:
     *   - 메소드 시그니처(이름 + 매개변수)가 같으면 구현 클래스에서 한 번만 구현하면 됨
     *   - 반환 타입이 다른 경우: 컴파일 오류 발생 → 이런 경우 인터페이스 수정 필요
     */

    // TODO: Printable 인터페이스를 선언하세요. (void print())


    // TODO: Displayable 인터페이스를 선언하세요. (void print())


    // TODO: Document 클래스를 작성하세요. (Printable, Displayable 모두 구현)
    // TODO: 주석으로 충돌이 발생하지 않는 이유를 설명하세요.
    // TODO: 주석으로 반환 타입이 달랐을 때의 문제점을 설명하세요.


    // ================================================================
    // 【문제 3】 인터페이스 상속 (인터페이스 extends 인터페이스)
    // ================================================================
    /*
     * 문제 제목: 인터페이스 계층 구조 설계
     *
     * 상세 설명:
     *   동물 능력 인터페이스 계층을 설계합니다:
     *
     *   Breathable (breathe())
     *       ↑ extends
     *   LandAnimal (walk())        AquaticAnimal (swimUnderwater())
     *       ↑ extends (둘 다)
     *   Amphibian  (생성: LandAnimal + AquaticAnimal 모두 상속받는 인터페이스)
     *       + 추가 메소드: switchHabitat()
     *
     *   1) Breathable, LandAnimal, AquaticAnimal, Amphibian 인터페이스를 선언하세요.
     *      - LandAnimal extends Breathable
     *      - AquaticAnimal extends Breathable
     *      - Amphibian extends LandAnimal, AquaticAnimal  (다중 인터페이스 상속)
     *        → switchHabitat() 메소드 추가
     *   2) Frog(개구리) 클래스가 Amphibian을 구현하도록 작성하세요.
     *      - breathe():         "개구리가 폐로 숨을 쉽니다."
     *      - walk():            "개구리가 네 발로 뜁니다."
     *      - swimUnderwater():  "개구리가 물속을 헤엄칩니다."
     *      - switchHabitat():   "개구리가 육지와 물 사이를 이동합니다."
     *   3) Frog 객체를 Amphibian 타입으로 참조하고 모든 메소드를 호출하세요.
     *
     * 예상 출력:
     *   개구리가 폐로 숨을 쉽니다.
     *   개구리가 네 발로 뜁니다.
     *   개구리가 물속을 헤엄칩니다.
     *   개구리가 육지와 물 사이를 이동합니다.
     *
     * 힌트:
     *   - interface Amphibian extends LandAnimal, AquaticAnimal { void switchHabitat(); }
     *   - Frog가 Amphibian을 구현하면 상위 인터페이스의 모든 메소드도 구현해야 함
     */

    // TODO: Breathable 인터페이스를 선언하세요. (breathe())


    // TODO: LandAnimal 인터페이스를 선언하세요. (Breathable 상속, walk())


    // TODO: AquaticAnimal 인터페이스를 선언하세요. (Breathable 상속, swimUnderwater())


    // TODO: Amphibian 인터페이스를 선언하세요. (LandAnimal, AquaticAnimal 다중 상속, switchHabitat())


    // TODO: Frog 클래스를 작성하세요. (Amphibian 구현, 모든 메소드 오버라이딩)


    public static void main(String[] args) {

        System.out.println("=== 문제 1: Duck의 다중 인터페이스 구현 ===");
        // TODO: Duck 객체 생성 후 swim(), run(), fly() 각각 호출


        // TODO: Duck 객체를 Swimmable 타입으로 참조하여 swim() 호출
        // Swimmable s = new Duck("도널드");


        System.out.println("\n=== 문제 2: 인터페이스 충돌 해결 ===");
        // TODO: Document 객체 생성 후 print() 호출


        System.out.println("\n=== 문제 3: 인터페이스 상속 계층 ===");
        // TODO: Frog 객체를 Amphibian 타입으로 참조하여 모든 메소드 호출

    }
}
