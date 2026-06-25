/*
 * ========================================================
 * 파일명: P01_ArrayBasics.java
 * 주제: 배열 기본 (Array Basics)
 * ========================================================
 *
 * 【학습목표】
 *  1. 배열의 선언, 초기화, 원소 접근 방법을 이해한다.
 *  2. 배열의 length 속성을 활용하여 배열 크기를 다룰 수 있다.
 *  3. 배열 복사 방법(얕은 복사, Arrays.copyOf)의 차이를 이해한다.
 *
 * 【핵심개념】
 *  - 배열(Array): 동일한 타입의 데이터를 연속된 메모리 공간에 저장하는 자료구조
 *  - 선언: int[] arr;
 *  - 생성: arr = new int[5];  또는 int[] arr = {1, 2, 3, 4, 5};
 *  - 인덱스: 0부터 시작, 마지막 인덱스 = length - 1
 *  - 얕은 복사: 참조값만 복사 (같은 배열을 가리킴)
 *  - Arrays.copyOf: 새로운 배열을 만들어 값을 복사 (독립적인 배열)
 *  - Arrays.fill: 배열의 모든 원소를 특정 값으로 채움
 *  - Arrays.copyOfRange: 배열의 특정 범위만 복사
 * ========================================================
 */

import java.util.Arrays;

public class P01_ArrayBasics {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: 배열 선언, 초기화, 원소 접근 및 변경 =====");
        /*
         * 【문제 1】 배열 선언, 초기화, 원소 접근, 변경, 출력
         *
         * 설명:
         *  - 크기가 5인 정수 배열을 선언하고 {10, 20, 30, 40, 50}으로 초기화하세요.
         *  - 첫 번째 원소와 세 번째 원소를 출력하세요.
         *  - 두 번째 원소의 값을 99로 변경한 후 배열 전체를 출력하세요.
         *
         * 예상 출력:
         *  첫 번째 원소: 10
         *  세 번째 원소: 30
         *  변경 후 배열: [10, 99, 30, 40, 50]
         *
         * 힌트:
         *  - 배열 선언: int[] numbers = {10, 20, 30, 40, 50};
         *  - 원소 접근: numbers[0] (첫 번째), numbers[2] (세 번째)
         *  - 배열 전체 출력: Arrays.toString(배열명)
         */

        // TODO: 크기 5인 정수 배열을 {10, 20, 30, 40, 50}으로 초기화하세요.
        int[] arr = {10, 20, 30, 40, 50};
        // TODO: 첫 번째 원소를 출력하세요. (예: "첫 번째 원소: 10")
        System.out.println("첫 번째 원소: " + arr[0]);
        // TODO: 세 번째 원소를 출력하세요. (예: "세 번째 원소: 30")
        System.out.println("세 번째 원소: " + arr[2]);
        // TODO: 두 번째 원소를 99로 변경하세요.
        arr[1] = 99;
        // TODO: 변경된 배열 전체를 출력하세요. (예: "변경 후 배열: [10, 99, 30, 40, 50]")
        System.out.println("변경 후 배열: " + Arrays.toString(arr));

        System.out.println("\n===== 문제 2: 배열 length 속성 활용 및 마지막 원소 접근 =====");
        /*
         * 【문제 2】 배열 length 속성 활용, 마지막 원소 접근
         *
         * 설명:
         *  - 문자열 배열 {"사과", "바나나", "딸기", "포도", "수박"}을 선언하세요.
         *  - 배열의 길이(크기)를 출력하세요.
         *  - for 반복문과 length 속성을 이용해 모든 원소를 출력하세요.
         *  - 배열의 마지막 원소를 length 속성을 이용해 출력하세요.
         *
         * 예상 출력:
         *  배열 크기: 5
         *  사과 바나나 딸기 포도 수박
         *  마지막 원소: 수박
         *
         * 힌트:
         *  - 배열 크기: 배열명.length
         *  - 마지막 인덱스: 배열명.length - 1
         */

