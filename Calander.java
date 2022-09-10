public class Calander {
    private int numberOf = 1;
    private double price;

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Calander(double price) {
        this.price = price;
    }

    public Calander(int numberOf, double price) {
        this.numberOf = numberOf;
        this.price = price;
    }

}
