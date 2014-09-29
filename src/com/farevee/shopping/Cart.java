/**
 * Reference on implementing Array Lists in Java:
 * http://www.tutorialspoint.com/java/java_linkedlist_class.htm
 * 
 * Reference on instanceOf:
 * http://www.tutorialspoint.com/java/java_inheritance.htm
 * 
 * Reference on contains:
 * http://www.tutorialspoint.com/java/lang/string_contains.htm
 * 
 * Reference on isInstance:
 * http://stackoverflow.com/questions/13873933/java-instanceof-with-class-name
 * http://www.tutorialspoint.com/java/lang/class_isinstance.htm
 * 
 */

package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.LinkedList;

import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Package;
import com.farevee.groceries.Units;

public class Cart
{
  /*Fields*/
  //Consulted Albert Owusu-Asare
  LinkedList<Item> shoppingCart = new LinkedList<Item>();
  int[] weightsArray = new int[4];
  //weightsArray[0] for pounds, weightsArray[1] for ounces
  //weightsArray[2] for kilograms, weightsArray[3] for grams
  int numberOfThings = 0;
  int numberOfEntries = 0;
  int totalPrice = 0;

  /*Constructor*/
  public Cart()
  {
  }

  /*Methods*/
  //Add an item to the cart.
  public void addItem(Item itemToAdd)
  {
    //Update numberOfThings, numberofEntries, totalPrice
    //Add new Item to shoppingCart
    if (itemToAdd instanceof ManyPackages)
      {
        numberOfThings += ((ManyPackages) itemToAdd).getCount();
        numberOfEntries++;
        totalPrice += itemToAdd.getPrice();

        shoppingCart.add(itemToAdd);
      }//if()
    else
      {
        numberOfThings++;
        numberOfEntries++;
        totalPrice += itemToAdd.getPrice();

        shoppingCart.add(itemToAdd);
      }//else()

    //Update the weightsArray
    Units weightUnit = itemToAdd.getWeightUnit();
    int weightAmount = itemToAdd.getWeightAmount();

    if (weightUnit.equals(Units.POUND))
      {
        weightsArray[0] += weightAmount;
      }
    else if (weightUnit.equals(Units.OUNCE))
      {
        weightsArray[1] += weightAmount;
      }
    else if (weightUnit.equals(Units.KILOGRAM))
      {
        weightsArray[2] += weightAmount;
      }
    else if (weightUnit.equals(Units.GRAM))
      {
        weightsArray[3] += weightAmount;
      }

  }//addItem(Item)

  //Get the number of things in the cart.
  public int numThings()
  {
    return this.numberOfThings;

  }//numThings()

  // Get the number of entries in the cart.
  public int numEntries()
  {
    return this.numberOfEntries;

  }//numEntries()

  //Print the contents of the cart. 
  public void printContents(PrintWriter pen)
  {
    pen.println("The shopping cart contains the following:");

    for (int i = 0; i < shoppingCart.size(); i++)
      {
        pen.println(shoppingCart.get(i).toString());

      }//for()

  }//printContents(PrintWriter)

  //Computes the total price of the order, in cents. 
  public int getPrice()
  {
    return this.totalPrice;

  }//getPrice()

  //Returns an array with weights in pounds, ounces, kilograms, and grams
  public int[] getWeight()
  {
    return weightsArray;

  }//getWeight()

  //Removes all of the products whose name exactly matches name.
  public void remove(String name)
  {
    CharSequence inputName = name;

    for (int i = 0; i < shoppingCart.size(); i++)
      {
        if (shoppingCart.get(i).toString().contains(inputName))
          {

            Item itemToRemove = shoppingCart.get(i);

            //Update numberOfThings, numberofEntries, totalPrice
            //Remove item whose name matches the user input name from shoppingCart
            if (itemToRemove instanceof ManyPackages)
              {
                numberOfThings -= ((ManyPackages) itemToRemove).getCount();
                numberOfEntries--;
                totalPrice -= itemToRemove.getPrice();

                shoppingCart.remove(itemToRemove);
              }//if()
            else
              {
                numberOfThings--;
                numberOfEntries--;
                totalPrice -= itemToRemove.getPrice();

                shoppingCart.remove(itemToRemove);
              }//else()

            //Update the weightsArray
            if ((itemToRemove.getWeightUnit()).equals(Units.POUND))
              {
                weightsArray[0] -= itemToRemove.getWeightAmount();
              }
            else if ((itemToRemove.getWeightUnit()).equals(Units.OUNCE))
              {
                weightsArray[1] -= itemToRemove.getWeightAmount();
              }
            else if ((itemToRemove.getWeightUnit()).equals(Units.KILOGRAM))
              {
                weightsArray[2] -= itemToRemove.getWeightAmount();
              }
            else if ((itemToRemove.getWeightUnit()).equals(Units.GRAM))
              {
                weightsArray[3] -= itemToRemove.getWeightAmount();
              }

          }//if()

      }//for()

  }//remove(String name)

