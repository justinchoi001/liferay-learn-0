# Low Stock Activity

This article documents steps on how to set up automatic actions whenever a product’s inventory falls below a certain level. Setting up these steps in advance has the benefit of communicating quickly to customers that an order may not be able to be fulfilled due to low stock while ensuring them that the product might be available again in sufficient quantities in the near future. Store owners can also configure the catalog to display how many products are remaining.

To set the Low Stock Activity:

1. Navigate to the _Control Panel_ → _Commerce_ → _Products_.
1. Click on a product (for example, _U-Joint_)(This sample product was created by the Minium Accelerator).
1. Click the _Configurations_ sub-tab.
1. Enter the following:
    * **Inventory Engine**: Default
    * **Availability Estimate**: 5-7 Days
    * **Display Availability**: YES
    * **Display Stock Quantity**: YES
    * **Low Stock Threshold**: 5
    * **Low Stock Action**: Set as Unpublished
    * **Allow Back Orders**: Yes
    * **Minimum Order Quantity**: 1
    * **Maximum Order Quantity**: 5
    * **Allowed Order Quantities**: 1
    * **Multiple Order Quantity**: 1

    <img src="./images/01.png" width="700px" style="borders: #000000 1px solid;">

1. Click _Save_.

The Low Stock Activity for this product has been configured. In the future, should the number of stock fall below the specified number, the automatic rules will be triggered.


## Additional Information

Developers can implement a custom extension point to add additional types of behaviors when a product's inventory falls below the threshold.

* [Implementing a Low Stock Activity](../../../../developer-guide/tutorial/implementing-a-custom-low-stock-activity/README.md)