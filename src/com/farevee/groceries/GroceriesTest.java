package com.farevee.groceries;

public class GroceriesTest
{

  public static void main(String args[])
  {
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    System.out.println(bananas.name + " " + bananas.pricePerUnit + " "
                       + bananas.supply + " " + bananas.unit);

    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    System.out.println(saffron.name + " " + saffron.pricePerUnit + " "
                       + saffron.supply + " " + saffron.unit);

    //The customer adds three pounds of bananas to the cart
    BulkItem bananas2 = new BulkItem(bananas, Units.POUND, 3);
    System.out.println(bananas2.toString());

    // The customer adds a jar of 3 grams of saffron to the cart
    BulkContainer saffronJar = new BulkContainer("jar", saffron, Units.GRAM, 3);
    System.out.println(saffronJar.toString());

    // The customer adds a bag of 1 gram of saffron to the cart
    BulkContainer saffronBag = new BulkContainer("bag", saffron, Units.GRAM, 1);
    System.out.println(saffronBag.toString());

    // The customer adds a box of oreos to the cart
    Package oreoBox = new Package("oreos", new Weight(Units.OUNCE, 12), 399);
    System.out.println(oreoBox.toString());

    // The customer adds a can opener to the cart, priced $3.489.
    NonFood canOpener =
        new NonFood("can opener", new Weight(Units.OUNCE, 2), 349);
    System.out.println(canOpener.toString());

    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    ManyPackages macNCheez =
        new ManyPackages(new Package("macncheez", new Weight(Units.OUNCE, 6),
                                     77), 5);
    System.out.println(macNCheez.toString());


  }
}
