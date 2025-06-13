public class D50Q6 {
    public static void main(String[] args){
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        if(max < min) { // (33)ア maxがminより小さい場合↓交換する
            int tmp = max;
            max = min;
            min = tmp;
        }

        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.initializePrimeNumbers(max); //(34)ア 素数の最大値
        int[] part = primeNumbers.getPart(min, max);

        for(int prime : part){
            System.out.printf("%d, ", prime);
        }
    }
}

class PrimeNumbers {
    boolean[] isPrimeNumbers;

    void initializePrimeNumbers(int max) {
        isPrimeNumbers = new boolean[max + 1]; //①や、32行目でmの最大値がmaxになるため+1としている
        for (int i = 2; i <= max; i++) {
            isPrimeNumbers[i] = true; // (35)ア 4.②trueで初期化するとあるため
        }

        for (int p = 2; p <= Math.sqrt(max); p++) { // ③p=2とし、⑥より平方根を超えるまで繰り返す
            if (isPrimeNumbers[p]) {
                for (int m = p * 2; m <= max; m += p) { //(36) エ ④より
                    isPrimeNumbers[m] = false; //④より
                }
            }
        }
    }

    int[] getPart(int min, int max) { // 素数判定配列から素数を抜き出し、結果を配列で返す
        int count = 0;
        for (int n = min; n <= max; n++) { //範囲内にある素数の数をカウント、47行目でつかう
            if (isPrimeNumbers[n]) {
                count++;
            }
        }

        int[] part = new int[count]; // (37)エ 配列partの作成。要素数は41行目よりわかる
        int index = 0;
        for (int n = min; n <= max; n++) {
            if (isPrimeNumbers[n]) {
                part[index++] = n;
            }
        }
        return part;
    }
}