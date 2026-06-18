/**
 * ============================================================
 * 학습 목표:
 *   1. 제네릭 클래스를 직접 정의하고 사용할 수 있다.
 *   2. 두 개 이상의 타입 파라미터를 가진 제네릭 클래스를 이해한다.
 *   3. 제네릭을 통해 얻을 수 있는 타입 안전성의 이점을 설명할 수 있다.
 *
 * 핵심 개념:
 *   - 제네릭(Generics): 클래스/메소드를 정의할 때 타입을 파라미터로 처리하는 기법
 *   - 타입 파라미터: <T>, <E>, <K, V> 등 꺾쇠 괄호 안에 선언되는 임시 타입 이름
 *   - 타입 안전성: 컴파일 시점에 타입 오류를 잡아내어 런타임 ClassCastException 방지
 *   - Raw Type: 제네릭 없이 사용하는 구식 방식 (권장하지 않음)
 *   - 타입 소거(Type Erasure): 컴파일 후 제네릭 타입 정보가 제거되는 JVM 특성
 * ============================================================
 */
public class P01_GenericClass {

    // =========================================================
    // 문제 1: Box<T> 제네릭 클래스 만들기
    // ---------------------------------------------------------
    // 설명:
    //   어떤 타입의 객체도 담을 수 있는 Box 클래스를 제네릭으로 구현하세요.
    //   - 타입 파라미터 T를 사용하여 Box 클래스를 선언합니다.
    //   - T 타입의 value 필드를 갖습니다.
    //   - 생성자, getValue(), setValue(), toString()을 구현합니다.
    //
    // 예상 출력:
    //   정수 박스 값: 42
    //   문자열 박스 값: Hello Generics
    //   Double 박스 값: 3.14
    //
    // 힌트:
    //   - class Box<T> { ... } 형태로 선언
    //   - T value; 와 같이 필드 선언
    // =========================================================
    static class Box<T> {
        // TODO: T 타입의 value 필드를 선언하세요.

        // TODO: T 타입을 인자로 받는 생성자를 작성하세요.

        // TODO: getValue() 메소드를 작성하세요.
        public T getValue() {
            // TODO: value를 반환하세요.
            return null;
        }

        // TODO: setValue() 메소드를 작성하세요.
        public void setValue(T value) {
            // TODO: value를 설정하세요.
        }

        // TODO: toString() 메소드를 오버라이드하세요.
        @Override
        public String toString() {
            // TODO: "Box[value=..." 형태의 문자열을 반환하세요.
            return null;
        }
    }

    // =========================================================
    // 문제 2: Pair<K, V> 두 타입 파라미터
    // ---------------------------------------------------------
    // 설명:
    //   두 개의 타입 파라미터를 갖는 Pair 클래스를 구현하세요.
    //   - 첫 번째 요소(first)와 두 번째 요소(second)를 보관합니다.
    //   - K는 Key(첫 번째), V는 Value(두 번째) 타입을 나타냅니다.
    //   - 두 쌍의 값을 교환하는 swap() 메소드를 구현합니다 (새 Pair 반환).
    //
    // 예상 출력:
    //   원본 쌍: (홍길동, 95)
    //   교환된 쌍: (95, 홍길동)
    //   좌표 쌍: (12.5, 37.8)
    //
    // 힌트:
    //   - class Pair<K, V> { ... } 형태로 선언
    //   - swap() 메소드는 Pair<V, K>를 반환합니다.
    // =========================================================
    static class Pair<K, V> {
        // TODO: K 타입의 first 필드를 선언하세요.

        // TODO: V 타입의 second 필드를 선언하세요.

        // TODO: 생성자를 작성하세요 (first, second를 초기화).

        // TODO: getFirst() 메소드를 작성하세요.
        public K getFirst() {
            // TODO: first를 반환하세요.
            return null;
        }

