/**
 * ============================================================
 * 학습 목표:
 *   1. 제네릭 메소드를 정의하고 다양한 타입에 적용할 수 있다.
 *   2. 타입 파라미터를 메소드 반환 타입과 매개변수에 활용한다.
 *   3. 배열 조작(출력, 교환, 탐색)을 제네릭 메소드로 구현할 수 있다.
 *
 * 핵심 개념:
 *   - 제네릭 메소드: 반환 타입 앞에 <T>를 선언하는 메소드
 *     예) public static <T> void printArray(T[] arr) { ... }
 *   - 타입 추론(Type Inference): 호출 시 인자를 보고 컴파일러가 T를 자동으로 결정
 *   - 배열과 제네릭: T[]로 배열을 선언하면 모든 참조 타입 배열에 적용 가능
 *   - 제네릭 메소드 vs 제네릭 클래스: 메소드 단위로도 독립적으로 타입 파라미터 선언 가능
 * ============================================================
 */
public class P02_GenericMethods {

    // =========================================================
    // 문제 1: 배열 원소를 출력하는 제네릭 메소드
    // ---------------------------------------------------------
    // 설명:
    //   어떤 타입의 배열이든 받아서 모든 원소를 출력하는
    //   제네릭 메소드 printArray()를 구현하세요.
    //   - 원소들은 공백으로 구분하여 한 줄에 출력합니다.
    //   - 출력 후 줄바꿈을 합니다.
    //
    // 예상 출력:
    //   Integer 배열: 1 2 3 4 5
    //   String 배열: Java 제네릭 메소드 학습
    //   Double 배열: 1.1 2.2 3.3
    //
    // 힌트:
    //   - public static <T> void printArray(T[] arr)
    //   - for-each 루프로 순회
    //   - System.out.print(elem + " ") 사용
    // =========================================================
    public static <T> void printArray(T[] arr) {
        // TODO: arr의 모든 원소를 공백으로 구분하여 출력하세요.
        // TODO: 출력 후 줄바꿈(System.out.println())을 추가하세요.
    }

    // =========================================================
    // 문제 2: 두 원소를 교환하는 제네릭 메소드
    // ---------------------------------------------------------
    // 설명:
    //   배열에서 두 인덱스의 원소를 교환하는 제네릭 메소드 swap()을 구현하세요.
    //   - T[] 배열과 두 인덱스(i, j)를 매개변수로 받습니다.
    //   - arr[i]와 arr[j]의 값을 서로 교환합니다.
    //   - 교환 후 배열을 출력하는 printArray()를 활용하세요.
    //
    // 예상 출력:
    //   교환 전: 1 2 3 4 5
    //   인덱스 1, 3 교환 후: 1 4 3 2 5
    //   교환 전: Apple Banana Cherry
    //   인덱스 0, 2 교환 후: Cherry Banana Apple
    //
    // 힌트:
    //   - public static <T> void swap(T[] arr, int i, int j)
    //   - 임시 변수를 사용하여 두 값을 교환 (temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;)
    // =========================================================
    public static <T> void swap(T[] arr, int i, int j) {
        // TODO: arr[i]와 arr[j]를 임시 변수를 이용하여 교환하세요.
    }

    // =========================================================
    // 문제 3: 배열에서 특정 원소를 찾는 제네릭 메소드
    // ---------------------------------------------------------
    // 설명:
    //   배열에서 특정 원소의 인덱스를 찾는 제네릭 메소드 findElement()를 구현하세요.
    //   - T[] 배열과 찾을 원소(target)를 매개변수로 받습니다.
    //   - 원소가 발견되면 해당 인덱스를 반환하고, 없으면 -1을 반환합니다.
    //   - equals() 메소드를 사용하여 원소를 비교합니다.
    //
    // 예상 출력:
    //   "Java"의 인덱스: 1
    //   "Python"의 인덱스: -1
    //   정수 30의 인덱스: 2
    //
    // 힌트:
    //   - public static <T> int findElement(T[] arr, T target)
    //   - null 체크 후 target.equals(arr[i])로 비교
    //   - 발견 즉시 return i; 나머지는 return -1;
    // =========================================================
    public static <T> int findElement(T[] arr, T target) {
        // TODO: 배열을 순회하면서 target과 같은 원소의 인덱스를 반환하세요.
        // TODO: 없으면 -1을 반환하세요.
        return -1;
    }

    // =========================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // =========================================================

    /**
     * 배열의 최솟값 인덱스를 반환하는 헬퍼 메소드 (선택 문제)
     * - Comparable을 구현한 타입에만 사용 가능합니다.
     */
    public static <T extends Comparable<T>> int findMinIndex(T[] arr) {
        // TODO: (선택) 배열에서 최솟값의 인덱스를 찾아 반환하세요.
        return -1;
    }

    /**
     * 두 값 중 더 큰 값을 반환하는 헬퍼 메소드 (선택 문제)
     */
    public static <T extends Comparable<T>> T max(T a, T b) {
        // TODO: (선택) a와 b 중 더 큰 값을 반환하세요.
        return null;
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: 배열 원소 출력 제네릭 메소드 ===");
        Integer[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"Java", "제네릭", "메소드", "학습"};
        Double[] dblArr = {1.1, 2.2, 3.3};

        // TODO: printArray()를 호출하여 각 배열을 출력하세요.
        System.out.print("Integer 배열: ");
        // TODO: printArray(intArr) 호출

        System.out.print("String 배열: ");
        // TODO: printArray(strArr) 호출

        System.out.print("Double 배열: ");
        // TODO: printArray(dblArr) 호출

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: 두 원소 교환 제네릭 메소드 ===");
        Integer[] swapArr1 = {1, 2, 3, 4, 5};
        System.out.print("교환 전: ");
        // TODO: printArray(swapArr1) 호출

        // TODO: swap(swapArr1, 1, 3) 호출 후 결과 출력
        System.out.print("인덱스 1, 3 교환 후: ");
        // TODO: printArray(swapArr1) 호출

        String[] swapArr2 = {"Apple", "Banana", "Cherry"};
        System.out.print("교환 전: ");
        // TODO: printArray(swapArr2) 호출

        // TODO: swap(swapArr2, 0, 2) 호출 후 결과 출력
        System.out.print("인덱스 0, 2 교환 후: ");
        // TODO: printArray(swapArr2) 호출

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 배열에서 원소 탐색 제네릭 메소드 ===");
        String[] searchArr = {"Python", "Java", "C++", "JavaScript"};
        // TODO: findElement(searchArr, "Java")의 결과를 출력하세요.
        System.out.println("\"Java\"의 인덱스: " /* TODO: findElement 호출 */);

        // TODO: findElement(searchArr, "Python")의 결과를 출력하세요.
        System.out.println("\"Python\"의 인덱스: " /* TODO: findElement 호출 */);

        Integer[] numArr = {10, 20, 30, 40, 50};
        // TODO: findElement(numArr, 30)의 결과를 출력하세요.
        System.out.println("정수 30의 인덱스: " /* TODO: findElement 호출 */);
    }
}
