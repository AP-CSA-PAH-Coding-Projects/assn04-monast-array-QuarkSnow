# Reflection

This program creates and experiments with the ShoppingList class, which has various helpfull methods for modifying and doing other things with lists of ShoppingItems. It also helped me understand a little more about ArrayLists by creating my own class MyList, and how ArrayLists are just arrays that get replaced with larger or smaller arrays throughout the program to give the functionality of a dynamic array.
#
I explained logic to the important methods in `ShoppingList.java`, but left out comments for what I though were trivial methods.
#
One of the chalenges I faced was figuring out the logic for the `makeCapacity` and `trimExcess` methods. Also, the `removeAt` and `insertAt` methods were tricky, but I was eventually able to get them working.

Also, some of the files I got had errors. The `pom.xml` file didn't have the dependencies for the junit testing. The `ShoppingProjectTest.java` file wasn't in the `apcsa/githubtrack` folders so it couldn't recognize the package. 

Also, I was having some trouble implementing the `MyList.java` interface for my `ShoppingList` class, because while my implementations of the methods were returning and dealing with `ShoppingItem`s, in the interface it was just set to `Object`, so I decided to make it generic.
#
Overall, this was a fun project, and I learned a lot! It must take some time to do this, so thanks for spending your time putting these together!
