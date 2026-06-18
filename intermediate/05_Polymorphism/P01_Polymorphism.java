/**
 * 파일명: P01_Polymorphism.java
 * 주제: 다형성 (Polymorphism)
 *
 * ========================================
 * 학습 목표
 * ========================================
 * 1. 다형성의 개념을 이해하고 Animal 배열에 여러 자식 객체를 저장할 수 있다.
 * 2. 업캐스팅(자식 타입 → 부모 타입)의 원리와 활용법을 익힌다.
 * 3. 동적 바인딩을 통해 런타임에 실제 타입의 메소드가 호출됨을 이해한다.
 *
 * ========================================
 * 핵심 개념 설명
 * ========================================
 * [다형성 (Polymorphism)]
 *   - 하나의 타입으로 여러 형태의 객체를 다루는 능력
 *   - 부모 타입 변수에 자식 타입 객체를 대입할 수 있다 (업캐스팅)
 *   - 예: Animal a = new Dog();  // Dog 객체를 Animal 타입으로 참조
 *
 * [업캐스팅 (Upcasting)]
 *   - 자식 클래스 타입 → 부모 클래스 타입으로의 형변환
 *   - 묵시적(자동)으로 이루어지며 별도 캐스팅 연산자 불필요
 *   - 업캐스팅 후에는 부모 클래스에 정의된 멤버만 접근 가능
 *
 * [동적 바인딩 (Dynamic Binding)]
 *   - 메소드 호출이 컴파일 시가 아닌 런타임에 결정되는 방식
 *   - 부모 타입 변수로 메소드를 호출해도, 실제 객체의 오버라이딩된 메소드가 실행됨
 *   - 오버라이딩(Overriding)과 함께 다형성의 핵심을 이룬다
 */
public class P01_Polymorphism {

    // ----------------------------------------
    // 기반 클래스 및 자식 클래스 정의
    // ----------------------------------------

    /**
     * 동물 부모 클래스
     * 모든 동물의 공통 기능을 정의한다.
     */
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        /** 동물 소리를 출력하는 메소드 (자식 클래스에서 오버라이딩) */
        void makeSound() {
            System.out.println(name + ": (소리 없음)");
        }