  //Finds identical items and merges them into a single item. 
  public void merge()
  {
    for (int i = 0; i < shoppingCart.size(); i++)
      {
        for (int j = 0; j < shoppingCart.size(); j++)
          {
            //If there are two packages, merge them into one ManyPackages 
            if ((shoppingCart.get(i) instanceof Package)
                && (shoppingCart.get(j) instanceof Package))
              {
                //Merge if the contents of the two packages are equal
                if (((Package) shoppingCart.get(i)).equals((Package) shoppingCart.get(j)))
                  {
                    Item thingToBeMerged = shoppingCart.get(i);
                    Package packageToBeMerged =
                        new Package(thingToBeMerged.getName(),
                                    thingToBeMerged.getWeight(),
                                    thingToBeMerged.getPrice());
                    ManyPackages mergedPackage =
                        new ManyPackages(packageToBeMerged, 2);
                    addItem(mergedPackage);
                    shoppingCart.remove(i);
                    shoppingCart.remove(j);
                  }//if()
              }//if()

            //If there is one Package and one ManyPackages with the same contents
            if ((shoppingCart.get(i) instanceof Package)
                && (shoppingCart.get(j) instanceof ManyPackages))
              {
                //Merge if the contents of Package are in ManyPackages
                if (((ManyPackages) shoppingCart.get(j)).getType()
                                                        .equals((Package) shoppingCart.get(i)))
                  {
                    Item thingToBeMerged = shoppingCart.get(i);
                    Package packageToBeMerged =
                        new Package(thingToBeMerged.getName(),
                                    thingToBeMerged.getWeight(),
                                    thingToBeMerged.getPrice());
                    int totalNumberOfPackages =
                        ((ManyPackages) shoppingCart.get(j)).getCount() + 1;
                    ManyPackages mergedPackage =
                        new ManyPackages(packageToBeMerged,
                                         totalNumberOfPackages);
                    addItem(mergedPackage);
                    shoppingCart.remove(i);
                    shoppingCart.remove(j);
                  }//else if()
              }//if()
            else if ((shoppingCart.get(i) instanceof ManyPackages)
                     && (shoppingCart.get(j) instanceof Package))
              {
                //Merge if the contents of Package are in ManyPackages
                if (((ManyPackages) shoppingCart.get(i)).getType()
                                                        .equals((Package) shoppingCart.get(j)))
                  {
                    Item thingToBeMerged = shoppingCart.get(j);
                    Package packageToBeMerged =
                        new Package(thingToBeMerged.getName(),
                                    thingToBeMerged.getWeight(),
                                    thingToBeMerged.getPrice());
                    int totalNumberOfPackages =
                        ((ManyPackages) shoppingCart.get(i)).getCount() + 1;
                    ManyPackages mergedPackage =
                        new ManyPackages(packageToBeMerged,
                                         totalNumberOfPackages);
                    addItem(mergedPackage);
                    shoppingCart.remove(i);
                    shoppingCart.remove(j);
                  }//if()
              }//else if()

            //If there are two ManyPackages with the same contents, merge into one ManyPackages
            if ((shoppingCart.get(i) instanceof ManyPackages)
                && (shoppingCart.get(j) instanceof ManyPackages))
              {
                //Merge if the contents of both ManyPackages are the same
                if (((ManyPackages) shoppingCart.get(i)).equals((ManyPackages) shoppingCart.get(j)))
                  {
                    int numberOfManyPackagesToAdd =
                        ((ManyPackages) shoppingCart.get(j)).getCount()
                            + ((ManyPackages) shoppingCart.get(j)).getCount();
                    Package packageToMerge =
                        ((ManyPackages) shoppingCart.get(i)).getType();
                    ManyPackages mergedPackage =
                        new ManyPackages(packageToMerge,
                                         numberOfManyPackagesToAdd);
                    addItem(mergedPackage);
                    shoppingCart.remove(i);
                    shoppingCart.remove(j);
                  }//if()
              }//if()

            //If there are two BulkItem with the same contents, merge into one BulkItem
            if ((shoppingCart.get(i) instanceof BulkItem)
                && (shoppingCart.get(j) instanceof BulkItem))
              {
                //Merge if the two BulkItem are equal
                if (((BulkItem) shoppingCart.get(i)).equals((BulkItem) shoppingCart.get(j)))
                  {
                    int bulkItemAmount =
                        ((BulkItem) shoppingCart.get(i)).getBulkItemAmount()
                            + ((BulkItem) shoppingCart.get(j)).getBulkItemAmount();
                    BulkItem mergedBulkItem =
                        new BulkItem(
                                     ((BulkItem) shoppingCart.get(i)).getBulkFoodType(),
                                     shoppingCart.get(i).getWeightUnit(),
                                     bulkItemAmount);
                    addItem(mergedBulkItem);
                    shoppingCart.remove(i);
                    shoppingCart.remove(j);
                  }//if()
              }//if()
          }//for(j)
      }//for(i)
  }//merge()

}//public class Cart
