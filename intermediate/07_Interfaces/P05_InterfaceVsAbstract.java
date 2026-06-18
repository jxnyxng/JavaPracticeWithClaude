/*
 * =====================================================
 * 파일명: P05_InterfaceVsAbstract.java
 * 주제: 인터페이스 vs 추상 클래스 비교 (Interface vs Abstract Class)
 * =====================================================
 *
 * 【학습목표】
 * 1. 같은 시나리오를 인터페이스와 추상 클래스로 각각 구현하는 방법을 익힌다.
 * 2. 두 방식의 문법적, 설계적 차이를 명확히 이해한다.
 * 3. 실제 설계 상황에서 인터페이스와 추상 클래스 중 어느 것을 선택할지 판단 기준을 익힌다.
 *
 * 【핵심개념】
 * - 인터페이스 (Interface):
 *   → "무엇을 할 수 있는가(Can-Do)" 관계 표현 (능력/계약)
 *   → 다중 구현 가능 (implements A, B, C)
 *   → 모든 필드는 public static final (인스턴스 변수 없음)
 *   → Java 8 이전: 추상 메소드만 가능 / Java 8+: default, static 메소드 추가 가능
 *   → 생성자 없음
 *
 * - 추상 클래스 (Abstract Class):
 *   → "무엇인가(Is-A)" 관계 표현 (상속/분류)
 *   → 단일 상속만 가능 (extends 하나)
 *   → 인스턴스 변수, 생성자 가질 수 있음
 *   → 추상 메소드와 일반 메소드를 모두 가질 수 있음
 *   → 공통 코드를 상위 클래스에 두어 중복 제거 효과
 *
 * 【선택 기준 요약】
 *   인터페이스 선택:  다중 구현이 필요할 때 / 능력(행동) 계약을 정의할 때
 *                     / 서로 관련 없는 클래스들이 공통 행동을 가질 때
 *   추상 클래스 선택: 공통 코드(필드, 메소드)를 상위 클래스에 두고 싶을 때
 *                     / 강한 IS-A 관계일 때 / 생성자나 인스턴스 변수가 필요할 때
 * =====================================================
 */
public class P05_InterfaceVsAbstract {

    // ================================================================
    // 【문제 1】 같은 시나리오를 인터페이스로 구현
    // ================================================================
    /*
     * 문제 제목: 도형(Shape) 시나리오 - 인터페이스 방식
     *
     * 상세 설명:
     *   도형(Circle, Rectangle, Triangle)의 넓이/둘레를 계산하는 프로그램을
     *   인터페이스 방식으로 구현합니다.
     *
     *   1) Shape 인터페이스를 선언하세요:
     *      - double getArea()      → 넓이 계산 (추상 메소드)
     *      - double getPerimeter() → 둘레 계산 (추상 메소드)
     *      - default void printInfo(): "[도형명] 넓이: [넓이], 둘레: [둘레]" 출력
     *        (도형명은 getClass().getSimpleName()으로 가져오세요)
     *   2) Circle_I 클래스 (I = Interface 방식):
     *      - Shape 구현, radius 필드 (double), 생성자
     *      - getArea(): Math.PI * radius * radius
     *      - getPerimeter(): 2 * Math.PI * radius
     *   3) Rectangle_I 클래스:
     *      - Shape 구현, width, height 필드 (double), 생성자
     *      - getArea(): width * height
     *      - getPerimeter(): 2 * (width + height)
     *   4) Triangle_I 클래스:
     *      - Shape 구현, a, b, c 필드 (세 변의 길이, double), 생성자
     *      - getPerimeter(): a + b + c
     *      - getArea(): 헤론의 공식 사용
     *        s = (a+b+c)/2, area = Math.sqrt(s*(s-a)*(s-b)*(s-c))
     *
     * 예상 출력 (소수점 2자리):
     *   Circle_I 넓이: 78.54, 둘레: 31.42
     *   Rectangle_I 넓이: 24.00, 둘레: 20.00
     *   Triangle_I 넓이: 6.00, 둘레: 12.00
     *
     * 힌트:
     *   - default void printInfo() { System.out.printf("%s 넓이: %.2f, 둘레: %.2f%n", ...); }
     *   - 헤론의 공식: s = getPerimeter()/2; area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
     */

    // TODO: Shape 인터페이스를 선언하세요.
    // (getArea(), getPerimeter() 추상 메소드, printInfo() 디폴트 메소드 포함)


    // TODO: Circle_I 클래스를 작성하세요. (Shape 구현)
    // (radius 필드, 생성자, getArea(), getPerimeter() 구현)


    // TODO: Rectangle_I 클래스를 작성하세요. (Shape 구현)
    // (width, height 필드, 생성자, getArea(), getPerimeter() 구현)


    // TODO: Triangle_I 클래스를 작성하세요. (Shape 구현, 헤론의 공식)
    // (a, b, c 필드, 생성자, getArea(), getPerimeter() 구현)


