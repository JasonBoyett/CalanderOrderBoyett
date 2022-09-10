import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args){

    }
    /*the first three methods are used to compute the price of orders*/

    public double computeOrder(double price){
        return (price + (price * 0.065));
    }//computes the price of an order by taking in the price and adding tax

    public double computeOrder(double price, int numberOfUnits){
        return ((price + (price * 0.065)) * numberOfUnits);
    }//computes the price of an order by taking in the price and adding tax and multiplying that by the number of units

    public double computeOrder(double price, int numberOfUnits, double discount){
        return (price + (price * 0.065 * numberOfUnits * discount));
    }

    /*the following methods are used to format and show a receipt */

    public String makeOrder(){
        ArrayList<Calander> order = new ArrayList<Calander>();
        int size = getQuantity();
        String receipt = "";
        double total = 0;

        if(size == 0){
            return "Have a nice day!";
        }
        if(size == 1){
            order.add(new Calander(getUnitPrice(1)));
            total = order.get(1).getPrice();
        }
        else if(size < 1){

            for(int i = 0; i < size; i++){
                try{
                    order.set(i, new Calander(getUnitPrice(i)));
                    total += order.get(i).getPrice();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "something went wrong", "error", JOptionPane.ERROR_MESSAGE);
                    makeOrder();
                }
            }
        }
        return receipt; 
    }

    public int getQuantity(){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(null, "How many different Calanders would you like to order?"));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "something went wrong", "error", JOptionPane.ERROR_MESSAGE);  
        }
        return getQuantity();
    }

    public double getUnitPrice(int unitNumber){
        try{
            return Double.parseDouble(JOptionPane.showInputDialog(null, "What is the price of the this Calander number" + unitNumber + "?"));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "something went wrong", "error", JOptionPane.ERROR_MESSAGE);
        }
        return getUnitPrice(unitNumber);
    }

    public int getNumberOfUnit(int unitNumber){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(null, "How many of calander number " + unitNumber + " would you like to order?"));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "something went wrong", "error", JOptionPane.ERROR_MESSAGE);
        }
        return getNumberOfUnit(unitNumber);
    }


}