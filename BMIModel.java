package ca.roumani.bmi;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by user on 1/18/17.
 */
public class BMIModel
{
    //attribute
    private double weight;
    private double height;

    //Constructor
    //Control grab the weight and height as a string
    public BMIModel(String w, String h)
    {
        //turn the string to double
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    //Method
    public String getBMI()
    {
       double index =  this.weight / (this.height * this.height);
        //turn it to a string to return to the view
        String result = String.format("%.1f",index);
        return result;
    }

    //Method2
    public String getWeightInPound()
    {
        double weightInPound = this.weight * 2.20462262185;
        String result = String.format("%.0f", weightInPound);
        return result;
    }

    //main method for testing
    public static void main(String[] args)
    {
        //prepare input and output
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        //create an instance
        BMIModel model = new BMIModel("100", "1.8");
//        String answer = model.getBMI();
//        output.println(answer);

        //2nd way to print
        output.println("Your weight in pound is " + model.getWeightInPound() + " and your BMI is " + model.getBMI());

        model = new BMIModel("46", "1.35");
        output.println("Your weight in pound is " + model.getWeightInPound() + " and your BMI is " + model.getBMI());
        model = new BMIModel("81", "1.2");
        output.println("Your weight in pound is " + model.getWeightInPound() + " and your BMI is " + model.getBMI());
        model = new BMIModel("65", "1.6 ");
        output.println("Your weight in pound is " + model.getWeightInPound() + " and your BMI is " + model.getBMI());
    }
}
