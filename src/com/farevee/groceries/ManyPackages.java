package com.farevee.groceries;

public class ManyPackages
    implements Item
{
  /*Fields*/
  Package type;
  int count;

  /*Constructor*/
  public ManyPackages(Package type, int count)
  {
    this.type = type;
    this.count = count;
  }

  //getWeight() requires a Weight to be returned but calculating weight as int
  public Weight getWeight()
  {
    return new Weight(this.type.weight.unit,
                      ((this.count) * (this.type.weight.amount)));
  }

  public int getPrice()
  {
    return this.count * this.type.price;
  }

  public String toString()
  {
    return (this.count + " x " + this.type.weight.amount + " "
            + this.type.weight.unit + " of " + this.type.name);
  }

  public boolean equals(ManyPackages manyManyPackages)
  {
    if (this.type == manyManyPackages.type)
      {
        return Boolean.TRUE;
      }
    else
      {
        return Boolean.FALSE;
      }
  }

  public int getCount()
  {
    return this.count;
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
    return this.type.name;
  }
  
  public Package getType()
  {
    return this.type;
  }
}
