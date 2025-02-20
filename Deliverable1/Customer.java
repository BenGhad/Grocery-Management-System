/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 40 "../grocerymanagementsystem.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String address;
  private int totalLoyaltyPoints;

  //Customer Associations
  private List<Cart> carts;
  private GroceryManagementSystem groceryManagementSystem;
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aAddress, int aTotalLoyaltyPoints, GroceryManagementSystem aGroceryManagementSystem, Account aAccount)
  {
    address = aAddress;
    totalLoyaltyPoints = aTotalLoyaltyPoints;
    carts = new ArrayList<Cart>();
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create customer due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    account = aAccount;
  }

  public Customer(String aAddress, int aTotalLoyaltyPoints, GroceryManagementSystem aGroceryManagementSystem, String aUsernameForAccount, String aPasswordForAccount, String aNameForAccount, String aNumberForAccount, GroceryManagementSystem aGroceryManagementSystemForAccount)
  {
    address = aAddress;
    totalLoyaltyPoints = aTotalLoyaltyPoints;
    carts = new ArrayList<Cart>();
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create customer due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    account = new Account(aUsernameForAccount, aPasswordForAccount, aNameForAccount, aNumberForAccount, this, aGroceryManagementSystemForAccount);
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

  public boolean setTotalLoyaltyPoints(int aTotalLoyaltyPoints)
  {
    boolean wasSet = false;
    totalLoyaltyPoints = aTotalLoyaltyPoints;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public int getTotalLoyaltyPoints()
  {
    return totalLoyaltyPoints;
  }
  /* Code from template association_GetMany */
  public Cart getCart(int index)
  {
    Cart aCart = carts.get(index);
    return aCart;
  }

  public List<Cart> getCarts()
  {
    List<Cart> newCarts = Collections.unmodifiableList(carts);
    return newCarts;
  }

  public int numberOfCarts()
  {
    int number = carts.size();
    return number;
  }

  public boolean hasCarts()
  {
    boolean has = carts.size() > 0;
    return has;
  }

  public int indexOfCart(Cart aCart)
  {
    int index = carts.indexOf(aCart);
    return index;
  }
  /* Code from template association_GetOne */
  public GroceryManagementSystem getGroceryManagementSystem()
  {
    return groceryManagementSystem;
  }
  /* Code from template association_GetOne */
  public Account getAccount()
  {
    return account;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCartsValid()
  {
    boolean isValid = numberOfCarts() >= minimumNumberOfCarts();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCarts()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Cart addCart(GroceryManagementSystem aGroceryManagementSystem, int aTotalPrice, boolean aIsPaid)
  {
    Cart aNewCart = new Cart(aGroceryManagementSystem, aTotalPrice, aIsPaid, this);
    return aNewCart;
  }

  public boolean addCart(Cart aCart)
  {
    boolean wasAdded = false;
    if (carts.contains(aCart)) { return false; }
    Customer existingCustomer = aCart.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);

    if (isNewCustomer && existingCustomer.numberOfCarts() <= minimumNumberOfCarts())
    {
      return wasAdded;
    }
    if (isNewCustomer)
    {
      aCart.setCustomer(this);
    }
    else
    {
      carts.add(aCart);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCart(Cart aCart)
  {
    boolean wasRemoved = false;
    //Unable to remove aCart, as it must always have a customer
    if (this.equals(aCart.getCustomer()))
    {
      return wasRemoved;
    }

    //customer already at minimum (1)
    if (numberOfCarts() <= minimumNumberOfCarts())
    {
      return wasRemoved;
    }

    carts.remove(aCart);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCartAt(Cart aCart, int index)
  {  
    boolean wasAdded = false;
    if(addCart(aCart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCarts()) { index = numberOfCarts() - 1; }
      carts.remove(aCart);
      carts.add(index, aCart);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCartAt(Cart aCart, int index)
  {
    boolean wasAdded = false;
    if(carts.contains(aCart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCarts()) { index = numberOfCarts() - 1; }
      carts.remove(aCart);
      carts.add(index, aCart);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCartAt(aCart, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGroceryManagementSystem(GroceryManagementSystem aGroceryManagementSystem)
  {
    boolean wasSet = false;
    if (aGroceryManagementSystem == null)
    {
      return wasSet;
    }

    GroceryManagementSystem existingGroceryManagementSystem = groceryManagementSystem;
    groceryManagementSystem = aGroceryManagementSystem;
    if (existingGroceryManagementSystem != null && !existingGroceryManagementSystem.equals(aGroceryManagementSystem))
    {
      existingGroceryManagementSystem.removeCustomer(this);
    }
    groceryManagementSystem.addCustomer(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=carts.size(); i > 0; i--)
    {
      Cart aCart = carts.get(i - 1);
      aCart.delete();
    }
    GroceryManagementSystem placeholderGroceryManagementSystem = groceryManagementSystem;
    this.groceryManagementSystem = null;
    if(placeholderGroceryManagementSystem != null)
    {
      placeholderGroceryManagementSystem.removeCustomer(this);
    }
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "totalLoyaltyPoints" + ":" + getTotalLoyaltyPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "groceryManagementSystem = "+(getGroceryManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getGroceryManagementSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}