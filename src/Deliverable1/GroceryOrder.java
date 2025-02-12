/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 47 "../grocery
// managementsystem.ump"
public class GroceryOrder extends Order
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

  //GroceryOrder Associations
  private Employee employees;
  private Customer customers;
  private List<AssignedOrder> assignedOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroceryOrder(Delivery aDeliveryDate, String aDate, Employee aEmployees, Customer aCustomers)
  {
    super();
    deliveryDate = aDeliveryDate;
    date = aDate;
    boolean didAddEmployees = setEmployees(aEmployees);
    if (!didAddEmployees)
    {
      throw new RuntimeException("Unable to create groceryOrder due to employees. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCustomers = setCustomers(aCustomers);
    if (!didAddCustomers)
    {
      throw new RuntimeException("Unable to create groceryOrder due to customers. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    assignedOrders = new ArrayList<AssignedOrder>();
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

  public Delivery getDeliveryDate()
  {
    return deliveryDate;
  }

  public String getDate()
  {
    return date;
  }
  /* Code from template association_GetOne */
  public Employee getEmployees()
  {
    return employees;
  }
  /* Code from template association_GetOne */
  public Customer getCustomers()
  {
    return customers;
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
  /* Code from template association_SetOneToMany */
  public boolean setEmployees(Employee aEmployees)
  {
    boolean wasSet = false;
    if (aEmployees == null)
    {
      return wasSet;
    }

    Employee existingEmployees = employees;
    employees = aEmployees;
    if (existingEmployees != null && !existingEmployees.equals(aEmployees))
    {
      existingEmployees.removeGroceryOrder(this);
    }
    employees.addGroceryOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomers(Customer aCustomers)
  {
    boolean wasSet = false;
    if (aCustomers == null)
    {
      return wasSet;
    }

    Customer existingCustomers = customers;
    customers = aCustomers;
    if (existingCustomers != null && !existingCustomers.equals(aCustomers))
    {
      existingCustomers.removeGroceryOrder(this);
    }
    customers.addGroceryOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignedOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public AssignedOrder addAssignedOrder(int aOrderNumber, Employee aEmployee)
  {
    return new AssignedOrder(aOrderNumber, aEmployee, this);
  }

  public boolean addAssignedOrder(AssignedOrder aAssignedOrder)
  {
    boolean wasAdded = false;
    if (assignedOrders.contains(aAssignedOrder)) { return false; }
    GroceryOrder existingOrder = aAssignedOrder.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aAssignedOrder.setOrder(this);
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
    //Unable to remove aAssignedOrder, as it must always have a order
    if (!this.equals(aAssignedOrder.getOrder()))
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
    Employee placeholderEmployees = employees;
    this.employees = null;
    if(placeholderEmployees != null)
    {
      placeholderEmployees.removeGroceryOrder(this);
    }
    Customer placeholderCustomers = customers;
    this.customers = null;
    if(placeholderCustomers != null)
    {
      placeholderCustomers.removeGroceryOrder(this);
    }
    for(int i=assignedOrders.size(); i > 0; i--)
    {
      AssignedOrder aAssignedOrder = assignedOrders.get(i - 1);
      aAssignedOrder.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "date" + ":" + getDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryDate" + "=" + (getDeliveryDate() != null ? !getDeliveryDate().equals(this)  ? getDeliveryDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employees = "+(getEmployees()!=null?Integer.toHexString(System.identityHashCode(getEmployees())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "customers = "+(getCustomers()!=null?Integer.toHexString(System.identityHashCode(getCustomers())):"null");
  }
}