package eecs1.myapplication;

/**
 * Created by user on 2/14/17.
 */
public class model1
{

    public static final int DEFAULT_COUNT = 0;
    private double price;
    private  int count;

    public model1(double p, int c)
    {
        this.count = c;
        this.price = p;
    }

    public model1(double p)
    {
        this.price = p;
        this.count = DEFAULT_COUNT;
    }

//    Method
    public int getCount()
    {
       return this.count;
    }

    public boolean setCount(int c)
    {

        if(c > 0)
        {
            return true;
        } else{
            return false;
        }
    }

    public double discountPrice(int percent)
    {
        double index = percent;
        double result = index / 100;
        double result1= 1.0 - result;
        double result2= this.price * result1;
        return result2;
    }

    public boolean equals(model1 other)
    {
        return (this.count == other.count) && (this.price == other.price);

    }


    public String toString()
    {

        String result = "this bag contains" + " " +this.count  + " " +"apples";
        return result;
    }

    public int countMultiple(int n)
    {

        int result = 0;
        for (int i = n ; i < this.count;i+=1 )
        {
            double index = i % 7 ;

            if (index ==0)
            {
                result++;
            }


        }
        return result;
    }

    public static void main(String[] args)
    {
        model1 m = new model1(2,15);
        model1 n = new model1(3,4);
        System.out.println(m.getCount());
        System.out.println(m.setCount(4));
        System.out.println(m.discountPrice(10));
        System.out.println(m.equals(n));
        System.out.println(m.toString());
        System.out.println(m.countMultiple(5));
    }

}
