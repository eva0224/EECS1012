/**
 * Created by Vmou on 2017/2/13 0013.
 */
public class Model extends java.lang.Object
{
    public static int DEFAULT_HEIGHT = 1;
    public static int DEFAULT_WIDTH = 1;

    private int height;
    private int width;

    // Constructor
    public Model(int w, int h){this.height = h; this.width = w;}
    public Model(int side){this.height = side; this.width=side;}
    public Model(){this.height = DEFAULT_HEIGHT;this.width=DEFAULT_WIDTH;}

    public int getHeight(){return this.height;}
    public int getWidth() {return this.width;}

    public void setHeight(String h) {this.height = Integer.parseInt(h);}
    public double computeDiagonal(){return Math.sqrt(this.height * this.height + this.width * this.width);}

    public boolean equals(Model other){return this.height == other.height && this.width == other.width;}

    @Override
    public String toString(){return String.format("I am a Model instance of size %dx%d.", this.width, this.height);}

    // TODO: 2017/2/13 0013 Add API for this method.
    public String computeYum() {return "";}

    public static void main(String[] args)
    {
        Model haha = new Model();
        Model hehe = new Model(4, 3);
        System.out.println(hehe.computeDiagonal());
        System.out.println(hehe.getHeight());
    }
}