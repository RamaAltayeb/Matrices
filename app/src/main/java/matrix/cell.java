package matrix;

public class cell {
    private int i;
    private int j;
    private float val;
    public cell(int i, int j,float val)
    {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
