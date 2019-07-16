# Payments

Payments are processed through a Payment Method. There are three types of payment method:

**Offline**: Liferay Commerce does not process payment (for example, a buyer might pay in cash when picking up a product that has been shipped to a local store).

**Online Standard**: Payment is processed entirely by Liferay Commerce. This option is not available out-of-the-box but can be customized using the [Payment Method SPI]().

**Online Redirect**: Liferay Commerce passes information to a third-party payment processor, redirecting the buyer to the processor's website to complete payment.

Liferay Commerce ships with four payment methods. One---Money Order---is an offline method while the others---Authorize.net, Mercanet, and Paypal---redirect buyers to a third-party website. Additional methods can be added using the [Payment Method SPI]().

To use a payment method, you must configure it and set it to _Active_. Configuring a Redirect method requires information you'll obtain from the relevant third-party processor.

## Additional Information

* [Authorize.net](../sales/payment-methods/authorize.net/README.md)
* [Mercanet](../sales/payment-methods/mercanet/README.md)
* [Money Orders](../sales/payment-methods/money-orders/README.md)
* [PayPal](../sales/payment-methods/paypal/README.md)