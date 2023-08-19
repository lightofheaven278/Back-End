package problem1;

public class IntList implements Int{
    private int x;

    public IntList() {
    }

    public IntList(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "IntList{" +
                "x=" + x +
                '}';
    }
}
