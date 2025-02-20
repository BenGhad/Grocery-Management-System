/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

package Deliverable1;

// line 59 "../grocerymanagementsystem.ump"
public class OrderedItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderedItem Attributes
  private int quantityOrdered;

  //OrderedItem Associations
  private GroceryManagementSystem groceryManagementSystem;
  private Order order;
  private Item item;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetOrder;
  private boolean canSetItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderedItem(int aQuantityOrdered, GroceryManagementSystem aGroceryManagementSystem, Order aOrder, Item aItem)
  {
    cachedHashCode = -1;
    canSetOrder = true;
    canSetItem = true;
    quantityOrdered = aQuantityOrdered;
    boolean didAddGroceryManagementSystem = setGroceryManagementSystem(aGroceryManagementSystem);
    if (!didAddGroceryManagementSystem)
    {
      throw new RuntimeException("Unable to create orderedItem due to groceryManagementSystem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create orderedItem due to order. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create orderedItem due to item. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQuantityOrdered(int aQuantityOrdered)
  {
    boolean wasSet = false;
    quantityOrdered = aQuantityOrdered;
    wasSet = true;
    return wasSet;
  }

  public int getQuantityOrdered()
  {
    return quantityOrdered;
  }
  /* Code from template association_GetOne */
  public GroceryManagementSystem getGroceryManagementSystem()
  {
    return groceryManagementSystem;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
  }
  /* Code from template association_GetOne */
  public Item getItem()
  {
    return item;
  }
  /* Code from template association_SetOneToManyAssociationClass */
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
      existingGroceryManagementSystem.removeOrderedItem(this);
    }
    if (!groceryManagementSystem.addOrderedItem(this))
    {
      groceryManagementSystem = existingGroceryManagementSystem;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (!canSetOrder) { return false; }
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeOrderedItem(this);
    }
    if (!order.addOrderedItem(this))
    {
      order = existingOrder;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setItem(Item aItem)
  {
    boolean wasSet = false;
    if (!canSetItem) { return false; }
    if (aItem == null)
    {
      return wasSet;
    }

    Item existingItem = item;
    item = aItem;
    if (existingItem != null && !existingItem.equals(aItem))
    {
      existingItem.removeOrderedItem(this);
    }
    if (!item.addOrderedItem(this))
    {
      item = existingItem;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    OrderedItem compareTo = (OrderedItem)obj;
  
    if (getOrder() == null && compareTo.getOrder() != null)
    {
      return false;
    }
    else if (getOrder() != null && !getOrder().equals(compareTo.getOrder()))
    {
      return false;
    }

    if (getItem() == null && compareTo.getItem() != null)
    {
      return false;
    }
    else if (getItem() != null && !getItem().equals(compareTo.getItem()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getOrder() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getOrder().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getItem() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getItem().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetOrder = false;
    canSetItem = false;
    return cachedHashCode;
  }

  public void delete()
  {
    GroceryManagementSystem placeholderGroceryManagementSystem = groceryManagementSystem;
    this.groceryManagementSystem = null;
    if(placeholderGroceryManagementSystem != null)
    {
      placeholderGroceryManagementSystem.removeOrderedItem(this);
    }
    Order placeholderOrder = order;
    this.order = null;
    if(placeholderOrder != null)
    {
      placeholderOrder.removeOrderedItem(this);
    }
    Item placeholderItem = item;
    this.item = null;
    if(placeholderItem != null)
    {
      placeholderItem.removeOrderedItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantityOrdered" + ":" + getQuantityOrdered()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "groceryManagementSystem = "+(getGroceryManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getGroceryManagementSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null");
  }
}