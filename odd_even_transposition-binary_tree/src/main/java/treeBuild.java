class treeBuild1 extends Thread {
    private long[] arr;

    public treeBuild1(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add1(arr[i]);
        }
    }
}

class treeBuild2 extends Thread {
    private long[] arr;

    public treeBuild2(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add2(arr[i]);
        }
    }
}

class treeBuild3 extends Thread {
    private long[] arr;

    public treeBuild3(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add3(arr[i]);
        }
    }
}

class treeBuild4 extends Thread {
    private long[] arr;

    public treeBuild4(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add4(arr[i]);
        }
    }
}

class treeBuild5 extends Thread {
    private long[] arr;

    public treeBuild5(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add5(arr[i]);
        }
    }
}

class treeBuild6 extends Thread {
    private long[] arr;

    public treeBuild6(long[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            Main.add6(arr[i]);
        }
    }
}


