/**
 * 파일명: P02_Instanceof.java
 * 주제: instanceof 연산자와 다운캐스팅
 *
 * ========================================
 * 학습 목표
 * ========================================
 * 1. instanceof 연산자로 객체의 실제 타입을 런타임에 확인할 수 있다.
 * 2. 다운캐스팅 시 ClassCastException 발생 조건을 이해하고 안전하게 방지할 수 있다.
 * 3. Java 16+에서 도입된 패턴 매칭 instanceof 문법을 활용할 수 있다.
 *
 * ========================================
 * 핵심 개념 설명
 * ========================================
 * [instanceof 연산자]
 *   - 객체가 특정 클래스의 인스턴스인지 확인하는 연산자
 *   - 결과는 boolean (true / false)
 *   - 예: if (animal instanceof Dog) { ... }
 *   - null에 대해 instanceof를 사용하면 항상 false 반환
 *
 * [다운캐스팅 (Downcasting)]
 *   - 부모 클래스 타입 → 자식 클래스 타입으로의 형변환
 *   - 명시적 캐스팅 연산자 필요: (자식타입) 부모변수
 *   - 실제 객체가 해당 자식 타입이 아닐 경우 ClassCastException 발생
 *   - 안전하게 하려면 instanceof로 확인 후 다운캐스팅 수행
 *
 * [ClassCastException]
 *   - 잘못된 형변환 시 런타임에 발생하는 예외
 *   - 예: Animal a = new Cat(); Dog d = (Dog) a; // 런타임 오류!
 *
 * [패턴 매칭 instanceof (Java 16+)]
 *   - instanceof 확인과 동시에 변수에 바인딩하는 문법
 *   - 예: if (animal instanceof Dog dog) { dog.fetch(); }
 *   - 별도 캐스팅 코드가 필요 없어 코드가 간결해진다
 */
public class P02_Instanceof {

