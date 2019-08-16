# Implementing a New Basic Payment Method

This tutorial will show you how to add a new basic payment method by implementing  the `CommercePaymentMethod` interface.

Payment methods represent various ways customers can pay for orders. Liferay Commerce provides several out of the box payment methods including [Authorize.Net](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-payment-method-authorize-net/src/main/java/com/liferay/commerce/payment/method/authorize/net/internal/AuthorizeNetCommercePaymentMethod.java), [Mercanet](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-payment-method-mercanet/src/main/java/com/liferay/commerce/payment/method/mercanet/internal/MercanetCommercePaymentMethod.java), [Money Order](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-payment-method-money-order/src/main/java/com/liferay/commerce/payment/method/money/order/internal/MoneyOrderCommercePaymentMethod.java), and [PayPal](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-payment-method-paypal/src/main/java/com/liferay/commerce/payment/method/paypal/internal/PayPalCommercePaymentMethod.java).

![Out of the box payment methods](./images/01.png "Out of the box payment methods")

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example payment method up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.4
    ```

1. Download and unzip [Acme Commerce Payment Method](./liferay-b1c3.zip).

    ```bash
    curl liferay-b1c3.zip
    ```

    ```bash
    unzip liferay-b1c3.zip
    ```

1. Go to `b1c3-impl`.

    ```bash
    cd b1c3-impl
    ```

1. Build and deploy the example.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    >Note: This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.b1c3.impl_1.0.0
    ```

1. Verify that the example new basic payment method was added. Open your browser to `https://localhost:8080` and navigate to _Site Administration_ → _Commerce_ → _Settings_ → _Payment Methods_.

   ![New basic payment method](./images/02.png "New basic payment method")

Congratulations, you've successfully built and deployed a new basic payment method that implements `CommercePaymentMethod`.

Next, let's dive deeper to learn more.

## Walk Through the Example

In this section, we will take a more in-depth review of the example we deployed. First, we will annotate the class for OSGi registration; second we will implement the `CommercePaymentMethod` interface; and third, we will implement the payment method logic.

### Annotate the Class for OSGi Registration

```java
@Component(
	immediate = true,
	property = "commerce.payment.engine.method.key=" + B1C3CommercePaymentMethod.KEY,
	service = CommercePaymentMethod.class
)
public class B1C3CommercePaymentMethod implements CommercePaymentMethod {

	public static final String KEY = "Example";
```

>It is important to provide a distinct key for our payment method so that Liferay Commerce can distinguish our new payment method from others in the [payment method registry](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-payment-service/src/main/java/com/liferay/commerce/payment/internal/method/CommercePaymentMethodRegistryImpl.java). Reusing a key that is already in use will override the existing associated payment method.

### Implement the `CommercePaymentMethod` Interface

The following five methods are required:

```java
	public String getDescription(Locale locale);
```

```java
	public String getKey();
```

```java
	public String getName(Locale locale);
```

```java
	public int getPaymentType();
```

```java
	public String getServletPath();
```

To better understand each of the required methods mentioned above, let's look at [B1C3CommercePaymentMethod.java](./liferay-b1c3.zip/b1c3-impl/src/main/java/com/acme/b1c3/internal/commerce/payment/method/B1C3CommercePaymentMethod.java). We will review the implementation of each required method in sequence.

1. ```java
	@Override
	public String getDescription(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "this-is-the-example-payment-method");
	}
    ```

    >This method populates the "Description" column in the Payment Methods administration page. `ResourceBundleUtil` is a Liferay class that provides support for multiple locales. Visit [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application) for more information.

1. ```java
	@Override
	public String getKey() {
		return KEY;
	}
    ```

    >This provides a unique identifier for the payment method in the registry. The key can be used to fetch the payment method from the registry programmatically if necessary. Reusing a key that is already in use will override the existing associated payment method.

1. ```java
	@Override
	public String getName(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(
			resourceBundle, "example-payment-method");
	}
    ```

    >This populates the "Name" column in the Payment Methods administration page. `ResourceBundleUtil` is a Liferay class that provides support for multiple locales. Visit [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application) for more information.

1. ```java
	@Override
	public int getPaymentType() {
		return CommercePaymentConstants.COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE;
	}
    ```

    >This identifies how the payment engine will use a given payment method. In this example, `COMMERCE_PAYMENT_METHOD_TYPE_OFFLINE` informs the payment engine that there are no online processing requirements for this payment method. There are two other payment type constants available out of the box: `COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_STANDARD` and `COMMERCE_PAYMENT_METHOD_TYPE_ONLINE_REDIRECT`. For more information see [Implementing a New Online Payment Method](../implementing-a-new-online-payment-method/README.md).

1. ```java
	@Override
	public String getServletPath() {
		return null;
	}
    ```

    >When implementing an online payment method, a servlet may be required to enable proper interfacing with an external payment provider. Since no servlet path is required for an offline payment method, `getServletPath` should return `null`.

### Create the Payment Method

The following methods are necessary to define our custom payment method logic. There are many more methods that can be implemented that provide additional functionality, such as subscriptions, recurring payments, and refunds. These can be seen in [CommercePaymentMethod.java](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-api/src/main/java/com/liferay/commerce/payment/method/CommercePaymentMethod.java). These methods come in pairs: one method to enable and the other to implement a given piece of functionality.

```java
@Override
public boolean isCompleteEnabled() {
	return true;
}
```

>For the payment method to complete payments, this must return true. `completePayment` is invoked when the payment is fulfilled. This informs the payment engine what functionality is supported by our payment method.

```java
@Override
public CommercePaymentResult completePayment(
		CommercePaymentRequest commercePaymentRequest)
	throws Exception {

	return new CommercePaymentResult(
		null, commercePaymentRequest.getCommerceOrderId(),
		CommerceOrderConstants.PAYMENT_STATUS_PAID, false, null, null,
		Collections.emptyList(), true);
}
```

>This is where custom payment logic will be implemented.  `CommercePaymentResult` is a container that stores information relevant to the completion of a payment process. For more information see [CommercePaymentResult.java](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-api/src/main/java/com/liferay/commerce/payment/result/CommercePaymentResult.java).

```java
@Override
public boolean isProcessPaymentEnabled() {
	return true;
}
```

>For the payment method to process payments, this must return true. `processPayment` is the initial step that is executed when a customer submits an order. This informs the payment engine what functionality is supported by our payment method.

```java
@Override
public CommercePaymentResult processPayment(
		CommercePaymentRequest commercePaymentRequest)
	throws Exception {

	return new CommercePaymentResult(
		null, commercePaymentRequest.getCommerceOrderId(),
		CommerceOrderConstants.PAYMENT_STATUS_AUTHORIZED, false, null, null,
		Collections.emptyList(), true);
}
```

>This is where custom payment logic will be implemented. This `CommercePaymentResult` should store information relevant to the processing of a payment. For more information see [CommercePaymentResult.java](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-api/src/main/java/com/liferay/commerce/payment/result/CommercePaymentResult.java)

Lastly, define the language key for our payment method's name and description. Add the keys and their values to a [Language.properties](./liferay-b1c3.zip/b1c3-impl/src/main/resources/content/Language.properties) file within our module:

```
example=Example
this-is-the-example-payment-method=This is the Example Payment Method.
```

## Conclusion

Congratulations! You now know the basics for implementing the `CommercePaymentMethod` interface and have added a new basic payment method to Liferay Commerce.

## Additional Information

* [Implementing a New Online Payment Method](../implementing-a-new-online-payment-method/README.md)
* [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
