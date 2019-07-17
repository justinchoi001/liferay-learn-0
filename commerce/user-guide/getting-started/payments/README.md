# Payments

Payments are processed through a Payment Method. There are three types of payment methods:

**Offline**: Liferay Commerce does not process payment (for example, a buyer might pay in cash when picking up a product that has been shipped to a local store).

**Online Standard**: Payment is processed entirely by Liferay Commerce. This option is not available out-of-the-box but can be customized using the Payment Method extension point.

**Online Redirect**: Liferay Commerce passes information to a third-party payment processor, redirecting the buyer to the processor's website to complete payment.

Liferay Commerce ships with four payment methods. Money Order is an offline method. Authorize.net, Mercanet, and Paypal redirect buyers to a third-party website. Additional methods can be added using the Payment Method extension point.

## Additional Information

* [Managing Payment Methods](./managing-payment-methods/README.md)
