package apcsa.githubtrack;

// Implement your ShoppingItem class here
public class ShoppingItem implements Comparable<ShoppingItem>{
    private String name;
    private int price; //stored in pennies
    private boolean sold;

    public ShoppingItem(String name, int cents) {
        this.name = name;
        price = cents;
        sold = false;
    }

    public ShoppingItem(String name, double dollars) {
        this.name = name;
        price = (int) (dollars*100);
        sold = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price / 100.0;
    }

    public boolean isSold() {
        return sold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }


    public void buy() {
        sold = true;
    }

    public boolean equals(ShoppingItem other) {
        if(other.name.equals(name) && other.price == price){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(ShoppingItem item) {
        if(!item.name.equals(name)) {
            System.out.println("Error: Different items! Still returning compared prices.");
        }
        return this.price - item.price;
    }

    @Override
    public String toString() {
        return name;
    }
}