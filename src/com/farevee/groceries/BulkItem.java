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
  //Get the Weight, including unit and amount
  public Weight getWeight()
  {
    return new Weight(this.unit, this.amount);
  }

  //Get the amount of weight
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }

  //Get the unit of weight
  @Override
  public Units getWeightUnit()
  {
    return this.unit;
  }

  //Get the price
  public int getPrice()
  {
    return this.food.pricePerUnit * this.amount;
  }

  //Creates a string for the name
  public String toString()
  {
    return (amount + " " + unit.name + " of " + food.name);
  }

  //Gets the name
  @Override
  public String getName()
  {
    return this.food.name;
  }

  //Get the type of BulkFood
  public BulkFood getBulkFoodType()
  {
    return this.food;
  }

  //Get the amount of BulkItem
  public int getBulkItemAmount()
  {
    return this.amount;
  }

  //Compares two BulkItem
  public boolean equals(BulkItem anotherBulkItem)
  {
    if ((this.food.name.equals(anotherBulkItem.food.name))
        && (this.unit.name.equals(anotherBulkItem.unit.name)))
      {
        return Boolean.TRUE;
      }
    return Boolean.FALSE;
  }

}
