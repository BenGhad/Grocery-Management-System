/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;
import java.util.*;

// line 33 "../grocerymanagementsystem.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private String name;
  private int price;
  private int quantity;
  private boolean perishable;
  private int loyaltyPoints;

  //Item Associations
  private List<Order> orders;
  private ItemList itemList;
  private List<OrderedItem> orderedItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(String aName, int aPrice, int aQuantity, boolean aPerishable, int aLoyaltyPoints, ItemList aItemList)
  {
    name = aName;
    price = aPrice;
    quantity = aQuantity;
    perishable = aPerishable;
    loyaltyPoints = aLoyaltyPoints;
    orders = new ArrayList<Order>();
    boolean didAddItemList = setItemList(aItemList);
    if (!didAddItemList)
    {
      throw new RuntimeException("Unable to create item due to itemList. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    orderedItems = new ArrayList<OrderedItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(int aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPerishable(boolean aPerishable)
  {
    boolean wasSet = false;
    perishable = aPerishable;
    wasSet = true;
    return wasSet;
  }

  public boolean setLoyaltyPoints(int aLoyaltyPoints)
  {
    boolean wasSet = false;
    loyaltyPoints = aLoyaltyPoints;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getPrice()
  {
    return price;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public boolean getPerishable()
  {
    return perishable;
  }

  public int getLoyaltyPoints()
  {
    return loyaltyPoints;
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
  /* Code from template association_GetOne */
  public ItemList getItemList()
  {
    return itemList;
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
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    orders.add(aOrder);
    if (aOrder.indexOfItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrder.addItem(this);
      if (!wasAdded)
      {
        orders.remove(aOrder);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (!orders.contains(aOrder))
    {
      return wasRemoved;
    }

    int oldIndex = orders.indexOf(aOrder);
    orders.remove(oldIndex);
    if (aOrder.indexOfItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrder.removeItem(this);
      if (!wasRemoved)
      {
        orders.add(oldIndex,aOrder);
      }
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
  /* Code from template association_SetOneToMany */
  public boolean setItemList(ItemList aItemList)
  {
    boolean wasSet = false;
    if (aItemList == null)
    {
      return wasSet;
    }

    ItemList existingItemList = itemList;
    itemList = aItemList;
    if (existingItemList != null && !existingItemList.equals(aItemList))
    {
      existingItemList.removeItem(this);
    }
    itemList.addItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrderedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public OrderedItem addOrderedItem(int aQuantityOrdered, Order aOrder)
  {
    return new OrderedItem(aQuantityOrdered, this, aOrder);
  }

  public boolean addOrderedItem(OrderedItem aOrderedItem)
  {
    boolean wasAdded = false;
    if (orderedItems.contains(aOrderedItem)) { return false; }
    Item existingItem = aOrderedItem.getItem();
    boolean isNewItem = existingItem != null && !this.equals(existingItem);
    if (isNewItem)
    {
      aOrderedItem.setItem(this);
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
    //Unable to remove aOrderedItem, as it must always have a item
    if (!this.equals(aOrderedItem.getItem()))
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
    ArrayList<Order> copyOfOrders = new ArrayList<Order>(orders);
    orders.clear();
    for(Order aOrder : copyOfOrders)
    {
      aOrder.removeItem(this);
    }
    ItemList placeholderItemList = itemList;
    this.itemList = null;
    if(placeholderItemList != null)
    {
      placeholderItemList.removeItem(this);
    }
    for(int i=orderedItems.size(); i > 0; i--)
    {
      OrderedItem aOrderedItem = orderedItems.get(i - 1);
      aOrderedItem.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "quantity" + ":" + getQuantity()+ "," +
            "perishable" + ":" + getPerishable()+ "," +
            "loyaltyPoints" + ":" + getLoyaltyPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "itemList = "+(getItemList()!=null?Integer.toHexString(System.identityHashCode(getItemList())):"null");
  }
}