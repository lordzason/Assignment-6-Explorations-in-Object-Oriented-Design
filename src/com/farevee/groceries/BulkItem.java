package com.farevee.groceries;

public class BulkItem
    implements Item
{
  /*Fields*/
  BulkFood food;
  Units unit;
  int amount;

  /*Constructor*/
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  }

  /*Methods*/
  public Weight getWeight()
  {
    //Need to implement
  }

  public int getPrice()
  {
    return this.food.pricePerUnit * this.food.supply;
  }

  public String toString()
  {
    //Need to implement
    return amount + " " + unit + " of " + food;
  }

  public boolean equals(BulkItem anotherBulkItem)
  {
    if ((this.food.equals(anotherBulkItem.food))
        && (this.unit.equals(anotherBulkItem.unit))
        && (this.amount == anotherBulkItem.amount))
      {
        return Boolean.TRUE;
      }
    return Boolean.FALSE;
  }
}
