package ru.practicum.shareit.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;


@Data
@AllArgsConstructor
@Builder
public class ItemRequestDto {

    private long id;

    private String name;

    private String description;

    private Boolean available;
    @Nullable
    private Long requestId;
}
