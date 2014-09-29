package com.farevee.groceries;

public class BulkContainer
    extends BulkItem
{
  /*Fields*/
  String container;

  /*Constructor*/
  public BulkContainer(String containerName, BulkFood food, Units unit,
                       int amount)
  {
    super(food, unit, amount);
    this.container = containerName;
  }

  /*Methods*/
  @Override
  public String toString()
  {
    return (this.container + " of " + this.amount + " " + this.unit.plural
            + " of " + this.food.name);
  }

  public boolean equals(BulkContainer anotherBulkContainer)
  {
    return ((this.equals(anotherBulkContainer)) && (this.container.compareTo(anotherBulkContainer.container) == 0));
  }

}
