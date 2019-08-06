# Implementing a Custom Order Validator

This tutorial will show you how to add a custom order validator by implementing the `CommerceOrderValidator` interface.

An order validator is a class that validates items in a customer's cart when proceeding through checkout. Liferay Commerce provides multiple out of the box order validators, including a [default](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-service/src/main/java/com/liferay/commerce/internal/order/DefaultCommerceOrderValidatorImpl.java), as well as validators to check [item versions](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-service/src/main/java/com/liferay/commerce/internal/order/VersionCommerceOrderValidatorImpl.java) and [recurring items (subscriptions)](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-service/src/main/java/com/liferay/commerce/internal/order/SubscriptionCommerceOrderValidatorImpl.java).

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example order validator up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.2
    ```

1. Download and unzip [Acme Commerce Order Validator](./liferay-n9b2.zip).

    ```bash
    curl liferay-n9b2.zip
    ```

    ```bash
    unzip liferay-n9b2.zip
    ```

1. Go to `n9b2-impl`.

    ```bash
    cd n9b2-impl
    ```

1. Build and deploy the example.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    > Note: This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.n9b2.internal.commerce.order_1.0.0
    ```

1. Verify that the example order validator was added by viewing the failure message. Open your browser to `https://localhost:8080` and navigate to a catalog with at least one item priced over $100. If one does not exist, you may need to add it yourself; see [Products](https://commerce.liferay.dev/user-guide/-/knowledge_base/user/products) for more information on this.

    Once in the catalog, search for the item with this price, then click "Add to Cart". Increase the quantity to 11 or more, then click the arrow to continue. The error message that appears shows that the custom order validator successfully rejected adding the item.

    ![New order validation error message](./images/01.png "New order validation error message")

Next, let's dive deeper to learn more.

## Walk Through the Example

In this section, we will take a more in-depth review of the example we deployed. First, we will annotate the class for OSGi registration; second we will implement the `CommerceOrderValidator` interface; and third, we will implement the custom validation logic.

### Annotate the Class for OSGi Registration

```java
@Component(
    immediate = true,
    property = {
        "commerce.order.validator.key=" + N9B2CommerceOrderValidator.KEY,
        "commerce.order.validator.priority:Integer=9"
    },
    service = CommerceOrderValidator.class
)
public class N9B2CommerceOrderValidator implements CommerceOrderValidator {

    public static final String KEY = "Example";
```

> It is important to provide a distinct key for our order validator so that Liferay Commerce can distinguish the new order validator from others in the [order validator registry](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-service/src/main/java/com/liferay/commerce/internal/order/CommerceOrderValidatorRegistryImpl.java). Reusing a key that is already in use will override the existing associated validator.

### Implement the `CommerceOrderValidator` Interface

The following three methods are required:

```java
public String getKey();
```

```java
public CommerceOrderValidatorResult validate(Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance, int quantity) throws PortalException;
```

```java
public CommerceOrderValidatorResult validate(Locale locale, CommerceOrderItem commerceOrderItem) throws PortalException;
```

To better understand each of the required methods mentioned above, let's look at [N9B2CommerceOrderValidator.java](./liferay-n9b2.zip/n9b2-impl/src/main/java/com/acme/n9b2/internal/commerce/order/validator/N9B2CommerceOrderValidator.java). We will review the implementation of each required method in sequence.

1. `public String getKey();`

    ```java
    @Override
    public String getKey() {
        return KEY;
    }
    ```

    > This method provides a unique identifier for the order validator in the registry. The key can be used to fetch the validator from the registry programmatically if necessary. Reusing a key that is already in use will override the existing associated validator.

1. `public CommerceOrderValidatorResult validate(
            Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance, int quantity)
        throws PortalException;`

    ```java
    @Override
    public CommerceOrderValidatorResult validate(
            Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance,
            int quantity)
        throws PortalException {

        if (cpInstance == null) {
            return new CommerceOrderValidatorResult(false);
        }

        return new CommerceOrderValidatorResult(true);
    }
    ```

    > This is one of the two validation methods where we will add our custom validation logic. This method is called whenever a customer adds an item to their cart. It does this by returning a `CommerceOrderValidatorResult`, which uses a boolean to determine whether or not the result passes validation; see this class at [CommerceOrderValidatorResult.java](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-api/src/main/java/com/liferay/commerce/order/CommerceOrderValidatorResult.java).
    >
    > Note that this dummy implementation only has a simple check for a null value, which is a standard first step for this method.

1. `public CommerceOrderValidatorResult validate(Locale locale, CommerceOrderItem commerceOrderItem) throws PortalException;`

    ```java
    @Override
    public CommerceOrderValidatorResult validate(
            Locale locale, CommerceOrderItem commerceOrderItem)
        throws PortalException {

        return new CommerceOrderValidatorResult(true);
    }
    ```

    > This is the second validation method where we can add custom validation logic. This method is called for items already in the cart, whenever a customer proceeds to a new step in checkout.

### Create the Validation Steps

The two `validate` methods are where we define the custom validation logic for our order validator. In our simple example, we will add logic to reject orders with more than ten of an item over a certain price.

1. `public CommerceOrderValidatorResult validate(Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance, int quantity)`

    ```java
    @Override
    public CommerceOrderValidatorResult validate(
            Locale locale, CommerceOrder commerceOrder, CPInstance cpInstance,
            int quantity)
        throws PortalException {

        if (cpInstance == null) {
            return new CommerceOrderValidatorResult(false);
        }

        BigDecimal price = cpInstance.getPrice();

        if ((price.doubleValue() > 100.0) && (quantity > 10)) {
            ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", locale, getClass());

            return new CommerceOrderValidatorResult(
                false,
                LanguageUtil.get(
                    resourceBundle, "this-item-has-a-maximum-quantity-of-10"));
        }

        return new CommerceOrderValidatorResult(true);
    }
    ```

    > After a standard null check for this method, the main validation check for our example is to check if both the price (stored as a `BigDecimal`) is more than $100, and the quantity is greater than ten. We get the price information from the CPInstance, which contains information about the order the customer has added; to find more methods you can use with a `CPInstance`, see [CPInstance](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-api/src/main/java/com/liferay/commerce/product/model/CPInstance.java) and [CPInstanceModel](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-api/src/main/java/com/liferay/commerce/product/model/CPInstanceModel.java).
    >
    > Note that, for the main validation checks, it is best practice to include a localized message explaining why the validation failed. For this to work correctly using `LanguageUtil`, we will need to add the language key ourselves. For more information, see [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application).

1. `public CommerceOrderValidatorResult validate(Locale locale, CommerceOrderItem commerceOrderItem)`

    ```java
    @Override
    public CommerceOrderValidatorResult validate(
            Locale locale, CommerceOrderItem commerceOrderItem)
        throws PortalException {

        BigDecimal price = commerceOrderItem.getUnitPrice();

        if ((price.doubleValue() > 100.0) &&
            (commerceOrderItem.getQuantity() > 10)) {

            ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", locale, getClass());

            return new CommerceOrderValidatorResult(
                false,
                LanguageUtil.get(
                    resourceBundle,
                    "expensive-items-have-a-maximum-quantity-of-10"));
        }

        return new CommerceOrderValidatorResult(true);
    }
    ```

    > We can add the same validation logic to this method, since it will be called for the items in the customer's cart. The main difference in this case is we get the information from a `CommerceOrderItem` object; to find more methods you can use with a `CommerceOrderItem`, see [CommerceOrderItem](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-api/src/main/java/com/liferay/commerce/model/CommerceOrderItem.java) and [CommerceOrderItemModel](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-api/src/main/java/com/liferay/commerce/model/CommerceOrderItemModel.java).

We will also need to add the language keys for our validator's error messages. Add the keys and their values to a Language.properties file within our module:

```
expensive-items-have-a-maximum-quantity-of-10=Expensive items have a maximum quantity of 10.
this-item-has-a-maximum-quantity-of-10=This item has a maximum quantity of 10.
```

## Conclusion

Congratulations! You now know the basics for implementing the `CommerceOrderValidator` interface, and have added a new order validator to Liferay Commerce.

## Additional Information

* [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
* [Products](https://commerce.liferay.dev/user-guide/-/knowledge_base/user/products)
