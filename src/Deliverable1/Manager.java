/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 15 "../grocerymanagementsystem.ump"
public class Manager extends Role
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Associations
  private List<GroceryShipment> groceryShipments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(Account aAccount)
  {
    super(aAccount);
    groceryShipments = new ArrayList<GroceryShipment>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public GroceryShipment getGroceryShipment(int index)
  {
    GroceryShipment aGroceryShipment = groceryShipments.get(index);
    return aGroceryShipment;
  }

  public List<GroceryShipment> getGroceryShipments()
  {
    List<GroceryShipment> newGroceryShipments = Collections.unmodifiableList(groceryShipments);
    return newGroceryShipments;
  }

  public int numberOfGroceryShipments()
  {
    int number = groceryShipments.size();
    return number;
  }

  public boolean hasGroceryShipments()
  {
    boolean has = groceryShipments.size() > 0;
    return has;
  }

  public int indexOfGroceryShipment(GroceryShipment aGroceryShipment)
  {
    int index = groceryShipments.indexOf(aGroceryShipment);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGroceryShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GroceryShipment addGroceryShipment(Account aAccount)
  {
    return new GroceryShipment(aAccount, this);
  }

  public boolean addGroceryShipment(GroceryShipment aGroceryShipment)
  {
    boolean wasAdded = false;
    if (groceryShipments.contains(aGroceryShipment)) { return false; }
    Manager existingManagers = aGroceryShipment.getManagers();
    boolean isNewManagers = existingManagers != null && !this.equals(existingManagers);
    if (isNewManagers)
    {
      aGroceryShipment.setManagers(this);
    }
    else
    {
      groceryShipments.add(aGroceryShipment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGroceryShipment(GroceryShipment aGroceryShipment)
  {
    boolean wasRemoved = false;
    //Unable to remove aGroceryShipment, as it must always have a managers
    if (!this.equals(aGroceryShipment.getManagers()))
    {
      groceryShipments.remove(aGroceryShipment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGroceryShipmentAt(GroceryShipment aGroceryShipment, int index)
  {  
    boolean wasAdded = false;
    if(addGroceryShipment(aGroceryShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroceryShipments()) { index = numberOfGroceryShipments() - 1; }
      groceryShipments.remove(aGroceryShipment);
      groceryShipments.add(index, aGroceryShipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGroceryShipmentAt(GroceryShipment aGroceryShipment, int index)
  {
    boolean wasAdded = false;
    if(groceryShipments.contains(aGroceryShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroceryShipments()) { index = numberOfGroceryShipments() - 1; }
      groceryShipments.remove(aGroceryShipment);
      groceryShipments.add(index, aGroceryShipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGroceryShipmentAt(aGroceryShipment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=groceryShipments.size(); i > 0; i--)
    {
      GroceryShipment aGroceryShipment = groceryShipments.get(i - 1);
      aGroceryShipment.delete();
    }
    super.delete();
  }

}