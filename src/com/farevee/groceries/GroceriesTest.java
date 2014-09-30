package com.farevee.groceries;

public class GroceriesTest
{

  public static void main(String args[])
  {
    /*Test 1: Class Tests*/

    //BulkItem Tests
    System.out.println("BulkItem Tests");
    //20 pounds of red apples, priced at 50 cents per pound
    BulkFood redApples = new BulkFood("Red Apples", Units.POUND, 50, 20);
    //50 pounds of green apples, priced at 20 cents per pound
    BulkFood greenApples = new BulkFood("Green Apples", Units.POUND, 20, 50);
    BulkItem redApplesBulk = new BulkItem(redApples, Units.POUND, 5);
    BulkItem greenApplesBulk = new BulkItem(greenApples, Units.POUND, 5);
    System.out.println("Red apples weight is "
                       + redApplesBulk.getWeightAmount());
    System.out.println("Green apples weight is "
                       + greenApplesBulk.getWeightAmount());
    System.out.println("Red apples weight is in unit "
                       + redApplesBulk.getWeightUnit());
    System.out.println("Green apples weight is in unit "
                       + greenApplesBulk.getWeightUnit());
    System.out.println("Red apples price is " + redApplesBulk.getPrice());
    System.out.println("Green apples price is " + greenApplesBulk.getPrice());
    System.out.println(redApplesBulk.toString());
    System.out.println(greenApplesBulk.toString());
    System.out.println("Red apples bulk item amount is "
                       + redApplesBulk.getBulkItemAmount());
    System.out.println("Green apples bulk item amount is "
                       + greenApplesBulk.getBulkItemAmount());
    System.out.println("Red apples and green apples comparison is "
                       + redApplesBulk.equals(greenApplesBulk));
    System.out.println();

    //BulkContainer Tests
    System.out.println("BulkContainer Tests");
    BulkContainer redApplesBox =
        new BulkContainer("box", redApples, Units.POUND, 5);
    BulkContainer redApplesBox2 =
        new BulkContainer("box", redApples, Units.POUND, 5);
    BulkContainer greenApplesBox =
        new BulkContainer("box", greenApples, Units.POUND, 5);
    System.out.println(redApplesBox.toString());
    System.out.println(greenApplesBox.toString());
    System.out.println("Red apples box and green apples box comparison "
                       + redApplesBox.equals(greenApplesBox));
    System.out.println("Red apples box and red apples box comparison "
                       + redApplesBox.equals(redApplesBox2));
    System.out.println();

    //Package Tests
    System.out.println("Package Tests");
    Package cakeMix = new Package("cake mix", new Weight(Units.OUNCE, 12), 399);
    Package brownieMix =
        new Package("brownie mix", new Weight(Units.OUNCE, 12), 399);
    System.out.println(cakeMix.toString());
    System.out.println("Cake mix and brownie mix comparison "
                       + cakeMix.equals(brownieMix));
    System.out.println("Cake mix weight amount " + cakeMix.getWeightAmount());
    System.out.println("Cake mix weight unit " + cakeMix.getWeightUnit());
    System.out.println("Cake mix price " + cakeMix.getPrice());
    System.out.println("Cake mix name " + cakeMix.getName());
    System.out.println();

    //NonFood Tests
    System.out.println("NonFood Tests");
    NonFood kitchenKnife =
        new NonFood("kitchen knife", new Weight(Units.OUNCE, 2), 499);
    NonFood kitchenFork =
        new NonFood("kitchen fork", new Weight(Units.OUNCE, 2), 499);
    System.out.println(kitchenKnife.toString());
    System.out.println("Kitchen knife and kitchen fork comparison "
                       + kitchenKnife.equals(kitchenFork));
    System.out.println("Kitchen knife weight amount "
                       + kitchenKnife.getWeightAmount());
    System.out.println("Kitchen knife weight unit "
                       + kitchenKnife.getWeightUnit());
    System.out.println("Kitchen knife price " + kitchenKnife.getPrice());
    System.out.println("Kitchen knife name " + kitchenKnife.getName());
    System.out.println();

    //ManyPackage Tests
    System.out.println("ManyPackages Tests");
    ManyPackages manyCakeMix = new ManyPackages(cakeMix, 5);
    ManyPackages manyBrownieMix = new ManyPackages(brownieMix, 5);
    System.out.println("Many cake mix price " + manyCakeMix.getPrice());
    System.out.println(manyCakeMix.toString());
    System.out.println("Many cake mix and many brownie mix comparison "
                       + manyCakeMix.equals(manyBrownieMix));
    System.out.println("Many cake mix count " + manyCakeMix.getCount());
    System.out.println("Many brownie mix count " + manyCakeMix.getCount());
    System.out.println("Many mix weight amount " + manyCakeMix.getWeightAmount());
    System.out.println("Many Cake mix weight unit " + manyCakeMix.getWeightUnit());
    System.out.println("Many cake mix name " + manyCakeMix.getName());
    System.out.println("Many cake package type " + manyCakeMix.getType().toString());
    System.out.println();

    /*Test 2: Normal Usage*/
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
