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

## Roadmap

* Creating a Grouped Product
* Associate Products in Group
* Apply Product Options
* Generate SKUs
* Set Prices and Quantities in the Inventory
* Configure Product Specifications
* Upload Product Images and Attachments
* Organize with Categories
* Associate with Related Products
* Selling Grouped Products

### Creating a Grouped Product

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

Once the Grouped Product has been created initially, you need to associate the individual products to be sold as this one unit. 

### Associate Products in Group

1. Click the _Grouped_ sub-tab.

   <img src="./images/01.png" width="700px" style="border: #000000 1px; solid;">

1. Click the (+) button to add a Grouped Entry.
1. Select the following products: _Dog Hair Brush_, _Dog Nail File_, and _Dog Shampoo_.
1. Click _Add_.

    <img src="./images/02.png" width="700px" style="border: #000000 1px; solid;">

Next, specify the priority (the order in which they are displayed), and the quantity sold in each package. Click the _3-dot_ icon then _Edit_ next to any of the products.

   <img src="./images/03.png" width="700px" style="border: #000000 1px; solid;">

In the image above, the product has been given priority 1.0 which means it will be listed first. Assign the incremental values to the other products.

   <img src="./images/04.png" width="700px" style="border: #000000 1px; solid;">

### Apply Product Options

[Product Options](../../customizing-your-product-with-product-options/README.md) provide an easy and flexible way to offer products that have a variety of options such as size, quantity, and color. Click the _Options_ sub-tab to add various options to the product.

### Generate SKUs 

Once you have applied product options to the product, SKUs have to be generated. For more information about how to generate SKUs, see the article [Adding SKUs to Your Products](../../adding-skus-to-your-products/README.md). Click the _SKUs_ sub-tab to generate the SKUs.

### Set Prices and Quantities in the Inventory

After the SKUs have been generated, set the base price and quantities in the inventory for each item. Depending on how many SKUs were generated based on the various product options, each SKU can have its own prices. Some products are sold in bulk quantities while others are sold individually. 

To set product prices and quantities:

1. Click the _3-dot_ icon then _Edit_ next to _default_. (At this point, you can rename the SKU to something more descriptive like _Dog Grooming Kit_ on the _Details_ menu.)
1. Click _Pricing_ on the left menu.
1. Enter the following:
    * **Price**: 21.00
    * **Promo Price**:
    * **Cost**: 

    <img src="./images/06.png" width="700px" style="border: #000000 1px; solid;">

1. Click _Save_. (If Promo Price and Cost fields are left as 0.00, no discounts or promotions are applied at this point.)
1. Click _Price List_ to apply this product to any existing [Price Lists](../../../managing-price/price-lists/adding-products-to-a-price-list/README.md).

The _Inventory_ menu is where store administrators manage the number of products available for sale in each warehouse. (If you had used the Minium Accelerator to create the store with sample data, there are three warehouses already created.)  

1. Click _Inventory_ on the left menu.
1. Enter a quantity for the corresponding warehouses.
1. Click _Save_.
1. Repeat these steps for the all the other product variants (SKUs) associated with this product.

    <img src="./images/07.png" width="700px" style="border: #000000 1px; solid;"> 

### Configure Product Specifications

[Product specifications](../../product-information/specifications/README.md) contain useful pieces of product information about the product, such as dimensions, color, weight, capacity, or almost any other attribute. Click the _Specifications_ sub-tab to add specifications.

### Upload Product Images and Attachments

[Product images](../../product-information/product-images/README.md) help to ensure that customers know what they are buying. Each product variant (SKU) can have their own associated product image. Click the _Images_ sub-tab to add all product images.

Store administrators can also add attachments that are associated with a particular product. Click the _Attachments_ sub-tab to add documents.   

### Organize with Categories

[Product Categories](../../categories/creating-a-new-product-category/README.md) are a great way to organize your products. Product categories could be used to apply discounts or other offers to a set of products, to assist buyers in finding products, or to promote certain products to a specified account or account group. 

### Associate with Related Products

[Product Relations](../../product-information/product-relations/README.md) can be used to connect products. Once connected, a product displays the links to other products. Every related product must be assigned to a Product Relation Type.

### Selling Grouped Products

The new Grouped Product appears in the catalog. As long as each individual product has enough stock in the inventory, buyers can select the Grouped Product for purchase.

   <img src="./images/05.png" width="700px" style="border: #000000 1px; solid;">

## Additional Information

* [Introduction to Product Types](../introduction-to-product-types/README.md)
* [Creating a Simple Product](../creating-a-simple-product/README.md)
* [Creating a Virtual Product](../creating-a-virtual-product/README.md)