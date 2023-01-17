package ru.practicum.item;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ItemResponseDto {
    private Long id;
    private Long userId;
    private String url;
    private Set<String> tags;
}