    // ----------------------------------------
    // 기반 클래스 및 자식 클래스 정의
    // ----------------------------------------

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void makeSound() {
            System.out.println(name + ": (소리 없음)");
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + ": 멍멍!");
        }

        void fetch() {
            System.out.println(name + "이(가) 공을 가져옵니다!");
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + ": 야옹~");
        }

        void purr() {
            System.out.println(name + "이(가) 그루밍을 합니다.");
        }
    }

    static class Bird extends Animal {
        Bird(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + ": 짹짹!");
        }

        void fly() {
            System.out.println(name + "이(가) 날아갑니다!");
        }
    }

    // ----------------------------------------
    // 문제 1: instanceof로 타입 체크 후 안전한 다운캐스팅
    // ----------------------------------------
    /**
     * [문제 1] instanceof를 이용한 안전한 다운캐스팅
     *
     * 설명:
     *   Animal 배열에 저장된 각 동물 객체를 instanceof로 타입을 확인한 뒤,
     *   안전하게 다운캐스팅하여 각 동물 고유의 메소드를 호출하세요.
     *
     * 예상 출력:
     *   =====instanceof 타입 체크=====
     *   [바둑이]
     *   instanceof Dog: true
     *   instanceof Cat: false
     *   바둑이이(가) 공을 가져옵니다!
     *   [나비]
     *   instanceof Dog: false
     *   instanceof Cat: true
     *   나비이(가) 그루밍을 합니다.
     *   [짹짹이]
     *   instanceof Bird: true
     *   짹짹이이(가) 날아갑니다!
     *
     * 힌트:
     *   - if (animal instanceof Dog) 로 타입 확인
     *   - Dog dog = (Dog) animal; 로 다운캐스팅
     *   - instanceof는 상속 관계도 체크한다 (Dog instanceof Animal → true)
     */
    static void problem1() {
        System.out.println("=====instanceof 타입 체크=====");
        Animal[] animals = {
            new Dog("바둑이"),
            new Cat("나비"),
            new Bird("짹짹이")
        };

        for (Animal animal : animals) {
            System.out.println("[" + animal.name + "]");
            // TODO: instanceof Dog 결과 출력
            // TODO: instanceof Cat 결과 출력
            // TODO: instanceof Dog이면 다운캐스팅 후 fetch() 호출
            // TODO: instanceof Cat이면 다운캐스팅 후 purr() 호출
            // TODO: instanceof Bird이면 다운캐스팅 후 fly() 호출
        }
    }

    // ----------------------------------------
    // 문제 2: ClassCastException 발생 조건과 방지
    // ----------------------------------------
    /**
     * [문제 2] ClassCastException 발생과 방지
     *
     * 설명:
     *   잘못된 다운캐스팅으로 ClassCastException이 발생하는 경우를 확인하고,
     *   instanceof로 방지하는 패턴을 작성하세요.
     *
     * 예상 출력:
     *   =====ClassCastException 테스트=====
     *   [잘못된 다운캐스팅 시도]
     *   ClassCastException 발생! 메시지: class P02_Instanceof$Cat cannot be cast...
     *   [instanceof로 방지]
     *   나비은(는) Dog가 아니므로 다운캐스팅 생략
     *   [안전하게 Dog인 경우만 처리]
     *   바둑이이(가) 공을 가져옵니다!
     *
     * 힌트:
     *   - Animal a = new Cat("나비"); Dog d = (Dog) a; 는 런타임 오류
     *   - try-catch (ClassCastException e) 로 예외 처리 가능
     *   - 근본적인 해결책은 instanceof 확인 후 캐스팅
     */
    static void problem2() {
        System.out.println("=====ClassCastException 테스트=====");

        System.out.println("[잘못된 다운캐스팅 시도]");
        Animal catAsAnimal = new Cat("나비");
        // TODO: try 블록 안에서 (Dog) catAsAnimal 시도
        // TODO: catch (ClassCastException e) 로 예외 잡고 메시지 출력

        System.out.println("[instanceof로 방지]");
        // TODO: instanceof Dog 체크 → false면 "다운캐스팅 생략" 메시지 출력

        System.out.println("[안전하게 Dog인 경우만 처리]");
        Animal dogAsAnimal = new Dog("바둑이");
        // TODO: instanceof 확인 후 안전하게 다운캐스팅하여 fetch() 호출
    }

    // ----------------------------------------
    // 문제 3: 패턴 매칭 instanceof (Java 16+)
    // ----------------------------------------
    /**
     * [문제 3] 패턴 매칭 instanceof (Java 16+)
     *
     * 설명:
     *   기존 instanceof + 다운캐스팅 코드를 Java 16+의 패턴 매칭 문법으로
     *   리팩토링하여 코드를 간결하게 만드세요.
     *
     * 예상 출력:
     *   =====패턴 매칭 instanceof=====
     *   [기존 방식]
     *   바둑이이(가) 공을 가져옵니다!
     *   [패턴 매칭 방식 (Java 16+)]
     *   바둑이이(가) 공을 가져옵니다!
     *   나비이(가) 그루밍을 합니다.
     *   짹짹이이(가) 날아갑니다!
     *
     * 힌트:
     *   기존 방식:
     *     if (animal instanceof Dog) {
     *         Dog dog = (Dog) animal;  // 명시적 캐스팅 필요
     *         dog.fetch();
     *     }
     *   패턴 매칭 방식:
     *     if (animal instanceof Dog dog) {  // 선언과 캐스팅 동시에!
     *         dog.fetch();
     *     }
     */
    static void problem3() {
        System.out.println("=====패턴 매칭 instanceof=====");

        Animal[] animals = {
            new Dog("바둑이"),
            new Cat("나비"),
            new Bird("짹짹이")
        };

        System.out.println("[기존 방식]");
        Animal first = animals[0];
        // TODO: 기존 방식(instanceof + 명시적 캐스팅)으로 fetch() 호출

        System.out.println("[패턴 매칭 방식 (Java 16+)]");
        for (Animal animal : animals) {
            // TODO: 패턴 매칭 instanceof로 Dog이면 fetch(), Cat이면 purr(), Bird이면 fly() 호출
        }
    }

    /**
     * 헬퍼 메소드: 동물 타입 정보를 출력한다
     * @param animal 타입을 확인할 Animal 객체
     */
    static void printTypeInfo(Animal animal) {
        // TODO: animal의 이름과 실제 타입(getClass().getSimpleName()) 출력
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