    // ================================================================
    // 【문제 2】 같은 시나리오를 추상 클래스로 구현
    // ================================================================
    /*
     * 문제 제목: 도형(Shape) 시나리오 - 추상 클래스 방식
     *
     * 상세 설명:
     *   문제 1과 동일한 도형 시나리오를 추상 클래스 방식으로 구현합니다.
     *
     *   1) AbstractShape 추상 클래스를 선언하세요:
     *      - color 필드 (String, 도형 색상)
     *      - 생성자: AbstractShape(String color)
     *      - abstract double getArea()
     *      - abstract double getPerimeter()
     *      - 일반 메소드: getColor() → color 반환
     *      - 일반 메소드: printInfo() → "[도형명] 색상: [색상], 넓이: [넓이], 둘레: [둘레]" 출력
     *        (인터페이스 방식과 달리 color 정보도 함께 출력)
     *   2) Circle_A 클래스 (A = Abstract 방식):
     *      - AbstractShape 상속, radius 필드, 생성자(color, radius)
     *      - super(color) 로 부모 생성자 호출
     *      - getArea(), getPerimeter() 구현
     *   3) Rectangle_A 클래스:
     *      - AbstractShape 상속, width, height 필드, 생성자(color, width, height)
     *      - getArea(), getPerimeter() 구현
     *   4) Triangle_A 클래스:
     *      - AbstractShape 상속, a, b, c 필드, 생성자(color, a, b, c)
     *      - getArea(), getPerimeter() 구현 (헤론의 공식)
     *
     * 예상 출력:
     *   Circle_A 색상: 빨강, 넓이: 78.54, 둘레: 31.42
     *   Rectangle_A 색상: 파랑, 넓이: 24.00, 둘레: 20.00
     *   Triangle_A 색상: 초록, 넓이: 6.00, 둘레: 12.00
     *
     * 힌트:
     *   - abstract class AbstractShape { String color; AbstractShape(String c){ color=c; } ... }
     *   - class Circle_A extends AbstractShape { ... }
     *   - 추상 클래스는 color 같은 공통 상태를 중앙에서 관리할 수 있는 장점이 있음
     */

    // TODO: AbstractShape 추상 클래스를 선언하세요.
    // (color 필드, 생성자, abstract getArea/getPerimeter, getColor(), printInfo() 포함)


    // TODO: Circle_A 클래스를 작성하세요. (AbstractShape 상속)
    // (radius 필드, 생성자, getArea(), getPerimeter() 구현)


    // TODO: Rectangle_A 클래스를 작성하세요. (AbstractShape 상속)
    // (width, height 필드, 생성자, getArea(), getPerimeter() 구현)


    // TODO: Triangle_A 클래스를 작성하세요. (AbstractShape 상속, 헤론의 공식)
    // (a, b, c 필드, 생성자, getArea(), getPerimeter() 구현)


    // ================================================================
    // 【문제 3】 언제 인터페이스/추상 클래스를 선택하는지 분석
    // ================================================================
    /*
     * 문제 제목: 인터페이스 vs 추상 클래스 설계 판단
     *
     * 상세 설명:
     *   다음 시나리오를 분석하고, 인터페이스/추상 클래스 중 더 적합한 것을 선택하여
     *   구현하세요. 각 선택 이유를 주석으로 반드시 작성하세요.
     *
     *   [시나리오 A] 동물원 동물 관리 시스템
     *     - Tiger, Eagle, Dolphin 클래스가 있음
     *     - 공통 속성: name(이름), age(나이), sound(울음소리)
     *     - 공통 동작: eat() → "[이름]이(가) 밥을 먹습니다."
     *     - Tiger만 할 수 있음: run()
     *     - Eagle만 할 수 있음: fly()
     *     - Dolphin만 할 수 있음: swim()
     *     → 질문: 공통 부분은 인터페이스와 추상 클래스 중 어느 게 적합한가?
     *
     *   [시나리오 B] USB 장치 플러그인 시스템
     *     - Keyboard, Mouse, Printer, Camera 클래스가 있음
     *     - 모든 장치는 connect(), disconnect() 기능을 가져야 함
     *     - 각 장치는 이미 다른 부모 클래스를 상속 중일 수 있음
     *     → 질문: 인터페이스와 추상 클래스 중 어느 게 적합한가?
     *
     *   구현 요구사항:
     *   1) 시나리오 A에 적합한 방식(추상 클래스)으로 Animal 기반 클래스와
     *      Tiger, Eagle, Dolphin 을 구현하세요.
     *      - eat() 공통 구현은 상위 클래스에 작성
     *      - run(), fly(), swim()은 각 클래스에만 작성
     *   2) 시나리오 B에 적합한 방식(인터페이스)으로 UsbConnectable 인터페이스와
     *      Keyboard, Mouse 클래스를 구현하세요.
     *      - connect() 출력: "[장치명] USB에 연결되었습니다."
     *      - disconnect() 출력: "[장치명] USB 연결이 해제되었습니다."
     *   3) 각 시나리오 선택 이유를 아래 주석 블록에 작성하세요.
     *
     * 힌트:
     *   - 시나리오 A: 공통 필드(name, age)와 공통 구현(eat())이 있으므로 추상 클래스 적합
     *   - 시나리오 B: 이미 다른 클래스를 상속 중일 수 있고, 단순 계약(연결/해제)만
     *                 정의하면 되므로 인터페이스 적합
     */

