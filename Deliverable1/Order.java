/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 55 "../grocerymanagementsystem.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Associations
  private List<Item> items;
  private GroceryManagementSystem groceryManagementSystem;
  private List<OrderedItem> orderedItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(GroceryManagementSystem aGroceryManagementSystem)
  {
    items = new ArrayList<Item>();
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create order due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    orderedItems = new ArrayList<OrderedItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    if (aItem.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aItem.addOrder(this);
      if (!wasAdded)
      {
        items.remove(aItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (!items.contains(aItem))
    {
      return wasRemoved;
    }

    int oldIndex = items.indexOf(aItem);
    items.remove(oldIndex);
    if (aItem.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aItem.removeOrder(this);
      if (!wasRemoved)
      {
        items.add(oldIndex,aItem);
      }
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
      existingGroceryManagementSystem.removeOrder(this);
    }
    groceryManagementSystem.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrderedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public OrderedItem addOrderedItem(int aQuantityOrdered, GroceryManagementSystem aGroceryManagementSystem, Item aItem)
  {
    return new OrderedItem(aQuantityOrdered, aGroceryManagementSystem, this, aItem);
  }

  public boolean addOrderedItem(OrderedItem aOrderedItem)
  {
    boolean wasAdded = false;
    if (orderedItems.contains(aOrderedItem)) { return false; }
    Order existingOrder = aOrderedItem.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aOrderedItem.setOrder(this);
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
    //Unable to remove aOrderedItem, as it must always have a order
    if (!this.equals(aOrderedItem.getOrder()))
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

  public void delete()
  {
    ArrayList<Item> copyOfItems = new ArrayList<Item>(items);
    items.clear();
    for(Item aItem : copyOfItems)
    {
      aItem.removeOrder(this);
    }
    GroceryManagementSystem placeholderGroceryManagementSystem = groceryManagementSystem;
    this.groceryManagementSystem = null;
    if(placeholderGroceryManagementSystem != null)
    {
      placeholderGroceryManagementSystem.removeOrder(this);
    }
    for(int i=orderedItems.size(); i > 0; i--)
    {
      OrderedItem aOrderedItem = orderedItems.get(i - 1);
      aOrderedItem.delete();
    }
  }

}