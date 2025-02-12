/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 23 "../grocerymanagementsystem.ump"
public class Customer extends Role
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Delivery { SAMEDAY, NEXTDAY, TWO_DAYS, THREE_DAYS }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String address;
  private int points;

  //Customer Associations
  private List<GroceryOrder> groceryOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(Account aAccount, String aAddress, int aPoints)
  {
    super(aAccount);
    address = aAddress;
    points = aPoints;
    groceryOrders = new ArrayList<GroceryOrder>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public int getPoints()
  {
    return points;
  }
  /* Code from template association_GetMany */
  public GroceryOrder getGroceryOrder(int index)
  {
    GroceryOrder aGroceryOrder = groceryOrders.get(index);
    return aGroceryOrder;
  }

  public List<GroceryOrder> getGroceryOrders()
  {
    List<GroceryOrder> newGroceryOrders = Collections.unmodifiableList(groceryOrders);
    return newGroceryOrders;
  }

  public int numberOfGroceryOrders()
  {
    int number = groceryOrders.size();
    return number;
  }

  public boolean hasGroceryOrders()
  {
    boolean has = groceryOrders.size() > 0;
    return has;
  }

  public int indexOfGroceryOrder(GroceryOrder aGroceryOrder)
  {
    int index = groceryOrders.indexOf(aGroceryOrder);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGroceryOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GroceryOrder addGroceryOrder(Account aAccount, Delivery aDeliveryDate, String aDate, Employee aEmployees)
  {
    return new GroceryOrder(aAccount, aDeliveryDate, aDate, aEmployees, this);
  }

  public boolean addGroceryOrder(GroceryOrder aGroceryOrder)
  {
    boolean wasAdded = false;
    if (groceryOrders.contains(aGroceryOrder)) { return false; }
    Customer existingCustomers = aGroceryOrder.getCustomers();
    boolean isNewCustomers = existingCustomers != null && !this.equals(existingCustomers);
    if (isNewCustomers)
    {
      aGroceryOrder.setCustomers(this);
    }
    else
    {
      groceryOrders.add(aGroceryOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGroceryOrder(GroceryOrder aGroceryOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aGroceryOrder, as it must always have a customers
    if (!this.equals(aGroceryOrder.getCustomers()))
    {
      groceryOrders.remove(aGroceryOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGroceryOrderAt(GroceryOrder aGroceryOrder, int index)
  {  
    boolean wasAdded = false;
    if(addGroceryOrder(aGroceryOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroceryOrders()) { index = numberOfGroceryOrders() - 1; }
      groceryOrders.remove(aGroceryOrder);
      groceryOrders.add(index, aGroceryOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGroceryOrderAt(GroceryOrder aGroceryOrder, int index)
  {
    boolean wasAdded = false;
    if(groceryOrders.contains(aGroceryOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroceryOrders()) { index = numberOfGroceryOrders() - 1; }
      groceryOrders.remove(aGroceryOrder);
      groceryOrders.add(index, aGroceryOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGroceryOrderAt(aGroceryOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=groceryOrders.size(); i > 0; i--)
    {
      GroceryOrder aGroceryOrder = groceryOrders.get(i - 1);
      aGroceryOrder.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "points" + ":" + getPoints()+ "]";
  }
}