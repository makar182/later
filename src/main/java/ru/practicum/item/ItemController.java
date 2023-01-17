package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ItemResponseDto> get(@RequestHeader("X-Later-User-Id") long userId) {
        return itemService.getItems(userId).stream()
                .map(ItemMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Item add(@RequestHeader("X-Later-User-Id") Long userId,
                    @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.addNewItem(userId, ItemMapper.toEntity(itemRequestDto));
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}