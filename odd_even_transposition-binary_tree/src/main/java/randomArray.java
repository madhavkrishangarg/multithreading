import java.util.Random;

public class randomArray {
    private int n;

    public randomArray(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public long[] arrayList() {
        return generateRandomArray();
    }

    private long[] generateRandomArray() {
        long[] long_list = new long[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            long_list[i] = (random.nextLong(-1000000000, 1000000000));
        }
        return long_list;
    }
}
