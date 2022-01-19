package ca.roumani.mcalc;

import java.io.PrintStream;
import java.util.Scanner;

import hr.YumModel;

/**
 * Created by user on 1/25/17.
 */
public class MortgageModel
{
    //Three private attributes to hold states.
    private double principle;
    private int amortization;
    private double interest;

    //Constructor grab the principle, amortization, interest
    public MortgageModel(String p, String a, String i)
    {
        //turn the string to double
        this.principle = Double.parseDouble(p);
        this.amortization = Integer.parseInt(a);
        this.interest = Double.parseDouble(i);
    }

    //Method
    public String computePayment()
    {
        double Monthlyinterest = (this.interest / 100)/12;
        double months = this.amortization * 12;
        double amount = this.principle;

        double temp = (months*(months-1)*Monthlyinterest*Monthlyinterest)/2;
        temp = temp + 1 + months * Monthlyinterest;
        temp = 1 / temp;
        temp = 1 - temp;
        double rP = Monthlyinterest * amount;
        double result = rP / temp;
        String monthlyPayment = String.format("$%,.2f", result);
        return monthlyPayment;
    }




    //main method for testing
    public static void main(String[] args) {
        //prepare input and output
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        //create an instance
        MortgageModel model = new MortgageModel("700000", "25", "2.75");
        output.println("Monthly Payment is:  " + model.computePayment());

        YumModel model2 = new YumModel();
        model2.setInterest("2.75");
        model2.setPrinciple("700000");
        model2.setAmortization("25");
        output.println("Monthly Payment is:  " + model2.computePayment());
    }
}
