public class D51Q6 {
    public static void main(String[] args) {
        Item[] li = { new Item("AA", "魚類"), new Item("BB", "肉類")};
        Item[] si = { new Item("A1", "さば"), new Item("A2", "さんま"),
                new Item("B1", "牛肉"), new Item("B2", "鶏肉"),
                new Item("B3", "豚肉")};
        ItemMaster im = new ItemMaster(li, si);
        String lcode = args[0].substring(0,2);
        String scode = args[0].substring(2,4);
        String details = args[0].substring(4); //（３３）イ

        String lname = im.getItemName(im.MAJOR, lcode); // 大分類コードから名前を取り出す
        String sname = im.getItemName(im.MINOR, scode); // 小分類コードから名前を取り出す
        System.out.println("商品コード：" + args[0]);
        System.out.println("大分類名：" + lname);
        System.out.println("小分類名：" + sname);
        System.out.println("詳細コード：" + details);
    }
}

class Item { // 項目を記録するためのクラス
    private String code;
    private String name;
    Item(String code, String name){ //コンストラクタ（インスタンス化したときに実行される）
        this.code = code;
        this.name = name;
    }
    public String getCode(){ return code; }
    public String getName(){ return name; }
}

class ItemMaster { // 商品マスタ。大分類または小分類コードに対応する名称を返す処理を行うクラス
    public int MAJOR = 0;
    public int MINOR = 1;
    private Item[][] items; // items は Item 型の2次元配列です。
    ItemMaster(Item[] major, Item[] minor){ //コンストラクタ（インスタンス化したときに実行される）
        items = new Item[2][]; // MAJOR=0 と MINOR=1 の2種類と決まっているため Item[2][] としている。（３４）エ
        items[MAJOR] = major;
        items[MINOR] = minor;
    }

    public String getItemName(int codeLevel, String code){
        for (int i = 0; i < items[codeLevel].length; i++){ // codeLevel（0ならMAJOR、1ならMINOR）が指定された配列から順に検索し（３５）エ
            if(code.equals(items[codeLevel][i].getCode())){ // 指定の code と一致したら（３６）ウ
                return items[codeLevel][i].getName(); // その名前を返す
            }
        }
        return "(不明)"; // 上のif分で商品コードが返されなかったらこちらをreturnする。（３７）ウ
    }
}
