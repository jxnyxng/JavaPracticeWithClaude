import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 학습 목표:
 *   1. 비한정 와일드카드(?)와 상한/하한 경계 와일드카드를 구분하여 사용할 수 있다.
 *   2. PECS(Producer Extends, Consumer Super) 원칙을 이해하고 적용한다.
 *   3. 제네릭 타입 파라미터(<T>)와 와일드카드(?)의 차이를 설명할 수 있다.
 *
 * 핵심 개념:
 *   - 비한정 와일드카드 <?>: 모든 타입 허용, 읽기 전용 (null만 추가 가능)
 *   - 상한 경계 <? extends T>: T이거나 T의 하위 타입, 읽기(Producer)에 적합
 *   - 하한 경계 <? super T>: T이거나 T의 상위 타입, 쓰기(Consumer)에 적합
 *   - PECS 원칙:
 *       Producer(데이터를 꺼낼 때) → extends 사용
 *       Consumer(데이터를 넣을 때) → super 사용
 *   - 와일드카드 vs 타입 파라미터: 와일드카드는 타입 간 관계를 유연하게 표현할 때 사용
 * ============================================================
 */
public class P04_WildcardTypes {

    // 테스트용 클래스 계층 구조
    // Animal <- Dog, Cat
    // Dog <- Poodle
    static class Animal {
        String name;
        Animal(String name) { this.name = name; }
        public String toString() { return "Animal(" + name + ")"; }
    }
    static class Dog extends Animal {
        Dog(String name) { super(name); }
        public String toString() { return "Dog(" + name + ")"; }
    }
    static class Cat extends Animal {
        Cat(String name) { super(name); }
        public String toString() { return "Cat(" + name + ")"; }
    }
    static class Poodle extends Dog {
        Poodle(String name) { super(name); }
        public String toString() { return "Poodle(" + name + ")"; }
    }

    // =========================================================
    // 문제 1: <?> 비한정 와일드카드 - 읽기 전용
    // ---------------------------------------------------------
    // 설명:
    //   어떤 타입의 List든 받아서 모든 원소를 출력하는
    //   메소드 printList()를 비한정 와일드카드로 구현하세요.
    //   - List<?> 타입의 매개변수를 받습니다.
    //   - 리스트의 모든 원소를 출력합니다.
    //   - 비한정 와일드카드에서는 원소 추가가 불가능함을 주석으로 설명하세요.
    //
    // 예상 출력:
    //   [비한정 와일드카드 출력]
    //   Animal(고양이과)
    //   Dog(바둑이)
    //   Cat(야옹이)
    //   42
    //   Hello
    //
    // 힌트:
    //   - public static void printList(List<?> list)
    //   - Object elem으로 꺼낼 수 있음 (타입이 ? 이므로 Object로만 참조 가능)
    //   - list.add(...)는 컴파일 오류 (null 제외)
    // =========================================================
    public static void printList(List<?> list) {
        // TODO: list의 모든 원소를 출력하세요.
        // 참고: List<?>에서는 원소를 추가할 수 없습니다 (null 제외).
        //       꺼낼 때는 Object 타입으로만 받을 수 있습니다.
    }

    // =========================================================
    // 문제 2: <? extends T> 상한 경계 와일드카드
    // ---------------------------------------------------------
    // 설명:
    //   Animal의 하위 타입(Dog, Cat 등)을 담은 List를 받아
    //   모든 동물의 이름을 출력하는 메소드 printAnimalNames()를 구현하세요.
    //   - List<? extends Animal>로 매개변수를 선언합니다.
    //   - 각 원소를 Animal 타입으로 꺼내어 name 필드를 출력합니다.
    //   - 리스트에 원소를 추가하면 컴파일 오류가 발생함을 주석으로 설명하세요.
    //
    // 예상 출력:
    //   [상한 경계 와일드카드]
    //   강아지 이름: 바둑이
    //   강아지 이름: 복실이
    //   고양이 이름: 야옹이
    //   고양이 이름: 냥냥이
    //
    // 힌트:
    //   - public static void printAnimalNames(List<? extends Animal> list, String type)
    //   - Animal a = list.get(i); 와 같이 Animal로 꺼낼 수 있음
    //   - list.add(new Dog(...))는 컴파일 오류
    // =========================================================
    public static void printAnimalNames(List<? extends Animal> list, String type) {
        // TODO: list를 순회하며 각 Animal의 name을 "[type] 이름: [name]" 형태로 출력하세요.
        // 참고: List<? extends Animal>에서는 원소를 추가할 수 없습니다.
        //       꺼낼 때는 Animal 타입으로 받을 수 있습니다.
    }