        /** 동물 정보를 출력하는 메소드 */
        void showInfo() {
            System.out.println("동물 이름: " + name);
        }
    }

    /** 개 클래스 */
    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            // TODO: "멍멍!" 출력 구현
        }

        /** 개만 가진 특수 메소드 */
        void fetch() {
            System.out.println(name + "이(가) 공을 가져옵니다!");
        }
    }

    /** 고양이 클래스 */
    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            // TODO: "야옹~" 출력 구현
        }

        /** 고양이만 가진 특수 메소드 */
        void purr() {
            System.out.println(name + "이(가) 그루밍을 합니다.");
        }
    }

    /** 새 클래스 */
    static class Bird extends Animal {
        Bird(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            // TODO: "짹짹!" 출력 구현
        }

        /** 새만 가진 특수 메소드 */
        void fly() {
            System.out.println(name + "이(가) 날아갑니다!");
        }
    }

    // ----------------------------------------
    // 문제 1: Animal 배열에 여러 동물 저장 후 소리 출력
    // ----------------------------------------
    /**
     * [문제 1] 동물 배열과 다형성
     *
     * 설명:
     *   Animal 타입의 배열을 만들고, Dog/Cat/Bird 객체를 저장한 뒤
     *   반복문을 사용하여 각 동물의 makeSound()를 호출하세요.
     *
     * 예상 출력:
     *   =====동물 소리 테스트=====
     *   바둑이: 멍멍!
     *   나비: 야옹~
     *   짹짹이: 짹짹!
     *
     * 힌트:
     *   - Animal[] animals = new Animal[3]; 로 배열 선언
     *   - animals[0] = new Dog("바둑이"); 처럼 자식 객체 대입 (업캐스팅 자동 적용)
     *   - for (Animal a : animals) { a.makeSound(); } 로 반복 호출
     */
    static void problem1() {
        System.out.println("=====동물 소리 테스트=====");
        // TODO: Animal 배열 생성 (크기 3)

        // TODO: Dog("바둑이"), Cat("나비"), Bird("짹짹이") 객체를 배열에 저장

        // TODO: 향상된 for문으로 각 동물의 makeSound() 호출
    }

    // ----------------------------------------
    // 문제 2: 업캐스팅 연습
    // ----------------------------------------
    /**
     * [문제 2] 업캐스팅 (자식 → 부모 타입)
     *
     * 설명:
     *   자식 타입 변수를 부모 타입 변수에 대입(업캐스팅)하고,
     *   업캐스팅 전/후 접근 가능한 멤버의 차이를 확인하세요.
     *
     * 예상 출력:
     *   =====업캐스팅 테스트=====
     *   [자식 타입으로 접근]
     *   바둑이: 멍멍!
     *   바둑이이(가) 공을 가져옵니다!
     *   [부모 타입으로 접근]
     *   바둑이: 멍멍!
     *   (fetch() 메소드 접근 불가 - 컴파일 오류 발생)
     *
     * 힌트:
     *   - Dog dog = new Dog("바둑이");  // 자식 타입 변수
     *   - Animal animal = dog;          // 업캐스팅 (자동 형변환)
     *   - 업캐스팅 후 animal.fetch()는 컴파일 오류 → 주석으로 설명 남기기
     */
    static void problem2() {
        System.out.println("=====업캐스팅 테스트=====");
        // TODO: Dog 타입 변수 dog 생성

        // TODO: Animal 타입 변수 animal에 dog 대입 (업캐스팅)

        System.out.println("[자식 타입으로 접근]");
        // TODO: dog.makeSound() 호출
        // TODO: dog.fetch() 호출

        System.out.println("[부모 타입으로 접근]");
        // TODO: animal.makeSound() 호출 (동적 바인딩 → Dog의 makeSound 실행)
        // TODO: animal.fetch() 호출 시도는 컴파일 오류 → 주석으로 이유 설명
        // 이유: 업캐스팅 후 참조 타입이 Animal이므로 Animal에 없는 fetch()는 접근 불가
    }

    // ----------------------------------------
    // 문제 3: 동적 바인딩 확인
    // ----------------------------------------
    /**
     * [문제 3] 동적 바인딩 (런타임 메소드 결정)
     *
     * 설명:
     *   부모 타입 매개변수를 받는 메소드 printSound()를 정의하고,
     *   다양한 자식 객체를 전달하여 동적 바인딩이 어떻게 동작하는지 확인하세요.
     *
     * 예상 출력:
     *   =====동적 바인딩 테스트=====
     *   [Animal 타입 매개변수로 전달]
     *   바둑이: 멍멍!
     *   나비: 야옹~
     *   짹짹이: 짹짹!
     *   컴파일 타임: Animal 타입 / 런타임: 실제 객체 타입의 메소드 실행
     *
     * 힌트:
     *   - static void printSound(Animal a) 메소드를 만들어 a.makeSound() 호출
     *   - printSound(new Dog("바둑이")); 처럼 자식 객체 전달
     *   - 메소드 내부는 Animal 타입만 알지만, 실제 실행은 자식 메소드가 된다
     */
    static void problem3() {
        System.out.println("=====동적 바인딩 테스트=====");
        System.out.println("[Animal 타입 매개변수로 전달]");
        // TODO: printSound(new Dog("바둑이")) 호출
        // TODO: printSound(new Cat("나비")) 호출
        // TODO: printSound(new Bird("짹짹이")) 호출
        System.out.println("컴파일 타임: Animal 타입 / 런타임: 실제 객체 타입의 메소드 실행");
    }

    /**
     * 동적 바인딩 확인용 헬퍼 메소드
     * @param animal 부모 타입 매개변수로 어떤 자식 객체도 받을 수 있다
     */
    static void printSound(Animal animal) {
        // TODO: animal.makeSound() 호출
    }

    // ----------------------------------------
    // main 메소드
    // ----------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }
}
