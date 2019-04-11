package com.example.taxcalculation;

public class TaxLogic {
    private int income;

    public TaxLogic(int income) {
        this.income = income;
    }


    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getTaxSummary() {
        int tax = 0;
        if (income > 1 && income < 200000) {
            tax =income * 15 / 100;
            System.out.println(tax);
            return tax;
        } else if (income > 20000 && income < 350000) {
            tax = (200000 * 1 / 100) + (income - 200000) * 15 / 100;
            return tax;
        } else if (income > 350000) {
            tax = 200000 * 1 / 100 + 150000 * 15 / 100 + (income - 350000) * 25 / 100;
            return tax;
        }
        return tax;
    }
}
