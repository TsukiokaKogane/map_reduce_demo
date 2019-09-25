import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Pair < K, V > {

    private K key;
    private V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


class Main {


    public static void main(String[] args) {

        String inputFile = "test.txt";
        Scanner input = null;
        try {
            input = new Scanner(new FileReader(inputFile));
            ArrayList < String > sv = new ArrayList < > ();

            while (input.hasNext()) {
                sv.add(input.next());
            }

            new MyStream < > (sv)
                .filter((i) - > i.startsWith("a"))
                .map((i) - > new Pair < > (i, 1))
                .groupByKey(Pair::getKey, Pair::getValue)
                .forEach((d) - > {
                    Integer count = d.getValue().reduce(0, (x, y) - > x + y);
                    if (count > 5) {
                        System.out.println("'" + d.getKey() + "' occurred " + count + " times");
                    }
                });


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("BaoLe");
        }
    }
}
