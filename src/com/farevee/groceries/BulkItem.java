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
    return new Weight(this.unit, this.amount);
  }

  public int getPrice()
  {
    return this.food.pricePerUnit * this.amount;
  }

  public String toString()
  {
    return (amount + " " + unit.name + " of " + food.name);
  }

  public boolean equals(BulkItem anotherBulkItem)
  {
    if ((this.food.name.equals(anotherBulkItem.food.name))
        && (this.unit.name.equals(anotherBulkItem.unit.name)))
        //&& (this.amount == anotherBulkItem.amount))
      {
        return Boolean.TRUE;
      }
    return Boolean.FALSE;
  }

  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }

  @Override
  public Units getWeightUnit()
  {
    return this.unit;
  }

  @Override
  public String getName()
  {
    return this.food.name;
  }
  
  public BulkFood getBulkFoodType()
  {
    return this.food;
  }
  
  public int getBulkItemAmount()
  {
    return this.amount;
  }
}
