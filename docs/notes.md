# Notes

Create a project that combines the concepts from [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service) and [Serving Web Content With Spring MVC](https://spring.io/guides/gs/serving-web-content). 

The project provides CRUD operations for items through a REST API and a server-rendered web interface using Spring MVC and Thymeleaf.

## Different Ways To Render Content With `th:each`

```html
<!-- Use this if you only have one field -->
<ul>
    <li th:each="item : ${items}"
        th:text="${item.name}"></li>
</ul>

<!-- Use this if you have multiple fields -->
<ul>
    <li th:each="item : ${items}">
        <span th:text="${item.name}"></span>
        <span th:text="${item.description}"></span>
    </li>
</ul>

<!-- Use this if you want it to be more generic -->
<!-- `th:each` means: repeat this element, including all of its contents,
    once for each item -->
<div th:each="item : ${items}">
    <h2 th:text="${item.name}"></h2>
    <p th:text="${item.description}"></p>
    <p>
        Price:
        <span th:text="${item.price}"></span>
    </p>
</div>
```

## `@ModelAttribute`

`@ModelAttribute` binds form data from an HTTP request to a Java object by matching form field names to the object's properties. It creates/populates the object and makes it available as a method parameter.

In other words, `@ModelAttribute` ≈ Flask's `request.form` + automatically populating a Java object.

Example:
```java
@PostMapping("...")
public String create(@ModelAttribute Object o) { ... }
```

## Spring's Hidden Method Support

Add the following to [application.properties](/src/main/resources/application.properties):

```
spring.mvc.hiddenmethod.filter.enabled=true
```

Then you can use the following (e.g. DELETE method):

```html
<form th:action="..." method="post">
    <input name="_method" type="hidden" value="delete">
    ...
</form>
```
