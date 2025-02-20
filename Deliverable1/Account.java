/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 16 "../grocerymanagementsystem.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String username;
  private String password;
  private String name;
  private String number;

  //Account Associations
  private Customer customer;
  private WorkerRole workerRole;
  private GroceryManagementSystem groceryManagementSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aUsername, String aPassword, String aName, String aNumber, Customer aCustomer, GroceryManagementSystem aGroceryManagementSystem)
  {
    username = aUsername;
    password = aPassword;
    name = aName;
    number = aNumber;
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    customer = aCustomer;
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create account due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Account(String aUsername, String aPassword, String aName, String aNumber, String aAddressForCustomer, int aTotalLoyaltyPointsForCustomer, GroceryManagementSystem aGroceryManagementSystemForCustomer, GroceryManagementSystem aGroceryManagementSystem)
  {
    username = aUsername;
    password = aPassword;
    name = aName;
    number = aNumber;
    customer = new Customer(aAddressForCustomer, aTotalLoyaltyPointsForCustomer, aGroceryManagementSystemForCustomer, this);
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create account due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String getName()
  {
    return name;
  }

  public String getNumber()
  {
    return number;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_GetOne */
  public WorkerRole getWorkerRole()
  {
    return workerRole;
  }

  public boolean hasWorkerRole()
  {
    boolean has = workerRole != null;
    return has;
  }
  /* Code from template association_GetOne */
  public GroceryManagementSystem getGroceryManagementSystem()
  {
    return groceryManagementSystem;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setWorkerRole(WorkerRole aNewWorkerRole)
  {
    boolean wasSet = false;
    if (workerRole != null && !workerRole.equals(aNewWorkerRole) && equals(workerRole.getAccount()))
    {
      //Unable to setWorkerRole, as existing workerRole would become an orphan
      return wasSet;
    }

    workerRole = aNewWorkerRole;
    Account anOldAccount = aNewWorkerRole != null ? aNewWorkerRole.getAccount() : null;

    if (!this.equals(anOldAccount))
    {
      if (anOldAccount != null)
      {
        anOldAccount.workerRole = null;
      }
      if (workerRole != null)
      {
        workerRole.setAccount(this);
      }
    }
    wasSet = true;
    return wasSet;
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
      existingGroceryManagementSystem.removeAccount(this);
    }
    groceryManagementSystem.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
    WorkerRole existingWorkerRole = workerRole;
    workerRole = null;
    if (existingWorkerRole != null)
    {
      existingWorkerRole.delete();
    }
    GroceryManagementSystem placeholderGroceryManagementSystem = groceryManagementSystem;
    this.groceryManagementSystem = null;
    if(placeholderGroceryManagementSystem != null)
    {
      placeholderGroceryManagementSystem.removeAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "," +
            "name" + ":" + getName()+ "," +
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "workerRole = "+(getWorkerRole()!=null?Integer.toHexString(System.identityHashCode(getWorkerRole())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "groceryManagementSystem = "+(getGroceryManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getGroceryManagementSystem())):"null");
  }
}