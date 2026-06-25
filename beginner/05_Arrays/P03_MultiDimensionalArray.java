/*
 * ========================================================
 * 파일명: P03_MultiDimensionalArray.java
 * 주제: 다차원 배열 (Multi-Dimensional Array)
 * ========================================================
 *
 * 【학습목표】
 *  1. 2차원 배열의 선언, 초기화, 원소 접근 방법을 이해한다.
 *  2. 중첩 반복문을 이용해 행렬 연산(덧셈, 전치)을 구현할 수 있다.
 *  3. 정방 행렬의 대각선 원소를 인덱스 패턴으로 접근할 수 있다.
 *
 * 【핵심개념】
 *  - 2차원 배열 선언: int[][] matrix = new int[행수][열수];
 *  - 2차원 배열 초기화: int[][] matrix = {{1,2,3}, {4,5,6}};
 *  - 원소 접근: matrix[행인덱스][열인덱스]
 *  - 행 수: matrix.length
 *  - 열 수: matrix[0].length
 *  - 행렬 덧셈: 같은 위치(i, j)의 원소끼리 더함
 *  - 행렬 전치(Transpose): result[j][i] = original[i][j]
 *  - 주대각선: 행 인덱스 == 열 인덱스 (i == j)
 *  - 부대각선: 행 인덱스 + 열 인덱스 == 크기 - 1
 * ========================================================
 */

import java.util.Arrays;

public class P03_MultiDimensionalArray {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: 2x3 행렬 선언, 초기화, 출력 =====");
        /*
         * 【문제 1】 2x3 행렬 선언, 초기화, 출력
         *
         * 설명:
         *  - 2행 3열의 정수 행렬을 아래 값으로 초기화하세요.
         *    1행: 1, 2, 3
         *    2행: 4, 5, 6
         *  - 중첩 반복문을 이용해 행렬을 표 형태로 출력하세요.
         *  - 각 원소의 행 인덱스와 열 인덱스도 함께 출력하세요.
         *
         * 예상 출력:
         *  matrix[0][0]=1  matrix[0][1]=2  matrix[0][2]=3
         *  matrix[1][0]=4  matrix[1][1]=5  matrix[1][2]=6
         *
         * 힌트:
         *  - int[][] matrix = {{1,2,3},{4,5,6}};
         *  - 바깥 반복문: 행(i), 안쪽 반복문: 열(j)
         *  - 줄바꿈: 안쪽 반복문 종료 후 System.out.println()
         */

