/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 3 "../grocerymanagementsystem.ump"
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
  private Role roles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aUsername, String aPassword, String aName, String aNumber, Role aRoles)
  {
    username = aUsername;
    password = aPassword;
    name = aName;
    number = aNumber;
    if (aRoles == null || aRoles.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aRoles. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    roles = aRoles;
  }

  public Account(String aUsername, String aPassword, String aName, String aNumber)
  {
    username = aUsername;
    password = aPassword;
    name = aName;
    number = aNumber;
    roles = new Role(this);
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
  public Role getRoles()
  {
    return roles;
  }

  public void delete()
  {
    Role existingRoles = roles;
    roles = null;
    if (existingRoles != null)
    {
      existingRoles.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "," +
            "name" + ":" + getName()+ "," +
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "roles = "+(getRoles()!=null?Integer.toHexString(System.identityHashCode(getRoles())):"null");
  }
}