# Implementing a Custom Checkout Step

This tutorial will show you how to add a custom checkout step by implementing the `CommerceCheckoutStep` interface.

A checkout step represents one screen of the checkout process for a customer. Liferay Commerce provides several checkout steps out of the box, including essential steps like [the payment method step](https://github.com/liferay/com-liferay-commerce/blob/2.0.3/commerce-checkout-web/src/main/java/com/liferay/commerce/checkout/web/internal/util/PaymentMethodCommerceCheckoutStep.java) and the [order confirmation step](https://github.com/liferay/com-liferay-commerce/blob/2.0.3/commerce-checkout-web/src/main/java/com/liferay/commerce/checkout/web/internal/util/OrderConfirmationCommerceCheckoutStep.java).

![Out of the box checkout steps](./images/01.png "Out of the box checkout steps")

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example checkout step up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.3
    ```

1. Download and unzip [Acme Commerce Checkout Step](./liferay-n8n6.zip).

    ```bash
    curl liferay-n8n6.zip
    ```

    ```bash
    unzip liferay-n8n6.zip
    ```

1. Go to `n8n6-impl`.

    ```bash
    cd n8n6-impl
    ```

1. Build and deploy the example.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    >Note: This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.n8n6.impl_1.0.0
    ```

1. Verify that the example checkout step was added. Open your browser to `https://localhost:8080` and navigate to a catalog on any Liferay Commerce site. Add an item to the cart, view the cart, and then click "Checkout". The new "Example Step" will be present in the list of checkout steps.

![New checkout step](./images/02.png "New checkout step")

Congratulations, you've successfully built and deployed a new checkout step that implements `CommerceCheckoutStep`.

Next, let's dive deeper to learn more.

## Walk Through the Example

In this section, we will review the example we deployed. First, we will annotate the class for OSGi registration; second, we will implement the `CommerceCheckoutStep` interface; and third, we will implement the rendering logic and add a JSP for the new screen.

### Annotate the Class for OSGi Registration

```java
@Component(
    immediate = true,
    property = {
        "commerce.checkout.step.name=" + N8N6CommerceCheckoutStep.NAME,
        "commerce.checkout.step.order:Integer=21"
    },
    service = CommerceCheckoutStep.class
)
public class N8N6CommerceCheckoutStep extends BaseCommerceCheckoutStep {

    public static final String NAME = "example-step";
```

> The checkout step name should be a unique value so that Liferay Commerce can distinguish our checkout step from existing checkout steps.
>
> The `commerce.checkout.step.order` value indicates how far into the checkout process the checkout step will appear. For example, the [shipping method checkout step](https://github.com/liferay/com-liferay-commerce/blob/2.0.3/commerce-checkout-web/src/main/java/com/liferay/commerce/checkout/web/internal/util/ShippingMethodCommerceCheckoutStep.java) has a value of 20. Giving our checkout step a value of 21 ensures that it will appear immediately after the shipping method step.

### Implement the `CommerceCheckoutStep` Interface

We can extend a base class to give us functionality to build on top of: [BaseCommerceCheckoutStep](https://github.com/liferay/com-liferay-commerce/blob/2.0.3/commerce-api/src/main/java/com/liferay/commerce/util/BaseCommerceCheckoutStep.java). This simplifies our work to implement this interface.

The following three methods are required in addition to extending the base class:

```java
public String getName();
```

```java
public void processAction(
        ActionRequest actionRequest, ActionResponse actionResponse)
    throws Exception;
```

```java
public void render(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
    throws Exception;
```

Let's look at [N8N6CommerceCheckoutStep.java](./liferay-n8n6.zip/n8n6-impl/src/main/java/com/acme/n8n6/internal/commerce/util/N8N6CommerceCheckoutStep.java) to review the implementation of each required method in sequence.

1. ```java
    @Override
    public String getName() {
        return NAME;
    }
   ```

    > This method returns the name of our checkout step. This name may be a language key that corresponds to the name that will appear in the UI.
    >
    > We need to add the language key for the name to display correctly. See [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application) for more information.

1. ```java
    @Override
    public void processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
    }
   ```

    > If backend processing is required, use the `processAction` method to implement business logic with the information passed through the `ActionRequest`.

1. ```java
    public void render(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
        throws Exception {
    }
   ```

    > This will be where we add the code to render a customized screen for our checkout step.

### Create the Checkout Step

First add the implementation for the `processAction` and `render` methods and then add a JSP to render the screen for the new checkout step. Our example will display text on a custom screen, so we do not need any backend processing in the `processAction` implementation.

```java
@Override
public void render(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
    throws Exception {

    _jspRenderer.renderJSP(
        _servletContext, httpServletRequest, httpServletResponse,
        "/terms_and_conditions.jsp");
}
```

> We use a `JSPRenderer` to render the JSP for our checkout step (in this case, [terms_and_conditions.jsp](./liferay-n8n6.zip/n8n6-impl/src/main/resources/META-INF/resources/terms_and_conditions.jsp)). We also give it a `ServletContext` parameter to give a context for where to find the JSP we have created.

Define the `ServletContext` using the symbolic name of our bundle so that it can find the JSP in our module:

```java
@Reference(target = "(osgi.web.symbolicname=com.acme.n8n6.impl)")
private ServletContext _servletContext;
```

> The value we have set here for `osgi.web.symbolicname` matches the value for `Bundle-SymbolicName` in our [bnd.bnd file](./liferay-n8n6.zip/n8n6-impl/bnd.bnd). These values must match for the `ServletContext` to locate the JSP.
>
> We also need to declare a unique value for `Web-ContextPath` in our bnd.bnd file so the `ServletContext` is correctly generated. In our example, `Web-ContextPath` is set to `/commerce-checkout-step`. See [bnd.bnd](./liferay-n8n6.zip/n8n6-impl/bnd.bnd) for a reference on these values.

Next, define the JSP for our checkout step's screen in the UI. In our example, we are adding placeholder text; you can see the implementation at [terms_and_conditions.jsp](./liferay-n8n6.zip/n8n6-impl/src/main/resources/META-INF/resources/terms_and_conditions.jsp).

Lastly, define the language key for the name of our new checkout step. Add the key and its value to a [Language.properties](./liferay-n8n6.zip/n8n6-impl/src/main/resources/content/Language.properties) file within our module:

```
example-step=Example Step
```

## Conclusion

Congratulations! You now know the basics for implementing the `CommerceCheckoutStep` interface, and have added a new checkout step to Liferay Commerce.

## Additional Information

* [Checkout](../../../user-guide/content/pages/checkout/README.md)
* [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