        // TODO: getSecond() 메소드를 작성하세요.
        public V getSecond() {
            // TODO: second를 반환하세요.
            return null;
        }

        // TODO: swap() 메소드를 작성하세요 (first와 second를 교환한 새 Pair 반환).
        public Pair<V, K> swap() {
            // TODO: 새로운 Pair<V, K>(second, first)를 반환하세요.
            return null;
        }

        // TODO: toString() 메소드를 오버라이드하세요.
        @Override
        public String toString() {
            // TODO: "(first, second)" 형태의 문자열을 반환하세요.
            return null;
        }
    }

    // =========================================================
    // 문제 3: 제네릭 타입의 타입 안전성 장점 설명
    // ---------------------------------------------------------
    // 설명:
    //   Object를 사용하는 구식 방식과 제네릭을 비교하여
    //   제네릭의 타입 안전성 장점을 코드로 보여주세요.
    //
    //   (a) ObjectBox 클래스: Object 타입을 사용하는 구식 방법
    //       - getValue() 호출 시 명시적 형변환(casting) 필요
    //       - 잘못된 형변환 시 런타임에 ClassCastException 발생 가능
    //
    //   (b) Box<T> 클래스(위에서 구현): 컴파일 시점에 타입 체크
    //       - 잘못된 타입 삽입 시 컴파일 오류 발생 (런타임 전에 발견)
    //       - 형변환 불필요
    //
    // 예상 출력:
    //   [구식 방법 - Object 사용]
    //   꺼낸 값 (형변환 필요): 안녕하세요
    //   잘못된 형변환 시 오류: class java.lang.String cannot be cast to class java.lang.Integer
    //
    //   [제네릭 사용]
    //   꺼낸 값 (형변환 불필요): 안녕하세요
    //   컴파일 단계에서 타입 오류가 잡히므로 안전합니다.
    //
    // 힌트:
    //   - try-catch로 ClassCastException을 잡아서 메시지 출력
    //   - Box<String>에 Integer를 넣으려 하면 컴파일 오류 (주석으로 설명)
    // =========================================================
    static class ObjectBox {
        // TODO: Object 타입의 value 필드를 선언하세요.

        // TODO: 생성자를 작성하세요.

        // TODO: getValue() 메소드를 작성하세요 (Object 반환).
        public Object getValue() {
            // TODO: value를 반환하세요.
            return null;
        }
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: Box<T> 제네릭 클래스 ===");
        // TODO: Box<Integer> intBox를 생성하고 값 42를 설정한 뒤 출력하세요.

        // TODO: Box<String> strBox를 생성하고 "Hello Generics"를 설정한 뒤 출력하세요.

        // TODO: Box<Double> dblBox를 생성하고 3.14를 설정한 뒤 출력하세요.

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: Pair<K, V> 두 타입 파라미터 ===");
        // TODO: Pair<String, Integer> p1 = new Pair<>("홍길동", 95); 생성 후 출력하세요.

        // TODO: p1.swap()으로 교환된 쌍을 출력하세요.

        // TODO: Pair<Double, Double> 좌표 쌍 (12.5, 37.8)을 생성하고 출력하세요.

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 타입 안전성 비교 ===");
        System.out.println("[구식 방법 - Object 사용]");
        // TODO: ObjectBox에 "안녕하세요"를 넣고 String으로 캐스팅하여 출력하세요.

        // TODO: ObjectBox에 "안녕하세요"를 넣고 Integer로 잘못 캐스팅 시도 후
        //       ClassCastException을 try-catch로 잡아 메시지를 출력하세요.

        System.out.println();
        System.out.println("[제네릭 사용]");
        // TODO: Box<String>에 "안녕하세요"를 넣고 형변환 없이 출력하세요.

        // TODO: 주석으로 "Box<String>에 Integer를 넣으면 컴파일 오류 발생" 설명을 작성하세요.
        System.out.println("컴파일 단계에서 타입 오류가 잡히므로 안전합니다.");
    }
}
