/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 55 "../grocerymanagementsystem.ump"
public class GroceryShipment extends Role
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroceryShipment Associations
  private Manager managers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroceryShipment(Account aAccount, Manager aManagers)
  {
    super(aAccount);
    boolean didAddManagers = setManagers(aManagers);
    if (!didAddManagers)
    {
      throw new RuntimeException("Unable to create groceryShipment due to managers. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Manager getManagers()
  {
    return managers;
  }
  /* Code from template association_SetOneToMany */
  public boolean setManagers(Manager aManagers)
  {
    boolean wasSet = false;
    if (aManagers == null)
    {
      return wasSet;
    }

    Manager existingManagers = managers;
    managers = aManagers;
    if (existingManagers != null && !existingManagers.equals(aManagers))
    {
      existingManagers.removeGroceryShipment(this);
    }
    managers.addGroceryShipment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Manager placeholderManagers = managers;
    this.managers = null;
    if(placeholderManagers != null)
    {
      placeholderManagers.removeGroceryShipment(this);
    }
    super.delete();
  }

}