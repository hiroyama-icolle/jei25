public class D51Q5 {
    public static void main(String[] args) { //   ↓57.0以上の部分
        double[] level = {0.0, 24.0, 57.0, Double.MAX_VALUE}; //使用量
        double[] unit = {0.0, 2.0, 3.0, 5.0}; //単位
        int[] rate = {0, 19, 17, 14}; //従量料金単価
        if(args.length != 1){
            System.out.println("引数の個数が不正");
            return;
        }
        double amount = Double.parseDouble(args[0]); // amountには使用量が入る
        if(amount < 0.0){
            System.out.println("0.0以上の使用量を入力");
            return;
        }

        int i, price = 1200; //ウ：説明２．①より基本使用料は1200円とあるので初期値として代入
        for(i = 1; amount >= level[i]; i++){
            price += (int)((level[i] - level[i - 1]) / unit[i])  * rate[i]; //上限57.0未満までの従量料金を段階ごとに加算
        }
        price += (int)Math.ceil((amount - level[i -1]) / unit[i]) * rate[i]; //残っている使用量(57.0以上)の料金を切り上げて加算している
        System.out.println("今月のガス料金 " + price + "円");
    }
}