        // TODO: 2x3 정수 행렬을 {{1,2,3},{4,5,6}}으로 초기화하세요.
        int[][] matrix = {{1,2,3},{4,5,6}};
        // TODO: 중첩 반복문으로 "matrix[i][j]=값" 형태로 출력하세요.
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                System.out.print("matrix["+i+"]["+j+"]=" + matrix[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("\n===== 문제 2: 두 행렬의 합 계산 (행렬 덧셈) =====");
        /*
         * 【문제 2】 두 행렬의 합 계산 (행렬 덧셈)
         *
         * 설명:
         *  - 3x3 행렬 matA와 matB를 아래와 같이 초기화하세요.
         *    matA: {{1,2,3},{4,5,6},{7,8,9}}
         *    matB: {{9,8,7},{6,5,4},{3,2,1}}
         *  - 같은 크기의 결과 행렬 result를 선언하세요.
         *  - 중첩 반복문으로 matA + matB를 계산하여 result에 저장하세요.
         *  - matA, matB, result를 각각 행렬 형태로 출력하세요.
         *
         * 예상 출력:
         *  행렬 A:
         *  1 2 3
         *  4 5 6
         *  7 8 9
         *  행렬 B:
         *  9 8 7
         *  6 5 4
         *  3 2 1
         *  A + B:
         *  10 10 10
         *  10 10 10
         *  10 10 10
         *
         * 힌트:
         *  - result[i][j] = matA[i][j] + matB[i][j]
         *  - 출력 시 같은 행의 원소는 공백으로 구분, 행 끝에서 줄바꿈
         */

        // TODO: 3x3 행렬 matA = {{1,2,3},{4,5,6},{7,8,9}}를 선언하세요.
        int[][] matA = {{1,2,3},{4,5,6},{7,8,9}};

        // TODO: 3x3 행렬 matB = {{9,8,7},{6,5,4},{3,2,1}}를 선언하세요.
        int[][] matB = {{9,8,7},{6,5,4},{3,2,1}};
        // TODO: 결과를 저장할 3x3 행렬 result를 선언하세요.
        int[][] result = new int[3][3];
        // TODO: 중첩 반복문으로 행렬 덧셈을 수행하세요. (result[i][j] = matA[i][j] + matB[i][j])
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                result[i][j] = matA[i][j] + matB[i][j];
            }
        }
        // TODO: matA, matB, result를 각각 제목과 함께 출력하세요.
        System.out.println("행렬 A:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(matA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("행렬 B:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(matB[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("A + B:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("\n===== 문제 3: 행렬 전치 (행과 열 바꾸기) =====");
        /*
         * 【문제 3】 행렬 전치 (행과 열 바꾸기)
         *
         * 설명:
         *  - 2x3 행렬 original = {{1,2,3},{4,5,6}}을 선언하세요.
         *  - 전치 행렬은 3x2 크기가 됩니다.
         *  - transposed[j][i] = original[i][j] 관계를 이용해 전치 행렬을 만드세요.
         *  - 원본과 전치 행렬을 각각 출력하세요.
         *
         * 예상 출력:
         *  원본 행렬 (2x3):
         *  1 2 3
         *  4 5 6
         *  전치 행렬 (3x2):
         *  1 4
         *  2 5
         *  3 6
         *
         * 힌트:
         *  - 원본 행 수 = rows, 원본 열 수 = cols
         *  - 전치 행렬 크기: new int[cols][rows]
         *  - 변환 규칙: transposed[j][i] = original[i][j]
         */

        // TODO: 2x3 행렬 original = {{1,2,3},{4,5,6}}을 선언하세요.
        int[][] original = {{1,2,3},{4,5,6}};
        // TODO: 전치 행렬을 저장할 3x2 배열 transposed를 선언하세요.
        int[][] transposed = new int[3][2];
        // TODO: 중첩 반복문으로 전치 행렬을 채우세요. (transposed[j][i] = original[i][j])
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                transposed[j][i] = original[i][j];
            }
        }
        // TODO: 원본 행렬과 전치 행렬을 각각 제목과 함께 출력하세요.
        System.out.println("원본 행렬 (2x3):");
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                System.out.print(original[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("전치 행렬 (3x2):");
        for (int i=0; i<3; i++){
            for (int j=0; j<2; j++){
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n===== 문제 4: 대각선 원소 합계 (정방 행렬) =====");
        /*
         * 【문제 4】 대각선 원소 합계 (정방 행렬)
         *
         * 설명:
         *  - 4x4 정방 행렬을 아래와 같이 초기화하세요.
         *    { {1, 2, 3, 4},
         *      {5, 6, 7, 8},
         *      {9, 10, 11, 12},
         *      {13, 14, 15, 16} }
         *  - 주대각선 원소(i==j)의 합계를 구하세요.
         *  - 부대각선 원소(i+j==n-1)의 합계를 구하세요.
         *  - 행렬과 두 대각선의 합계를 출력하세요.
         *
         * 예상 출력:
         *  행렬:
         *  1  2  3  4
         *  5  6  7  8
         *  9  10 11 12
         *  13 14 15 16
         *  주대각선 합계 (1+6+11+16): 34
         *  부대각선 합계 (4+7+10+13): 34
         *
         * 힌트:
         *  - 주대각선: i == j 일 때 matrix[i][j]를 더함
         *  - 부대각선: i + j == n - 1 일 때 matrix[i][j]를 더함
         *  - n = matrix.length (행 수)
         */

        // TODO: 4x4 정방 행렬을 위의 값으로 선언하세요.
        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        // TODO: 행렬을 출력하세요. (숫자 폭 맞춤: %-3d 또는 %2d 활용)
        System.out.println("행렬:");
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.println();
        }
        // TODO: 단일 반복문으로 주대각선(i==j)의 합계를 구하세요.
        int sum =0;
        StringBuilder keep = new StringBuilder();
        for (int i=0; i<4; i++){
            sum += arr[i][i];
            keep.append(arr[i][i]);
            if (i != 3) {
                keep.append("+");
            }
        }
        // TODO: 단일 반복문으로 부대각선(i+j==n-1)의 합계를 구하세요.
        int sum2 =0;
        StringBuilder keep2 = new StringBuilder();
        for (int i=0; i<4; i++){
            sum2 += arr[i][3-i];
            keep2.append(arr[i][3-i]);
            if (i != 3) {
                keep2.append("+");
            }
        }

        // TODO: 주대각선과 부대각선 합계를 각각 출력하세요.
        System.out.println("주대각선 합계 (" + keep + "): " + sum);
        System.out.println("부대각선 합계 (" + keep2 + "): " + sum2);
    }

    /**
     * 행렬을 표 형태로 출력하는 헬퍼 메소드 (선택적으로 활용)
     * @param matrix 출력할 2차원 정수 배열
     */
    static void printMatrix(int[][] matrix) {
        // TODO: 중첩 반복문으로 행렬을 표 형태로 출력하세요.
    }
}
