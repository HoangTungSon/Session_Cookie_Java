package source.model;

public class MyCount {
    private int count;

    public MyCount() {
    }

    public MyCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
