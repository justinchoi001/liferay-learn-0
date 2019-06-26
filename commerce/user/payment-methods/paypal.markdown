# Adding PayPal as a Payment Method

This article details how to enable PayPal as a payment method.


Before configuring your store to use PayPal, it is necessary to generate a PayPal Client ID and a Client Secret number. Go to [PayPal Developer Dashboard](https://developer.paypal.com/developer/applications/create) for more information.

1.  Navigate to _(your Commerce site) → Commerce → Settings → Payment Methods_.
2.  Click _PayPal_.
3.  Click _Configuration_.
4.  Enter the following:
    *   **Client ID**
    *   **Client Secret**
5.  Select _Live_ if it is a live site or _Sandbox_ if it is a test environment.
6.  In the _Payment Attempts Max Count_ field, enter the number of attempts to make payment on a subscription before cancelling the subscription. 
    * For more information, read PayPal's [Reattempt failed recurring payments with Subscribe buttons](https://developer.paypal.com/docs/classic/paypal-payments-standard/integration-guide/reattempt-failed-payment/) article.
7.  Click _Save_.
8.  Click the _3-dot icon_ next to _PayPal_ then _Activate_.

PayPal is now enabled for your store.

## Additional Information

Here is more information about adding other payment methods:

*   [{Authorize.net}](Authorize.net)
*   [{Mercanet}](Mercanet)
*   <a href="">Currencies Administration</a>
*   [Reattempt failed recurring payments with Subscribe buttons](https://developer.paypal.com/docs/classic/paypal-payments-standard/integration-guide/reattempt-failed-payment/)
*   <a href="">Learn how to add other 3rd party payment systems.</a>