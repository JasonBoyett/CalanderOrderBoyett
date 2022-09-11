/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){//in main the program program prompts the user for key information and uses that information to determin which computeOrder method to use. that computeOrder method then has the relavent information passed to it.
        int numberOfUnits = 0;
        double price = 0;
        double subtotal = 0;
        //these variables hold information from the user and the value passed by computeOrder method. This information is then used to create a receipt
        DecimalFormat round = new DecimalFormat("###,###,###.##");//used to round off the results from computeOrder
        
        Scanner scanner = new Scanner(System.in);
        String isDiscounted;
        String discountCode;

        System.out.println("how many Calanders would you like to order?\n");
        numberOfUnits = scanner.nextInt();

        if(numberOfUnits == 0){//if the number of units is 0 the order total will be 0 the program will just skip to printing the receipt
            subtotal = 0;
        }
        if(numberOfUnits == 1){//if the number of units is one then the program will check if the user has a discount code and varify that code. Then it will pass the price to the Compute order method and the discount if applicable
            System.out.println("Do you have a discount code? Yes/No \n");
            isDiscounted = scanner.next();
            isDiscounted = isDiscounted.toUpperCase();
            if(isDiscounted.equals("YES")){
                System.out.println("please enter a price");
                price = scanner.nextDouble();
                System.out.println("please enter a discount code");
                discountCode = scanner.next();
                discountCode = discountCode.toUpperCase();
                
                if (discountCode.equals("DISCOUNT10")){
                    subtotal = computeOrder(price,numberOfUnits,0.1);
                }
                else if (discountCode.equals("DISCOUNT20")){
                    subtotal = computeOrder(price,numberOfUnits,0.2);
                }
                else{
                    System.out.println("Invalid discount code");
                    subtotal = computeOrder(price);
                }
            }
            else{
                System.out.println("please enter a price");
                price = scanner.nextDouble();
                subtotal = computeOrder(price);
            }
        }
        else{//if the number of units is greater than one then the method that takes an intiger number of units is used as opposed to the one that simply takes a price. This block performs the same checks and prompts the user in the same ways as the previous ones
            System.out.println("Do you have a discount code? Yes/No \n");
            isDiscounted = scanner.next();
            isDiscounted = isDiscounted.toUpperCase();
            if(isDiscounted.equals("YES")){ 
                System.out.println("please enter a price");
                price = scanner.nextDouble();
                System.out.println("please enter a discount code");
                discountCode = scanner.next();
                discountCode = discountCode.toUpperCase();
               
                if (discountCode.equals("DISCOUNT10")){
                    subtotal = computeOrder(price,numberOfUnits,0.1);
                }
                else if (discountCode.equals("DISCOUNT20")){
                    subtotal = computeOrder(price,numberOfUnits,0.2);
                }
                else{
                    System.out.println("Invalid discount code");
                    subtotal = computeOrder(price,numberOfUnits);
                }
            }
            else{
                System.out.println("please enter a price");
                price = scanner.nextDouble();
                subtotal = computeOrder(price,numberOfUnits);
            }
        }
        
        String receipt = "Calendar   Quantity    Price\n           ";
        receipt += String.valueOf(numberOfUnits) + "            ";
        receipt += "$" + String.valueOf(round.format(price)) + " \n\n";
        receipt += "Tax: $" + String.valueOf(round.format(price * 0.065)) + "\n";
        receipt += "Discount: $" + String.valueOf(round.format(((price + (price * 0.065))*numberOfUnits)-subtotal)) + "\n";
        receipt += "Total: $" + String.valueOf(round.format(subtotal));
        //this block of code takes the information from the previous if else block and uses it to create a receipt fot the user
        //this block uses the += opporator to append onto the receipt string. It is doen this way as opposed to doing everything on one line in order to make it more readable
        
        System.out.println(receipt);
        //the program displays the receipt created by the previous code block
    }//end of main
    /*the three methods are used to compute the price of orders depending on the information available*/

    public static double computeOrder(double price){
        return (price + (price * 0.065));
    }//computes the price of an order by taking in the price and adding tax

    public static double computeOrder(double price, int numberOfUnits){
        return ((price + (price * 0.065)) * numberOfUnits);
    }//computes the price of an order by taking in the price and adding tax and multiplying that by the number of units

    public static double computeOrder(double price, int numberOfUnits, double discount){
        return (((price + (price * 0.065)) - ((price + (price * 0.065)) * discount)) * numberOfUnits);
    }//computes the price of an order by taking in the price and adding tax and multiplying that by the number of units then subtracting the previous number times the discount
}
