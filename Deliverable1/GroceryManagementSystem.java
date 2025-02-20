/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 3 "../grocerymanagementsystem.ump"
public class GroceryManagementSystem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Delivery { SAMEDAY, NEXTDAY, TWO_DAYS, THREE_DAYS }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroceryManagementSystem Associations
  private List<Account> accounts;
  private List<WorkerRole> workerRoles;
  private List<Customer> customers;
  private List<Item> items;
  private List<Order> orders;
  private List<OrderedItem> orderedItems;
  private List<GroceryOrder> groceryOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroceryManagementSystem()
  {
    accounts = new ArrayList<Account>();
    workerRoles = new ArrayList<WorkerRole>();
    customers = new ArrayList<Customer>();
    items = new ArrayList<Item>();
    orders = new ArrayList<Order>();
    orderedItems = new ArrayList<OrderedItem>();
    groceryOrders = new ArrayList<GroceryOrder>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }
  /* Code from template association_GetMany */
  public WorkerRole getWorkerRole(int index)
  {
    WorkerRole aWorkerRole = workerRoles.get(index);
    return aWorkerRole;
  }

  public List<WorkerRole> getWorkerRoles()
  {
    List<WorkerRole> newWorkerRoles = Collections.unmodifiableList(workerRoles);
    return newWorkerRoles;
  }

  public int numberOfWorkerRoles()
  {
    int number = workerRoles.size();
    return number;
  }

  public boolean hasWorkerRoles()
  {
    boolean has = workerRoles.size() > 0;
    return has;
  }

  public int indexOfWorkerRole(WorkerRole aWorkerRole)
  {
    int index = workerRoles.indexOf(aWorkerRole);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_workerRoles()
  {
    workerRoles.clear();
  }
  /* Code from template association_GetMany */
  public Customer getCustomer(int index)
  {
    Customer aCustomer = customers.get(index);
    return aCustomer;
  }

  public List<Customer> getCustomers()
  {
    List<Customer> newCustomers = Collections.unmodifiableList(customers);
    return newCustomers;
  }

  public int numberOfCustomers()
  {
    int number = customers.size();
    return number;
  }

  public boolean hasCustomers()
  {
    boolean has = customers.size() > 0;
    return has;
  }

  public int indexOfCustomer(Customer aCustomer)
  {
    int index = customers.indexOf(aCustomer);
    return index;
  }
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_orders()
  {
    orders.clear();
  }
  /* Code from template association_GetMany */
  public OrderedItem getOrderedItem(int index)
  {
    OrderedItem aOrderedItem = orderedItems.get(index);
    return aOrderedItem;
  }

  public List<OrderedItem> getOrderedItems()
  {
    List<OrderedItem> newOrderedItems = Collections.unmodifiableList(orderedItems);
    return newOrderedItems;
  }

  public int numberOfOrderedItems()
  {
    int number = orderedItems.size();
    return number;
  }

  public boolean hasOrderedItems()
  {
    boolean has = orderedItems.size() > 0;
    return has;
  }

  public int indexOfOrderedItem(OrderedItem aOrderedItem)
  {
    int index = orderedItems.indexOf(aOrderedItem);
    return index;
  }
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Account addAccount(String aUsername, String aPassword, String aName, String aNumber, Customer aCustomer)
  {
    return new Account(aUsername, aPassword, aName, aNumber, aCustomer, this);
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aAccount.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aAccount.setGroceryManagementSystem(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a groceryManagementSystem
    if (!this.equals(aAccount.getGroceryManagementSystem()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWorkerRoles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public WorkerRole addWorkerRole(Account aAccount)
  {
    return new WorkerRole(this, aAccount);
  }

  public boolean addWorkerRole(WorkerRole aWorkerRole)
  {
    boolean wasAdded = false;
    if (workerRoles.contains(aWorkerRole)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aWorkerRole.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aWorkerRole.setGroceryManagementSystem(this);
    }
    else
    {
      workerRoles.add(aWorkerRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWorkerRole(WorkerRole aWorkerRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aWorkerRole, as it must always have a groceryManagementSystem
    if (!this.equals(aWorkerRole.getGroceryManagementSystem()))
    {
      workerRoles.remove(aWorkerRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWorkerRoleAt(WorkerRole aWorkerRole, int index)
  {  
    boolean wasAdded = false;
    if(addWorkerRole(aWorkerRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkerRoles()) { index = numberOfWorkerRoles() - 1; }
      workerRoles.remove(aWorkerRole);
      workerRoles.add(index, aWorkerRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWorkerRoleAt(WorkerRole aWorkerRole, int index)
  {
    boolean wasAdded = false;
    if(workerRoles.contains(aWorkerRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWorkerRoles()) { index = numberOfWorkerRoles() - 1; }
      workerRoles.remove(aWorkerRole);
      workerRoles.add(index, aWorkerRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWorkerRoleAt(aWorkerRole, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Customer addCustomer(String aAddress, int aTotalLoyaltyPoints, Account aAccount)
  {
    return new Customer(aAddress, aTotalLoyaltyPoints, this, aAccount);
  }

  public boolean addCustomer(Customer aCustomer)
  {
    boolean wasAdded = false;
    if (customers.contains(aCustomer)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aCustomer.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aCustomer.setGroceryManagementSystem(this);
    }
    else
    {
      customers.add(aCustomer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomer(Customer aCustomer)
  {
    boolean wasRemoved = false;
    //Unable to remove aCustomer, as it must always have a groceryManagementSystem
    if (!this.equals(aCustomer.getGroceryManagementSystem()))
    {
      customers.remove(aCustomer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomerAt(Customer aCustomer, int index)
  {  
    boolean wasAdded = false;
    if(addCustomer(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomerAt(Customer aCustomer, int index)
  {
    boolean wasAdded = false;
    if(customers.contains(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomerAt(aCustomer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Item addItem(String aName, int aPrice, int aQuantityInStock, boolean aIsPerishable, int aLoyaltyPoints)
  {
    return new Item(aName, aPrice, aQuantityInStock, aIsPerishable, aLoyaltyPoints, this);
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aItem.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aItem.setGroceryManagementSystem(this);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aItem, as it must always have a groceryManagementSystem
    if (!this.equals(aItem.getGroceryManagementSystem()))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder()
  {
    return new Order(this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aOrder.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aOrder.setGroceryManagementSystem(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a groceryManagementSystem
    if (!this.equals(aOrder.getGroceryManagementSystem()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrderedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public OrderedItem addOrderedItem(int aQuantityOrdered, Order aOrder, Item aItem)
  {
    return new OrderedItem(aQuantityOrdered, this, aOrder, aItem);
  }

  public boolean addOrderedItem(OrderedItem aOrderedItem)
  {
    boolean wasAdded = false;
    if (orderedItems.contains(aOrderedItem)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aOrderedItem.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aOrderedItem.setGroceryManagementSystem(this);
    }
    else
    {
      orderedItems.add(aOrderedItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderedItem(OrderedItem aOrderedItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrderedItem, as it must always have a groceryManagementSystem
    if (!this.equals(aOrderedItem.getGroceryManagementSystem()))
    {
      orderedItems.remove(aOrderedItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderedItemAt(OrderedItem aOrderedItem, int index)
  {  
    boolean wasAdded = false;
    if(addOrderedItem(aOrderedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderedItems()) { index = numberOfOrderedItems() - 1; }
      orderedItems.remove(aOrderedItem);
      orderedItems.add(index, aOrderedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderedItemAt(OrderedItem aOrderedItem, int index)
  {
    boolean wasAdded = false;
    if(orderedItems.contains(aOrderedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderedItems()) { index = numberOfOrderedItems() - 1; }
      orderedItems.remove(aOrderedItem);
      orderedItems.add(index, aOrderedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderedItemAt(aOrderedItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGroceryOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GroceryOrder addGroceryOrder(Delivery aDeliveryDate, String aDate, int aOrderNumber, Employee aEmployee, Cart aCart)
  {
    return new GroceryOrder(aDeliveryDate, aDate, aOrderNumber, this, aEmployee, aCart);
  }

  public boolean addGroceryOrder(GroceryOrder aGroceryOrder)
  {
    boolean wasAdded = false;
    if (groceryOrders.contains(aGroceryOrder)) { return false; }
    GroceryManagementSystem existingGroceryManagementSystem = aGroceryOrder.getGroceryManagementSystem();
    boolean isNewGroceryManagementSystem = existingGroceryManagementSystem != null && !this.equals(existingGroceryManagementSystem);
    if (isNewGroceryManagementSystem)
    {
      aGroceryOrder.setGroceryManagementSystem(this);
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
    //Unable to remove aGroceryOrder, as it must always have a groceryManagementSystem
    if (!this.equals(aGroceryOrder.getGroceryManagementSystem()))
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

  public void delete()
  {
    while (accounts.size() > 0)
    {
      Account aAccount = accounts.get(accounts.size() - 1);
      aAccount.delete();
      accounts.remove(aAccount);
    }
    
    while (workerRoles.size() > 0)
    {
      WorkerRole aWorkerRole = workerRoles.get(workerRoles.size() - 1);
      aWorkerRole.delete();
      workerRoles.remove(aWorkerRole);
    }
    
    while (customers.size() > 0)
    {
      Customer aCustomer = customers.get(customers.size() - 1);
      aCustomer.delete();
      customers.remove(aCustomer);
    }
    
    while (items.size() > 0)
    {
      Item aItem = items.get(items.size() - 1);
      aItem.delete();
      items.remove(aItem);
    }
    
    while (orders.size() > 0)
    {
      Order aOrder = orders.get(orders.size() - 1);
      aOrder.delete();
      orders.remove(aOrder);
    }
    
    while (orderedItems.size() > 0)
    {
      OrderedItem aOrderedItem = orderedItems.get(orderedItems.size() - 1);
      aOrderedItem.delete();
      orderedItems.remove(aOrderedItem);
    }
    
    while (groceryOrders.size() > 0)
    {
      GroceryOrder aGroceryOrder = groceryOrders.get(groceryOrders.size() - 1);
      aGroceryOrder.delete();
      groceryOrders.remove(aGroceryOrder);
    }
    
  }

}