    /*
     * ---------------------------------------------------------------
     * [시나리오 A 선택 이유 작성 공간]
     *
     * TODO: 시나리오 A에서 추상 클래스를 선택한 이유를 주석으로 작성하세요.
     *
     * 예시 형식:
     *   - 선택: 추상 클래스 (abstract class)
     *   - 이유 1: ...
     *   - 이유 2: ...
     *   - 인터페이스를 선택하지 않은 이유: ...
     * ---------------------------------------------------------------
     */

    // TODO: Animal 추상 클래스를 작성하세요.
    // (name, age 필드, 생성자, eat() 일반 메소드 포함)


    // TODO: Tiger 클래스를 작성하세요. (Animal 상속)
    // (생성자, run() 메소드 포함)


    // TODO: Eagle 클래스를 작성하세요. (Animal 상속)
    // (생성자, fly() 메소드 포함)


    // TODO: Dolphin 클래스를 작성하세요. (Animal 상속)
    // (생성자, swim() 메소드 포함)


    /*
     * ---------------------------------------------------------------
     * [시나리오 B 선택 이유 작성 공간]
     *
     * TODO: 시나리오 B에서 인터페이스를 선택한 이유를 주석으로 작성하세요.
     *
     * 예시 형식:
     *   - 선택: 인터페이스 (interface)
     *   - 이유 1: ...
     *   - 이유 2: ...
     *   - 추상 클래스를 선택하지 않은 이유: ...
     * ---------------------------------------------------------------
     */

    // TODO: UsbConnectable 인터페이스를 선언하세요.
    // (connect(), disconnect() 추상 메소드 포함)


    // TODO: Keyboard 클래스를 작성하세요. (UsbConnectable 구현)
    // (deviceName 필드, 생성자, connect(), disconnect() 구현)


    // TODO: Mouse 클래스를 작성하세요. (UsbConnectable 구현)
    // (deviceName 필드, 생성자, connect(), disconnect() 구현)


    // ================================================================
    // 비교 요약 표 (주석으로 작성)
    // ================================================================
    /*
     * ┌─────────────────────┬──────────────────────┬──────────────────────┐
     * │       항목          │     인터페이스        │    추상 클래스       │
     * ├─────────────────────┼──────────────────────┼──────────────────────┤
     * │ 키워드              │ interface             │ abstract class       │
     * │ 구현 키워드         │ implements            │ extends              │
     * │ 다중 적용           │ 가능 (여러 개)        │ 불가 (하나만)        │
     * │ 인스턴스 변수       │ 불가 (상수만)         │ 가능                 │
     * │ 생성자              │ 없음                  │ 있음                 │
     * │ 메소드 구현         │ default/static만 가능 │ 일반 메소드 가능     │
     * │ 접근 제한자         │ 묵시적 public         │ 자유롭게 설정 가능   │
     * │ 관계 표현           │ Can-Do (능력)         │ Is-A (분류)          │
     * │ 주 사용 목적        │ 계약/규약 정의        │ 공통 코드 공유       │
     * └─────────────────────┴──────────────────────┴──────────────────────┘
     */

    public static void main(String[] args) {

        System.out.println("=== 문제 1: 도형 시나리오 - 인터페이스 방식 ===");
        // TODO: Shape 배열에 Circle_I, Rectangle_I, Triangle_I 객체를 담으세요.
        // TODO: 반복문으로 각 도형의 printInfo()를 호출하세요.
        // (Circle: radius=5, Rectangle: 4x6, Triangle: 3,4,5)


        System.out.println("\n=== 문제 2: 도형 시나리오 - 추상 클래스 방식 ===");
        // TODO: AbstractShape 배열에 Circle_A, Rectangle_A, Triangle_A 객체를 담으세요.
        // TODO: 반복문으로 각 도형의 printInfo()를 호출하세요.
        // (색상: 빨강/파랑/초록, 나머지 값은 문제 1과 동일)


        System.out.println("\n=== 문제 3A: 동물원 시스템 - 추상 클래스 방식 ===");
        // TODO: Tiger, Eagle, Dolphin 객체를 생성하고 eat() 및 고유 메소드 호출


        System.out.println("\n=== 문제 3B: USB 장치 시스템 - 인터페이스 방식 ===");
        // TODO: UsbConnectable 배열에 Keyboard, Mouse 객체 담기
        // TODO: 반복문으로 connect(), disconnect() 호출

    }
}
