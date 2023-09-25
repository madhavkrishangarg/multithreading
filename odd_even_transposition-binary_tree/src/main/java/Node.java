public class Node {
    private Long item, height;
    public Node left, right;

    public Long getItem() {
        return item;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public Long getHeight() {
        return height;
    }
    public Node(Long d) {
        item = d;
        height = (long)1;
    }

}
