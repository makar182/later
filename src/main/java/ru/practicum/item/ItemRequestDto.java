package ru.practicum.item;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ItemRequestDto {
    private Long userId;
    private String url;
    private Set<String> tags;
}
