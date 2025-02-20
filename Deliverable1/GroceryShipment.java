/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 81 "../grocerymanagementsystem.ump"
public class GroceryShipment extends Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroceryShipment Attributes
  private String dateOrdered;

  //GroceryShipment Associations
  private Manager manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroceryShipment(GroceryManagementSystem aGroceryManagementSystem, String aDateOrdered, Manager aManager)
  {
    super(aGroceryManagementSystem);
    dateOrdered = aDateOrdered;
    boolean didAddManager = setManager(aManager);
    if (!didAddManager)
    {
      throw new RuntimeException("Unable to create groceryShipment due to manager. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateOrdered(String aDateOrdered)
  {
    boolean wasSet = false;
    dateOrdered = aDateOrdered;
    wasSet = true;
    return wasSet;
  }

  public String getDateOrdered()
  {
    return dateOrdered;
  }
  /* Code from template association_GetOne */
  public Manager getManager()
  {
    return manager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    if (aManager == null)
    {
      return wasSet;
    }

    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeGroceryShipment(this);
    }
    manager.addGroceryShipment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Manager placeholderManager = manager;
    this.manager = null;
    if(placeholderManager != null)
    {
      placeholderManager.removeGroceryShipment(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "dateOrdered" + ":" + getDateOrdered()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null");
  }
}