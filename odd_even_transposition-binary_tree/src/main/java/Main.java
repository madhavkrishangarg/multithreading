import java.util.Arrays;

public class Main {
    static Tree tree1 = new Tree();
    static Tree tree2 = new Tree();
    static Tree tree3 = new Tree();
    static Tree tree4 = new Tree();
    static Tree tree5 = new Tree();
    static Tree tree6 = new Tree();
    static Tree tree7 = new Tree();
    static Tree tree8 = new Tree();
    static Tree tree9 = new Tree();

    public static synchronized void add1(Long i) {  //with 10 4
        tree1.root = tree1.insertNode(tree1.root, i);
    }

    public static synchronized void add2(Long i) { //with 1000 4
        tree2.root = tree2.insertNode(tree2.root, i);
    }

    public static synchronized void add3(Long i) { //with 1000000 4
        synchronized (tree3) {
            tree3.root = tree3.insertNode(tree3.root, i);
        }
    }

    public static synchronized void add4(Long i) {  //with 10 2
        tree4.root = tree4.insertNode(tree4.root, i);
    }

    public static synchronized void add5(Long i) {  //with 1000 2
        tree5.root = tree5.insertNode(tree5.root, i);
    }

    public static synchronized void add6(Long i) {  //with 1000000 2
        synchronized (tree6) {
            tree6.root = tree6.insertNode(tree6.root, i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        randomArray randomArray = new randomArray(10);
        long[] arr1 = randomArray.arrayList();
        randomArray.setN(1000);
        long[] arr2 = randomArray.arrayList();
        randomArray.setN(1000000);
        long[] arr3 = randomArray.arrayList();

        long start1 = System.nanoTime();
        for (int i = 0; i < arr1.length; i++) {
            tree7.root = tree7.insertNode(tree7.root, arr1[i]);
        }
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        for (int i = 0; i < arr2.length; i++) {
            tree8.root = tree8.insertNode(tree8.root, arr2[i]);
        }
        long end2 = System.nanoTime();
        long start3 = System.nanoTime();
        for (int i = 0; i < arr3.length; i++) {
            tree9.root = tree9.insertNode(tree9.root, arr3[i]);
        }
        long end3 = System.nanoTime();
        System.out.println("Time taken to build tree of 10 (without multithreading) : " + (end1 - start1));
        System.out.println("Time taken to build tree of 1000 (without multithreading) : " + (end2 - start2));
        System.out.println("Time taken to build tree of 100000000 (without multithreading) : " + (end3 - start3));
        System.out.println("\n");

        start1 = System.nanoTime();
        treeBuild1 thread1 = new treeBuild1(Arrays.copyOfRange(arr1, 0, 3));
        treeBuild1 thread2 = new treeBuild1(Arrays.copyOfRange(arr1, 3, 6));
        treeBuild1 thread3 = new treeBuild1(Arrays.copyOfRange(arr1, 6, 8));
        treeBuild1 thread4 = new treeBuild1(Arrays.copyOfRange(arr1, 8, 10));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        treeBuild2 thread5 = new treeBuild2(Arrays.copyOfRange(arr2, 0, 250));
        treeBuild2 thread6 = new treeBuild2(Arrays.copyOfRange(arr2, 250, 500));
        treeBuild2 thread7 = new treeBuild2(Arrays.copyOfRange(arr2, 500, 750));
        treeBuild2 thread8 = new treeBuild2(Arrays.copyOfRange(arr2, 750, 1000));
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        end2 = System.nanoTime();

        start3 = System.nanoTime();
        treeBuild3 thread9 = new treeBuild3(Arrays.copyOfRange(arr3, 0, 250000));
        treeBuild3 thread10 = new treeBuild3(Arrays.copyOfRange(arr3, 250000, 500000));
        treeBuild3 thread11 = new treeBuild3(Arrays.copyOfRange(arr3, 500000, 750000));
        treeBuild3 thread12 = new treeBuild3(Arrays.copyOfRange(arr3, 750000, 1000000));
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread9.join();
        thread10.join();
        thread11.join();
        thread12.join();
        end3 = System.nanoTime();

        System.out.println("Time taken to build tree of 10 (4 threads) : " + (end1 - start1));
        System.out.println("Time taken to build tree of 1000 (4 threads) : " + (end2 - start2));
        System.out.println("Time taken to build tree of 100000000 (4 threads) : " + (end3 - start3));
        System.out.println("\n");

        start1 = System.nanoTime();
        treeBuild4 thread13 = new treeBuild4(Arrays.copyOfRange(arr1, 0, 5));
        treeBuild4 thread14 = new treeBuild4(Arrays.copyOfRange(arr1, 5, 10));
        thread13.start();
        thread14.start();
        thread13.join();
        thread14.join();
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        treeBuild5 thread15 = new treeBuild5(Arrays.copyOfRange(arr2, 0, 500));
        treeBuild5 thread16 = new treeBuild5(Arrays.copyOfRange(arr2, 500, 1000));
        thread15.start();
        thread16.start();
        thread15.join();
        thread16.join();
        end2 = System.nanoTime();

        start3 = System.nanoTime();
        treeBuild6 thread17 = new treeBuild6(Arrays.copyOfRange(arr3, 0, 500000));
        treeBuild6 thread18 = new treeBuild6(Arrays.copyOfRange(arr3, 500000, 1000000));
        thread17.start();
        thread18.start();
        thread17.join();
        thread18.join();
        end3 = System.nanoTime();

        System.out.println("Time taken to build tree of 10 (2 threads) : " + (end1 - start1));
        System.out.println("Time taken to build tree of 1000 (2 threads) : " + (end2 - start2));
        System.out.println("Time taken to build tree of 100000000 (2 threads) : " + (end3 - start3));
        System.out.println("\n");

        tree1.inOrder(tree1.root);
        tree2.inOrder(tree2.root);
        tree3.inOrder(tree3.root);
        tree4.inOrder(tree4.root);
        tree5.inOrder(tree5.root);
        tree6.inOrder(tree6.root);
        tree7.inOrder(tree7.root);
        tree8.inOrder(tree8.root);
        tree9.inOrder(tree9.root);
        System.out.println("Height of tree 1 : " + tree1.height(tree1.root));
        System.out.println("Height of tree 2 : " + tree2.height(tree2.root));
        System.out.println("Height of tree 3 : " + tree3.height(tree3.root));
        System.out.println("Height of tree 4 : " + tree4.height(tree4.root));
        System.out.println("Height of tree 5 : " + tree5.height(tree5.root));
        System.out.println("Height of tree 6 : " + tree6.height(tree6.root));
        System.out.println("Height of tree 7 : " + tree7.height(tree7.root));
        System.out.println("Height of tree 8 : " + tree8.height(tree8.root));
        System.out.println("Height of tree 9 : " + tree9.height(tree9.root));
        System.out.println("\n");
        start1 = System.nanoTime();
        for (int i = 0; i < tree7.inorder.size(); i++) {
            if (tree7.inorder.get(i).equals(tree7.inorder.get(5))) {
                System.out.println("Found : " + tree7.inorder.get(5));
                break;
            }
        }
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        for (int i = 0; i < tree8.inorder.size(); i++) {
            if (tree8.inorder.get(i).equals(tree8.inorder.get(500))) {
                System.out.println("Found : " + tree8.inorder.get(500));
                break;
            }
        }
        end2 = System.nanoTime();

        start3 = System.nanoTime();
        for (int i = 0; i < tree9.inorder.size(); i++) {
            if (tree9.inorder.get(i).equals(tree9.inorder.get(500000))) {
                System.out.println("Found : " + tree9.inorder.get(500000));
                break;
            }
        }
        end3 = System.nanoTime();

        System.out.println("Time taken to search an element arr(10) (without parallelization) : " + (end1 - start1));
        System.out.println("Time taken to search an element arr(1000) (without parallelization) : " + (end2 - start2));
        System.out.println("Time taken to search an element arr(1000000) (without parallelization) : " + (end3 - start3));
        System.out.println("\n");

        System.out.println("Searching via 4 threads : ");
        start1 = System.nanoTime();
        elementFind thread19 = new elementFind(tree1.inorder.subList(0, 3), tree1.inorder.get(tree1.inorder.size()/2), start1);
        elementFind thread20 = new elementFind(tree1.inorder.subList(3, 6), tree1.inorder.get(tree1.inorder.size()/2), start1);
        elementFind thread21 = new elementFind(tree1.inorder.subList(6, 8), tree1.inorder.get(tree1.inorder.size()/2), start1);
        elementFind thread22 = new elementFind(tree1.inorder.subList(8, 10), tree1.inorder.get(tree1.inorder.size()/2), start1);
        thread19.start();
        thread20.start();
        thread21.start();
        thread22.start();
        thread19.join();
        thread20.join();
        thread21.join();
        thread22.join();
        System.out.println("\n");

        start2 = System.nanoTime();
        elementFind thread23 = new elementFind(tree2.inorder.subList(0, 250), tree2.inorder.get(tree2.inorder.size()/2), start2);
        elementFind thread24 = new elementFind(tree2.inorder.subList(250, 500), tree2.inorder.get(tree2.inorder.size()/2), start2);
        elementFind thread25 = new elementFind(tree2.inorder.subList(500, 750), tree2.inorder.get(tree2.inorder.size()/2), start2);
        elementFind thread26 = new elementFind(tree2.inorder.subList(750, 1000), tree2.inorder.get(tree2.inorder.size()/2), start2);
        thread23.start();
        thread24.start();
        thread25.start();
        thread26.start();
        thread23.join();
        thread24.join();
        thread25.join();
        thread26.join();
        System.out.println("\n");

        start3 = System.nanoTime();
        elementFind thread27 = new elementFind(tree3.inorder.subList(0, 250000), tree3.inorder.get(tree3.inorder.size()/2), start3);
        elementFind thread28 = new elementFind(tree3.inorder.subList(250000, 500000), tree3.inorder.get(tree3.inorder.size()/2), start3);
        elementFind thread29 = new elementFind(tree3.inorder.subList(500000, 750000), tree3.inorder.get(tree3.inorder.size()/2), start3);
        elementFind thread30 = new elementFind(tree3.inorder.subList(750000, tree3.inorder.size()), tree3.inorder.get(tree3.inorder.size()/2), start3);
        thread27.start();
        thread28.start();
        thread29.start();
        thread30.start();
        thread27.join();
        thread28.join();
        thread29.join();
        thread30.join();
        System.out.println("\n");

        System.out.println("Searching via 2 threads : ");
        start1 = System.nanoTime();
        elementFind thread31 = new elementFind(tree4.inorder.subList(0, 5), tree4.inorder.get(tree4.inorder.size()/2), start1);
        elementFind thread32 = new elementFind(tree4.inorder.subList(5, 10), tree4.inorder.get(tree4.inorder.size()/2), start1);
        thread31.start();
        thread32.start();
        thread31.join();
        thread32.join();
        System.out.println("\n");

        start2 = System.nanoTime();
        elementFind thread33 = new elementFind(tree5.inorder.subList(0, 500), tree5.inorder.get(tree5.inorder.size()/2), start2);
        elementFind thread34 = new elementFind(tree5.inorder.subList(500, 1000), tree5.inorder.get(tree5.inorder.size()/2), start2);
        thread33.start();
        thread34.start();
        thread33.join();
        thread34.join();
        System.out.println("\n");

        start3 = System.nanoTime();
        elementFind thread35 = new elementFind(tree6.inorder.subList(0, 500000), tree6.inorder.get(tree6.inorder.size()/2), start3);
        elementFind thread36 = new elementFind(tree6.inorder.subList(500000, tree6.inorder.size()), tree6.inorder.get(tree6.inorder.size()/2), start3);
        thread35.start();
        thread36.start();
        thread35.join();
        thread36.join();
    }
}