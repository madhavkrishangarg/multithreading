import java.util.List;

public class elementFind extends Thread {
    private List<Long> arr;
    private long element;
    private long start;
    public elementFind(List<Long> arr, long element,long start) {
        this.arr = arr;
        this.element = element;
        this.start=start;
    }

    public Long getElement() {
        return element;
    }

    public void setElement(long element) {
        this.element = element;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(element)) {
                System.out.println("Found the element!");
                System.out.println("Time taken : "+(System.nanoTime()-start));
                return;
            }
        }
    }
}
