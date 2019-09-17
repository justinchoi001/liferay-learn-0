# Managing Product Visibility

Liferay Commerce allows store managers to create a publication schedule for when a product is first published in a catalog. Conversely, store managers can schedule a time when the product is no longer available for sale by setting an expiration date.

Note that unpublishing (that is, reverting to a draft status) or expiring a product does not delete the product. The product information is still stored in the database. Instead, a search does not return the product on the main _Catalog_ page.

Furthermore, unpublishing a product may be configured to happen automatically if the product's inventory falls below the minimum threshold; for more information, see the article on [Low Stock Activity](./low-stock-activity.md).

## Unpublishing a Product

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_).
    > Expand the _Schedule_ section if necessary.
1. Uncheck the _Published_ checkbox.

    ![Unchecked Published box](./managing-product-visibility/images/01.png)

1. Click _Publish_.
1. Navigate to the store site.
1. Search for the product (_U-Joint_ in this example).

![Unpublished U-Joint](./managing-product-visibility/images/02.png)

The product is not searchable in the catalog.

## Expiring a Product

Expiring a product works in a similar fashion. When a product has an expiration date, the product is no longer visible in the store's front page. To expire a product:

1. Navigate to _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_).
1. Uncheck the _Never Expire_ checkbox.
1. Enter an expiration date and time.

    ![Setting a Product's Expiration Date](./managing-product-visibility/images/03.png)

1. Click _Publish_.

After the expiration date, the product will be not returned when searching on the _Catalog_ page. To make the product visible again, enter a new expiration date in the future and republish the product.

## Additional Information

* [Introduction to Product Types](./introduction-to-product-types.md)
* [Creating a Simple Product](./creating-a-simple-product.md)
* [Creating a Grouped Product](./creating-a-grouped-product.md)
* [Creating a Virtual Product](./creating-a-virtual-product.md)
* [Low Stock Activity](./low-stock-activity.md)