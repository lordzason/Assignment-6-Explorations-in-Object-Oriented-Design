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
  @Override
  public String toString()
  {
    return this.name;
  }

  public int getPrice()
  {
    return this.price * this.weight.amount;
  }

  public Weight getWeight()
  {
    return this.weight;
  }

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

  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }

  @Override
  public Units getWeightUnit()
  {
    return this.getWeight().unit;
  }

  @Override
  public String getName()
  {
   return this.name;
  }
}
