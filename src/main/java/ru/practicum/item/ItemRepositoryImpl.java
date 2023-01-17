package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository{
    private final Map<Long, Map<Long, Item>> items; //Map<userId, Map<itemId, Item>>

    @Override
    public List<Item> findByUserId(long userId) {
        return items.get(userId).values().stream().toList();
    }

    @Override
    public Item save(Item item) {
        if (items.containsKey(item.getUserId())) {
            items.get(item.getUserId()).put(item.getId(), item);
        } else {
            items.put(item.getUserId(), Map.of(item.getId(), item));
        }
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        items.get(userId).remove(itemId);
    }
}
