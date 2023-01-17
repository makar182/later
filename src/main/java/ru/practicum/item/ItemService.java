package ru.practicum.item;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface ItemService {
    List<Item> getItems(long userId);

    Item addNewItem(Long userId, Item item);

    void deleteItem(long userId, long itemId);
}
