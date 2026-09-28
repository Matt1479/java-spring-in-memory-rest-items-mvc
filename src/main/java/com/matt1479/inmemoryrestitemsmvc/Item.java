package com.matt1479.inmemoryrestitemsmvc;

import java.util.Objects;

public class Item {
    
    private String description;
    private Long id;
    private String name;
    private Double price;
    
    public Item() { }

    public Item(String description, Long id, String name, Double price) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean hasMissingFieldsExceptId() {
        return description == null || description.isEmpty() || name == null
            || name.isEmpty() || price == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;
        return Objects.equals(this.description, item.description)
            && Objects.equals(this.id, item.id)
            && Objects.equals(this.name, item.name)
            && Objects.equals(this.price, item.price);
    }

}
