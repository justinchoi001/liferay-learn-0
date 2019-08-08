# Checkout

The Checkout page is a required page that contains the _Checkout_ widget. This widget is populated once a buyer clicks _Checkout_ to submit an order. Custom checkout steps can also be implemented using extension points. To learn more see [Implementing a Custom Checkout Step](../../../../developer-guide/tutorial/implementing-a-custom-checkout-step/README.md).

<img src="./images/01.png" width="700px" style="border: #000000 1px solid;">

During the checkout process, there are several pages to enter the buyer's shipping and billing addresses and choose a shipment method. The last two pages are the _Order Summary_ and _Order Confirmation_.

## Entering a Shipping Address

<img src="./images/02.png" width="700px" style="border: #000000 1px solid;">

Note that if the buyer checks the _Use shipping address as billing address_, this will skip the Billing Address page.

## Selecting Shipping Method

<img src="./images/03.png" width="700px" style="border: #000000 1px solid;">

Shipping methods available to a buyer are configured by changing _Shipping Methods_ in _Control Panel_ → _(your site)_ → _Commerce_ → _Settings_ -> _Shipping Methods_. See [Using the Flat Rate Shipping Method](../../../sales/shipping/using-the-flat-rate-shipping-method/README.md) for more information.

## Entering a Billing Address

As noted above, this page appears only if the buyer's billing address is different from the shipping address.

<img src="./images/04.png" width="700px" style="border: #000000 1px solid;">

## Viewing the Order Summary

<img src="./images/05.png" width="700px" style="border: #000000 1px solid;">

## Confirming the Order

<img src="./images/06.png" width="700px" style="border: #000000 1px solid;">

When an order is confirmed, the order is ready for processing by the seller. See [Order Life Cycle](../../../sales/order-management/order-life-cycle/README.md) for more information.

## Additional Information

* [Widget Reference Guide](../widget-reference/README.md)
* [Creating Pages](https://help.liferay.com/hc/en-us/articles/360018171291-Creating-Pages)
* [Implementing a Custom Checkout Step](../../../../developer-guide/tutorial/implementing-a-custom-checkout-step/README.md)
* [Using the Flat Rate Shipping Method](../../../sales/shipping/using-the-flat-rate-shipping-method/README.md)
