package com.farevee.groceries;

public class ManyPackages
    implements Item
{

  //+--------+------------------------------------------------------
  // | Fields |
  // +--------+
  Package type;
  int count;

  //+--------------+------------------------------------------------
  // | Constructor |
  // +--------------+
  public ManyPackages(Package type, int count)
  {
    this.type = type;
    this.count = count;
  }

  //+-----------+---------------------------------------------------
  // | Methods  |
  // +-----------+
  //Get the Weight of ManyPackages, including unit and amount
  public Weight getWeight()
  {
    return new Weight(this.type.weight.unit,
                      ((this.count) * (this.type.weight.amount)));
  }

  //Get the price of ManyPackages
  public int getPrice()
  {
    return this.count * this.type.price;
  }

  //Get information about ManyPackages
  public String toString()
  {
    return (this.count + " x " + this.type.weight.amount + " "
            + this.type.weight.unit + " of " + this.type.name);
  }

  //Compares two ManyPackages
  public boolean equalZ(Object thing)
  {
    if (thing instanceof ManyPackages)
      {
        ManyPackages manyManyPackages = (ManyPackages) thing;
        return (this.type.equals(manyManyPackages.type));
      }
    else
      {
        return Boolean.FALSE;
      }
  }

  //Get the count/number packages in ManyPackages
  public int getCount()
  {
    return this.count;
  }

  //Get the amount of weight of ManyPackages
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }

  //Get the unit of weight of ManyPackages
  @Override
  public Units getWeightUnit()
  {
    return this.getWeight().unit;
  }

  //Get the name of packages in ManyPackages
  @Override
  public String getName()
  {
    return this.type.name;
  }

  //Get the type of packages in ManyPackages
  public Package getType()
  {
    return this.type;
  }
  
  public void addPackage(int amount)
  {
    this.count += amount;
  }
  
}
