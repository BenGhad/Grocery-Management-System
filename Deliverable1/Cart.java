/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 67 "../grocerymanagementsystem.ump"
public class Cart extends Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cart Attributes
  private int totalPrice;
  private boolean isPaid;

  //Cart Associations
  private GroceryOrder groceryOrder;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cart(GroceryManagementSystem aGroceryManagementSystem, int aTotalPrice, boolean aIsPaid, Customer aCustomer)
  {
    super(aGroceryManagementSystem);
    totalPrice = aTotalPrice;
    isPaid = aIsPaid;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create cart due to customer. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalPrice(int aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPaid(boolean aIsPaid)
  {
    boolean wasSet = false;
    isPaid = aIsPaid;
    wasSet = true;
    return wasSet;
  }

  public int getTotalPrice()
  {
    return totalPrice;
  }

  /**
   * Locked can't modify
   */
  public boolean getIsPaid()
  {
    return isPaid;
  }
  /* Code from template association_GetOne */
  public GroceryOrder getGroceryOrder()
  {
    return groceryOrder;
  }

  public boolean hasGroceryOrder()
  {
    boolean has = groceryOrder != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setGroceryOrder(GroceryOrder aNewGroceryOrder)
  {
    boolean wasSet = false;
    if (groceryOrder != null && !groceryOrder.equals(aNewGroceryOrder) && equals(groceryOrder.getCart()))
    {
      //Unable to setGroceryOrder, as existing groceryOrder would become an orphan
      return wasSet;
    }

    groceryOrder = aNewGroceryOrder;
    Cart anOldCart = aNewGroceryOrder != null ? aNewGroceryOrder.getCart() : null;

    if (!this.equals(anOldCart))
    {
      if (anOldCart != null)
      {
        anOldCart.groceryOrder = null;
      }
      if (groceryOrder != null)
      {
        groceryOrder.setCart(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    //Must provide customer to cart
    if (aCustomer == null)
    {
      return wasSet;
    }

    if (customer != null && customer.numberOfCarts() <= Customer.minimumNumberOfCarts())
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      boolean didRemove = existingCustomer.removeCart(this);
      if (!didRemove)
      {
        customer = existingCustomer;
        return wasSet;
      }
    }
    customer.addCart(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    GroceryOrder existingGroceryOrder = groceryOrder;
    groceryOrder = null;
    if (existingGroceryOrder != null)
    {
      existingGroceryOrder.delete();
    }
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeCart(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "totalPrice" + ":" + getTotalPrice()+ "," +
            "isPaid" + ":" + getIsPaid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "groceryOrder = "+(getGroceryOrder()!=null?Integer.toHexString(System.identityHashCode(getGroceryOrder())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}