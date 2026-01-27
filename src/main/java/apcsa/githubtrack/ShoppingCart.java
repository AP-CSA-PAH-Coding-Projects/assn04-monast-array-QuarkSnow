package apcsa.githubtrack;

// Implement your ShoppingCart class here
public class ShoppingCart {
    private String user;
    private ShoppingList list;
    private boolean returned;
    private static int numReturned;

    public ShoppingCart() {
        list = new ShoppingList();
        returned = false;
    }

    public ShoppingCart(String u, ShoppingList l) {
        user = u;
        list = l;
        returned = false;
    }

    public ShoppingList getList() {
        return list;
    }

    public boolean isReturned() {
        return returned;
    }

    public static int getTotalCartsReturned() {
        return numReturned;
    }

    public boolean isCompleted() {
        return list.itemsAreSold();
    }

    public boolean isIdentical(ShoppingCart other) {
        return list.isIdentical(other.list);
    }

    public void goShopping() {
        list.goShopping();
    }

    public void returnCart() {
        if(isCompleted() && !returned) {
            numReturned++;
            returned = true;
        }
    }

}