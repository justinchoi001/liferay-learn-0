# Creating a Grouped Product

A Grouped Product in Liferay Commerce is two or more products from the catalog that are packaged together to be sold as a single item. Grouped Products are not tracked in the inventory. Instead, the catalog tracks all of the products contained in the group individually. A Grouped Product can contain simple products, other Grouped Products, or virtual products.

You must specify the products that the group contains. A Grouped Product has an extra tab (_Grouped_) in its product tab bar. From that tab, click on the _Add_ button in the upper-right to select any number of products. Once products have been added to the group, they can be edited individually to set a quantity and a priority (priority establishes the order in which items are displayed; lower numbers come first).

## Prerequisites

Before creating a Grouped Product, ensure that the following conditions have been met:

1. The individual products to be sold as a single unit have been created in the catalog.
    * All SKUs have been generated.
    * All prices have been set.
    * The products can be both simple and virtual.
1. The individual products have sufficent quantities in the inventory.

## Creating a Grouped Product

1. Navigate to _Control Panel_ → _Commerce_ → _Products_. 
1. Click the (+) button then _Grouped_.
1. Enter the following:
    * **Catalog**: Sahara.com
    * **Name**: Dog Grooming Kit
    * **Short Description**: Max's Dog Grooming Kit
    * **Full Description**: 
    * **Friendly URL**: (auto-generated)
    * **Meta Title**: Dog Grooming Kit
    * **Meta Description**: 
    * **Meta Keywords**: 
1. Click _Publish_.

Once the Grouped Product has been created initially, there are additional required steps. Click the _Grouped_ sub-tab to continue. On the _Grouped_ tab, add the individual items to be sold in this package.

   <img src="./images/01.png" width="700px" style="border: #000000 1px; solid;">

1. Click the (+) button to add a Grouped Entry.
1. Select the following products: _Dog Hair Brush_, _Dog Nail File_, and _Dog Shampoo_.
1. Click _Add_.

    <img src="./images/02.png" width="700px" style="border: #000000 1px; solid;">

Next, specify the priority (the order in which they are displayed), and the quantity sold in each package. Click the _3-dot_ icon then _Edit_ next to any of the products.

   <img src="./images/03.png" width="700px" style="border: #000000 1px; solid;">

In the image above, the product has been given priority 1.0 which means it will be listed first. Assign the incremental values to the other products.

   <img src="./images/04.png" width="700px" style="border: #000000 1px; solid;">

Finally follow the rest of the steps found in [Creating a Simple Product](../creating-a-simple-product/README.md), such as adding SKUs and setting a base price. These are required when adding a Grouped Product to the catalog.

The new Grouped Product appears in the catalog. As long as each individual product has enough stock in the inventory, buyers can select the Grouped Product for purchase.

   <img src="./images/05.png" width="700px" style="border: #000000 1px; solid;">

## Additional Information

* [Introduction to Product Types](../introduction-to-product-types/README.md)
* [Creating a Simple Product](../creating-a-simple-product/README.md)
* [Creating a Virtual Product](../creating-a-virtual-product/README.md)