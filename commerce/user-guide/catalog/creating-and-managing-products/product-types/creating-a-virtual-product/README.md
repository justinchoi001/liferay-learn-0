# Creating a Virtual Product

A virtual product is any non-physical product. For example, the product is downloaded rather than shipped: a music file, a video, or an electronic publication. Virtual products could also include warranties and service contracts.

Note that when creating a Virtual Product in Liferay Commerce, there is an extra tab (_Virtual_) in its product tab bar which contains necessary configurations.

## Roadmap

* Create a Virtual Product
* Associate Digital Assets
* Apply Product Options
* Set Prices and Quantities
* Upload Product Images and Attachments
* Organize with Categories
* Associate with Related Products

### Create a Virtual Product:

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click the (+) button then _Virtual_.
1. Enter the following:
    * **Catalog**: Sahara.com
    * **Name**: 3 Year Warranty
    * **Short Description**: 3 Year Warranty
    * **Full Description**: 3 Year Warranty for all products purchased on Sahara.com
    * **Friendly URL**: (auto-generated)
    * **Meta Title**: 3 year Warranty
    * **Meta Description**: 3 year Warranty for all products
    * **Meta Keywords**: warranty, goods, year
1. Click _Publish_.

Once this virtual product has been created initially, store administators need to associate the digital asset and legal rights with the product. 

### Associate Digital Assets

1. Click the _Virtual_ sub-tab to continue.

   <img src="./images/01.png" width="700px" style="border: #000000 1px; solid;">

1. Enter the following:
    * **Insert the URL or select a file of your virtual product.**: Upload warranty.pdf
    * **Activation Status**: Completed
    * **Duration**: 0
    * **Max Number of Downloads**: 0
    * **Enable Sample**: unchecked
    * **Enable Terms of Use**: No

   <img src="./images/02.png" width="700px" style="border: #000000 1px; solid;"> 

1. Click _Save_.

For more information about each field, see the [Virtual Product Reference](../virtual-product-reference/README.md) article.

### Apply Product Options

You can apply [Product Options](../../customizing-your-product-with-product-options/README.md) templates to the virtual product. For example, an e-book might have alternate front covers depending on different markets.

Click the _Options_ sub-tab to continue.

### Set Price and Quantities

Usually, virtual products such as a music or video file, electronic publications, warranties, or service contracts are unique and thus might not have multiple product variations (multiple SKUs). Virtual products can still be sold in a batch liked a Grouped Product. 

To set product prices and quantities:

1. Click the _3-dot_ icon then _Edit_ next to _default_. (At this point, you can rename the SKU to something more descriptive like _3 Year Warranty_ on the _Details_ menu.)
1. Click _Pricing_ on the left menu.
1. Enter the following:
    * **Price**: 12.00
    * **Promo Price**:
    * **Cost**: 
1. Click _Save_. (If Promo Price and Cost fields are left as 00, no discounts or promotions are applied at this point.)
1. Click _Price List_ to apply this product to any existing [Price Lists](../../../managing-price/price-lists/adding-products-to-a-price-list/README.md).

The _Inventory_ menu is where store administrators manage the number of products available for sale in each warehouse. (If you had used the Minium Accelerator to create the store with sample data, there are three warehouses already created.)  

1. Click _Inventory_ on the left menu.
1. Enter a quantity for the corresponding warehouses.
1. Click _Save_.
1. Repeat these steps for the all the other product variants (SKUs) associated with this product.

### Add Product Specifications

[Product specifications](../../product-information/specifications/README.md) contain useful pieces of product information about the product, such as dimensions, color, weight, capacity, or almost any other attribute. Click the _Specifications_ sub-tab to add specifications.

### Upload Product Images and Attachments

[Product images](../../product-information/product-images/README.md) help to ensure that customers know what they are buying. Each product variant (SKU) can have their own associated product image. Click the _Images_ sub-tab to add all product images.

Store administrators can also add attachments that are associated with a particular product. Click the _Attachments_ sub-tab to add documents.   

### Organize with Categories

[Product Categories](../../categories/creating-a-new-product-category/README.md) are a great way to organize your products. Product categories could be used to apply discounts or other offers to a set of products, to assist buyers in finding products, or to promote certain products to a specified account or account group. 

### Associate with Related Products

[Product Relations](../../product-information/product-relations/README.md) can be used to connect products. Once connected, a product displays the links to other products. Every related product must be assigned to a Product Relation Type.


## Additional Information

* [Introduction to Product Types](../introduction-to-product-types/README.md)
* [Creating a Grouped Product](../creating-a-grouped-product/README.md)
* [Creating a Simple Product](../creating-a-simple-product/README.md)
* [Virtual Product Reference](../virtual-product-reference/README.md)