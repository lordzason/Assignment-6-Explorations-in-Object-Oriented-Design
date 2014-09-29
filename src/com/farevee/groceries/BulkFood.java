package com.farevee.groceries;

public class BulkFood
{
  /*Fields*/
  String name;
  Units unit;
  int pricePerUnit;
  int supply;
  
  /*Constructor*/
  public BulkFood(String name, Units unit, int pricePerUnit, int supply)
  {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
    this.supply = supply;
  }
  
  /*Methods*/
  public int getBulkFoodSupply()
  {
    return this.supply;
  }
  
}