        // TODO: 문자열 배열 {"사과", "바나나", "딸기", "포도", "수박"}을 선언하세요.
        String[] arr2 = {"사과", "바나나", "딸기", "포도", "수박"};
        // TODO: 배열의 크기를 출력하세요. (예: "배열 크기: 5")
        System.out.println("배열 크기: " + arr2.length);
        // TODO: for문과 length를 이용해 모든 원소를 한 줄에 공백으로 구분하여 출력하세요.
        for (int i=0; i< arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        // TODO: 마지막 원소를 length-1 인덱스를 사용하여 출력하세요. (예: "마지막 원소: 수박")
        System.out.println("마지막 원소: " + arr2[arr.length-1]);

        System.out.println("\n===== 문제 3: 배열 복사 (얕은 복사 vs Arrays.copyOf) =====");
        /*
         * 【문제 3】 배열 복사 (얕은 복사 vs Arrays.copyOf)
         *
         * 설명:
         *  - 정수 배열 original = {1, 2, 3, 4, 5}을 선언하세요.
         *  - 얕은 복사(참조 복사)로 shallowCopy 배열을 만드세요.
         *  - Arrays.copyOf로 deepCopy 배열을 만드세요.
         *  - original[0]을 100으로 변경한 후,
         *    shallowCopy와 deepCopy의 첫 번째 원소를 각각 출력하여 차이를 확인하세요.
         *
         * 예상 출력:
         *  original 변경 후: [100, 2, 3, 4, 5]
         *  얕은 복사 배열: [100, 2, 3, 4, 5]  <- original과 동일하게 변경됨
         *  깊은 복사 배열: [1, 2, 3, 4, 5]    <- 변경되지 않음
         *
         * 힌트:
         *  - 얕은 복사: int[] shallowCopy = original;
         *  - Arrays.copyOf: int[] deepCopy = Arrays.copyOf(original, original.length);
         */

        // TODO: 정수 배열 original = {1, 2, 3, 4, 5}을 선언하세요.
        int[] original = {1, 2, 3, 4, 5};
        // TODO: 얕은 복사(참조 복사)로 shallowCopy를 만드세요.
        int[] shallowCopy = original;
        // TODO: Arrays.copyOf를 이용해 deepCopy를 만드세요.
        int[] deepCopy = Arrays.copyOf(original, original.length);
        // TODO: original[0]을 100으로 변경하세요.
        original[0] = 100;
        // TODO: original, shallowCopy, deepCopy를 각각 출력하여 차이를 확인하세요.
        System.out.println("original 변경 후: " + Arrays.toString(original));
        System.out.println("얕은 복사 배열: " + Arrays.toString(shallowCopy));
        System.out.println("깊은 복사 배열: " + Arrays.toString(deepCopy));

        System.out.println("\n===== 문제 4: 배열 채우기 (Arrays.fill, Arrays.copyOfRange) =====");
        /*
         * 【문제 4】 Arrays.fill과 Arrays.copyOfRange 활용
         *
         * 설명:
         *  - 크기가 7인 정수 배열을 만들고 모든 원소를 5로 채우세요. (Arrays.fill 사용)
         *  - 배열을 출력하세요.
         *  - 기존 배열 {10, 20, 30, 40, 50, 60, 70}에서 인덱스 2부터 5 미만까지 복사하세요.
         *    (Arrays.copyOfRange 사용)
         *  - 복사된 부분 배열을 출력하세요.
         *
         * 예상 출력:
         *  fill 결과: [5, 5, 5, 5, 5, 5, 5]
         *  부분 복사 결과: [30, 40, 50]
         *
         * 힌트:
         *  - Arrays.fill(배열명, 채울값)
         *  - Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스)  <- 끝인덱스는 미포함
         */

        // TODO: 크기 7인 정수 배열을 선언하고 Arrays.fill로 모든 원소를 5로 채우세요.
        int[] arr3 = new int[7];
        Arrays.fill(arr3, 5);
        // TODO: fill 결과를 출력하세요. (예: "fill 결과: [5, 5, 5, 5, 5, 5, 5]")
        System.out.println("fill 결과: " + Arrays.toString(arr3));
        // TODO: 정수 배열 {10, 20, 30, 40, 50, 60, 70}을 선언하세요.
        int[] arr4 = {10, 20, 30, 40, 50, 60, 70};
        // TODO: Arrays.copyOfRange로 인덱스 2부터 5 미만까지 복사하세요.
        int[] arr5 = Arrays.copyOfRange(arr4, 2, 5);
        // TODO: 부분 복사 결과를 출력하세요. (예: "부분 복사 결과: [30, 40, 50]")
        System.out.println("부분 복사 결과: " + Arrays.toString(arr5));
    }
}
