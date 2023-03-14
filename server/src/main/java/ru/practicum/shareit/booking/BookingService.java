package ru.practicum.shareit.booking;

import ru.practicum.shareit.booking.dto.BookingRequestDto;
import ru.practicum.shareit.booking.dto.BookingResponseDto;

import java.util.List;

public interface BookingService {
    BookingResponseDto create(Long userId, BookingRequestDto bookingRequestDto);

    BookingResponseDto approve(Long userId, Long bookingId, Boolean approved);

    BookingResponseDto getByBookerOrOwner(Long userId, Long bookingId);

    List<BookingResponseDto> findAllByBookerIdAndState(Long userId, String state, Integer from, Integer size);

    List<BookingResponseDto> findAllByOwnerIdAndState(Long userId, String state, Integer from, Integer size);
}

