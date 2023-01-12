package chapter_06;

/**
 * (Financial application: print a tax table) Listing 3.5 gives a program to compute
 * tax. Write a method for computing tax using the following header:
 *
 *      public static double computeTax(int status, double taxableIncome)
 *
 * Use this method to write a program that prints a tax table for taxable income from
 * $50,000 to $60,000 with intervals of $50 for all the following statuses:
 *
 *      Taxable    Single    Married Joint    Married    Head of
 *      Income               or Qualifying    Separate   a House
 *                           Widow(er)
 *      --------------------------------------------------------
 *      50000      8688      6665             8688       7353
 *      50050      8700      6673             8700       7365
 *      ...
 *      59950      11175     8158             11175      9840
 *      60000      11188     8165             11188      9853
 *
 * Hint: round the tax into integers using Math.round (i.e., Math
 * .round(computeTax(status, taxableIncome)).
 */
public class PE_06_15_Financial_application_print_a_tax_table {
    public static void main(String[] args) {
        System.out.println("Taxable    Single    Married Joint    Married    Head of");
        System.out.println("Income               or Qualifying    Separate   a House");
        System.out.println("                     Widow(er)");
        System.out.println("--------------------------------------------------------");
        for (int i = 50000; i <= 60000; i += 50) {
            System.out.printf("%-11d%-10d%-17d%-11d%-7d%n",
                    i,
                    Math.round(computeTax(0, i)),
                    Math.round(computeTax(1, i)),
                    Math.round(computeTax(2, i)),
                    Math.round(computeTax(3, i)));
        }        
    }

    public static double computeTax(int status, double taxableIncome) {
        if (status == 0) { // Compute tax for single filers
            if (taxableIncome <= 8350)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 33950)
                return 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            else if (taxableIncome <= 82250)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) * 0.25;
            else if (taxableIncome <= 171550)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (taxableIncome - 82250) * 0.28;
            else if (taxableIncome <= 372950)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (taxableIncome - 171550) * 0.33;
            else
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (taxableIncome - 372950) * 0.35;
        }
        else if (status == 1) { // Compute tax for married file jointly
            if (taxableIncome <= 16700)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 67900)
                return 16700 * 0.10 + (taxableIncome - 16700) * 0.15;
            else if (taxableIncome <= 137050)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (taxableIncome - 67900) * 0.25;
            else if (taxableIncome <= 208850)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (taxableIncome - 137050) * 0.28;
            else if (taxableIncome <= 372950)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (taxableIncome - 208850) * 0.33;
            else
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (taxableIncome - 372950) * 0.35;
        }
        else if (status == 2) { // Compute tax for married separately
            if (taxableIncome <= 8350)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 33950)
                return 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            else if (taxableIncome <= 68525)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) * 0.25;
            else if (taxableIncome <= 104425)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (taxableIncome - 68525) * 0.28;
            else if (taxableIncome <= 186475)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (taxableIncome - 104425) * 0.33;
            else
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (taxableIncome - 186475) * 0.35;
        }
        else if (status == 3) { // Compute tax for head of household
            if (taxableIncome <= 11950)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 45500)
                return 11950 * 0.10 + (taxableIncome - 11950) * 0.15;
            else if (taxableIncome <= 117450)
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (taxableIncome - 45500) * 0.25;
            else if (taxableIncome <= 190200)
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (taxableIncome - 117450) * 0.28;
            else if (taxableIncome <= 372950)
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (taxableIncome - 190200) * 0.33;
            else
                return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (taxableIncome - 372950) * 0.35;
        }
        else {
            return -1;
        }
    }
}
