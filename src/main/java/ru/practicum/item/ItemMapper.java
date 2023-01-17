package ru.practicum.item;

import org.springframework.stereotype.Component;

public class ItemMapper {
    public static ItemResponseDto toResponseDto(Item item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .userId(item.getUserId())
                .url(item.getUrl())
                .tags(item.getTags())
                .build();
    }

    public static Item toEntity(ItemRequestDto itemRequestDto) {
        return Item.builder()
                .userId(itemRequestDto.getUserId())
                .url(itemRequestDto.getUrl())
                .tags(itemRequestDto.getTags())
                .build();
    }
}
