/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 11 "../grocerymanagementsystem.ump"
public class Role
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Role Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Role(Account aAccount)
  {
    if (aAccount == null || aAccount.getRoles() != null)
    {
      throw new RuntimeException("Unable to create Role due to aAccount. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    account = aAccount;
  }

  public Role(String aUsernameForAccount, String aPasswordForAccount, String aNameForAccount, String aNumberForAccount)
  {
    account = new Account(aUsernameForAccount, aPasswordForAccount, aNameForAccount, aNumberForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Account getAccount()
  {
    return account;
  }

  public void delete()
  {
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }

}