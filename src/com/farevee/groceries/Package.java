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
  //Information about the Package in a string
  @Override
  public String toString()
  {
    return this.weight.amount + " " + this.weight.unit.name + " package of "
           + this.name;
  }

  //Compares two Package
  public boolean equals(Object thing)
  {
    if (thing instanceof Package)
      {
        Package anotherPackage = (Package) thing;

        return ((this.name.compareTo(anotherPackage.name) == 0)
                && ((this.getWeight().unit).equals(anotherPackage.getWeight().unit))
                && ((this.getWeight().amount) == (anotherPackage.getWeight().amount)) && (this.getPrice() == anotherPackage.getPrice()));
      }
    else
      {
        return Boolean.FALSE;
      }
  }

  //Get the Weight, unit and amount
  @Override
  public Weight getWeight()
  {
    return this.weight;
  }

  //Get the price of the Package
  @Override
  public int getPrice()
  {
    return this.price;
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
    return this.getWeight().unit;
  }

  //Get the name of the Package
  @Override
  public String getName()
  {
    return this.name;
  }
}
