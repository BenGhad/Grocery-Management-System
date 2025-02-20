/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 26 "../grocerymanagementsystem.ump"
public class WorkerRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WorkerRole Associations
  private GroceryManagementSystem groceryManagementSystem;
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WorkerRole(GroceryManagementSystem aGroceryManagementSystem, Account aAccount)
  {
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create workerRole due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create workerRole due to account. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public GroceryManagementSystem getGroceryManagementSystem()
  {
    return groceryManagementSystem;
  }
  /* Code from template association_GetOne_clear */
  protected void clear_groceryManagementSystem()
  {
    groceryManagementSystem = null;
  }
  /* Code from template association_GetOne */
  public Account getAccount()
  {
    return account;
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
      existingGroceryManagementSystem.removeWorkerRole(this);
    }
    groceryManagementSystem.addWorkerRole(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setAccount(Account aNewAccount)
  {
    boolean wasSet = false;
    if (aNewAccount == null)
    {
      //Unable to setAccount to null, as workerRole must always be associated to a account
      return wasSet;
    }
    
    WorkerRole existingWorkerRole = aNewAccount.getWorkerRole();
    if (existingWorkerRole != null && !equals(existingWorkerRole))
    {
      //Unable to setAccount, the current account already has a workerRole, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Account anOldAccount = account;
    account = aNewAccount;
    account.setWorkerRole(this);

    if (anOldAccount != null)
    {
      anOldAccount.setWorkerRole(null);
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
      placeholderGroceryManagementSystem.removeWorkerRole(this);
    }
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.setWorkerRole(null);
    }
  }

}