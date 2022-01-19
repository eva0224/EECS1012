
/**
 * Created by Vmou on 2017/2/14 0014.
 */
public class Model
{
    public static final int DEFAULT_COUNT = 0;

    private double p;
    private int c;

    public Model(double p, int c) {this.p = p;this.c = c;}
    public Model(double p) {this.p = p; this.c = DEFAULT_COUNT;}

    public int getCount() {return this.c;}
    public boolean setCount (int c) {this.c = c > 0 ? c : this.c ; return this.c == c;}
    public double discountPrice(int percent) {return this.p * ((100.0 - percent) / 100.0);}
    public boolean equals(Model other) {return this.c == other.c;}

    @Override
    public String toString(){return String.format(this.c > 1 ? "This bag contains %d apples.": "This bag contains %d apple.", this.c);}

    // TODO: 2017/2/14 0014 Add API for this method.
    public double computeYum(){return 0.0;}

    public int countMutiples(int n)
    {
        int count = 0;
        for (int i = n;i <= this.c; i++)
        {
            count += i % 7 == 0 ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Model haha = new Model(10.0, 12);
        Model hehe = new Model(10.0, 15);
        System.out.println(haha.equals(hehe));
        System.out.println(haha.setCount(10));
        System.out.println(haha.getCount());
        System.out.println(haha.discountPrice(12));
        System.out.println(haha.toString());
        System.out.println(haha.countMutiples(5));

    }
}
