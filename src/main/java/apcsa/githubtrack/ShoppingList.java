package apcsa.githubtrack;

import java.util.Arrays;

// Implement the ShoppingList class here

public class ShoppingList implements MyList<ShoppingItem> {
    private int capacity;
    private int size;
    private ShoppingItem[] storage;

    public ShoppingList() {
        capacity = 8;
        size = 0;
        storage = new ShoppingItem[8];
    }

    public ShoppingList(ShoppingItem[] items) {
        capacity = 8;
        size = items.length;
        /* 
        while(size > capacity) {
            updateCapacity();
        }
        */
        storage = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public ShoppingItem[] getItems() {
        return storage;
    }

    public String getItemNames() {
        return Arrays.toString(storage);
    }

    public void goShopping() {
        for(int i = 0; i < size; i++) {
            storage[i].setSold(true);
        }
    }

    public void goShopping(ShoppingList toBuy) {
        //nested loops
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < toBuy.size; j++) {
                // for each element in this.storage, check it against each 
                // element in toBuy.storage, and check if they are equal. If any 
                // two elements are equal, set their sold attribute to true.
                if(storage[i].equals(toBuy.storage[j])){
                    storage[i].setSold(true);
                    toBuy.storage[j].setSold(true);
                }
            }
        }
    }

    public double totalPrice() {
        double total = 0;
        for(int i = 0; i < size; i++) {
            total += storage[i].getPrice();
        }
        return total;
    }

    public boolean isIdentical(ShoppingList other) {
        // First check if they have the same size
        if(this.size == other.size) {
            // if so, take the first element in this.storage, and see if it exists 
            // somewhere in other.storage. If it doesn't, b will still be false,
            // and the method will return false. If there is a match, however,
            // b will be set to true and the loop will move on to it's next
            // iteration. If the loop finds matches for every item, the method
            // will return true.
            for(int i = 0; i < size; i++) {
                boolean b = false;
                for(int j = 0; j < other.size; j++) {
                    if(storage[i].equals(other.storage[j])) {
                        b = true;
                        break;
                    }
                }
                if(!b) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean itemsAreSold() {
        for(int i = 0; i < size; i++) {
            if(!storage[i].isSold()) {
                return false;
            }
        }
        return true;
    }
    /*
    public void updateCapacity() {
        if(size > capacity) {
            capacity *= 2;
            ShoppingItem[] newArray = new ShoppingItem[capacity];
            System.arraycopy(storage, 0, newArray, 0, size);
            storage = newArray;
        } else if(size <= capacity / 2) {
            capacity /= 2;
            ShoppingItem[] newArray = new ShoppingItem[capacity];
            System.arraycopy(storage, 0, newArray, 0, size);
        }
    }
    */

    public void makeCapacity(int minCapacity) {
        // I have to admit, I didn't understand the logic in the readme, so I 
        // tried writing a custom method above that dealt with both trimming and 
        // extending the capacity as needed. Since it didn't work with the testing, 
        // I then tried to follow the instructions for writing the methods how it
        // was intended. I think this first if statement is checking if capacity
        // needs to be increased or decreased. 
        if(minCapacity <= size || minCapacity == capacity) {
            // If it needs to be decreased, it runs this code right here, which 
            // uses System.arraycopy to copy the necesarry data to itself, 
            // leaving behind the excess values in storage
            capacity = minCapacity;
            System.arraycopy(storage, 0, storage, 0, minCapacity);
        } else {
            // If it needs to be increased, capacity is changed to whichever 
            // value is larger out of 8 and minCapacity (I didn't quite get why 
            // it couldn't just be set to minCapacity). It then creates a new 
            // array with the increased size and copies the data from the old 
            // array to that array. It then sets the new array to storage.
            capacity = Math.max(8, minCapacity);
            ShoppingItem[] newArray = new ShoppingItem[capacity];
            System.arraycopy(storage, 0, newArray, 0, size);
            storage = newArray;
        }
    }

    public void trimExcess() {
        makeCapacity(size);
    }

    @Override
    public ShoppingItem getAt(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return new ShoppingItem("", 0);
        } else {
            return storage[index];
        }
        
    }

    @Override
    public int getSize() {
        return size;
    }

    // addToEnd simply calls makeCapacity to increase the size, and then sets the 
    // last element to the passed-in item.
    @Override
    public void addToEnd(ShoppingItem item) {
        size++;
        makeCapacity(size + 1);
        storage[size - 1] = item;
    }

    // insertAt first makes sure that the index is not out of the bounds of storage
    @Override
    public void insertAt(int index, ShoppingItem item) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index!");
        } else {
            // if in bounds, it increases the size of the array
            size++;
            makeCapacity(size + 1);
            // It then takes the chunk of the array after index (including index) 
            // and moves it over one to the right.
            System.arraycopy(storage, index, storage, index + 1, size - index);
            // and then it inserts the item in the empty space at index.
            storage[index] = item;
        }
    }

    // very similar to the previous one
    @Override
    public void removeAt(int index) {
        //first checks if index is in the bounds of the array
        if(index < 0 || index >= size) {
            System.out.println("Invalid index!");
        } else {
            // then decrements size
            size--;

            // then it takes the chunk to the right of index (excluding index)
            // and moves it over one to the left, effectively deleting index.
            System.arraycopy(storage, index + 1, storage, index, size - index);
            // then it trims the excess.
            trimExcess();
        }
        
    }

    
}
