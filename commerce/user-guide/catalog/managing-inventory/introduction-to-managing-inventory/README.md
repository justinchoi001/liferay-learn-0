# Introduction to Managing Inventory

Liferay Commerce provides the tools to manage the product inventory. Liferay Commerce can scale for merchants with just a single store to those with multiple warehouses and stores. Store administrators can use these features to maintain quantities for sales and handle shipments to complete order.

To manage inventory, there are several key features that store administrators use: Warehouses, Availability Estimates, Low Stock Activity, Shipping, and the ability to set inventory by warehouse.

## Warehouses

See the [Warehouse Reference Guide](../warehouse-reference-guide/README.md) and the [Adding a New Warehouse](../adding-a-new-warehouse/README.md) article for more information about how to manage warehouses.

Warehouses must be associated for each channel. See the [Introduction to Channels](../../creating-and-managing-products/channels/introduction-to-channels/README.md) article on how channels work.

## Availablity Estimates

If a product becomes unavailable, store owners can inform customers how long before a product is availablea again. There are three default time periods in Liferay Commerce.

See the [Availability Estimates](../availability-estimates/README.md) article on how to configure the time periods.

## Low Stock Activity

When the number of products available in the inventory reaches a certain threshold, it can become impossible to fulfill the next orders. Liferay Commerce can set a low stock threshold then what action to execute, such as accepting back orders and removing the item temporarily from being displayed in the catalog.

See the [Inventory Reference Guide](../inventory-reference-guide/README.md) about the different settings.

See the [Low Stock Activity](../low-stock-activity/README.md) on how to configure what behavior Liferay Commerce executes when stocks reach a certain minimum number.

Developers interested in creating their own custom low stock activity can refer to [Implementing a Custom Low Stock Activity](../../../../developer-guide/tutorial/implementing-a-custom-low-stock-activity/README.md).

## Setting Inventory by Warehouse

It is important to ensure that the correct inventory quantities are set in each warehouse. In Liferay Commerce, inventory management is done per product SKU.

To learn more, read the [Setting Inventory by Warehouse](../setting-inventory-by-warehouse/README.md) article.

## Additional Information

Managing inventory is closely tied to Shipping. See the separate Shipping related articles for more information.

* Shipping