    // =========================================================
    // 문제 3: <? super T> 하한 경계 와일드카드
    // ---------------------------------------------------------
    // 설명:
    //   Dog 또는 Dog의 상위 타입(Animal, Object)을 담는 List에
    //   Dog 객체들을 추가하는 메소드 addDogs()를 구현하세요.
    //   - List<? super Dog>로 매개변수를 선언합니다.
    //   - 매개변수로 받은 이름 배열로 Dog 객체를 생성하여 리스트에 추가합니다.
    //   - 꺼낼 때는 Object 타입으로만 받을 수 있음을 주석으로 설명하세요.
    //
    // 예상 출력:
    //   [하한 경계 와일드카드]
    //   Animal 리스트에 Dog 추가 후:
    //   Dog(바둑이)
    //   Dog(복실이)
    //   Dog(멍멍이)
    //
    // 힌트:
    //   - public static void addDogs(List<? super Dog> list, String[] names)
    //   - list.add(new Dog(name))은 가능
    //   - 꺼낼 때: Object obj = list.get(i); (Dog로 직접 캐스팅은 위험)
    // =========================================================
    public static void addDogs(List<? super Dog> list, String[] names) {
        // TODO: names 배열의 각 이름으로 Dog를 생성하여 list에 추가하세요.
        // 참고: List<? super Dog>에서는 Dog(또는 Dog의 하위 타입)를 추가할 수 있습니다.
        //       꺼낼 때는 Object 타입으로만 받을 수 있습니다.
    }

    // =========================================================
    // 문제 4: PECS 원칙 (Producer Extends Consumer Super)
    // ---------------------------------------------------------
    // 설명:
    //   PECS 원칙을 적용하여 원본 리스트에서 대상 리스트로 원소를 복사하는
    //   메소드 copy()를 구현하세요.
    //   - src(원본): List<? extends T> - 데이터를 꺼내므로 extends (Producer)
    //   - dest(대상): List<? super T>   - 데이터를 넣으므로 super (Consumer)
    //   - T 타입 파라미터를 사용하는 제네릭 메소드로 선언합니다.
    //
    // 예상 출력:
    //   [PECS 원칙 적용]
    //   복사 전 dest: []
    //   복사 후 dest: [Dog(바둑이), Dog(복실이), Poodle(구름이)]
    //   Animal 리스트에 Dog 복사: [Dog(바둑이), Dog(복실이), Poodle(구름이)]
    //
    // 힌트:
    //   - public static <T> void copy(List<? extends T> src, List<? super T> dest)
    //   - for (T elem : src) dest.add(elem);
    //   - src에서 꺼낸 값을 T로 받아 dest에 추가
    // =========================================================
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        // TODO: src의 모든 원소를 dest에 추가하세요.
        // PECS 원칙:
        //   - src (Producer): 데이터를 꺼내므로 <? extends T> 사용
        //   - dest (Consumer): 데이터를 넣으므로 <? super T> 사용
    }

    // =========================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // =========================================================

    /**
     * 비한정 와일드카드로 리스트의 크기를 반환하는 헬퍼 메소드
     */
    public static int getSize(List<?> list) {
        // TODO: list.size()를 반환하세요.
        return 0;
    }

    /**
     * 상한 경계 와일드카드로 Number 리스트의 합계를 반환하는 헬퍼 메소드
     */
    public static double sumNumbers(List<? extends Number> list) {
        // TODO: list의 모든 원소를 doubleValue()로 변환하여 합계를 반환하세요.
        return 0.0;
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: 비한정 와일드카드 <?> ===");
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("고양이과"));
        animalList.add(new Dog("바둑이"));
        animalList.add(new Cat("야옹이"));

        List<Integer> intList = new ArrayList<>();
        intList.add(42);

        List<String> strList = new ArrayList<>();
        strList.add("Hello");

        System.out.println("[비한정 와일드카드 출력]");
        // TODO: printList(animalList) 호출
        // TODO: printList(intList) 호출
        // TODO: printList(strList) 호출

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: 상한 경계 와일드카드 <? extends Animal> ===");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("바둑이"));
        dogs.add(new Dog("복실이"));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("야옹이"));
        cats.add(new Cat("냥냥이"));

        System.out.println("[상한 경계 와일드카드]");
        // TODO: printAnimalNames(dogs, "강아지") 호출
        // TODO: printAnimalNames(cats, "고양이") 호출

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 하한 경계 와일드카드 <? super Dog> ===");
        List<Animal> animalContainer = new ArrayList<>();
        String[] dogNames = {"바둑이", "복실이", "멍멍이"};

        System.out.println("[하한 경계 와일드카드]");
        System.out.println("Animal 리스트에 Dog 추가 후:");
        // TODO: addDogs(animalContainer, dogNames) 호출
        // TODO: printList(animalContainer) 호출

        System.out.println();

        // --- 문제 4 테스트 ---
        System.out.println("=== 문제 4: PECS 원칙 ===");
        List<Dog> srcDogs = new ArrayList<>();
        srcDogs.add(new Dog("바둑이"));
        srcDogs.add(new Dog("복실이"));
        srcDogs.add(new Poodle("구름이"));

        List<Animal> destAnimals = new ArrayList<>();

        System.out.println("[PECS 원칙 적용]");
        System.out.println("복사 전 dest: " + destAnimals);
        // TODO: copy(srcDogs, destAnimals) 호출
        System.out.println("복사 후 dest: " + destAnimals);

        // TODO: Dog 리스트를 Animal 리스트에 복사하는 것이 가능한 이유를 주석으로 설명하세요.
        //       (힌트: Poodle은 Dog의 하위 타입, Dog는 Animal의 하위 타입)
    }
}
