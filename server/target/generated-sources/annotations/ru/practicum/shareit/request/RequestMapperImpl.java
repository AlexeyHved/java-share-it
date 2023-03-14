package ru.practicum.shareit.request;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.item.ItemMapper;
import ru.practicum.shareit.item.dto.ItemResponseDto;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.request.dto.RequestDto;
import ru.practicum.shareit.request.dto.ResponseDto;
import ru.practicum.shareit.request.model.ItemRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T12:13:28+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class RequestMapperImpl implements RequestMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ItemRequest mapToItemRequest(RequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        ItemRequest itemRequest = new ItemRequest();

        itemRequest.setDescription( requestDto.getDescription() );

        return itemRequest;
    }

    @Override
    public ResponseDto mapToResponseDto(ItemRequest itemRequest) {
        if ( itemRequest == null ) {
            return null;
        }

        long id = 0L;
        String description = null;
        LocalDateTime created = null;
        List<ItemResponseDto> items = null;

        id = itemRequest.getId();
        description = itemRequest.getDescription();
        created = itemRequest.getCreated();
        items = itemListToItemResponseDtoList( itemRequest.getItems() );

        ResponseDto responseDto = new ResponseDto( id, description, created, items );

        return responseDto;
    }

    protected List<ItemResponseDto> itemListToItemResponseDtoList(List<Item> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemResponseDto> list1 = new ArrayList<ItemResponseDto>( list.size() );
        for ( Item item : list ) {
            list1.add( itemMapper.mapToItemResponseDto( item ) );
        }

        return list1;
    }
}
