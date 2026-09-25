package com.matt1479.inmemoryrestitemsmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class ItemWebController {

    private final ItemService itemService;

    public ItemWebController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/items")
    public String getItems(Model model) {
        // A key value pair of ("items", itemService.getItems()) is added to
        // a Model object, making it accessible to the view template
        model.addAttribute("items", itemService.getItems());

        // Resolves to: templates/items.html
        return "items";
    }

    @GetMapping("/items/{id}")
    public String getItem(@PathVariable Long id, Model model) {
        // TODO: if item not found, redirect, flash a message

        model.addAttribute("id", id);
        model.addAttribute("item", itemService.getItem(id));
        return "item";
    }

    @GetMapping("/items/new")
    public String createItemForm() {
        return "create-item";
    }

    @PostMapping("/items/new")
    public String createItem(@ModelAttribute Item item) {
        // TODO: if any field is empty, redirect, flash a message

        itemService.createItem(item);
        return "redirect:/items";
    }

    @GetMapping("/items/{id}/edit")
    public String editItemForm(@PathVariable Long id, Model model) {
        // TODO: if item not found, redirect, flash a message

        model.addAttribute("id", id);
        model.addAttribute("item", itemService.getItem(id));
        return "edit-item";
    }

    @PostMapping("/items/{id}/edit")
    public String editItem(@PathVariable Long id, @ModelAttribute Item item) {
        // TODO: if item not found, redirect, flash a message
        // TODO: if any field is empty, redirect, flash a message

        itemService.replaceItem(item, id);
        return "redirect:/items";
    }
    
    @DeleteMapping("/items/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        // TODO: if item not found, redirect, flash a message

        itemService.deleteItem(id);
        return "redirect:/items";
    }

}
