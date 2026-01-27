package apcsa.githubtrack;

/**
 * This file is complete – DO NOT MAKE ANY CHANGES TO THIS FILE! The MyList interface specifies the
 * basic operations of any list-like object. This interface contains a variation of the methods of
 * the standard java.util.List interface.
 */
public interface MyList <T> {
  /** Adds an element at the end of the list. */
  public void addToEnd(T o);

  /**
   * Inserts an element at the specified index. Prints to console, "No such element exists!" if
   * index is out of bounds.
   */
  public void insertAt(int index, T o);

  /**
   * Removes the element at the specified index. Prints to console, "No such element exists!" if
   * index is out of bounds.
   */
  public void removeAt(int index);

  /**
   * Returns the element at the specified index Prints to console, "No such element exists!" if
   * index is out of bounds.
   */
  public T getAt(int index);

  /**
   * Returns the size of the list.
   *
   * @return the number of elements in the list
   */
  public int getSize();
}
