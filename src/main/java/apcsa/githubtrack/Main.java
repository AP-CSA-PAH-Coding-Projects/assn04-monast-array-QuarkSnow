package apcsa.githubtrack;

// Implement your Main class (with the main method) here
public class Main {
    public static void main(String[] args) {
        
        ShoppingList bE = new ShoppingList();
        bE.addToEnd(new ShoppingItem("eggs", 3.50));
        bE.addToEnd(new ShoppingItem("zucchini", 2.75));
        bE.addToEnd(new ShoppingItem("frozen berries", 5.15));
        bE.addToEnd(new ShoppingItem("smoked salmon", 9.99));
        bE.insertAt(2, new ShoppingItem("tissues", 1.00));
        bE.removeAt(2);
        ShoppingList dR = new ShoppingList();
        dR.addToEnd(new ShoppingItem("eggs", 3.50));
        dR.addToEnd(new ShoppingItem("tissues", 1.00));
        dR.addToEnd(new ShoppingItem("frozen berries", 5.15));
        dR.addToEnd(new ShoppingItem("smoked salmon", 9.99));
        dR.insertAt(2, new ShoppingItem("zucchini", 2.75));

        ShoppingCart breakfastEssentials = new ShoppingCart();
        ShoppingCart dormRun = new ShoppingCart();

        System.out.println(breakfastEssentials.isIdentical(dormRun));
        
        dR.removeAt(1);
        dR.removeAt(4);
        dR.getAt(0).buy();
        //dormRun.getAt(4).buy(); can't get smoked salmon because it was removed from the list
        System.out.println("DormRun is completed: " + dormRun.isCompleted());

        breakfastEssentials.goShopping();

        System.out.println(breakfastEssentials.getList().getAt(0)
                            .compareTo(dormRun.getList().getAt(2)));

        String s1 = dormRun.getList().toString();
        String s2 = dormRun.isCompleted() ? "" : "not ";
        System.out.printf("DormRun's cart includes the following items: %s for a total of $%.2f. It is %scompleted!\n", s1, dormRun.getList().totalPrice(), s2);
        
    }
}
