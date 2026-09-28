package com.matt1479.inmemoryrestitemsmvc;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// A controller is used for handling HTTP requests
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/items")
    public Collection<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/api/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemService.getItem(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    @PostMapping("/api/items")
    public Item createItem(@RequestBody Item item) {
        if (item.hasMissingFieldsExceptId()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "description, name, and price are required"
            );
        }

        return itemService.createItem(item);
    }
    
    @PutMapping("/api/items/{id}")
    public Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        if (itemService.getItem(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (newItem.hasMissingFieldsExceptId()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "description, name, and price are required"
            );
        }

        return itemService.replaceItem(newItem, id);
    }

    @DeleteMapping("/api/items/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id) {
        if (itemService.getItem(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(itemService.deleteItem(id));
    }

}
