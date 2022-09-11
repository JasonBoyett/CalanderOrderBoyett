/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main{

    public static void main(String[] args){
        int numberOfUnits = 0;
        double price = 0;
        double subtotal = 0;
        DecimalFormat round = new DecimalFormat("###,###,###.##");
        
        Scanner scanner = new Scanner(System.in);
        String isDiscounted;
        String discountCode;

        System.out.println("how many Calanders would you like to order?\n");
        numberOfUnits = scanner.nextInt();

        if(numberOfUnits == 0){
            subtotal = 0;
        }
        if(numberOfUnits == 1){
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
        else{
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
    
        String reciept = "Calendar   Quantity    Price\n           ";
        reciept += String.valueOf(numberOfUnits) + "            ";
        reciept += "$" + String.valueOf(round.format(price)) + " \n\n";
        reciept += "Tax: $" + String.valueOf(round.format(price * 0.065)) + "\n";
        reciept += "Discount: $" + String.valueOf(round.format(((price + (price * 0.065))*numberOfUnits)-subtotal)) + "\n";
        reciept += "Total: $" + String.valueOf(round.format(subtotal));
        System.out.println(reciept);
        

    }
    /*the first three methods are used to compute the price of orders*/

    public static double computeOrder(double price){
        return (price + (price * 0.065));
    }//computes the price of an order by taking in the price and adding tax

    public static double computeOrder(double price, int numberOfUnits){
        return ((price + (price * 0.065)) * numberOfUnits);
    }//computes the price of an order by taking in the price and adding tax and multiplying that by the number of units

    public static double computeOrder(double price, int numberOfUnits, double discount){
        return (((price + (price * 0.065)) - ((price + (price * 0.065)) * discount)) * numberOfUnits);
    }
}
