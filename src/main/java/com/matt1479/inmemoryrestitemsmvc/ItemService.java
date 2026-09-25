package com.matt1479.inmemoryrestitemsmvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service 
public class ItemService {
    
    private final Map<Long, Item> itemRepository = new HashMap<Long, Item>();
    private final AtomicLong counter = new AtomicLong(1);

    public ItemService() { }

    public Collection<Item> getItems() {
        return itemRepository.values();
    }

    public Item getItem(Long id) {
        return itemRepository.get(id);
    }

    public Item createItem(Item item) {
        if (item == null) {
            return null;
        }

        Long id = counter.getAndIncrement();
        item.setId(id);
        itemRepository.put(id, item);
        return item;
    }

    public Item replaceItem(Item newItem, Long id) {
        if (newItem == null) {
            return null;
        }

        if (!itemRepository.containsKey(id)) {
            return null;
        }

        newItem.setId(id);
        itemRepository.put(id, newItem);
        return newItem;
    }

    public Item deleteItem(Long id) {
        return itemRepository.remove(id);
    }

}
