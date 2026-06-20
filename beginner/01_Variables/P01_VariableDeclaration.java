/*
 * ============================================================
 * 파일명: P01_VariableDeclaration.java
 * 주제: 변수 선언과 초기화
 * ============================================================
 *
 * [학습목표]
 * 1. 자바의 기본 자료형 8가지를 선언하고 초기화할 수 있다.
 * 2. 변수를 활용하여 의미 있는 데이터를 저장하고 출력할 수 있다.
 * 3. 임시 변수를 이용한 swap(값 교환) 알고리즘을 구현할 수 있다.
 *
 * [핵심개념]
 * - 변수(Variable): 데이터를 저장하는 메모리 공간에 붙인 이름
 * - 선언(Declaration): 변수의 자료형과 이름을 지정하는 것 (예: int age;)
 * - 초기화(Initialization): 변수에 처음으로 값을 대입하는 것 (예: age = 20;)
 * - 기본 자료형 8가지: byte, short, int, long, float, double, char, boolean
 * - 오버플로우(Overflow): 자료형이 표현할 수 있는 최대값을 초과할 때 발생하는 현상
 * ============================================================
 */
public class P01_VariableDeclaration {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: 기본 자료형 8가지 변수 선언 및 출력
        // ============================================================
        /*
         * [문제 설명]
         * 자바의 기본 자료형 8가지(byte, short, int, long, float, double, char, boolean)
         * 각각 변수를 선언하고 적절한 값으로 초기화한 뒤 출력하시오.
         *
         * [예상 출력]
         * byte형 변수: 100
         * short형 변수: 30000
         * int형 변수: 2000000000
         * long형 변수: 9000000000000000000
         * float형 변수: 3.14
         * double형 변수: 3.141592653589793
         * char형 변수: A
         * boolean형 변수: true
         *
         * [힌트]
         * - long 타입 리터럴 끝에는 L 또는 l을 붙입니다. (예: 9000000000000000000L)
         * - float 타입 리터럴 끝에는 F 또는 f를 붙입니다. (예: 3.14f)
         * - char 타입은 작은따옴표('')로 감쌉니다. (예: 'A')
         */
        System.out.println("===== 문제 1: 기본 자료형 8가지 =====");

        // TODO: byte형 변수 byteVar를 선언하고 100으로 초기화하세요.
        byte byteVar = 100;
        // TODO: short형 변수 shortVar를 선언하고 30000으로 초기화하세요.
        short shortVar = 30000;
        // TODO: int형 변수 intVar를 선언하고 2000000000으로 초기화하세요.
        int intVar = 2000000000;
        // TODO: long형 변수 longVar를 선언하고 9000000000000000000L로 초기화하세요.
        long longVar = 9000000000000000000L;
        // TODO: float형 변수 floatVar를 선언하고 3.14f로 초기화하세요.
        float floatVar = 3.14f;
        // TODO: double형 변수 doubleVar를 선언하고 3.141592653589793으로 초기화하세요.
        double doubleVar = 3.141592653589793;
        // TODO: char형 변수 charVar를 선언하고 'A'로 초기화하세요.
        char charVar = 'A';
        // TODO: boolean형 변수 boolVar를 선언하고 true로 초기화하세요.
        boolean boolVar = true;
        // TODO: 각 변수를 "자료형 변수: 값" 형식으로 출력하세요.
        System.out.println("byte형 변수: " + byteVar);
        System.out.println("short형 변수: " + shortVar);
        System.out.println("int형 변수: " + intVar);
        System.out.println("long형 변수: " + longVar);
        System.out.println("float형 변수: " + floatVar);
        System.out.println("double형 변수: " + doubleVar);
        System.out.println("char형 변수: " + charVar);
        System.out.println("boolean형 변수: " + boolVar);
        // ============================================================
        // 문제 2: 두 변수의 값 교환 (Swap)
        // ============================================================
        /*
         * [문제 설명]
         * int형 변수 a와 b에 각각 10과 20을 저장한 뒤,
         * 임시 변수(temp)를 사용하여 두 변수의 값을 서로 교환하고 출력하시오.
         *
         * [예상 출력]
         * ===== 문제 2: 값 교환 (Swap) =====
         * 교환 전: a = 10, b = 20
         * 교환 후: a = 20, b = 10
         *
         * [힌트]
         * - 임시 변수(temp)를 사용하는 순서: temp = a → a = b → b = temp
         * - 변수 a와 b를 직접 교환하면 한 쪽 값이 사라지므로 반드시 임시 변수가 필요합니다.
         */
        System.out.println("\n===== 문제 2: 값 교환 (Swap) =====");

        // TODO: int형 변수 a를 선언하고 10으로 초기화하세요.
        int a = 10;
        // TODO: int형 변수 b를 선언하고 20으로 초기화하세요.
        int b = 20;
        // TODO: 교환 전 a와 b의 값을 출력하세요.
        System.out.println("교환 전: a = " + a + ", b = " + b);
        // TODO: 임시 변수 temp를 선언하고 swap 알고리즘을 구현하세요.
        //       순서: 1) temp = a  2) a = b  3) b = temp
        int temp = a;
        a = b;
        b = temp;
        // TODO: 교환 후 a와 b의 값을 출력하세요.
        System.out.println("교환 후: a = " + a + ", b = " + b);

        // ============================================================
        // 문제 3: 오버플로우(Overflow) 실험
        // ============================================================
        /*
         * [문제 설명]
         * byte 자료형의 최대값(127)을 변수에 저장한 뒤,
         * 거기에 1을 더하면 어떤 값이 출력되는지 확인하고,
         * 오버플로우 현상이 왜 발생하는지 이해하시오.
         *
         * [예상 출력]
         * ===== 문제 3: 오버플로우 실험 =====
         * byte 최대값: 127
         * 최대값 + 1 = -128  (오버플로우 발생!)
         * byte 최소값: -128
         * 최소값 - 1 = 127   (언더플로우 발생!)
         *
         * [힌트]
         * - byte의 범위는 -128 ~ 127입니다.
         * - 127 + 1은 수학적으로 128이지만, byte 범위를 초과하면 반대편(-128)으로 돌아옵니다.
         * - 이 현상을 오버플로우(Overflow)라고 합니다.
         * - byte 최대값은 직접 127을 입력하거나 (byte)(Byte.MAX_VALUE)를 사용할 수 있습니다.
         */
        System.out.println("\n===== 문제 3: 오버플로우 실험 =====");

        // TODO: byte형 변수 maxByte를 선언하고 byte의 최대값(127)으로 초기화하세요.
        byte maxByte = 127;
        // TODO: maxByte 값을 출력하세요.
        System.out.println("byte 최대값: " + maxByte);
        // TODO: maxByte에 1을 더한 결과를 byte로 캐스팅하여 출력하세요.
        //       (byte)(maxByte + 1) 형태로 사용하세요.
        System.out.println("최대값 + 1 = " + (byte)(maxByte + 1) + "  (오버플로우 발생!)");
        // TODO: byte형 변수 minByte를 선언하고 byte의 최소값(-128)으로 초기화하세요.
        byte minByte = -128;
        System.out.println("byte 최소값: " + minByte);
        // TODO: minByte에 1을 뺀 결과를 byte로 캐스팅하여 출력하세요.
        System.out.println("최소값 - 1 = " + (byte)(minByte - 1) + "   (언더플로우 발생!)");
    } // main 메소드 끝

} // P01_VariableDeclaration 클래스 끝