/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 19 "../grocerymanagementsystem.ump"
public class Employee extends Role
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Delivery { SAMEDAY, NEXTDAY, TWO_DAYS, THREE_DAYS }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Associations
  private List<GroceryOrder> groceryOrders;
  private List<AssignedOrder> assignedOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(Account aAccount)
  {
    super(aAccount);
    groceryOrders = new ArrayList<GroceryOrder>();
    assignedOrders = new ArrayList<AssignedOrder>();
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  /* Code from template association_GetMany */
  public AssignedOrder getAssignedOrder(int index)
  {
    AssignedOrder aAssignedOrder = assignedOrders.get(index);
    return aAssignedOrder;
  }

  public List<AssignedOrder> getAssignedOrders()
  {
    List<AssignedOrder> newAssignedOrders = Collections.unmodifiableList(assignedOrders);
    return newAssignedOrders;
  }

  public int numberOfAssignedOrders()
  {
    int number = assignedOrders.size();
    return number;
  }

  public boolean hasAssignedOrders()
  {
    boolean has = assignedOrders.size() > 0;
    return has;
  }

  public int indexOfAssignedOrder(AssignedOrder aAssignedOrder)
  {
    int index = assignedOrders.indexOf(aAssignedOrder);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGroceryOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GroceryOrder addGroceryOrder(Account aAccount, Delivery aDeliveryDate, String aDate, Customer aCustomers)
  {
    return new GroceryOrder(aAccount, aDeliveryDate, aDate, this, aCustomers);
  }

  public boolean addGroceryOrder(GroceryOrder aGroceryOrder)
  {
    boolean wasAdded = false;
    if (groceryOrders.contains(aGroceryOrder)) { return false; }
    Employee existingEmployees = aGroceryOrder.getEmployees();
    boolean isNewEmployees = existingEmployees != null && !this.equals(existingEmployees);
    if (isNewEmployees)
    {
      aGroceryOrder.setEmployees(this);
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
    //Unable to remove aGroceryOrder, as it must always have a employees
    if (!this.equals(aGroceryOrder.getEmployees()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignedOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public AssignedOrder addAssignedOrder(int aOrderNumber, GroceryOrder aOrder)
  {
    return new AssignedOrder(aOrderNumber, this, aOrder);
  }

  public boolean addAssignedOrder(AssignedOrder aAssignedOrder)
  {
    boolean wasAdded = false;
    if (assignedOrders.contains(aAssignedOrder)) { return false; }
    Employee existingEmployee = aAssignedOrder.getEmployee();
    boolean isNewEmployee = existingEmployee != null && !this.equals(existingEmployee);
    if (isNewEmployee)
    {
      aAssignedOrder.setEmployee(this);
    }
    else
    {
      assignedOrders.add(aAssignedOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignedOrder(AssignedOrder aAssignedOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssignedOrder, as it must always have a employee
    if (!this.equals(aAssignedOrder.getEmployee()))
    {
      assignedOrders.remove(aAssignedOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssignedOrderAt(AssignedOrder aAssignedOrder, int index)
  {  
    boolean wasAdded = false;
    if(addAssignedOrder(aAssignedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedOrders()) { index = numberOfAssignedOrders() - 1; }
      assignedOrders.remove(aAssignedOrder);
      assignedOrders.add(index, aAssignedOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignedOrderAt(AssignedOrder aAssignedOrder, int index)
  {
    boolean wasAdded = false;
    if(assignedOrders.contains(aAssignedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedOrders()) { index = numberOfAssignedOrders() - 1; }
      assignedOrders.remove(aAssignedOrder);
      assignedOrders.add(index, aAssignedOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignedOrderAt(aAssignedOrder, index);
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
    for(int i=assignedOrders.size(); i > 0; i--)
    {
      AssignedOrder aAssignedOrder = assignedOrders.get(i - 1);
      aAssignedOrder.delete();
    }
    super.delete();
  }

}