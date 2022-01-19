package eecs.test;

/**
 * Created by user on 2/12/17.
 */
public class Model
{
    public static final int DEFAULT_WIDTH = 4;
    public static final int DEFAULT_HEIGHT = 2;
    private int height;
    private int width;

    public Model()
    {
        this.height = DEFAULT_HEIGHT;
        this.width = DEFAULT_WIDTH;
    }

    public Model(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public Model (int side)
    {
        this.width = side;
        this.height = side;
    }

    public int getHeight()
    {
        int result = this.height;
        return result;
    }

    public String getWidth(int n)
    {
        return String.format("%0"+n+"d",this.width);
    }

    public void setHeight(java.lang.String h)
    {
        this.height = Integer.parseInt(h);
    }
    public double computeDiagonal()
    {
        double index1 = this.width * this.width + this.height * this.height;
        double index = Math.sqrt(index1);
        return  index;

    }

    public java.lang.String toString()
    {
        String result = "I am a Model instance of size " +this.width +"x" + this.height;
        return  result;

    }

    public boolean equals(Model other)
    {
        return (this.width == other.width) && (this.height == other.height);
    }


    public java.lang.String computeYum()
    {
        return this.computeYum();
    }




    public static void main(String[] args)
    {
        Model m = new Model ( );
        System.out.println(m.width);
    }



}
