// メインクラス
public class D52ensyu {
    public static void main(String[] args) {
        Animal tama = new Cat();   // Catのインスタンス
        Animal ao = new Horse();   // Horseのインスタンス
        Animal a = new Animal(); //

        tama.bark();  // にゃーん
        ao.bark();    // ひひーん
        a.bark(); // なにか動物の鳴き声
    }
}

// 親クラス
class Animal {
    public void bark() {
        System.out.println("なにか動物の鳴き声");
    }
}

// Catクラス
class Cat extends Animal {
    public void bark() {
        System.out.println("にゃーん");
    }
}

// Horseクラス
class Horse extends Animal {
    public void bark() {
        System.out.println("ひひーん");
    }
}

/*
第52回問2の3.(p80)の問題文からコードを作成してください
継承する際の書き方は以下の通りです
class Cat extends Animal {}
↑これはCatクラスはAnimalクラスを継承しているという意味です。

実行時に出力される鳴き声は適当に設定してください（例：にゃーん、ひひーん）
 */