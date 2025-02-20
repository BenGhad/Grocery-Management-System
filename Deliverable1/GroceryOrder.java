/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 75 "../grocerymanagementsystem.ump"
public class GroceryOrder
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Delivery { SAMEDAY, NEXTDAY, TWO_DAYS, THREE_DAYS }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroceryOrder Attributes
  private Delivery deliveryDate;
  private String date;
  private int orderNumber;

  //GroceryOrder Associations
  private GroceryManagementSystem groceryManagementSystem;
  private Employee employee;
  private Cart cart;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroceryOrder(Delivery aDeliveryDate, String aDate, int aOrderNumber, GroceryManagementSystem aGroceryManagementSystem, Employee aEmployee, Cart aCart)
  {
    deliveryDate = aDeliveryDate;
    date = aDate;
    orderNumber = aOrderNumber;
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create groceryOrder due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create groceryOrder due to employee. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCart = setCart(aCart);
    if (!didAddCart)
    {
      throw new RuntimeException("Unable to create groceryOrder due to cart. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDeliveryDate(Delivery aDeliveryDate)
  {
    boolean wasSet = false;
    deliveryDate = aDeliveryDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderNumber(int aOrderNumber)
  {
    boolean wasSet = false;
    orderNumber = aOrderNumber;
    wasSet = true;
    return wasSet;
  }

  public Delivery getDeliveryDate()
  {
    return deliveryDate;
  }

  public String getDate()
  {
    return date;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }
  /* Code from template association_GetOne */
  public GroceryManagementSystem getGroceryManagementSystem()
  {
    return groceryManagementSystem;
  }
  /* Code from template association_GetOne */
  public Employee getEmployee()
  {
    return employee;
  }
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
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
      existingGroceryManagementSystem.removeGroceryOrder(this);
    }
    groceryManagementSystem.addGroceryOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    if (aEmployee == null)
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      existingEmployee.removeGroceryOrder(this);
    }
    employee.addGroceryOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setCart(Cart aNewCart)
  {
    boolean wasSet = false;
    if (aNewCart == null)
    {
      //Unable to setCart to null, as groceryOrder must always be associated to a cart
      return wasSet;
    }
    
    GroceryOrder existingGroceryOrder = aNewCart.getGroceryOrder();
    if (existingGroceryOrder != null && !equals(existingGroceryOrder))
    {
      //Unable to setCart, the current cart already has a groceryOrder, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Cart anOldCart = cart;
    cart = aNewCart;
    cart.setGroceryOrder(this);

    if (anOldCart != null)
    {
      anOldCart.setGroceryOrder(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    GroceryManagementSystem placeholderGroceryManagementSystem = groceryManagementSystem;
    this.groceryManagementSystem = null;
    if(placeholderGroceryManagementSystem != null)
    {
      placeholderGroceryManagementSystem.removeGroceryOrder(this);
    }
    Employee placeholderEmployee = employee;
    this.employee = null;
    if(placeholderEmployee != null)
    {
      placeholderEmployee.removeGroceryOrder(this);
    }
    Cart existingCart = cart;
    cart = null;
    if (existingCart != null)
    {
      existingCart.setGroceryOrder(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "date" + ":" + getDate()+ "," +
            "orderNumber" + ":" + getOrderNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryDate" + "=" + (getDeliveryDate() != null ? !getDeliveryDate().equals(this)  ? getDeliveryDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "groceryManagementSystem = "+(getGroceryManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getGroceryManagementSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null");
  }
}