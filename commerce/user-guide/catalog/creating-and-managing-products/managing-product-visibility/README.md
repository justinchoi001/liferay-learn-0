# Managing Product Visibility

Liferay Commerce allows store managers to create a publication schedule for when a product is first appears in a catalog. Conversely, store managers can schedule a time when the product is no longer available for sale by setting an expiration date.

Here are some important terms:

* **Published**: The product is now live with all the necessary metadata already filled out in the _Products_ menu on the _Control Panel_. The product is immediately searchable and purchasable on the Catalog page.
* **Unpublished**: The product is no longer searchable on the Catalog Page. This can be configured either manually or automatically if the product's inventory falls below the minimum threshold; for more information, see the article on [Low Stock Activity](../../managing-inventory/low-stock-activity/README.md).
* **Draft**: The product and its associated metadata have not yet been finalized for publication. Thus, it is not searchable on the Catalog Page.
* **Expired**: The product is not searchable after a certain date set by the store administrator. In the _Control Panel_'s _Products_ menu, the _Expired_ status appears in the _Status_ column.
* **Display Date**: The date the product first appears on the Catalog page. This date can be the same day the product is published or a future date.

Note 1: Unpublishing or expiring a product does _not_ delete the product. The product information is still stored in the database. Besides being unsearchable, using the product's bookmark or friendly URL will display a _The requested resource could not be found._ message.

Note 2: If an item is _already_ in the Checkout cart and it is marked as Unpublished after it has already been placed in the cart, buyers can still proceed with the purchase.

## Unpublishing a Product

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_).
    > Expand the _Schedule_ section if necessary.
1. Uncheck the _Published_ checkbox.

    ![Unchecked Published box](./images/01.png)

1. Click _Publish_.
1. Navigate to the store site.
1. Search for the product (_U-Joint_ in this example).

![Unpublished U-Joint](./images/02.png)

The product is no longer searchable in the catalog.

## Expiring a Product

To expire a product:

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_).
1. Uncheck the _Never Expire_ checkbox.
1. Enter an expiration date and time.

    ![Setting a Product's Expiration Date](./images/03.png)

1. Click _Publish_.

After the expiration date, the product will be not searchable and displayed on the _Catalog_ page. To make the product visible again, enter a new expiration date in the future and click _Publish_ to display the product again.

## Additional Information

* [Introduction to Product Types](../product-types/introduction-to-product-types/README.md)
* [Creating a Simple Product](../product-types/creating-a-simple-product/README.md)
* [Creating a Grouped Product](../product-types/creating-a-grouped-product/README.md)
* [Creating a Virtual Product](../product-types/creating-a-virtual-product/README.md)
* [Low Stock Activity](../../managing-inventory/low-stock-activity/README.md)
