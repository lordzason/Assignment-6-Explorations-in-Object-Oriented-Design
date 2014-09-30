package com.farevee.groceries;

public class NonFood
    implements Item
{
  /*Fields*/
  String name;
  Weight weight;
  int price;

  /*Constructor*/
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  /*Methods*/
  //Get information about the NonFood
  @Override
  public String toString()
  {
    return this.name + "costs " + this.price;
  }

  //Get the price of the NonFood
  public int getPrice()
  {
    return this.price;
  }

  //Get the Weight of the NonFood, including unit and amount
  public Weight getWeight()
  {
    return this.weight;
  }

  //Compares two NonFood
  public boolean equals(NonFood anotherNonFood)
  {
    if (((this.name).compareTo(anotherNonFood.name) == 0)
        && ((this.weight.unit).equals(anotherNonFood.weight.unit))
        && ((this.weight.amount) == (anotherNonFood.weight.amount))
        && (this.price == anotherNonFood.price))
      {
        return Boolean.TRUE;
      }
    else
      {
        return Boolean.FALSE;
      }
  }

  //Get the amount of weight of NonFood
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }

  //Get the unit of weight of NonFood
  @Override
  public Units getWeightUnit()
  {
    return this.getWeight().unit;
  }

  //Get the name of the NonFood
  @Override
  public String getName()
  {
   return this.name;
  }
}
