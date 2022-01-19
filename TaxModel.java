package com.example.baoqiyu.tabulator;

/**
 * Created by baoqiyu on 2017-02-01.
 */
public class TaxModel {
    //attributes
    private double income;
    private double tax, average, marginal, cpp, ei;


    public static final double BRACKET_0 = 11475.0;
    public static final double BRACKET_1 = 33808.0;
    public static final double BRACKET_2 = 40895.0;
    public static final double BRACKET_3 = 63823.0;
    public static final double RATE_1 = 22.79 / 100.0;
    public static final double RATE_2 = 33.23 / 100.0;
    public static final double RATE_3 = 45.93 / 100.0;
    public static final double RATE_4 = 52.75 / 100.0;

    public static final double EI_RATE = 1.63/100.0;
    public static final double EI_MAX = 836.19;

    public static final double CPP_RATE = 4.95/100.0;
    public static final double CPP_MAX = 2564.10;
    public static final double CPP_EXEMPT = 3500.0;

    //Constructor
    public TaxModel()
    {
        //   this.income = 0;
    }

    //Method
    public void setIncome(double i)
    {
        income = i ;
    }

    public String getTax()
    {
        double remIncome = income;
        tax = 0;
        if(remIncome <= BRACKET_0)
        {
            tax = 0;
        }
        else {
            remIncome -= BRACKET_0;
            if (remIncome >= 0 && remIncome < BRACKET_1) {
                tax += remIncome * RATE_1;
                marginal = RATE_1;
            } else {
                tax += BRACKET_1 * RATE_1;
                remIncome -= BRACKET_1;
                if (remIncome >= 0 && remIncome < BRACKET_2) {
                    tax += remIncome * RATE_2;
                    marginal = RATE_2;
                } else {
                    tax += BRACKET_2 * RATE_2;
                    remIncome -= BRACKET_2;
                    if (remIncome >= 0 && remIncome < BRACKET_3) {
                        tax += remIncome * RATE_3;
                        marginal = RATE_3;
                    } else {
                        tax += BRACKET_3 * RATE_3;
                        remIncome -= BRACKET_3;
                        if (remIncome >= 0) {
                            tax += remIncome * RATE_4;
                            marginal = RATE_4;
                        }
                    }
                }
            }
        }

        String result = String.format("%,.2f", tax);
        return result;

    }


    public String getAverageRate()
    {
        average = (tax / income)*100;
        //average = Math.round(average);
        if(tax == 0 )
        {
            return "0%";
        }
        else {
            String result = String.format("%,.0f%%", average);
            return result;
        }
    }


    public String getMarginalRate()
    {
        marginal = marginal * 100;
        //55marginal = Math.round(marginal);
        String result = String.format("%,.0f%%", marginal);
        return result;
    }


    public String getCPP()
    {
        double remIncome = income;
        if(remIncome <= CPP_EXEMPT)
        {
            cpp = 0;
        }
        else
        {
            remIncome -=CPP_EXEMPT;
            cpp = remIncome * CPP_RATE;
            if(cpp >= CPP_MAX)
            {
                cpp = CPP_MAX;
            }
        }
        //cpp = Math.round(cpp);
        String result = String.format("%,.0f", cpp);
        return result;
    }


    public String getEI()
    {
        ei = income * EI_RATE;
        if(ei >= EI_MAX)
        {
            ei = EI_MAX;
        }
        ei = Math.round(ei);

        String EItext = String.format("%,.0f", ei);
        //DecimalFormat formatter = new DecimalFormat("#,###");
        //return formatter.format(ei);
        return EItext;
    }




    //main method for testing
    public static void main(String[] args) {
        //prepare input and output
        TaxModel model = new TaxModel();
        model.setIncome(52500);
        System.out.println(model.getTax());
        System.out.println(model.getAverageRate());
        System.out.println(model.getMarginalRate());
        System.out.println(model.getCPP());
        System.out.println(model.getEI());
    }
}
