package com.farevee.groceries;

public class Package
    implements Item
{
  /*Fields*/
  String name;
  Weight weight;
  int price;

  /*Constructor*/
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  /*Methods*/
  @Override
  public String toString()
  {
    return this.weight.amount + " " + this.weight.unit.name + " package of "
           + this.name;
  }

  public boolean equals(Package anotherPackage)
  {
    if ((this.name.compareTo(anotherPackage.name) == 0)
        && ((this.getWeight().unit).equals(anotherPackage.getWeight().unit))
        && ((this.getWeight().amount) == (anotherPackage.getWeight().amount))
        && (this.getPrice() == anotherPackage.getPrice()))
      {
        return Boolean.TRUE;
      }
    return Boolean.FALSE;
  }

  @Override
  public Weight getWeight()
  {
    return this.weight;
  }

  @Override
  public int getPrice()
  {
    return this.price;
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
