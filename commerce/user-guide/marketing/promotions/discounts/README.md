# Adding Discounts by Product

A discount applies a modifier to a product’s base price. It can be an absolute number or a percentage, and can be applied to a limited number of products or to the entire catalog. It can be available to all buyers, or to a defined Account Group, or to a more narrowly defined group of customers that meet certain qualifications. Unlike a price list, a discount always _reduces_ the base price.

## Roadmap
* Creating a Discount by Product
* Adding a Discount Rule

### Discount by Product

To create a discount rule by product:

1. Go to the _Control Panel_ → _Commerce_ → _Discounts_.
1. Click the (+) button to add a new Discount.
1. Enter a name: _Christmas Sale_.
1. Select a discount type from the _Target_ drop down. There are five different types of discounts: Categories, Products, Shipment, Subtotal, and Total. In this example, select _Apply to Product_.
1. Check the box for which channel this discount applies to.
1. Select which [Account Groups](/../account-management/creating-account-groups/README.md) this discount applies to; in this example, _US East Coast_. 
1. Switch the _Use Percentage_ toggle to _Yes_.
1. Enter the _Maximum Discount Amount_: 20%.
1. Enter the _Level_: 1.00
1. Switch the _Active_ toggle to _YES_. 

    <img src="./images/01.png" width="700px" style="border: #000000 1px solid;">

1. Click _Publish_.

Your store now has a discount with 20% off selected goods for those in a specific Account Group.

### Adding Rules to a Discount

You can create rules that limit the buyer's discount conditions. There are three types of rules:

**Cart Total**: Buyers can benefit from the discount if their orders contain products worth a specified amount.

**Has all of these products**: Buyers can benefit if their orders include all from a list of specified products.

**Has one of these products**: Buyers can benefit if their orders contain at least one from a list of specified products.


1. Once the discount has been created, there are 3 tabs: _Detail_, _Rules_, and _Products_. Click on the _Rules_ tab.

    <img src="./images/02.png" width="700px" style="border: #000000 1px solid;">

1. Click (+) button to add a new Discount Rule.
1. Select _Cart Total_ from the _Type_ drop down menu.
1. Enter 25.00 in the _Cart Total Minimum Amount_ field.
1. Click _Save_.

In this example, a Discount Rule has been applied to this particular Discount. Customers will receive this discount for all purchases over the set amount.

The other two options (**Has all of these products** and **Has one of these products**) function by allowing the seller to select which products in the catalog are eligible for the discount.


   <img src="./images/03.png" width="700px" style="border: #000000 1px solid;">

   Select which products are to be included:

   <img src="./images/04.png" width="700px" style="border: #000000 1px solid;">

After selecting the applicable products, customers will receive a discount for these goods depending on which of these rules has been chosen.

## Additional Information

* [Account Groups](/../account-management/creating-account-groups/README.md).