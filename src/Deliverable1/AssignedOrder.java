/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

/**
 * association classes:
 */
// line 61 "../grocerymanagementsystem.ump"
public class AssignedOrder
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssignedOrder Attributes
  private int orderNumber;

  //AssignedOrder Associations
  private Employee employee;
  private GroceryOrder order;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetEmployee;
  private boolean canSetOrder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssignedOrder(int aOrderNumber, Employee aEmployee, GroceryOrder aOrder)
  {
    cachedHashCode = -1;
    canSetEmployee = true;
    canSetOrder = true;
    orderNumber = aOrderNumber;
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create assignedOrder due to employee. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create assignedOrder due to order. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderNumber(int aOrderNumber)
  {
    boolean wasSet = false;
    orderNumber = aOrderNumber;
    wasSet = true;
    return wasSet;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }
  /* Code from template association_GetOne */
  public Employee getEmployee()
  {
    return employee;
  }
  /* Code from template association_GetOne */
  public GroceryOrder getOrder()
  {
    return order;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    if (!canSetEmployee) { return false; }
    if (aEmployee == null)
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      existingEmployee.removeAssignedOrder(this);
    }
    if (!employee.addAssignedOrder(this))
    {
      employee = existingEmployee;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setOrder(GroceryOrder aOrder)
  {
    boolean wasSet = false;
    if (!canSetOrder) { return false; }
    if (aOrder == null)
    {
      return wasSet;
    }

    GroceryOrder existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeAssignedOrder(this);
    }
    if (!order.addAssignedOrder(this))
    {
      order = existingOrder;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    AssignedOrder compareTo = (AssignedOrder)obj;
  
    if (getEmployee() == null && compareTo.getEmployee() != null)
    {
      return false;
    }
    else if (getEmployee() != null && !getEmployee().equals(compareTo.getEmployee()))
    {
      return false;
    }

    if (getOrder() == null && compareTo.getOrder() != null)
    {
      return false;
    }
    else if (getOrder() != null && !getOrder().equals(compareTo.getOrder()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getEmployee() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getEmployee().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getOrder() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getOrder().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetEmployee = false;
    canSetOrder = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Employee placeholderEmployee = employee;
    this.employee = null;
    if(placeholderEmployee != null)
    {
      placeholderEmployee.removeAssignedOrder(this);
    }
    GroceryOrder placeholderOrder = order;
    this.order = null;
    if(placeholderOrder != null)
    {
      placeholderOrder.removeAssignedOrder(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null");
  }
}