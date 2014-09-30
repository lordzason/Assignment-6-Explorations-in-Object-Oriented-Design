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
  //Information about the BulkContainer in a string
  @Override
  public String toString()
  {
    return (this.container + " of " + this.amount + " " + this.unit.plural
            + " of " + this.food.name);
  }

  //Compares two BulkContainer
  public boolean equals(BulkContainer anotherBulkContainer)
  {
    return ((this.food.equals(anotherBulkContainer.food)) 
        && (this.container.compareTo(anotherBulkContainer.container) == 0));
  }

}
